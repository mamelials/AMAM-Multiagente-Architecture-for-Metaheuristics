package Builder;

import Construction.Construction;
import Cooperation.Cooperation;
import Environment.Problem;
import Environment.Solution;
import Environment_VRP.VRPSolution;
import Function_Package.AcceptationCriteria;
import Function_Package.StopCondition;
import ILS_VRP.VRPILSAcceptationCriteriaFO;
import ILS_VRP.VRPILSElement;
import ILS_VRP.VRPILSStopConditionIterations;
import Local_Search.LocalSearch;
import Methods.Method;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Builder class for GRASP Method for VRP. Implements Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPGRASPBuilder extends GRASPBuilder{

	@Override
	public Method building(int id_method, Parameters parameters, Cooperation cooperation, Problem p) {
		// TODO Auto-generated method stub
		Solution so = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.getGrasp().setSo(so);
		
		Solution improve_solution = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.getGrasp().setImproveSolution(improve_solution);
		
		Solution best_solution = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.getGrasp().setBestSolution(best_solution);
		
		VRPILSElement e = new VRPILSElement();
		e.setIterationsNumber(0);
		e.setMaxIterations(parameters.getMethodParametersI(id_method).getMaxIterations());					//---MAX_LEVEL---
		this.getGrasp().setElement(e);

		this.getGrasp().setParameters(parameters);
		
		Method construction = new Construction();
		construction = this.getConstructBuilder().building(id_method, parameters, cooperation, p);
		this.getGrasp().setConstruction(construction);

		Method local_search = new LocalSearch();
		local_search = this.getLsBuilder().building(id_method, parameters, cooperation, p);
		this.getGrasp().setLocalSearch(local_search);
				
		StopCondition condition = new VRPILSStopConditionIterations();
		this.getGrasp().setCondition(condition);
		
		AcceptationCriteria criteria = new VRPILSAcceptationCriteriaFO();
		this.getGrasp().setCriteria(criteria);
				
		this.getGrasp().setCooperation(cooperation);
		
		return this.getGrasp();
	}

}
