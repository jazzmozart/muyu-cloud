package com.muyus.muyucloud.commons.ali;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.Random;


/**
 * Message
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/12
 */
public class Message {
    static Random random = new Random();
    static final String product = "Dysmsapi";
    static final String domain = "dysmsapi.aliyuncs.com";
    static final String accessKeyId = "LTAIOL8cFmKvDULz";
    static final String accessKeySecret = "N2jVwq8LquuRAXzLtdZaIETtbCAUfK";

    /**
     *
     * 四位数验证码
     *
     * @param phone
     */
    public static String sendCode(String phone) throws ClientException {
        String code = null;
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        // 初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("木渔");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_126265024");
        code = random.ints(1000, 10000).findFirst().getAsInt()+"";
        request.setTemplateParam("{\"code\":"+code+"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            //请求成功
            return code;
        } else {
            throw new ClientException("验证码发送失败");
        }
    }

    public static void main(String[] args) {

        try {
            Message.sendCode("13522861483");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
