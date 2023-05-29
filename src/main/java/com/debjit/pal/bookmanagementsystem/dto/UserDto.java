package com.debjit.pal.bookmanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserDto {

    private String userName;
    @Email(message = "Please enter a valid email address")
    private String userEmail;
    @Size(min = 10, max = 10, message = "Please enter a valid phone number")
    private String userPhone;

    public UserDto() {
        super();
    }

    public UserDto(String userName, @Email(message = "Please enter a valid email address") String userEmail,
            @Size(min = 10, max = 10, message = "Please enter a valid phone number") String userPhone) {
        super();
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "UserDto [userName=" + userName + ", userEmail=" + userEmail + ", userPhone=" + userPhone + "]";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

}
