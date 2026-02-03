package com.example.transportapi;

import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/buses")
public class BusController {

    private final BusRepository busRepository;

    public BusController() {
        this.busRepository = new BusDAO();
    }

    @GetMapping
    public List<Bus> getAllBuses() throws SQLException {
        return busRepository.getAllBuses();
    }

    @PostMapping
    public String addBus(@RequestBody Bus bus) throws SQLException {
        busRepository.addBus(bus);
        return "Bus added";
    }

    @DeleteMapping("/{routeNumber}")
    public String deleteBus(@PathVariable int routeNumber) throws SQLException {
        busRepository.deleteBus(routeNumber);
        return "Bus deleted";
    }
}
