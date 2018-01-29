package Construct_VRP;

import Construction.InitializeCandidates;
import Environment.Element;
import Environment.Problem;
import Environment_VRP.VRPProblem;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the InitializeCandidates class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPInitializeCandidates implements InitializeCandidates {

	@Override
	public void initializeCandidates(Element e, Problem p) {
		// TODO Auto-generated method stub
		
		VRPConstructElement e_vrp = null;
		if(e instanceof VRPConstructElement){
			e_vrp = (VRPConstructElement) e;
		}
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem){
			vrp = (VRPProblem) p;
		}
		
		/*for(int i = 0; i < vrp.getNumberOfClients(); i++) {
			e_vrp.setCandidateI(vrp.getClientCollection(i).getIdNumber(), i);
		}*/
		
		e_vrp.calculateCostInsertion(vrp);
		e_vrp.orderClients(vrp);
		
	}
	
}
