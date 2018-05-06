import java.util.ArrayList;
import java.util.List;

public class Node {

    int duration;

    List<Node> dependencies;

    // earliest start & finish
    int eStart;
    int eFinish;

    // latest start & finish
    int lStart;
    int lFinish;

    public Node(int dur){
        this.duration = dur;
        this.dependencies = new ArrayList<>();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Node> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Node node) {
        this.dependencies.add(node);
    }

    public int geteStart() {
        return eStart;
    }

    public void seteStart(int eStart) {
        this.eStart = eStart;
    }

    public int geteFinish() {
        return eFinish;
    }

    public void seteFinish(int eFinish) {
        this.eFinish = eFinish;
    }

    public int getlStart() {
        return lStart;
    }

    public void setlStart(int lStart) {
        this.lStart = lStart;
    }

    public int getlFinish() {
        return lFinish;
    }

    public void setlFinish(int lFinish) {
        this.lFinish = lFinish;
    }
}
