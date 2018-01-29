package Local_Search_VRP;

import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_PRV_Movements.VRPMovementElement;
import Environment_VRP.VRPSolution;
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

public class VRPBestNeighborCompleteDescentMultiObjective implements BestNeighbor{

	private VRPSolution s_initial;
	private VRPSolution best_neighbor;
	private VRPSolution s_line;
	
	private VRPMovementElement element;
	
	@Override
	public Solution bestNeighbor(int neighborhood, MoveNeighborhood movement_neighborhood, 
			AcceptationCriteria criteria, Solution so, Parameters parameters, 
			Element e, Problem p) {
		// TODO Auto-generated method stub
		
		int k = neighborhood;
		
		this.s_initial = null;
		if(so instanceof VRPSolution) {
			this.s_initial = (VRPSolution) so;
		}		
		this.element = null;
		if(e instanceof VRPMovementElement) {
			this.element = (VRPMovementElement) e;
		}
		this.best_neighbor = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		this.s_line = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		
		this.best_neighbor.copyValuesSolution(this.s_initial, p);
		this.s_line.copyValuesSolution(this.s_initial, p);
		
		
		if(movement_neighborhood.getList().getMoveI(k).getMoveType() == "shift_inter") {
			this.bestNeighborShiftInter(k, movement_neighborhood, criteria, parameters, e, p);
		}
		//if(movement_neighborhood.getList().getMoveI(k).getMoveType() == "shift_intra") {
			//this.bestNeighborShiftIntra(k, movement_neighborhood, criteria, parameters, e, p);
		//}
		if(movement_neighborhood.getList().getMoveI(k).getMoveType() == "swap_inter") {
			this.bestNeighborSwapInter(k, movement_neighborhood, criteria, parameters, e, p);
		}
		//if(movement_neighborhood.getList().getMoveI(k).getMoveType() == "swap_intra") {
			//this.bestNeighborSwapIntra(k, movement_neighborhood, criteria, parameters, e,  p);
		//}
		if(movement_neighborhood.getList().getMoveI(k).getMoveType() == "eliminate") {
			this.bestNeighborEliminateSmallRoute(k, movement_neighborhood, criteria, parameters, e, p);
			//if(this.best_neighbor.getNumberRoutes() < this.s_line.getNumberRoutes())
				//System.out.println("\nDIMINUIU O NÚMERO DE ROTAS!");
			//this.element.setCount(this.element.getCount()+1);
			//System.out.println("\nCount: " + this.element.getCount());
		}
		
		return this.best_neighbor;
	}

