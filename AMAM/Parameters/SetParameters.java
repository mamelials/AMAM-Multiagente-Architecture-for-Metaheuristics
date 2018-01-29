package Parameters;

import java.io.IOException;

import Environment.Problem;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Experiments parameters.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public abstract class SetParameters {

	public abstract MethodParameters setParameters(String parameter_text_file, Problem p, int n_try, long initial_time) throws IOException;	
}
