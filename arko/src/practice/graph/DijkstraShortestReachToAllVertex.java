package practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class DijkstraShortestReachToAllVertex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int q = sc.nextInt();
			while(q-->0){
				int n = sc.nextInt();
				int m = sc.nextInt();
				Integer graph[][] = new Integer[n+1][n+1];
				Integer dist[] = new Integer[n+1];
				Boolean visited[] = new Boolean[n+1];
				for (int i = 1; i < dist.length; i++) {
					dist[i] =  -1;
					visited[i] = false;
				}
				for (int i = 1; i <= m; i++) {
					Integer v1 = sc.nextInt();
					Integer v2 = sc.nextInt();
					Integer val = sc.nextInt();
					if(graph[v1][v2] == null)
						graph[v1][v2] = val;
					else
						graph[v1][v2] = Math.min(graph[v1][v2], val);
					
					graph[v2][v1] = graph[v1][v2];
				}
				Integer src = sc.nextInt();
				dist[src] = 0;
				visited[src] = true;
				Queue<Integer> que = new LinkedList<>();
				que.offer(src);
				while(!que.isEmpty()){
					int size = que.size();
					while(size-->0){
						int temp = que.poll();
						for (int i = 1; i <= n ; i++) {
							if(graph[temp][i] != null){
								if(!visited[i]){
									visited[i] = true;
									dist[i] = dist[temp] + graph[temp][i];
									que.offer(i);
								}
								else{
									if((dist[temp] + graph[temp][i]) < dist[i]){
										dist[i] = dist[temp] + graph[temp][i];
										que.offer(i);
									}
								}
							}
							
						}
					}
				}
				for (int i = 1; i < dist.length; i++) {
					if(dist[i]!=0)
					System.out.print(dist[i] + " ");
				}
				System.out.println();
			}
			
		}
	}
	
}
