package model;

public class House extends Facility {
    private String standardRoom;
    private String descriptionOther;
    private int numOfFloors;


    public House(int serviceId) {
        super(serviceId);
    }

    public House() {
    }

    public House(int serviceId, String serviceName, Double serviceArea, Long serviceCost, int serviceMaxPeople, int rentTypeId, String standardRoom, String descriptionOther, int numOfFloors) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId);
        this.standardRoom = standardRoom;
        this.descriptionOther = descriptionOther;
        this.numOfFloors = numOfFloors;
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "standardRoom='" + standardRoom + '\'' +
                ", descriptionOther='" + descriptionOther + '\'' +
                ", numOfFloors=" + numOfFloors +
                "} " ;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }
}
