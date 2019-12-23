public class ParkingLot {

    private int parkingLevels = 1;
    private ParkingSlot[][] parkingSlots = null;
    private int freeCarParking = 0;
    private int freeBicycleSlots = 0;
    private int freeBusSlots = 0;

    static class ParkingStatus {
        int levelId;
        int freeCarSlots;
        int freeBicycleSlots;
        int freeBusSlots;
    }

    static enum VehicleType {
        None,
        Bicycle,
        Car,
        Bus
    }

    static enum VehicleParkStatus {
        No_Vehicle,
        Left_Park,
        Right_Park,
        LR_Park
    }

    static class ParkingSlot {
        private VehicleType vehType;
        private VehicleParkStatus parkStatus;

        public ParkingSlot() {
            vehType = VehicleType.None;
            parkStatus = VehicleParkStatus.No_Vehicle;
        }
    }

    static class ParkingLevel {
        private int levelId;
        private int rowCount;
        private int colCount;
    }

    public ParkingLot(int rowCount, int colCount) {
        parkingSlots = new ParkingSlot[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                parkingSlots[i][j] = new ParkingSlot();
            }
        }
    }

    public void vehicleParkChanged(VehicleType vehicleType, int sRowId, int sColId, int eRowId, int eColId, VehicleParkStatus status) {

    }

    public void calculateParkingSpaces() {
        int fCarParking = 0;
        int fBicycleSlots = 0;
        for (int i = 0; i < parkingSlots.length; i++) {
            for (int j = 0; j < parkingSlots[0].length; j++) {
                if (parkingSlots[i][j].parkStatus == VehicleParkStatus.No_Vehicle) {
                    fCarParking++;
                    fBicycleSlots += 2;
                }
                else if (parkingSlots[i][j].parkStatus == VehicleParkStatus.Left_Park ||
                        parkingSlots[i][j].parkStatus == VehicleParkStatus.Right_Park) {
                    fBicycleSlots++;
                }
            }
        }
        freeCarParking = fCarParking;
        freeBicycleSlots = fBicycleSlots;
        freeBusSlots = calculateBusParking();
    }

    private int calculateBusParking() {
        int fBusSlots = 0;
        int possibleBusSlot = 0;
        boolean[][] tmpBusSpots = new boolean[parkingSlots.length][parkingSlots[0].length];
        for (int i = 0; i < parkingSlots.length; i++) {
            for (int j = 0; j < parkingSlots[0].length; j++) {
                if ( (j < parkingSlots[0].length - 2) &&
                        (parkingSlots[i][j].parkStatus == VehicleParkStatus.No_Vehicle) &&
                        (parkingSlots[i][j+1].parkStatus == VehicleParkStatus.No_Vehicle) &&
                        (parkingSlots[i][j+2].parkStatus == VehicleParkStatus.No_Vehicle) &&
                        (!tmpBusSpots[i][j] && !tmpBusSpots[i][j+1] && !tmpBusSpots[i][j+2]) ) {
                    fBusSlots++;
                    tmpBusSpots[i][j] = true;
                    tmpBusSpots[i][j+1] = true;
                    tmpBusSpots[i][j+2] = true;
                }
                else if ( (i < parkingSlots.length - 2) &&
                        (parkingSlots[i][j].parkStatus == VehicleParkStatus.No_Vehicle) &&
                        (parkingSlots[i+1][j].parkStatus == VehicleParkStatus.No_Vehicle) &&
                        (parkingSlots[i+2][j].parkStatus == VehicleParkStatus.No_Vehicle) &&
                        (!tmpBusSpots[i][j] && !tmpBusSpots[i+1][j] && !tmpBusSpots[i+2][j]) ) {
                    fBusSlots++;
                    tmpBusSpots[i][j] = true;
                    tmpBusSpots[i+1][j] = true;
                    tmpBusSpots[i+2][j] = true;
                }
            }
        }
        return fBusSlots;
    }

    public ParkingStatus getParkingStatus() {
        ParkingStatus parkingStatus = new ParkingStatus();
        parkingStatus.freeCarSlots = freeCarParking;
        parkingStatus.freeBicycleSlots = freeBicycleSlots;
        parkingStatus.freeBusSlots = freeBusSlots;

        return parkingStatus;
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5, 10);
        parkingLot.calculateParkingSpaces();
        ParkingStatus parkingStatus = parkingLot.getParkingStatus();
        System.out.println("Car Parking Spaces: " + parkingStatus.freeCarSlots);
        System.out.println("Bicycle Parking Spaces: " + parkingStatus.freeBicycleSlots);
        System.out.println("Bus Parking Spaces: " + parkingStatus.freeBusSlots);
    }
}
