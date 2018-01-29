package Function_Package;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: One of the functions of the methods. Used by Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public interface StopConditionAllThreads {

	public abstract boolean stopConditionAllThreads(Element e, Problem p, Solution s);
	
}
