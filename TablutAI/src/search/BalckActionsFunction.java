package search;

import java.util.Set;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ActionsFunction;
import it.unibo.ai.didattica.competition.tablut.domain.State.Pawn;
import it.unibo.ai.didattica.competition.tablut.domain.StateTablut;



public class BalckActionsFunction implements ActionsFunction {

	//mosse non valide per i neri (considero non valido il trono)
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
	private char int_to_char_pos[] = {'A','B','C','D','E','F','G','H','I'};
	
//	@Override
	public Set<Action> actions(Object o) {
		AITablutState mcState = (AITablutState) o;
		Set<Action> result = new LinkedHashSet<Action>();
		StateTablut st = mcState.getState();
		for(int x=0;x<9;x++) {
			for(int y=0;y<9;y++) {
				if(st.getPawn(x, y)==Pawn.BLACK) {
					//SINISTRA
					for(int sinistra_x = x-1;sinistra_x>=0;sinistra_x--) {
						if(blackValid[sinistra_x][y] && st.getPawn(sinistra_x, y)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+y+int_to_char_pos[sinistra_x]+y));
						}else {
							break;
						}
					}
					//DESTRA
					for(int destra_x = x;destra_x<9;destra_x++) {
						if(blackValid[destra_x][y] && st.getPawn(destra_x, y)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+y+int_to_char_pos[destra_x]+y));
						}else {
							break;
						}
					}
					//SU
					for(int su_y = y-1;su_y>=0;su_y--) {
						if(blackValid[x][su_y] && st.getPawn(x, su_y)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+y+int_to_char_pos[x]+su_y));
						}else {
							break;
						}
					}
					//Giù
					for(int giu_y = y;giu_y<9;giu_y++) {
						if(blackValid[x][giu_y] && st.getPawn(x, giu_y)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+y+int_to_char_pos[x]+giu_y));
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
