package Construct_PM;

import Construction.UpdateCandidates;
import Environment.Element;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the UpdateCandidates class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMUpdateCandidates implements UpdateCandidates {

	@Override
	public void updateCandidates(Element e) {
		// TODO Auto-generated method stub
		
		PMConstructElement e_pm = null;
		if(e instanceof PMConstructElement){
			e_pm = (PMConstructElement) e;
		}
		
		e_pm.setCandidateI(-1, e_pm.getNextCandidate());
	}

}
