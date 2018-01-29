package Environment_PM;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: Component of Parallel Machines Problem  
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 **/

public class SetupTime {

	private int setup[][];

	public SetupTime(int n) {
		// TODO Auto-generated constructor stub
		
		this.setup = new int[n][n]; //n -> number of tasks = size problem
	}
	
	public void copyValuesSetupTime(SetupTime st, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.setup[i][j] = st.setup[i][j];
			}
		}
	}
	
	public void showSetupTime(int n) {
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++) {
				System.out.print(this.setup[i][j]+ " ");
			}
			System.out.println();
		}
	}

	public int getSetupTime(int i, int j) {
		return setup[i][j];
	}

	public void setSetupTime(int setup, int i, int j) {
		this.setup[i][j] = setup;
	}
}
