package search;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ResultFunction;


public class TablutResultFunction implements ResultFunction {

	
	public Object result(Object o, Action a) {
		
		BlackTablutState mcState = (BlackTablutState) o;
		if (TablutActionsFunction.MC.equals(a))
			return moveMC(mcState);
		if (TablutActionsFunction.MM.equals(a))
			return moveMM(mcState);
		if (TablutActionsFunction.CC.equals(a))
			return moveCC(mcState);
		if (TablutActionsFunction.M.equals(a))
			return moveM(mcState);
		if (TablutActionsFunction.C.equals(a))
			return moveC(mcState);
		
		//noOp
		return mcState;
	}
	


	private BlackTablutState moveMC(BlackTablutState mcState) {
		if (mcState.isPosBoat())
 			return new BlackTablutState(mcState.getTotMissionars(),
 															mcState.getTotCannibals(),
															mcState.getMissionars() - 1,
															mcState.getCannibals() - 1,
															! mcState.isPosBoat());
 		else
 			return new BlackTablutState(mcState.getTotMissionars(),
															mcState.getTotCannibals(),
															mcState.getMissionars() + 1,
															mcState.getCannibals() + 1,
															! mcState.isPosBoat());
 	}
	
 	private BlackTablutState moveMM(BlackTablutState mcState) {
 		if (mcState.isPosBoat())
 			return new BlackTablutState(mcState.getTotMissionars(),
															mcState.getTotCannibals(),
															mcState.getMissionars() - 2,
															mcState.getCannibals(),
															! mcState.isPosBoat());
 		else
 			return new BlackTablutState(mcState.getTotMissionars(),
															mcState.getTotCannibals(),
															mcState.getMissionars() + 2,
															mcState.getCannibals(),
															! mcState.isPosBoat());
 	}

 	private BlackTablutState moveCC(BlackTablutState mcState) {
 		if (mcState.isPosBoat())
 			return new BlackTablutState(mcState.getTotMissionars(),
															mcState.getTotCannibals(),
															mcState.getMissionars(),
															mcState.getCannibals() - 2,
															! mcState.isPosBoat());
 		else
 			return new BlackTablutState(mcState.getTotMissionars(),
															mcState.getTotCannibals(),
															mcState.getMissionars(),
															mcState.getCannibals() + 2,
															! mcState.isPosBoat());
 	}
	
 	private BlackTablutState moveM(BlackTablutState mcState) {
 		if (mcState.isPosBoat())
 			return new BlackTablutState(mcState.getTotMissionars(),
															mcState.getTotCannibals(),
															mcState.getMissionars() - 1,
															mcState.getCannibals(),
															! mcState.isPosBoat());
 		else
 			return new BlackTablutState(mcState.getTotMissionars(),
															mcState.getTotCannibals(),
															mcState.getMissionars() + 1,
															mcState.getCannibals(),
															! mcState.isPosBoat());
 	}
 	
 	private BlackTablutState moveC(BlackTablutState mcState) {
 		if (mcState.isPosBoat())
 			return new BlackTablutState(mcState.getTotMissionars(),
															mcState.getTotCannibals(),
															mcState.getMissionars(),
															mcState.getCannibals() - 1,
															! mcState.isPosBoat());
 		else
 			return new BlackTablutState(mcState.getTotMissionars(),
															mcState.getTotCannibals(),
															mcState.getMissionars(),
															mcState.getCannibals() + 1,
															! mcState.isPosBoat());
 	}

	
	
}
