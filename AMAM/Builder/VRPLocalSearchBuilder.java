package Builder;

import Cooperation.Cooperation;
import Environment.Problem;
import Environment.Solution;
import Environment_PRV_Movements.VRPMovementElement;
import Environment_VRP.VRPSolution;
import Local_Search.LocalSearch;
import Local_Search.MoveNeighborhood;
import Local_Search_VRP.VRPBestNeighborCompleteDescent;
import Local_Search_VRP.VRPBestNeighborFirstImprovementDescent;
import Local_Search_VRP.VRPLocalSearchAcceptationCriteriaOF;
import Methods.Method;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Builder class for Local Search Method for VRP. Implements Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPLocalSearchBuilder extends MethodBuilder{

	@Override
	public Method building(int id_method, Parameters parameters, Cooperation cooperation, Problem p) {
		// TODO Auto-generated method stub
		
		LocalSearch ls = new LocalSearch();

		//inicializa as soluções da busca local
		Solution s1 = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		ls.setS(s1);
		Solution s2 = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		ls.setBestSolution(s2);
		Solution s4 = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		ls.setS_line(s4);
				
		ls.setNeighborhoodSize(parameters.getMethodParametersI(id_method).getNeighborhoodSize());
		ls.setFunctionType(this.getFunctionType());
		
		ls.setParameters(parameters);
		
		ls.setCooperation(cooperation);
			
		switch (this.getFunctionType()) {
			case "basic_vnd_complete":
					
				VRPLocalSearchAcceptationCriteriaOF pm_criteria = new VRPLocalSearchAcceptationCriteriaOF();
				ls.setCriteria(pm_criteria);
						
				VRPBestNeighborCompleteDescent best_neighbor = new VRPBestNeighborCompleteDescent();
				ls.setBestNeighbor(best_neighbor);
						
				MoveNeighborhood move_neighborhood = new MoveNeighborhood(parameters.getMethodParametersI(id_method).getNeighborhoodSize());
				for (int i = 0; i < parameters.getMethodParametersI(id_method).getNeighborhoodSize(); i++) {
					move_neighborhood.getList().addMovementI(parameters.getMethodParametersI(id_method).getMovementList().getMoveI(i));
				}
				ls.setMovementNeighborhood(move_neighborhood);
						
				VRPMovementElement vrp_element = new VRPMovementElement();
				ls.setElement(vrp_element);
				break;
			case "basic_vnd_firstimprove":
			
				VRPLocalSearchAcceptationCriteriaOF pm_criteria1 = new VRPLocalSearchAcceptationCriteriaOF();
				ls.setCriteria(pm_criteria1);
						
				VRPBestNeighborFirstImprovementDescent best_neighbor1 = new VRPBestNeighborFirstImprovementDescent();
				ls.setBestNeighbor(best_neighbor1);
						
				MoveNeighborhood move_neighborhood1 = new MoveNeighborhood(parameters.getMethodParametersI(id_method).getNeighborhoodSize());
				for (int i = 0; i < parameters.getMethodParametersI(id_method).getNeighborhoodSize(); i++) {
					move_neighborhood1.getList().addMovementI(parameters.getMethodParametersI(id_method).getMovementList().getMoveI(i));
				}
				ls.setMovementNeighborhood(move_neighborhood1);
						
				VRPMovementElement vrp_element1 = new VRPMovementElement();
				ls.setElement(vrp_element1);
				break;
			default:
				System.out.println("\nTipo de Busca Local não disponível!");
				break;
		}
		
		//Outros tipos de busca local ...
		/*if(function_type = "descent") {
					
		}*/
				
		return ls;
	}
	
}
