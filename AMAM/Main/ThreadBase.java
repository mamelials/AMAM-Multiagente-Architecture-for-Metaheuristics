package Main;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class responsible for defining the structure of a thread in the framework. Every thread will 
 * have the reference of the main thread, to ensure that a next main thread is executed only if the previous 
 * main thread has been fully executed.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class ThreadBase extends Thread{

	protected ExecutionMainThread handler;
	
    public ThreadBase(ExecutionMainThread handler) {
        super();
        this.handler = handler; //cada thread tem uma referência da thread principal
    }
	
}
