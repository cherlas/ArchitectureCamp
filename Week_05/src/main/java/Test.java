import java.util.*;

public class Test {
    private static final int SERVER_COUNT = 10;
    private static final int VIRTUAL_NODE_PER_SERVER = 150;

    private static final int REQUEST_COUNT = 1000000;

    private static final Server server = new Server();
    private static final List<String> servers = new ArrayList<>(SERVER_COUNT);

    public static void main(String[] args) {
        init();
        Map<String, String> requestRecord = new HashMap<>();
        String[] ipAddresses = Utils.generateIpAddresses(REQUEST_COUNT);
        for (int i = 0; i < REQUEST_COUNT; i++) {
            String serverIp = server.getBalanceNode(ipAddresses[i]);
            requestRecord.put(ipAddresses[i], serverIp);
        }

        System.out.println(Utils.analysis(requestRecord));
    }

    private static void init() {
        for (int i = 0; i < SERVER_COUNT; i++) {
            servers.add("127.0.0." + i);
        }

        server.buildHashCycle(new TreeMap<>());
        servers.forEach(s -> {
            for (int i = 0; i < VIRTUAL_NODE_PER_SERVER; i++) {
                String virtualNodeName = s + "-" + i;
                server.addNode(new Node(virtualNodeName));
            }
        });
    }
}
