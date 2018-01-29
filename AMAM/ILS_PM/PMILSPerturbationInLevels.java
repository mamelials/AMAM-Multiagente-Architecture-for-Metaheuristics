package ILS_PM;

import java.util.Random;

import Cooperation.Cooperation;
import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_PM.PMSolution;
import Environment_PM_Movements.MovementPMShiftInter;
import Environment_PM_Movements.MovementPMSwapInter;
import Environment_PM_Movements.PMMovementElement;
import ILS.ILSPerturbation;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the ILSPerturbation Class. 
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMILSPerturbationInLevels implements ILSPerturbation{

	@Override
	public Solution perturbation(Solution s, Element e, int id_agent, Cooperation coopertation, Parameters parameters, Problem p) {
		// TODO Auto-generated method stub
		
		Solution sol_perturb = new PMSolution(1, p);
		
		PMILSElement e_pm = null;
		if(e instanceof PMILSElement) {
			e_pm = (PMILSElement) e;
		}
		
		PMSolution sol_pm = null;
		if(s instanceof PMSolution) {
			sol_pm = (PMSolution) s;
		}
		
		switch (e_pm.getLevelPerturb()) {
			case 1: 
				//deslocamento inter-máquina de duas tarefas aleatórias 
				sol_perturb.copyValuesSolution(this.perturbationTwoShiftInterRandom(sol_pm, parameters, p), p);
				break;
			case 2: 
				sol_perturb.copyValuesSolution(this.perturbationThreeShiftInterRandom(sol_pm, parameters, p), p);
				break;
			case 3:
				sol_perturb.copyValuesSolution(this.perturbationThreeShiftInterConsecutive(sol_pm, parameters, p), p);
				break;
			//case 4:
				//n tarefas em sequência - por enquanto 3
				//sol_perturb.copyValuesSolution(this.perturbationTwoSwapInterRandom(sol_pm, parameters, p), p);
				//break;
			default:
				System.out.println("\n\nInvalid Pertubation Function!");
		}
		
		return sol_perturb;
	}
	
	private Solution perturbationTwoShiftInterRandom(PMSolution s, Parameters parameters, Problem p) {
		
		PMSolution sol = new PMSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		
		int pos_task1, pos_task2, machine1, machine2;
		Random generator = new Random();
		PMMovementElement e = new PMMovementElement();
		MovementPMShiftInter movement_shif_inter = new MovementPMShiftInter("shift_inter");
		
		//shift one
		do{
			machine1 = generator.nextInt(s.getMachineNumber());
		}while(s.getMachineI(machine1).getTasksNumber() == 0);
		do {
			machine2 = generator.nextInt(s.getMachineNumber());
		} while((machine1 == machine2));
		
		if(s.getMachineI(machine1).getTasksNumber() != 0) 
			pos_task1 = generator.nextInt(s.getMachineI(machine1).getTasksNumber());
		else
			pos_task1 = 0;
		if(s.getMachineI(machine2).getTasksNumber() != 0)
			pos_task2 = generator.nextInt(s.getMachineI(machine2).getTasksNumber()+1);
		else
			pos_task2 = 0;
		
		e.setMachine1(machine1);
		e.setMachine2(machine2);
		e.setPositionTask1(pos_task1);
		e.setPositionTask2(pos_task2);
		
		sol.copyValuesSolution(movement_shif_inter.movement(s, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		
		//shift two
		do{
			machine1 = generator.nextInt(sol.getMachineNumber());
		}while(sol.getMachineI(machine1).getTasksNumber() == 0);
		do {
			machine2 = generator.nextInt(sol.getMachineNumber());
		} while((machine1 == machine2));
		
		if(sol.getMachineI(machine1).getTasksNumber() != 0) 
			pos_task1 = generator.nextInt(sol.getMachineI(machine1).getTasksNumber());
		else
			pos_task1 = 0;
		if(sol.getMachineI(machine2).getTasksNumber() != 0)
			pos_task2 = generator.nextInt(sol.getMachineI(machine2).getTasksNumber()+1);
		else
			pos_task2 = 0;
		
		e.setMachine1(machine1);
		e.setMachine2(machine2);
		e.setPositionTask1(pos_task1);
		e.setPositionTask2(pos_task2);
		
		sol.copyValuesSolution(movement_shif_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		
		return sol;
	}
	
	private Solution perturbationThreeShiftInterRandom(PMSolution s, Parameters parameters, Problem p) {
		
		PMSolution sol = new PMSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		
		int pos_task1, pos_task2, machine1, machine2;
		Random generator = new Random();
		PMMovementElement e = new PMMovementElement();
		MovementPMShiftInter movement_shif_inter = new MovementPMShiftInter("shift_inter");
		
		//shift one
		do{
			machine1 = generator.nextInt(s.getMachineNumber());
		}while(s.getMachineI(machine1).getTasksNumber() == 0);
		do {
			machine2 = generator.nextInt(s.getMachineNumber());
		} while((machine1 == machine2));
		
		if(s.getMachineI(machine1).getTasksNumber() != 0) 
			pos_task1 = generator.nextInt(s.getMachineI(machine1).getTasksNumber());
		else
			pos_task1 = 0;
		if(s.getMachineI(machine2).getTasksNumber() != 0)
			pos_task2 = generator.nextInt(s.getMachineI(machine2).getTasksNumber()+1);
		else
			pos_task2 = 0;
		
		e.setMachine1(machine1);
		e.setMachine2(machine2);
		e.setPositionTask1(pos_task1);
		e.setPositionTask2(pos_task2);
		
		sol.copyValuesSolution(movement_shif_inter.movement(s, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		
		//shift two
		do{
			machine1 = generator.nextInt(sol.getMachineNumber());
		}while(sol.getMachineI(machine1).getTasksNumber() == 0);
		do {
			machine2 = generator.nextInt(sol.getMachineNumber());
		} while((machine1 == machine2));
		
		if(sol.getMachineI(machine1).getTasksNumber() != 0) 
			pos_task1 = generator.nextInt(sol.getMachineI(machine1).getTasksNumber());
		else
			pos_task1 = 0;
		if(sol.getMachineI(machine2).getTasksNumber() != 0)
			pos_task2 = generator.nextInt(sol.getMachineI(machine2).getTasksNumber()+1);
		else
			pos_task2 = 0;
		
		e.setMachine1(machine1);
		e.setMachine2(machine2);
		e.setPositionTask1(pos_task1);
		e.setPositionTask2(pos_task2);
		
		sol.copyValuesSolution(movement_shif_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		
		//shift three
		do{
			machine1 = generator.nextInt(sol.getMachineNumber());
		}while(sol.getMachineI(machine1).getTasksNumber() == 0);
		do {
			machine2 = generator.nextInt(sol.getMachineNumber());
		} while((machine1 == machine2));
		
		if(sol.getMachineI(machine1).getTasksNumber() != 0) 
			pos_task1 = generator.nextInt(sol.getMachineI(machine1).getTasksNumber());
		else
			pos_task1 = 0;
		if(sol.getMachineI(machine2).getTasksNumber() != 0)
			pos_task2 = generator.nextInt(sol.getMachineI(machine2).getTasksNumber()+1);
		else
			pos_task2 = 0;
		
		e.setMachine1(machine1);
		e.setMachine2(machine2);
		e.setPositionTask1(pos_task1);
		e.setPositionTask2(pos_task2);
		
		sol.copyValuesSolution(movement_shif_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		
		return sol;
	}
	
	public Solution perturbationThreeShiftInterConsecutive(PMSolution s, Parameters parameters, Problem p) {
		
		PMSolution sol = new PMSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		
		int pos_task1, pos_task2, machine1, machine2;
		Random generator = new Random();
		PMMovementElement e = new PMMovementElement();
		MovementPMShiftInter movement_shif_inter = new MovementPMShiftInter("shift_inter");
		
		//shift one
		machine1 = generator.nextInt(s.getMachineNumber());
		do {
			machine2 = generator.nextInt(s.getMachineNumber());
		} while(machine1 == machine2);
		
		if(s.getMachineI(machine1).getTasksNumber() != 0) 
			pos_task1 = generator.nextInt(s.getMachineI(machine1).getTasksNumber());
		else
			pos_task1 = 0;
		if(s.getMachineI(machine2).getTasksNumber() != 0)
			pos_task2 = generator.nextInt(s.getMachineI(machine2).getTasksNumber()+1);
		else
			pos_task2 = 0;
		
		e.setMachine1(machine1);
		e.setMachine2(machine2);
		e.setPositionTask1(pos_task1);
		e.setPositionTask2(pos_task2);
		
		sol.copyValuesSolution(movement_shif_inter.movement(s, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		
		if(pos_task1 < sol.getMachineI(machine1).getTasksNumber()) {
			e.setMachine1(machine1);
			e.setMachine2(machine2);
			e.setPositionTask1(pos_task1);
			e.setPositionTask2(pos_task2+1);
		
			sol.copyValuesSolution(movement_shif_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		if(pos_task1 < sol.getMachineI(machine1).getTasksNumber()) {
			e.setMachine1(machine1);
			e.setMachine2(machine2);
			e.setPositionTask1(pos_task1);
			e.setPositionTask2(pos_task2+2);
		
			sol.copyValuesSolution(movement_shif_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
			
		return sol;
			
	}
	
	//ARRUMAR
	private Solution perturbationTwoSwapInterRandom(PMSolution s, Parameters parameters, Problem p) {
			
		PMSolution sol = new PMSolution(parameters.getExperimentParameters().getReceiverSize(), p);
			
		int pos_task1, pos_task2, machine1, machine2;
		Random generator = new Random();
		PMMovementElement e = new PMMovementElement();
		MovementPMSwapInter movement_swap_inter = new MovementPMSwapInter("swap_inter");
		
		//shift one
		do{
			machine1 = generator.nextInt(s.getMachineNumber());
		}while(s.getMachineI(machine1).getTasksNumber() == 0);
		do {
			machine2 = generator.nextInt(s.getMachineNumber());
		} while((machine1 == machine2) && (s.getMachineI(machine2).getTasksNumber() == 0));
		
		if(s.getMachineI(machine1).getTasksNumber() != 0) 
			pos_task1 = generator.nextInt(s.getMachineI(machine1).getTasksNumber());
		else
			pos_task1 = 0;
		if(s.getMachineI(machine2).getTasksNumber() != 0)
			pos_task2 = generator.nextInt(s.getMachineI(machine2).getTasksNumber()+1);
		else
			pos_task2 = 0;
		
		e.setMachine1(machine1);
		e.setMachine2(machine2);
		e.setPositionTask1(pos_task1);
		e.setPositionTask2(pos_task2);
		
		sol.copyValuesSolution(movement_swap_inter.movement(s, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
				
		return sol;
	}
	
	//ARRUMAR	
	public Solution perturbationThreeSwapInterConsecutive(PMSolution s, Parameters parameters, Problem p) {
		
		PMSolution sol = new PMSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		
		int pos_task1, pos_task2, machine1, machine2;
		Random generator = new Random();
		PMMovementElement e = new PMMovementElement();
		MovementPMSwapInter movement_swap_inter = new MovementPMSwapInter("swap_inter");
		
		//shift one
		machine1 = generator.nextInt(s.getMachineNumber());
		do {
			machine2 = generator.nextInt(s.getMachineNumber());
		} while(machine1 == machine2);
		
		if(s.getMachineI(machine1).getTasksNumber() != 0) 
			pos_task1 = generator.nextInt(s.getMachineI(machine1).getTasksNumber());
		else
			pos_task1 = 0;
		if(s.getMachineI(machine2).getTasksNumber() != 0)
			pos_task2 = generator.nextInt(s.getMachineI(machine2).getTasksNumber()+1);
		else
			pos_task2 = 0;
		
		e.setMachine1(machine1);
		e.setMachine2(machine2);
		e.setPositionTask1(pos_task1);
		e.setPositionTask2(pos_task2);
		
		sol.copyValuesSolution(movement_swap_inter.movement(s, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		
		pos_task1++;
		pos_task2++;
		if((pos_task1 < sol.getMachineI(machine1).getTasksNumber()) && (pos_task2 < sol.getMachineI(machine1).getTasksNumber())) {
			e.setMachine1(machine1);
			e.setMachine2(machine2);
			e.setPositionTask1(pos_task1);
			e.setPositionTask2(pos_task2);
		
			sol.copyValuesSolution(movement_swap_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		pos_task1++;
		pos_task2++;
		if((pos_task1 < sol.getMachineI(machine1).getTasksNumber()) && (pos_task2 < sol.getMachineI(machine1).getTasksNumber())) {
			e.setMachine1(machine1);
			e.setMachine2(machine2);
			e.setPositionTask1(pos_task1);
			e.setPositionTask2(pos_task2);
		
			sol.copyValuesSolution(movement_swap_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		return sol;
		
	}
	
}
