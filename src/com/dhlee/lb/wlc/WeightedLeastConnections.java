package com.dhlee.lb.wlc;

import java.util.HashMap;
import java.util.Map;

public class WeightedLeastConnections {

    private static Map<String, Integer> serverWeights = new HashMap<>();
    private static Map<String, Integer> currentConnections = new HashMap<>();

    static {
        // 서버와 가중치 설정
        serverWeights.put("Server1", 3);
        serverWeights.put("Server2", 2);
        serverWeights.put("Server3", 1);

        // 초기 연결 수 설정
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

            // 가중치 * 현재 연결 수를 통해 총 가중치 계산
            int totalWeight = weight * connections;

            // 최소 연결 수를 갖는 서버 선택
            if (totalWeight < minConnections) {
                minConnections = totalWeight;
                selectedServer = server;
            }
        }

        // 선택된 서버의 현재 연결 수 증가
        currentConnections.put(selectedServer, currentConnections.get(selectedServer) + 1);

        return selectedServer;
    }

    public static void main(String[] args) {
        // 클라이언트 요청이 들어올 때 Weighted Least Connections 방식으로 서버 선택
        for (int i = 0; i < 10; i++) {
            String selectedServer = getServerWithLeastConnections();
            System.out.println("Selected Server: " + selectedServer);
        }
    }
}

