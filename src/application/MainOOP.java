package application;

public class MainOOP {
	public static final int[] turn = {100, 1000, 10000, 100000, 1000000, 2000000};
	public static final int numberOfEntityTypes = 7;
	
	public static void main(String[]args) {
		for(int i = 0; i < turn.length; i++) {
			System.out.println("GENERATE WITH (ENTITIES, FACTS, ARTICLES) = (" + turn[i] + ", " + turn[i]/numberOfEntityTypes + ", " + turn[i]/numberOfEntityTypes + ")");
			Runner runner = new Runner(turn[i]/numberOfEntityTypes);
			runner.run();
		}
		System.out.print("*** PROGRAM FINISHED SUCCEED ****");
	}
}
