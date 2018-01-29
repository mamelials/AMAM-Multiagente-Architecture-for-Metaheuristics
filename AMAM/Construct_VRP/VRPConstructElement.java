package Construct_VRP;

import Environment.Element;
import Environment.Problem;
import Environment_VRP.VRPProblem;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that extends the Element class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPConstructElement extends Element{

	private int route_ins;
	private int pos_ins;
	private int next_candidate;
	private double insertion_cost[];
	private int candidates[];
	private int pos_candidate;
	private int count;  //for candidates
	
	public VRPConstructElement(Problem p) {
		// TODO Auto-generated constructor stub
		super(0);
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		this.route_ins = -1;
		this.pos_ins = -1;
		this.next_candidate = -1;
		this.candidates = new int[vrp.getNumberOfClients()];
		this.count = 0;
		
		this.insertion_cost = new double[vrp.getNumberOfClients()];
	}
	

	public void calculateCostInsertion(VRPProblem p)
	{
		double alfa = -0.7;
		double beta = 0.1;
		double gama = 0.2;
		double pi;
		double cost, a, b, c;
		
		//System.out.println("\n\nINSERTION COST: ");
		for (int i = 1; i < p.getNumberOfClients(); i++)
		{
			a = alfa * p.getDistanceTable(0, i);
			b = beta * p.getClientCollection(i).getTWFinal();
			pi = ((Math.atan2(p.getClientCollection(i).getCoordinateY(), p.getClientCollection(i).getCoordinateX()))*180)/Math.PI;
			c = gama * ((pi/360)*p.getDistanceTable(0,i));
			cost = a + b + c;
			this.insertion_cost[i] = cost;
			//System.out.print(cost + ", ");
		}
	}
	
	public void orderClients(VRPProblem p)
	{
		int client_aux, j;
		this.candidates[1] = 1;
		for(int i = 2; i < p.getNumberOfClients(); i++)
		{
			client_aux = i;
			j = i - 1;
			this.candidates[0] = client_aux;
			while (this.insertion_cost[client_aux] < this.insertion_cost[this.candidates[j]])
			{
				this.candidates[j+1] = p.getClientCollection(this.candidates[j]).getIdNumber();
				j = j - 1;
			}
			this.candidates[j+1] = client_aux;
		}
		//System.out.println("\n\nORDER CLIENTS");
		for(int i = 1; i < p.getNumberOfClients(); i++) {
			//System.out.print(this.candidates[i] + " - ");
		}
	}
	
	public void addCount() {
		this.count++;
	}
	
	public int getRouteIns() {
		return route_ins;
	}
	
	public void setRouteIns(int route_ins) {
		this.route_ins = route_ins;
	}
	
	public int getPosIns() {
		return pos_ins;
	}
	
	public void setPosIns(int pos_ins) {
		this.pos_ins = pos_ins;
	}

	public int getCandidateI(int i) {
		return candidates[i];
	}

	public void setCandidateI(int candidates, int i) {
		this.candidates[i] = candidates;
	}

	public int getNextCandidate() {
		return next_candidate;
	}

	public void setNextCandidate(int next) {
		this.next_candidate = next;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	public int getPosCandidate() {
		return pos_candidate;
	}


	public void setPosCandidate(int pos_candidate) {
		this.pos_candidate = pos_candidate;
	}

	/*public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}*/
	
}
