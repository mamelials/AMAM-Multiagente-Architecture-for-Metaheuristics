package MultiObjective;

import Environment.Problem;
import Environment.Solution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Multi-objective problem element.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class WeightedProblemMOFitness extends MultiObjectiveFitness{

	double lambda[];
	
	//lambda[i] sum = 1
	public WeightedProblemMOFitness(double lambda[], int dimension) {
		// TODO Auto-generated constructor stub
		this.lambda = new double[dimension];
		for(int i = 0; i < dimension; i++) {
			this.lambda[i] = lambda[i];
		}
	}
	
	@Override
	public double calculateFitness(Problem p, Solution s) {
		// TODO Auto-generated method stub
		double fitness_function = 0;
		
		for(int i = 0; i < p.getDimension(); i ++) {
			fitness_function = fitness_function + (this.lambda[i] * s.getObjectiveFunctionI(i));
		}
		
		return fitness_function;
	}
	
	

}
