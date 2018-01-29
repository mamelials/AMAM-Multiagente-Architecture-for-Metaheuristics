package Local_Search;

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
public class AdaptiveLocalSearch_QLearning_NewVersion extends Method{

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
		boolean improved = true, episode = true; //prior = false;
		int no_improvement = 0;
		int next_state, state = 0;
		double reward; // epsilon;
		
		int states[] = new int[this.getParameters().getMethodParametersI(id_agent-1).getQLearning().getQSize()];
		int states_count;
				
		this.s_line.copyValuesSolution(so, p);
		this.best_solution.copyValuesSolution(so, p);
		this.worst_solution.copyValuesSolution(so, p);

		//epsilon = this.getParameters().getQLearning().getEpsilon();
		
		while (improved) {
			
			reward = 0; //every episode restarts reward
			
			//Episode  --  the improvement of the solution is goal in each episode
			//System.out.println("\nNew Episode!"); 
			
			states_count = 0;
			for(int i = 0; i < this.getParameters().getMethodParametersI(id_agent-1).getQLearning().getQSize(); i++) {
				states[i] = i;
			}
			
			//random initial state
			next_state = this.getParameters().getMethodParametersI(id_agent-1).getQLearning().chooseAnAction(0, 2); //2 --> random function
			//System.out.println("\nState: " + next_state);
			
			//Best Neighbor
			this.s_line.copyValuesSolution(this.best_neighbor.bestNeighbor(next_state, movement_neighborhood, 
				this.criteria, this.s_line, this.getParameters(), this.element, p), p);
			
			if(criteria.acceptationCriteria(this.s_line, this.best_solution,element, p)) {
				this.best_solution.copyValuesSolution(this.s_line, p);
				//System.out.println("Melhorou a solução!");
				//this.s_line.showOFAndFitness(p);
				
				//Reinforcement Learning
				if(p.getProblemType(0).equals("min")) { //testando para 1 dimensão
					this.s_line.minMaxFitnessWorstSolution(this.worst_solution, p);;
					reward = this.s_line.getFitnessLearning();
				}
				else {
					reward = this.s_line.getFitnessFunction();
				}
			}
			else {
				states_count++;
				states[next_state] = -1;
				//System.out.println("Não melhorou a solução!");
				//this.element.getBestCurrentSolution().showOFAndFitness(p);
			}
			
			while (episode) {
				
				state = next_state;
				next_state = this.getParameters().getMethodParametersI(id_agent-1).getQLearning().chooseAnAction(state, 1);  // 1 --> epsilon greedy function
				
				//System.out.println("\nState: " + next_state);
				//System.out.println("\nEpsilon: " + this.getParameters().getQLearning().getEpsilon());	
				
				//Best Neighbor
				this.s_line.copyValuesSolution(this.best_neighbor.bestNeighbor(next_state, movement_neighborhood,
				this.criteria, this.s_line, this.getParameters(), this.element, p), p);
					
				if(criteria.acceptationCriteria(this.s_line, this.best_solution, this.element, p)) {
					this.best_solution.copyValuesSolution(this.s_line, p);
					improved = true;
					episode = false; //ends the episode
					no_improvement = 0;
					
					//Reinforcement Learning
					if(p.getProblemType(0).equals("min")) { //testando para 1 dimensão
						this.s_line.minMaxFitnessWorstSolution(this.worst_solution, p);;
						reward = reward + this.s_line.getFitnessLearning();
						//System.out.println("\n\nReward: " + reward);
						this.getParameters().getMethodParametersI(id_agent-1).getQLearning().calculateQValue(state, next_state, reward); //updates the matrix q
							
					}
					else {
						reward = reward + this.s_line.getFitnessFunction();
						//System.out.println("\n\nReward: " + reward);
						this.getParameters().getMethodParametersI(id_agent-1).getQLearning().calculateQValue(state, next_state, reward); //updates the matrix q
					}
							
					//System.out.println("Melhorou a solução!");
					//this.s_line.showOFAndFitness(p);
						
				}
				else {
					no_improvement++;  //no improvement iterations
					//this.getParameters().getQLearning().setEpsilon(this.getParameters().getQLearning().getEpsilon() + 0.05); //increases epsilon
						
					if(states[next_state] != -1) {
						states[next_state] = -1;
						states_count++;
					}
						
					if((no_improvement > 10) || (states_count == this.getParameters().getMethodParametersI(id_agent-1).getQLearning().getQSize())) {
						improved = false;
						episode = false;
					}
					//System.out.println("Não melhorou a solução!");
					//this.element.getBestCurrentSolution().showOFAndFitness(p);
				}
				
				//q_learning.calculateQValue(state, next_state, reward); //updates the matrix q
					
			}
			episode = true;
			//Decay epsilon
			//this.getParameters().getQLearning().setEpsilon(this.getParameters().getQLearning().getEpsilon()*0.99);
			this.getParameters().getMethodParametersI(id_agent-1).getQLearning().setEpsilon(this.getParameters().getMethodParametersI(id_agent-1).getQLearning().getEpsilon()*0.999);
			if(this.getParameters().getMethodParametersI(id_agent-1).getQLearning().getEpsilon() < 0.1)
				this.getParameters().getMethodParametersI(id_agent-1).getQLearning().setEpsilon(0.1);
			//this.getParameters().getQLearning().showQMatrix();
			//this.getParameters().getQLearning().setEpsilon(epsilon);
		}
		
		//this.getParameters().getQLearning().showQMatrix();
		
		/*try {
			this.getParameters().getQLearning().writeQMatrix(this.getParameters().getFw());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
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
