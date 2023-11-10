package com.dhlee.lb;

import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueLoadBalancer {
	private PriorityQueue<Server> serverQueue;

    public PriorityQueueLoadBalancer(List<Server> servers) {
        serverQueue = new PriorityQueue<>(servers.size(), new Server.ServerComparator());
        serverQueue.addAll(servers);
    }

    // synchronized�� ����Ͽ� ��Ƽ������ ȯ�濡�� �����ϰ� ���� ����
    public synchronized Server selectServer() {
        Server selectedServer = serverQueue.poll();
        selectedServer.incrementRequestCount();
        serverQueue.offer(selectedServer);
        return selectedServer;
    }
}
