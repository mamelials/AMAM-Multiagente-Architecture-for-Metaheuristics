package Reinforcement_Learning;

import java.io.IOException;
import java.util.Random;

import Environment.Problem;
import Environment.Solution;
import Function_Package.WriterInFile;
import Genetic_Algorithm.Population;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Elements of Reinforcement Learning.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class QLearning {
	
	private int q_size;
	private double alpha;
	private double gamma;
	private double q[][];
	//private double q_stateless[];
	private double epsilon;
	
	private int current_state;
	
	public QLearning(int q_size, double gamma, double alpha, double epsilon) {
		// TODO Auto-generated constructor stub
		
		this.q_size = q_size;
		this.gamma = gamma;
		this.alpha = alpha;
		q = new double[this.q_size][this.q_size];
		this.epsilon = epsilon;
		//initializeQNull(); //apenas para teste
		initializeQSpecific(); //atribui valores a sequência i - i
		//initializeQBestSolution();
	}
	
	public void initializeQNull() {
		for(int i = 0; i < this.q_size; i++) {
			for(int j = 0; j < this.q_size; j++) {
				q[i][j] = 0;
			}
		}
	}
	
	public void initializeQSpecific() {
		for(int i = 0; i < this.q_size; i++) {
			for(int j = 0; j < this.q_size; j++) {
				//if(i != j) 
					q[i][j] = 0;
				//else
					//q[i][j] = -200;
				//if(j == 0) {
					//q[i][j] = 50;
				//}
			}
		}
		//q[0][0] = 50;
		//q[this.q_size-1][this.q_size-1] = -200;
	}
	
	/*public void initializeQBestSolution() {
		
	}*/
	
	public void initializeQSpecificTest() {
		
		this.q[0][0] = 1892;
		this.q[0][1] = 1894; 
		this.q[0][2] = 173;

		this.q[1][0] = 1903;
		this.q[1][1] = 1893;
		this.q[1][2] = 0;
		
		this.q[2][0] = 1867;
		this.q[2][1] = 1859;
		this.q[2][2] = 0;
	}
	
	public void initializeQSpecific(double q_specific[][]) {
		for(int i = 0; i < this.q_size; i++) {
			for(int j = 0; j < this.q_size; j++) {
				q[i][j] = q_specific[i][j];
			}
		}
	}
	
	public void episode(int initial_state, Solution s, double r, int type) {
	
		int state, next_state;		
		Solution s_line = s;
		state = initial_state;
		
		this.setCurrentState(initial_state);
		
		while(s_line.getFitnessFunction() <= s.getFitnessFunction()) {
			
			next_state = chooseAnAction(initial_state, type);
			
			double q_value = this.q[state][next_state];
			
			double maxQ = maxActionQ(next_state);
			
			//r = ;//função fitness resultante da aplicação da estrutura do estado a qual a ação leva
			
			double value = q_value + this.alpha * (r + this.gamma * maxQ - q_value);
			q[state][next_state] = value;
		}
		
	}
	
	public int chooseAnAction(int action, int type) {
		
		int next_action = 0;
		
		if(type == 1) { //epsilon greedy
			next_action = this.epsiloGreedy(action);
		}
		else if(type == 2) { //random
			next_action = this.randomAction();
		}
		//else
			//implementar outras formas de escolha da solução
		
		return next_action;
	}
	
	public int epsiloGreedy(int current_action) {
		int action;
		Random generator = new Random();
		double random = generator.nextDouble();
		
		if(random <= this.epsilon) {
			action = generator.nextInt(this.q_size);
		}
		else {
			action = maxActionQ(current_action);
		}
		
		return action;
	}
	
	public int randomAction() {
		int action;
		
		Random generator = new Random();
		action = generator.nextInt(this.getQSize());
		
		return action;
	}
	
	public void calculateQValue(int action, int next_action, double r) {
		
		double q_value = this.q[action][next_action];
		double maxQ = q[next_action][maxActionQ(next_action)];
		
		q[action][next_action] = q_value + this.alpha * (r + this.gamma * maxQ - q_value);
	}
	
	/*public void calculateQValueStateless(int state, int next_state, double r) {
		
		double q_value = this.q[state][next_state];
		double maxQ = q[next_state][maxActionQ(next_state)];
		
		.. q[state][next_state] = q_value + this.alpha * (r + this.gamma * maxQ - q_value);
	}*/
	
	public int maxActionQ(int current_action) {
		Random generator = new Random();
		int greater_action = 0;
		double greater_q = this.q[current_action][0];
		
		for(int i = 1; i < this.q_size; i++) {
			if(this.q[current_action][i] > greater_q) {
				greater_q = this.q[current_action][i];
				greater_action = i;
			}
			//se for igual escolhe uma aleatória
			if(this.q[current_action][i] == greater_q) {
				double rand = generator.nextDouble();
				if(rand <= 0.5) {
					greater_q = this.q[current_action][i];
					greater_action = i;
				}
			}
		}
		
		return greater_action;
	}
	
	public void maxMin(Population pop, Problem p) {
		
		double fitness, min, max;
		if(p.getDimension() > 1) {
			min = pop.getPopulationI(pop.minMonoFitness(p)).getFitnessFunction();
			max = pop.getPopulationI(pop.maxMonoFitness(p)).getFitnessFunction();
			for(int i = 0; i < pop.getSize(); i++) {
				double sub = max - min;
				if(sub != 0) {
					fitness = (pop.getPopulationI(i).getFitnessFunction() - min) / sub;
					fitness = 1 - fitness;
				}
				else {
					fitness = 0;
				}
				pop.getPopulationI(i).setFitnessLearning(fitness);
			}
		}
		else {
			min = pop.getPopulationI(pop.minMonoOF()).getObjectiveFunctionI(0);
			max = pop.getPopulationI(pop.maxMonoOF()).getObjectiveFunctionI(0);
			
			for(int i = 0; i < pop.getSize(); i++) {
				double sub = max - min;
				if(sub != 0) {
					fitness = (pop.getPopulationI(i).getObjectiveFunctionI(0) - min) / sub;
					fitness = 1 - fitness;
				}
				else {
					fitness = 0;
				}
				pop.getPopulationI(i).setFitnessLearning(fitness);
			}
		}
	}
	
	public int sequenceQMatrix(int i, int previous, boolean improved) {
		int next;
		int larger_pos = -1;
		double larger = -1;
		
		if(improved == true) {  //  greatest value q
			larger_pos = 0;
			larger = q[i][0];
			for(int j = 0; j < this.q_size; j++) {
				if(q[i][j] > larger) {
					larger = q[i][j];
					larger_pos = j;
				}
			}
			next = larger_pos;
		}
		else {  //  the largest less than j
			for(int j = 0; j < this.q_size; j++) {
				if(q[i][j] < q[i][previous]) {
					if(larger == -1) {
						larger_pos = j;
						larger = q[i][j];
					}
					else {
						if(q[i][j] > larger) {
							larger = q[i][j];
							larger_pos = j;
						}
					}
				}
			}
			next = larger_pos;
		}
		return next;
	}
	
	public void showQMatrix() {
		System.out.println("\n\nMatrix Q");
		for(int i = 0; i < this.q_size; i++) {
			for(int j = 0; j < this.q_size; j++) {
				System.out.print(q[i][j] + " - ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void writeQMatrix(WriterInFile fw) throws IOException {
		fw.writerTextFile("\n\n  *** Q Matrix ***");
		for(int i = 0; i < this.q_size; i++) {
			for(int j = 0 ; j < this.q_size; j++) {
				fw.writerTextFileWithoutLine(q[i][j] + "	");
			}
			fw.writerNewLine();
		}
	}
	
	public int getCurrentState() {
		return current_state;
	}

	public void setCurrentState(int current_state) {
		this.current_state = current_state;
	}

	public int getQSize() {
		return q_size;
	}

	public void setQSize(int q_size) {
		this.q_size = q_size;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getGamma() {
		return gamma;
	}

	public void setGamma(double gamma) {
		this.gamma = gamma;
	}

	public double[][] getQ() {
		return q;
	}

	public void setQ(double q[][]) {
		this.q = q;
	}

	public double getQij(int i, int j) {
		return q[i][j];
	}

	public void setQi(double q, int i, int j) {
		this.q[i][j] = q;
	}
	
	public double getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	/*public double[] getQStateless() {
		return q_stateless;
	}

	public void setQStateless(double q_stateless[]) {
		this.q_stateless = q_stateless;
	}

	public double getQStatelessI(int i) {
		return q_stateless[i];
	}

	public void setQStatelessI(double q_stateless, int i) {
		this.q_stateless[i] = q_stateless;
	}*/
}
