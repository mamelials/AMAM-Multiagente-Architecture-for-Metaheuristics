package GRASP;

import java.io.IOException;
import java.util.Random;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Function_Package.AcceptationCriteria;
import Function_Package.StopCondition;
import Methods.Method;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that defines the structure of a basic GRASP Method. Defined at run time by 
 * Design Pattern Builder.
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class GreedyRandomizedAdaptiveSearchProcedure extends Method{

	private Method construction;
	private Method construction_partial_solution;
	private Method local_search;
	private StopCondition condition;
	private AcceptationCriteria criteria;
	
	private Element element;
	
	private int portion_size;
	
	private Solution so;
	private Solution improve_solution;
	private Solution best_solution;
	
	
	public Solution runMethod(Problem p, Solution s, int id_agent) {
		
		Random generator = new Random();
		long solution_time;
		double aleatory, probability = 0.5;
		
		this.so.copyValuesSolution(this.construction.runMethod(p, so, id_agent), p);
		System.out.print("\n\n--INITIAL SOLUTION--");
		this.so.showSolution(p);
		
		solution_time = System.currentTimeMillis() - this.getParameters().getMethodParametersI(id_agent-1).getInitialTime();
		//ESCREVENDO NOS ARQUIVOS
		try {
			this.getParameters().getMethodParametersI(id_agent-1).getFw().writeSolutionsInTextFile(this.so, solution_time, p, "INITIAL");
			this.getParameters().getMethodParametersI(id_agent-1).getFwReduced().writeSolutionsInTextFilesReduced(this.so, solution_time, p, "INITIAL");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ADD IN POOL
		this.getCooperation().getPool().addSolutionInPool_evaluation(this.so, p, id_agent, 0, this.element);
		
		this.improve_solution.copyValuesSolution(this.local_search.runMethod(p, so, id_agent), p);
		//System.out.print("\n\n--IMPROVE SOLUTION--");
		//this.improve_solution.showSolution(p);
		
		this.best_solution.copyValuesSolution(this.improve_solution, p);
		
		//ADD IN POOL
		this.getCooperation().getPool().addSolutionInPool_evaluation(this.best_solution, p, id_agent, 0, this.element);
		
		solution_time = System.currentTimeMillis() - this.getParameters().getMethodParametersI(id_agent-1).getInitialTime();
		//ESCREVENDO NOS ARQUIVOS
		try {
			this.getParameters().getMethodParametersI(id_agent-1).getFw().writeSolutionsInTextFile(this.so, solution_time, p, "BEST");
			this.getParameters().getMethodParametersI(id_agent-1).getFwReduced().writeSolutionsInTextFilesReduced(this.so, solution_time, p, "BEST");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(this.condition.stopCondition(this.element, p, this.best_solution)) {
			
			aleatory = generator.nextDouble();
			if(aleatory < probability) {
				this.so.copyValuesSolution(this.construction.runMethod(p, so, id_agent), p);
				//System.out.print("\n\n--INITIAL SOLUTION--");
				//this.so.showSolution(p);
			}
			else {
				//COOPERATION - GET IN POOL
				this.so.copyValuesSolution(this.getCooperation().getPool().getSolutionGRASP(this.construction_partial_solution, this.portion_size, this.getParameters().getExperimentParameters().getReceiverSize(), p), p);
				//System.out.print("\n\n--INITIAL SOLUTION--");
				//this.so.showSolution(p);
			}
			
			this.improve_solution.copyValuesSolution(this.local_search.runMethod(p, so, id_agent), p);
			//System.out.print("\n\n--IMPROVE SOLUTION--");
			//this.improve_solution.showSolution(p);
			
			if(this.criteria.acceptationCriteria(this.improve_solution, this.best_solution, this.element, p)) {
				this.best_solution.copyValuesSolution(this.improve_solution, p);
				//System.out.print("\n\n--BEST SOLUTION--");
				//this.best_solution.showSolution(p);
				
				//ADD IN POOL
				this.getCooperation().getPool().addSolutionInPool_evaluation(this.best_solution, p, id_agent, 0, this.element);
				
				solution_time = System.currentTimeMillis() - this.getParameters().getMethodParametersI(id_agent-1).getInitialTime();
				//ESCREVENDO NOS ARQUIVOS
				try {
					this.getParameters().getMethodParametersI(id_agent-1).getFw().writeSolutionsInTextFile(this.so, solution_time, p, "BEST");
					this.getParameters().getMethodParametersI(id_agent-1).getFwReduced().writeSolutionsInTextFilesReduced(this.so, solution_time, p, "BEST");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		//this.getCooperation().getPool().showPoolSolutions(p);
		try {
			this.getCooperation().getPool().writePoolSolutionsReduce(p, this.getParameters().getExperimentParameters().getFwPool());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return this.best_solution;
	}

	public Method getConstruction() {
		return construction;
	}

	public void setConstruction(Method construction) {
		this.construction = construction;
	}

	public Method getLocalSearch() {
		return local_search;
	}

	public void setLocalSearch(Method local_search) {
		this.local_search = local_search;
	}

	public StopCondition getCondition() {
		return condition;
	}

	public void setCondition(StopCondition condition) {
		this.condition = condition;
	}

	public AcceptationCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(AcceptationCriteria criteria) {
		this.criteria = criteria;
	}

	public Solution getSo() {
		return so;
	}

	public void setSo(Solution so) {
		this.so = so;
	}

	public Solution getImproveSolution() {
		return improve_solution;
	}

	public void setImproveSolution(Solution improve_solution) {
		this.improve_solution = improve_solution;
	}

	public Solution getBestSolution() {
		return best_solution;
	}

	public void setBestSolution(Solution best_solution) {
		this.best_solution = best_solution;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Method getConstructionPartialSolution() {
		return construction_partial_solution;
	}

	public void setConstructionPartialSolution(
			Method construction_partial_solution) {
		this.construction_partial_solution = construction_partial_solution;
	}

	public int getPortionSize() {
		return portion_size;
	}

	public void setPortionSize(int portion_size) {
		this.portion_size = portion_size;
	}
	
}
