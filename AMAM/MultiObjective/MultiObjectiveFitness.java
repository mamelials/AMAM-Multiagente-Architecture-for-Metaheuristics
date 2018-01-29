package MultiObjective;

import Environment.Problem;
import Environment.Solution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Abstract class that defines the Multi-Objective Fitness model for optimization problems.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public abstract class MultiObjectiveFitness {
	
	public abstract double calculateFitness(Problem p, Solution s);

}
