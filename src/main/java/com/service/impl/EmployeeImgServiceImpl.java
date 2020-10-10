package com.service.impl;

import com.domain.EmployeeImg;
import com.mapper.EmployeeImgMapper;
import com.service.EmployeeImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.AddressOperateUtils;

import java.net.SocketException;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/28 8:47
 */
@Service("employeeImgService")
public class EmployeeImgServiceImpl implements EmployeeImgService {

    @Autowired
    private EmployeeImgMapper employeeImgMapper;

    @Override
    public int insertEmployeeImg(EmployeeImg employeeImg) {
        return employeeImgMapper.insertEmployeeImg(employeeImg);
    }

    @Override
    public int deleteEmployeeImgById(Integer id) {
        return employeeImgMapper.deleteEmployeeImgById(id);
    }

    @Override
    public int updateEmployeeImgById(EmployeeImg employeeImg) {
        return employeeImgMapper.updateEmployeeImgById(employeeImg);
    }

    @Override
    public EmployeeImg findEmployeeImgById(Integer id) {
        return employeeImgMapper.findEmployeeImgById(id);
    }

    @Override
    public List<EmployeeImg> findAllEmployeeImg() {
        return employeeImgMapper.findAllEmployeeImg();
    }

    @Override
    public void updateURL(String ip, String port) throws SocketException {
        List<EmployeeImg> allEmployeeImg = employeeImgMapper.findAllEmployeeImg();
        for (EmployeeImg employeeImg : allEmployeeImg) {
            String url = employeeImg.getImgUrl();
            String newUrl = AddressOperateUtils.changeAddress(url, ip, port);
            employeeImg.setImgUrl(newUrl);
            System.out.println("newUrl=" + newUrl);
            employeeImgMapper.updateEmployeeImgById(employeeImg);
        }
    }
}
