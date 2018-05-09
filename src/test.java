import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {

    public static void main(String[] args) {
        CriticalPathMethod cpm = new CriticalPathMethod();

        Node a = new Node(10, "a");
        Node b = new Node(20, "b");
        Node c = new Node(5, "c");
        Node d = new Node(10, "d");
        Node e = new Node(20, "e");
        Node f = new Node(15, "f");
        Node g = new Node(5, "g");
        Node h = new Node(15, "h");

        a.setDependencies(f);
        a.setDependencies(b);
        a.setDependencies(h);

        b.setDependencies(c);

        c.setDependencies(g);
        c.setDependencies(d);

        d.setDependencies(e);

        f.setDependencies(g);

        g.setDependencies(e);

        h.setDependencies(e);

        List<Node> nodes = new ArrayList<>(Arrays.asList(a, b, c, d, e, f, g, h));

        for (int i = 0; i < nodes.size(); i++) {
            System.out.println(nodes.get(i).duration);
            for (int j = 0; j < nodes.get(i).dependencies.size(); j++) {
                System.out.println(nodes.get(i).dependencies.get(j));
            }
        }
        System.out.println("-----------------------------------------------------");

        List<List<Node>> path = cpm.getPaths(a, new ArrayList<>());
        cpm.calcEarlyStart(path);
        for (List <Node> paths : path) {
            System.out.println("Paths -----------");
            for (Node node : paths) {
                System.out.println(node.getName());
            }
        }

        System.out.println("CritPath -------------------");
        for (Node node : cpm.getCritPath(path)) {
            System.out.println(node.getName());
        }

        System.out.println("Floats ---------------------");
        for (Node node : nodes) {
            System.out.println(node.calcFloat());
        }
        System.out.println("------------------");


        for (List <Node> paths : path) {
            System.out.println("Calc -----------");
            for (Node node : paths) {
                System.out.println(node.geteStart());
            }
        }


    }

}
