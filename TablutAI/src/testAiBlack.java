import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import giocatori.AIBlack;
import it.unibo.ai.didattica.competition.tablut.client.TablutHumanClient;
import it.unibo.ai.didattica.competition.tablut.domain.Action;
import search.AITablutState;
import search.TablutActionsFunction;
import search.TablutResultFunction;

public class testAiBlack {
	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		AITablutState initState= new AITablutState(false);
		Problem problem = new Problem(initState,
				new TablutActionsFunction(),
				new TablutResultFunction(),
				initState,
				initState);
		DepthFirstSearch search = new DepthFirstSearch(new GraphSearch());
		SearchAgent agent;
		try {
			agent = new SearchAgent(problem, search);
			//String name=((DynamicAction)agent.getActions()).getName();
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			//System.out.println(name);//Action aiAction;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private static void printActions(List<aima.core.agent.Action> list) {
		for (int i = 0; i < list.size(); i++) {
			String action = list.get(i).toString();
			System.out.println(action);
		}
	}
	private static void printInstrumentation(Properties properties) {
		Iterator<Object> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property.toString());
		}

	}
}
