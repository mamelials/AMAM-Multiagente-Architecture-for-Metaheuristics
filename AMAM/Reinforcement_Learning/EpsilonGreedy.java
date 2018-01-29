package Reinforcement_Learning;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Elements of Reinforcement Learning.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class EpsilonGreedy {

	private double epsilon;

	public int getAction(double e_decay_rate, int current_episode) {
		float random = 1; 
		if (random <= this.getEpsilon(e_decay_rate, current_episode)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public double getEpsilon(double e_decay_rate, int current_episode) {
		this.epsilon = 1 * Math.pow(e_decay_rate, current_episode);
		return epsilon;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}
	
	
}
