package Factorys;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class responsible for agent creation (instantiation)  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import Builder.MethodBuilder;
import Cooperation.Cooperation;
import Environment.Problem;
import Main.ExecutionMainThread;
import MultiagentSystem.Agent;
import Parameters.Parameters;

public class AgentFactory {

	public Agent createAgent(Parameters parameters, Cooperation cooperation, Problem p,
			int agent_id, int execution, ExecutionMainThread handler) throws Exception {
		
		//DEFINING THE AGENT
		
		//CREATE METHOD BUILDER
		MethodBuilderFactory method_builder_factory = new MethodBuilderFactory();
		MethodBuilder method_builder = method_builder_factory.createMethodBuilder(p.getProblemDescription(), parameters.getMethodParametersI(agent_id)); 
		
		Agent agent = new Agent(handler, agent_id, execution, p, parameters, cooperation);
		
		//agent.setFinalSolution(s);
		//agent.setSo(s);
		
		agent.setMethod(method_builder.building((agent_id), parameters, cooperation, p));
		
		//agent.setFw_writer(new WriterInFile("Results-" + p.getProblemDescription() + "- " + p.getInstanceName() + " - " + agent_id + " - " + execution + ".txt"));
		//agent.setFw_writer_reduced(new WriterInFile("Results-" + p.getProblemDescription() + "- " + p.getInstanceName()  + " - " + agent_id + " - " + execution + "-Reduced.txt"));
		//agent.setFwWriterPool(new WriterInFile("Results-POOL-" + p.getProblemDescription() + "- " + p.getInstanceName()  + " - " + agent_id + " - " + execution + ".txt"));
		
		return agent;
	}
	
}
