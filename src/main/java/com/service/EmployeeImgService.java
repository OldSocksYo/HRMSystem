package com.service;

import com.domain.EmployeeImg;

import java.net.SocketException;
import java.util.List;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/28 8:46
 */
public interface EmployeeImgService {
    /**
     * 添加新的员工图片
     * @param employeeImg
     * @return
     */
    int insertEmployeeImg(EmployeeImg employeeImg);

    /**
     * 删除员工图片
     * @param id
     * @return
     */
    int deleteEmployeeImgById(Integer id);

    /**
     * 根据员工id删除员工图片
     * @param employeeImg
     * @return
     */
    int updateEmployeeImgById(EmployeeImg employeeImg);

    /**
     * 根据员工id查找员工图片
     * @param id
     * @return
     */
    EmployeeImg findEmployeeImgById(Integer id);

    /**
     * 查找所有的员工图片
     * @return
     */
    List<EmployeeImg> findAllEmployeeImg();

    /**
     * 此方法用来更新数据库中的所有图片的地址
     */
    void updateURL(String ip, String port) throws SocketException;
}
