package MultiObjective;

import Environment.Problem;
import Environment.Solution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that extends MultiObjectiveFitness Class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class MOGAFitness extends MultiObjectiveFitness{

	@Override
	public double calculateFitness(Problem p, Solution s) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/* ---- MOGA ---- */
	
	//alpha - define se escalonamento é linear (alpha = 1) ou não (alpha > 1) 
	public void evaluateFitnessMOGA(Population pop, int alpha, int size_file, Problem p) {
		
		double fitness[] = new double[pop.getSize()];
		
		/*- Classificação -*/
		//determina a classificação de cada indivíduo da população
		pop.rankIndividuals(p);
		
		/*- Normalização -*/
		//normaliza os valores de r(i) para o intervalo unitário e transforma para maximização
		double min_rank = pop.getRankI(pop.min(pop.getRank(), pop.getSize()));
		double max_rank = pop.getRankI(pop.max(pop.getRank(), pop.getSize()));
		double rank_max[] = new double[pop.getSize()];		
		for(int i = 0; i < pop.getSize(); i++) {
			pop.setRank(i, (pop.getRankI(i) - min_rank) / (max_rank - min_rank));
			rank_max[i] = 1 - pop.getRankI(i);
		}
		//escalonamento, se alpha = 1 - escalonamento linear -- ATÉ AQUI --
		
		//caso o escalonamento não seja linear (alpha > 1), normaliza os valores novamente
		double delta[] = new double[pop.getSize()];
		for(int i = 0; i < pop.getSize(); i++) {
			delta[i] = Math.pow(rank_max[i], alpha); 
		}
	
		double max_delta = delta[pop.max(delta, pop.getSize())];
		for(int i = 0; i < pop.getSize(); i++) {
			fitness[i] = delta[i] / max_delta;
		}
		
		/*- Técnicas de Nicho -*/
		//Uma forma de priorizar uma melhor distribuic~ao da populac~ao sobre a fronteira Pareto-otima
		//A função de aptidão de cada indivíduo é degradada com base na função de partilha
		
		//Normaliza Fx
		double fx[][] = new double[pop.getSize()][p.getDimension()];
		fx = pop.copyMatrixOF(pop, pop.getSize(), p.getDimension());
		
		double max_fx[] = new double[p.getDimension()];
		double min_fx[] = new double[p.getDimension()];
		for(int i = 0; i < p.getDimension(); i++) {
			max_fx[i] = fx[(int)pop.maxColumn(fx, pop.getSize(), i)][i];
			min_fx[i] = fx[(int)pop.minColumn(fx, pop.getSize(), i)][i];
		}
		
		for(int i = 0; i < pop.getSize(); i++) {
			for(int j = 0; j < p.getDimension(); j++) {
	    		fx[i][j] = (fx[i][j] - min_fx[j]) / (max_fx[j] - min_fx[j]); 
	    	}
	    }
		
		//Calcula a matriz de distância
		double sub[] = new double[p.getDimension()];
		double distance[][] = new double[pop.getSize()][pop.getSize()];
		for(int i = 0; i < pop.getSize(); i++) {
			for(int j = i+1; j < pop.getSize(); j++) {
				double sum = 0;
				for(int k = 0; k < p.getDimension(); k++) {
					sub[k] = fx[i][k] - fx[j][k];
					sum = sum + (Math.pow(sub[k],2));
				}
				distance[i][j] = Math.sqrt(sum);
				distance[j][i] = distance[i][j];
			}
		}
		
		//Calcula sigma_sh - raiz de m (maior diagonal do hipercubo) dividido por X (tamanho máximo do arquivo)
		double sigma_sh;
		sigma_sh = (Math.sqrt(p.getDimension())/size_file);
		
		//Calcula a matriz s_d(i,j)
		double s[][] = new double[pop.getSize()][pop.getSize()];		
		for(int i = 0; i < pop.getSize(); i++) {
			for (int j = i; j < pop.getSize(); j++) {
				if(distance[i][j] > sigma_sh) {
					s[i][j] = 0;
					s[j][i] = s[i][j];
				}
				else {
					s[i][j] = 1 - (Math.pow((distance[i][j]/sigma_sh), alpha));
					s[j][i] = s[i][j];
				}
			}
		}
		
		//Calcula o vetor sh
		double sh[] = new double[pop.getSize()];
		for(int i = 0; i < pop.getSize(); i++) {
			sh[i] = 0;
			for(int j = 0; j < pop.getSize(); j++) {
				sh[i] = sh[i] + s[i][j];
			}
		}
		
		//Função de Aptidão degradada
		for(int i = 0; i < pop.getSize(); i++) {
			pop.getSolutionInPopulation(i).setFitnessFunction(fitness[i] / sh[i]);
		}
		
		System.out.println("");
	}
	
	public Population updateFileMOGA(Population pop, Population file, int size_file_max, int receiver_size, Problem p) {
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
		//currente_file.showPopulation(p);
		
		//identifica o pareto da população corrente
		currente_file = currente_file.identifyPareto(receiver_size, p);
		
		//verifica o tamanho do arquivo para possível redução
		if(currente_file.getSize() > size_file_max) {
			//reduz o arquivo ao tamanho máximo
			currente_file = this.reduceFileMOGA(currente_file, size_file_max, receiver_size, p);
		}
		
		return currente_file;
	}
		
	public Population reduceFileMOGA(Population file, int size_file_max, int receiver_size, Problem p) {
		
		Population new_file = new Population(size_file_max, size_file_max, receiver_size, p);
		double sigma_sh = Math.sqrt(p.getDimension()) / size_file_max;
		int current_size = file.getSize();
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
			
			//Calcula o vetor c
			double c[] = new double[current_size];
			for(int i = 0; i < current_size; i++) {
				c[i] = 0;
				for(int j = 0; j < current_size; j++) {
					if(distance[i][j] < sigma_sh) {
						c[i]++;
					}
				}
			}
			
			//Elimina o indivíduo com pior c
			int pos_larger = file.max(c, current_size);
			aux.eliminatesIndividualI(pos_larger, p);
			
			current_size--;
			aux.setSize(current_size);
		}
		
		new_file.copyPopulation(aux, p);
		
		return new_file;
	}

}
