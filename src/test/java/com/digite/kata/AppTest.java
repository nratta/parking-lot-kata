package com.digite.kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    ParkingLot parkingLot;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot(6);
    }

    @Test
    public void testInitialisingParkingLot() {
        assertEquals("Parking lot is at full capacity when created", 6, parkingLot.getStatus());
    }

    @Test
    public void testAvailableSlotsDecreaseWhenCarIsParked() {
        parkingLot.park("KA-01-HH-1234", "White");
        assertEquals("Capacity reduces by one when a car is parked", 5, parkingLot.getStatus());
    }

    @Test
    public void testMapsParkedCardToASlot() {
        parkingLot.park("KA-01-HH-1234", "White");
        assertEquals("Gets colour number by Registration", "White",
                     parkingLot.getColourByRegistrationNumber("KA-01-HH-1234"));
    }
}
