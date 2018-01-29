package Environment_PM;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Specialized class for the Solution of the Parallel Machines Problem  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import java.io.IOException;

import Construct_PM.PMConstructElement;
import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Function_Package.WriterInFile;

public class PMSolution extends Solution{

	private Machine machines[];
	private int machine_number;
	
	public PMSolution(int receiver_size, Problem p) {
		super(receiver_size, p.getDimension());	
		// TODO Auto-generated constructor stub
		
		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		this.machine_number = pm.getMachinesNumber();
		//RETIRAR
		this.machines = new Machine[pm.getMachinesNumber()];
		for(int i = 0; i < pm.getMachinesNumber(); i++) {
			this.machines[i] = new Machine(pm.getNumberOfTasks());
		}
	}
		
	/* OVERRIDE METHODS */
	@Override
	/* Description: o valor da função objetivo é o tempo da máquina que conclui as tarefas
	 * em maior tempo
	 */
	public void calculateObjectiveFunction(Problem p) {
		// TODO Auto-generated method stub
		
		PMProblem pm = null;
		if(p instanceof PMProblem){
			pm = (PMProblem) p;
		}
		
		int makespan = this.machines[0].getTotalTime();
		
		for(int i = 1; i < pm.getMachinesNumber(); i++) {
			if(this.machines[i].getTotalTime() > makespan) {
				makespan = this.machines[i].getTotalTime();
			}
		}
		this.setObjectiveFunctionI(0, makespan);
	}
	
	public int searchMakespanMachine(Problem p) {
		// TODO Auto-generated method stub
		
		PMProblem pm = null;
		if(p instanceof PMProblem){
			pm = (PMProblem) p;
		}
		
		int makespan = this.machines[0].getTotalTime();
		int i_makespan = 0;
		
		for(int i = 1; i < pm.getMachinesNumber(); i++) {
			if(this.machines[i].getTotalTime() > makespan) {
				makespan = this.machines[i].getTotalTime();
				i_makespan = i;
			}
		}
		return i_makespan;
	}
	
	@Override
	public void calculateFitnessFunction(double gama, Problem p) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void copyValuesSolution(Solution s, Problem p) {
		// TODO Auto-generated method stub
		PMSolution pm_sol = null;
		if(s instanceof PMSolution){
			pm_sol = (PMSolution) s;
		}
		
		PMProblem pm = null;
		if(p instanceof PMProblem){
			pm = (PMProblem) p;
		}
		for(int i = 0; i < p.getDimension(); i++) {
			this.setObjectiveFunctionI(i, pm_sol.getObjectiveFunctionI(i));
		}
		for(int i = 0; i < pm.getMachinesNumber(); i++) {
			this.machines[i].copyValuesMachine(pm_sol.machines[i]);
		}
	}

	@Override
	public void showSolution(Problem p) {
		// TODO Auto-generated method stub
		
		PMProblem pm = null;
		if(p instanceof PMProblem){
			pm = (PMProblem) p;
		}
		
		System.out.println("\n\n**SOLUTION**");
		for(int i = 0; i < p.getDimension(); i++) {
			System.out.print("Objective Function: " + this.getObjectiveFunctionI(i));
		}
		for(int i = 0; i < pm.getMachinesNumber(); i++) {
			System.out.println("\nMachine " + i);
			this.machines[i].showMachine();
		}
	}
	
