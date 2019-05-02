import java.io.IOException;
import java.net.UnknownHostException;

import giocatori.AIBlack;
import it.unibo.ai.didattica.competition.tablut.client.TablutHumanClient;

public class main {
	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		//String[] array = new String[]{"WHITE"};
		//TablutHumanClient.main(array);
		
		new AIBlack().run();
	}
	
}
