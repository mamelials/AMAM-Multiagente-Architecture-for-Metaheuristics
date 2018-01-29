package Construct_VRP;

import java.util.Random;

import Construction.NextCandidate;
import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Environment_VRP.VRPProblem;
import Environment_VRP.VRPSolution;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Class that implements the NextCandidate class.  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class VRPNextCandidate implements NextCandidate{

	private int rcl[];
	private int rcl_size;
	
	public VRPNextCandidate(int rcl_size) {
		// TODO Auto-generated constructor stub
		rcl = new int[rcl_size];
		this.rcl_size = rcl_size;
	}
	
	@Override
	public void nextCandidate(Solution s, Element e, Problem p, String function_type, int receiver_size) {
		
		VRPSolution s_line = new VRPSolution(receiver_size, p);
		s_line.copyValuesSolution(s, p);
		
		// TODO Auto-generated method stub
		switch(function_type) {
			case "greedy":
				this.greedyFunctionVRP(s_line, e, p, receiver_size);
				break;
			case "greedy_random":
				this.greedyRandomFunctionVRP(s_line, e, p, receiver_size);
				break;
			default:
				System.out.println("Invalid Function!");
		}
	}
	
	private void greedyFunctionVRP(Solution s, Element e, Problem p, int receiver_size) {
		
		int cand;
		
		VRPConstructElement vrp_e = null;
		if(e instanceof VRPConstructElement) {
			vrp_e = (VRPConstructElement) e;
		}
		
		VRPSolution vrp_sol = null;
		if(s instanceof VRPSolution) {
			vrp_sol = (VRPSolution) s;
		}
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		cand = vrp_e.getCandidateI(vrp_e.getCount()+1);
		vrp_e.setPosCandidate(vrp_e.getCount()+1);
		
		//System.out.println("Candidato " + cand);
		
		vrp_sol.testBetterClientPosition(cand, vrp_e, vrp, receiver_size);
		
		vrp_e.setNextCandidate(cand);
		
		e = vrp_e;
	}

	private void greedyRandomFunctionVRP(Solution s, Element e, Problem p, int receiver_size) {
		
		int cand, pos_rcl, current_size;
		
		VRPProblem vrp = null;
		if(p instanceof VRPProblem) {
			vrp = (VRPProblem) p;
		}
		
		VRPConstructElement vrp_e = null;
		if(e instanceof VRPConstructElement) {
			vrp_e = (VRPConstructElement) e;
		}
		
		VRPSolution vrp_sol = null;
		if(s instanceof VRPSolution) {
			vrp_sol = (VRPSolution) s;
		}

		Random generator = new Random();
		
		int i = 0;
		int j = 1;
		while((i < this.rcl_size) && (j < vrp.getNumberOfClients())) {
			if(vrp_e.getCandidateI(j) != -1) {
				this.rcl[i] = vrp_e.getCandidateI(j);
				i++;
			}
			j++;
		}
		current_size = i;
		pos_rcl = generator.nextInt(current_size); 
		cand = this.rcl[pos_rcl];
		vrp_e.setPosCandidate(this.searchPositionCandidate(cand, vrp_e, vrp));
		
		vrp_sol.testBetterClientPosition(cand, vrp_e, vrp, receiver_size);
		
		vrp_e.setNextCandidate(cand);
		
	}
	
	public int searchPositionCandidate(int cand, VRPConstructElement e, VRPProblem p) {
		for(int i = 1; i < p.getNumberOfClients(); i++) {
			if(e.getCandidateI(i) == cand) {
				return i;
			}
		}
		return 0;
	}

	public int[] getRcl() {
		return rcl;
	}

	public void setRcl(int rcl[]) {
		this.rcl = rcl;
	}

	public int getRclSize() {
		return rcl_size;
	}

	public void setRclSize(int rcl_size) {
		this.rcl_size = rcl_size;
	}
	
}
