package Environment_PRV_Movements;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that extends the Movement class.
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_Movements.Movement;
import Environment_VRP.VRPProblem;
import Environment_VRP.VRPSolution;

public class MovementVRPEliminatesSmallRoute extends Movement{

	public MovementVRPEliminatesSmallRoute(String move_type) {
		super(move_type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Solution movement(Solution s, int receiver_size, Element element, Problem p) {
		// TODO Auto-generated method stub
		
		VRPSolution vrp_sol = null;
		if(s instanceof VRPSolution) {
			vrp_sol = (VRPSolution) s;
		}
		
		VRPSolution sol = new VRPSolution(receiver_size, p);
		sol.copyValuesSolution(vrp_sol, p);
		
		VRPMovementElement vrp_element = null;
		if(element instanceof VRPMovementElement) {
			vrp_element = (VRPMovementElement) element;
		}
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		vrp_element.setValid(sol.eliminatesSmallRoute(vrp, receiver_size));

		element = vrp_element;
		return sol;
		
	}

}
