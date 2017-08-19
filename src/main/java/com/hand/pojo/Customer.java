package com.hand.pojo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by 铭刻 on 2017/8/15.
 */
public class Customer {


    /**
     * customer_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
     store_id TINYINT UNSIGNED NOT NULL,
     first_name VARCHAR(45) NOT NULL,
     last_name VARCHAR(45) NOT NULL,
     email VARCHAR(50) DEFAULT NULL,
     address_id SMALLINT UNSIGNED NOT NULL,
     active BOOLEAN NOT NULL DEFAULT TRUE,
     create_date DATETIME NOT NULL,
     last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     */
    private short customerId;
    private String firstName;
    private String lastName;

    @NotEmpty(message = "邮件不能为空")
    @Email(message = "请输入正确的邮箱")
    private String email;
    private String address;
    private boolean active;
    private Date createDate;
    private Date lastUpdate;

    public short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(short customerId) {
        this.customerId = customerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", addressId=" + address +
                ", active=" + active +
                ", createDate=" + createDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
