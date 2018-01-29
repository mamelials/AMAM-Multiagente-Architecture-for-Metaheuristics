package Construct_PM;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the AddElement class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import Construction.AddElement;
import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_PM.PMSolution;

public class PMAddElement implements AddElement{

	@Override
	public void addElementInSolution(Solution s, Element e, Problem p) {
		// TODO Auto-generated method stub
		
		PMSolution pm_sol = null;
		if(s instanceof PMSolution){
			pm_sol = (PMSolution) s;
		}
		
		PMConstructElement pm_e = null;
		if(e instanceof PMConstructElement){
			pm_e = (PMConstructElement) e;
		}
		
		pm_sol.insertTaskInSolutionInLast(pm_e.getNextCandidate(), pm_e.getMachineIns(), p);
		pm_sol.calculateObjectiveFunction(p);
		pm_e.addCount();
		
		e = pm_e;
	}
	
}
