package Construct_VRP;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_VRP.VRPProblem;
import Function_Package.StopCondition;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the StopCondition class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPConstructionStopCondition implements StopCondition {

	@Override
	public boolean stopCondition(Element e, Problem p, Solution s) {
		// TODO Auto-generated method stub
		
		VRPConstructElement e_vrp = null;
		if(e instanceof VRPConstructElement){
			e_vrp = (VRPConstructElement) e;
		}
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		if(e_vrp.getCount() < vrp.getNumberOfClients()-1){
			return false;
		}
		else {
			e_vrp.setCount(0);
			return true; //reaching stop condition
		}
	}

}
