package Construct_PM;

import java.util.Random;

import Construction.NextCandidate;
import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_PM.PMProblem;
import Environment_PM.PMSolution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the NextCandidate class  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class PMNextCandidate implements NextCandidate{

	private int rcl_size;

	@Override
	public void nextCandidate(Solution s, Element e, Problem p,
			String function_type, int receiver_size) {
		// TODO Auto-generated method stub
		
		switch(function_type) {
			case "greedy":
				this.greedyFunctionPM(s, e, p, receiver_size);
				break;
			case "greedy_random":
				this.greedyRandomFunctionPM(s, e, p, receiver_size);
				break;
			case "random":
				this.randomFunctionPM(s, e, p);
				break;
			default:
				System.out.println("Invalid Function!");
		}
	}

	private void greedyFunctionPM(Solution s, Element e, Problem p, int receiver_size) {
			
		PMSolution sol = null;
		if(s instanceof PMSolution) {
			sol = (PMSolution) s;
		}
			
		sol.testBetterTaskPosition(sol, e, p, receiver_size);
		
	}

	private void greedyRandomFunctionPM(Solution s, Element e, Problem p, int receiver_size) {

		PMSolution sol = null;
		if(s instanceof PMSolution) {
			sol = (PMSolution) s;
		}
			
		PMConstructElement pm_e = null;
		if(e instanceof PMConstructElement) {
			pm_e = (PMConstructElement) e;
		}
			
		pm_e.setRclSize(this.rcl_size);
		sol.testBetterTaskPositionGreedyRandom(sol, pm_e, p, receiver_size);
	}

	private void randomFunctionPM(Solution s, Element e, Problem p) {
			
		PMProblem pm = null;
		if(p instanceof PMProblem) {
			pm = (PMProblem) p;
		}
		
		PMConstructElement pm_e= null;
		if(e instanceof PMConstructElement) {
			pm_e = (PMConstructElement) e;
		}
		
		Random generator = new Random();		
		int machine, task;
		
		machine = generator.nextInt(pm.getMachinesNumber());
		do {
			task = generator.nextInt(pm.getNumberOfTasks());
		} while(pm_e.getCandidateI(task) == -1);
		
		pm_e.setMachineIns(machine);
		pm_e.setNextCandidate(task);
	}

	public int getRclSize() {
		return rcl_size;
	}

	public void setRclSize(int rcl_size) {
		this.rcl_size = rcl_size;
	}

	
}
