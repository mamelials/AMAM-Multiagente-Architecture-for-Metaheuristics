
package Main;

import java.text.SimpleDateFormat;

/** AMAM - Multiagent architecture for metaheuristics
 * 
 * Copyright (C) 2013-2018 Silva, M.A.L.
 * Function: This class implement the 
 * @author Maria Amélia Lopes Silva <mamelia@ufv.br>
 * 
 *  This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//------------------C-------------------
		
		String instance = "C101";

		//ONE AGENT -----------------------------------
		String experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		Experiment experiment = new Experiment(experiment_text_file, "");
		
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
				
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		//--------------------------
		
		
		instance = "C102";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		//--------------------------
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		
		instance = "C103";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		//--------------------------
		
		java.awt.Toolkit.getDefaultToolkit().beep();

		instance = "C104";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		//--------------------------
				
		java.awt.Toolkit.getDefaultToolkit().beep();

		
		instance = "C105";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();

		//--------------------------
		
		instance = "C106";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();

		//--------------------------

		instance = "C107";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "C108";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//---------------------
	
		instance = "C109";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		//-------------
		
		instance = "C201";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "C202";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "C203";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "C204";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "C205";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "C206";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "C207";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "C208";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		//------------------R-------------------
		
		instance = "R101";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
				
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		//--------------------------
		
		
		instance = "R102";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		//--------------------------
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		
		instance = "R103";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		//--------------------------
		
		java.awt.Toolkit.getDefaultToolkit().beep();

		instance = "R104";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		//--------------------------
				
		java.awt.Toolkit.getDefaultToolkit().beep();

		
		instance = "R105";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();

		//--------------------------
		
		instance = "R106";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();

		//--------------------------

		instance = "R107";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "R108";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();

		//-------------
		
		instance = "R109";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		//-------------

		instance = "R110";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		//-------------

		instance = "R111";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		//-------------

		instance = "R112";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		//-------------

		
		instance = "R201";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "R202";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "R203";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "R204";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "R205";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "R206";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "R207";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "R208";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "R209";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "R210";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "R211";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		//----------------------RC--------------
		
		instance = "RC101";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
				
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		//--------------------------
		
		
		instance = "RC102";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		//--------------------------
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		
		instance = "RC103";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		//--------------------------
		
		java.awt.Toolkit.getDefaultToolkit().beep();

		instance = "RC104";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		//--------------------------
				
		java.awt.Toolkit.getDefaultToolkit().beep();

		
		instance = "RC105";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();

		//--------------------------
		
		instance = "RC106";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();

		//--------------------------

		instance = "RC107";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "RC108";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		//-------------
		
		instance = "RC201";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "RC202";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "RC203";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "RC204";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------

		instance = "RC205";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "RC206";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "RC207";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		instance = "RC208";
		
		//ONE AGENT -----------------------------------
		experiment_text_file = "VRP_" + instance + "_OneAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("OneAgent");
		
		//TWO AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_TwoAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("TwoAgents");

		
		//FOUR AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_FourAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("FourAgents");

		//EIGHT AGENTS -----------------------------------
		experiment_text_file = "VRP_" + instance + "_EightAgent";
		
		//LOADS ALL PARAMETERS AND PROBLEM DATA
		experiment = new Experiment(experiment_text_file, "");
		
		//RUN THE EXPERIMENT
		experiment.runExperiment("EightAgents");
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//--------------------------
		
		
		//HORA DO FIM DO EXPERIMENTO
		String data = "dd/MM/yyyy";
		String hora = "h:mm - a";
		String data1, hora1;
		java.util.Date agora = new java.util.Date();;
		SimpleDateFormat formata = new SimpleDateFormat(data);
		data1 = formata.format(agora);
		formata = new SimpleDateFormat(hora);
		hora1 = formata.format(agora);
		System.out.print(data1 + " ");
		System.out.print(hora1 + " ");
		
		System.out.println("\n\nEND EXPERIMENT!");
		
	}
}
