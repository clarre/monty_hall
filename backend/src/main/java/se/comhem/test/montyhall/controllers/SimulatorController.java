package se.comhem.test.montyhall.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.comhem.test.montyhall.models.Simulation;
import se.comhem.test.montyhall.services.SimulationService;

import java.util.List;


@RestController
public class SimulatorController {

    private final SimulationService simulationService;

    public SimulatorController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping("/simulate/change/{changeDoor}/times/{numberOfSimulations}")
    public List<Simulation> simulations(@PathVariable boolean changeDoor, @PathVariable int numberOfSimulations) {

        return simulationService.runSimulation(changeDoor, numberOfSimulations);
    }

}
