package MultiagentSystem;

import java.io.IOException;

import Cooperation.Cooperation;
import Environment.Problem;
import Environment.Solution;
import Factorys.SolutionFactory;
import Function_Package.WriterInFile;
import Main.ThreadBase;
import Main.ExecutionMainThread;
import Methods.Method;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that defines the Agent and the thread.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class Agent extends ThreadBase{
	
	//ALL AGENTS ARE OBSERVERS  - LISTNERS
	private boolean allDone;
	
	private int id_thread; //for method i
	private int id;   //for receiver and sender
	private int id_execution;
	
	private Method method;
	
	private long final_time;
	private long total_time_run;
	
	private Solution so;
	private Solution final_solution;
	
	private WriterInFile fw_writer;
	private WriterInFile fw_writer_reduced;
	private WriterInFile fw_writer_pool;
	
	//copy of problem
	private Problem p;
	//copy of parameters
	private Parameters parameters;
	//copy of cooperation
	private Cooperation cooperation;
	
	public Agent(ExecutionMainThread handler, int id_agent, int id_execution, Problem p, 
			Parameters parameters, Cooperation cooperation) {
		super(handler);
		// TODO Auto-generated constructor stub
		
		this.id_thread = id_agent;
		this.id = id_agent;
		this.id_execution = id_execution;
		this.p = p;
		this.parameters = parameters;
		this.cooperation = cooperation;
		
		SolutionFactory solution_factory = new SolutionFactory();
		this.final_solution = solution_factory.createSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.so = solution_factory.createSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.parameters.getMethodParametersI(this.id_thread).setBestMethodSolution(solution_factory.createSolution(parameters.getExperimentParameters().getReceiverSize(), p));
		
		this.allDone = false;
		
		cooperation.getPool().attach(this); //ADD A POOL OBSERVER
		
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		
		//this.method.getParameters().getExperimentParameters().setFw(fw_writer);
		//this.method.getParameters().getExperimentParameters().setFwReduced(fw_writer_reduced);
		//this.method.getParameters().getExperimentParameters().setFwPool(fw_writer_pool);
		
		this.method.setAgent(this);
		
		this.getMethod().getParameters().getMethodParametersI(this.id_thread).setInitialTime(System.currentTimeMillis());
		
		this.final_solution.copyValuesSolution(method.runMethod(this.p, this.so, this.id), this.p);
		this.parameters.getMethodParametersI(this.id_thread).getBestMethodSolution().copyValuesSolution(this.final_solution, p);
		
		this.setFinalTime(System.currentTimeMillis());
		this.setTotalTimeRun((this.getFinalTime() - this.getMethod().getParameters().getMethodParametersI(this.id_thread).getInitialTime()));
		
		System.out.print("\n\n----FINAL SOLUTION----");
		this.final_solution.showSolution(p);
		
		try {
			parameters.getMethodParametersI(this.id).getFw().writerTextFile("\n\n----FINAL SOLUTION----");
			parameters.getMethodParametersI(this.id).getFwReduced().writerTextFile("\n\n----FINAL SOLUTION----");
			this.final_solution.writeSolution(this.p, parameters.getMethodParametersI(this.id).getFw());
			this.final_solution.writeSolutionST(p, parameters.getMethodParametersI(this.id).getFwSt());
			this.final_solution.writeReduceSolution(this.p, parameters.getMethodParametersI(this.id).getFwReduced());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\nTEMPO DE EXECUÇÃO TOTAL: " + this.getTotalTimeRun()/1000.0 + "s");
		try {
			parameters.getMethodParametersI(this.id).getFw().writerTextFile("\n\nTEMPO DE EXECUÇÃO TOTAL: " + this.getTotalTimeRun()/1000.0 + "s");
			parameters.getMethodParametersI(this.id).getFwReduced().writerTextFile("\n\nTEMPO DE EXECUÇÃO TOTAL: " + this.getTotalTimeRun()/1000.0 + "s");
			parameters.getMethodParametersI(this.id).getFwSt().writerTextFile(this.getTotalTimeRun()/1000.0 + "");			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		parameters.getMethodParametersI(this.id_thread).setFinalTime(this.getTotalTimeRun());
		parameters.getMethodParametersI(this.id_thread).getBestMethodSolution().setSeachTime(this.getTotalTimeRun());;
		
		System.out.println("Teste Thread "+ this.id_execution + this.id + " Terminou!");
		this.handler.notifyFinishThread();//notifica que o agente terminou a execução do seu método
		
	}
	
	//DEFINITION OF OBSERVER ------ ALL AGENTS ARE OBSERVERS ------
	public void update() {
		//System.out.println("\nNOVO ELEMENTO INSERIDO NO POOL: Ver chamada de comandos para atualizar quando receber uma notificação do Pool");
	}
	
	public void updateBestSolution() {
		//PARAR O MÉTODO
		this.setAllDone(true);
	}
	//----------------------
		
	public void setId(int id) {
		this.id = id;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Problem getProblem() {
		return p;
	}

	public void setProblemP(Problem p) {
		this.p = p;
	}

	public long getTotalTimeRun() {
		return total_time_run;
	}

	public void setTotalTimeRun(long total_time_run) {
		this.total_time_run = total_time_run;
	}

	public Solution getFinalSolution() {
		return final_solution;
	}

	public void setFinalSolution(Solution final_solution) {
		this.final_solution = final_solution;
	}

	public WriterInFile getFw_writer() {
		return fw_writer;
	}

	public void setFw_writer(WriterInFile fw_writer) {
		this.fw_writer = fw_writer;
	}

	public WriterInFile getFw_writer_reduced() {
		return fw_writer_reduced;
	}

	public void setFw_writer_reduced(WriterInFile fw_writer_reduced) {
		this.fw_writer_reduced = fw_writer_reduced;
	}

	public Solution getSo() {
		return so;
	}

	public void setSo(Solution so) {
		this.so = so;
	}

	public long getFinalTime() {
		return final_time;
	}

	public void setFinalTime(long final_time) {
		this.final_time = final_time;
	}

	public WriterInFile getFwWriterPool() {
		return fw_writer_pool;
	}

	public void setFwWriterPool(WriterInFile fw_writer_pool) {
		this.fw_writer_pool = fw_writer_pool;
	}

	public int getIdExecution() {
		return id_execution;
	}

	public void setIdExecution(int id_execution) {
		this.id_execution = id_execution;
	}

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

	public int getIdThread() {
		return id_thread;
	}

	public void setIdThread(int id_thread) {
		this.id_thread = id_thread;
	}

	public boolean isAllDone() {
		return allDone;
	}

	public void setAllDone(boolean allDone) {
		this.allDone = allDone;
	}

}
