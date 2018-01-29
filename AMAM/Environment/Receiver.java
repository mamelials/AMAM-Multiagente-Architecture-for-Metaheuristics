package Environment;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that keeps the agents that received the solution of the pool. 
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class Receiver {

	/* ATTRIBUTES */
	private int id_receiver[];
	private long time_receiver[];
	private int max_size; //número máximo de receivers a serem armazenados
	private int size;
	
	public Receiver(int max_size){
		this.max_size = max_size;
		this.size = 0;
		this.id_receiver = new int[this.max_size];
		this.time_receiver =  new long[this.max_size];
	}
	
	public void copyValuesReceiver(Receiver r) {
		this.size = r.size;
		for(int i = 0; i < this.size; i++) {
			this.id_receiver[i] = r.id_receiver[i];
			this.time_receiver[i] = r.time_receiver[i];
		}
	}
	
	public void addReceiver(int receiver, long time) {
		if(this.size < this.max_size) {
			this.id_receiver[this.size] = receiver;
			this.time_receiver[this.size] = time;
			this.size++;
		}
	}
	
	/* SETS AND GETS */
	public void setIdReceiverI(int receiver, int i) {
		this.id_receiver[i] = receiver;
	}
	
	public int getIdReceiverI(int i) {
		return this.id_receiver[i];
	}
	
	public void setTimeReceiverI(long time_receiver, int i) {
		this.time_receiver[i] = time_receiver;
	}
	
	public long getTimeReceiverI(int i) {
		return this.time_receiver[i];
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.size;
	}

	public int getMaxSize() {
		return max_size;
	}

	public void setMaxSize(int max_size) {
		this.max_size = max_size;
	}
	
}
