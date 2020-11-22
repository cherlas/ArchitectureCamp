import lombok.Data;

import java.util.Map;
import java.util.TreeMap;

@Data
public class Server {
    private TreeMap<Integer, String> nodes = new TreeMap<Integer, String>();

    public void addNode(Node node) {
        nodes.put(node.getHash(), node.getNodeName());
    }

    public String getBalanceNode(String Url) {
        int hash = Utils.getHashCode(Url);
        Map.Entry<Integer, String> subTree = nodes.ceilingEntry(hash);
        subTree = subTree == null ? nodes.firstEntry() : subTree;
        String value = subTree.getValue();
        return value.substring(0, value.indexOf('-'));
    }

    //构建hash环
    public TreeMap<Integer, String> buildHashCycle(TreeMap<Integer, String> treeMap) {
        this.nodes = treeMap;
        return nodes;
    }
}
