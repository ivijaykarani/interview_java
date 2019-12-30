import java.nio.CharBuffer;
import java.util.*;

public class GraphSearch {

    static class Graph {
        public GraphNode[] nodes;
        public ArrayList<Character> vertices;
        public HashMap<Character, ArrayList<Character>> connections;

        public Graph(ArrayList<Character> v, HashMap<Character, ArrayList<Character>> c) {
            vertices = v;
            connections = c;
        }

        public void addVertex(char v) {
            if (connections.containsKey(v)) {
                System.out.println("Vertex: " + v + " already exists");
            }
            else {
                vertices.add(v);
                ArrayList<Character> e = new ArrayList<Character>();
                connections.put(v, e);
                System.out.println("Vertex: " + v + " added");
            }
        }

        public void addEdge(char src, char dst) {
            if (!connections.containsKey(src)) {
                addVertex(src);
            }
            if (!connections.containsKey(dst)) {
                addVertex(dst);
            }
            ArrayList<Character> c = connections.get(src);
            if (!c.contains(dst)) {
                c.add(dst);
                connections.replace(src, c);
            }
            ArrayList<Character> c1 = connections.get(dst);
            if (!c1.contains(src)) {
                c1.add(src);
                connections.replace(dst, c1);
            }
        }

        public void printEdges() {
            connections.forEach((v, c) -> {
                System.out.print("Vertex: " + v + ": ");
                for (int i = 0; i < c.size(); i++) {
                    System.out.print(c.get(i) + " ");
                }
                System.out.println();
            });
        }

        public void BFSTraversal() {
            Queue<Character> queue = new LinkedList<Character>();
            HashSet<Character> visited = new HashSet<Character>();
            for (Character v: vertices) {
                if (!visited.contains(v)) {
                    queue.add(v);
                    do {
                        char qE = queue.remove();
                        visited.add(qE);
                        ArrayList<Character> c = connections.get(qE);
                        for (int i = 0; i < c.size(); i++) {
                            char newE = c.get(i);
                            if (!visited.contains(newE) && !queue.contains(newE)) {
                                queue.add(c.get(i));
                            }
                        }
                    } while (!queue.isEmpty());
                }
            }
        }
    }

    static class GraphNode {
        public String name;
        public GraphNode[] children;
    }

    public static void printEdges(Graph g) {

    }

    public static void main(String[] args) {
        ArrayList<Character> vertices = new ArrayList<Character>();
        HashMap<Character, ArrayList<Character>> connections = new HashMap<Character, ArrayList<Character>>();

        Character[] nodes = { 'A', 'B', 'C', 'D', 'E', 'F' };
        Arrays.stream(nodes).forEach(c-> {vertices.add(c);});
        ArrayList<Character> aConnections = new ArrayList<>();
        aConnections.add('B');
        ArrayList<Character> bConnections = new ArrayList<>();
        bConnections.add('A');
        bConnections.add('C');
        bConnections.add('D');
        ArrayList<Character> cConnections = new ArrayList<>();
        cConnections.add('B');
        cConnections.add('D');
        ArrayList<Character> dConnections = new ArrayList<>();
        dConnections.add('B');
        dConnections.add('C');
        ArrayList<Character> eConnections = new ArrayList<>();
        eConnections.add('F');
        ArrayList<Character> fConnections = new ArrayList<>();
        fConnections.add('E');

        connections.put('A', aConnections);
        connections.put('B', bConnections);
        connections.put('C', cConnections);
        connections.put('D', dConnections);
        connections.put('E', eConnections);
        connections.put('F', fConnections);

        Graph g = new Graph(vertices, connections);
        //g.addVertex('A');
        //g.addVertex('G');
        //g.addEdge('E', 'G');
        g.printEdges();
        g.BFSTraversal();
    }
}
