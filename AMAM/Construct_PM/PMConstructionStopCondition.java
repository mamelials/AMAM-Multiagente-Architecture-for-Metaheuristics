package Construct_PM;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_PM.PMProblem;
import Function_Package.StopCondition;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the StopCondition class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMConstructionStopCondition implements StopCondition{

	@Override
	public boolean stopCondition(Element e, Problem p, Solution s) {
		// TODO Auto-generated method stub
		
		PMConstructElement e_pm = null;
		if(e instanceof PMConstructElement){
			e_pm = (PMConstructElement) e;
		}
		
		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		if(e_pm.getCount() < pm.getNumberOfTasks()) {
			return false;   /* not reached the stop condition */
		}
		else {
			e_pm.setCount(0);
			return true;   /* hit the stop condition */
		}
	}

}
