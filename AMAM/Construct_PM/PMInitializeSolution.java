package Construct_PM;

import Construction.InitializeSolution;
import Environment.Problem;
import Environment.Solution;
import Environment_PM.PMSolution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the InitializeSolution class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMInitializeSolution implements InitializeSolution{

	@Override
	public Solution initializeSolution(Problem p, int receiver_size) {
		// TODO Auto-generated method stub
		
		PMSolution initial_solution = new PMSolution(receiver_size, p);
		
		return initial_solution;
	}

}
