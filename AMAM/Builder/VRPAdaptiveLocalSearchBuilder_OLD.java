package Builder;

import Cooperation.Cooperation;
import Environment.Problem;
import Environment.Solution;
import Environment_PRV_Movements.VRPMovementElement;
import Environment_VRP.VRPSolution;
import Local_Search.LocalSearch_AdaptiveBRACIS2015;
import Local_Search.MoveNeighborhood;
import Local_Search_VRP.VRPBestNeighborCompleteDescent;
import Local_Search_VRP.VRPLocalSearchAcceptationCriteriaOF;
import Methods.Method;
import Parameters.Parameters;
import Reinforcement_Learning.ReinforcementLearning_Old;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Builder class for Adaptive Local Search Method for VRP. Implements Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPAdaptiveLocalSearchBuilder_OLD extends MethodBuilder{

	@Override
	public Method building(int id_method, Parameters parameters, Cooperation cooperation, Problem p) {
		// TODO Auto-generated method stub
		
		//AdaptiveLocalSearch_QLearning ls = new AdaptiveLocalSearch_QLearning();
		LocalSearch_AdaptiveBRACIS2015 ls = new LocalSearch_AdaptiveBRACIS2015();

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
		
		ReinforcementLearning_Old rl_ls = new ReinforcementLearning_Old(parameters.getMethodParametersI(id_method).getNeighborhoodSize());
		ls.setReinforcementLearning(rl_ls);
		
		//QLearning q_learning = new QLearning(parameters.getNeighborhoodSize(), 0.9, 0.1, 0.05); //valores a serem definidos
		//ls.setQLearning(q_learning);
		
		switch (this.getFunctionType()) {
			case "adaptive_vnd_complete":	
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
			case "adaptive_vnd_old":	
				pm_criteria = new VRPLocalSearchAcceptationCriteriaOF();
				ls.setCriteria(pm_criteria);
						
				best_neighbor = new VRPBestNeighborCompleteDescent();
				ls.setBestNeighbor(best_neighbor);
						
				move_neighborhood = new MoveNeighborhood(parameters.getMethodParametersI(id_method).getNeighborhoodSize());
				for (int i = 0; i < parameters.getMethodParametersI(id_method).getNeighborhoodSize(); i++) {
					move_neighborhood.getList().addMovementI(parameters.getMethodParametersI(id_method).getMovementList().getMoveI(i));
				}
				ls.setMovementNeighborhood(move_neighborhood);
						
				vrp_element = new VRPMovementElement();
				ls.setElement(vrp_element);
				break;
			default:
				System.out.println("\nTipo de Busca Local não disponível!");
				break;
		}
				
		//Outros tipos de busca local ...
		/*if(function_type = "first_improvement") {
					
		}*/
				
		return ls;
	}
	
}
