import java.util.ArrayList;
import java.util.List;

public class CriticalPathMethod {


    public int getCriticalPath(Node startNode){
        List<Node> critPath = new ArrayList<>();
        Node currentNode = startNode;
        int longestDurPath = 0;
        for (int i = 0; i < currentNode.getDependencies().size(); i++) {
            if(longestDurPath < getDurationFromPath(currentNode, i)) {
                longestDurPath = getDurationFromPath(currentNode, i);

            }
            System.out.println(getDurationFromPath(currentNode,i));
        }
        return longestDurPath;
    }

    private int getDurationFromPath(Node start, int path){
        Node currentNode = start;
        int totalDuration = start.getDuration();
        while (currentNode.getDependencies().size() > 0){
            if(currentNode.getDependencies().size() == 1){
                currentNode = currentNode.getDependencies().get(0);
                totalDuration += currentNode.getDuration();
            }else {
                currentNode = currentNode.getDependencies().get(path);
                totalDuration += currentNode.getDuration();
            }
        }
        return totalDuration;
    }

    public List<Node> getPaths(Node start, List<Node> list, int path){
        Node cn = start;
        List<Node> nodes = list;
        nodes.add(start);
        while(cn.getDependencies().size() > 0){
            System.out.println(cn.duration);
            if(cn.getDependencies().size() == 1){
                cn = cn.getDependencies().get(0);
            }else {
                for (int i = 0; i < cn.getDependencies().size(); i++) {
                    getPaths(cn.getDependencies().get(i), nodes, i);
                }
                cn = cn.getDependencies().get(path);
            }
            nodes.add(cn);
        }

        return nodes;
    }
}
