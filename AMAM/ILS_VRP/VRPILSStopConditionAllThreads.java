package ILS_VRP;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_VRP.VRPSolution;
import Function_Package.StopConditionAllThreads;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the StopConditionAllThreads Class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPILSStopConditionAllThreads implements StopConditionAllThreads{

	@Override
	public boolean stopConditionAllThreads(Element e, Problem p, Solution s) {
		// TODO Auto-generated method stub
		
		VRPILSElement e_vrp = null; 
		if(e instanceof VRPILSElement) {
			e_vrp = (VRPILSElement) e;
		}
		
		VRPSolution sol = null;
		if(s instanceof VRPSolution) {
			sol = (VRPSolution) s;
		}
		
		if((sol.getNumberRoutes() > e_vrp.getBestNumberRoutes()) || (sol.getCostWithoutPenalty() > e_vrp.getBestOf())) {
			return false;
		}
		else {
			System.out.println("\n\nFINAL ITERATIONS: " + e_vrp.getIterationsNumber() + "\n");
			return true;
		}
		
	}

}
