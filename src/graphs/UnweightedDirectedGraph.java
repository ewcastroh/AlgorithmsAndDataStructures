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
	1: [0, 0, 1, 1, 0],
	2: [0, 0, 0, 1, 0],
	3: [0, 0, 0, 0, 1],
	4: [0, 0, 0, 0, 0]
]

*/
public class UnweightedDirectedGraph {

    private int[][] adjacencyMatrix;
    private int vertices;

    public UnweightedDirectedGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
    }

    public void removeEdge(int i, int j) {
        adjacencyMatrix[i][j] = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- ");
        for (int i = 0; i < vertices; i++) {
            sb.append(i).append("\t");
        }
        sb.append("\n");
        for (int i = 0; i < vertices; i++) {
            sb.append(i).append(": ");
            for (int j : adjacencyMatrix[i]) {
                sb.append((j == 1 ? 1 : 0));
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UnweightedDirectedGraph graph = new UnweightedDirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        System.out.println(graph.toString());
    }
}
