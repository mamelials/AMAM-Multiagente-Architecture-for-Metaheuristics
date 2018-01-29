package Construct_VRP;

import Construction.InitializeSolution;
import Environment.Problem;
import Environment.Solution;
import Environment_VRP.VRPProblem;
import Environment_VRP.VRPSolution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the InitializeSolution class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPInitializeSolution implements InitializeSolution{

	@Override
	public Solution initializeSolution(Problem p, int receiver_size) {
		// TODO Auto-generated method stub
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		VRPSolution initial_solution = new VRPSolution(receiver_size, vrp);
		
		return initial_solution;
	
	}
	
}
