package Parameters;

import Environment.Element;
import Environment.Solution;
import Environment_Movements.MovementList;
import Function_Package.WriterInFile;
import Reinforcement_Learning.QLearning;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Experiments parameters.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class MethodParameters {

	private Element element;      		//elementos específicos do problema

	//Metaheuristics
	private String mth_type;      		//método implementada
	private String stop_cond_type;     	//tipo de condição de parada do método
	private String accept_crit_type;	//tipo de critério de aceitação do método
	private int max_iterations; 
	private int max_levels_perturbation;
	
	//Construction
	private String constr_type;   		//contrução utilizada pelo método
	private int rcl_size;				//tamanho da lista restrita de candidatos
	private int portion_size;
	
	//LocalSearch
	private String ls_type;       		//busca local utilizada pelo metódo
	private int neighborhood_size; 		//número de 
	private MovementList movement_list;

	
	//Reforcement Learning
	private QLearning q_learning;
	//private int q_size;
	//private double alpha;
	//private double gamma;
	//private double q[][];
	//private double epsilon;
	
	//Time
	private long initial_time;
	private int max_time;
	private long final_time;
	
	//Best method solution
	private Solution best_mtd_solution;
	
	//files
	private WriterInFile fw;
	private WriterInFile fw_reduced;
	private WriterInFile fw_st;
	private WriterInFile fw_final_tableQ;
	
	public Element getElement() {
		return element;
	}
	
	public void setElement(Element element) {
		this.element = element;
	}
	
	public String getMthType() {
		return mth_type;
	}
	
	public void setMthType(String mth_type) {
		this.mth_type = mth_type;
	}
	
	public String getStopCondType() {
		return stop_cond_type;
	}
	
	public void setStopCondType(String stop_cond_type) {
		this.stop_cond_type = stop_cond_type;
	}
	
	public String getAcceptCritType() {
		return accept_crit_type;
	}
	
	public void setAcceptCritType(String accept_crit_type) {
		this.accept_crit_type = accept_crit_type;
	}
	
	public int getMaxIterations() {
		return max_iterations;
	}
	
	public void setMaxIterations(int max_iterations) {
		this.max_iterations = max_iterations;
	}
	
	public int getMaxLevelsPerturbation() {
		return max_levels_perturbation;
	}
	
	public void setMaxLevelsPerturbation(int max_levels_perturbation) {
		this.max_levels_perturbation = max_levels_perturbation;
	}
	
	public String getConstrType() {
		return constr_type;
	}
	
	public void setConstrType(String constr_type) {
		this.constr_type = constr_type;
	}
	
	public int getRclSize() {
		return rcl_size;
	}
	
	public void setRclSize(int rcl_size) {
		this.rcl_size = rcl_size;
	}
	
	public int getPortionSize() {
		return portion_size;
	}
	
	public void setPortionSize(int portion_size) {
		this.portion_size = portion_size;
	}
	
	public String getLsType() {
		return ls_type;
	}
	
	public void setLsType(String ls_type) {
		this.ls_type = ls_type;
	}
	
	public int getNeighborhoodSize() {
		return neighborhood_size;
	}
	
	public void setNeighborhoodSize(int neighborhood_size) {
		this.neighborhood_size = neighborhood_size;
	}
	
	public MovementList getMovementList() {
		return movement_list;
	}
	
	public void setMovementList(MovementList movement_list) {
		this.movement_list = movement_list;
	}	
	
	public long getInitialTime() {
		return initial_time;
	}

	public void setInitialTime(long initial_time) {
		this.initial_time = initial_time;
	}

	/*
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

	public double getQIJ(int i, int j) {
		return q[i][j];
	}

	public void setQIJ(double q, int i, int j) {
		this.q[i][j] = q;
	}

	public double getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}*/

	public QLearning getQLearning() {
		return q_learning;
	}

	public void setQLearning(QLearning q_learning) {
		this.q_learning = q_learning;
	}

	public int getMaxTime() {
		return max_time;
	}

	public void setMaxTime(int max_time) {
		this.max_time = max_time;
	}

	public WriterInFile getFw() {
		return fw;
	}

	public void setFw(WriterInFile fw) {
		this.fw = fw;
	}

	public WriterInFile getFwReduced() {
		return fw_reduced;
	}

	public void setFwReduced(WriterInFile fw_reduced) {
		this.fw_reduced = fw_reduced;
	}

	public WriterInFile getFwSt() {
		return fw_st;
	}

	public void setFwST(WriterInFile fw_st) {
		this.fw_st = fw_st;
	}

	public WriterInFile getFwFinalTableQ() {
		return fw_final_tableQ;
	}

	public void setFwFinalTableQ(WriterInFile fw_final_tableQ) {
		this.fw_final_tableQ = fw_final_tableQ;
	}

	public Solution getBestMethodSolution() {
		return best_mtd_solution;
	}

	public void setBestMethodSolution(Solution best_mtd_solution) {
		this.best_mtd_solution = best_mtd_solution;
	}

	public long getFinalTime() {
		return final_time;
	}

	public void setFinalTime(long final_time) {
		this.final_time = final_time;
	}
	
}
