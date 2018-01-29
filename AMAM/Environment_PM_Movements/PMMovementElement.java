package Environment_PM_Movements;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that extends the Element class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import Environment.Element;

public class PMMovementElement extends Element{

	private int task1;
	private int position_task1;
	private int task2;
	private int position_task2;
	private int machine1;
	private int machine2; 
	private boolean valid;
	private int count;
	
	public PMMovementElement() {
		super(0);
		// TODO Auto-generated constructor stub
	}
	
	public int getTask1() {
		return task1;
	}
	
	public void setTask1(int task1) {
		this.task1 = task1;
	}
	
	public int getTask2() {
		return task2;
	}
	
	public void setTask2(int task2) {
		this.task2 = task2;
	}
	
	public int getMachine1() {
		return machine1;
	}
	
	public void setMachine1(int machine1) {
		this.machine1 = machine1;
	}
	
	public int getMachine2() {
		return machine2;
	}
	
	public void setMachine2(int machine2) {
		this.machine2 = machine2;
	}

	public int getPositionTask1() {
		return position_task1;
	}

	public void setPositionTask1(int position_task1) {
		this.position_task1 = position_task1;
	}

	public int getPositionTask2() {
		return position_task2;
	}

	public void setPositionTask2(int position_task2) {
		this.position_task2 = position_task2;
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
