package MultiObjective;

import Environment.Problem;
import Environment.Solution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that extends MultiObjectiveFitness Class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class NSGA2Fitness extends MultiObjectiveFitness{

	@Override
	public double calculateFitness(Problem p, Solution s) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void evaluateFitnessNSGA2(Population pop, int alpha, int receiver_size, Problem p) {
		
		// - Classificação - 
		Population new_pop = new Population(pop.getSize(), pop.getMaxSize(), receiver_size, p);
		new_pop.copyPopulation(pop, p);
		Population boundary = new Population(pop.getSize(), pop.getMaxSize(), receiver_size, p);
		
		int id_boundary = 1;
		int count = 0, pareto_size;
		int pareto[] = new int[pop.getSize()];
		
		pop.showFOPopulation(p);
		
		while(new_pop.getSize() != 0) {
			//encontra os elementos da fronteira
			pareto = new_pop.identifyParetoNSGA2(receiver_size, p);
			
			pareto_size = 0;
			//atribui classificação à fronteira
			for(int i = 0; i < new_pop.getSize(); i++) {
				if(pareto[i] == 1) {
					pareto_size++;
				}
			}
			int ind_pareto[] = new int[pareto_size];
			int k = 0;
			for(int i = 0; i < new_pop.getSize(); i++) {
				if(pareto[i] == 1) {
					ind_pareto[k] = i;
					k++;
				}
			}
			for(int i = 0; i < pareto_size; i++) {
				boundary.setSolutionInPopulation(count, new_pop.getSolutionInPopulation(ind_pareto[i]), p);
				boundary.getSolutionInPopulation(count).setFitnessFunction(id_boundary);;
				count++;
			}
			boundary.showFOPopulation(p);
			
			//atualizar a população
			int pos;
			for(int i = 0; i < pareto_size; i++) {
				pos = ind_pareto[i];
				if(i != 0) {
					pos = pos - i;
				}
				new_pop.eliminatesIndividualI(pos, p);
				new_pop.setSize(new_pop.getSize() - 1);
			}
			new_pop.showFOPopulation(p);
			
			id_boundary++;
		}
		
		// - Normalização - 
		double rank[] = new double[boundary.getSize()];
		rank = boundary.copyVectorFitness(boundary);
		//Normaliza os valores de r(i) para o intervalo unitário e transformado para maximização
	    double rank_min = rank[boundary.min(rank, boundary.getSize())];
	    double rank_max = rank[boundary.max(rank, boundary.getSize())];
	    double r_max[] = new double[boundary.getSize()];
	    for(int i = 0; i < boundary.getSize(); i++) {
	    	rank[i] = (rank[i] - rank_min) / (rank_max - rank_min);
	    	r_max[i] = 1 - rank[i];
	    }
	    
	    //escalonamento - se alpha = 1, escalonamento linear
	    double delta[] = new double[boundary.getSize()];
	    for(int i = 0; i < boundary.getSize(); i++) {
	    	delta[i] = Math.pow(r_max[i], alpha);
	    }
	    
	    //caso o escalonamento não seja linear (alpha > 1), normaliza os valores novamente
	    double delta_max = delta[boundary.max(delta, boundary.getSize())];
	    double fitness[] = new double[boundary.getSize()];
	    for(int i = 0; i < boundary.getSize(); i++) {
	    	fitness[i] = delta[i] / delta_max;
	    	pop.getSolutionInPopulation(i).setFitnessFunction(fitness[i]);
	    }  
	}
	
	public Population updateFileNSGA2(Population pop, Population file, int size_file_max, int receiver_size, Problem p) {
		//une a população corrente com o arquivo já existente para idenficar 
		//os pontos de pareto da população corrente
		int total_size = pop.getSize() + file.getSize();
		Population currente_file = new Population(total_size, size_file_max, receiver_size, p);
		
		for(int i = 0; i < pop.getSize(); i++) {
			currente_file.setSolutionInPopulation(i, pop.getSolutionInPopulation(i), p);
		}
		int c = pop.getSize();
		for (int i = 0; i < file.getSize(); i++) {
			currente_file.setSolutionInPopulation(c, file.getSolutionInPopulation(i), p);
			c++;
		}
		currente_file.showPopulation(p);
		
		//identifica o pareto da população corrente
		currente_file = currente_file.identifyPareto(receiver_size, p);
		
		//verifica o tamanho do arquivo para possível redução
		if(currente_file.getSize() > size_file_max) {
		//reduz o arquivo ao tamanho máximo
			currente_file = this.reduceFileNSGA2(currente_file, size_file_max, receiver_size, p);
		}
		
		return currente_file;
	}
	
	public Population reducePopulationNSGA2(Population pop, int size_new_pop, int receiver_size, Problem p) {
		
		Population new_pop = new Population(size_new_pop, pop.getMaxSize(), receiver_size, p);
		int count = 1;
		int pareto[] = new int[pop.getSize()];
		
		while(size_new_pop < pop.getSize()) {
			int boundary[] = new int[pop.getSize()]; 
			boundary = pop.identifyParetoNSGA2(receiver_size, p);
			
			//atribui classificação à fronteira
			int pareto_size = 0;
			for(int i = 0; i < new_pop.getSize(); i++) {
				if(pareto[i] == 1) {
					pareto_size++;
				}
			}
			int ind_pareto[] = new int[pareto_size];
			int k = 0;
			for(int i = 0; i < new_pop.getSize(); i++) {
				if(pareto[i] == 1) {
					ind_pareto[k] = i;
					k++;
				}
			}
		}
		
		return new_pop;
	}
	
	public Population reduceFileNSGA2(Population file, int size_file_max, int receiver_size, Problem p) {
		
		Population new_file = new Population(size_file_max, size_file_max, receiver_size, p);
		double sigma_sh = Math.sqrt(p.getDimension()) / size_file_max;
		int current_size = file.getSize();    						//s
		Population aux = new Population(current_size, size_file_max, receiver_size, p);
		
		aux.copyPopulation(file, p);
		
		while (current_size > size_file_max) {
			
			//Normaliza fx
			double fx[][] = new double[current_size][p.getDimension()];
			fx = file.copyMatrixOF(aux, current_size, p.getDimension());
			
			double max_fx[] = new double[p.getDimension()];
			double min_fx[] = new double[p.getDimension()];
			for(int i = 0; i < p.getDimension(); i++) {
				max_fx[i] = fx[(int)file.maxColumn(fx, current_size, i)][i];
				min_fx[i] = fx[(int)file.minColumn(fx, current_size, i)][i];
			}
			
			for(int i = 0; i < current_size; i++) {
				for(int j = 0; j < p.getDimension(); j++) {
		    		fx[i][j] = (fx[i][j] - min_fx[j]) / (max_fx[j] - min_fx[j]); 
		    	}
		    }
			
			//Calcula a matriz de distância
			double sub[] = new double[p.getDimension()];
			double distance[][] = new double[current_size][current_size];
			for(int i = 0; i < current_size; i++) {
				for(int j = i+1; j < current_size; j++) {
					double sum = 0;
					for(int k = 0; k < p.getDimension(); k++) {
						sub[k] = fx[i][k] - fx[j][k];
						sum = sum + (Math.pow(sub[k],2));
					}
					distance[i][j] = Math.sqrt(sum);
					distance[j][i] = distance[i][j];
				}
			}
			
			int k = (int)Math.sqrt(current_size);
			
			double c[] = new double[current_size];
			for(int i = 0; i < current_size; i++) {
				c[i] = this.sumSmallDistances(distance[i], current_size, i, k);
			}
			
			int pos_small = file.min(c, current_size);
			aux.eliminatesIndividualI(pos_small, p);
			
			current_size--;
			aux.setSize(current_size);
		}
		
		new_file.copyPopulation(aux, p);
		
		return new_file;
	}
	
	/* UTILITY */
	
	public double sumSmallDistances(double d[], int size, int i, int k) {

		double d_max[] = new double[size];
		double aux_small;
		int pos_small;
		int current_size = size;
		double small = 0;
		
		for(int j = 0; j < current_size; j++) {
			d_max[j] = d[j];
		}
		
		d_max = this.eliminatesElement(d_max, current_size, i);
		current_size--;
		
		for(int j = 0; j < k; j++) {
			aux_small = d_max[0];
			pos_small = 0;
			for(int l = 0; l < current_size; l++) {
				if(d_max[l] < aux_small) {
					aux_small = d_max[l];
					pos_small = l;
				}
			}
			small = small + aux_small;
			d_max = this.eliminatesElement(d_max, current_size, pos_small);
			current_size--;
		}
		
		return small;
	}
	
	public double[] eliminatesElement(double vector[], int size, int i) {
		double aux[] = new double[size-1];
		
		for(int j = 0; j < i; j++) {
			aux[j] = vector[j];
		}		
		for(int j = i; j < size-1; j++) {
			aux[j] = vector[j+1];
		}
		
		return aux;
	}
	
}
