package Parameters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Environment.Problem;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Experiments parameters.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPSetParameters extends SetParameters{
	
	public MethodParameters setParameters(String parameter_text_file, Problem vrp, int n_try, long initial_time) throws IOException {
		
		MethodParameters parameters_vrp = new MethodParameters();
		
		FileReader file = new FileReader(parameter_text_file + ".txt");
		BufferedReader buffer = new BufferedReader(file);
		
		String line = buffer.readLine();
		StringTokenizer token = new StringTokenizer(line," ");
		
		System.out.println();
		
		line = buffer.readLine();
		token = new StringTokenizer(line," ");
		
		
		/*
		//CRIA A LISTA DE MOVIMENTOS E ATRIBUI OS MOVIMENTOS DISPONÍVEIS
		parameters_vrp.setNeighborhoodSize(8);					 // -----NEIGHBORHOOD_SIZE-----
		MovementList vrp_movement_list = new MovementList(parameters_vrp.getNeighborhoodSize());
		
		Movement movement_vrp_swap_intra = new MovementVRPSwapIntra("swap_intra");
		Movement movement_vrp_swap_inter = new MovementVRPSwapInter("swap_inter");
		Movement movement_vrp_shift_intra = new MovementVRPShiftIntra("shift_intra");
		Movement movement_vrp_shift_inter = new MovementVRPShiftInter("shift_inter");
		Movement movement_vrp_two_swap_inter = new MovementVRPTwoSwapInter("two_swap_inter");
		Movement movement_vrp_two_shift_inter = new MovementVRPTwoShiftInter("two_shift_inter");
		Movement movement_vrp_eliminates_small_route = new MovementVRPEliminatesSmallRoute("eliminate_small");
		Movement movement_vrp_eliminates_random_route = new MovementVRPEliminatesRandomRoute("eliminate_random");
		
		//ORDER MOVEMENTS
		//VNS ORDER
		if(neighbor_type == "order1"){
			vrp_movement_list.addMovementI(movement_vrp_swap_inter);
			vrp_movement_list.addMovementI(movement_vrp_swap_intra);
			vrp_movement_list.addMovementI(movement_vrp_shift_inter);
			vrp_movement_list.addMovementI(movement_vrp_shift_intra);
			vrp_movement_list.addMovementI(movement_vrp_two_swap_inter);
			vrp_movement_list.addMovementI(movement_vrp_two_shift_inter);
			vrp_movement_list.addMovementI(movement_vrp_eliminates_small_route);
			vrp_movement_list.addMovementI(movement_vrp_eliminates_random_route);
		}
		
		//REVERSE ORDER
		if(neighbor_type == "order2"){
			vrp_movement_list.addMovementI(movement_vrp_eliminates_random_route);
			vrp_movement_list.addMovementI(movement_vrp_eliminates_small_route);
			vrp_movement_list.addMovementI(movement_vrp_two_shift_inter);
			vrp_movement_list.addMovementI(movement_vrp_two_swap_inter);
			vrp_movement_list.addMovementI(movement_vrp_shift_intra);
			vrp_movement_list.addMovementI(movement_vrp_shift_inter);
			vrp_movement_list.addMovementI(movement_vrp_swap_intra);
			vrp_movement_list.addMovementI(movement_vrp_swap_inter);
		}
		
		//ALTERNATIVE ORDER
		if(neighbor_type == "order3"){
			vrp_movement_list.addMovementI(movement_vrp_two_shift_inter);
			vrp_movement_list.addMovementI(movement_vrp_two_swap_inter);
			vrp_movement_list.addMovementI(movement_vrp_eliminates_random_route);
			vrp_movement_list.addMovementI(movement_vrp_eliminates_small_route);
			vrp_movement_list.addMovementI(movement_vrp_shift_intra);
			vrp_movement_list.addMovementI(movement_vrp_shift_inter);
			vrp_movement_list.addMovementI(movement_vrp_swap_intra);
			vrp_movement_list.addMovementI(movement_vrp_swap_inter);
		}
		
		parameters_vrp.setFw(new WriterInFile("Results-" + vrp.getInstanceName() + "-" + n_try + ".txt"));
		parameters_vrp.setFwReduced(new WriterInFile("Results-" + vrp.getInstanceName() + "-" + n_try + "-reduced.txt"));
		parameters_vrp.setFwPool(new WriterInFile("Results-" + vrp.getInstanceName() + "-" + n_try + "-pool.txt"));
		parameters_vrp.setFwST(new WriterInFile("Results-" + vrp.getInstanceName() + "-" + n_try + "-ST.txt"));
		parameters_vrp.setFwFinalTableQ(new WriterInFile("TableFinalQ-" + vrp.getInstanceName() + "-" + n_try + ".txt"));
		
		parameters_vrp.setMovementList(vrp_movement_list);
		
		//QLEARNING
		parameters_vrp.setQLearning(new QLearning(parameters_vrp.getNeighborhoodSize(), 0.9, 0.1, 0.05)); 
		parameters_vrp.getQLearning().setQSize(parameters_vrp.getNeighborhoodSize());  //QSIZE
		parameters_vrp.getQLearning().setGamma(0.9);      //GAMMA
		parameters_vrp.getQLearning().setAlpha(0.1);      //ALPHA
		parameters_vrp.getQLearning().setEpsilon(1);   //EPSILON
						
		parameters_vrp.setMaxIterations(2000);					 // -----MAX_ITERATIONS-----
		parameters_vrp.setMaxTime(max_time); 					 	 //  -----MAX_TIME-----
		
		parameters_vrp.setMaxLevelsPerturbation(8);				 // -----MAX_LEVELS-----
		
		VRPProblem vrp_p = null;
		if(vrp instanceof VRPProblem) {
			vrp_p = (VRPProblem) vrp;
		}
		parameters_vrp.setRclSize((int)(vrp_p.getNumberOfClients() * 0.1));		// -----RCL_SIZE-----
			
		int portion = (int )(vrp_p.getNumberOfClients() * 0.5);
		parameters_vrp.setPortionSize(portion);

		*/
		return parameters_vrp;
		
	}

}
