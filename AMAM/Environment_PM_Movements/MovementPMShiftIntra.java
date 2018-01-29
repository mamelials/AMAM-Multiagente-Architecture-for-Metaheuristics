package Environment_PM_Movements;

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
import Environment_PM.PMProblem;
import Environment_PM.PMSolution;

public class MovementPMShiftIntra extends Movement{

	public MovementPMShiftIntra(String move_type) {
		super(move_type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Solution movement(Solution s, int receiver_size, Element element, Problem p) {
		// TODO Auto-generated method stub
		
		PMSolution pm_sol = null;
		if(s instanceof PMSolution) {
			pm_sol = (PMSolution) s;
		}
		
		PMSolution sol = new PMSolution(receiver_size, p);
		sol.copyValuesSolution(pm_sol, p);
		
		PMMovementElement pm_element = null;
		if(element instanceof PMMovementElement) {
			pm_element = (PMMovementElement) element;
		}
		
		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		pm_element.setValid(sol.shiftPMIntra(pm_element.getPositionTask1(), pm_element.getMachine1(), pm_element.getPositionTask2(), pm));
		
		return sol;
	}

}
