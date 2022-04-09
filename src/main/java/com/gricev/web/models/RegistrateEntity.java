package com.gricev.web.models;

import com.gricev.web.repo.RegistrateEntityRepository;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
public class RegistrateEntity  {

    public RegistrateEntity() {}
    public RegistrateEntity(String firstname, String lastname, String email,
                            String country, String password, long phoneNumber, String sex) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.country = country;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }
    public  RegistrateEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    private Boolean trusted;
//    private UUID userUuid;

    private String firstname;
    private String lastname;
    private String email;
    private String country;
    private String password;

    private long phoneNumber;
    private String sex;

    private String validatacode;
    private Date outdate;

    @Column(name = "validatacode", length = 50)
    public String getValidatacode() {
        return validatacode;
    }

    public void setValidatacode(String validatacode) {
        this.validatacode = validatacode;
    }
    @Column(name = "outdate", length = 50)
    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }
//    public UUID getUserUuid() {
//        return userUuid;
//    }

//    public void setUserUuid(UUID userUuid) {
//        this.userUuid = userUuid;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "phonenumber")
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
