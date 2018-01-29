package MultiObjective;

import Environment.CollectionSolutions;
import Environment.Problem;
import Environment.Solution;
import Factorys.SolutionFactory;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Multi-objective problem element.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class Population extends CollectionSolutions{
	
	/* ATTRIBUTES */
	//private Solution population[];
	//private int population_size;
	private double rank[];
	
	public Population(int pop_size, int size_max, int receiver_size, Problem p) {
		super(size_max);
		// TODO Auto-generated constructor stub
		
		this.setSize(pop_size);
		this.setRank(new double[this.getSize()]);
		SolutionFactory solution_factory = new SolutionFactory();
		for(int i = 0; i < this.getSize(); i++) {
			this.setSolutionInPopulation(i, solution_factory.createSolution(receiver_size, p), p);
		}
	}
	
	public int dominanceRelation(double a[], double b[], int size) {
	//If a dominates b, then result is -1;
	//If a and b are nondominated vectors, then result is 0;
	//If a is dominated by b, then result is +1;
		
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(a[i] == b[i]) {
				count = count + 1;
			}
		}
		if(count == size)
			return 0;
		
		count = 0;
		for(int i = 0; i < size; i++) {
			if(a[i] < b[i]) {
				count = count + 1;
			}
		}
		if(count == size)
			return -1;
		
		count = 0;
		for(int i = 0; i < size; i++) {
			if(b[i] < a[i]) {
				count = count + 1;
			}
		}
		if(count == size)
			return 1;
		else
			return 0; 
	}
	
	public int dominanceRelationMin(double a[], double b[], int dimension) {
		/*
		 * If a dominates b, then result is -1;
		 * If a and b are nondominated vectors, then result is 0;
		 * If a is dominated by b, then result is +1;
		 */
		
		int count1 = 0, count2 = 0;
		
		for(int i = 0; i < dimension; i++) {
			if(a[i] == b[i]) {
				count1++;
			}
			else if(a[i] < b[i]){
				count2++;
			}
		}
		
		if(count1 == dimension) {
			return 0;
		}
		else if(count2 == dimension){
			return -1; 
		}
		else if(count2 == 0){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	public int dominanceRelationMax(double a[], double b[], int dimension) {
		/*
		 * If a dominates b, then result is -1;
		 * If a and b are nondominated vectors, then result is 0;
		 * If a is dominated by b, then result is +1;
		 */
		
		int count1 = 0, count2 = 0;
		
		for(int i = 0; i < dimension; i++) {
			if(a[i] == b[i]) {
				count1++;
			}
			else if(a[i] > b[i]){
				count2++;
			}
		}
		
		if(count1 == dimension) {
			return 0;
		}
		else if(count2 == dimension){
			return -1; 
		}
		else if(count2 == 0){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	public void rankIndividuals(Problem p) {
		int count, result;
		double a[] = new double[p.getDimension()];
		double b[] = new double[p.getDimension()];
		
		for(int i = 0; i < this.getSize(); i++) {
			count = 1;
			a = this.copyVectorOF(this.getSolutionInPopulation(i), p.getDimension());
			for(int j = 0; j < this.getSize(); j++) {
				if(i != j) {
					b = this.copyVectorOF(this.getSolutionInPopulation(j), p.getDimension());
					if(p.getProblemType(0) == "min") {
						result = this.dominanceRelationMin(b, a, p.getDimension());
					}
					else {
						result = this.dominanceRelationMax(b, a, p.getDimension());
					}
					if(result == -1) {
						count = count + 1;
					}
				}
			}
			this.rank[i] = count;
		}
	}
	
	public Population identifyPareto(int receiver_size, Problem p) {
		int count_pareto = 0;
		int count, result;
		double a[] = new double[p.getDimension()];
		double b[] = new double[p.getDimension()];
		Population pareto = new Population(this.getSize(), this.getMaxSize(), receiver_size, p);
		
		//compara um ponto com todos os outros - verificando dominância
		for(int i = 0; i < this.getSize(); i++) {
			count = 1;                   //1 se o ponto é não dominado
			a = this.copyVectorOF(this.getSolutionInPopulation(i), p.getDimension());
			for(int j = 0; j < this.getSize(); j++) {
				if(i != j) {
					b = this.copyVectorOF(this.getSolutionInPopulation(j), p.getDimension());
					if(p.getProblemType(0) == "min") {
						result = this.dominanceRelationMin(b, a, p.getDimension());
					}
					else {
						result = this.dominanceRelationMax(b, a, p.getDimension());
					}
					if(result == 1) {
						count = 0;       //se não é pareto cont recebe 0
					}
				}
			}
			
			//se um ponto não é dominado
			if(count == 1) {
				//É PONTO DO PARETO
				pareto.getSolutionInPopulation(count_pareto).copyValuesSolution(this.getSolutionInPopulation(i), p);
				count_pareto++;
			}
		}
		pareto.setSize(count_pareto);
		Population new_pareto = new Population(count_pareto, this.getMaxSize(), receiver_size, p);
		new_pareto.copyPopulation(pareto, p);
		return new_pareto;
	}	
	
	public int[] identifyParetoNSGA2(int receiver_size, Problem p) {
		int count, result;
		double a[] = new double[p.getDimension()];
		double b[] = new double[p.getDimension()];
		int pareto[] = new int[this.getSize()];
		
		for(int i = 0; i < this.getSize(); i++) {
			pareto[i] = 0;
		}
		
		//compara um ponto com todos os outros - verificando dominância
		for(int i = 0; i < this.getSize(); i++) {
			count = 1;                   //1 se o ponto é não dominado
			a = this.copyVectorOF(this.getSolutionInPopulation(i), p.getDimension());
			for(int j = 0; j < this.getSize(); j++) {
				if(i != j) {
					b = this.copyVectorOF(this.getSolutionInPopulation(j), p.getDimension());
					if(p.getProblemType(0) == "min") {
						result = this.dominanceRelationMin(b, a, p.getDimension());
					}
					else {
						result = this.dominanceRelationMax(b, a, p.getDimension());
					}
					if(result == 1) {
						count = 0;       //se não é pareto cont recebe 0
					}
				}
			}
			
			//se um ponto não é dominado
			if(count == 1) {
				//É PONTO DO PARETO
				pareto[i] = 1;
			}
		}
		
		return pareto;
	}
	
	/* UTILITY */
	public void eliminatesIndividualI(int i, Problem p) {
		for(int j = i; j < this.getSize()-1; j++) {
			this.setSolutionInPopulation(j, this.getSolutionInPopulation(j+1), p);
		}
	}
	
	public int min(double vector[], int size_vector) {
		double m[] = new double[2]; 
		m[0] = vector[0];
		m[1] = 0;
		for(int i = 1; i < size_vector; i++) {
			if(vector[i] < m[0]) {
				m[0] = vector[i];
				m[1] = i;
			}
		}
		return (int) m[1];
	}
	
	public int max(double vector[], int size_vector) {
		double m[] = new double[2]; 
		m[0] = vector[0];
		m[1] = 0;
		for(int i = 1; i < size_vector; i++) {
			if(vector[i] > m[0]) {
				m[0] = vector[i];
				m[1] = i;
			}
		}
		return (int) m[1];
	}

	public int minColumn(double matrix[][], int size, int col) {
		double m[] = new double[2]; 
		m[0] = matrix[0][col];
		m[1] = 0;
		for(int i = 1; i < size; i++) {
			if(matrix[i][col] < m[0]) {
				m[0] = matrix[i][col];
				m[1] = i;
			}
		}
		return (int) m[1];
	}
	
	public int maxColumn(double matrix[][], int size, int col) {
		double m[] = new double[2]; 
		m[0] = matrix[0][col];
		m[1] = 0;
		for(int i = 1; i < size; i++) {
			if(matrix[i][col] > m[0]) {
				m[0] = matrix[i][col];
				m[1] = i;
			}
		}
		return (int) m[1];
	}
	
	public double[] copyVectorOF(Solution s, int dimension) {
		double b[] = new double[dimension];
		for(int i = 0; i < dimension; i++) {
			b[i] = s.getObjectiveFunctionI(i);
		}
		return b;
	}
	
	public double[][] copyMatrixOF(Population pop, int pop_size, int dimension) {
		double b[][] = new double[pop_size][dimension];
		for(int i = 0; i < pop_size; i++) {
			for(int j = 0; j < dimension; j++) {
				b[i][j] = pop.getSolutionInPopulation(i).getObjectiveFunctionI(j);
			}
		}
		return b;
	}
	
	public double[] copyVectorFitness(Population pop) {
		double b[] = new double[pop.getSize()];
		for(int i = 0; i < pop.getSize(); i++) {
			b[i] = pop.getSolutionInPopulation(i).getFitnessFunction();
		}
		return b;
	}
	
	public void showPopulation(Problem p) {
		System.out.println("\n\n****** POPULATION ******");
		for(int i = 0; i < this.getSize(); i++) {
			System.out.println("\n\nIndivíduo " + i );
			System.out.print("Rank: " + this.rank[i]);
			this.getSolutionInPopulation(i).showSolution(p);
		}
	}
	
	public void showFOPopulation(Problem p) {
		System.out.println("\n\n****** POPULATION ******");
		for(int i = 0; i < this.getSize(); i++) {
			System.out.println("\n\nIndivíduo " + i );
			for(int j = 0; j < p.getDimension(); j++) {
				System.out.println("Objective Function " + j + ": " + this.getSolutionInPopulation(i).getObjectiveFunctionI(j));
			}
			System.out.println("Fitness Function: " + this.getSolutionInPopulation(i).getFitnessFunction());
		}
	}
	
	public void copyPopulation(Population pop,  Problem p) {
		this.setSize(pop.getSize());
		for(int i = 0; i < this.getSize(); i++) {
			this.rank[i] = pop.getRankI(i);
			this.getSolutionInPopulation(i).copyValuesSolution(pop.getSolutionInPopulation(i), p);
		}
	}
	
	/* SETS AND GETS */
	
	public Solution getSolutionInPopulation(int i) {
		return this.getSolutionInPopulation(i);
	}
	
	public void setSolutionInPopulation(int i, Solution s, Problem p) {
		this.getSolutionInPopulation(i).copyValuesSolution(s, p);;
	}

	public double[] getRank() {
		return rank;
	}

	public void setRank(double rank[]) {
		this.rank = rank;
	}
	
	public double getRankI(int i) {
		return rank[i];
	}

	public void setRank(int i, double rank) {
		this.rank[i] = rank;
	}

}
