package Local_Search_VRP;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Function_Package.AcceptationCriteria;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the AcceptationCriteria Class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPLocalSearchAcceptationCriteriaOF implements AcceptationCriteria{

	@Override
	public boolean acceptationCriteria(Solution s1, Solution s2, Element e,
			Problem p) {
		// TODO Auto-generated method stub
		
		if(s1.getObjectiveFunctionI(0) < s2.getObjectiveFunctionI(0)) {
			return true;
		}
		else {
			return false;
		}
	}

}
