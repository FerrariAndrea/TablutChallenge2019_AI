package search;

import java.io.IOException;

import aima.core.agent.impl.DynamicAction;
import it.unibo.ai.didattica.competition.tablut.domain.Action;
import it.unibo.ai.didattica.competition.tablut.domain.GameTablut;
import it.unibo.ai.didattica.competition.tablut.domain.State;
import it.unibo.ai.didattica.competition.tablut.domain.State.Turn;
import it.unibo.ai.didattica.competition.tablut.exceptions.ActionException;
import it.unibo.ai.didattica.competition.tablut.exceptions.BoardException;
import it.unibo.ai.didattica.competition.tablut.exceptions.ClimbingException;
import it.unibo.ai.didattica.competition.tablut.exceptions.DiagonalException;
import it.unibo.ai.didattica.competition.tablut.exceptions.OccupitedException;
import it.unibo.ai.didattica.competition.tablut.exceptions.PawnException;
import it.unibo.ai.didattica.competition.tablut.exceptions.StopException;
import it.unibo.ai.didattica.competition.tablut.exceptions.ThroneException;

public class GameTablutSingleton {

	private static GameTablutSingleton _instance =null;
	private GameTablut game = null;
	
	public static GameTablutSingleton getInstance() {
		if(_instance==null){
			_instance=new GameTablutSingleton();
		}
		return _instance;
	}
	
	public GameTablutSingleton() {
		game = new GameTablut();
	}
	
	
	public State checkMove(AITablutState state, aima.core.agent.Action a) throws BoardException, ActionException, StopException, PawnException, DiagonalException, ClimbingException, ThroneException, OccupitedException, IOException
	{	
		String name=((DynamicAction)a).getName();
		System.out.println("----->"+name);
		Action aiAction; 
		if(name.charAt(4)=='B') {
			aiAction= new Action(name.substring(0,2),name.substring(2,4),Turn.BLACK);
		}else {
			aiAction= new Action(name.substring(0,2),name.substring(2,4),Turn.BLACK);				
		}
	
		return game.checkMove(state.getState(), aiAction);
	}
	
}
