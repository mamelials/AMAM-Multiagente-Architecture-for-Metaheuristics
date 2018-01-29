package ILS_PM;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Function_Package.StopCondition;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the StopCondition Class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMILSStopConditionIterations implements StopCondition{

	@Override
	public boolean stopCondition(Element e, Problem p, Solution s) {
		// TODO Auto-generated method stub
		
		PMILSElement e_pm = null;
		if(e instanceof PMILSElement) {
			e_pm = (PMILSElement) e;
		}
		
		e_pm.addIterationsNumber();
		
		if(e_pm.getIterationsNumber() <= e_pm.getMaxIterations()) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
