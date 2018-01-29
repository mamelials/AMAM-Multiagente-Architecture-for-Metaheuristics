package Construct_PM;

import Environment.Element;
import Environment.Problem;
import Environment_PM.PMProblem;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that extends the Element class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMConstructElement extends Element{

	private int machine_ins;
	private int pos_ins;
	private int next_candidate;
	private int candidates[];
	private int count;  //for candidates
	private int rcl_size;
	
	public PMConstructElement(Problem p) {
		// TODO Auto-generated constructor stub
		super(0);
		
		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		this.machine_ins = -1;
		this.pos_ins = -1;
		this.next_candidate = -1;
		this.candidates = new int[pm.getNumberOfTasks()];
		this.count = 0;
	}
	
	public void copyValues(PMConstructElement e, Problem p) {
		
		PMProblem p_pm =null;
		if(p instanceof PMProblem) {
			p_pm = (PMProblem) p;
		}
		
		this.machine_ins = e.machine_ins;
		this.pos_ins = e.pos_ins;
		this.next_candidate = e.next_candidate;
		for(int i = 0; i < p_pm.getNumberOfTasks(); i++) {
			this.candidates[i] = e.candidates[i];
		}
		this.count = e.count;
	}
	
	public void addCount() {
		this.count++;
	}
	
	public int getMachineIns() {
		return machine_ins;
	}
	
	public void setMachineIns(int machine_ins) {
		this.machine_ins = machine_ins;
	}
	
	public int getPosIns() {
		return pos_ins;
	}
	
	public void setPosIns(int pos_ins) {
		this.pos_ins = pos_ins;
	}
	
	public int getNextCandidate() {
		return next_candidate;
	}
	
	public void setNextCandidate(int next_candidate) {
		this.next_candidate = next_candidate;
	}
	
	public int getCandidateI(int i) {
		return candidates[i];
	}
	
	public void setCandidateI(int candidate, int i) {
		this.candidates[i] = candidate;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	public int getRclSize() {
		return rcl_size;
	}

	public void setRclSize(int rcl_size) {
		this.rcl_size = rcl_size;
	}
	
}
