package graphs;

/*
Graph:

0 ------ 1
| \		 | \
|  \     |  \
|   \    |   2
|    \   |  /
|      \ | /
4 ------ 3

Adjacency Matrix:

[       0  1  2  3  4
	0: [0, 1, 0, 1, 1],
	1: [1, 0, 1, 1, 0],
	2: [0, 1, 0, 1, 0],
	3: [1, 1, 1, 0, 1],
	4: [1, 0, 0, 1, 0]
]

*/
public class UnweightedUndirectedGraph {

    private int[][] adjacencyMatrix;
    private int vertices;

    public UnweightedUndirectedGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public void removeEdge(int i, int j) {
        adjacencyMatrix[i][j] = 0;
        adjacencyMatrix[j][i] = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- ");
        for (int i = 0; i < vertices - 1; i++) {
            sb.append(i).append("\t");
        }
        sb.append("\n");
        for (int i = 0; i < vertices - 1; i++) {
            sb.append(i).append(": ");
            for (int j = 0; j <vertices - 1; j++) {
                sb.append((j == 1 ? 1 : 0));
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UnweightedUndirectedGraph graph = new UnweightedUndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        System.out.println(graph);
    }
}
