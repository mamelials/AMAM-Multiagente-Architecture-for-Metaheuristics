package Construct_PM;

import Construction.InitializeCandidatesPartialSolution;
import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_PM.PMProblem;
import Environment_PM.PMSolution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the InitializeCandidatesPartialSolution class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMInitializeCandidatesPartialSolution implements InitializeCandidatesPartialSolution {

	@Override
	public void initializeCandidates(Solution partial_solution, Element e, Problem p) {
		// TODO Auto-generated method stub
		
		PMConstructElement e_pm = null;
		if(e instanceof PMConstructElement){
			e_pm = (PMConstructElement) e;
		}
		
		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		PMSolution pm_sol = null;
		if(partial_solution instanceof PMSolution) {
			pm_sol = (PMSolution) partial_solution;
		}
		
		for(int i = 0; i < pm.getNumberOfTasks(); i++) {
			e_pm.setCandidateI(0, i);
		}
		
		int k = 0;
		for(int i = 0; i < pm_sol.getMachineNumber(); i++) {
			for(int j = 0; j < pm_sol.getMachineI(i).getTasksNumber(); j++) {
				e_pm.setCandidateI(-1, pm_sol.getTaskInMachines(i, j));
				k++;
			}
		}
		e_pm.setCount(k);
		
		for(int i = 0; i < pm.getNumberOfTasks(); i++) {
			if(e_pm.getCandidateI(i) != -1)
				e_pm.setCandidateI(i, i);
		}
		
	}

}