	public void bestNeighborShiftInter(int neighborhood, MoveNeighborhood movement_neighborhood,
			AcceptationCriteria criteria, Parameters parameters, Element e, Problem p) {
		
		this.element.nullBestCurrentSolution();
		
		for(int i = 0; i < this.s_initial.getNumberRoutes(); i++){
			for(int j = 1; j <= this.s_initial.getRouteI(i).getNumberClientsRoute(); j++) {
				for(int k = i+1; k < this.s_initial.getNumberRoutes(); k++) {
					for(int l = 1; l <= (this.s_initial.getRouteI(k).getNumberClientsRoute() + 1); l++) {
						this.element.setRoute1(i);
						this.element.setPositionClient1(j);
						this.element.setRoute2(k);
						this.element.setPositionClient2(l);
					
						//implementa o movimento de acordo com a vizinhança "neighborhood"
						this.s_line.copyValuesSolution(movement_neighborhood.moveNeighborhood(neighborhood, 
								this.s_line, parameters, element, p), p);
						
						if(this.element.isValid()) {
							if(criteria.acceptationCriteria(this.s_line, this.best_neighbor, element, p)) {
								this.best_neighbor.copyValuesSolution(this.s_line, p);
							}	
						}
						else {
							//atribuir penalidade por solução não válida
							this.s_line.setObjectiveFunctionI(0, 2*this.s_line.getObjectiveFunctionI(0));
						}
						
						if(this.element.getBestCurrentSolution() == null) {
							this.element.newBestCurrentSolution(new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p));
							this.element.setBestCurrentSolution(this.s_line, p);
						}
						else {
							if(criteria.acceptationCriteria(this.s_line, this.element.getBestCurrentSolution(), element, p)) {
								this.element.setBestCurrentSolution(this.s_line, p);
							}
						}
						
						this.s_line.copyValuesSolution(this.s_initial, p);
					}
				}
			}
		}
	}

	public void bestNeighborShiftIntra(int neighborhood, MoveNeighborhood movement_neighborhood,
			AcceptationCriteria criteria, Parameters parameters, Element e, Problem p) {

		this.element.nullBestCurrentSolution();
		
		for(int i = 0; i < this.s_initial.getNumberRoutes(); i++){
			for(int j = 1; j <= this.s_initial.getRouteI(i).getNumberClientsRoute(); j++) {
				for(int l = 1; l <= (this.s_initial.getRouteI(i).getNumberClientsRoute()); l++) {
					if(j != l) {
						this.element.setRoute1(i);
						this.element.setPositionClient1(j);
						this.element.setRoute2(i);
						this.element.setPositionClient2(l);
				
						//implementa o movimento de acordo com a vizinhança "neighborhood"
						this.s_line.copyValuesSolution(movement_neighborhood.moveNeighborhood(neighborhood, 
								this.s_line, parameters, element, p), p);
							
						if(this.element.isValid()) {
							if(criteria.acceptationCriteria(this.s_line, this.best_neighbor, element, p)) {
								this.best_neighbor.copyValuesSolution(this.s_line, p);
							}
						}
						else {
							//atribuir penalidade por solução não válida
							this.s_line.setObjectiveFunctionI(0, 2*this.s_line.getObjectiveFunctionI(0));
						}
						
						if(this.element.getBestCurrentSolution() == null) {
							this.element.newBestCurrentSolution(new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p));
							this.element.setBestCurrentSolution(this.s_line, p);
						}
						else {
							if(criteria.acceptationCriteria(this.s_line, this.element.getBestCurrentSolution(), element, p)) {
								this.element.setBestCurrentSolution(this.s_line, p);
							}
						}
						
						this.s_line.copyValuesSolution(this.s_initial, p);
					}
				}
			}
		}
	}

	public void bestNeighborSwapInter(int neighborhood, MoveNeighborhood movement_neighborhood,
			AcceptationCriteria criteria, Parameters parameters, Element e, Problem p) {

		this.element.nullBestCurrentSolution();
		
		for(int i = 0; i < this.s_initial.getNumberRoutes()-1; i++){
			for(int j = 1; j <= this.s_initial.getRouteI(i).getNumberClientsRoute(); j++) {
				for(int k = i+1; k < this.s_initial.getNumberRoutes(); k++) {
					for(int l = 1; l <= (this.s_initial.getRouteI(k).getNumberClientsRoute()); l++) {
						this.element.setRoute1(i);
						this.element.setPositionClient1(j);
						this.element.setRoute2(k);
						this.element.setPositionClient2(l);
					
						//implementa o movimento de acordo com a vizinhança "neighborhood"
						this.s_line.copyValuesSolution(movement_neighborhood.moveNeighborhood(neighborhood, 
								this.s_line, parameters, element, p), p);
						
						if(this.element.isValid()) {
							if(criteria.acceptationCriteria(this.s_line, this.best_neighbor, element, p)) {
								this.best_neighbor.copyValuesSolution(this.s_line, p);
							}
						}
						else {
							//atribuir penalidade por solução não válida
							this.s_line.setObjectiveFunctionI(0, 2*this.s_line.getObjectiveFunctionI(0));
						}
						
						if(this.element.getBestCurrentSolution() == null) {
							this.element.newBestCurrentSolution(new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p));
							this.element.setBestCurrentSolution(this.s_line, p);
						}
						else {
							if(criteria.acceptationCriteria(this.s_line, this.element.getBestCurrentSolution(), element, p)) {
								this.element.setBestCurrentSolution(this.s_line, p);
							}
						}
						
						this.s_line.copyValuesSolution(this.s_initial, p);
					}
				}
			}
		}
	}

	public void bestNeighborSwapIntra(int neighborhood, MoveNeighborhood movement_neighborhood,
			AcceptationCriteria criteria, Parameters parameters, Element e, Problem p) {

		this.element.nullBestCurrentSolution();
		
		for(int i = 0; i < this.s_initial.getNumberRoutes(); i++){
			for(int j = 1; j <= this.s_initial.getRouteI(i).getNumberClientsRoute(); j++) {
				for(int l = j+1; l <= (this.s_initial.getRouteI(i).getNumberClientsRoute()); l++) {
					if(j != l) {
						this.element.setRoute1(i);
						this.element.setPositionClient1(j);
						this.element.setRoute2(i);
						this.element.setPositionClient2(l);
				
						//implementa o movimento de acordo com a vizinhança "neighborhood"
						this.s_line.copyValuesSolution(movement_neighborhood.moveNeighborhood(neighborhood, 
								this.s_line, parameters, element, p), p);
							
						if(this.element.isValid()) {
							if(criteria.acceptationCriteria(this.s_line, this.best_neighbor, element, p)) {
								this.best_neighbor.copyValuesSolution(this.s_line, p);
							}
						}
						else {
							//atribuir penalidade por solução não válida
							this.s_line.setObjectiveFunctionI(0, 2*this.s_line.getObjectiveFunctionI(0));
						}
						
						if(this.element.getBestCurrentSolution() == null) {
							this.element.newBestCurrentSolution(new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p));
							this.element.setBestCurrentSolution(this.s_line, p);
						}
						else {
							if(criteria.acceptationCriteria(this.s_line, this.element.getBestCurrentSolution(), element, p)) {
								this.element.setBestCurrentSolution(this.s_line, p);
							}
						}
						
						this.s_line.copyValuesSolution(this.s_initial, p);
					}
				}
			}
		}
	}
	
	public void bestNeighborEliminateSmallRoute(int neighborhood, MoveNeighborhood movement_neighborhood, 
			AcceptationCriteria criteria, Parameters parameters, Element e, Problem p) {
	
		this.best_neighbor.copyValuesSolution(movement_neighborhood.moveNeighborhood(neighborhood, this.s_line, parameters, element, p), p);
		this.element.newBestCurrentSolution(new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p));
		this.element.setBestCurrentSolution(this.best_neighbor, p);
	}

}
