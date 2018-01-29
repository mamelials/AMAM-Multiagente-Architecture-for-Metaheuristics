package Main;

import Cooperation.Cooperation;
import Cooperation.CooperationFactory;
import Environment.Problem;
import Factorys.ProblemFactory;
import Function_Package.WriterInFile;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that defines a Experiment.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class Experiment {

	private Parameters parameters;
	private Problem p;
	private Cooperation cooperation;
	
	public Experiment(String experiment_text_file, String methods_param_file) throws Exception {
		
		//INPUT PARAMETERS  ---  LOADS ALL PARAMETERS
		parameters = new Parameters(experiment_text_file, methods_param_file);
		
		ProblemFactory problem_factory = new ProblemFactory();
		p = problem_factory.createProblem(parameters);
		
		CooperationFactory cooperation_factory = new CooperationFactory();
		this.cooperation = cooperation_factory.createCooperation(parameters.getExperimentParameters().getCooperationType(), parameters.getExperimentParameters().getProblemDescription(), parameters.getExperimentParameters(), p);
		
	}
	
	public void runExperiment(String experiment) throws Exception {
		
		ExecutionMainThread main_thread = new  ExecutionMainThread();
		
		for(int n_try = 0; n_try < parameters.getExperimentParameters().getExecutionsNumber(); n_try++) {
			//INITIALIZATION
			this.parameters.getExperimentParameters().setInitialTimeExecution(System.currentTimeMillis());
			this.parameters.getExperimentParameters().setNTry(n_try);
			
			//OUTPUT FILES
			this.parameters.getExperimentParameters().setFwPool(new WriterInFile("Results" + experiment + " -" + p.getInstanceName() + "-" + n_try + "-pool.txt"));
			this.parameters.getExperimentParameters().setFwBestSolution(new WriterInFile("Results" + experiment + "-" + p.getInstanceName() + "-" + n_try + "-best_solution.txt"));
			
			//EXECUTION OF AGENTS
			main_thread.execute(experiment, p, this.parameters, this.cooperation, n_try);
			
			System.out.println("\n\nTerminou o " + n_try + "o teste!\n\n");
		}
	}

	public Cooperation getCooperation() {
		return cooperation;
	}

	public void setCooperation(Cooperation cooperation) {
		this.cooperation = cooperation;
	}

	public Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	
}