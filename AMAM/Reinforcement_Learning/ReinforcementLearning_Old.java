package Reinforcement_Learning;

import java.util.Random;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Elements of Reinforcement Learning.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class ReinforcementLearning_Old {

	private double experience_reinforce[][]; //w(i,j) = w(i,j) + reinforcement
	//private double reinforcement_factor1; //the agent improves its best found solution
	//private double reinforcement_factor2; //the agent improves the best know solution 
	
	private double roulette[];
	private double roulette_total;
	private double total[];
	private double fraction_roulette[];
	private double weight;
	private int k;
	private int k_1;
	private int max_roulette;
	
	public ReinforcementLearning_Old(int max) {
		
		double aux;
		
		this.roulette_total = 100;
		
		this.setTotal(new double[max]);
		for(int i = 0; i < max; i++) {
			this.total[i] = 100;
		}
		
		double percentage = this.roulette_total/(max-1);
		this.setMaxRoulette(max);
		
		this.setRoulette(new double[max]);
		this.setFractionRoulette(new double[max]);
		
		for(int i = 0; i < max; i++) {
			aux = (percentage * (i+1));
			this.setRouletteI(i, aux);
			this.setFractionRouletteI(percentage, i);
		}
		
		this.setExperienceReinforce(new double[max][max]);
		
		for(int i = 0; i < max; i++) {
			for(int j = 0; j < max; j++) {
				if(i != j){
					if(j < i) 
						aux = (percentage * (j+1));
					else
						aux = (percentage * (j));
				}
				else
					if(j == 0)
						aux = 0;
					else
						aux = this.getExperienceReinforceIJ(i, j-1);
				this.setExperienceReinforceIJ(aux, i, j);
			}
		}
		
		this.weight = this.getRouletteTotal() / 20; // 5% do total inicial
	}
	
	public void updateExperienceReinforce(int i, int j) {
	
		this.setTotalI(this.getRouletteTotal() + this.getWeight(), i);
		
		for(int l = j; l < this.getMaxRoulette(); l++) {
			this.setExperienceReinforceIJ((this.getExperienceReinforceIJ(i, l) + this.getWeight()), i, l);
		}
		
	}
	
	public void updateRoulette(int i) {
		
		this.setFractionRouletteI((this.getFractionRouletteI(i) + this.getWeight()), i);
		this.setRouletteTotal(this.getRouletteTotal() + this.getWeight());
		
		for(int j = i; j < this.getMaxRoulette(); j++) {
			this.setRouletteI(j, (this.getRouletteI(j) + this.getWeight()));
		}
		
	}
	
	public int rouletteWheelRL(int i) {
		
		Random generator = new Random();
		
		double value_rl;
		
		value_rl = generator.nextFloat() * this.getTotalI(i);
		
		int pos = 0;
		int j = 0;
		while (this.experience_reinforce[i][j] <= value_rl) {
			pos = j + 1;
			j++;
		}
		return pos;
	
	}
	
	public int rouletteWheel() {
		
		Random generator = new Random();
		
		double value_roulette;
		
		value_roulette = generator.nextFloat() * this.getRouletteTotal();
		
		int pos = 0;
		int i = 0;
		while (roulette[i] <= value_roulette) {
			pos = i + 1;
			i++;
		}
		return pos;
	
	}
	
	public double[] getRoulette() {
		return roulette;
	}

	public void setRoulette(double roulette[]) {
		this.roulette = roulette;
	}
	
	public double getRouletteI(int i) {
		return roulette[i];
	}

	public void setRouletteI(int i, double value) {
		this.roulette[i] = value;
	}

	public double[][] getExperienceReinforce() {
		return experience_reinforce;
	}

	public void setExperienceReinforce(double experience_reinforce[][]) {
		this.experience_reinforce = experience_reinforce;
	}

	public double getExperienceReinforceIJ(int i, int j) {
		return experience_reinforce[i][j];
	}

	public void setExperienceReinforceIJ(double reinforce, int i, int j) {
		this.experience_reinforce[i][j] = reinforce;
	}

	public double[] getFractionRoulette() {
		return fraction_roulette;
	}

	public void setFractionRoulette(double fraction_roulette[]) {
		this.fraction_roulette = fraction_roulette;
	}
	
	public double getFractionRouletteI(int i) {
		return fraction_roulette[i];
	}

	public void setFractionRouletteI(double fraction, int i) {
		this.fraction_roulette[i] = fraction;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getRouletteTotal() {
		return roulette_total;
	}

	public void setRouletteTotal(double routette_total) {
		this.roulette_total = routette_total;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getMaxRoulette() {
		return max_roulette;
	}

	public void setMaxRoulette(int max_roulette) {
		this.max_roulette = max_roulette;
	}

	public int getK_1() {
		return k_1;
	}

	public void setK_1(int k_1) {
		this.k_1 = k_1;
	}

	public double[] getTotal() {
		return total;
	}

	public void setTotal(double total[]) {
		this.total = total;
	}
	
	public double getTotalI(int i) {
		return total[i];
	}

	public void setTotalI(double total, int i) {
		this.total[i] = total;
	}
	
}
