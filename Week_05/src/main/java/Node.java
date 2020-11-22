import lombok.Data;

@Data
public class Node {
    Integer hash;
    String nodeName;

    public Node(String nodeName) {
        this.hash = Utils.getHashCode(nodeName);
        this.nodeName = nodeName;
    }
}
