package model;

public class Villa extends Facility {
    private String standardRoom;
    private String descriptionOther;
    private Double poolArea;
    private int numOfFloors;


    public Villa(int serviceId, String serviceName, Double serviceArea, Long serviceCost, int serviceMaxPeople, int rentTypeId, String standardRoom, String descriptionOther, Double poolArea, int numOfFloors) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId);
        this.standardRoom = standardRoom;
        this.descriptionOther = descriptionOther;
        this.poolArea = poolArea;
        this.numOfFloors = numOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "standardRoom='" + standardRoom + '\'' +
                ", descriptionOther='" + descriptionOther + '\'' +
                ", poolArea=" + poolArea +
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

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }
}
