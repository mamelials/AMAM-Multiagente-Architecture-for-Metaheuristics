package Factorys;

import Environment.Problem;
import Environment.Solution;
import Environment_PM.PMSolution;
import Environment_VRP.VRPSolution;
import Genetic_Algorithm.Population;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: class responsible for the creation (instantiation) of Populations. 
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PopulationFactory {

	public Population createPopulation(int pop_size, int receiver_size, Problem p) {

		Population pop = new Population(pop_size);
		
		switch (p.getProblemDescription()){
			case "vrp":
				for(int i = 0; i < pop_size; i++) {
					Solution s = new VRPSolution(receiver_size, p);
					pop.newSolutioni(i, s, p);
				}
				break;
				
			case "pmp":
				for(int i = 0; i < pop_size; i++) {
					Solution s = new PMSolution(receiver_size, p);
					pop.newSolutioni(i, s, p);
				}
				break;
				
			default:
				System.out.println("Tipo de solução não disponível!");
		}
		
		return pop;
	}
	
}
