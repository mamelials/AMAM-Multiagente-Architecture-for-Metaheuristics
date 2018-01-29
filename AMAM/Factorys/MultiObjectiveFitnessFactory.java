package Factorys;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function:  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import MultiObjective.MultiObjectiveFitness;
import MultiObjective.WeightedProblemMOFitness;

public class MultiObjectiveFitnessFactory {
	
	public MultiObjectiveFitness createFitness(String type, double lambda[], int dimension) {
		
		MultiObjectiveFitness mo_fitness = null;
		switch (type){
			case "lambda":
				mo_fitness = new WeightedProblemMOFitness(lambda, dimension);
				break;
			
			//case "e":
				
				//break;
			
			default:
				System.out.println("Tipo de função não disponível!");
		}	
		
		return mo_fitness;
	}

}
