package Factorys;

import Environment_Movements.Movement;
import Environment_PRV_Movements.MovementVRPEliminatesRandomRoute;
import Environment_PRV_Movements.MovementVRPEliminatesSmallRoute;
import Environment_PRV_Movements.MovementVRPShiftInter;
import Environment_PRV_Movements.MovementVRPShiftIntra;
import Environment_PRV_Movements.MovementVRPSwapInter;
import Environment_PRV_Movements.MovementVRPSwapIntra;
import Environment_PRV_Movements.MovementVRPTwoShiftInter;
import Environment_PRV_Movements.MovementVRPTwoSwapInter;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: class responsible for the creation (instantiation) of momevement factorys. 
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class MovementFactory {
	
	public Movement createMoviment(String move_type) {
		
		Movement m = null;
		
		switch (move_type){
			case "swap_intra":
				m = new MovementVRPSwapIntra(move_type);
				break;
			case "swap_inter":
				m = new MovementVRPSwapInter(move_type);
				break;
			case "shift_intra":
				m = new MovementVRPShiftIntra(move_type);
				break;
			case "shift_inter":
				m = new MovementVRPShiftInter(move_type);
				break;
			case "two_swap_inter":
				m = new MovementVRPTwoSwapInter(move_type);
				break;
			case "two_shift_inter":
				m = new MovementVRPTwoShiftInter(move_type);
				break;
			case "eliminate_small": 
				m = new MovementVRPEliminatesSmallRoute(move_type);
				break;
			case "eliminate_random":
				m = new MovementVRPEliminatesRandomRoute(move_type);
				break;
			default:
				System.out.println("Tipo de movimento não disponível!");
		}
		
		return m;
	}

}
