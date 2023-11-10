package com.dhlee.lb.wrr;

import java.util.ArrayList;
import java.util.List;

public class WeightedRoundRobinExample {

	public static void main(String[] args) {
        // Create servers with weights
        Server server1 = new Server("Server1", 2);
        Server server2 = new Server("Server2", 1);
        Server server3 = new Server("Server3", 3);

        // Create a list of servers
        List<Server> servers = new ArrayList<>();
        servers.add(server1);
        servers.add(server2);
        servers.add(server3);

        // Create a WeightedRoundRobinBalancer with the list of servers
        WeightedRoundRobinBalancer balancer = new WeightedRoundRobinBalancer(servers);

        // Simulate requests
        for (int i = 0; i < 10; i++) {
            Server selectedServer = balancer.getNextServer();
            System.out.println("Request " + (i + 1) + " sent to: " + selectedServer.getName());
        }
    }

}
