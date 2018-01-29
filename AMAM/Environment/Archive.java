package Environment;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class responsible for defining solution archives.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class Archive extends CollectionSolutions{
	
	public Archive(int size_max) {
		super(size_max);
		// TODO Auto-generated constructor stub
	}
	
	public void updateArchive(Solution s, Problem p) {
		this.addSolutionInCollection(this.getSize(), s, p);
	}
	
	//returns the first solution unvisited found 
	//or null if not found unvisited solution
	public Solution pickArchive() {
		Solution s = null;
		int size = this.getSize();
		
		for(int i = 0; i < size; i++) {
			if(!(this.getSolutionInCollection(i).isVisited())){
				return s;
			}
		}
		return s;
	}

}
