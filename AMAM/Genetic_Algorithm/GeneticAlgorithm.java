package Genetic_Algorithm;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Function_Package.StopCondition;
import Methods.Method;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that defines the structure of a basic Genetic Algorithm. Defined at run time by 
 * Design Pattern Builder.
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class GeneticAlgorithm extends Method{

	private Population population;
	private Element e;
	
	private GeneratesInitialPopulation generates;
	private EvaluateFitness evaluate;
	private Recombination recombination;
	private Mutation mutation;
	private Selection selection;
	
	private StopCondition condition;
	
	private Solution best_solution;
	
	@Override
	public Solution runMethod(Problem p, Solution s, int id_agent) {
		// TODO Auto-generated method stub
		
		this.population = generates.generatesInitialPolulation(p);
		
		evaluate.evaluateFitness(this.population, p);
		
		while(condition.stopCondition(this.e, p, s)) {
			
			recombination.applyRecombination(this.population, p);
			
			mutation.applyMutation(this.population, p);
			
			evaluate.evaluateFitness(this.population, p);
			
			selection.select(population, p);
		}
		
		return best_solution;
	}

	public Solution getBestSolution() {
		return best_solution;
	}

	public void setBestSolution(Solution best_solution) {
		this.best_solution = best_solution;
	}

}
