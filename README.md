# AMAM: Multiagente Architecture for Metaheuristics
Copyright (C) 2013-2017 Silva, M.A.L.
 
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 


AMAM framework, whose initial formulations was proposed in Silva (2007), Fernandes et al. (2009) and Silva et al. (2014, 2015), is a Multi-agent Architecture for Metaheuristic. In this framework, each agent encapsulates a heuristic/metaheuristic and has the function of seeking the solution for a given Combinatorial Optimization problem. The strength of the proposed framework is the hybridization capacity of metaheuristics through a multi-agent approach, using concepts of cooperation and parallelism.

During the search process of the solution, the agents in this framework should go through the multi-agent system environment. In this case, the multi-agent environment is defined by the search space of the addressed problem. The perception and action capabilities of the agent are defined in this environment as:

   - Perception of the environment: ability of the agents to access information about the problem that are required to it;

   - Positioning: ability of the agents to define their positions in the environment, either by the construction of a new solution or by the choice of solutions already available;

   - Movement: ability of the agent to move, from one solution to another in the environment. The movement here comprises all kinds of solution modifications (neighborhood structures, operators) that allow the agent to move from one solution to another;

   - Cooperation: ability of the agent to share and provide solutions for the other agents of the system.

The actions available to each agent define the vision that it will have of the environment. Therefore, its representation of the environment is partial. The goal is to apply, at the same time, the strengths of each metaheuristic through the cooperative work of the agents.

The Object Oriented Programming paradigm is used to facilitate the development of the framework, allowing to reduce the effort used in the implementation of methods and in the adaptation of these to a specific problem. Therefore, a generic structure that enables the definition of the problem characteristics is used.

The cooperation between agents occurs through the exchange of information in the search space of the problem. The available solutions are stored in a pool of solutions in the environment and shared by the agents at the end of each iteration. The purpose of this cooperative structure is to guide agents in the solutions space toward the most promising areas, and thus, improves the final result and reduces the time needed to solve the problem.

AMAM framework applications to optimization problems have been showed in Fernandes et al. (2009), Silva et al. (2014) and Silva et al. (2015). This framework is under development and its most recent publication was presented in Silva et al. (2015).

    Silva, M. A. L., 2007. Modelagem de uma arquitetura multiagente para a solução, via metaheurísticas, de problemas de otimização combinatória. Master’s thesis, Federal Center of Technological Education of Minas Gerais (CEFET-MG), Belo Horizonte, Brazil. 

    Fernandes, F. C., de Souza, S. R., Silva, M. A. L., Borges, H. E., Ribeiro, F. F., 2009. A multiagent architecture for solving combinatorial optimization problems through metaheuristics. In: Proceedings of the 2009 IEEE International Conference on Systems, Man and Cybernetics (SMC 2009). pp. 3071–3076.

    Silva, M. A. L., de Souza, S. R., de Oliveira, S. M., Souza, M. J. F., 2014. An agent-based metaheuristic approach applied to the vehicle routing problem with time-windows. In: Proceedings of the 2014 Brazilian Conference on Intelligent Systems - Enc. Nac. de Inteligência Artificial e Computacional (BRACIS-ENIAC 2014). São Carlos, SP, Brazil.

    Silva, M. A. L., de Souza, S. R., Souza, M. J. F., de Oliveira, S. M., Nov 2015. A multi-agent metaheuristic optimization framework with
    cooperation. In: 2015 Brazilian Conference on Intelligent Systems (BRACIS). Natal, Brazil, pp. 104–109.
