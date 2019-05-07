import java.io.IOException;
import java.net.UnknownHostException;

import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.problem.Problem;
import aima.core.search.uninformed.DepthLimitedSearch;
import giocatori.AIBlack;
import it.unibo.ai.didattica.competition.tablut.client.TablutHumanClient;
import it.unibo.ai.didattica.competition.tablut.domain.Action;
import search.AITablutState;
import search.BlackActionsFunction;
import search.TablutResultFunction;

public class testAiBlack {
	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		AITablutState initState= new AITablutState(false);
		Problem problem = new Problem(initState,
				new BlackActionsFunction(),
				new TablutResultFunction(),
				initState,
				initState);
		DepthLimitedSearch search = new DepthLimitedSearch(10);
		SearchAgent agent;
		try {
			agent = new SearchAgent(problem, search);
			String name=((DynamicAction)agent.getActions().get(0)).getName();
			
			System.out.println(name);//Action aiAction;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
