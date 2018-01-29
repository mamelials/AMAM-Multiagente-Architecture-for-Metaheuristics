package Environment_VRP;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Component of Vehicle Routing Problem  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import java.util.StringTokenizer;

public class Client {

	/* ATTRIBUTES */
	private int id_number;
	private int coordinate_x;
	private int coordinate_y;
	private int demand;
	private int tw_initial;
	private int tw_final;
	private int service_time;
	private double insertion_cost;
	
	public Client(String line){
		StringTokenizer token = new StringTokenizer(line," ");
		while (token.hasMoreTokens()){
	    	this.id_number = new Integer(token.nextToken()).intValue();
	    	this.coordinate_x = new Integer(token.nextToken()).intValue();
	    	this.coordinate_y = new Integer(token.nextToken()).intValue();
	    	this.demand = new Integer(token.nextToken()).intValue();
	    	this.tw_initial= new Integer(token.nextToken()).intValue();
	    	this.tw_final = new Integer(token.nextToken()).intValue();
	    	this.service_time = new Integer(token.nextToken()).intValue();
		}
	}
	
	public void copyValuesClient(Client c) {
		this.id_number = c.id_number;
		this.coordinate_x = c.coordinate_x;
		this.coordinate_y = c.coordinate_y;
		this.demand = c.demand;
		this.tw_initial = c.tw_initial;
		this.tw_final = c.tw_final;
		this.service_time = c.service_time;
		this.insertion_cost = c.insertion_cost;
	}
	
	public void showClient() {
		System.out.println(this.id_number + "  " + this.coordinate_x + "  " + this.coordinate_y + "  " +
				this.demand + "  " + this.tw_initial + "  " + this.tw_final + "  " + this.service_time);
	}
	
	/* SETS AND GETS */
	public void setIdNumber(int id_number) {
		this.id_number = id_number;
	}
	
	public int getIdNumber() {
		return this.id_number;
	}
	
	public void setCoordinateX(int coordinate_x) {
		this.coordinate_x = coordinate_x;
	}
	
	public int getCoordinateX() {
		return this.coordinate_x;
	}
	
	public void setCoordinateY(int coordinate_y) {
		this.coordinate_y = coordinate_y;
	}
	
	public int getCoordinateY() {
		return this.coordinate_y;
	}
	
	public void setDemand(int demand) {
		this.demand = demand;
	}
	
	public int getDemand() {
		return this.demand;
	}
	
	public void setTWInitial(int tw_initial) {
		this.tw_initial = tw_initial;
	}
	
	public int getTWInitial() {
		return this.tw_initial;
	}
	
	public void setTWFinal(int tw_final) {
		this.tw_final = tw_final;
	}
	
	public int getTWFinal() {
		return this.tw_final;
	}
	
	public void setServiceTime(int service_time) {
		this.service_time = service_time;
	}
	
	public int getServiceTime() {
		return this.service_time;
	}
	
	public void setInsertionCost(double insertion_cost) {
		this.insertion_cost = insertion_cost;
	}
	
	public double getInsertionCost() {
		return this.insertion_cost;
	}
	
}
