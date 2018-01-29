package Cooperation;

import Environment.Problem;
import Environment.Solution;
import Environment_PM.PMProblem;
import Environment_PM.PMSolution;
import Methods.Method;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Solution pool class.
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMPoolSolutions extends PoolSolutions{

	public PMPoolSolutions(int size_max, double radius_niche, Problem p, int receiver_size) {
		super(size_max, radius_niche);
		// TODO Auto-generated constructor stub
		
		for(int i = 0; i < this.getMaxSize(); i++) {
			this.setSolutionInCollection(i, new PMSolution(receiver_size, p), p);
		}
		
		this.setBestSolutionPool(new PMSolution(receiver_size, p));
	}

	@Override
	public synchronized int calculateDistanceBetweenSolutions(Solution s1, Solution s2,
			Problem p) {
		// TODO Auto-generated method stub
		
		return this.calculateDistanceBetweenSolutionsPosition(s1, s2, p);
	}

	public synchronized int calculateDistanceBetweenSolutionsPosition(Solution s1, Solution s2,
			Problem p) {
		// TODO Auto-generated method stub
		
		int count = 0;
		int distance;
		
		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		PMSolution pm_s1 = null;
		if(s1 instanceof PMSolution) {
			pm_s1 = (PMSolution) s1;
		}
		
		PMSolution pm_s2 = null;
		if(s1 instanceof PMSolution) {
			pm_s2 = (PMSolution) s2;
		}
		
		for(int k = 0; k < pm_s1.getMachineNumber(); k++)
		{
			for(int i = 0; i < pm_s1.getMachineI(k).getTasksNumber(); i++)
			{
				//System.out.println("\nMáquina " + k + " - pos " + i );
				//System.out.println("Arco s1 - " + s1.getTaskInMachines(k,i) + ", " + s1.getTaskInMachines(k,i+1));
				//System.out.println("Máquina " + k + " - pos " + i );
				//System.out.println("Arco s2 - " + s2.getTaskInMachines(k, i) + ", " + s2.getTaskInMachines(k, i+1));
				if((k < pm_s2.getMachineNumber()) && (i < pm_s2.getMachineI(k).getTasksNumber())) {
					if((pm_s1.getTaskInMachines(k, i) == pm_s2.getTaskInMachines(k, i)))
						count++;
				}
			}
		}
		distance = (pm.getNumberOfTasks()) - count;
		return distance;
	}
	
	public synchronized int calculateDistanceBetweenSolutionsArcs(Solution s1, Solution s2,
			Problem p) {
		// TODO Auto-generated method stub
		
		int count = 0;
		int distance;
		
		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		PMSolution pm_s1 = null;
		if(s1 instanceof PMSolution) {
			pm_s1 = (PMSolution) s1;
		}
		
		PMSolution pm_s2 = null;
		if(s1 instanceof PMSolution) {
			pm_s2 = (PMSolution) s2;
		}
		
		for(int k = 0; k < pm_s1.getMachineNumber(); k++)
		{
			for(int i = 0; i < (pm_s1.getMachineI(k).getTasksNumber()-1); i++)
			{
				//AUMENTAR UM FOR PARA COMPARAR ARCO COM ARCO, E NÃO AVALIAR A ROTA COMO ESTÁ
				//COLOCAR A COMPARAÇÃO I,J E J,I
				
				//System.out.println("\nMáquina " + k + " - pos " + i );
				//System.out.println("Arco s1 - " + s1.getTaskInMachines(k,i) + ", " + s1.getTaskInMachines(k,i+1));
				//System.out.println("Máquina " + k + " - pos " + i );
				//System.out.println("Arco s2 - " + s2.getTaskInMachines(k, i) + ", " + s2.getTaskInMachines(k, i+1));
				if((k < pm_s2.getMachineNumber()) && (i < (pm_s2.getMachineI(k).getTasksNumber()-1))) {
					if((pm_s1.getTaskInMachines(k, i) == pm_s2.getTaskInMachines(k, i)) && (pm_s1.getTaskInMachines(k, i+1) == pm_s2.getTaskInMachines(k, i+1)))
						count++;
				}
			}
		}
		distance = (pm.getNumberOfTasks()) - count;
		return distance;
	}

	@Override
	public Solution getPartialSolution(int portion_size, int receiver_size,
			Problem p) {
		// TODO Auto-generated method stub
		int i;
		PMSolution partial_solution = new PMSolution(receiver_size, p);
		Solution sol_pool = this.getRandomSolutionCollection(receiver_size, 0);
		
		PMSolution sol = null;
		if(sol_pool instanceof PMSolution) {
			sol = (PMSolution) sol_pool;
		}
		
		i = 0;
		for(int j = 0; j < sol.getMachineNumber(); j++){
			//partial_solution.setMachineNumber(partial_solution.getMachineNumber() + 1);
			for(int k = 0; k < sol.getMachineI(j).getTasksNumber(); k++) {
				partial_solution.insertTaskInSolutioninPosition(sol.getTaskInMachines(j, k), k, j, p);
				i++;
				if(i >= portion_size) {
					return partial_solution;
				}
			}
		}
		
		return partial_solution;
	}
	
	public Solution getSolutionGRASP(Method construction, int portion_size, int receiver_size, Problem p) {
		
		Solution s = new PMSolution(receiver_size, p);
		
		s.copyValuesSolution(this.getPartialSolution(portion_size, receiver_size, p), p);
		
		s.copyValuesSolution(construction.runMethod(p, s, 1), p);
		
		return s;
	}
		
}
