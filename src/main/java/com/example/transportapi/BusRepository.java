package com.example.transportapi;

import java.sql.SQLException;
import java.util.List;

public interface BusRepository {
    void addBus(Bus bus) throws SQLException;

    List<Bus> getAllBuses() throws SQLException;

    void updateCapacity(int routeNumber, int capacity) throws SQLException;

    void deleteBus(int routeNumber) throws SQLException;
}
