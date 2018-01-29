package Factorys;

import Environment.Problem;
import Function_Package.StopConditionAllThreads;
import ILS_VRP.VRPILSStopConditionAllThreads;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function:  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class StopConditionAllThreadsFactory {
	
	public StopConditionAllThreads createStopConditionAllThreads(Problem p){
	
		StopConditionAllThreads stopcondition_allthreads = null;
	
		switch (p.getProblemDescription()) {
			case "vrp":
				stopcondition_allthreads = new VRPILSStopConditionAllThreads();
				break;
			case "pmp":
				break;		
			default:
				System.out.println("Tipo de Construtor de método não disponível!");
		}

		return stopcondition_allthreads;
	}

}
