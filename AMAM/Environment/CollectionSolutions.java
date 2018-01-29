package Environment;

/** AMAM - Multiagent architecture for metaheuristics
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Abstract class responsible for defining set of solutions. Used to define populations, 
 * pools, tabu lists, etc.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public abstract class CollectionSolutions {

	private Solution collection_of_solutions[];
	private int current_size;
	private int max_size;
	
	public CollectionSolutions(int size_max) {
		this.setMaxSize(size_max);
		this.setSize(0);
		this.collection_of_solutions = new Solution[this.getMaxSize()];
	}
	
	public Solution[] getCollectionOfSolutions() {
		return collection_of_solutions;
	}
	
	public void setCollectionOfSolutions(Solution collection_of_solutions[]) {
		this.collection_of_solutions = collection_of_solutions;
	}
	
	public Solution getSolutionInCollection(int i) {
		return this.collection_of_solutions[i];
	}
	
	public void addSolutionInCollection(int i, Solution s, Problem p) {
		this.collection_of_solutions[i].copyValuesSolution(s, p);
	}
	
	public void setSolutionInCollection(int i, Solution s, Problem p) {
		this.collection_of_solutions[i] = s;
	}
	
	public int getSize() {
		return current_size;
	}
	
	public void setSize(int size) {
		this.current_size = size;
	}
	
	public int getMaxSize() {
		return max_size;
	}
	
	public void setMaxSize(int max_size) {
		this.max_size = max_size;
	}
	
}
