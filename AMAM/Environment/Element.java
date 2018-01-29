package Environment;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class responsible for the specific data of the current problem that will be passed on to the methods.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public abstract class Element {
	
	private int id;
	private Solution best_current_solution;
	
	private long initial_time;
	private int max_time;
	
	private Archive archive;
	
	public Element(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Solution getBestCurrentSolution() {
		return best_current_solution;
	}

	public void setBestCurrentSolution(Solution best_current_solution, Problem p) {
		this.best_current_solution.copyValuesSolution(best_current_solution, p);
	}
	
	public void nullBestCurrentSolution() {
		this.best_current_solution = null;
	}

	public void newBestCurrentSolution(Solution best_current_solution) {
		this.best_current_solution = best_current_solution;
	}
	
	public long getInitialTime() {
		return initial_time;
	}

	public void setInitialTime(long initial_time) {
		this.initial_time = initial_time;
	}

	public int getMaxTime() {
		return max_time;
	}

	public void setMaxTime(int max_time) {
		this.max_time = max_time;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

}
