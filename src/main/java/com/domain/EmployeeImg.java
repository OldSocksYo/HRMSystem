package com.domain;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/28 8:20
 */
public class EmployeeImg {
    private Integer id;
    private String imgUrl;

    public EmployeeImg() {
    }

    public EmployeeImg(Integer id, String imgUrl) {
        this.id = id;
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "employeeImg{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
