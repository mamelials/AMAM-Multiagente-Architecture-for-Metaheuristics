package Construction;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Function_Package.StopCondition;
import Methods.Method;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that defines the structure of a basic Constructive Heuristic. Defined at run time by 
 * Design Pattern Builder.
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class Construction extends Method{

	private Solution s; //initial solution
	
	private InitializeSolution init_solution;
	private InitializeCandidates init_candidates;
	private StopCondition condition;
	private NextCandidate next;
	private AddElement add;
	private UpdateCandidates update_candidates;
	
	private Element element;
	
	private String function_type;	
	
	@Override
	public Solution runMethod(Problem p, Solution s_line, int id_agent) {
		// TODO Auto-generated method stub
		
		s = init_solution.initializeSolution(p, this.getParameters().getExperimentParameters().getReceiverSize());
		
		init_candidates.initializeCandidates(this.element, p);
		
		while (!(condition.stopCondition(this.element, p, s))) {
			
			next.nextCandidate(s, this.element, p, this.function_type, 
					this.getParameters().getExperimentParameters().getReceiverSize());
			
			add.addElementInSolution(s, this.element, p);
	
			update_candidates.updateCandidates(this.element);
		}

		return s;
	}
	
	public InitializeSolution getInitSolution() {
		return init_solution;
	}
	
	public void setInitSolution(InitializeSolution init_solution) {
		this.init_solution = init_solution;
	}

	public InitializeCandidates getInitCandidates() {
		return init_candidates;
	}

	public void setInitCandidates(InitializeCandidates init_candidates) {
		this.init_candidates = init_candidates;
	}

	public StopCondition getCondition() {
		return condition;
	}

	public void setCondition(StopCondition condition) {
		this.condition = condition;
	}

	public AddElement getAdd() {
		return add;
	}

	public void setAdd(AddElement add) {
		this.add = add;
	}

	public NextCandidate getNext() {
		return next;
	}

	public void setNext(NextCandidate next) {
		this.next = next;
	}

	public UpdateCandidates getUpdateCandidates() {
		return update_candidates;
	}

	public void setUpdateCandidates(UpdateCandidates update_candidates) {
		this.update_candidates = update_candidates;
	}

	public String getFunctionType() {
		return function_type;
	}

	public void setFunctionType(String function_type) {
		this.function_type = function_type;
	}
	
	public Element getElement() {
		return element;
	}
	
	public void setElement(Element e) {
		this.element = e;
	}
	
}
