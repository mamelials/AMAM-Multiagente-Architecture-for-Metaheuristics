package ILS;

import java.io.IOException;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Function_Package.AcceptationCriteria;
import Function_Package.StopCondition;
import Methods.Method;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that defines the structure of a basic ILS Method. Defined at run time by 
 * Design Pattern Builder.
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class IteratedLocalSearch extends Method{

	private Method construction;
	private Method local_search;
	private StopCondition condition;
	private ILSPerturbation perturb;
	private AcceptationCriteria criteria;
	
	private Element element;
	
	private Solution so;
	private Solution s;
	private Solution improve_solution;
	private Solution perturb_solution;
	private Solution best_solution;
	
	public Solution runMethod(Problem p, Solution s, int id_agent) {
		
		long solution_time;
		//int it = 1; //iteration number
		
		this.so.copyValuesSolution(this.construction.runMethod(p, so, id_agent), p);
		System.out.print("\n\n--INITIAL SOLUTION--");
		this.so.showSolution(p);
		
		solution_time = System.currentTimeMillis() - this.getParameters().getMethodParametersI(id_agent).getInitialTime();
		
		//ADD IN POOL - INITIAL SOLUTION
		this.getCooperation().getPool().addSolutionInPool_evaluation(this.so, p, 0, solution_time, this.element);
					
		//ESCREVENDO NOS ARQUIVOS
		try {
			this.getParameters().getMethodParametersI(id_agent).getFw().writeSolutionsInTextFile(this.so, solution_time, p, "INITIAL");
			this.getParameters().getMethodParametersI(id_agent).getFwReduced().writeSolutionsInTextFilesReduced(this.so, solution_time, p, "INITIAL");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.s.copyValuesSolution(this.local_search.runMethod(p, so, id_agent), p);
		//System.out.print("\n\n--IMPROVE SOLUTION--");
		//this.s.showSolution(p);
		
		this.best_solution.copyValuesSolution(this.s, p);
	
		solution_time = System.currentTimeMillis() - this.getParameters().getMethodParametersI(id_agent).getInitialTime();
		
		//ADD IN POOL
		this.getCooperation().getPool().addSolutionInPool_evaluation(this.best_solution, p, id_agent, solution_time, this.element);
	
		//ESCREVENDO NOS ARQUIVOS
		try {
			this.getParameters().getMethodParametersI(id_agent).getFw().writeSolutionsInTextFile(this.best_solution, solution_time, p, "BEST");
			this.getParameters().getMethodParametersI(id_agent).getFwReduced().writeSolutionsInTextFilesReduced(this.best_solution, solution_time, p, "BEST");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("\n\n--EXECUTION ILS--");
		
		this.element.setInitialTime(this.getParameters().getMethodParametersI(id_agent).getInitialTime());
		while(this.condition.stopCondition(this.element, p, this.best_solution)) {
			
			//System.out.print("\n\nIteration " + it + "\n");
			
			this.perturb_solution.copyValuesSolution(this.perturb.perturbation(this.best_solution, this.element, id_agent, this.getCooperation(), this.getParameters(), p), p);
			//System.out.print("\n\n--PERTURB SOLUTION--");
			//this.perturb_solution.showSolution(p);
			
			this.improve_solution.copyValuesSolution(this.local_search.runMethod(p, this.perturb_solution, id_agent), p);
			//System.out.print("\n\n--IMPROVE SOLUTION--");
			//this.improve_solution.showSolution(p);
			
			if(this.criteria.acceptationCriteria(this.improve_solution, this.best_solution, this.element, p)) {
				this.best_solution.copyValuesSolution(this.improve_solution, p);
				//System.out.print("\n\n--BEST SOLUTION--");
				//this.best_solution.showSolution(p);
				
				solution_time = System.currentTimeMillis() - this.getParameters().getMethodParametersI(id_agent).getInitialTime();
				
				//ADD IN POOL
				this.getCooperation().getPool().addSolutionInPool_evaluation(this.best_solution, p, id_agent, solution_time, this.element);
			
				//ESCREVENDO NOS ARQUIVOS
				try {
					this.getParameters().getMethodParametersI(id_agent).getFw().writeSolutionsInTextFile(this.best_solution, solution_time, p, "BEST");
					this.getParameters().getMethodParametersI(id_agent).getFwReduced().writeSolutionsInTextFilesReduced(this.best_solution, solution_time, p, "BEST");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			//it++;
			//System.out.println("\nIteration: " + it);
		
			//STOP THREAD
			if(this.getAgent().isAllDone()) {
				System.out.println("BREAK ----------------------------------");
				break;
			}
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
	
	public ILSPerturbation getPerturb() {
		return perturb;
	}
	
	public void setPerturb(ILSPerturbation perturb) {
		this.perturb = perturb;
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
	
	public Solution getS() {
		return s;
	}
	
	public void setS(Solution s) {
		this.s = s;
	}
	
	public Solution getImproveSolution() {
		return improve_solution;
	}
	
	public void setImproveSolution(Solution improve_solution) {
		this.improve_solution = improve_solution;
	}
	
	public Solution getPerturbSolution() {
		return perturb_solution;
	}
	
	public void setPerturbSolution(Solution perturb_solution) {
		this.perturb_solution = perturb_solution;
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

	public void setElement(Element e) {
		this.element = e;
	}
	
}
