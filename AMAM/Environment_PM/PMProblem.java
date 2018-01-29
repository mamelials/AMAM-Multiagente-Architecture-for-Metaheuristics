package Environment_PM;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Specialized class for the Parallel Machines Problem  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import Environment.Problem;

public class PMProblem extends Problem{

	
	private int number_of_tasks;
	private int machines_number;
	private int processing_time[][];
	private SetupTime setup_time[];	
	
	public PMProblem(String instance, String problem_description, String problem_type[], int dimension) throws Exception {
		
		super(instance, problem_description, problem_type, dimension);
		
		// TODO Auto-generated constructor stub
		
		this.readProblem(this.getInstanceName(), this.getDimension());
	}
	
	@Override
	public void readProblem(String instance, int dimension) throws Exception {
		// TODO Auto-generated method stub
		
		int aux;
		
		this.setInstanceName(instance);
		FileReader file = new FileReader(this.getInstanceName() + ".txt");
		BufferedReader buffer = new BufferedReader(file);
		
		System.out.println("**PM Problem**");
		
		String line = buffer.readLine();
		StringTokenizer token = new StringTokenizer(line," ");
		while (token.hasMoreTokens()){
			this.setNumberOfTasks(new Integer(token.nextToken()).intValue());
			this.machines_number = new Integer(token.nextToken()).intValue();
			aux = new Integer(token.nextToken()).intValue();
			System.out.println("Task number: " +this.getNumberOfTasks());
			System.out.println("Machine number: " + this.machines_number);
	    }
		
		this.processing_time = new int[this.getNumberOfTasks()][this.machines_number];
		this.setup_time = new SetupTime[this.machines_number];
		for(int i = 0; i < this.machines_number; i++) {
			this.setup_time[i] = new SetupTime(this.getNumberOfTasks());
		}
		
		System.out.println("\nProcessing Time:");
		
		line = buffer.readLine( );
		token = new StringTokenizer(line,"	");
		aux = new Integer(token.nextToken()).intValue();
		
		line = buffer.readLine( );
		token = new StringTokenizer(line,"	");
	    for(int i = 0; i < this.getNumberOfTasks(); i++) { //task
	    	for(int j = 0; j < this.machines_number; j++) { //machine
	    		aux = new Integer(token.nextToken()).intValue();
	    		System.out.print(aux + "  ");
	    		this.processing_time[i][j] = new Integer(token.nextToken()).intValue();
	    		System.out.print(this.processing_time[i][j] + "  ");
	    	}
	    	line = buffer.readLine( );
	    	token = new StringTokenizer(line,"	");
	    	System.out.println("");
	    }
	    
	    System.out.println("\nSetup Time:");
	    line = buffer.readLine( );
    	token = new StringTokenizer(line,"	");
    	
	    for(int i = 0; i < this.machines_number; i++) {
	    	System.out.println("M" + i);
	    	line = buffer.readLine( );
	    	token = new StringTokenizer(line,"	");
	    	for(int j = 0; j < this.getNumberOfTasks(); j++) {
	    		for(int k = 0; k < this.getNumberOfTasks(); k++) {
	    			this.setup_time[i].setSetupTime(new Integer(token.nextToken()).intValue(), j, k);
		    		System.out.print(this.setup_time[i].getSetupTime(j, k) + "  ");
	    		}
	    		System.out.println("");
	    		line = buffer.readLine( );
	    		if(line != null)
	    			token = new StringTokenizer(line,"	");
	    	}
	    	System.out.println("");
	    }
	    
	    buffer.close();
	}

	@Override
	public void copyValuesProblem(Problem p) {
		// TODO Auto-generated method stub
		PMProblem pm = null;
		if(p instanceof PMProblem){
			pm = (PMProblem) p;
		}
		
		this.setNumberOfTasks(pm.getNumberOfTasks());
		this.machines_number = pm.machines_number;
		for(int i = 0; i < this.getNumberOfTasks(); i++) {
			for(int j = 0; j < this.machines_number; j++) {
				this.setProcessingTime(pm.getProcessingTime(i, j), i, j);
			}
		}
		for(int i = 0; i < this.machines_number; i++) {
			this.setup_time[i].copyValuesSetupTime(pm.setup_time[i], pm.getNumberOfTasks());
		}
	}

	@Override
	public void showProblem() {
		// TODO Auto-generated method stub
		System.out.println("***Parallel Machines Problem***");
		System.out.println("Task number: " + this.getNumberOfTasks());
		System.out.println("Machines number: " + this.machines_number);
		
		System.out.println("\nProcessing Time:");
		for(int i = 0; i < this.machines_number; i++) {
			System.out.print("M" + i + " ");
		}
		System.out.println("");
		for(int i = 0; i < this.getNumberOfTasks(); i++) {
			for(int j = 0; j < this.machines_number; j++) {
				System.out.print(this.processing_time[i][j] + "  ");
			}
			System.out.println("");
		}
		
				System.out.println("\nSetup Time: ");
		for(int i = 0; i < this.machines_number; i++) {
			System.out.println("Máquina " + i + ": ");
			this.setup_time[i].showSetupTime(this.getNumberOfTasks());
		}
	}
	
	@Override
	public int randomItem() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getMachinesNumber() {
		return machines_number;
	}

	public void setMachinesNumber(int machines_number) {
		this.machines_number = machines_number;
	}

	public int getProcessingTime(int i, int j) {
		return processing_time[i][j];
	}

	public void setProcessingTime(int time, int i, int j) {
		this.processing_time[i][j] = time;
	}

	public int getSetupTime(int machine, int i, int j) {
		return this.setup_time[machine].getSetupTime(i, j);
	}

	public int getNumberOfTasks() {
		return number_of_tasks;
	}

	public void setNumberOfTasks(int number_of_tasks) {
		this.number_of_tasks = number_of_tasks;
	}
	
}
