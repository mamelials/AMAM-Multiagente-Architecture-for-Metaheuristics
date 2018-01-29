package Cooperation;

import Environment.Problem;
import Environment.Solution;
import Environment_VRP.VRPProblem;
import Environment_VRP.VRPSolution;
import Methods.Method;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Solution pool class.
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPPoolSolutions extends PoolSolutions{
	
	public VRPPoolSolutions(int size_max, double radius_niche, Problem p, int receiver_size) {
		super(size_max, radius_niche);
		// TODO Auto-generated constructor stub
	
		for(int i = 0; i < this.getMaxSize(); i++) {
			this.setSolutionInCollection(i, new VRPSolution(receiver_size, p), p);
		}
		
		this.setBestSolutionPool(new VRPSolution(receiver_size, p));
	}
	
	@Override
	public synchronized int calculateDistanceBetweenSolutions(Solution s1, Solution s2, Problem p) {
		// TODO Auto-generated method stub
		int count = 0;
		int dist;
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		VRPSolution vrp_s1 = null;
		if(s1 instanceof VRPSolution) {
			vrp_s1 = (VRPSolution) s1;
		}
		
		VRPSolution vrp_s2 = null;
		if(s1 instanceof VRPSolution) {
			vrp_s2 = (VRPSolution) s2;
		}
		
		for(int k = 0; k < vrp_s1.getNumberRoutes(); k++)
		{
			for(int i = 0; i < vrp_s1.getRouteI(k).getNumberClientsRoute(); i++)
			{
				//System.out.println("\nRota " + k + " - pos " + i );
				//System.out.println("Arco s1 - " + s1.getClienteRouteVectorI(k,i) + ", " + s1.getClienteRouteVectorI(k,i+1));
				//System.out.println("Rota " + l + " - pos " + j );
				//System.out.println("Arco s2 - " + s2.getClienteRouteVectorI(l, j) + ", " + s2.getClienteRouteVectorI(l, j+1));
				if((k < vrp_s2.getNumberRoutes()) && (i <= vrp_s2.getRouteI(k).getNumberClientsRoute())) {
					if((vrp_s1.getClientInSolution(k, i) == vrp_s2.getClientInSolution(k, i)) && (vrp_s1.getClientInSolution(k, i+1) == vrp_s2.getClientInSolution(k, i+1)))
						count++;
				}
			}
		}
		dist = (vrp.getNumberOfClients()-1) - count;
		return dist;
	}

	@Override
	public Solution getPartialSolution(int portion_size, int receiver_size,
			Problem p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solution getSolutionGRASP(Method construction, int portion_size, int receiver_size, Problem p) {
		// TODO Auto-generated method stub
		return null;
	}	
	
}