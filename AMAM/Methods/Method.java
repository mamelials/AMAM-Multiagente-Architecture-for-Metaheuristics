package Methods;

import Cooperation.Cooperation;
import Environment.Problem;
import Environment.Solution;
import MultiagentSystem.Agent;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Abstract class that defines the Method model.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public abstract class Method {
	
	//FOR STOP THREAD
	private Agent agent;
	
	private Parameters parameters;
	
	//copy cooperation
	private Cooperation cooperation;
	
	public abstract Solution runMethod(Problem p, Solution s, int id_agent);

	public Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	public Cooperation getCooperation() {
		return cooperation;
	}

	public void setCooperation(Cooperation cooperation) {
		this.cooperation = cooperation;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
