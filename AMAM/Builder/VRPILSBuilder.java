package Builder;

import Construction.Construction;
import Cooperation.Cooperation;
import Environment.Problem;
import Environment.Solution;
import Environment_VRP.VRPSolution;
import Function_Package.AcceptationCriteria;
import Function_Package.StopCondition;
import ILS.ILSPerturbation;
import ILS_VRP.VRPILSAcceptationCriteriaFO;
import ILS_VRP.VRPILSElement;
import ILS_VRP.VRPILSPerturbationInLevels;
import ILS_VRP.VRPILSStopConditionTime;
import Local_Search.AdaptiveLocalSearch_QLearning;
import Methods.Method;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Builder class for ILS Method for VRP. Implements Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPILSBuilder extends ILSBuilder{
	
	@Override
	public Method building(int id_method, Parameters parameters, Cooperation cooperation, Problem p) {
		// TODO Auto-generated method stub
		
		Solution so = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.getIls().setSo(so);
		
		Solution s = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.getIls().setS(s);
		
		Solution improve_solution = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.getIls().setImproveSolution(improve_solution);
		
		Solution perturb_solution = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.getIls().setPerturbSolution(perturb_solution);
		
		Solution best_solution = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.getIls().setBestSolution(best_solution);
		
		VRPILSElement e = new VRPILSElement();
		e.setIterationsNumber(0);
		e.setMaxIterations(parameters.getMethodParametersI(id_method).getMaxIterations());   
		e.setLevelPerturb(1);
		e.setMaxLevelPerturb(parameters.getMethodParametersI(id_method).getMaxLevelsPerturbation());
		e.setMaxTime(parameters.getMethodParametersI(id_method).getMaxTime());
		
		e.setBestNumberRoutes(parameters.getExperimentParameters().getBestAux());
		e.setBestOf(parameters.getExperimentParameters().getBestOF());
		this.getIls().setElement(e);
		
		this.getIls().setParameters(parameters);
		
		Method construction = new Construction();
		construction = this.getConstructBuilder().building(id_method, parameters, cooperation, p);
		this.getIls().setConstruction(construction);

		Method local_search = new AdaptiveLocalSearch_QLearning(); //LocalSearch();
		local_search = this.getLsBuilder().building(id_method, parameters, cooperation, p);
		this.getIls().setLocalSearch(local_search);
				
		//StopCondition condition = new VRPILSStopConditionIterations();
		StopCondition condition = new VRPILSStopConditionTime();
		this.getIls().setCondition(condition);
				
		ILSPerturbation perturb = new VRPILSPerturbationInLevels();
		this.getIls().setPerturb(perturb);
				
		AcceptationCriteria criteria = new VRPILSAcceptationCriteriaFO();
		this.getIls().setCriteria(criteria);
				
		this.getIls().setCooperation(cooperation);
		
		return this.getIls();
	}

}
