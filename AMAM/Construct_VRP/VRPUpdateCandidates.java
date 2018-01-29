package Construct_VRP;

import Construction.UpdateCandidates;
import Environment.Element;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the UpdateCandidates class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPUpdateCandidates implements UpdateCandidates {

	@Override
	public void updateCandidates(Element e) {
		// TODO Auto-generated method stub
		
		VRPConstructElement e_vrp = null;
		if(e instanceof VRPConstructElement){
			e_vrp = (VRPConstructElement) e;
		}
		
		e_vrp.setCandidateI(-1, e_vrp.getPosCandidate());
		
	}

}
