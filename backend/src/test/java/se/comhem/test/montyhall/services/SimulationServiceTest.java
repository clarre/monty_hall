package se.comhem.test.montyhall.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.comhem.test.montyhall.models.Simulation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationServiceTest {

    public static final SimulationService simulationService = new SimulationService();

    @Test
    void shouldReturnNumberOfSimulationInstances() {
        int runSimulations = 5;
        List<Simulation> simulations = simulationService.runSimulation(false, runSimulations);

        assertEquals(simulations.size(), runSimulations);
    }
}