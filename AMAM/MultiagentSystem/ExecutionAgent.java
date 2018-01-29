package MultiagentSystem;

import Cooperation.Cooperation;
import Cooperation.PoolSolutions;
import Environment.Problem;
import Factorys.PoolSolutionsFactory;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that defines the execution of agent.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class ExecutionAgent {

	public void executionAgentsEqual(int n, String problem_type, String method_type, int execution, Parameters parameters, Problem p) throws Exception{
		
		//DEFINE COOPERATION
		Cooperation cooperation = new Cooperation();
		PoolSolutionsFactory pool_factory = new PoolSolutionsFactory();
		PoolSolutions pool = pool_factory.createPool(problem_type, parameters.getExperimentParameters().getMaxSizePool(), parameters.getExperimentParameters().getRadiusNiche(), parameters.getExperimentParameters().getReceiverSize(), p);
		cooperation.setPool(pool);
		
		Agent agents[] = new Agent[n];
		for(int i = 0; i < n; i++) {
		    //agents[i] = 
		}
		
		Thread thread_agents[] = new Thread[n];
		for(int i = 0; i < n; i++) {
		    thread_agents[i] = new Thread(agents[i]);
		}
		
		for(int i = 0; i < n; i++) {
		    thread_agents[i].run();
		}
		
		/*
		Agent agent1 = new_agent_grasp.newAgent(1, parameters, p, cooperation);
		Agent agent2 = new_agent_grasp.newAgent(2, parameters, p, cooperation);
		
		Thread thread_agent1 = new Thread(agent1);
		Thread thread_agent2 = new Thread(agent2);
		
		thread_agent1.run();
		thread_agent2.run();
		*/
	}
	
	/*public void executionOneAgent(String problem_type, String method_type, Cooperation cooperation, Parameters parameters, int execution,Problem p) throws Exception{
		
		NewAgent new_agent = new NewAgent(problem_type, method_type, execution);
		
		Agent agent1 = new_agent.newAgent(1, parameters, p, cooperation);
	
		Thread thread_agent1 = new Thread(agent1);
		
		thread_agent1.run();
		
	}*/
	
}
