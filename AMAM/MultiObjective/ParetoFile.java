package MultiObjective;

import Environment.Problem;
import Environment.Solution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Multi-objective problem element.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class ParetoFile {

	private Solution pareto_optimal[];
	private int pareto_size;

	/*public void identifyBoundary(Population pop, int dimension) {
		
		int count;
		double a[] = new double[dimension];
		
		for(int i = 0; i < pop.getPopulationSize(); i++) {
			count = 1; //1 if the point is not dominated
			
			
		}
		
	}*/
	
	public Solution getSolutionIPareto(int i) {
		return this.pareto_optimal[i];
	}

	public void setPareto(int i, Solution s, Problem p) {
		this.pareto_optimal[i].copyValuesSolution(s, p);
	}

	public int getParetoSize() {
		return pareto_size;
	}

	public void setParetoSize(int pareto_size) {
		this.pareto_size = pareto_size;
	}
	
}
