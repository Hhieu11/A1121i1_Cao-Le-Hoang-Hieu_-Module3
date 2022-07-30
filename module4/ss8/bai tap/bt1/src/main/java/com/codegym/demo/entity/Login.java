package com.codegym.demo.entity;

import javax.validation.constraints.*;

public class Login {
//    @Max(value = 45,message = "Do dai toi da la 45")
//    @Min(value = 2,message = "Do dai toi thieu la 2")
//    private String firstName;
//
//
//    @NotEmpty
//    @Max(value = 45,message = "Do dai toi da la 45")
//    @Min(value = 2,message = "Do dai toi thieu la 2")
//    private String lastName;
//
//    private String phoneNumber;
//
//    @Min(value =18 ,message ="Tuoi >=18" )
//    private String Age;
//
//
//    @Email
//    private String email;
//
//    public Login() {
//    }
//
//    public Login(@Max(value = 45, message = "Do dai toi da la 45") @Min(value = 2, message = "Do dai toi thieu la 2") String firstName, @NotEmpty @Max(value = 45, message = "Do dai toi da la 45") @Min(value = 2, message = "Do dai toi thieu la 2") String lastName, String phoneNumber, @Min(value = 18, message = "Tuoi >=18") String age, @Email String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
//        Age = age;
//        this.email = email;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getAge() {
//        return Age;
//    }
//
//    public void setAge(String age) {
//        Age = age;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
@NotBlank
@Size(min = 5, max = 45)
private String firstName;


    @NotBlank
    @Size(min = 5, max = 45 )
    private String lastName;

    private String phoneNumber;

    @Min(value =18 ,message ="Tuoi >=18" )
    private String Age;


    @Email
    private String email;

    public Login() {
    }

    public Login(@NotBlank @Size(min = 5, max = 45) String firstName, @NotBlank @Size(min = 5, max = 45) String lastName, String phoneNumber, @Min(value = 18, message = "Tuoi >=18") String age, @Email String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        Age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
