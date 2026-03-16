import java.util.*;

public class ParkingLot {

    String[] spots = new String[10];

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % spots.length;
    }

    public void park(String plate) {

        int index = hash(plate);

        while (spots[index] != null) {
            index = (index + 1) % spots.length;
        }

        spots[index] = plate;
        System.out.println("Parked at spot " + index);
    }

    public void exit(String plate) {
        for (int i = 0; i < spots.length; i++) {
            if (plate.equals(spots[i])) {
                spots[i] = null;
                System.out.println("Vehicle exited");
            }
        }
    }

    public static void main(String[] args) {
        ParkingLot p = new ParkingLot();

        p.park("ABC123");
        p.park("XYZ999");
        p.exit("ABC123");
    }
}