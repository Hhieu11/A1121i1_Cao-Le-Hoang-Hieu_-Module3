package model;

public class Room extends Facility {
    private String descriptionOther;


    public Room(int serviceId, String serviceName, Double serviceArea, Long serviceCost, int serviceMaxPeople, int rentTypeId, String descriptionOther) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId);
        this.descriptionOther = descriptionOther;
    }

    public Room() {
    }

    @Override
    public String toString() {
        return "Room{" + super.toString() +
                "descriptionOther='" + descriptionOther + '\'' +
                "} " ;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }
}
