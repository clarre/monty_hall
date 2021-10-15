package se.comhem.test.montyhall.services;

import org.springframework.stereotype.Service;
import se.comhem.test.montyhall.models.Simulation;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulationService {
    public List<Simulation> runSimulation(boolean changeDoor, int times) {
        List<Simulation> simulations = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            Simulation newSimulation = new Simulation(changeDoor);
            newSimulation.setWin(newSimulation.isWin());
            simulations.add(newSimulation);
        }

        return simulations;
    }
}
