package utils;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/28 23:23
 */
public class StringUtils {
    public static String getTheLastOfUrl(String str){
        String[] split = str.split("/");
        return split[split.length -1];
    }
}
