package Environment_VRP;


/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Specialized class for the Solution of the Vehicle Routing Problem  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

import java.io.IOException;
import java.util.Random;

import Construct_VRP.VRPConstructElement;
import Environment.Problem;
import Environment.Solution;
import Function_Package.WriterInFile;

public class VRPSolution extends Solution{
	
	/* ATTRIBUTES */
	private int number_routes;
	private Route solution_vector[];
	
	public VRPSolution(int receiver_size, Problem p) {
		
		super(receiver_size, p.getDimension());
		// TODO Auto-generated constructor stub
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem){
			vrp = (VRPProblem)p;
		}
		
		this.setObjectiveFunctionI(0, 0);
		this.setCostWithoutPenalty(0);
		this.setFitnessFunction(0);
		this.setNumberRoutes(0);
		
		this.solution_vector = new Route[vrp.getNumberOfClients()];
		//nenhuma rota é inicializada aqui, só serão inicializadas quando necessário	
	}

	
	@Override
	public void calculateObjectiveFunction(Problem p) {
		// TODO Auto-generated method stub
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		float cost = 0;
		for(int j = 0; j < this.number_routes; j++)
		{
			for (int i = 0; i <= this.getRouteI(j).getNumberClientsRoute(); i++)
			{
				cost = cost + vrp.getDistanceTable(this.getRouteI(j).getClientInRoute(i), this.getRouteI(j).getClientInRoute(i+1));
			}
		}
		this.setCostWithoutPenalty(cost);
		
		cost = cost + this.number_routes * vrp.getVehiclePenalty();
		
		this.setObjectiveFunctionI(0, cost);
	}

	@Override
	public void calculateFitnessFunction(double gama, Problem p) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void copyValuesSolution(Solution s, Problem p) {
		// TODO Auto-generated method stub
	
		VRPSolution vrp_sol = null;
		if(s instanceof VRPSolution) {
			vrp_sol = (VRPSolution) s;
		}
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		for(int i = 0; i < p.getDimension(); i++) {
			this.setObjectiveFunctionI(i, vrp_sol.getObjectiveFunctionI(i));
		}
		this.setCostWithoutPenalty(vrp_sol.getCostWithoutPenalty());
		this.setFitnessFunction(vrp_sol.getFitnessFunction());
		this.getSender().copyValuesSender(vrp_sol.getSender());
		this.getReceiver().copyValuesReceiver(vrp_sol.getReceiver());
		this.setSeachTime(vrp_sol.getSeachTime());
		this.number_routes = vrp_sol.number_routes;
		for(int i = 0; i < vrp_sol.number_routes; i++) {
			if(this.solution_vector[i] == null) {
				this.newRouteI(i, vrp);
			}
			this.solution_vector[i].copyValuesRoute(vrp_sol.solution_vector[i]);
		}
	}

	@Override
	public void showSolution(Problem p) {
		// TODO Auto-generated method stub
		System.out.println("\n\n  *** SOLUTION ***");
		for(int i = 0; i < p.getDimension(); i++) {
			System.out.println("Objective Function " + i + ": " + this.getObjectiveFunctionI(i));
		}
		System.out.println("Cost Without Penalty: " + this.getCostWithoutPenalty());
		System.out.println("Number of Routes: " + this.number_routes);
		System.out.println("Fitness Function: " + this.getFitnessFunction());
		System.out.println("Sender:\nid: " + this.getSender().getIdSender() + " - time: " + (this.getSender().getTimeSender()/1000.0) + "s");
		System.out.println("Receiver: ");
		for(int i = 0; i < this.getReceiver().getSize(); i++) {
			System.out.println("id: " + this.getReceiver().getIdReceiverI(i) + " - time: " + (this.getReceiver().getTimeReceiverI(i)/1000.0) + "s");
		}
		System.out.println("\nROTAS: ");
		for(int i = 0; i < this.number_routes; i++) {
			System.out.println("Route " + (i+1) + ": ");
			this.solution_vector[i].showRoute();
			System.out.println("");
		}
	}
	
	@Override
	public void showOFAndFitness(Problem p) {
		// TODO Auto-generated method stub
		for(int i = 0; i < p.getDimension(); i++) {
			System.out.println("Objective Function " + i + ": " + this.getObjectiveFunctionI(i));
		}
		System.out.println("Cost without penalty: " + this.getCostWithoutPenalty());
		System.out.println("Routes number: " + this.getNumberRoutes());
	}

	@Override
	public void writeSolution(Problem p, WriterInFile fw) throws IOException {
		// TODO Auto-generated method stub
		fw.writerTextFile("\n  *** SOLUTION ***");
		for(int i = 0; i < p.getDimension(); i++) {
			fw.writerTextFile("Objective Function: " + this.getObjectiveFunctionI(i));
		}
		fw.writerTextFile("Cost Without Penalty: " + this.getCostWithoutPenalty());
		fw.writerTextFile("Number of Routes: " + this.number_routes);
		fw.writerTextFile("Fitness Function: " + this.getFitnessFunction());
		fw.writerTextFile("Sender:\nid: " + this.getSender().getIdSender() + " - time: " + this.getSender().getTimeSender()/1000.0 + "s");
		fw.writerTextFile("Receiver: ");
		for(int i = 0; i < this.getReceiver().getSize(); i++) {
			fw.writerTextFile("id: " + this.getReceiver().getIdReceiverI(i) + " - time: " + this.getReceiver().getTimeReceiverI(i)/1000.0 + "s");
		}
		fw.writerTextFile("\nROTAS: ");
		for(int i = 0; i < this.number_routes; i++) {
			fw.writerTextFile("Route " + (i+1) + ": ");
			this.solution_vector[i].writeRoute(fw);
			fw.writerTextFile("");
		}
	}
	
	@Override
	public void writeSolutionST(Problem p, WriterInFile fw) throws IOException {
		// TODO Auto-generated method stub
		fw.writerTextFile(this.getCostWithoutPenalty() + "");
		fw.writerTextFile(this.number_routes + "");
	}
	
	@Override
	public void writeReduceSolution(Problem p, WriterInFile fw) throws IOException {
		// TODO Auto-generated method stub
		fw.writerTextFile("\n  *** SOLUTION ***");
		for(int i = 0; i < p.getDimension(); i++) {
			fw.writerTextFile("Objective Function: " + this.getObjectiveFunctionI(i));
		}
		fw.writerTextFile("Cost Without Penalty: " + this.getCostWithoutPenalty());
		fw.writerTextFile("Number of Routes: " + this.number_routes);
		fw.writerTextFile("Fitness Function: " + this.getFitnessFunction());
		fw.writerTextFile("Sender:\nid: " + this.getSender().getIdSender() + " - time: " + this.getSender().getTimeSender()/1000.0 + "s");
		fw.writerTextFile("Receiver: ");
		for(int i = 0; i < this.getReceiver().getSize(); i++) {
			fw.writerTextFile("id: " + this.getReceiver().getIdReceiverI(i) + " - time: " + this.getReceiver().getTimeReceiverI(i)/1000.0 + "s");
		}
	}
	
	public void searchClientInSolution(int client, int route, int pos) {
		
		for(int i = 0; i < this.number_routes; i++) {
			for(int j = 0; j < this.getRouteI(i).getNumberClientsRoute(); j++) {
				
			}
		}
	}
	
	//Insere o cliente na posição pos e atualiza os valores necessários
	public void insertionClientInSolution(int client, int route, int pos, VRPProblem p) {
		int i;
		double objective_function = this.getObjectiveFunctionI(0);
		double cost_without_penalty = this.getCostWithoutPenalty();
		
		if(this.getRouteI(route) == null)
		{
			this.newRouteI(route, p);
			this.getRouteI(route).setClientInRoute(client, 1);
			this.setNumberRoutes(this.getNumberRoutes() + 1);
			objective_function = objective_function + p.getVehiclePenalty();
		}
		else
		{
			if(this.getNumberRoutes() == route) {
				this.setNumberRoutes(this.getNumberRoutes() + 1);
				objective_function = objective_function + p.getVehiclePenalty();
			}
			i = this.getRouteI(route).getNumberClientsRoute() + 1;
			while (i > pos)
			{
				this.getRouteI(route).setClientInRoute(this.getRouteI(route).getClientInRoute(i-1), i);
				i = i - 1;
			}
			this.getRouteI(route).setClientInRoute(client, pos);
		}
		
		//update number of clients in route, total demand, total time, objective function
		this.getRouteI(route).setNumberClientsRoute(this.getRouteI(route).getNumberClientsRoute() + 1);
		this.getRouteI(route).setTotalDemand(this.getRouteI(route).getTotalDemand() + p.getClientCollection(client).getDemand());
		this.getRouteI(route).setTotalTime(this.calculateTotalTime(route, p));
		
		if(this.getRouteI(route).getNumberClientsRoute() == 1) {
			objective_function = objective_function + 
					p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos-1), this.getRouteI(route).getClientInRoute(pos)) +
					p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos), this.getRouteI(route).getClientInRoute(0));
			cost_without_penalty = cost_without_penalty + 
					p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos-1), this.getRouteI(route).getClientInRoute(pos)) +
					p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos), this.getRouteI(route).getClientInRoute(0));
		}
		//deposit time
		else if(pos == this.getRouteI(route).getNumberClientsRoute()){
			objective_function = objective_function - 
					p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos-1), this.getRouteI(route).getClientInRoute(0)) +
					p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos-1), this.getRouteI(route).getClientInRoute(pos)) +
					p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos), this.getRouteI(route).getClientInRoute(0));
			cost_without_penalty = cost_without_penalty - 
					p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos-1), this.getRouteI(route).getClientInRoute(0)) +
					p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos-1), this.getRouteI(route).getClientInRoute(pos)) +
					p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos), this.getRouteI(route).getClientInRoute(0));
		} 
		else {
			objective_function = objective_function - 
				p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos-1), this.getRouteI(route).getClientInRoute(pos+1)) +
				p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos-1), this.getRouteI(route).getClientInRoute(pos)) +
				p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos), this.getRouteI(route).getClientInRoute(pos+1));
			cost_without_penalty = cost_without_penalty - 
				p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos-1), this.getRouteI(route).getClientInRoute(pos+1)) +
				p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos-1), this.getRouteI(route).getClientInRoute(pos)) +
				p.getDistanceTable(this.getRouteI(route).getClientInRoute(pos), this.getRouteI(route).getClientInRoute(pos+1));
		}
		this.setObjectiveFunctionI(0, objective_function);
		this.setCostWithoutPenalty(cost_without_penalty);
	}
	
	public void removeClientOfSolution(int route, int pos, VRPProblem p) {
		
		int client_aux;
		double distance_sum = 0;
		double distance_sub = 0;
		
		client_aux = this.getClientInSolution(route, pos);
			
		//update total demand
		this.getRouteI(route).setTotalDemand(this.getRouteI(route).getTotalDemand() - p.getClientCollection(client_aux).getDemand());
			
		//update distance
		distance_sub = p.getDistanceTable(this.getClientInSolution(route, pos-1), this.getClientInSolution(route, pos));
		if(pos == this.getRouteI(route).getNumberClientsRoute()) {
			distance_sub = distance_sub + p.getDistanceTable(this.getClientInSolution(route, pos), this.getRouteI(route).getClientInRoute(0));
			distance_sum = p.getDistanceTable(this.getClientInSolution(route, pos-1), this.getRouteI(route).getClientInRoute(0));
		}
		else {
			distance_sub = distance_sub + p.getDistanceTable(this.getClientInSolution(route, pos), this.getClientInSolution(route, pos+1));
			distance_sum = p.getDistanceTable(this.getClientInSolution(route, pos-1), this.getClientInSolution(route, pos+1));
		}
		this.setObjectiveFunctionI(0, this.getObjectiveFunctionI(0) - distance_sub + distance_sum);
		this.setCostWithoutPenalty(this.getCostWithoutPenalty() - distance_sub + distance_sum);
			
		//remove client
		for(int i = pos; i <= this.getRouteI(route).getNumberClientsRoute(); i++) {
			this.setClientInSolution(route, this.getClientInSolution(route, i+1), i); 
		}
		this.getRouteI(route).setNumberClientsRoute(this.getRouteI(route).getNumberClientsRoute() - 1);
		
		//update total time
		this.getRouteI(route).setTotalTime(this.calculateTotalTime(route, p));
		
	}
		
	public boolean violateCapacity(int route, VRPProblem p) {
		
		if(this.getRouteI(route).getTotalDemand() <= p.getVehicleCapacity()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//verfica se uma rota tem ou não violação de janela de tempo
	public boolean violateTWRoute(int route, VRPProblem p) {
		
		int i;
		float total_time, excess_time;
		   
		total_time = p.getDistanceTable(0, this.getRouteI(route).getClientInRoute(1));
		excess_time = 0;
		
		i = 1;
		while( i <= this.getRouteI(route).getNumberClientsRoute()) {
			
			if(i > 1) {
				total_time = total_time + p.getClientCollection(this.getRouteI(route).getClientInRoute(i-1)).getServiceTime() 
							+ p.getDistanceTable(this.getRouteI(route).getClientInRoute(i-1), this.getRouteI(route).getClientInRoute(i));
			}
			
			if (total_time < p.getClientCollection(this.getRouteI(route).getClientInRoute(i)).getTWInitial()) {
				total_time = (float) p.getClientCollection(this.getRouteI(route).getClientInRoute(i)).getTWInitial();
			}
			else if(total_time > p.getClientCollection(this.getRouteI(route).getClientInRoute(i)).getTWFinal()) {
					   excess_time = excess_time + (total_time - p.getClientCollection(this.getRouteI(route).getClientInRoute(i)).getTWFinal());
					   return true;
			}
			i++;
		}
		
		//last client
		total_time = total_time + p.getClientCollection(this.getRouteI(route).getClientInRoute(i)).getServiceTime();
		total_time = total_time + p.getDistanceTable(this.getRouteI(route).getClientInRoute(i), 0);
		// Deposit Time Window
		if ( total_time > p.getClientCollection(0).getTWFinal()) {
			excess_time = excess_time + ( total_time - p.getClientCollection(0).getTWFinal() );
			return true;
		}
		
		return false;
	}
	
	public float calculateTotalTime(int route, VRPProblem p) {
		
		int i;
		float total_time, excess_time;
		   
		total_time = p.getDistanceTable(0, this.getRouteI(route).getClientInRoute(1));
		excess_time = 0;
		
		i = 0;		   
		while( i < this.getRouteI(route).getNumberClientsRoute()) {
			//service time + distance between clients
			if(i > 0) {
				total_time = total_time + 
					p.getClientCollection(this.getRouteI(route).getClientInRoute(i)).getServiceTime() +
					p.getDistanceTable(this.getRouteI(route).getClientInRoute(i), this.getRouteI(route).getClientInRoute(i+1));
			}
			if(total_time < p.getClientCollection(this.getRouteI(route).getClientInRoute(i+1)).getTWInitial()) {
				total_time = p.getClientCollection(this.getRouteI(route).getClientInRoute(i+1)).getTWInitial();
			}
			else if(total_time > p.getClientCollection(this.getRouteI(route).getClientInRoute(i+1)).getTWFinal()) {
				excess_time = excess_time + (total_time - p.getClientCollection(this.getRouteI(route).getClientInRoute(i+1)).getTWFinal());
				return -1; //Error - violate TW
			}
			i++;
		}
		return total_time;
	}
	
	public void testBetterClientPosition(int cand, VRPConstructElement e, VRPProblem p, int receiver_size) {
		
		int route;
		
		double of_small = 100000; 
		int pos_small = 1;
		int route_small = 0;
		
		VRPSolution s_line;
		
		for(int i = 0; i < this.getNumberRoutes(); i++) {
			
			for(int j = 1; j <= (this.getRouteI(i).getNumberClientsRoute()+1); j++) {
		
				s_line = new VRPSolution(receiver_size, p);
				s_line.copyValuesSolution(this, p);
				
				//without capacity violation
				if((s_line.getRouteI(i).getTotalDemand() + p.getClientCollection(cand).getDemand()) < p.getVehicleCapacity()) {
					s_line.insertionClientInSolution(cand, i, j, p);	
					
					//without TW violation
					if(!s_line.violateTWRoute(i, p)) {
						if(s_line.getObjectiveFunctionI(0) < of_small) {
							of_small = s_line.getObjectiveFunctionI(0);
							pos_small = j;
							route_small = i;
						}
					}
				}
			}
		}
		
		//TESTING NEW ROUTE
		s_line = new VRPSolution(receiver_size, p);
		s_line.copyValuesSolution(this, p);
		s_line.newRouteI(s_line.getNumberRoutes(), p);
		
		//without capacity violation
		if((p.getClientCollection(cand).getDemand()) < p.getVehicleCapacity()) {
			route = s_line.getNumberRoutes();
			s_line.insertionClientInSolution(cand, route, 1, p);
			
			//without TW violation
			if(!s_line.violateTWRoute(route, p)) {
				if(s_line.getObjectiveFunctionI(0) < of_small) {
					pos_small = 1;
					route_small = route;
				}
			}
		}
		
		e.setPosIns(pos_small);
		e.setRouteIns(route_small);
	}
	
	//encontra posição para o cliente "cand", sem considerar a rota atual dele
	public void testBetterPositionInOtherRoute(int cand, int current_route, VRPConstructElement e, VRPProblem p, int receiver_size) {
		
		double of_small = 100000; 
		int pos_small = -1;
		int route_small = -1;
		
		VRPSolution s_line;
		
		for(int i = 0; i < this.getNumberRoutes(); i++) {
			
			if(i != current_route) { //não considerar a rota atual do candidato
		
				for(int j = 1; j <= (this.getRouteI(i).getNumberClientsRoute()+1); j++) {
		
					s_line = new VRPSolution(receiver_size, p);
					s_line.copyValuesSolution(this, p);
				
					//without capacity violation
					if((s_line.getRouteI(i).getTotalDemand() + p.getClientCollection(cand).getDemand()) < p.getVehicleCapacity()) {
						s_line.insertionClientInSolution(cand, i, j, p);	
					
						//without TW violation
						if(!s_line.violateTWRoute(i, p)) {
							if(s_line.getObjectiveFunctionI(0) < of_small) {
								of_small = s_line.getObjectiveFunctionI(0);
								pos_small = j;
								route_small = i;
							}
						}
					}
				}
			}
		}
		
		e.setPosIns(pos_small);
		e.setRouteIns(route_small);
	}
	
	public boolean testFirstPosition(int pos_cand, int current_route, VRPConstructElement e, VRPProblem p, int receiver_size) {
		
		VRPSolution s_line;
		
		s_line = new VRPSolution(receiver_size, p);
		
		e.setPosIns(-1);
		e.setRouteIns(-1);
		
		for(int i = 0; i < this.getNumberRoutes(); i++) {
			
			s_line.copyValuesSolution(this, p);
			
			if(i != current_route) { //não considerar a rota atual do candidato
		
				for(int j = 1; j <= (this.getRouteI(i).getNumberClientsRoute()); j++) {
			
					if(s_line.swapInter(current_route, pos_cand, i, j, p)) {
						e.setPosIns(j);
						e.setRouteIns(i);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/* MOVIMENTS */
	
	//Troca de clientes - inter-rota
	public boolean swapInter(int route1, int pos1, int route2, int pos2, VRPProblem p) {
		
		int client1, client2;
		
		if((route1 == route2) && (pos1 == pos2)) {
			return true;
		}
		else {
			//remove
			client1 = this.getClientInSolution(route1, pos1);
			client2 = this.getClientInSolution(route2, pos2);
			
			this.removeClientOfSolution(route1, pos1, p);
			this.removeClientOfSolution(route2, pos2, p);
			
			//insertion
			this.insertionClientInSolution(client1, route2, pos2, p);
			this.insertionClientInSolution(client2, route1, pos1, p);
			
			if(this.violateCapacity(route1, p) || this.violateCapacity(route2, p)) {
				return false;
			}
			
			if((this.getRouteI(route1).getTotalTime() == -1) || (this.getRouteI(route2).getTotalTime() == -1)) {
				return false;
			}
		}
		
		return true;
	}
	
	//Troca de clientes - intra-rota
	public boolean swapIntra(int route1, int pos1, int pos2, VRPProblem p) {
		
		int client1, client2;
			
		if(pos1 == pos2) {
			return true;
		}
		else {
			client1 = this.getClientInSolution(route1, pos1);
			client2 = this.getClientInSolution(route1, pos2);
				
			if(pos1 < pos2) {
				this.removeClientOfSolution(route1, pos2, p);
				this.removeClientOfSolution(route1, pos1, p);
				this.insertionClientInSolution(client2, route1, pos1, p);
				this.insertionClientInSolution(client1, route1, pos2, p);
			}
				
			if(pos2 < pos1) {
				this.removeClientOfSolution(route1, pos1, p);
				this.removeClientOfSolution(route1, pos2, p);
				this.insertionClientInSolution(client1, route1, pos2, p);
				this.insertionClientInSolution(client2, route1, pos1, p);
			}
				
			if(this.violateCapacity(route1, p)) {
				return false;
			}
				
			if(this.getRouteI(route1).getTotalTime() == -1) {
				return false;
			}
		}
			
		return true;
	}
	
	//A single shift - (Realocação - Inter-rota)
	public boolean shiftInter(int route1, int pos1, int route2, int pos2, VRPProblem p) {
		
		int client1;
		
		if((route1 == route2) && (pos1 == pos2)) {
			return true;
		}
		else {
			//remove
			client1 = this.getClientInSolution(route1, pos1);
			this.removeClientOfSolution(route1, pos1, p);
			
			//insertion
			this.insertionClientInSolution(client1, route2, pos2, p);
			
			if(this.violateCapacity(route2, p)) {
				if(this.getRouteI(route1).getNumberClientsRoute() == 0) {
					this.eliminatesEmptyRoute(route1, p);
				}
				return false;
			}
			
			if((this.getRouteI(route1).getTotalTime() == -1) || (this.getRouteI(route2).getTotalTime() == -1)) {
				if(this.getRouteI(route1).getNumberClientsRoute() == 0) {
					this.eliminatesEmptyRoute(route1, p);
				}
				return false;
			}
		}
		
		if(this.getRouteI(route1).getNumberClientsRoute() == 0) {
			this.eliminatesEmptyRoute(route1, p);
		}
		return true;
	}

	//Realocação - Intra-rota
	public boolean shiftIntra(int route1, int pos1, int pos2, VRPProblem p) {
			
		int client1;
		
		if(pos1 == pos2) {
			return true;
		}
		else {
			
			//remove
			client1 = this.getClientInSolution(route1, pos1);
			this.removeClientOfSolution(route1, pos1, p);
				
			/*if(pos1 < pos2) {
				pos2--;
			}*/
			//insertion
			this.insertionClientInSolution(client1, route1, pos2, p);

			if(this.violateCapacity(route1, p)) {
				return false;
			}
				
			if(this.getRouteI(route1).getTotalTime() == -1) {
				return false;
			}
		}
			
		return true;
	}
	
	//N consecutive swap
	public boolean nSwapInter(int n, int route1, int pos1, int route2, int pos2, VRPProblem p) {
				
		int client1, client2;
			
		int count = 0;
		
		while((count < n) && (pos1 <= this.getRouteI(route1).getNumberClientsRoute()) && 
				(pos2 <= this.getRouteI(route2).getNumberClientsRoute())){
		
			if((route1 == route2) && (pos1 == pos2)) {
				return true;
			}
			else {
				//remove
				client1 = this.getClientInSolution(route1, pos1);
				client2 = this.getClientInSolution(route2, pos2);
				
				this.removeClientOfSolution(route1, pos1, p);
				this.removeClientOfSolution(route2, pos2, p);
				
				//insertion
				this.insertionClientInSolution(client1, route2, pos2, p);
				this.insertionClientInSolution(client2, route1, pos1, p);
				
				if(this.violateCapacity(route1, p) || this.violateCapacity(route2, p)) {
					return false;
				}
				
				if((this.getRouteI(route1).getTotalTime() == -1) || (this.getRouteI(route2).getTotalTime() == -1)) {
					return false;
				}

				pos1++;
				pos2++;
				count++;
			}
		}
		
		return true;
	}
	
	//N consecutive shifts
	public boolean nShiftInter(int n, int route1, int pos1, int route2, int pos2, VRPProblem p) {
		
		int client1;
		
		int count = 0;
		
		while((count < n) && (pos1 <= this.getRouteI(route1).getNumberClientsRoute())){
			
			if((route1 == route2) && (pos1 == pos2)) {
				return true;
			}
			else {
				//remove
				client1 = this.getClientInSolution(route1, pos1);
				this.removeClientOfSolution(route1, pos1, p);
				
				//insertion
				this.insertionClientInSolution(client1, route2, pos2, p);
				
				if(this.violateCapacity(route2, p)) {
					if(this.getRouteI(route1).getNumberClientsRoute() == 0) {
						this.eliminatesEmptyRoute(route1, p);
					}
					return false;
				}
				
				if((this.getRouteI(route1).getTotalTime() == -1) || (this.getRouteI(route2).getTotalTime() == -1)) {
					if(this.getRouteI(route1).getNumberClientsRoute() == 0) {
						this.eliminatesEmptyRoute(route1, p);
					}
					return false;
				}
			}
			
			if(this.getRouteI(route1).getNumberClientsRoute() == 0) {
				this.eliminatesEmptyRoute(route1, p);
				return false;
			}
			
			pos2++;
			count++;
		}
			
		return true;
	}
	
	//N consecutive shifts 
	public boolean nShiftForBestPositionInter(int n, int route, int position, VRPProblem p, int receiver_size) {
		
		int client, number_clients;
		VRPConstructElement e = new VRPConstructElement(p);
		
		VRPSolution sol = new VRPSolution(receiver_size, p);
		sol.copyValuesSolution(this, p);
			
		number_clients = this.solution_vector[route].getNumberClientsRoute();
			
		int count = 0;
		for(int j = position; j <= number_clients; j++) {
				
			client = this.getClientInSolution(route, position);
				
			this.testBetterPositionInOtherRoute(client, route, e, p, receiver_size);
				
			if((e.getRouteIns() == -1) || (e.getPosIns() == -1)) {
				this.copyValuesSolution(sol, p);
				return false;
			}
			else {
				this.removeClientOfSolution(route, position, p);
				this.insertionClientInSolution(client, e.getRouteIns(), e.getPosIns(), p);
				count++;
				int k = route;
				if(this.solution_vector[route].getNumberClientsRoute() == 0) {
					if(route != (this.getNumberRoutes()-1)) {
						for(k = route; k < this.getNumberRoutes()-1; k++) {
							this.solution_vector[k].copyValuesRoute(this.solution_vector[k+1]);
						}
					}
					//eliminates route
					this.solution_vector[k] = null;
					this.setObjectiveFunctionI(0, this.getObjectiveFunctionI(0) - p.getVehiclePenalty());
					this.setNumberRoutes(this.getNumberRoutes() - 1);
					return true;
				}
				if(count >= n) {
					return true;
				}
			}
		}
		return true;
	}	
	
	public boolean eliminatesSmallRoute(VRPProblem p, int receiver_size) {
		
		int client, route, position, number_clients;
		VRPConstructElement e = new VRPConstructElement(p);
		int routes[] = new int[this.getNumberRoutes()];
		
		for(int i = 0; i < this.getNumberRoutes(); i++) {
			routes[i] = 0;
		}
		
		VRPSolution sol = new VRPSolution(receiver_size, p);
		sol.copyValuesSolution(this, p);
		
		for(int i = 0; i < this.getNumberRoutes(); i++) {
			
			route = this.smallRouteForEliminatesRoute(routes, p);
			routes[route] = -1;
			position = 1;
			number_clients = this.solution_vector[route].getNumberClientsRoute();
			
			for(int j = 1; j <= number_clients; j++) {
				
				client = this.getClientInSolution(route, position);
				
				this.testBetterPositionInOtherRoute(client, route, e, p, receiver_size);
				
				if((e.getRouteIns() == -1) && (e.getPosIns() == -1)) {
					this.copyValuesSolution(sol, p);
					break;
				}
				else {
					this.removeClientOfSolution(route, position, p);
					this.insertionClientInSolution(client, e.getRouteIns(), e.getPosIns(), p);
					int k = route;
					if(this.solution_vector[route].getNumberClientsRoute() == 0) {
						if(route != (this.getNumberRoutes()-1)) {
							for(k = route; k < this.getNumberRoutes()-1; k++) {
								this.solution_vector[k].copyValuesRoute(this.solution_vector[k+1]);
							}
						}
						//eliminates route
						this.solution_vector[k] = null;
						this.setObjectiveFunctionI(0, this.getObjectiveFunctionI(0) - p.getVehiclePenalty());
						this.setNumberRoutes(this.getNumberRoutes() - 1);

						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean eliminatesRandomRoute(VRPProblem p, int receiver_size) {
		
		int client, route, position, number_clients;
		VRPConstructElement e = new VRPConstructElement(p);
		Random generator = new Random();
		int routes[] = new int[this.getNumberRoutes()];
		
		for(int i = 0; i < this.getNumberRoutes(); i++) {
			routes[i] = 0;
		}
		
		VRPSolution sol = new VRPSolution(receiver_size, p);
		sol.copyValuesSolution(this, p);
		
		for(int i = 0; i < this.getNumberRoutes(); i++) {
			
			route = generator.nextInt(this.getNumberRoutes());
			routes[route] = -1;
			position = 1;
			number_clients = this.solution_vector[route].getNumberClientsRoute();
			
			for(int j = 1; j <= number_clients; j++) {
				
				client = this.getClientInSolution(route, position);
				
				this.testBetterPositionInOtherRoute(client, route, e, p, receiver_size);
				
				if((e.getRouteIns() == -1) && (e.getPosIns() == -1)) {
					this.copyValuesSolution(sol, p);
					break;
				}
				else {
					this.removeClientOfSolution(route, position, p);
					this.insertionClientInSolution(client, e.getRouteIns(), e.getPosIns(), p);
					int k = route;
					if(this.solution_vector[route].getNumberClientsRoute() == 0) {
						if(route != (this.getNumberRoutes()-1)) {
							for(k = route; k < this.getNumberRoutes()-1; k++) {
								this.solution_vector[k].copyValuesRoute(this.solution_vector[k+1]);
							}
						}
						//eliminates route
						this.solution_vector[k] = null;
						this.setObjectiveFunctionI(0, this.getObjectiveFunctionI(0) - p.getVehiclePenalty());
						this.setNumberRoutes(this.getNumberRoutes() - 1);

						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	// ??????
	public boolean eliminatesRouteI_BestCost(int route, VRPProblem p, int receiver_size) {
		
		int client, position, number_clients;
		VRPConstructElement e = new VRPConstructElement(p);
		
		VRPSolution sol = new VRPSolution(receiver_size, p);
		sol.copyValuesSolution(this, p);
		
		for(int i = 0; i < this.getNumberRoutes(); i++) {
			
			position = 1;
			number_clients = this.solution_vector[route].getNumberClientsRoute();
			
			for(int j = 1; j <= number_clients; j++) {
				
				client = this.getClientInSolution(route, position);
				
				this.testBetterPositionInOtherRoute(client, route, e, p, receiver_size);
				
				if((e.getRouteIns() == -1) && (e.getPosIns() == -1)) {
					//criar nova rota
					this.insertionClientInSolution(client, this.getNumberRoutes(), 1, p);
				}
				else {
					this.removeClientOfSolution(route, position, p);
					this.insertionClientInSolution(client, e.getRouteIns(), e.getPosIns(), p);
					int k = route;
					//if empty route
					if(this.solution_vector[route].getNumberClientsRoute() == 0) {
						if(route != (this.getNumberRoutes()-1)) {
							for(k = route; k < this.getNumberRoutes()-1; k++) {
								this.solution_vector[k].copyValuesRoute(this.solution_vector[k+1]);
							}
						}
						//eliminates route
						this.solution_vector[k] = null;
						this.setObjectiveFunctionI(0, this.getObjectiveFunctionI(0) - p.getVehiclePenalty());
						this.setNumberRoutes(this.getNumberRoutes() - 1);

						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public int smallRoute() {
		
		int small = this.solution_vector[0].getNumberClientsRoute();
		int small_route = 0;
		
		for(int i = 1; i < this.getNumberRoutes(); i++) {
			if(this.solution_vector[i].getNumberClientsRoute()< small) {
				small = this.solution_vector[i].getNumberClientsRoute();
				small_route = i;
			}
		}
		
		return small_route;
	}
	
	public int smallRouteForEliminatesRoute(int routes[], VRPProblem p) {
		
		int small = p.getNumberOfClients();
		int small_route = -1;
		
		for(int i = 0; i < this.getNumberRoutes(); i++) {
			if(routes[i] != -1) {
				if(this.solution_vector[i].getNumberClientsRoute()< small) {
					small = this.solution_vector[i].getNumberClientsRoute();
					small_route = i;
				}
			}
		}
		
		return small_route;
	}
	
	public void eliminatesEmptyRoute(int route, VRPProblem p) {
		
		int k = route;
		if(this.solution_vector[route].getNumberClientsRoute() == 0) {
			if(route != (this.getNumberRoutes()-1)) {
				for(k = route; k < this.getNumberRoutes()-1; k++) {
					this.solution_vector[k].copyValuesRoute(this.solution_vector[k+1]);
				}
			}
			//eliminates route
			this.solution_vector[k] = null;
			this.setObjectiveFunctionI(0, this.getObjectiveFunctionI(0) - p.getVehiclePenalty());
			this.setNumberRoutes(this.getNumberRoutes() - 1);
		}	
	}
	
	public Solution bestCostRouteCrossover(VRPSolution p1, VRPSolution p2) {
		
		Random generator = new Random();
		int r_p1; //, r_p2;
		Route route_p1;//, route_p2;
		
		r_p1 = generator.nextInt(p1.getNumberRoutes());
		//r_p2 = generator.nextInt(p2.getNumberRoutes());
		
		route_p1 = p1.getRouteI(r_p1);
		//route_p2 = p2.getRouteI(r_p2);
		
		int i = 0;
		while(i <= route_p1.getNumberClientsRoute()) {
			
		}
		
		return null;
	}
	
	/* SETS AND GETS */
	public void setNumberRoutes(int number_routes) {
		this.number_routes = number_routes;
	}

	public int getNumberRoutes() {
		return this.number_routes;
	}

	public void setClientInSolution(int route, int client, int i) {
		this.solution_vector[route].setClientInRoute(client, i);;
	}

	public int getClientInSolution(int route, int i) {
		return this.solution_vector[route].getClientInRoute(i);
	}
	
	public Route getRouteI(int i) {
		return this.solution_vector[i];
	}
	
	public void newRouteI(int i, VRPProblem p) {
		this.solution_vector[i] = new Route(p.getNumberOfClients());
	}
	
}
