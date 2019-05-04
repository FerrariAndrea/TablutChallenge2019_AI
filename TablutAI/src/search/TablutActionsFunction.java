package search;

import java.util.Set;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ActionsFunction;



public class TablutActionsFunction implements ActionsFunction {

	//raccoglitori di azioni
	public static List<Action> SU = new ArrayList<Action>();
	public static List<Action> GIU = new ArrayList<Action>();
	public static List<Action> DESTRA = new ArrayList<Action>();
	public static List<Action> SINISTRA = new ArrayList<Action>();
	//Genero una volta sola tutte le azioni possibili
	public TablutActionsFunction() {
		for(int x = 1;x<=8;x++) {
			SU.add(new DynamicAction("U"+x));//U-->UP
			GIU.add(new DynamicAction("D"+x));//D-->Down
			DESTRA.add(new DynamicAction("R"+x));//R->right
			SINISTRA.add(new DynamicAction("L"+x));//L->Left
		}
	}
	
	
//	@Override
	public Set<Action> actions(Object o) {
		BlackTablutState mcState = (BlackTablutState) o;
		Set<Action> result = new LinkedHashSet<Action>();
		/*
				if (canMoveMC(mcState))
					result.add(TablutActionsFunction.MC);
				if (canMoveMM(mcState))
					result.add(TablutActionsFunction.MM);
				if (canMoveCC(mcState))
					result.add(TablutActionsFunction.CC);
				if (canMoveM(mcState))
					result.add(TablutActionsFunction.M);
				if (canMoveC(mcState))
					result.add(TablutActionsFunction.C);
		*/
		return result;
	}

}
