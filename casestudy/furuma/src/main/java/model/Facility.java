package model;

public class Facility {
    private int serviceId;
    private String serviceName;
    private Double serviceArea;
    private Long serviceCost;
    private int serviceMaxPeople;
    private int rentTypeId;

    public Facility(int serviceId) {
        this.serviceId = serviceId;
    }

    public Facility() {
    }

    public Facility(int serviceId, String serviceName, Double serviceArea, Long serviceCost, int serviceMaxPeople, int rentTypeId) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return serviceId == facility.serviceId;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", serviceArea=" + serviceArea +
                ", serviceCost=" + serviceCost +
                ", serviceMaxPeople=" + serviceMaxPeople +
                ", rentTypeId=" + rentTypeId +
                '}';
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Double serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Long getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Long serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }
}
