package ILS;

import Cooperation.Cooperation;
import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: One of the elements of a ILS Method. Used by Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public interface ILSPerturbation {

	public abstract Solution perturbation(Solution s, Element e, int id_agent, Cooperation cooperation, Parameters parameters, Problem p);
	
}
