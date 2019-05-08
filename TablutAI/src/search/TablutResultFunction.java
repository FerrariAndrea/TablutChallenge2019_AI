package search;

import java.io.IOException;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ResultFunction;
import it.unibo.ai.didattica.competition.tablut.exceptions.ActionException;
import it.unibo.ai.didattica.competition.tablut.exceptions.BoardException;
import it.unibo.ai.didattica.competition.tablut.exceptions.ClimbingException;
import it.unibo.ai.didattica.competition.tablut.exceptions.DiagonalException;
import it.unibo.ai.didattica.competition.tablut.exceptions.OccupitedException;
import it.unibo.ai.didattica.competition.tablut.exceptions.PawnException;
import it.unibo.ai.didattica.competition.tablut.exceptions.StopException;
import it.unibo.ai.didattica.competition.tablut.exceptions.ThroneException;
public class TablutResultFunction implements ResultFunction {

	
	public Object result(Object o, Action a) {
	
			
		try {
			//System.out.println("TablutResultFunction->" + ((AITablutState) o).getState().getTurn().toString());
			return GameTablutMover.checkMove((AITablutState) o, a);
		} catch (BoardException | ActionException | StopException | PawnException | DiagonalException
				| ClimbingException | ThroneException | OccupitedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	

	
	
}