	@Override
	public void showOFAndFitness(Problem p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeSolution(Problem p, WriterInFile fw) throws IOException{
		// TODO Auto-generated method stub
		PMProblem pm = null;
		if(p instanceof PMProblem){
			pm = (PMProblem) p;
		}
		
		fw.writerTextFile("\n\n**SOLUTION**");
		for(int i = 0; i < p.getDimension(); i++) {
			fw.writerTextFile("Objective Function: " + this.getObjectiveFunctionI(i));
		}
		for(int i = 0; i < pm.getMachinesNumber(); i++) {
			fw.writerTextFile("\nMachine " + i);
			this.machines[i].writeMachine(fw);
		}
	}

	@Override
	public void writeReduceSolution(Problem p, WriterInFile fw) throws IOException{
		// TODO Auto-generated method stub
		fw.writerTextFile("\n\n**SOLUTION**");
		for(int i = 0; i < p.getDimension(); i++) {
			fw.writerTextFile("Objective Function: " + this.getObjectiveFunctionI(i));
		}
	}

	//Insere no final da lista de tarefas da máquina
	public void insertTaskInSolutionInLast(int task, int machine, Problem p) {
		
		PMProblem pm = null;
		if(p instanceof PMProblem){
			pm = (PMProblem) p;
		}
		
		int previous_task;
		int setup_time, processing_time;
		
		this.machines[machine].setTasksInMachine(task, this.machines[machine].getTasksNumber());
		
		//updated total time
		if(this.machines[machine].getTasksNumber() == 0) 
			this.machines[machine].setTotalTime(pm.getProcessingTime(task, machine));
		else {
			previous_task = this.machines[machine].getTasksInMachine(this.machines[machine].getTasksNumber() - 1);
			setup_time = pm.getSetupTime(machine, previous_task, task);
			processing_time = pm.getProcessingTime(task, machine);
			this.machines[machine].setTotalTime(this.machines[machine].getTotalTime() + processing_time + setup_time);
		}
		
		this.machines[machine].setTasksNumber(this.machines[machine].getTasksNumber() + 1);
	}
	
	public void insertTaskInSolutioninPosition(int task, int position, int machine, Problem p) {
		
		PMProblem pm = null;
		if(p instanceof PMProblem){
			pm = (PMProblem) p;
		}
		
		int previous_task = 0, next_task;
		int setup_time = 0, processing_time = 0;
		int time_sum = 0;
		int time_sub = 0;
		
		if(position != 0) {
			previous_task = this.machines[machine].getTasksInMachine(position-1);
		}
		
		next_task = this.machines[machine].getTasksInMachine(position);
		if((position < this.machines[machine].getTasksNumber()) && (position != 0)) {
			time_sub = pm.getSetupTime(machine, previous_task , next_task);
		}
		
		int i = this.machines[machine].getTasksNumber();
		while(i > position){
			i--;
			if(i == -1)
				System.out.println("Teste");
			this.machines[machine].setTasksInMachine(this.machines[machine].getTasksInMachine(i), i+1);
		}
		this.machines[machine].setTasksInMachine(task, i);
		
		//updated total time
		if(this.machines[machine].getTasksNumber() == 0) 
			this.machines[machine].setTotalTime(pm.getProcessingTime(task, machine));
		else {
			if(position != 0) {
				setup_time = pm.getSetupTime(machine, previous_task, task);
			}
			if(position < this.machines[machine].getTasksNumber()) {
				setup_time = setup_time + pm.getSetupTime(machine, task, next_task);
			}
			processing_time = pm.getProcessingTime(task, machine);
			time_sum = setup_time + processing_time;
			this.machines[machine].setTotalTime(this.machines[machine].getTotalTime() + time_sum - time_sub);
		}
		
		this.machines[machine].setTasksNumber(this.machines[machine].getTasksNumber() + 1);
	}
	
	public int searchTask(int task, int machine, int pos) {
		
		for(int i = 0; i < this.machine_number; i++) {
			for(int j = 0; j < this.machines[i].getTasksNumber(); j++) {
				if(this.machines[i].getTasksInMachine(j) == task) {
					machine = i;
					pos = j;
					return 1;
				}
			}
		}
		return 0;
	}
	
	/* remove known task */
	public void removeTaskInSolution(int machine, int position, Problem p) {
		
		int task = this.getTaskInMachines(machine, position);
		
		PMProblem pm = null;
		if (p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		int processing_time, previous_task, next_task;
		int setup_time1 = 0, setup_time2 = 0;
		
		processing_time = pm.getProcessingTime(task, machine);
		
		if (this.machines[machine].getTasksNumber() != 1) {
			if (position  == 0) {
				next_task = this.machines[machine].getTasksInMachine(position + 1);
				setup_time1 = pm.getSetupTime(machine, task, next_task);
			}
			else {
				if (position == (this.machines[machine].getTasksNumber() - 1)) {
					previous_task = this.machines[machine].getTasksInMachine(position - 1);
					setup_time1 = pm.getSetupTime(machine, previous_task, task);
				}
				else {
					previous_task = this.machines[machine].getTasksInMachine(position - 1);
					next_task = this.machines[machine].getTasksInMachine(position + 1);
					setup_time1 = pm.getSetupTime(machine, previous_task, task) + pm.getSetupTime(machine, task, next_task);
					setup_time2 = pm.getSetupTime(machine, previous_task, next_task);
				}
			}
			
			for(int i = position; i < this.machines[machine].getTasksNumber()-1; i++) {
				this.machines[machine].setTasksInMachine(this.machines[machine].getTasksInMachine(i+1), i);
			}
		}
		
		this.machines[machine].setTotalTime(this.machines[machine].getTotalTime() - processing_time - setup_time1 + setup_time2);
		this.machines[machine].setTasksNumber(this.machines[machine].getTasksNumber() - 1);
	}
	
	
	//shift on two machine
	public boolean shiftPMInter(int pos_task1, int machine1, int pos_task2, int machine2, PMProblem p) {
		
		int task1 = this.getTaskInMachines(machine1, pos_task1);
		
		//Remove
		this.removeTaskInSolution(machine1, pos_task1, p);
		
		//Insertion
		this.insertTaskInSolutioninPosition(task1, pos_task2, machine2, p);
		
		//Update objective function
		this.calculateObjectiveFunction(p);
		
		return true;
	}
	
	//shift on the same machine
	public boolean shiftPMIntra(int pos_task1, int machine1, int pos_task2, PMProblem p) {
		
		int task1 = this.getTaskInMachines(machine1, pos_task1);
		
		if(pos_task1 != pos_task2) {
			//Remove
			this.removeTaskInSolution(machine1, pos_task1, p);
		
			//Insertion
			this.insertTaskInSolutioninPosition(task1, pos_task2, machine1, p);
		
			//Update objective function
			this.calculateObjectiveFunction(p);
		}
		
		return true;
	}
	
	//swap on two machine
	public boolean swapPMInter(int pos_task1, int machine1, int pos_task2, int machine2, PMProblem p) {
		
		int task1 = this.getTaskInMachines(machine1, pos_task1);
		int task2 = this.getTaskInMachines(machine2, pos_task2);
				
		//Remove
		this.removeTaskInSolution(machine1, pos_task1, p);
		this.removeTaskInSolution(machine2, pos_task2, p);
		
		//Insertion
		this.insertTaskInSolutioninPosition(task1, pos_task2, machine2, p);
		this.insertTaskInSolutioninPosition(task2, pos_task1, machine1, p);
				
		//Update objective function
		this.calculateObjectiveFunction(p);
		
		return true;
	}
	
	//swap on the same machine
	public boolean swapPMIntra(int pos_task1, int machine1, int pos_task2, PMProblem p) {
		
		int task1 = this.getTaskInMachines(machine1, pos_task1);
		int task2 = this.getTaskInMachines(machine1, pos_task2);
		
		if(pos_task1 != pos_task2) {
			//Remove
			this.removeTaskInSolution(machine1, pos_task1, p);
			if(pos_task1 < pos_task2)
				pos_task2--;
			this.removeTaskInSolution(machine1, pos_task2, p);
		
			//Insertion
			if(pos_task1 < pos_task2) {
				this.insertTaskInSolutioninPosition(task2, pos_task1, machine1, p);
				pos_task2++;
				this.insertTaskInSolutioninPosition(task1, pos_task2, machine1, p);
			}
			else {
				this.insertTaskInSolutioninPosition(task1, pos_task2, machine1, p);
				this.insertTaskInSolutioninPosition(task2, pos_task1, machine1, p);
			}
				
			//Update objective function
			this.calculateObjectiveFunction(p);
		}
			
		return true;
	}
	
	public void testBetterTaskPositionGreedyRandom(Solution s, Element e, Problem p, int receiver_size) {
		
		PMConstructElement pm_e = null;
		if(e instanceof PMConstructElement) {
			pm_e = (PMConstructElement) e;
		}
		
		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		int pos;
		int machines[] = new int[pm_e.getRclSize()]; 
		int candidates[] = new int[pm_e.getRclSize()]; 
		
		PMConstructElement pm_e_aux = new PMConstructElement(p);
		pm_e_aux.copyValues(pm_e, p);
		
		int total = pm.getNumberOfTasks() - pm_e.getCount();
		
		int i = 0;
		int j = 1;
		while((i < pm_e.getRclSize()) && (j <= total)) {
			this.testBetterTaskPosition(s, pm_e_aux, p, receiver_size);
			machines[i] = pm_e_aux.getMachineIns();
			candidates[i] = pm_e_aux.getNextCandidate();
			pm_e_aux.setCandidateI(-1, pm_e_aux.getNextCandidate());
			i++;
			j++;
		}
		
		pos = (int)(Math.random() * i);
		
		pm_e.setMachineIns(machines[pos]);
		pm_e.setNextCandidate(candidates[pos]);
		
	}
	
	public void testBetterTaskPosition(Solution s, Element e, Problem p, int receiver_size) {
		
		PMSolution s_line = new PMSolution(receiver_size, p);
		PMSolution best_solution = new PMSolution(receiver_size, p);
		
		int best_machine = 0, best_task = 0, best_machine_task;
		int best_time_cand = -1;
		
		PMSolution sol = null;
		if(s instanceof PMSolution) {
			sol = (PMSolution) s;
		}
		
		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		PMConstructElement pm_e = null;
		if(e instanceof PMConstructElement) {
			pm_e = (PMConstructElement) e;
		}
		
		for(int i = 0; i < pm.getNumberOfTasks(); i++) {
			
			if(pm_e.getCandidateI(i) != -1) {  //-1 = candidate already used 
			
				best_machine_task = -1;
				
				for(int j = 0; j < pm.getMachinesNumber(); j++) {
					for(int k = 0; k < sol.getMachineI(j).getTasksNumber()+1; k++) {
					
						s_line.copyValuesSolution(sol, p);
						s_line.insertTaskInSolutioninPosition(pm_e.getCandidateI(i), k, j, pm);
						
						if(best_machine_task == -1) {
							best_machine_task = j;
							best_solution.copyValuesSolution(s_line, pm);
						}
						else {
							if(s_line.getMachineI(j).getTotalTime() < best_solution.getMachineI(best_machine_task).getTotalTime()){
								best_machine_task = j;
								best_solution.copyValuesSolution(s_line, pm);
							}
						}
					}
				}
				
				if((best_time_cand ==  -1) || (best_solution.getMachineI(best_machine_task).getTotalTime() < best_time_cand)) {
					best_time_cand = best_solution.getMachineI(best_machine_task).getTotalTime();
					best_machine = best_machine_task;
					best_task = i;
				}
			}
		}
		pm_e.setMachineIns(best_machine);
		pm_e.setNextCandidate(best_task);
	}
	
	/* SETS AND GETS */
	public Machine getMachineI(int i) {
		return machines[i];
	}

	public void setMachineI(Machine machines, int i) {
		this.machines[i] = machines;
	}

	public int getTaskInMachines(int machine, int i) {
		return machines[machine].getTasksInMachine(i);
	}

	public void setTaskInMachines(int machine, int i, int task) {
		this.machines[machine].setTasksInMachine(task, i);
	}

	public int getMachineNumber() {
		return machine_number;
	}


	public void setMachineNumber(int machine_number) {
		this.machine_number = machine_number;
	}
	
	public int getTaskNumberMachineI(int machine) {
		return this.getMachineI(machine).getTasksNumber();
	}
	
	public void setTaskNumberMachineI(int machine, int tasks_number) {
		this.getMachineI(machine).setTasksNumber(tasks_number);
	}

	@Override
	public void writeSolutionST(Problem p, WriterInFile fw) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
