public class GraphAdjMatrix implements Graph{
	
	public int[][] edges;
	public int size;

	public GraphAdjMatrix(int vs){

		size = vs;
		edges = new int[size][size];
	}

	public void addEdge(int v1, int v2){
		
		try {
            
            edges[v1][v2] = 1;
        
        }catch (ArrayIndexOutOfBoundsException indexBounce){
           
            System.out.println("the vertex is not present");
        }
	}

	public int[] neighbors(int v){
		int[] results = new int[size];
		int count = 0;
		try{
			for(int i = 0; i < size; i++){
				if(edges[v][i] == 1){
					results[count] = i;
					count = count+1;
				}
			}
		
		}catch(ArrayIndexOutOfBoundsException indexBounce){
           
            System.out.println("the vertex is not present");
        }
        int[] resultsNew = new int[count];
        for(int j = 0; j < count; j++){

        	resultsNew[j] = results[j];
        }
        return resultsNew;
	}
	public int incidentsEdges(int v){
		int count = 0;
		for(int i = 0; i < size; i++){
			if(edges[i][v] == 1){
				count++;
			}
		}
		return count;
	}

	public void topologicalSort(){
		boolean[] visited = new boolean[size];
		for(int i = 0; i < size; i++){
			if(!visited[i]){
				topologicalSort(i, visited);
			}
		}
	}

	public void topologicalSort(int v, boolean[] visited){

		if(! visited[v]){
			visited[v] = true;
			System.out.print(v);
			int[] nei = neighbors(v);

			for(int i = 0 ; i < nei.length -1; i++){
				topologicalSort(nei[i+1], visited);
			}
		}

	}
}