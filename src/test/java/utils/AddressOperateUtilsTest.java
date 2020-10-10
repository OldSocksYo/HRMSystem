package utils;

import org.junit.Test;

import java.net.SocketException;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/30 9:09
 */
public class AddressOperateUtilsTest {

    @Test
    public void changeAddress() throws SocketException {
        String s = AddressOperateUtils.changeAddress("http://172.18.25.77:8081/HRM/", null, null);
        System.out.println(s);
    }

    @Test
    public void getLocalIp() {
        AddressOperateUtils.getLocalIp();
    }

    @Test
    public void getAllIp() throws SocketException {
        AddressOperateUtils.getLocalIpv4();
    }
}