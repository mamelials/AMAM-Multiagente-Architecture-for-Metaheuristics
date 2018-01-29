package Local_Search;

import java.util.Random;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Function_Package.AcceptationCriteria;
import Methods.Method;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that defines the structure of a basic Adaptive Local Search. Defined at run time by 
 * Design Pattern Builder.
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

//Local Search and VND - em função de neighborhood_size
public class AdaptiveLocalSearch_QLearning_AfterTraining extends Method{

	private AcceptationCriteria criteria;
	private MoveNeighborhood movement_neighborhood;
	private BestNeighbor best_neighbor;

	private Element element; //MovementElement
	
	private Solution s_line;
	private Solution best_solution;
	private Solution worst_solution;
	
	private int neighborhood_size;
	
	private String function_type;
	
	//private QLearning q_learning;
	
	@Override
	public Solution runMethod(Problem p, Solution so, int id_agent) {
		// TODO Auto-generated method stub		
		//Random generator = new Random();
		boolean improved = true, better = true; 
		//int no_improvement = 0;
		int count_k = 0, k, k_previous = 0, previous = 0;
		
		Random generator = new Random();
						
		this.s_line.copyValuesSolution(so, p);
		this.best_solution.copyValuesSolution(so, p);
		this.worst_solution.copyValuesSolution(so, p);
		
		this.getParameters().getMethodParametersI(id_agent-1).getQLearning().initializeQSpecificTest();
		
		//first neighborhood -- random
		k = generator.nextInt(this.getParameters().getMethodParametersI(id_agent-1).getQLearning().getQSize());
		
		while (improved) {
			
			//System.out.println("\n\nNeighbor: " + k);
			
			//Best Neighbor
			this.s_line.copyValuesSolution(this.best_neighbor.bestNeighbor(k, movement_neighborhood, 
					this.criteria, this.s_line, this.getParameters(), this.element, p), p);
			 
			if(criteria.acceptationCriteria(this.s_line, this.best_solution, element, p)) {
				this.best_solution.copyValuesSolution(this.s_line, p);
				improved = true;
				count_k = 0;
				better = true;
				
				//System.out.println("\nMelhorou a solução!");
				//this.best_solution.showOFAndFitness(p);;
				
				//next neighborhood
				k = this.getParameters().getMethodParametersI(id_agent-1).getQLearning().sequenceQMatrix(k, 0, better);
			}
			else {
				//System.out.println("\nNão melhorou a solução!");
				
				if(count_k == 0) {
					//next neighborhood
					k_previous = k;
					k = this.getParameters().getMethodParametersI(id_agent-1).getQLearning().sequenceQMatrix(k, 0, better);
					count_k++;
				}
				else {
					previous = k;
					k = k_previous;
					better = false;
					count_k++;
					k = this.getParameters().getMethodParametersI(id_agent-1).getQLearning().sequenceQMatrix(k, previous, better);
				}
				
				if(k == -1) {
					if(count_k >= this.getParameters().getMethodParametersI(id_agent-1).getQLearning().getQSize()) {
						improved = false;
					}
					else {
						System.out.println("Achar o que entra aqui, kkkkkk");
					}
				}
			}
		}
			
		return this.best_solution;
	}
	
	public AcceptationCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(AcceptationCriteria criteria) {
		this.criteria = criteria;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Solution getS_line() {
		return s_line;
	}

	public void setS_line(Solution s_line) {
		this.s_line = s_line;
	}

	public Solution getBestSolution() {
		return best_solution;
	}

	public void setBestSolution(Solution best_solution) {
		this.best_solution = best_solution;
	}

	public Solution getS() {
		return worst_solution;
	}

	public void setS(Solution s) {
		this.worst_solution = s;
	}

	public int getNeighborhoodSize() {
		return neighborhood_size;
	}

	public void setNeighborhoodSize(int neighborhood_size) {
		this.neighborhood_size = neighborhood_size;
	}

	public String getFunctionType() {
		return function_type;
	}
	
	/*public QLearning qetQLearning() {
		return this.q_learning;
	}*/

	public void setFunctionType(String function_type) {
		this.function_type = function_type;
	}

	public MoveNeighborhood getMovementNeighborhood() {
		return movement_neighborhood;
	}

	public void setMovementNeighborhood(MoveNeighborhood movement) {
		this.movement_neighborhood = movement;
	}

	public BestNeighbor getBestNeighbor() {
		return best_neighbor;
	}

	public void setBestNeighbor(BestNeighbor best_neighbor) {
		this.best_neighbor = best_neighbor;
	}
	
	/*public void setQLearning(QLearning q_learning) {
		this.q_learning = q_learning;
	}*/
	
}
