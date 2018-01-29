package Factorys;

import Environment.Problem;
import Environment.Solution;
import Environment_PM.PMSolution;
import Environment_VRP.VRPSolution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: class responsible for the creation (instantiation) of solution
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class SolutionFactory {

	public Solution createSolution(int receiver_size, Problem p) {
		
		Solution s = null;
		
		switch (p.getProblemDescription()){
			case "vrp":
				s = new VRPSolution(receiver_size, p);
				break;
				
			case "pmp":
				s = new PMSolution(receiver_size, p);
				break;
				
			default:
				System.out.println("Tipo de solução não disponível!");
		}
		
		return s;
	}
	
}
