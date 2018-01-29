package Environment_VRP;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Specialized class for the Vehicle Routing Problem  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import Environment.Problem;

public class VRPProblem extends Problem{

	/* ATTRIBUTES */
	private int number_of_clients; 
	private Client client_collection[];
	private int vehicle_capacity;
	private int wait_time;
	private float distance_table[][];
	private int vehicle_penalty;
	
	public VRPProblem(String instance, String problem_description, String problem_type[], int dimension) throws Exception {
		
		super(instance, problem_description, problem_type, dimension);
		
		// TODO Auto-generated constructor stub
		
		this.readProblem(instance, dimension);
		this.distance_table = new float[this.getNumberOfClients()][this.getNumberOfClients()];
		this.calculateDistances();
		this.vehicle_penalty = 1000;
	}
	
	/* OVERRIDE */
	@Override
	public void readProblem(String instance, int dimension) throws Exception {
		// TODO Auto-generated method stub
		
		FileReader file = new FileReader(this.getInstanceName() + ".txt");
		BufferedReader buffer = new BufferedReader(file);
		
		System.out.println("**VRP Problem**");
		
		String line = buffer.readLine();
		StringTokenizer token = new StringTokenizer(line," ");
		while (token.hasMoreTokens()){
			this.setNumberOfClients(new Integer(token.nextToken()).intValue());
			this.vehicle_capacity = new Integer(token.nextToken()).intValue();//casting
			System.out.println("Clients Number: " +this.getNumberOfClients());
			System.out.println("Capacity: " + this.vehicle_capacity);
	    }
		this.setNumberOfClients(this.getNumberOfClients() + 1);
		
		System.out.println("\nClients Data:");
		
		this.client_collection = new Client[this.getNumberOfClients()];
		
		line = buffer.readLine( );
	    int j = 0;
	    while ( line != null ) {
	    	this.client_collection[j] = new Client(line);
	    	this.client_collection[j].showClient();
	    	line = buffer.readLine( );
	    	j++;
	    }
	    buffer.close();
	}
	
	@Override
	public void copyValuesProblem(Problem p) {
		// TODO Auto-generated method stub
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem){
			vrp = (VRPProblem) p;
		}
		
		//super
		this.setInstanceName(vrp.getInstanceName());
		
		this.setNumberOfClients(vrp.getNumberOfClients());
		for(int i = 0; i < this.getNumberOfClients(); i++){
			this.client_collection[i].copyValuesClient(vrp.getClientCollection(i));
		}
		this.vehicle_capacity = vrp.vehicle_capacity;
		this.wait_time = vrp.wait_time;
		for(int i = 0; i < this.getNumberOfClients(); i++){
			for(int j = 0; j < this.getNumberOfClients(); j++){
				this.distance_table[i][j] = vrp.distance_table[i][j];
			}
		}
		this.vehicle_penalty = vrp.vehicle_penalty;
	}

	@Override
	public void showProblem() {
		// TODO Auto-generated method stub
		
	}
	
	public void calculateDistances() {
		System.out.print("\nMatriz de Distancias\n");
		for (int i = 0; i < this.number_of_clients; i++){
			for (int j = 0; j < this.number_of_clients; j++){
				this.distance_table[i][j] = (float)(Math.floor(10*Math.sqrt( Math.pow((this.client_collection[j].getCoordinateX()-this.client_collection[i].getCoordinateX()),2) + Math.pow((this.client_collection[j].getCoordinateY()-this.client_collection[i].getCoordinateY()),2)))/10);
				System.out.print(" " + this.distance_table[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	@Override
	public int randomItem() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/* SETS AND GETS */
	public void setClientCollectionI(Client client_collection, int i) {
		this.client_collection[i] = client_collection;
	}

	public Client getClientCollection(int i) {
		return this.client_collection[i];
	}

	public void setVehicleCapacity(int vehicle_capacity) {
		this.vehicle_capacity = vehicle_capacity;
	}

	public int getVehicleCapacity() {
		return this.vehicle_capacity;
	}

	public void setWaitTime(int wait_time) {
		this.wait_time = wait_time;
	}

	public int getWaitTime() {
		return this.wait_time;
	}

	public void setDistanceTable(float distance_table, int i, int j) {
		this.distance_table[i][j] = distance_table;
	}

	public float getDistanceTable(int i, int j) {
		return this.distance_table[i][j];
	}

	public void setVehiclePenalty(int vehicle_penalty) {
		this.vehicle_penalty = vehicle_penalty;
	}

	public int getVehiclePenalty() {
		return this.vehicle_penalty;
	}

	public int getNumberOfClients() {
		return number_of_clients;
	}

	public void setNumberOfClients(int number_of_clients) {
		this.number_of_clients = number_of_clients;
	}
	
}