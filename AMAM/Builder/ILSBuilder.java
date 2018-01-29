package Builder;

import Cooperation.Cooperation;
import Environment.Problem;
import Factorys.ElementFactory;
import Factorys.SolutionFactory;
import ILS.IteratedLocalSearch;
import Methods.Method;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Builder class for ILS Method. Implements Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class ILSBuilder extends MethodBuilder{

	private IteratedLocalSearch ils;
	private MethodBuilder construct_builder;
	private MethodBuilder ls_builder;
	
	public ILSBuilder() {
		this.setIls(new IteratedLocalSearch());
	}
	
	@Override
	public Method building(int id_method, Parameters parameters, Cooperation cooperation, Problem p) {
		// TODO Auto-generated method stub
		
		SolutionFactory solution_factory = new SolutionFactory();
		this.ils.setSo(solution_factory.createSolution(parameters.getExperimentParameters().getReceiverSize(), p));
		this.ils.setS(solution_factory.createSolution(parameters.getExperimentParameters().getReceiverSize(), p));
		this.ils.setImproveSolution(solution_factory.createSolution(parameters.getExperimentParameters().getReceiverSize(), p));
		this.ils.setPerturbSolution(solution_factory.createSolution(parameters.getExperimentParameters().getReceiverSize(), p));
		this.ils.setBestSolution(solution_factory.createSolution(parameters.getExperimentParameters().getReceiverSize(), p));
		
		ElementFactory element_factory = new ElementFactory();
		this.ils.setElement(element_factory.createElement(p, parameters, id_method));
		
		this.ils.setParameters(parameters);
		
		//Construction
		this.ils.setConstruction(this.getConstructBuilder().building(id_method, parameters, cooperation, p));
		//Local Search
		this.ils.setLocalSearch(this.getLsBuilder().building(id_method, parameters, cooperation, p));
		
		this.ils.setCooperation(cooperation);
		
		return this.ils;
	}

	public IteratedLocalSearch getIls() {
		return ils;
	}

	public void setIls(IteratedLocalSearch ils) {
		this.ils = ils;
	}

	public MethodBuilder getConstructBuilder() {
		return construct_builder;
	}

	public void setConstructBuilder(MethodBuilder construct_builder) {
		this.construct_builder = construct_builder;
	}

	public MethodBuilder getLsBuilder() {
		return ls_builder;
	}

	public void setLsBuilder(MethodBuilder ls_builder) {
		this.ls_builder = ls_builder;
	}
	
}
