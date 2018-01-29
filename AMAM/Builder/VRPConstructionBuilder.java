package Builder;

import Construct_VRP.VRPAddElement;
import Construct_VRP.VRPConstructionStopCondition;
import Construct_VRP.VRPConstructElement;
import Construct_VRP.VRPInitializeCandidates;
import Construct_VRP.VRPInitializeSolution;
import Construct_VRP.VRPNextCandidate;
import Construct_VRP.VRPUpdateCandidates;
import Construction.Construction;
import Cooperation.Cooperation;
import Environment.Problem;
import Methods.Method;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Builder class for Constructive Heuristic for VRP. Implements Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPConstructionBuilder extends MethodBuilder{

	@Override
	public Method building(int id_method, Parameters parameters, Cooperation cooperation, Problem p) {
		// TODO Auto-generated method stub
	
		Construction construction = new Construction();
		
		VRPInitializeSolution init_solution = new VRPInitializeSolution(); 
		construction.setInitSolution(init_solution);
		
		VRPInitializeCandidates init_candidates = new VRPInitializeCandidates();
		construction.setInitCandidates(init_candidates);
		
		VRPConstructionStopCondition condition = new VRPConstructionStopCondition();
		construction.setCondition(condition);
		
		VRPAddElement add = new VRPAddElement();
		construction.setAdd(add);
		
		VRPNextCandidate next = new VRPNextCandidate(parameters.getMethodParametersI(id_method).getRclSize());
		construction.setNext(next);
		
		VRPUpdateCandidates update_candidates = new VRPUpdateCandidates();
		construction.setUpdateCandidates(update_candidates);
		
		VRPConstructElement vrp_element = new VRPConstructElement(p);
		construction.setElement(vrp_element);
		
		construction.setFunctionType(this.getFunctionType());

		construction.setParameters(parameters);
		
		construction.setCooperation(cooperation);
		
		return construction;
	}
}
