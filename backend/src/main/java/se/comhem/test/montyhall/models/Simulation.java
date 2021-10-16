package se.comhem.test.montyhall.models;

import java.util.Random;

public class Simulation {
    private static final String GOAT = "GOAT";
    private static final String CAR = "CAR";
    private static final int DOORS = 3;

    private String[] doors;
    private int playerChoosesDoor;
    private int hostShowsDoor;
    private boolean playerChangingDoor;
    private Boolean win = null;

    public Simulation(boolean playerChangingDoor) {
        String[] montyHallDoors = {GOAT, GOAT, GOAT};
        Random randomDoor = new Random();

        int carDoor = randomDoor.nextInt(DOORS);
        montyHallDoors[carDoor] = CAR;

        this.doors = montyHallDoors;
        this.playerChoosesDoor = randomDoor.nextInt(DOORS);

        // Randomize until host takes a door that's a GOAT
        do {
            this.hostShowsDoor = randomDoor.nextInt(DOORS);
        }
        while(this.hostShowsDoor == this.playerChoosesDoor || montyHallDoors[this.hostShowsDoor] == CAR );

        this.playerChangingDoor = playerChangingDoor;
    }

    public String[] getDoors() {
        return doors;
    }

    public void setDoors(String[] doors) {
        this.doors = doors;
    }

    public int getPlayerChoosesDoor() {
        return playerChoosesDoor;
    }

    public void setPlayerChoosesDoor(int playerChoosesDoor) {
        this.playerChoosesDoor = playerChoosesDoor;
    }

    public int getHostShowsDoor() {
        return hostShowsDoor;
    }

    public void setHostShowsDoor(int hostShowsDoor) {
        this.hostShowsDoor = hostShowsDoor;
    }

    public boolean isPlayerChangingDoor() {
        return playerChangingDoor;
    }

    public void setPlayerChangingDoor(boolean playerChangingDoor) {
        this.playerChangingDoor = playerChangingDoor;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    /**
     * Only two possible losing scenarios in game
     * 1. Choose right door first but then change door
     * 2. Choose wrong door first and not changing door
     */
    public boolean isWin() {
        if (this.doors[this.playerChoosesDoor] == CAR && this.playerChangingDoor == true) {
            return false;
        }

        if (this.doors[this.playerChoosesDoor] == GOAT && this.playerChangingDoor == false) {
            return false;
        }

        return true;
    }
}
