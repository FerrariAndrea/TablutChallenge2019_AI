	package search;


	import aima.core.agent.Action;
	import aima.core.search.framework.evalfunc.HeuristicFunction;
	import aima.core.search.framework.problem.GoalTest;
	import aima.core.search.framework.problem.StepCostFunction;
	import it.unibo.ai.didattica.competition.tablut.domain.StateTablut;
	import it.unibo.ai.didattica.competition.tablut.domain.State.Turn;

public class AITablutState implements GoalTest,StepCostFunction,HeuristicFunction{



		
		
		
	/*****************************************************************************
	 * Description of the state of the problem
	/*****************************************************************************/
		private  it.unibo.ai.didattica.competition.tablut.domain.State state;
		private boolean im_white;
	 
	/*****************************************************************************
	 * Methods for accessing the state
	/*****************************************************************************/
		
			
		public it.unibo.ai.didattica.competition.tablut.domain.State getState() {
			return state;
		}
		public void setState(it.unibo.ai.didattica.competition.tablut.domain.State state) {
			this.state=state;
		}
		public AITablutState getNext(it.unibo.ai.didattica.competition.tablut.domain.State state) {
			return new AITablutState(state,im_white);
		}
		public boolean m_i_white() {
			return im_white;
		}

		
		/*
		public void setState(StateTablut state) {
			this.state = state;
		}
		*/
		
	


	/*****************************************************************************
	 * CONSTRUCTORS	
	/*****************************************************************************/
		/*
		 * Default constructor.
		 * 
		 * It initializes the problem as start configuration
		 */
		public AITablutState(boolean im_white) {
			this(new StateTablut(),im_white);
		}



		/*
		 * Generic constructor.
		 *
		 */
		public AITablutState(it.unibo.ai.didattica.competition.tablut.domain.State state,boolean im_white) {
			this.state=state;
			this.im_white= im_white;
		}


		
		
	/*****************************************************************************
	* Methods for the interface GoalTest
	/*****************************************************************************/
		public boolean isGoalState(Object state) {
			if (state instanceof AITablutState) {
				AITablutState tablutstate = (AITablutState) state;	
				if(tablutstate.m_i_white()) {
					 return (tablutstate.getState().getTurn().equals(Turn.WHITEWIN));	
				}else {
					 return (tablutstate.getState().getTurn().equals(Turn.BLACKWIN));	
				}
						
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
	 	
	 	
		//------------------------------------------------------------------------------DA FARE
	 	public double c(Object fromState, Action a, Object toState) {
	 		return 1.0;
	 	}
	 	
	 


	/*****************************************************************************
	* Methods for the interface HeuristicFunction
	/*****************************************************************************/
	 	//--------------------------------------------------------------------------------DA FARE
		public double getHeuristicValue(Object state) {
			if (state instanceof AITablutState) {
				AITablutState mcState = (AITablutState) state;
	 			int hVal = 0;//mcState.missionars + mcState.cannibals - (mcState.posBoat? 1:0);
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
	 		AITablutState temp = (AITablutState) o1; 
	 		return this.im_white == temp.im_white &&this.state.equals(temp.state);
	 		
	 	}
		
	 	public String toString() {
	 		String tempPlayer = "Black";
	 		if(this.im_white) {
	 			 tempPlayer = "White";
	 		}
	 		return 	"Player["+ tempPlayer+ "] game[" + this.state.toLinearString()+"]";
		}
		
	 	
	 	
	 	


}
