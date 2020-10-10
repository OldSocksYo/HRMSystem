package utils;

import java.net.*;
import java.util.Enumeration;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/29 23:11
 */
public class AddressOperateUtils {
    //获取本机的ip地址（当只有一张网卡时，或者没开热点时使用）
    public static String getLocalIp(){
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return localHost.getHostAddress();
    }

    //获取本机的ip地址，当有多张网卡并且不止一张网卡在工作的时候
    public static String getLocalIpv4() throws SocketException {
        //获取本机所有的网络接口
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
        while(nifs.hasMoreElements()){
            NetworkInterface nif = nifs.nextElement();
            //获取与本接口绑定的ip地址，一般只有一个
            Enumeration<InetAddress> inetAddresses = nif.getInetAddresses();
            while (inetAddresses.hasMoreElements()){
                InetAddress inetAddress = inetAddresses.nextElement();
                if(inetAddress instanceof Inet4Address){//只操作ipv4
                    if("wlan2".equals(nif.getName())){
                        return inetAddress.getHostAddress();
                    }
                    break;
//                    System.out.println("网卡接口名称：" + nif.getName());
//                    System.out.println("网卡接口地址：" + inetAddress.getHostAddress());
//                    System.out.println();
                }
            }
        }
        return null;
    }

    public static String changeAddress(String path, String ip, String port) throws SocketException {

        //还要加一个判断是否是地址的正则表达式

        String[] split = path.split("/");
//        String localIp = getLocalIp();
        String localIpv4 = getLocalIpv4();
        if(ip != null){
            localIpv4 = ip;
        }
        if(port == null){
            port = "8081";
        }
        String newSplit = localIpv4 + ":" + port;

        return path.replace(split[2], newSplit);
    }

}
