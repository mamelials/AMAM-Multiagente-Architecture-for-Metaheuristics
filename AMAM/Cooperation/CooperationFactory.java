package Cooperation;

import Environment.Problem;
import Factorys.PoolSolutionsFactory;
import Parameters.ExperimentParameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: class responsible for the creation (instantiation) of cooperation.
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class CooperationFactory {
	
	public Cooperation createCooperation(String cooperation_type, String problem_description, 
			ExperimentParameters parameters, Problem p) throws Exception {
		Cooperation cooperation = new Cooperation();
		switch (cooperation_type){
			case "pool":
				PoolSolutionsFactory pool_factory = new PoolSolutionsFactory();
				//pr.getProblemParameters().setRadiusNiche(vrp_p.getNumberOfClients() * 0.6);
				PoolSolutions pool = pool_factory.createPool(problem_description, parameters.getMaxSizePool(), parameters.getRadiusNiche(), parameters.getReceiverSize(), p);
				cooperation.setPool(pool);
				break;
			/*case "b":
				set_parameters = new PMILSSetParameters();
				pr = set_parameters.setParameters(p);
				break;
			*/
			default:
				System.out.println("Tipo de problema não disponível!");
		}
		
		return cooperation;
	}

}
