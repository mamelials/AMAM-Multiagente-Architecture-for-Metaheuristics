package Environment;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Abstract class that defines the solution model for optimization problems.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import java.io.IOException;

import Function_Package.WriterInFile;

public abstract class Solution {

	/* ATTRIBUTES */
	private double objective_function[];
	private double cost_without_penalty;
	private double fitness_function;
	private double fitness_learning;
	
	//data pool
	private Sender sender;
	private Receiver receiver;
	private float seach_time;
	
	//multiobjective
	private boolean visited;
	
	public Solution(int receiver_size, int dimension){
		this.sender = new Sender();
		this.receiver= new Receiver(receiver_size);
		this.objective_function = new double[dimension];
	}
	
	/* ABSTRACT METHODS */
	public abstract void calculateObjectiveFunction(Problem p);
	
	public abstract void calculateFitnessFunction(double gama, Problem p);
	
	public abstract void copyValuesSolution(Solution s, Problem p);
	
	public abstract void showSolution(Problem p);
	
	public abstract void showOFAndFitness(Problem p);
	
	public abstract void writeSolution(Problem p, WriterInFile fw) throws IOException;
	
	public abstract void writeSolutionST(Problem p, WriterInFile fw) throws IOException;
	
	public abstract void writeReduceSolution(Problem p, WriterInFile fw) throws IOException;
	
	/*UTILITY*/
	public void minMaxFitnessWorstSolution(Solution worst_solution, Problem p) {
		double fitness = 0;
		double objective_function[] = new double[p.getDimension()];
		
			for(int i = 0; i < p.getDimension(); i++) {
				objective_function[i] = worst_solution.getObjectiveFunctionI(i) - this.getObjectiveFunctionI(i);
				if(p.getDimension() > 1) {
					fitness = fitness + (0.5 * objective_function[i]);
				}
				else {
					fitness = objective_function[i];
				}
			}
		
		this.setFitnessLearning(fitness);
	}
	
	public void showObjectiveFunction(Problem p) {
		for(int i = 0; i < p.getDimension(); i++) {
			System.out.print("Objective Function " + i+1 + ": " + this.getObjectiveFunctionI(i));
		}
	}
	
	/* SETS AND GETS */	
	public void setObjectiveFunctionI(int i, double objective_function) {
		this.objective_function[i] = objective_function;
	}
	
	public double getObjectiveFunctionI(int i) {
		return this.objective_function[i];
	}

	public void setCostWithoutPenalty(double cost_without_penalty) {
		this.cost_without_penalty = cost_without_penalty;
	}

	public double getCostWithoutPenalty() {
		return this.cost_without_penalty;
	}

	public void setFitnessFunction(double fitness_function) {
		this.fitness_function = fitness_function;
	}

	public double getFitnessFunction() {
		return this.fitness_function;
	}
	
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	public Sender getSender() {
		return this.sender;
	}
	
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
	
	public Receiver getReceiver() {
		return this.receiver;
	}

	public void setSeachTime(float seach_time) {
		this.seach_time = seach_time;
	}

	public float getSeachTime() {
		return this.seach_time;
	}

	public double getFitnessLearning() {
		return fitness_learning;
	}

	public void setFitnessLearning(double fitness_learning) {
		this.fitness_learning = fitness_learning;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
}
