package search;


import aima.core.agent.Action;
import aima.core.search.framework.evalfunc.HeuristicFunction;
import aima.core.search.framework.problem.GoalTest;
import aima.core.search.framework.problem.StepCostFunction;
import it.unibo.ai.didattica.competition.tablut.domain.StateTablut;



public class TablutState implements GoalTest,StepCostFunction,HeuristicFunction {

	
	
	
/*****************************************************************************
 * Description of the state of the problem
/*****************************************************************************/
	private  StateTablut state;
 
/*****************************************************************************
 * Methods for accessing the state
/*****************************************************************************/
	
	
	
	
	
	
/*****************************************************************************
 * CONSTRUCTORS	
/*****************************************************************************/
	/*
	 * Default constructor.
	 * 
	 * It initializes the problem in the classic configuration (3,3,1).
	 */
	public TablutState() {
		this.state= new StateTablut();
	}

	/*
	 * Generic constructor.
	 * 
	 * Used for generating new states, as well as for creating different 
	 * instances of the problem (with more people, and maybe on different shores)
	 */
	public TablutState(StateTablut state) {
		this.state=state;
	}


	
	
/*****************************************************************************
* Methods for the interface GoalTest
/*****************************************************************************/
	public boolean isGoalState(Object state) {
		if (state instanceof TablutState) {
			TablutState mcState = (TablutState) state;
		   return (	this.state.getTurn().compareTo(Turn.win));
		}
		else
			return false;
	};
 
 
 
 

/*****************************************************************************
* Methods for the interface StepCostFunction
/*****************************************************************************/
	/*
 	public Double calculateStepCost(Object fromState, Object toState, String action) {
 		return new Double(1);
 	};
 	*/
 	
 	
 	public double c(Object fromState, Action a, Object toState) {
 		return 1.0;
 	}
 	
 


/*****************************************************************************
* Methods for the interface HeuristicFunction
/*****************************************************************************/
 	// This is the same proposed by Russell-Norvig
	public double getHeuristicValue(Object state) {
		if (state instanceof TablutState) {
 			TablutState mcState = (TablutState) state;
 			int hVal = mcState.missionars + mcState.cannibals - (mcState.posBoat? 1:0);
 			return hVal;
 		}
 		else return Integer.MAX_VALUE;
	}

	public double h(Object state) {
		return this.getHeuristicValue(state);
	}
 
 
/*****************************************************************************
* Generic Methods
/*****************************************************************************/
 	public int hashCode() {
		return 0;
	}

 	public boolean equals(Object o1) {
 		TablutState temp = (TablutState) o1; 
 		if (	(this.missionars == temp.missionars) &&
 				(this.cannibals == temp.cannibals) &&
				(this.posBoat == temp.posBoat))
 			return true;
 		else
 			return false;
 		
 	}
	
 	public String toString() {
 		return 	"(M:" + this.missionars + 
					", C:" + this.cannibals +
					", B:" + this.posBoat + " )";
	}
 	
 	
 	

}
