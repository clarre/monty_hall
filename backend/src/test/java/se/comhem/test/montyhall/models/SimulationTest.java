package se.comhem.test.montyhall.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void ShouldReturnNullIfSetWinIsNotSet() {
        Simulation simulation = new Simulation(true);

        assertNull(simulation.getWin());
    }

    @Test
    void ShouldWinIfWrongDoorChosenAndPlayerChanges() {
        String[] doors = { "GOAT", "GOAT", "CAR"};

        Simulation simulation = new Simulation(true);

        simulation.setDoors(doors);
        simulation.setPlayerChoosesDoor(0);

        assertTrue(simulation.isWin());
    }

    @Test
    void ShouldLoseIfWrongDoorChosenAndPlayerKeepDoor() {
        String[] doors = { "GOAT", "GOAT", "CAR"};

        Simulation simulation = new Simulation(false);

        simulation.setDoors(doors);
        simulation.setPlayerChoosesDoor(0);

        assertFalse(simulation.isWin());
    }

    @Test
    void ShouldLoseIfRightDoorChosenAndPlayerChanges() {
        String[] doors = { "GOAT", "GOAT", "CAR"};

        Simulation simulation = new Simulation(true);

        simulation.setDoors(doors);
        simulation.setPlayerChoosesDoor(2);

        assertFalse(simulation.isWin());
    }

    @Test
    void ShouldWinIfRightDoorChosenAndPlayerKeepDoor() {
        String[] doors = { "GOAT", "GOAT", "CAR"};

        Simulation simulation = new Simulation(false);

        simulation.setDoors(doors);
        simulation.setPlayerChoosesDoor(2);

        assertTrue(simulation.isWin());
    }
}