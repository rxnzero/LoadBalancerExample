package com.dhlee.lb;

import java.util.Comparator;

import java.util.Comparator;

// 서버를 나타내는 클래스
class Server {
    private String serverName;
    private int weight;
    private int requestCount;

    public Server(String serverName, int weight) {
        this.serverName = serverName;
        this.weight = weight;
        this.requestCount = 0;
    }

    public String getServerName() {
        return serverName;
    }

    public int getWeight() {
        return weight;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public synchronized void incrementRequestCount() {
        requestCount++;
    }
    
    public static class ServerComparator implements Comparator<Server> {
        @Override
        public int compare(Server s1, Server s2) {
            return Integer.compare(s1.getRequestCount(), s2.getRequestCount());
        }
    }
}