package Local_Search;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Function_Package.AcceptationCriteria;
import Methods.Method;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that defines the structure of a basic Local Search. Defined at run time by 
 * Design Pattern Builder.
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

//Local Search and VND - em função de neighborhood_size
public class LocalSearch extends Method{

	private AcceptationCriteria criteria;
	private MoveNeighborhood movement_neighborhood;
	private BestNeighbor best_neighbor;

	private Element element; //MovementElement
	
	private Solution s_line;
	private Solution best_solution;
	private Solution s;
	
	private int neighborhood_size;
	
	private String function_type;
	
	@Override
	public Solution runMethod(Problem p, Solution so, int id_agent) {
		// TODO Auto-generated method stub
		boolean improved = true;
		
		this.s.copyValuesSolution(so, p);
		this.best_solution.copyValuesSolution(so, p);
		
		int k = 0; //na ordem das vizinhanças
		int no_improvement = 0;
		
		while ((k < this.neighborhood_size) && (improved)) {
		
			//System.out.println("\n\nNeighbor: " + k);
			
			//Best Neighbor
			this.s.copyValuesSolution(this.best_neighbor.bestNeighbor(k, movement_neighborhood, 
					this.criteria, this.s, this.getParameters(), this.element, p), p);
			 
			if(criteria.acceptationCriteria(this.s, this.best_solution, element, p)) {
				this.best_solution.copyValuesSolution(this.s, p);
				improved = true;
				no_improvement = 0;
				k = 0;
				
				//System.out.println("\nMelhorou a solução!");
				//this.best_solution.showOFAndFitness(p);;
			}
			else {
				no_improvement++;
				if(no_improvement > 10) {
					improved = false;
				}
				if(this.neighborhood_size > 1) {
					k = k + 1;
				}
				else {
					improved = false;
				}
				//System.out.println("\nNão melhorou a solução!");
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
		return s;
	}

	public void setS(Solution s) {
		this.s = s;
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
	
}
