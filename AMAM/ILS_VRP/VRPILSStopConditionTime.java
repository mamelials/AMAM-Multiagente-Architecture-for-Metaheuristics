package ILS_VRP;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_VRP.VRPSolution;
import Function_Package.StopCondition;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the StopCondition Class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPILSStopConditionTime implements StopCondition{

	@Override
	public boolean stopCondition(Element e, Problem p, Solution s) {
		// TODO Auto-generated method stub

		VRPILSElement e_vrp = null; 
		if(e instanceof VRPILSElement) {
			e_vrp = (VRPILSElement) e;
		}
		
		VRPSolution sol = null;
		if(s instanceof VRPSolution) {
			sol = (VRPSolution) s;
		}
		
		e_vrp.addIterationNumber();
		
		long final_time = System.currentTimeMillis();
		long total_time = final_time - e_vrp.getInitialTime();
		
		total_time = total_time/1000;
		if((total_time) < e_vrp.getMaxTime()) { //MaxTime in seconds
		//if(e_vrp.getIterationsNumber() <= e_vrp.getMaxIterations()){ //|| (s.getCostWithoutPenalty() <= e_vrp.getBestOf())) {
			//return true;
			if((sol.getNumberRoutes() > e_vrp.getBestNumberRoutes()) || (sol.getCostWithoutPenalty() > e_vrp.getBestOf())) {
				return true;
			}
			else {
				System.out.println("\n\nFINAL ITERATIONS: " + e_vrp.getIterationsNumber() + "\n");
				return false;
			}
		}
		else {
			System.out.println("\n\nFINAL ITERATIONS: " + e_vrp.getIterationsNumber() + "\n");
			return false;
		}
		
	}

}
