package Construction;

import Environment.Element;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: One of the elements of a Constructive Heuristic. Used by Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public interface UpdateCandidates {

	public abstract void updateCandidates(Element e);
	
}
