import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CriticalPathMethod cpm = new CriticalPathMethod();

        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(5);
        Node d = new Node(10);
        Node e = new Node(20);
        Node f = new Node(15);
        Node g = new Node(5);
        Node h = new Node(15);

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
        //cpm.getCriticalPath(a);
        List<Node> path = cpm.getPaths(a, new ArrayList<>(), 0);
        //System.out.println(path.size());

    }

}
