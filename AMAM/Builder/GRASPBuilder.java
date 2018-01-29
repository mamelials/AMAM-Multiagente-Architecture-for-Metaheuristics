package Builder;

import GRASP.GreedyRandomizedAdaptiveSearchProcedure;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Builder class for GRASP Method. Implements Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public abstract class GRASPBuilder extends MethodBuilder{

    private GreedyRandomizedAdaptiveSearchProcedure grasp;
    private MethodBuilder construct_builder;
	private MethodBuilder ls_builder;
	
	public GRASPBuilder() {
		this.setGrasp(new GreedyRandomizedAdaptiveSearchProcedure());
	}

	public GreedyRandomizedAdaptiveSearchProcedure getGrasp() {
		return grasp;
	}

	public void setGrasp(GreedyRandomizedAdaptiveSearchProcedure grasp) {
		this.grasp = grasp;
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
