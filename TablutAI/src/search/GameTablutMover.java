package search;

import java.io.IOException;

import aima.core.agent.impl.DynamicAction;
import it.unibo.ai.didattica.competition.tablut.domain.Action;
import it.unibo.ai.didattica.competition.tablut.domain.GameTablut;
import it.unibo.ai.didattica.competition.tablut.domain.State;
import it.unibo.ai.didattica.competition.tablut.domain.State.Turn;
import it.unibo.ai.didattica.competition.tablut.domain.StateTablut;
import it.unibo.ai.didattica.competition.tablut.exceptions.ActionException;
import it.unibo.ai.didattica.competition.tablut.exceptions.BoardException;
import it.unibo.ai.didattica.competition.tablut.exceptions.ClimbingException;
import it.unibo.ai.didattica.competition.tablut.exceptions.DiagonalException;
import it.unibo.ai.didattica.competition.tablut.exceptions.OccupitedException;
import it.unibo.ai.didattica.competition.tablut.exceptions.PawnException;
import it.unibo.ai.didattica.competition.tablut.exceptions.StopException;
import it.unibo.ai.didattica.competition.tablut.exceptions.ThroneException;

public class GameTablutMover {


	
	public static AITablutState checkMove(AITablutState state, aima.core.agent.Action a) throws BoardException, ActionException, StopException, PawnException, DiagonalException, ClimbingException, ThroneException, OccupitedException, IOException
	{	
		String name=((DynamicAction)a).getName();
		//System.out.println("----->"+name);
		Action aiAction; 
		if(name.charAt(4)=='B') {
			aiAction= new Action(name.substring(0,2),name.substring(2,4),Turn.BLACK);
		}else {
			aiAction= new Action(name.substring(0,2),name.substring(2,4),Turn.WHITE);				
		}
		
		//System.out.println("--------------------------------");
		//System.out.println(aiAction.toString());
		//System.out.println(state.getState().boardString());
		//System.out.println(state.getState().getTurn().toString());
		//System.out.println("pre-->" + state.getState().boardString());	
		//System.out.println("after-->" + state.getState().boardString());
		//System.out.println("--------------------------------");
		return state.getNext(movePawn(state.getState(), aiAction));
	}
	
	private static State movePawn(State state, Action a) {
		State ris = state.clone();
		State.Pawn pawn = ris.getPawn(a.getRowFrom(), a.getColumnFrom());
		State.Pawn[][] newBoard = ris.getBoard();
		//libero il trono o una casella qualunque
		if(newBoard.length==9)
		{
			if(a.getColumnFrom()==4 && a.getRowFrom()==4)
			{
				newBoard[a.getRowFrom()][a.getColumnFrom()]= State.Pawn.THRONE;
			}
			else
			{
				newBoard[a.getRowFrom()][a.getColumnFrom()]= State.Pawn.EMPTY;
			}
		}
		if(newBoard.length==7)
		{
			if(a.getColumnFrom()==3 && a.getRowFrom()==3)
			{
				newBoard[a.getRowFrom()][a.getColumnFrom()]= State.Pawn.THRONE;
			}
			else
			{
				newBoard[a.getRowFrom()][a.getColumnFrom()]= State.Pawn.EMPTY;
			}
		}
		
		//metto nel nuovo tabellone la pedina mossa
		newBoard[a.getRowTo()][a.getColumnTo()]=pawn;
		//aggiorno il tabellone
		ris.setBoard(newBoard);
		//cambio il turno
		if(ris.getTurn().equalsTurn(State.Turn.WHITE.toString()))
		{
			ris.setTurn(State.Turn.BLACK);
		}
		else
		{
			ris.setTurn(State.Turn.WHITE);
		}
		
		
		return ris;
	}
}
