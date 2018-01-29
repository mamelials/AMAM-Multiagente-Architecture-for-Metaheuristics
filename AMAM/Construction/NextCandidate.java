package Construction;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: One of the elements of a Constructive Heuristic. Used by Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public interface NextCandidate {

	public abstract void nextCandidate(Solution s, Element e, Problem p, String function_type, int receiver_size);
	
}
