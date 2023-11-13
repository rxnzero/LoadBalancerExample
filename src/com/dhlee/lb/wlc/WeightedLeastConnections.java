package com.dhlee.lb.wlc;

import java.util.HashMap;
import java.util.Map;

public class WeightedLeastConnections {

    private static Map<String, Integer> serverWeights = new HashMap<>();
    private static Map<String, Integer> currentConnections = new HashMap<>();

    static {
        // ������ ����ġ ����
        serverWeights.put("Server1", 3);
        serverWeights.put("Server2", 2);
        serverWeights.put("Server3", 1);

        // �ʱ� ���� �� ����
        currentConnections.put("Server1", 0);
        currentConnections.put("Server2", 0);
        currentConnections.put("Server3", 0);
    }

    public static String getServerWithLeastConnections() {
        String selectedServer = null;
        int minConnections = Integer.MAX_VALUE;

        for (String server : serverWeights.keySet()) {
            int connections = currentConnections.get(server);
            int weight = serverWeights.get(server);

            // ����ġ * ���� ���� ���� ���� �� ����ġ ���
            int totalWeight = weight * connections;

            // �ּ� ���� ���� ���� ���� ����
            if (totalWeight < minConnections) {
                minConnections = totalWeight;
                selectedServer = server;
            }
        }

        // ���õ� ������ ���� ���� �� ����
        currentConnections.put(selectedServer, currentConnections.get(selectedServer) + 1);

        return selectedServer;
    }

    public static void main(String[] args) {
        // Ŭ���̾�Ʈ ��û�� ���� �� Weighted Least Connections ������� ���� ����
        for (int i = 0; i < 10; i++) {
            String selectedServer = getServerWithLeastConnections();
            System.out.println("Selected Server: " + selectedServer);
        }
    }
}

