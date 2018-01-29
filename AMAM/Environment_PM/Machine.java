package Environment_PM;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Component of the solution of Parallel Machines Problem  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import java.io.IOException;

import Function_Package.WriterInFile;

public class Machine {

	private int tasks[];
	private int tasks_number;
	private int total_time;
	
	public Machine(int n) {
		// TODO Auto-generated constructor stub
		this.tasks = new int [n];
		this.tasks_number = 0;
		this.total_time = 0;
	}
	
	public void copyValuesMachine(Machine m) {
		for(int i = 0; i < m.tasks_number; i++) {
			this.tasks[i] = m.tasks[i];
		}
		this.tasks_number = m.tasks_number;
		this.total_time = m.total_time;
	}
	
	public void showMachine() {
		System.out.println("  Task number: " + this.tasks_number);
		System.out.println("  Total time: " + this.total_time);
		System.out.print("  Tarefas: ");
		for(int i = 0; i < this.tasks_number; i++) {
			System.out.print(this.tasks[i] + ", ");
		}
	}
	
	public void writeMachine(WriterInFile fw) throws IOException{
		fw.writerTextFile("  Task number: " + this.tasks_number);
		fw.writerTextFile("  Total time: " + this.total_time);
		fw.writerTextFile("  Tasks: ");
		fw.writerTextFileWithoutLine("    ");
		for(int i = 0; i < this.tasks_number; i++) {
			fw.writerTextFileWithoutLine(this.tasks[i] + ", ");
		}
	}
	
	/* SETS E GETS */
	public int getTasksInMachine(int i) {
		return tasks[i];
	}
	
	public void setTasksInMachine(int task, int i) {
		this.tasks[i] = task;
	}
	
	public int getTasksNumber() {
		return tasks_number;
	}
	
	public void setTasksNumber(int tasks_number) {
		this.tasks_number = tasks_number;
	}
	
	public int getTotalTime() {
		return total_time;
	}
	
	public void setTotalTime(int total_time) {
		this.total_time = total_time;
	}
	
}
