package com.dhlee.lb;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancerExample {
    public static void main(String[] args) {
        // ���� ����� ����
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("Server1", 3));
        servers.add(new Server("Server2", 2));
        servers.add(new Server("Server3", 1));

        // �ε� �뷱���� ����
        LoadBalancer loadBalancer = new LoadBalancer(servers);

        // �ε� �뷱�̵� ���� ����
        for (int i = 0; i < 10; i++) {
            Server selectedServer = loadBalancer.selectServer();
            System.out.println("Selected server: " + selectedServer.getServerName());
        }
    }
}