package com.digite.kata;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParkingLot {

    private final int parkingLotCapacity;
    private int currentCapacity;
    Map<Integer, Car> slots;

    public ParkingLot(int intialCapacity) {
        parkingLotCapacity = intialCapacity;
        currentCapacity = parkingLotCapacity;
        slots = new HashMap<>();
    }

    public int getStatus() {
        return this.currentCapacity;
    }

    public void park(String registrationNumber, String colour) {
        this.slots.put(1, new Car(registrationNumber, colour));
        this.currentCapacity -= 1;
    }

    public String getColourByRegistrationNumber(String registrationNumber) {
        Iterator slotsIterator = slots.entrySet().iterator();

        while (slotsIterator.hasNext()) {
            Car car = slots.get(slotsIterator.next());
            if (car.getRegistrationNumber().equals(registrationNumber))
                return car.getColour();
        }
        return null;
    }
}
