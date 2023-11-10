package com.dhlee.lb;

import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueLoadBalancer {
	private PriorityQueue<Server> serverQueue;

    public PriorityQueueLoadBalancer(List<Server> servers) {
        serverQueue = new PriorityQueue<>(servers.size(), new Server.ServerComparator());
        serverQueue.addAll(servers);
    }

    // synchronized를 사용하여 멀티스레드 환경에서 안전하게 서버 선택
    public synchronized Server selectServer() {
        Server selectedServer = serverQueue.poll();
        selectedServer.incrementRequestCount();
        serverQueue.offer(selectedServer);
        return selectedServer;
    }
}
