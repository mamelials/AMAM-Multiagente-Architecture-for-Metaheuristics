package Genetic_Algorithm;

import Environment.Problem;
import Environment.Solution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Elements used for Genetic Algorithm.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class Population {

	private Solution population[];
	private int size;
	
	public Population(int pop_size) {
		this.setSize(pop_size);
		this.population = new Solution[pop_size];
	}

	public Solution[] getPopulation() {
		return population;
	}

	public void setPopulation(Solution population[]) {
		this.population = population;
	}
	
	public Solution getPopulationI(int i) {
		return population[i];
	}

	public void setPopulation(int i, Solution solution, Problem p) {
		this.population[i].copyValuesSolution(solution, p);
	}

	public void newSolutioni(int i, Solution solution, Problem p) {
		this.population[i] = solution;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int maxMonoOF () {
		int pos_max = 0;
		double max = this.getPopulationI(0).getObjectiveFunctionI(0);
		
		for(int i = 1; i < this.getSize(); i++) {
			if(this.getPopulationI(i).getObjectiveFunctionI(0) > max) {
				max = this.getPopulationI(i).getObjectiveFunctionI(0);
				pos_max = i;
			}
		}
		return pos_max;
	}
	
	public int minMonoOF () {
		int pos_min = 0;
		double min = this.getPopulationI(0).getObjectiveFunctionI(0);
		
		for(int i = 1; i < this.getSize(); i++) {
			if(this.getPopulationI(i).getObjectiveFunctionI(0) < min) {
				min = this.getPopulationI(i).getObjectiveFunctionI(0);
				pos_min = i;
			}
		}
		return pos_min;
	}
	
	public int maxMonoFitness(Problem p) {
		int pos_max = 0;
		double max = this.getPopulationI(0).getFitnessFunction();
		
		for(int i = 1; i < this.getSize(); i++) {
			if(this.getPopulationI(i).getFitnessFunction() > max) {
				max = this.getPopulationI(i).getFitnessFunction();
				pos_max = i;
			}
		}
		return pos_max;
	}
	
	public int minMonoFitness(Problem p) {
		int pos_min = 0;
		double min = this.getPopulationI(0).getFitnessFunction();
		
		for(int i = 1; i < this.getSize(); i++) {
			if(this.getPopulationI(i).getFitnessFunction() < min) {
				min = this.getPopulationI(i).getFitnessFunction();
				pos_min = i;
			}
		}
		return pos_min;
	}
	
}
