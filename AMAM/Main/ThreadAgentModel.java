package Main;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that defines a Thread Agent Model.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class ThreadAgentModel extends ThreadBase{

	private int id_thread;
	private int id_execution;
	
	public ThreadAgentModel(ExecutionMainThread handler, int id_thread, int id_execution) {
		super(handler);
		// TODO Auto-generated constructor stub
		
		this.id_thread = id_thread;
		this.id_execution = id_execution;
	}
	
	public void run() {
		for(int i = 0; i < 100; i++){
			System.out.println("Teste Thread " + this.id_execution + this.id_thread); //execução dos agentes da execução
		}
		System.out.println("Teste Thread "+ this.id_execution + this.id_thread + " Terminou!");
		this.handler.notifyFinishThread();
	}

}
