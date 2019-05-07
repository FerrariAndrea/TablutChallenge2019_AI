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



public class BlackActionsFunction implements ActionsFunction {

	//mosse non valide per i neri (considero non valido il trono)
	//abbiamo aggiunto una riga e una colonna per non fare -1 negli accessi
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
	
//	@Override
	public Set<Action> actions(Object o) {
		AITablutState mcState = (AITablutState) o;
		Set<Action> result = new LinkedHashSet<Action>();
		StateTablut st = mcState.getState();
		for(int x=1;x<10;x++) {
			for(int y=1;y<10;y++) {
				if(st.getPawn(y, x)==Pawn.BLACK) {
					//SINISTRA
					for(int sinistra_x = x-1;sinistra_x>=1;sinistra_x--) {
						if(blackValid[y][sinistra_x] && st.getPawn(y, sinistra_x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+y+int_to_char_pos[sinistra_x]+y+"B"));
						}else {
							break;
						}
					}
					//DESTRA
					for(int destra_x = x;destra_x<10;destra_x++) {
						if(blackValid[y][destra_x] && st.getPawn(y, destra_x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+y+int_to_char_pos[destra_x]+y+"B"));
						}else {
							break;
						}
					}
					//SU
					for(int su_y = y-1;su_y>=1;su_y--) {
						if(blackValid[su_y][x] && st.getPawn(su_y, x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+y+int_to_char_pos[x]+su_y+"B"));
						}else {
							break;
						}
					}
					//Giù
					for(int giu_y = y;giu_y<10;giu_y++) {
						if(blackValid[giu_y][x] && st.getPawn(giu_y, x)==Pawn.EMPTY) {
							result.add(new DynamicAction(""+int_to_char_pos[x]+y+int_to_char_pos[x]+giu_y+"B"));
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
