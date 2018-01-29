package Local_Search;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_Movements.MovementList;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: One of the elements of a Local Seach Heuristic. Used by Design Pattern Builder.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class MoveNeighborhood{
	
	private MovementList list;
	private int list_size;
	
	public MoveNeighborhood(int list_size) {
		this.setListSize(list_size);
		MovementList l = new MovementList(list_size);
		this.setList(l);
	}
	
	public Solution moveNeighborhood(int neighborhood, Solution s, Parameters parameters, Element e, Problem p) {
		return this.list.getMoveI(neighborhood).movement(s, parameters.getExperimentParameters().getReceiverSize(), e, p);
	}

	public int getListSize() {
		return list_size;
	}

	public void setListSize(int list_size) {
		this.list_size = list_size;
	}

	public MovementList getList() {
		return list;
	}

	public void setList(MovementList list) {
		this.list = list;
	}

}
