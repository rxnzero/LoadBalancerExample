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

        // ���� �����忡�� ���ÿ� �ε� �뷱�� ���
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Server selectedServer = loadBalancer.selectServer();
                System.out.println("Selected server: " + selectedServer.getServerName());
            }).start();
        }
    }
}