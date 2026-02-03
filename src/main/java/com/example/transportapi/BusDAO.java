package com.example.transportapi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO implements BusRepository {

    public void addBus(Bus bus) throws SQLException {
        String sql = "INSERT INTO bus(route_number, capacity) VALUES (?, ?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, bus.getRouteNumber());
        stmt.setInt(2, bus.getCapacity());
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    public List<Bus> getAllBuses() throws SQLException {
        List<Bus> buses = new ArrayList<>();
        String sql = "SELECT route_number, capacity FROM bus";

        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            buses.add(new Bus(
                    rs.getInt("route_number"),
                    rs.getInt("capacity")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return buses;
    }

    public void updateCapacity(int routeNumber, int capacity) throws SQLException {
        String sql = "UPDATE bus SET capacity=? WHERE route_number=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, capacity);
        stmt.setInt(2, routeNumber);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    public void deleteBus(int routeNumber) throws SQLException {
        String sql = "DELETE FROM bus WHERE route_number=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, routeNumber);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}
