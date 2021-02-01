package com.digite.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class ParkingLot {

    private final int parkingLotCapacity;
    ConcurrentMap<Integer, Car> slots;
    private int currentCapacity;

    public ParkingLot(int intialCapacity) {
        parkingLotCapacity = intialCapacity;
        currentCapacity = parkingLotCapacity;
        slots = new ConcurrentHashMap<>();
    }

    public int getStatus() {
        return this.currentCapacity;
    }

    public void park(String registrationNumber, String colour) {
        int slotNo = 0;
        int allcatedSlotNo  = 0;
        if(slots.size() == 0){
            allcatedSlotNo = 1;
        }
       else {
            for (Map.Entry<Integer, Car> entry : slots.entrySet()) {
                ++slotNo;
                if (!entry.getKey().equals(slotNo)) {
                    allcatedSlotNo = slotNo;
                    break;
                }
                else
                    allcatedSlotNo = slotNo +1;
            }
        }
        this.slots.put(allcatedSlotNo, new Car(registrationNumber, colour));
        this.currentCapacity -= 1;
    }

    public String getColourByRegistrationNumber(String registrationNumber) {
        return slots.entrySet().stream().filter(entry -> registrationNumber.equals(entry.getValue().getRegistrationNumber()))
                .map(val -> val.getValue().getColour())
                .collect(Collectors.joining());
    }

    public void leave(int i) {
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) {
            if(entry.getKey().equals(i) ) {
                slots.remove(i);
                break;
            }
        }
    }

    public int getSlotNumberByRegistrationNumber(String s) {
       int slotNo = 0;
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) {
            if (entry.getValue().getRegistrationNumber().equals(s)) {
                slotNo =  entry.getKey();
            }
        }
        return slotNo;
    }
    public List<String> getRegistrationListByColor(String color) {
        List<String> registrationList = new ArrayList<>();
        for(Map.Entry<Integer, Car> entry : slots.entrySet())
        {    if(color.equalsIgnoreCase(entry.getValue().getColour()))
            registrationList.add(entry.getValue().getRegistrationNumber());
        }
        return  registrationList;
    }
    public List<String> getSlotListByColor(String color) {
        List<String> slotList = new ArrayList<>();
        for(Map.Entry<Integer, Car> entry : slots.entrySet())
        {    if(color.equalsIgnoreCase(entry.getValue().getColour()))
            slotList.add(entry.getValue().getRegistrationNumber());
        }
        return  slotList;
    }
}
