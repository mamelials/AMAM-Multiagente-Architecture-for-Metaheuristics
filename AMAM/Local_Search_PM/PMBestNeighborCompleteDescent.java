package Local_Search_PM;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_PM.PMProblem;
import Environment_PM.PMSolution;
import Environment_PM_Movements.PMMovementElement;
import Function_Package.AcceptationCriteria;
import Local_Search.BestNeighbor;
import Local_Search.MoveNeighborhood;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the BestNeighbor Class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMBestNeighborCompleteDescent implements BestNeighbor{

	private PMSolution s_initial;
	private PMSolution best_neighbor;
	private PMSolution s_line;
	
	private PMMovementElement element;
	
	@Override
	public Solution bestNeighbor(int neighborhood, MoveNeighborhood movement_neighborhood, 
			AcceptationCriteria criteria, Solution so, Parameters parameters, 
			Element e, Problem p) {
		// TODO Auto-generated method stub
		
		//int k = neighborhood;
		
		this.s_initial = null;
		if(so instanceof PMSolution) {
			this.s_initial = (PMSolution) so;
		}		
		this.element = null;
		if(e instanceof PMMovementElement) {
			this.element = (PMMovementElement) e;
		}
		this.best_neighbor = new PMSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.s_line = new PMSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		
		this.best_neighbor.copyValuesSolution(this.s_initial, p);
		this.s_line.copyValuesSolution(this.s_initial, p);
		
		
		if(movement_neighborhood.getList().getMoveI(neighborhood).getMoveType() == "shift_inter") {
			this.bestNeighborShiftInter(neighborhood, movement_neighborhood, criteria, parameters, p);
		}
		if(movement_neighborhood.getList().getMoveI(neighborhood).getMoveType() == "shift_intra") {
			this.bestNeighborShiftIntra(neighborhood, movement_neighborhood, criteria, parameters, p);
		}
		if(movement_neighborhood.getList().getMoveI(neighborhood).getMoveType() == "swap_inter") {
			this.bestNeighborSwapInter(neighborhood, movement_neighborhood, criteria, parameters, p);
		}
		if(movement_neighborhood.getList().getMoveI(neighborhood).getMoveType() == "swap_intra") {
			this.bestNeighborSwapIntra(neighborhood, movement_neighborhood, criteria, parameters, p);
		}
		return this.best_neighbor;
	}

	public void bestNeighborShiftInter(int neighborhood, MoveNeighborhood movement_neighborhood,
			AcceptationCriteria criteria, Parameters parameters, Problem p) {

		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		for(int i = 0; i < pm.getMachinesNumber(); i++){
			for(int j = 0; j < this.s_initial.getMachineI(i).getTasksNumber(); j++) {
				for(int k = 0; k < pm.getMachinesNumber(); k++) {
					if(i != k) {
						for(int l = 0; l <= (this.s_initial.getMachineI(k).getTasksNumber()); l++) {
							if(l < pm.getNumberOfTasks()) {
								this.element.setMachine1(i);
								this.element.setPositionTask1(j);
								this.element.setMachine2(k);
								this.element.setPositionTask2(l);
							
								//implementa o movimento de acordo com a vizinhança "neighborhood"
								this.s_line.copyValuesSolution(movement_neighborhood.moveNeighborhood(neighborhood, 
										this.s_line, parameters, element, p), p);
								
								if(this.element.isValid()) {
									if(criteria.acceptationCriteria(this.s_line, this.best_neighbor, element, p)) {
										this.best_neighbor.copyValuesSolution(this.s_line, p);
									}	
								}
								this.s_line.copyValuesSolution(this.s_initial, p);
							}
						}
					}
				}
			}
		}
	}
	
	public void bestNeighborShiftIntra(int neighborhood, MoveNeighborhood movement_neighborhood,
			AcceptationCriteria criteria, Parameters parameters, Problem p) {

		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		int makespan_machine = this.s_initial.searchMakespanMachine(pm);
		
		//for(int i = 0; i < pm.getMachinesNumber(); i++){
			for(int j = 0; j < this.s_initial.getMachineI(makespan_machine).getTasksNumber(); j++) {
				for(int l = 0; l < this.s_initial.getMachineI(makespan_machine).getTasksNumber(); l++) {
					if(j != l) {
						this.element.setMachine1(makespan_machine);
						this.element.setPositionTask1(j);
						this.element.setMachine2(makespan_machine);
						this.element.setPositionTask2(l);
				
						//implementa o movimento de acordo com a vizinhança "neighborhood"
						this.s_line.copyValuesSolution(movement_neighborhood.moveNeighborhood(neighborhood, 
								this.s_line, parameters, element, p), p);
							
						if(this.element.isValid()) {
							if(criteria.acceptationCriteria(this.s_line, this.best_neighbor, element, p)) {
								this.best_neighbor.copyValuesSolution(this.s_line, p);
							}	
						}
						this.s_line.copyValuesSolution(this.s_initial, p);
					}
				}
			}
		//}
	}
	
	public void bestNeighborSwapInter(int neighborhood, MoveNeighborhood movement_neighborhood, 
			AcceptationCriteria criteria, Parameters parameters, Problem p) {

		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		for(int i = 0; i < pm.getMachinesNumber()-1; i++){
			for(int j = 0; j < this.s_initial.getMachineI(i).getTasksNumber(); j++) {
				for(int k = i+1; k < pm.getMachinesNumber(); k++) {
					for(int l = 0; l < this.s_initial.getMachineI(k).getTasksNumber(); l++) {
						this.element.setMachine1(i);
						this.element.setPositionTask1(j);
						this.element.setMachine2(k);
						this.element.setPositionTask2(l);
					
						//implementa o movimento de acordo com a vizinhança "neighborhood"
						this.s_line.copyValuesSolution(movement_neighborhood.moveNeighborhood(neighborhood, 
								this.s_line, parameters, element, p), p);
						
						if(this.element.isValid()) {
							if(criteria.acceptationCriteria(this.s_line, this.best_neighbor, element, p)) {
								this.best_neighbor.copyValuesSolution(this.s_line, p);
							}	
						}
						this.s_line.copyValuesSolution(this.s_initial, p);
					}
				}
			}
		}
	}

	public void bestNeighborSwapIntra(int neighborhood, MoveNeighborhood movement_neighborhood,
			AcceptationCriteria criteria, Parameters parameters, Problem p) {

		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		int makespan_machine = this.s_initial.searchMakespanMachine(pm);
		
		//for(int i = 0; i < pm.getMachinesNumber(); i++){
			for(int j = 0; j < this.s_initial.getMachineI(makespan_machine).getTasksNumber(); j++) {
				for(int l = j+1; l < this.s_initial.getMachineI(makespan_machine).getTasksNumber(); l++) {
					if(j != l) {
						this.element.setMachine1(makespan_machine);
						this.element.setPositionTask1(j);
						this.element.setMachine2(makespan_machine);
						this.element.setPositionTask2(l);
				
						//implementa o movimento de acordo com a vizinhança "neighborhood"
						this.s_line.copyValuesSolution(movement_neighborhood.moveNeighborhood(neighborhood, 
								this.s_line, parameters, element, p), p);
							
						if(this.element.isValid()) {
							if(criteria.acceptationCriteria(this.s_line, this.best_neighbor, element, p)) {
								this.best_neighbor.copyValuesSolution(this.s_line, p);
							}	
						}
						this.s_line.copyValuesSolution(this.s_initial, p);
					}
				}
			}
		//}
	}
	
}
