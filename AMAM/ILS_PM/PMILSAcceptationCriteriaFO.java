package ILS_PM;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_PM.PMSolution;
import Function_Package.AcceptationCriteria;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the AcceptationCriteria  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMILSAcceptationCriteriaFO implements AcceptationCriteria{

	@Override
	public boolean acceptationCriteria(Solution s1, Solution s2, Element e, Problem p) {
		// TODO Auto-generated method stub
		
		PMSolution pm_sol1 = null;
		if(s1 instanceof PMSolution) {
			pm_sol1 = (PMSolution) s1;
		}
		PMSolution pm_sol2 = null;
		if(s2 instanceof PMSolution) {
			pm_sol2 = (PMSolution) s2;
		}
		
		PMILSElement e_pm = null;
		if(e instanceof PMILSElement) {
			e_pm = (PMILSElement) e;
		}
		
		if(pm_sol1.getObjectiveFunctionI(0) < pm_sol2.getObjectiveFunctionI(0)) {
			e_pm.setLevelPerturb(1);
			return true;
		}
		else {
			e_pm.addLevelPerturb();
			if(e_pm.getLevelPerturb() > e_pm.getMaxLevelPerturb()) 
				e_pm.setLevelPerturb(1);
			return false;
		}
	}
	
}
