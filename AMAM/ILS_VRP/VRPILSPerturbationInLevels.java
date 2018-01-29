package ILS_VRP;

import java.util.Random;

import Construct_VRP.VRPConstructElement;
import Cooperation.Cooperation;
import Environment.Element;
import Environment.Problem;
import Environment.Receiver;
import Environment.Solution;
import Environment_PRV_Movements.MovementVRPShiftInter;
import Environment_PRV_Movements.MovementVRPSwapInter;
import Environment_PRV_Movements.VRPMovementElement;
import Environment_VRP.VRPProblem;
import Environment_VRP.VRPSolution;
import ILS.ILSPerturbation;
import Parameters.Parameters;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the ILSPerturbation Class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPILSPerturbationInLevels implements ILSPerturbation{

	@Override
	public Solution perturbation(Solution s, Element e, int id_agent, Cooperation cooperation, Parameters parameters, Problem p) {
		// TODO Auto-generated method stub

		VRPSolution sol_perturb = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		
		VRPILSElement e_vrp = null;
		if(e instanceof VRPILSElement) {
			e_vrp = (VRPILSElement) e;
		}
		
		VRPSolution sol_vrp = null;
		if(s instanceof VRPSolution) {
			sol_vrp = (VRPSolution) s;
		}
		
		sol_perturb.copyValuesSolution(sol_vrp, p);
		
		for(int i = 0; i < 6; i++) {
		
			switch (e_vrp.getLevelPerturb()) {
				case 1: 
					//deslocamento inter-máquina de duas tarefas aleatórias 
					//sol_perturb.copyValuesSolution(this.perturbationTwoShiftInterRandom(sol_vrp, parameters, p), p);
					sol_perturb.copyValuesSolution(this.perturbationTwoShiftInterRandom(sol_perturb, parameters, p), p);
					break;
				case 2:
					//sol_perturb.copyValuesSolution(this.perturbationTwoSwapInterRandom(sol_vrp, parameters, p), p);
					sol_perturb.copyValuesSolution(this.perturbationTwoSwapInterRandom(sol_perturb, parameters, p), p);
					break;
				case 3:
					//deslocamento inter-máquina de três tarefas aleatórias
					//sol_perturb.copyValuesSolution(this.perturbationThreeShiftInterRandom(sol_vrp,parameters, p), p);
					sol_perturb.copyValuesSolution(this.perturbationThreeShiftInterRandom(sol_perturb,parameters, p), p);
					break;
				case 4:
					//sol_perturb.copyValuesSolution(this.perturbationThreeSwapInterRandom(sol_vrp, parameters, p), p);
					sol_perturb.copyValuesSolution(this.perturbationThreeSwapInterRandom(sol_perturb, parameters, p), p);
					break;
				case 5:
					//sol_perturb.copyValuesSolution(this.perturbationThreeShifInterConsecutive(sol_vrp, parameters, p), p);
					sol_perturb.copyValuesSolution(this.perturbationThreeShifInterConsecutive(sol_perturb, parameters, p), p);
					break;
				case 6:
					//sol_perturb.copyValuesSolution(this.perturbationEliminatesSmallRoute(sol_vrp, parameters, p), p);
					sol_perturb.copyValuesSolution(this.perturbationEliminatesSmallRoute(sol_perturb, parameters, p), p);
					if(sol_vrp.getNumberRoutes() < sol_perturb.getNumberRoutes())
						System.out.println("\nDIMINUIU O NÚMERO DE ROTAS!");
					break;
				case 7:
					//sol_perturb.copyValuesSolution(this.perturbationEliminatesRandomRoute(sol_vrp, parameters, p), p);
					sol_perturb.copyValuesSolution(this.perturbationEliminatesRandomRoute(sol_perturb, parameters, p), p);
					if(sol_vrp.getNumberRoutes() < sol_perturb.getNumberRoutes())
						System.out.println("\nDIMINUIU O NÚMERO DE ROTAS!");
					break;
				case 8:
					long solution_time = System.currentTimeMillis() - parameters.getMethodParametersI(id_agent).getInitialTime();
					sol_perturb.copyValuesSolution(cooperation.getPool().getRandomSolutionCollection(id_agent, solution_time), p);
					Receiver receiver = new Receiver(parameters.getExperimentParameters().getReceiverSize());
					sol_perturb.setReceiver(receiver);
					break;
				default:
					System.out.println("\n\nInvalid Pertubation Function!");
			}
			
		}
		return sol_perturb;
		
	}
	
	private Solution perturbationTwoShiftInterRandom(VRPSolution s, Parameters parameters, Problem p) {
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		VRPSolution sol = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		sol.copyValuesSolution(s, vrp);
		
		int pos_client1, route1, client, count;
		Random generator = new Random();
		VRPMovementElement e = new VRPMovementElement();
		VRPConstructElement e_better = new VRPConstructElement(p);
		MovementVRPShiftInter movement_shif_inter = new MovementVRPShiftInter("shift_inter");
		
		count = 0;
		//shift one
		do{
			route1 = generator.nextInt(s.getNumberRoutes());
			if(s.getRouteI(route1).getNumberClientsRoute() != 0) { 
				pos_client1 = generator.nextInt(s.getRouteI(route1).getNumberClientsRoute());
				pos_client1++;
			}
			else
				pos_client1 = 1;
			 
			client = s.getClientInSolution(route1, pos_client1);
			s.testBetterPositionInOtherRoute(client, route1, e_better, vrp, parameters.getExperimentParameters().getReceiverSize());
			count++;
		} while((e_better.getRouteIns() == -1) && (count < 100));
			
		e.setRoute1(route1);
		e.setPositionClient1(pos_client1);
		e.setRoute2(e_better.getRouteIns());
		e.setPositionClient2(e_better.getPosIns());
		
		if((e.getRoute2() != -1) && (e.getPositionClient2() != -1)) {
			sol.copyValuesSolution(movement_shif_inter.movement(s, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
			
		count = 0;
		do{
			route1 = generator.nextInt(sol.getNumberRoutes());
			if(sol.getRouteI(route1).getNumberClientsRoute() != 0) { 
				pos_client1 = generator.nextInt(sol.getRouteI(route1).getNumberClientsRoute());
				pos_client1++;
			}
			else
				pos_client1 = 1;
			 
			client = sol.getClientInSolution(route1, pos_client1);
			sol.testBetterPositionInOtherRoute(client, route1, e_better, vrp, parameters.getExperimentParameters().getReceiverSize());
			count++;
		} while ((e_better.getRouteIns() == -1) && (count < 100));
			
		e.setRoute1(route1);
		e.setPositionClient1(pos_client1);
		e.setRoute2(e_better.getRouteIns());
		e.setPositionClient2(e_better.getPosIns());
		
		if((e.getRoute2() != -1) && (e.getPositionClient2() != -1)) {
			sol.copyValuesSolution(movement_shif_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		return sol;
	}

	private Solution perturbationThreeShiftInterRandom(VRPSolution s, Parameters parameters, Problem p) {
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		VRPSolution sol = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		sol.copyValuesSolution(s, vrp);
		
		int pos_client1, route1, client, count;
		Random generator = new Random();
		VRPMovementElement e = new VRPMovementElement();
		VRPConstructElement e_better = new VRPConstructElement(p);
		MovementVRPShiftInter movement_shif_inter = new MovementVRPShiftInter("shift_inter");
		
		count = 0;
		//shift one
		do{
			route1 = generator.nextInt(s.getNumberRoutes());
			if(s.getRouteI(route1).getNumberClientsRoute() != 0) { 
				pos_client1 = generator.nextInt(s.getRouteI(route1).getNumberClientsRoute());
				pos_client1++;
			}
			else
				pos_client1 = 1;
			 
			client = s.getClientInSolution(route1, pos_client1);
			s.testBetterPositionInOtherRoute(client, route1, e_better, vrp, parameters.getExperimentParameters().getReceiverSize());
			count++;
		} while((e_better.getRouteIns() == -1) && (count < 100));
			
		e.setRoute1(route1);
		e.setPositionClient1(pos_client1);
		e.setRoute2(e_better.getRouteIns());
		e.setPositionClient2(e_better.getPosIns());
		
		if((e.getRoute2() != -1) && (e.getPositionClient2() != -1)) {
			sol.copyValuesSolution(movement_shif_inter.movement(s, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		count = 0;
		do{
			route1 = generator.nextInt(sol.getNumberRoutes());
			if(sol.getRouteI(route1).getNumberClientsRoute() != 0) { 
				pos_client1 = generator.nextInt(sol.getRouteI(route1).getNumberClientsRoute());
				pos_client1++;
			}
			else
				pos_client1 = 1;
			 
			client = sol.getClientInSolution(route1, pos_client1);
			sol.testBetterPositionInOtherRoute(client, route1, e_better, vrp, parameters.getExperimentParameters().getReceiverSize());
			count++;
		} while((e_better.getRouteIns() == -1) && (count < 100));
			
		e.setRoute1(route1);
		e.setPositionClient1(pos_client1);
		e.setRoute2(e_better.getRouteIns());
		e.setPositionClient2(e_better.getPosIns());
		
		if((e.getRoute2() != -1) && (e.getPositionClient2() != -1)) {
			sol.copyValuesSolution(movement_shif_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		count = 0;
		do{
			route1 = generator.nextInt(sol.getNumberRoutes());
			if(sol.getRouteI(route1).getNumberClientsRoute() != 0) { 
				pos_client1 = generator.nextInt(sol.getRouteI(route1).getNumberClientsRoute());
				pos_client1++;
			}
			else
				pos_client1 = 1;
			 
			client = sol.getClientInSolution(route1, pos_client1);
			sol.testBetterPositionInOtherRoute(client, route1, e_better, vrp, parameters.getExperimentParameters().getReceiverSize());
			count++;
		} while((e_better.getRouteIns() == -1) && (count < 100));
			
		e.setRoute1(route1);
		e.setPositionClient1(pos_client1);
		e.setRoute2(e_better.getRouteIns());
		e.setPositionClient2(e_better.getPosIns());
		
		if((e.getRoute2() != -1) && (e.getPositionClient2() != -1)) {
			sol.copyValuesSolution(movement_shif_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		return sol;	
	}
	
	private Solution perturbationTwoSwapInterRandom(VRPSolution s, Parameters parameters, Problem p) {
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		VRPSolution sol = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		sol.copyValuesSolution(s, vrp);
		
		int pos_client1, route1, count;
		Random generator = new Random();
		VRPMovementElement e = new VRPMovementElement();
		VRPConstructElement e_better = new VRPConstructElement(p);
		MovementVRPSwapInter movement_swap_inter = new MovementVRPSwapInter("swap_inter");
		
		count = 0;
		//swap one
		do{
			route1 = generator.nextInt(s.getNumberRoutes());
			if(s.getRouteI(route1).getNumberClientsRoute() != 0) { 
				pos_client1 = generator.nextInt(s.getRouteI(route1).getNumberClientsRoute());
				pos_client1++;
			}
			else
				pos_client1 = 1;
			 
			s.testFirstPosition(pos_client1, route1, e_better, vrp, parameters.getExperimentParameters().getReceiverSize());
			count++;
		} while((e_better.getRouteIns() == -1) && (e_better.getPosIns() == -1) && (count < 100));
		
		e.setRoute1(route1);
		e.setPositionClient1(pos_client1);
		e.setRoute2(e_better.getRouteIns());
		e.setPositionClient2(e_better.getPosIns());
		
		if((e.getRoute2() != -1) && (e.getPositionClient2() != -1)) {
			sol.copyValuesSolution(movement_swap_inter.movement(s, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		count = 0;
		//swap two
		do{
			route1 = generator.nextInt(sol.getNumberRoutes());
			if(sol.getRouteI(route1).getNumberClientsRoute() != 0) { 
				pos_client1 = generator.nextInt(sol.getRouteI(route1).getNumberClientsRoute());
				pos_client1++;
			}
			else
				pos_client1 = 1;
					 
			sol.testFirstPosition(pos_client1, route1, e_better, vrp, parameters.getExperimentParameters().getReceiverSize());
			count++;
		} while((e_better.getRouteIns() == -1) && (e_better.getPosIns() == -1) && (count < 100));
					
		e.setRoute1(route1);
		e.setPositionClient1(pos_client1);
		e.setRoute2(e_better.getRouteIns());
		e.setPositionClient2(e_better.getPosIns());
		
		if((e.getRoute2() != -1) && (e.getPositionClient2() != -1)) {
			sol.copyValuesSolution(movement_swap_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		return sol;
	}
	
	private Solution perturbationThreeSwapInterRandom(VRPSolution s, Parameters parameters, Problem p) {
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		VRPSolution sol = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		sol.copyValuesSolution(s, vrp);
		
		int pos_client1, route1, count;
		Random generator = new Random();
		VRPMovementElement e = new VRPMovementElement();
		VRPConstructElement e_better = new VRPConstructElement(p);
		MovementVRPSwapInter movement_swap_inter = new MovementVRPSwapInter("swap_inter");
		
		count = 0;
		//swap one
		do{
			route1 = generator.nextInt(s.getNumberRoutes());
			if(s.getRouteI(route1).getNumberClientsRoute() != 0) { 
				pos_client1 = generator.nextInt(s.getRouteI(route1).getNumberClientsRoute());
				pos_client1++;
			}
			else
				pos_client1 = 1;
			 
			s.testFirstPosition(pos_client1, route1, e_better, vrp, parameters.getExperimentParameters().getReceiverSize());
			count++;
		} while((e_better.getRouteIns() == -1) && (e_better.getPosIns() == -1) && (count < 100));
		
		e.setRoute1(route1);
		e.setPositionClient1(pos_client1);
		e.setRoute2(e_better.getRouteIns());
		e.setPositionClient2(e_better.getPosIns());
		
		if((e.getRoute2() != -1) && (e.getPositionClient2() != -1)) {
			sol.copyValuesSolution(movement_swap_inter.movement(s, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		count = 0;
		//swap two
		do{
			route1 = generator.nextInt(sol.getNumberRoutes());
			if(sol.getRouteI(route1).getNumberClientsRoute() != 0) { 
				pos_client1 = generator.nextInt(sol.getRouteI(route1).getNumberClientsRoute());
				pos_client1++;
			}
			else
				pos_client1 = 1;
					 
			sol.testFirstPosition(pos_client1, route1, e_better, vrp, parameters.getExperimentParameters().getReceiverSize());
			count++;
		} while((e_better.getRouteIns() == -1) && (e_better.getPosIns() == -1) && (count < 100));
					
		e.setRoute1(route1);
		e.setPositionClient1(pos_client1);
		e.setRoute2(e_better.getRouteIns());
		e.setPositionClient2(e_better.getPosIns());
		
		if((e.getRoute2() != -1) && (e.getPositionClient2() != -1)) {
			sol.copyValuesSolution(movement_swap_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		count = 0;
		//swap two
		do{
			route1 = generator.nextInt(sol.getNumberRoutes());
			if(sol.getRouteI(route1).getNumberClientsRoute() != 0) { 
				pos_client1 = generator.nextInt(sol.getRouteI(route1).getNumberClientsRoute());
				pos_client1++;
			}
			else
				pos_client1 = 1;
					 
			sol.testFirstPosition(pos_client1, route1, e_better, vrp, parameters.getExperimentParameters().getReceiverSize());
			count++;
		} while((e_better.getRouteIns() == -1) && (e_better.getPosIns() == -1) && (count < 100));
					
		e.setRoute1(route1);
		e.setPositionClient1(pos_client1);
		e.setRoute2(e_better.getRouteIns());
		e.setPositionClient2(e_better.getPosIns());
		
		if((e.getRoute2() != -1) && (e.getPositionClient2() != -1)) {
			sol.copyValuesSolution(movement_swap_inter.movement(sol, parameters.getExperimentParameters().getReceiverSize(), e, p), p);
		}
		
		return sol;
	}

	private Solution perturbationThreeShifInterConsecutive(VRPSolution s, Parameters parameters, Problem p) {
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		int route, position;
		Random generator = new Random();
	
		VRPSolution sol = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		sol.copyValuesSolution(s, vrp);
	
		route = generator.nextInt(s.getNumberRoutes());
		position = generator.nextInt(s.getRouteI(route).getNumberClientsRoute());
		position++;
		
		sol.nShiftForBestPositionInter(5, route, position, vrp, parameters.getExperimentParameters().getReceiverSize());
		
		return sol;
	}
	
	private Solution perturbationEliminatesSmallRoute(VRPSolution s, Parameters parameters, Problem p) {
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		VRPSolution sol = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		sol.copyValuesSolution(s, vrp);
		
		if(sol.eliminatesSmallRoute(vrp, parameters.getExperimentParameters().getReceiverSize()))
			return sol;
		else
			return s;
	}
	
	private Solution perturbationEliminatesRandomRoute(VRPSolution s, Parameters parameters, Problem p) {
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		VRPSolution sol = new VRPSolution(parameters.getExperimentParameters().getReceiverSize(), p);
		sol.copyValuesSolution(s, vrp);
		
		if(sol.eliminatesRandomRoute(vrp, parameters.getExperimentParameters().getReceiverSize()))
			return sol;
		else
			return s;
	}
	
}
