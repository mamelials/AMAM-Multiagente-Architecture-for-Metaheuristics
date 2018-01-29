package Construct_PM;

import Construction.InitializeCandidates;
import Environment.Element;
import Environment.Problem;
import Environment_PM.PMProblem;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the InitializeCandidates class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMInitializeCandidates implements InitializeCandidates {

	@Override
	public void initializeCandidates(Element e, Problem p) {
		// TODO Auto-generated method stub
		
		PMConstructElement e_pm = null;
		if(e instanceof PMConstructElement){
			e_pm = (PMConstructElement) e;
		}
		
		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		for(int i = 0; i < pm.getNumberOfTasks(); i++) {
			e_pm.setCandidateI(i, i);
		}
		
	}

}
