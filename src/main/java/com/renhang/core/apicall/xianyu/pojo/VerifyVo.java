package com.renhang.core.apicall.xianyu.pojo;

import lombok.Data;

@Data
public class VerifyVo {
    /**
     * 列表中返回的试玩ID
     */
    private String id;
    /**
     * 英文“,”（逗号）分隔的上传图片名称，最多3张；每张图片名称格式必须如：ssp_api_gaoe_媒体ID_任务ID_时间戳_随机数.[jpg|png|jpeg]， 长度不超过64字节
     */
    private String pics;
    /**
     * 详情中sub_option中有mobiel时，则提交手机号
     */
    private String mobile;
    /**
     * 详情中sub_option中有username时，则提交用户名
     */
    private String userName;
    /**
     * 详情中sub_option中有realname时，则提交用户姓名
     */
    private String realName;
    /**
     * 详情中sub_option中有others时，则提交other_option选项内容
     */
    private String others;
    /**
     * token
     */
    private String token;
}
