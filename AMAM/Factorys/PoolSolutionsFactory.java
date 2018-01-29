package Factorys;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: class responsible for the creation (instantiation) of pool solutions
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import Cooperation.PMPoolSolutions;
import Cooperation.PoolSolutions;
import Cooperation.VRPPoolSolutions;
import Environment.Problem;

public class PoolSolutionsFactory {

	public PoolSolutions createPool(String type, int size_max_pool, double radius_niche, int receiver_size, Problem p) throws Exception {
		
		PoolSolutions pool = null;
		
		switch (type){
			case "vrp":
				pool = new VRPPoolSolutions(size_max_pool, radius_niche, p, receiver_size);
				break;
				
			case "pmp":
				pool = new PMPoolSolutions(size_max_pool, radius_niche, p, receiver_size);
				break;
				
			default:
				System.out.println("Tipo de problema não disponível!");
		}
		
		return pool;
	}
	
}
