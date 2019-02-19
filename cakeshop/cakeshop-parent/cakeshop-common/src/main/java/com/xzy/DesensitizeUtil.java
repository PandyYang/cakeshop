package com.xzy;

import org.apache.commons.lang3.StringUtils;
import sun.security.krb5.internal.crypto.Des;

/**
 * @Author: Pandy
 * @Date: 2019/2/19 0:41
 * @Version 1.0
 */
public class DesensitizeUtil {
    /**
     * 只显示第一个汉字，其他隐藏为2个星号<例子：李**>
     *
     * @param fullName
     * @param  index 1 为第index位
     * @return
     */
    public  String nameTool(String fullName,int index) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        String name = StringUtils.left(fullName, index);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }

    /**
     * [身份证号] 110****58，前面保留3位明文，后面保留2位明文
     *
     * @param name
     * @param index 3
     * @param end 2
     * @return
     */
    public  String idenumTool(String name,int index,int end) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        return StringUtils.left(name, index).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(name, end),
                StringUtils.length(name), "*"), "***"));
    }

    /**
     * [固定电话] 后四位，其他隐藏<例子：****1234>
     *
     * @param num
     * @return
     */
    public  String telephoneTool(String num,int index,int end) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.left(num, index).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, end),
                StringUtils.length(num), "*"), "***"));
    }
    /**
     * 邮箱脱敏
     *
     */
    public  String emailTool(String email,int index,int end){
        if (StringUtils.isBlank(email)){
            return "";
        }
        return StringUtils.left(email,index).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(email, end),
                StringUtils.length(email), "*"), "***"));
    }

    //public static void main(String[] args) {
        //DesensitizeUtil.emailTool("906821482@qq.com",4,6);
        //System.out.println(DesensitizeUtil.emailTool("906821482@qq.com",4,6));
        //System.out.println(DesensitizeUtil.nameTool("周杰伦",1));
        //System.out.println(DesensitizeUtil.telephoneTool("11111111111",3,4));
    //}

}
