package Cooperation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Environment.CollectionSolutions;
import Environment.Element;
import Environment.Problem;
import Environment.Solution;
import Factorys.StopConditionAllThreadsFactory;
import Function_Package.StopConditionAllThreads;
import Function_Package.WriterInFile;
import Methods.Method;
import MultiagentSystem.Agent;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Solution pool class.
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public abstract class PoolSolutions extends CollectionSolutions {

	//DEFINITION OF OBSERVABLE  -  LISTENERS
	private boolean state;
	private List<Agent> observers = new ArrayList<Agent>();
	
	private StopConditionAllThreads stopcondition_allthreads;
	
	//private Solution collection_of_solutions[];
	//private int size;
	//private int max_size;
	private double radius_niche;
	private double distances[][]; //distances i x j
	private double distance[];
	private double shi[];
	private Solution best_solution_pool;
	private Solution worst_solution_pool;
	
	
	public PoolSolutions(int size_max, double radius_niche)
	{
		super(size_max);
		
		this.radius_niche = radius_niche;
		this.distances = new double[this.getMaxSize()][this.getMaxSize()];
		this.distance = new double[this.getMaxSize()];
		this.shi = new double[this.getMaxSize()];
		
		this.state = false;
		
	}
	
	public abstract int calculateDistanceBetweenSolutions(Solution s1, Solution s2, Problem p);
	
	public abstract Solution getPartialSolution(int portion_size, int receiver_size, Problem p);
	
	public abstract Solution getSolutionGRASP(Method construction, int portion_size, int receiver_size, Problem p);
	
	public synchronized void addSolutionInPool(Solution s, Problem p, int id_sender, long solution_time, Element e)
	{
		int worst_pos;
		
		s.getSender().setIdSender(id_sender);
		s.getSender().setTimeSender(solution_time);
		
		//If there is space
		if(this.getSize() < this.getMaxSize())
		{
			//s.getReceiver().addReceiver(receiver, System.currentTimeMillis());
			this.getSolutionInCollection(this.getSize()).copyValuesSolution(s, p);
			this.setSize(this.getSize() + 1);
		}
		else //full pool
		{
			//update distances between solutions
			this.calculateDistancesSolutions(p);
			//replace the worse solution
			worst_pos = this.searchISolutionWithWorstSHi();
			//s.getReceiver().addReceiver(receiver, System.currentTimeMillis());
			this.getSolutionInCollection(worst_pos).copyValuesSolution(s, p);
		}
		//update the best solution in the pool
		if(s.getObjectiveFunctionI(0) < this.best_solution_pool.getObjectiveFunctionI(0)) {
			this.best_solution_pool.copyValuesSolution(s, p);
		}
		
		//this.setChange(true); //CHANGE OF LISTENING STATUS
		this.notifyAllObservers();
		
		//STOP ALL THREADS
		StopConditionAllThreadsFactory stopcondition_factory = new StopConditionAllThreadsFactory();
		this.stopcondition_allthreads = stopcondition_factory.createStopConditionAllThreads(p);
		if(this.stopcondition_allthreads.stopConditionAllThreads(e, p, s)) {
			System.out.println("NOTIFY ALL THREADS ----------------------------------");
			this.notifyAllObserversBestSolution();
			//STOP ALL THREADS
		}
		
	}
	
	public boolean evaluatesInsertionInThePool(Solution s) {
		
		if(s.getObjectiveFunctionI(0) < this.best_solution_pool.getObjectiveFunctionI(0)) {
			return true;  //better than the best solution pool
		}
		else {
			this.worst_solution_pool = getWorstSolutionOfCollection();
			if(s.getObjectiveFunctionI(0) < this.worst_solution_pool.getObjectiveFunctionI(0)) {
				return true;	//better than the worst solution	
			}
			else
				return false;   //do not enter the pool
		}
	}
	
	public synchronized void addSolutionInPool_evaluation(Solution s, Problem p, int id_sender, long solution_time, Element e)
	{
		int worst_pos;
		boolean duplicate = false;
		
		s.getSender().setIdSender(id_sender);
		s.getSender().setTimeSender(solution_time);
		
		//update distances between solutions
		this.calculateFunctionShi(s, p);
		
		if(this.getSize() < this.getMaxSize())
		{
			//s.getReceiver().addReceiver(receiver, System.currentTimeMillis());
			for(int i = 0; i < this.getSize(); i++) {
				if(this.shi[i] == 1) {
					duplicate = true;
				}
			}
			if(!duplicate) {
				this.getSolutionInCollection(this.getSize()).copyValuesSolution(s, p);
				this.setSize(this.getSize() + 1);;
				
				//update the best solution in the pool
				if(this.getSize() == 1) { 
					this.best_solution_pool.copyValuesSolution(s, p);
				} else if(s.getObjectiveFunctionI(0) < this.best_solution_pool.getObjectiveFunctionI(0)) {
					this.best_solution_pool.copyValuesSolution(s, p);
				}
			}
		}
		else //full pool
		{
			if(this.evaluatesInsertionInThePool(s)) {
				//replace the worse solution
				worst_pos = this.searchISolutionWithWorstSHi();
				//s.getReceiver().addReceiver(receiver, System.currentTimeMillis());
				this.getSolutionInCollection(worst_pos).copyValuesSolution(s, p);
				
				//update the best solution in the pool
				if(this.getSize() == 1) { 
					this.best_solution_pool.copyValuesSolution(s, p);
				} else if(s.getObjectiveFunctionI(0) < this.best_solution_pool.getObjectiveFunctionI(0)) {
					this.best_solution_pool.copyValuesSolution(s, p);
				}
			}
		}
		
		//this.setChange(true); //CHANGE OF LISTENING STATUS
		this.notifyAllObservers();
				
		//STOP ALL THREADS
		StopConditionAllThreadsFactory stopcondition_factory = new StopConditionAllThreadsFactory();
		this.stopcondition_allthreads = stopcondition_factory.createStopConditionAllThreads(p);
		if(this.stopcondition_allthreads.stopConditionAllThreads(e, p, s)) {
			System.out.println("NOTIFY ALL THREADS ----------------------------------");
			this.notifyAllObserversBestSolution();
			//STOP ALL THREADS
		}		
	}
	
	//pior SHI - maior SHI
	public synchronized int searchISolutionWithWorstSHi()
	{
		double larger = this.shi[0];
		int pos_larger = 0;
		for(int i = 1; i < this.getSize(); i++)
		{
			if(this.shi[i] > larger)
			{
				larger = this.shi[i];
				pos_larger = i;
			}
		}
		return pos_larger;
	}
	
	public synchronized int searchISolutionWithWorstDistance()
	{
		double larger = this.distance[0];
		int pos_larger = 0;
		for(int i = 1; i < this.getSize(); i++)
		{
			if(this.distance[i] > larger)
			{
				larger = this.distance[i];
				pos_larger = i;
			}
		}
		return pos_larger;
	}
	
	//SHi
	public synchronized void calculateDistancesSolutions(Problem p)
	{
		double d = 0;		
		//System.out.print("\n\n");
		for(int i = 0; i < this.getSize(); i++)
		{
			for(int j = i; j < this.getSize(); j++)
			{
				d = calculateDistanceBetweenSolutions(this.getSolutionInCollection(i), this.getSolutionInCollection(j), p);
				//System.out.println("Distance ["+ i + "][" + j + "] :" + distance);
				if(d <= this.radius_niche)
				{
					this.distances[i][j] = 1 - (d / this.radius_niche);
					this.distances[j][i] = this.distances[i][j];
				}
				else
				{
					this.distances[i][j] = 0;
					this.distances[j][i] = this.distances[i][j];
				}
				//System.out.println("Distance: " + this.distances[i][j]);
			}
		}
		//calculate shi
		for(int i = 0; i < this.getSize(); i++)
		{
			this.shi[i] = 0;
			for(int j = 0; j < this.getSize(); j++)
			{
				this.shi[i] = this.shi[i] + this.distances[i][j];
			}
			//System.out.println("SHi: " + this.shi[i]);
		}
	}
	
	//SHi
	public synchronized void calculateFunctionShi(Solution s, Problem p)
	{
		double dist = 0;		
		//System.out.print("\n\n");
		for(int i = 0; i < this.getSize(); i++)
		{
			dist = calculateDistanceBetweenSolutions(s, this.getSolutionInCollection(i), p);
			//System.out.println("Distance ["+ i + "][" + j + "] :" + distance);
			if(dist <= this.radius_niche)
			{
				//quanto mais próximo de 1, mais próximas são as soluções
				this.distance[i] = 1 - (dist / this.radius_niche);
				this.shi[i] = 1 - (dist / this.radius_niche);
			}
			else
			{
				//0 para soluções mais distantes (com base no raio do nicho)
				this.distance[i] = 0;
				this.shi[i] = 0;
			}
				//System.out.println("Distance: " + this.distances[i][j]);
		}
		
	}
	
	public Solution getRandomSolutionCollection(int receiver, long solution_time)
	{
		int pos = (int)(Math.random() * this.getSize());
	
		this.getSolutionInCollection(pos).getReceiver().addReceiver(receiver,  solution_time);
	
		return this.getSolutionInCollection(pos);
	}
	
	//small objective function
	public synchronized Solution getBestSolutionOfCollection()
	{
		int pos_small = 0;
		double of_small = this.getSolutionInCollection(0).getObjectiveFunctionI(0);
		
		for(int i = 1; i < this.getSize(); i++)
		{
			if(this.getSolutionInCollection(i).getObjectiveFunctionI(0) < of_small)
			{
				pos_small = i;
				of_small = this.getSolutionInCollection(i).getObjectiveFunctionI(0);
			}
		}
		if(this.getSize() > 1)
		{
			if(this.getSolutionInCollection(pos_small).getObjectiveFunctionI(0) < this.best_solution_pool.getObjectiveFunctionI(0))
				return this.getSolutionInCollection(pos_small);
			else
				return this.best_solution_pool;
		}
		else
			return this.getSolutionInCollection(pos_small);
	}
	
	//worst objective function
	public synchronized Solution getWorstSolutionOfCollection()
		{
		int pos_greater = 0;
		double of_greater = this.getSolutionInCollection(0).getObjectiveFunctionI(0);
			
		for(int i = 1; i < this.getSize(); i++)
		{
			if(this.getSolutionInCollection(i).getObjectiveFunctionI(0) > of_greater)
			{
				pos_greater = i;
				of_greater = this.getSolutionInCollection(i).getObjectiveFunctionI(0);
			}
		}
		return this.getSolutionInCollection(pos_greater);
	}	
	
	public synchronized void showPoolSolutions(Problem p)
	{
		System.out.println("\n\n\nPOOL SOLUTIONS");
		System.out.println("\n\nTAMANHO: " + this.getSize() + "\n");
		for(int i = 0; i < this.getSize(); i++)
		{
			this.getSolutionInCollection(i).showSolution(p);
		}
	}
	
	public synchronized void writePoolSolutions(Problem p, WriterInFile fw) throws IOException
	{
		fw.writerTextFile("\n\n\nPOOL SOLUTIONS");
		fw.writerTextFile("\n\nTAMANHO: " + this.getSize() + "\n");
		for(int i = 0; i < this.getSize(); i++)
		{
			this.getSolutionInCollection(i).writeSolution(p, fw);
		}
	}
	
	
	public synchronized void writePoolSolutionsReduce(Problem p, WriterInFile fw) throws IOException
	{
		fw.writerTextFile("\n\n\nPOOL SOLUTIONS");
		fw.writerTextFile("\n\nTAMANHO: " + this.getSize() + "\n");
		for(int i = 0; i < this.getSize(); i++)
		{
			this.getSolutionInCollection(i).writeReduceSolution(p, fw);
		}
	}
	
	//getter and setter ---------------------------------------
	public double getRadiusNiche() {
		return radius_niche;
	}

	public void setRadiusNiche(double radius_niche) {
		this.radius_niche = radius_niche;
	}

	public double[][] getDistances() {
		return distances;
	}

	public void setDistances(double distances[][]) {
		this.distances = distances;
	}

	public double[] getShi() {
		return shi;
	}

	public void setShi(double shi[]) {
		this.shi = shi;
	}

	public Solution getBestSolutionPool() {
		return best_solution_pool;
	}

	public void setBestSolutionPool(Solution best_solution_pool) {
		this.best_solution_pool = best_solution_pool;
	}

	//DEFINITION OF OBSERVABLE  -  LISTENERS  ---------------
	public void attach(Agent observer){
		observers.add(observer);		
	}
	
	public void setChange(boolean state) {
		this.state = state;
		notifyAllObservers();
	}
	
	public void notifyAllObserversBestSolution(){
		for (Agent observer : observers) {
			observer.updateBestSolution();;
		}
	}
	
	public void notifyAllObservers(){
		for (Agent observer : observers) {
			observer.update();
		}
	}
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	//----------------
		
}
