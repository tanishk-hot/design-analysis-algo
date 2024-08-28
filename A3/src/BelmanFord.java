import java.util.ArrayList;

public class BelmanFord {
    //First things first, we need an array that maintains the minimum distance as of nwo for every vertex apart from source
    //Then, we need a 2D array that gives cost from one vertex to another.
    //Now, how can we structure the 2D array?

    public static void main(String[] args) {
        belman('A', 6);
    }


    static ArrayList<Cost> input (){
        ArrayList<Cost> edges = new ArrayList<>();

        edges.add(new Cost('A', 'B', 6));
        edges.add(new Cost('A', 'C', 4));
        edges.add(new Cost('A', 'D', 5));
        edges.add(new Cost('D', 'C', -2));
        edges.add(new Cost('C', 'B', -2));
        edges.add(new Cost('D', 'F', -1));
        edges.add(new Cost('B', 'E', -1));
        edges.add(new Cost('C', 'E', 3));
        edges.add(new Cost('E', 'F', 3));

        return edges;
    }

    static ArrayList<Cost> input2 (){
        ArrayList<Cost> edges = new ArrayList<>();

        edges.add(new Cost('A', 'B', 6));
        edges.add(new Cost('A', 'C', 4));
        edges.add(new Cost('A', 'D', 5));
        edges.add(new Cost('D', 'C', -2));
        edges.add(new Cost('C', 'B', -2));
        edges.add(new Cost('D', 'F', -1));
        edges.add(new Cost('B', 'E', -1));
        edges.add(new Cost('C', 'E', 3));
        edges.add(new Cost('E', 'F', 3));

        return edges;
    }
    static void belman(char source, int vertices){

        ArrayList<Cost> edges = input();

        //dist[0] = distance from A to B
        //dist[1] = distance from A to C
        //...
        //dist[4] = distance from A to F
        int[] dist = new int[vertices];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source - 'A'] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            for (Cost edge : edges) {
                int u = edge.start - 'A';
                int v = edge.end - 'A';
                int weight = edge.cost;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }


        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println((char)(i + 'A') + "\t\t" + dist[i]);
        }
    }


    private static class Cost{
        char start;
        char end;
        int cost;

        Cost(char start,char end,int cost){
            this.start = start;
            this.cost = cost;
            this.end = end;
        }
    }
}

