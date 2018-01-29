package ILS_PM;

import Environment.Element;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the Element Class. 
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMILSElement extends Element{

	private int iterations_number;
	private int max_iterations;
	private int level_perturb;
	private int max_level_perturb;
	
	public PMILSElement() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	public int getIterationsNumber() {
		return iterations_number;
	}

	public void setIterationsNumber(int iterations_number) {
		this.iterations_number = iterations_number;
	}

	public void addIterationsNumber() {
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
	
}
