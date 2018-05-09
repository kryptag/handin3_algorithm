import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CriticalPathMethod {


    public List<List<Node>> getPaths(Node start, List<List<Node>> pths){
        Node cn = start;

        List<List<Node>> paths = pths;

            for(Node node : cn.getDependencies()) {
                List<Node> path = new ArrayList<>();
                path.add(cn);
                getPath(node, path, paths);

            }


        return paths;
    }

    public List<Node> getPath(Node node, List<Node> nodes, List<List<Node>> nodeList){
        List<Node> path = nodes;
        path.add(node);
        if(node.getDependencies().size() == 0){
            nodeList.add(path);
            return path;
        } else if (node.getDependencies().size() == 1) {
            getPath(node.getDependencies().get(0), path, nodeList);
        } else if (node.getDependencies().size() > 1) {
                for (Node n : node.getDependencies()) {
                    List<Node> newList = new ArrayList<>();
                    for (Node no : path) {
                        newList.add(no);
                        if (no.getName().equals(node.getName())){
                            break;
                        }
                    }
                    getPath(n, newList, nodeList);
                }
        }
        return path;
    }


    public List<Node> getCritPath(List<List<Node>> paths){
        int index = 0;
        int longestDuration = 0;

        for (int i = 0; i < paths.size(); i++) {
                int newDuration = 0;
                for (Node node : paths.get(i)) {
                    newDuration += node.getDuration();
                }
                if (newDuration > longestDuration) {
                    longestDuration = newDuration;
                    index = i;
                }
        }

        return paths.get(index);
    }

    public void calcEarlyStart(List<List<Node>> paths) {
        List<Node> critNodes = getCritPath(paths);
        for (int i = 0; i < critNodes.size(); i++) {
            if (i == 0) {
                critNodes.get(i).seteStart(1);
                critNodes.get(i).setlStart(1);
                critNodes.get(i).seteFinish(critNodes.get(i).getDuration());
                critNodes.get(i).setlFinish(critNodes.get(i).getDuration());
            } else {
                critNodes.get(i).seteStart(critNodes.get(i - 1).geteFinish() + 1);
                critNodes.get(i).setlStart(critNodes.get(i - 1).getlFinish() + 1);
                critNodes.get(i).seteFinish(critNodes.get(i - 1).geteFinish() + critNodes.get(i).getDuration());
                critNodes.get(i).setlFinish(critNodes.get(i - 1).getlFinish() + critNodes.get(i).getDuration());
            }
        }

        for (int j = 0; j < paths.size(); j++) {
            for(int i = 1; i < paths.get(j).size(); i++) {
                if(paths.get(j).get(i - 1).geteFinish() + paths.get(j).get(i).getDuration() - 1 > paths.get(j).get(i).geteStart()) {
                   continue;
                }
                paths.get(j).get(i).seteStart(paths.get(j).get(i - 1).geteFinish() + 1);
                paths.get(j).get(i).seteFinish(paths.get(j).get(i - 1).geteFinish() + paths.get(j).get(i).getDuration() - 1);
            }
        }

    }


}
//paths.get(j).get(i).setlStart(paths.get(j).get(i - 1).getlFinish() + 1);
//                paths.get(j).get(i).setlFinish(paths.get(j).get(i - 1).getlFinish() + paths.get(j).get(i).getDuration());