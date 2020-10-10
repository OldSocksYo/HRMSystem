package utils;


import java.io.File;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/28 17:38
 */
public class DeleteFileUtils {

    /**
     * 判断文件是否存在
     * @param deleteFilePath
     * @return
     */
    public static boolean isFileExist(String deleteFilePath){
        File file = new File(deleteFilePath);
        return file.exists();
    }

    /**
     * 删除文件
     * @param deleteFilePath
     * @return
     */
    public static boolean deleteFile(String deleteFilePath){
        System.out.println("deleteFilePath=" + deleteFilePath);
        boolean flag = false;
        File file = new File(deleteFilePath);
        if(file.exists() && file.isFile()){
            flag = file.delete();
            System.out.println("删除服务器照片是否成功:" + flag);
        }
        return flag;
    }
}
