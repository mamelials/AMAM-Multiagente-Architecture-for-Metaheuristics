package ILS_VRP;

import Environment.Element;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the Element Class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPILSElement extends Element{

	private int iterations_number;
	private int max_iterations;
	private int level_perturb;
	private int max_level_perturb;
	
	private double best_of;
	private int best_number_routes;
	
	public VRPILSElement() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	public int getIterationsNumber() {
		return iterations_number;
	}

	public void setIterationsNumber(int iterations_number) {
		this.iterations_number = iterations_number;
	}
	
	public void addIterationNumber() {
		this.iterations_number++;
	}

	public int getMaxIterations() {
		return max_iterations;
	}

	public void setMaxIterations(int max_iterations) {
		this.max_iterations = max_iterations;
	}

	public int getLevelPerturb() {
		return level_perturb;
	}

	public void setLevelPerturb(int level_perturb) {
		this.level_perturb = level_perturb;
	}
	
	public void addLevelPerturb() {
		this.level_perturb++;
	}

	public int getMaxLevelPerturb() {
		return max_level_perturb;
	}

	public void setMaxLevelPerturb(int max_level_perturb) {
		this.max_level_perturb = max_level_perturb;
	}

	public double getBestOf() {
		return best_of;
	}

	public void setBestOf(double best_of) {
		this.best_of = best_of;
	}

	public int getBestNumberRoutes() {
		return best_number_routes;
	}

	public void setBestNumberRoutes(int best_number_routes) {
		this.best_number_routes = best_number_routes;
	}
	
}
