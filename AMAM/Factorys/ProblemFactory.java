package Factorys;

import Environment.Problem;
import Environment_PM.PMProblem;
import Environment_VRP.VRPProblem;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: class responsible for the creation (instantiation) of problem 
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class ProblemFactory {

	public Problem createProblem(Parameters parameters) throws Exception {
		
		Problem p = null;
		
		switch (parameters.getExperimentParameters().getProblemDescription()){
			case "vrp":
				p = new VRPProblem(parameters.getExperimentParameters().getInstanceName(), 
						parameters.getExperimentParameters().getProblemDescription(), 
						parameters.getExperimentParameters().getProblemType(), parameters.getExperimentParameters().getProblemDimension());
				break;
				
			case "pmp":
				p = new PMProblem(parameters.getExperimentParameters().getInstanceName(), 
						parameters.getExperimentParameters().getProblemDescription(), 
						parameters.getExperimentParameters().getProblemType(), parameters.getExperimentParameters().getProblemDimension());
				break;
				
			default:
				System.out.println("Tipo de problema não disponível!");
		}
		
		return p;
	}
	
}
