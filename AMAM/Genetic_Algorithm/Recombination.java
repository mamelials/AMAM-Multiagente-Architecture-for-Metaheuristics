package Genetic_Algorithm;

import Environment.Problem;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: One of the elements of a Genetic Algorithm. Used by Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public interface Recombination {

	public abstract void applyRecombination(Population pop, Problem p);
	
}
