package com.dhlee.lb;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancerExample {
    public static void main(String[] args) {
        // 서버 목록을 생성
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("Server1", 3));
        servers.add(new Server("Server2", 2));
        servers.add(new Server("Server3", 1));

        // 로드 밸런서를 생성
        LoadBalancer loadBalancer = new LoadBalancer(servers);

        // 로드 밸런싱된 서버 선택
        for (int i = 0; i < 10; i++) {
            Server selectedServer = loadBalancer.selectServer();
            System.out.println("Selected server: " + selectedServer.getServerName());
        }
    }
}