package com.dhlee.lb.wrr;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class WeightedRoundRobinBalancer {
    private List<Server> servers;
    private AtomicInteger currentServerIndex;

    public WeightedRoundRobinBalancer(List<Server> servers) {
        this.servers = servers;
        this.currentServerIndex = new AtomicInteger(0);
    }

    public Server getNextServer() {
        int totalWeight = servers.stream().mapToInt(Server::getWeight).sum();
        int currentIndex = currentServerIndex.getAndIncrement() % totalWeight;
        
        for (Server server : servers) {
            currentIndex -= server.getWeight();
            if (currentIndex < 0) {
                return server;
            }
        }

        // Should not reach here
        return null;
    }
}
