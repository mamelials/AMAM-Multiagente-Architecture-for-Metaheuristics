package Construct_VRP;

import Construction.AddElement;
import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_VRP.VRPProblem;
import Environment_VRP.VRPSolution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the AddElement class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPAddElement implements AddElement{

	@Override
	public void addElementInSolution(Solution s, Element e, Problem p) {
		// TODO Auto-generated method stub
		
		VRPSolution sol = null;
		if(s instanceof VRPSolution) {
			sol = (VRPSolution) s;
		}
		
		VRPConstructElement vrp_e = null;
		if(e instanceof VRPConstructElement) {
			vrp_e = (VRPConstructElement) e;
		}
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		sol.insertionClientInSolution(vrp_e.getNextCandidate(), vrp_e.getRouteIns(), vrp_e.getPosIns(), vrp);
		
		//System.out.println("Inseriu o elemento " + vrp_e.getCount());
		
		vrp_e.addCount();
		
		e = vrp_e;
	}
	
}
