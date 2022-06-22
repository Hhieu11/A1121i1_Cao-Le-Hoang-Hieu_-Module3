package model;

public class Employee {
    private int Id;
    private  String name;
    private String dateOfBirth;
    private String idCard;
    private String sdt;
    private String email;
    private int educationId;
    private int positionId;
    private long price;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idCard='" + idCard + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", educationId=" + educationId +
                ", positionId=" + positionId +
                ", price=" + price +
                '}';
    }

    public Employee(int id) {
        Id = id;
    }

    public Employee(int id,
                    String name,
                    String dateOfBirth,
                    String idCard,
                    String sdt,
                    String email,
                    int educationId,
                    int positionId,
                    long price) {
        Id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.sdt = sdt;
        this.email = email;
        this.educationId = educationId;
        this.positionId = positionId;
        this.price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Id == employee.Id;
    }

}
