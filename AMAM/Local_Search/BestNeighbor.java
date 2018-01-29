package Local_Search;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Function_Package.AcceptationCriteria;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: One of the elements of a Local Seach Heuristic. Used by Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public interface BestNeighbor {
	
	public abstract Solution bestNeighbor(int neighborhood, MoveNeighborhood movement_neighborhood, 
			AcceptationCriteria criteria , Solution so, Parameters parameters, 
			Element e, Problem p);

}
