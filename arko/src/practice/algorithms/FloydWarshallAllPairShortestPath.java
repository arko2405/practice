package practice.algorithms;

public class FloydWarshallAllPairShortestPath {
	static int INF = 99999;

	public static void main(String[] args) {
		int graph[][] = { { 0, 5, INF, 10 }, { INF, 0, 3, INF },
				{ INF, INF, 0, 1 }, { INF, INF, INF, 0 } };
		floydWarshell(graph);
	}

	private static void floydWarshell(int[][] graph) {
		int distance[][] = graph;
		for (int k = 0; k < graph.length; k++) {
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph.length; j++) {
					distance[i][j] = Math.min(distance[i][j], distance[i][k]+distance[k][j]);
				}
			}
		}
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(distance[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
}
