package Builder;

import Cooperation.Cooperation;
import Environment.Problem;
import Methods.Method;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Abstract class that defines the model of the builder class for Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public abstract class MethodBuilder {

	private String function_type;
	
	public abstract Method building(int id_method, Parameters parameters, Cooperation cooperation, Problem p);

	public String getFunctionType() {
		return function_type;
	}

	public void setFunctionType(String function_type) {
		this.function_type = function_type;
	}
	
}
