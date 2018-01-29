package Environment_PRV_Movements;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that extends the Element class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import Environment.Element;

public class VRPMovementElement extends Element{
	
	private int client1;
	private int position_client1;
	private int client2;
	private int position_client2;
	private int route1;
	private int route2;
	private int count;
	
	private boolean valid;
	
	public VRPMovementElement() {
		super(0);
		// TODO Auto-generated constructor stub
		this.count = 0;
	}
	
	public int getClient1() {
		return client1;
	}
	
	public void setClient1(int client1) {
		this.client1 = client1;
	}
	
	public int getPositionClient1() {
		return position_client1;
	}
	
	public void setPositionClient1(int position_client1) {
		this.position_client1 = position_client1;
	}

	public int getClient2() {
		return client2;
	}

	public void setClient2(int client2) {
		this.client2 = client2;
	}

	public int getPositionClient2() {
		return position_client2;
	}

	public void setPositionClient2(int position_client2) {
		this.position_client2 = position_client2;
	}

	public int getRoute1() {
		return route1;
	}

	public void setRoute1(int route1) {
		this.route1 = route1;
	}

	public int getRoute2() {
		return route2;
	}

	public void setRoute2(int route2) {
		this.route2 = route2;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
