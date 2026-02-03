package com.example.transportapi;

import java.util.Objects;

public class Bus extends Transport {

    private int routeNumber;

    public Bus(int routeNumber, int capacity) {
        super(capacity);
        this.routeNumber = routeNumber;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void printInfo() {
        System.out.println("Bus route: " + routeNumber + ", capacity: " + capacity);
    }

    @Override
    public String toString() {
        return "Bus{routeNumber=" + routeNumber + ", capacity=" + capacity + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;
        Bus bus = (Bus) o;
        return routeNumber == bus.routeNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeNumber);
    }
}
