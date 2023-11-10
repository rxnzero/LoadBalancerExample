package com.dhlee.lb;

import java.util.List;

class LoadBalancer {
    private List<Server> servers;

    public LoadBalancer(List<Server> servers) {
        this.servers = servers;
    }

    public Server selectServer() {
        // 사용량이 가장 적은 서버 선택
        Server selectedServer = servers.get(0);
        for (Server server : servers) {
            if (server.getRequestCount() < selectedServer.getRequestCount()) {
                selectedServer = server;
            }
        }
        selectedServer.incrementRequestCount();
        return selectedServer;
    }
}
