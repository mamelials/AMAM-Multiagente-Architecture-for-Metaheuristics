package Environment_VRP;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Component of the solution of Vehicle Routing Problem  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import java.io.IOException;

import Function_Package.WriterInFile;

public class Route {

	/* ATTRIBUTES */
	private int route_vector[];
	private int number_clients_route;
	private int total_demand;
	private float total_time;
	
	public Route(int n) {
		this.route_vector = new int[n];
		this.route_vector[0] = 0;
		this.number_clients_route = 0;
		this.total_demand = 0;
		this.total_time = 0;
	}
	
	public void copyValuesRoute(Route r) {
		for(int i = 0; i <= r.number_clients_route; i++) {
			this.route_vector[i] = r.route_vector[i];
		}
		this.number_clients_route = r.number_clients_route;
		this.total_demand = r.total_demand;
		this.total_time = r.total_time;
	}
	
	public void showRoute() {
		for(int i = 0; i <= this.number_clients_route; i++) {
			System.out.print(this.route_vector[i] + " - ");
		}
		System.out.println("\nNumber of Clients in the Route: " + this.number_clients_route);
		System.out.println("Total Demand: " + this.total_demand);
		System.out.println("Total Time: " + this.total_time);
	}
	
	public void writeRoute(WriterInFile fw) throws IOException {
		for(int i = 0; i <= this.number_clients_route; i++) {
			fw.writerTextFileWithoutLine(this.route_vector[i] + " - ");
		}
		fw.writerNewLine();
		fw.writerTextFile("Number of Clients in the Route: " + this.number_clients_route);
		fw.writerTextFile("Total Demand: " + this.total_demand);
		fw.writerTextFile("Total Time: " + this.total_time);
	}
	
	/* SETS AND GETS */
	public void setClientInRoute(int client, int i) {
		this.route_vector[i] = client;
	}
	
	public int getClientInRoute(int i) {
		return this.route_vector[i];
	}

	public void setNumberClientsRoute(int number_clients_route) {
		this.number_clients_route = number_clients_route;
	}

	public int getNumberClientsRoute() {
		return number_clients_route;
	}

	public void setTotalDemand(int total_demand) {
		this.total_demand = total_demand;
	}

	public int getTotalDemand() {
		return total_demand;
	}

	public void setTotalTime(float total_time) {
		this.total_time = total_time;
	}

	public float getTotalTime() {
		return total_time;
	}
	
}