package com.dhlee.lb;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueueLoadBalancerExample {
    public static void main(String[] args) {
    	List<Server> servers = new ArrayList<>();
        servers.add(new Server("Server1", 3));
        servers.add(new Server("Server2", 2));
        servers.add(new Server("Server3", 1));

        PriorityQueueLoadBalancer loadBalancer = new PriorityQueueLoadBalancer(servers);

        // 여러 스레드에서 동시에 로드 밸런서 사용
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Server selectedServer = loadBalancer.selectServer();
                System.out.println("Selected server: " + selectedServer.getServerName());
            }).start();
        }
    }
}