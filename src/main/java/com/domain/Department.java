package com.domain;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/18 16:37
 */
public class Department implements Serializable {
    private static final long serialVersionUID = -684979447075466776L;
    private Integer id;
    private String name;
    private String address;

    public Department() {
    }

    public Department(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
