package Parameters;

import Function_Package.WriterInFile;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Experiments parameters.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class ExperimentParameters {
	
	private String instance_name;
	private String problem_description;
	private int problem_dimension;
	private String problem_type[];
	private int executions_number;
	
	//Melhor solução conhecida
	private double best_of;
	private int best_aux;
	
	private long initial_time_execution;
	private int n_try;
	
	private int number_of_methods;
	
	private String method_parameters_files[];	
	
	//private WriterInFile fw;
	//private WriterInFile fw_reduced;
	//private WriterInFile fw_st;
	private WriterInFile fw_pool;
	private WriterInFile fw_best_solution;
	//private WriterInFile fw_final_tableQ;
	
	//Cooperation
	private String cooperation_type;
	private int receiver_size; 		//da solução
	private double radius_niche;
	private int max_size_pool;
		
	//Multiobjective
	private double gama_mo;
	
		
	public int getExecutionsNumber() {
		return executions_number;
	}
	
	public void setExecutionsNumber(int executions_number) {
		this.executions_number = executions_number;
	}
	
	public String getInstanceName() {
		return instance_name;
	}
	
	public void setInstanceName(String instance_name) {
		this.instance_name = instance_name;
	}
	
	public String getProblemDescription() {
		return problem_description;
	}

	public void setProblemDescription(String problem_description) {
		this.problem_description = problem_description;
	}
	
	public int getReceiverSize() {
		return receiver_size;
	}
	
	public void setReceiverSize(int receiver_size) {
		this.receiver_size = receiver_size;
	}
	
	public double getRadiusNiche() {
		return radius_niche;
	}

	public void setRadiusNiche(double radius_niche) {
		this.radius_niche = radius_niche;
	}

	public int getMaxSizePool() {
		return max_size_pool;
	}

	public void setMaxSizePool(int size_max_pool) {
		this.max_size_pool = size_max_pool;
	}
	
	public double getGamaMO() {
		return gama_mo;
	}

	public void setGamaMO(double gama) {
		this.gama_mo = gama;
	}
	
	
	/*public WriterInFile getFw() {
		return fw;
	}

	public void setFw(WriterInFile fw) {
		this.fw = fw;
	}

	public WriterInFile getFwReduced() {
		return fw_reduced;
	}

	public void setFwReduced(WriterInFile fwreduced) {
		this.fw_reduced = fwreduced;
	}*/

	public WriterInFile getFwPool() {
		return fw_pool;
	}

	public void setFwPool(WriterInFile fw_pool) {
		this.fw_pool = fw_pool;
	}

	/*public WriterInFile getFwFinalTableQ() {
		return fw_final_tableQ;
	}

	public void setFwFinalTableQ(WriterInFile fw_final_tableQ) {
		this.fw_final_tableQ = fw_final_tableQ;
	}*/
	
	/*public WriterInFile getFwST() {
		return fw_st;
	}

	public void setFwST(WriterInFile fw_st) {
		this.fw_st = fw_st;
	}*/
	

	public int getProblemDimension() {
		return problem_dimension;
	}

	public void setProblemDimension(int problem_dimension) {
		this.problem_dimension = problem_dimension;
	}

	public String getProblemTypeI(int i) {
		return problem_type[i];
	}

	public void setProblemTypeI(String problem_type, int i) {
		this.problem_type[i] = problem_type;
	}
	
	public String[] getProblemType() {
		return problem_type;
	}

	public void setProblemType(String problem_type[]) {
		this.problem_type = problem_type;
	}

	public int getNumberOfMethods() {
		return number_of_methods;
	}

	public void setNumberOfMethods(int number_of_methods) {
		this.number_of_methods = number_of_methods;
	}

	public String[] getMethodParametersFiles() {
		return method_parameters_files;
	}

	public void setMethodParametersFiles(String method_parameters_files[]) {
		this.method_parameters_files = method_parameters_files;
	}
	
	public String getMethodParametersFilesI(int i) {
		return method_parameters_files[i];
	}

	public void setMethodParametersFilesI(String method_parameters_files, int i) {
		this.method_parameters_files[i] = method_parameters_files;
	}

	public long getInitialTimeExecution() {
		return initial_time_execution;
	}

	public void setInitialTimeExecution(long initial_time_execution) {
		this.initial_time_execution = initial_time_execution;
	}

	public int getNTry() {
		return n_try;
	}

	public void setNTry(int n_try) {
		this.n_try = n_try;
	}

	public String getCooperationType() {
		return cooperation_type;
	}

	public void setCooperationType(String cooperation_type) {
		this.cooperation_type = cooperation_type;
	}

	public double getBestOF() {
		return best_of;
	}

	public void setBestOF(double best_of) {
		this.best_of = best_of;
	}

	public int getBestAux() {
		return best_aux;
	}

	public void setBestAux(int best_aux) {
		this.best_aux = best_aux;
	}

	public WriterInFile getFwBestSolution() {
		return fw_best_solution;
	}

	public void setFwBestSolution(WriterInFile fw_best_solution) {
		this.fw_best_solution = fw_best_solution;
	}
	
}
