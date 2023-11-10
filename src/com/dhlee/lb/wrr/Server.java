package com.dhlee.lb.wrr;

class Server {
    private String name;
    private int weight;

    public Server(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
