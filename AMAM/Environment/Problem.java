package Environment;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Abstract class that defines the optimization problem model.   
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public abstract class Problem {

	/* ATTRIBUTES */
	private String instance_name;
	private String problem_description;
	private int dimension;  //number of goals
	
	private String problem_type[]; 
	
	public Problem(String instance, String problem_description, String problem_type[], int dimension) {
		this.instance_name = instance;
		this.problem_description = problem_description;
		this.dimension = dimension;
		this.problem_type = new String[this.dimension];
		for(int i = 0; i < this.dimension; i++) {
			this.problem_type[i] = problem_type[i];
		}
	}
	
	/* ABSTRACT METHODS */
	public abstract void readProblem(String instance, int dimension) throws Exception;

	public abstract void copyValuesProblem(Problem p);
	
	public abstract void showProblem();
	
	public abstract int randomItem(); 

	/* SETS AND GETS */
	public void setInstanceName(String instance_name) {
		this.instance_name = instance_name;
	}

	public String getInstanceName() {
		return instance_name;
	}

	public String getProblemDescription() {
		return problem_description;
	}

	public void setProblemDescription(String problem_type) {
		this.problem_description = problem_type;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public String getProblemType(int i) {
		return problem_type[i];
	}

	public void setProblemType(String problem_type, int i) {
		this.problem_type[i] = problem_type;
	}
	
}
