package Factorys;

import Construct_VRP.VRPConstructElement;
import Environment.Element;
import Environment.Problem;
import ILS_VRP.VRPILSElement;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class responsible for creating (instantiating) an element of a specific problem from input parameters  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/


public class ElementFactory {

	public Element createElement(Problem p, Parameters parameters, int i) {
		
		Element e = null;
		
		switch (p.getProblemDescription()){
			case "vrp":
				switch (parameters.getMethodParametersI(i).getMthType()) {
					case "construct":
						e = new VRPConstructElement(p);
						break;
					case "ils":
						e = new VRPILSElement();
						VRPILSElement vrp_ils_e = null;
						if(e instanceof VRPILSElement) {
							vrp_ils_e = (VRPILSElement) e;
						}
						//inicialização
						vrp_ils_e.setIterationsNumber(0);
						vrp_ils_e.setLevelPerturb(1);
						//parâmetros
						vrp_ils_e.setMaxIterations(parameters.getMethodParametersI(i).getMaxIterations());   
						vrp_ils_e.setMaxLevelPerturb(parameters.getMethodParametersI(i).getMaxLevelsPerturbation());
						vrp_ils_e.setMaxTime(parameters.getMethodParametersI(i).getMaxTime());
						vrp_ils_e.setBestNumberRoutes(parameters.getExperimentParameters().getBestAux());
						vrp_ils_e.setBestOf(parameters.getExperimentParameters().getBestOF());
					default:
						break;
				}
				break;
				
			case "pmp":
				break;

			case "mkp": 
				break;
				
			default:
				System.out.println("Tipo de solução não disponível!");
		}
		
		return e;
	}
	
}
