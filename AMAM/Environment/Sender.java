package Environment;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that keeps the agents that sent the solution to the pool.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class Sender {
	
	/* ATTRIBUTES */
	private int id_sender;
	private float time_sender;
	
	
	public void copyValuesSender(Sender s) {
		this.id_sender = s.id_sender;
		this.time_sender = s.time_sender;
	}
	
	/* SETS AND GETS */
	public void setIdSender(int sender) {
		this.id_sender = sender;
	}
	
	public int getIdSender() {
		return this.id_sender;
	}
	
	public void setTimeSender(float time_sender) {
		this.time_sender = time_sender;
	}
	
	public float getTimeSender() {
		return this.time_sender;
	}

}
