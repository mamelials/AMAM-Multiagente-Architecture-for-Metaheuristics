package Parameters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Environment_Movements.Movement;
import Environment_Movements.MovementList;
import Factorys.MovementFactory;
import Reinforcement_Learning.QLearning;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Experiments parameters.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class Parameters {

	private ExperimentParameters experiment_parameters;
	private MethodParameters method_parameters[];
	
	public Parameters(String experiment_param_file, String methods_param_file) throws IOException { 
		readExperimentParameters(experiment_param_file);
		readMethodsParameters(methods_param_file);	
	}
	
	public void readExperimentParameters(String experiment_param_file) throws IOException {
		
		this.experiment_parameters = new ExperimentParameters();
		
		FileReader file = new FileReader(experiment_param_file + ".txt");
		BufferedReader buffer = new BufferedReader(file);
		
		String line = buffer.readLine();
		System.out.println(line);
		line = buffer.readLine();
		System.out.println();
		
		line = buffer.readLine();
		StringTokenizer token = new StringTokenizer(line," ");
		String aux = token.nextToken();
		System.out.print(aux + " ");
		this.experiment_parameters.setInstanceName(token.nextToken());
		System.out.println(this.experiment_parameters.getInstanceName());
		
		line = buffer.readLine();
		token = new StringTokenizer(line," ");
		aux = token.nextToken();
		System.out.print(aux + " ");
		this.experiment_parameters.setBestOF(new Double(token.nextToken()).doubleValue());
		System.out.println(this.experiment_parameters.getBestOF());
		
		line = buffer.readLine();
		token = new StringTokenizer(line," ");
		aux = token.nextToken();
		System.out.print(aux + " ");
		this.experiment_parameters.setBestAux(new Integer(token.nextToken()).intValue());
		System.out.println(this.experiment_parameters.getBestAux());
		
		line = buffer.readLine();
		token = new StringTokenizer(line," ");
		aux = token.nextToken();
		System.out.print(aux + " ");
		this.experiment_parameters.setProblemDescription(token.nextToken());
		System.out.println(this.experiment_parameters.getProblemDescription());
		
		line = buffer.readLine();
		token = new StringTokenizer(line," ");
		aux = token.nextToken();
		System.out.print(aux + " ");
		this.experiment_parameters.setProblemDimension(new Integer(token.nextToken()).intValue());
		System.out.println(this.experiment_parameters.getProblemDimension());
		
		this.experiment_parameters.setProblemType(new String[this.experiment_parameters.getProblemDimension()]);		
		line = buffer.readLine();
		for(int i = 0; i < this.experiment_parameters.getProblemDimension(); i++) {
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			this.experiment_parameters.setProblemTypeI(token.nextToken(), i);
			System.out.println(this.experiment_parameters.getProblemTypeI(i));
		}
		
		if(this.experiment_parameters.getProblemDimension() > 1) {
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			this.experiment_parameters.setGamaMO(new Double(token.nextToken()).doubleValue());
			System.out.println(this.experiment_parameters.getGamaMO());
		}
		else {
			line = buffer.readLine();
			this.experiment_parameters.setGamaMO(0);
		}
		
		line = buffer.readLine();
		token = new StringTokenizer(line," ");
		aux = token.nextToken();
		System.out.print(aux + " ");
		this.experiment_parameters.setExecutionsNumber(new Integer(token.nextToken()).intValue());
		System.out.println(this.experiment_parameters.getExecutionsNumber());
		
		line = buffer.readLine();
		token = new StringTokenizer(line," ");
		aux = token.nextToken();
		System.out.print(aux + " ");
		this.experiment_parameters.setNumberOfMethods(new Integer(token.nextToken()).intValue());
		System.out.println(this.experiment_parameters.getNumberOfMethods());
		
		this.experiment_parameters.setMethodParametersFiles(new String[this.experiment_parameters.getNumberOfMethods()]);		
		line = buffer.readLine();
		for(int i = 0; i < this.experiment_parameters.getNumberOfMethods(); i++) {
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			this.experiment_parameters.setMethodParametersFilesI(token.nextToken(), i);
			System.out.println(this.experiment_parameters.getMethodParametersFilesI(i));
		}
		
		//COOPERATION
		line = buffer.readLine();
		line = buffer.readLine();
		token = new StringTokenizer(line," ");
		aux = token.nextToken();
		System.out.print(aux + " ");
		this.experiment_parameters.setCooperationType(token.nextToken());
		System.out.println(this.experiment_parameters.getCooperationType());
		
		line = buffer.readLine();
		token = new StringTokenizer(line," ");
		aux = token.nextToken();
		System.out.print(aux + " ");
		this.experiment_parameters.setReceiverSize(new Integer(token.nextToken()).intValue());
		System.out.println(this.experiment_parameters.getReceiverSize());
		
		line = buffer.readLine();
		token = new StringTokenizer(line," ");
		aux = token.nextToken();
		System.out.print(aux + " ");
		this.experiment_parameters.setRadiusNiche(new Double(token.nextToken()).doubleValue());
		System.out.println(this.experiment_parameters.getRadiusNiche());
		
		line = buffer.readLine();
		token = new StringTokenizer(line," ");
		aux = token.nextToken();
		System.out.print(aux + " ");
		this.experiment_parameters.setMaxSizePool(new Integer(token.nextToken()).intValue());
		System.out.println(this.experiment_parameters.getMaxSizePool());
		
		buffer.close();
	}
	
	public void readMethodsParameters(String methods_param_file) throws IOException {
		
		System.out.println(" -----");
		method_parameters = new MethodParameters[this.experiment_parameters.getNumberOfMethods()];
		for(int i = 0; i < this.experiment_parameters.getNumberOfMethods(); i++) {
			System.out.println("");
			this.method_parameters[i] = new MethodParameters();
			
			FileReader file = new FileReader(this.experiment_parameters.getMethodParametersFilesI(i) + ".txt");
			BufferedReader buffer = new BufferedReader(file);
			
			String line = buffer.readLine();
			System.out.println(line);
			line = buffer.readLine();
			System.out.println();
			
			System.out.println("METHOD " + i);
			
			line = buffer.readLine();
			StringTokenizer token = new StringTokenizer(line," ");
			String aux = token.nextToken();
			System.out.print(aux + " ");
			this.method_parameters[i].setMthType(token.nextToken());
			System.out.println(this.method_parameters[i].getMthType());
			
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			this.method_parameters[i].setStopCondType(token.nextToken());
			System.out.println(this.method_parameters[i].getStopCondType());
			
			if( this.method_parameters[i].getStopCondType().equals("time")) {
				line = buffer.readLine();
				token = new StringTokenizer(line," ");
				aux = token.nextToken();
				System.out.print(aux + " ");
				this.method_parameters[i].setMaxTime(new Integer(token.nextToken()).intValue());
				System.out.println(this.method_parameters[i].getMaxTime());
			}
			else {
				line = buffer.readLine();
				this.method_parameters[i].setMaxTime(0);
			}
			
			if(this.method_parameters[i].getStopCondType().equals("iterations")) {
				line = buffer.readLine();
				token = new StringTokenizer(line," ");
				aux = token.nextToken();
				System.out.print(aux + " ");
				this.method_parameters[i].setMaxIterations(new Integer(token.nextToken()).intValue());
				System.out.println(this.method_parameters[i].getMaxIterations());
			}
			else {
				line = buffer.readLine();
				this.method_parameters[i].setMaxIterations(0);;
			}
			
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			this.method_parameters[i].setAcceptCritType(token.nextToken());
			System.out.println(this.method_parameters[i].getAcceptCritType());
			
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			this.method_parameters[i].setMaxLevelsPerturbation(new Integer(token.nextToken()).intValue());
			System.out.println(this.method_parameters[i].getMaxLevelsPerturbation());
			
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			this.method_parameters[i].setConstrType(token.nextToken());
			System.out.println(this.method_parameters[i].getConstrType());
			
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			this.method_parameters[i].setLsType(token.nextToken());
			System.out.println(this.method_parameters[i].getLsType());
			
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			this.method_parameters[i].setNeighborhoodSize(new Integer(token.nextToken()).intValue());
			System.out.println(this.method_parameters[i].getNeighborhoodSize());
			
			int q_size = this.method_parameters[i].getNeighborhoodSize();
			
			double gamma;
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			gamma = new Double(token.nextToken()).doubleValue();
			System.out.println(gamma);
			
			double alpha;
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			alpha = new Double(token.nextToken()).doubleValue();
			System.out.println(alpha);
			
			double epsilon;
			line = buffer.readLine();
			token = new StringTokenizer(line," ");
			aux = token.nextToken();
			System.out.print(aux + " ");
			epsilon = new Double(token.nextToken()).doubleValue();
			System.out.println(epsilon);
			
			this.method_parameters[i].setQLearning(new QLearning(q_size, gamma, alpha, epsilon));
			
			line = buffer.readLine();
			System.out.println(line);
			MovementFactory movement_factory = new MovementFactory();
			MovementList movement_list = new MovementList(this.method_parameters[i].getNeighborhoodSize());
			for(int j = 0; j < this.method_parameters[i].getNeighborhoodSize(); j++) {
				line = buffer.readLine();
				token = new StringTokenizer(line," ");
				aux = token.nextToken();
				System.out.print(aux + " ");
				Movement move = movement_factory.createMoviment(token.nextToken());
				movement_list.addMovementI(move);
				System.out.println(movement_list.getMoveI(j).getMoveType());
			}
			this.method_parameters[i].setMovementList(movement_list);
			
			this.method_parameters[i].setRclSize(10);
			
			buffer.close();
		}
	}
	
	public ExperimentParameters getExperimentParameters() {
		return experiment_parameters;
	}
	
	public void setExperimentParameters(ExperimentParameters experiment_parameters) {
		this.experiment_parameters = experiment_parameters;
	}

	public MethodParameters getMethodParametersI(int i) {
		return method_parameters[i];
	}

	public void setMethodParametersI(MethodParameters method_parameters, int i) {
		this.method_parameters[i] = method_parameters;
	}
	
}
