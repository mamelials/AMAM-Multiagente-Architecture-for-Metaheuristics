package Factorys;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: class responsible for the creation (instantiation) of method builders 
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import Builder.ILSBuilder;
import Builder.MethodBuilder;
import Builder.VRPAdaptiveLocalSearchBuilder;
import Builder.VRPAdaptiveLocalSearchBuilder_OLD;
import Builder.VRPConstructionBuilder;
import Builder.VRPLocalSearchBuilder;
import Builder.VRPNewAdaptiveLocalSearchBuilder;
import ILS_VRP.VRPILSAcceptationCriteriaFO;
import ILS_VRP.VRPILSPerturbationInLevels;
import ILS_VRP.VRPILSStopConditionIterations;
import ILS_VRP.VRPILSStopConditionTime;
import Parameters.MethodParameters;

public class MethodBuilderFactory {

	public MethodBuilder createMethodBuilder(String problem_description, MethodParameters parameters) throws Exception {
		
		MethodBuilder builder = null;
		
		switch (problem_description) {
			case "vrp":
				switch (parameters.getMthType()) {
					case "ils":
						builder = new ILSBuilder();
						builder.setFunctionType(parameters.getMthType());
						
						ILSBuilder vrp_ils_builder = null;
						if(builder instanceof ILSBuilder) {
							vrp_ils_builder = (ILSBuilder) builder;
						}
						
						MethodBuilder construct_builder = new VRPConstructionBuilder();
						construct_builder.setFunctionType(parameters.getConstrType());
						vrp_ils_builder.setConstructBuilder(construct_builder);
						
						MethodBuilder ls_builder = null;
						
						switch (parameters.getLsType()) {
							case "basic_vnd_complete":
								System.out.println("VNS Classic");
								ls_builder = new VRPLocalSearchBuilder();
								break;
							case "adaptive_vnd_complete":
								ls_builder = new VRPAdaptiveLocalSearchBuilder();
								break;
							case "new_adaptive_vnd":
								ls_builder = new VRPNewAdaptiveLocalSearchBuilder();
								break;
							case "adaptive_vnd_old":
								ls_builder = new VRPAdaptiveLocalSearchBuilder_OLD();
								break;
							default:
								System.out.println("\nTipo de Busca Local não disponível!");
								break;
						}
						ls_builder.setFunctionType(parameters.getLsType());
						vrp_ils_builder.setLsBuilder(ls_builder);
						
						switch (parameters.getStopCondType()) {
							case "iterations":
								vrp_ils_builder.getIls().setCondition(new VRPILSStopConditionIterations());
								break;
							case "time":
								vrp_ils_builder.getIls().setCondition(new VRPILSStopConditionTime());
								break;
							default:
								System.out.println("\nTipo de Condição de Parada não disponível!");
								break;
						}
						
						vrp_ils_builder.getIls().setPerturb(new VRPILSPerturbationInLevels());
								
						parameters.setAcceptCritType("fo");
						vrp_ils_builder.getIls().setCriteria(new VRPILSAcceptationCriteriaFO());
						
						break;
					case "grasp":
						
						break;
				}
				break;
			case "pmp":
				break;		
			default:
				System.out.println("Tipo de Construtor de método não disponível!");
		}
		
		return builder;
	}
	
}
