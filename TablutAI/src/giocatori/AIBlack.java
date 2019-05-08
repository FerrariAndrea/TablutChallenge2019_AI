package giocatori;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.problem.Problem;
import aima.core.search.uninformed.DepthLimitedSearch;
import it.unibo.ai.didattica.competition.tablut.client.TablutClient;
import it.unibo.ai.didattica.competition.tablut.domain.Action;
import it.unibo.ai.didattica.competition.tablut.domain.StateTablut;
import it.unibo.ai.didattica.competition.tablut.domain.State.Turn;
import search.AITablutState;
import search.TablutActionsFunction;
import search.TablutResultFunction;

public class AIBlack extends TablutClient {

	public AIBlack() throws UnknownHostException, IOException {
		super("black", "AIBlack");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("You are player " + this.getPlayer().toString() + "!");
		String actionStringFrom = "";
		String actionStringTo = "";
		Action action;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			this.declareName();
		} catch (Exception e) {
			e.printStackTrace();
		}
	/*
		 //----------------------------------------------------------------------------------------Turn.WHITE
			System.out.println("You are player " + this.getPlayer().toString() + "!");
			while (true) {
				try {
					this.read();

					System.out.println("Current state:");
					System.out.println(this.getCurrentState().toString());
					if (this.getCurrentState().getTurn().equals(StateTablut.Turn.WHITE)) {
						System.out.println("Player " + this.getPlayer().toString() + ", do your move: ");
						System.out.println("From: ");
						actionStringFrom = in.readLine();
						System.out.println("To: ");
						actionStringTo = in.readLine();
						action = new Action(actionStringFrom, actionStringTo, this.getPlayer());
						this.write(action);
					} else if (this.getCurrentState().getTurn().equals(StateTablut.Turn.BLACK)) {
						System.out.println("Waiting for your opponent move... ");
					} else if (this.getCurrentState().getTurn().equals(StateTablut.Turn.WHITEWIN)) {
						System.out.println("YOU WIN!");
						System.exit(0);
					} else if (this.getCurrentState().getTurn().equals(StateTablut.Turn.BLACKWIN)) {
						System.out.println("YOU LOSE!");
						System.exit(0);
					} else if (this.getCurrentState().getTurn().equals(StateTablut.Turn.DRAW)) {
						System.out.println("DRAW!");
						System.exit(0);
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		*/
		 //----------------------------------------------------------------------------------------Turn.BALCK
			System.out.println("You are player " + this.getPlayer().toString() + "!");
			while (true) {
				try {
					this.read();
					System.out.println("Current state:");
					System.out.println(this.getCurrentState().toString());
					if (this.getCurrentState().getTurn().equals(StateTablut.Turn.BLACK)) {
						System.out.println("Player " + this.getPlayer().toString() + ", do your move: ");
						/*
						System.out.println("From: ");
						actionStringFrom = in.readLine();
						System.out.println("To: ");
						actionStringTo = in.readLine();
						action = new Action(actionStringFrom, actionStringTo, this.getPlayer());
						*/
						AITablutState initState= new AITablutState(false);
						Problem problem = new Problem(initState,
								new TablutActionsFunction(),
								new TablutResultFunction(),
								initState,
								initState);
						DepthLimitedSearch search = new DepthLimitedSearch(10);
						SearchAgent agent = new SearchAgent(problem, search);
						String name=((DynamicAction)agent.getActions().get(0)).getName();
						Action aiAction;
						
						if(name.charAt(4)=='B') {
							aiAction= new Action(name.substring(0,2),name.substring(2,4),Turn.BLACK);
						}else {
							aiAction= new Action(name.substring(0,2),name.substring(2,4),Turn.BLACK);				
						}
						this.write(aiAction);
					} else if (this.getCurrentState().getTurn().equals(StateTablut.Turn.WHITE)) {
						System.out.println("Waiting for your opponent move... ");
					} else if (this.getCurrentState().getTurn().equals(StateTablut.Turn.WHITEWIN)) {
						System.out.println("YOU LOSE!");
						System.exit(0);
					} else if (this.getCurrentState().getTurn().equals(StateTablut.Turn.BLACKWIN)) {
						System.out.println("YOU WIN!");
						System.exit(0);
					} else if (this.getCurrentState().getTurn().equals(StateTablut.Turn.DRAW)) {
						System.out.println("DRAW!");
						System.exit(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		

	}

}
