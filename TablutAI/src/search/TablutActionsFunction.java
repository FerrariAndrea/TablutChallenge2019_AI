package search;

import java.util.Set;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ActionsFunction;
import it.unibo.ai.didattica.competition.tablut.domain.State.Pawn;
import it.unibo.ai.didattica.competition.tablut.domain.State.Turn;
import it.unibo.ai.didattica.competition.tablut.domain.StateTablut;



public class TablutActionsFunction implements ActionsFunction {

	//mosse non valide per i neri (considero non valido il trono)
	//abbiamo aggiunto una riga e una colonna per non fare -1 negli accessi
	/*
	private boolean  blackValid[][] ={
			{false,false,false,false,false,false,false,false,false,false},
			{false,false,false,false,true,true,true,false,false,false},
			{false,false,true,true,true,true,true,true,true,false},
			{false,false,true,true,true,true,true,true,true,false},
			{false,false,true,true,true,true,true,true,true,false},
			{false,false,true,true,true,false,true,true,true,false},
			{false,false,true,true,true,true,true,true,true,false},
			{false,false,true,true,true,true,true,true,true,false},
			{false,false,true,true,true,true,true,true,true,false},
			{false,false,false,false,true,true,true,false,false,false}
	};
	
	private char int_to_char_pos[] = {'X','A','B','C','D','E','F','G','H','I'};
	*/
	private boolean  blackValid[][] ={
			{false,false,false,true,true,true,false,false,false},
			{false,true,true,true,true,true,true,true,false},
			{false,true,true,true,true,true,true,true,false},
			{false,true,true,true,true,true,true,true,false},
			{false,true,true,true,false,true,true,true,false},
			{false,true,true,true,true,true,true,true,false},
			{false,true,true,true,true,true,true,true,false},
			{false,true,true,true,true,true,true,true,false},
			{false,false,false,true,true,true,false,false,false}
	};
	private boolean  whiteValid[][] ={
			{true,true,true,false,false,false,true,true,true},
			{true,true,true,true,false,true,true,true,true},
			{true,true,true,true,true,true,true,true,true},
			{false,true,true,true,true,true,true,true,false},
			{false,false,true,true,false,true,true,false,false},
			{false,true,true,true,true,true,true,true,false},
			{true,true,true,true,true,true,true,true,true},
			{true,true,true,true,false,true,true,true,true},
			{true,true,true,false,false,false,true,true,true}
	};
	private char int_to_char_pos[] = {'A','B','C','D','E','F','G','H','I'};
	
//	@Override
	public Set<Action> actions(Object o) {
		AITablutState mcState = (AITablutState) o;		
		it.unibo.ai.didattica.competition.tablut.domain.State st = mcState.getState();
		System.out.println("ola------------------------->" +st.getTurn().toString());
		
		if(st.getTurn().equals(Turn.BLACK)) {
			return getBlackMoves(st);
		}else if(st.getTurn().equals(Turn.WHITE)) {
			return getWhiteMoves(st);
		}
		return new LinkedHashSet<Action>();
	}

	private Set<Action> getWhiteMoves(it.unibo.ai.didattica.competition.tablut.domain.State st){
		Set<Action> result = new LinkedHashSet<Action>();
		for(int x=0;x<9;x++) {
			for(int y=0;y<9;y++) {
				if(st.getPawn(y, x)==Pawn.WHITE && st.getPawn(y, x)==Pawn.KING) {
					//SINISTRA
					for(int sinistra_x = x-1;sinistra_x>=0;sinistra_x--) {
						if(whiteValid[y][sinistra_x] && st.getPawn(y, sinistra_x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+(y+1)+int_to_char_pos[sinistra_x]+(y+1)+"W"));
						}else {
							break;
						}
					}
					//DESTRA
					for(int destra_x = x;destra_x<9;destra_x++) {
						if(whiteValid[y][destra_x] && st.getPawn(y, destra_x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+(y+1)+int_to_char_pos[destra_x]+(y+1)+"W"));
						}else {
							break;
						}
					}
					//SU
					for(int su_y = y-1;su_y>=0;su_y--) {
						if(whiteValid[su_y][x] && st.getPawn(su_y, x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+(y+1)+int_to_char_pos[x]+(su_y+1)+"W"));
						}else {
							break;
						}
					}
					//Giù
					for(int giu_y = y;giu_y<9;giu_y++) {
						if(whiteValid[giu_y][x] && st.getPawn(giu_y, x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+(y+1)+int_to_char_pos[x]+(giu_y+1)+"W"));
						}else {
							break;
						}
					}
				}
			}
		}
		return result;
	}
	private Set<Action> getBlackMoves(it.unibo.ai.didattica.competition.tablut.domain.State st){
		Set<Action> result = new LinkedHashSet<Action>();
		for(int x=0;x<9;x++) {
			for(int y=0;y<9;y++) {
				if(st.getPawn(y, x)==Pawn.BLACK) {
					//SINISTRA
					for(int sinistra_x = x-1;sinistra_x>=0;sinistra_x--) {
						if(blackValid[y][sinistra_x] && st.getPawn(y, sinistra_x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+(y+1)+int_to_char_pos[sinistra_x]+(y+1)+"B"));
						}else {
							break;
						}
					}
					//DESTRA
					for(int destra_x = x;destra_x<9;destra_x++) {
						if(blackValid[y][destra_x] && st.getPawn(y, destra_x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+(y+1)+int_to_char_pos[destra_x]+(y+1)+"B"));
						}else {
							break;
						}
					}
					//SU
					for(int su_y = y-1;su_y>=0;su_y--) {
						if(blackValid[su_y][x] && st.getPawn(su_y, x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+(y+1)+int_to_char_pos[x]+(su_y+1)+"B"));
						}else {
							break;
						}
					}
					//Giù
					for(int giu_y = y;giu_y<9;giu_y++) {
						if(blackValid[giu_y][x] && st.getPawn(giu_y, x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+(y+1)+int_to_char_pos[x]+(giu_y+1)+"B"));
						}else {
							break;
						}
					}
				}
			}
		}
		return result;
	}

}
