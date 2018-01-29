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
 
AMAM framework, whose conceptual model was proposed in Silva (2007), is a Multi-agent Architecture for Metaheuristic, in which each agent implements a metaheuristic. The environment, where agents exist and act, corresponds to the search space of the optimization problem to be solved. Thus, by changing the problem to be solved, it is only necessary to make a simply change of the architecture environment. The movement ability of the agent through the search space of the problem is defined by the neighbourhood structures (movements) that it has.

The scalability of the AMAM architecture is guaranteed by the ease of adding new agents, with minimal impacton the rest of the architecture. These agents interact with the environment and with others agents cooperatively, exchanging and sharing information about their condition and about the environment. The software developed from the conceptual model is presented in Fernandes et al. (2009), and allows the creation of an instance of the environment and multiple agents to the search of the solution. Design patterns are used to ensure that the AMAM architecture be flexible and extensible.

The hybridization of metaheuristics is also guaranteed in the AMAM framework, through iteration between the different heuristic / metaheuristic agents. Additionally, AMAM offers the possibility of parallel execution, in which each agent runs on a separate thread.

AMAM framework applications to optimization problems have been showed in Fernandes et al. (2009), Silva et al. (2014) and Silva et al. (2015). This framework is under development and its most recent publication was presented in Silva et al. (2015).


    Fernandes, F. C., de Souza, S. R., Silva, M. A. L., Borges, H. E., Ribeiro, F. F., 2009. A multiagent architecture for solving combinatorial optimization problems through metaheuristics. In: Proceedings of the 2009 IEEE International Conference on Systems, Man and Cybernetics (SMC 2009). pp. 3071–3076.

    Silva, M. A. L., 2007. Modelagem de uma arquitetura multiagente para a solução, via metaheurísticas, de problemas de otimização combinatória. Master’s thesis, Federal Center of Technological Education of Minas Gerais (CEFET-MG), Belo Horizonte, Brazil. 

    Silva, M. A. L., de Souza, S. R., de Oliveira, S. M., Souza, M. J. F., 2014. An agent-based metaheuristic approach applied to the vehicle routing problem with time-windows. In: Proceedings of the 2014 Brazilian Conference on Intelligent Systems - Enc. Nac. de Inteligência Artificial e Computacional (BRACIS-ENIAC 2014). São Carlos, SP, Brazil.

    Silva, M. A. L., de Souza, S. R., Souza, M. J. F., de Oliveira, S. M., Nov 2015. A multi-agent metaheuristic optimization framework with
    cooperation. In: 2015 Brazilian Conference on Intelligent Systems (BRACIS). Natal, Brazil, pp. 104–109.
