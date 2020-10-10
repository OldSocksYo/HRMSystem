package com.domain;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/18 16:34
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = -68497944707546677L;
    private Integer id;
    private Integer departmentId;
    private String name;
    private String sex;
    private String phoneNumber;
    private String email;

    public Employee() {
    }

    public Employee(Integer id, Integer departmentId, String name, String sex, String phoneNumber, String email) {
        this.id = id;
        this.departmentId = departmentId;
        this.name = name;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
