package com.renhang.core.apicall.xianwan.pojo.TryApiAdInfoRes;

import lombok.Data;

@Data
public class ButInfoRes {
    /**
     * 是否允许存在本地APP 0:否（如果存在 提示：请先卸载本地APP） 1：是
     */
    private Integer isLocalAPP;
    /**
     * 是否显示按钮 0:否【APP不做任何判断】 1：是
     */
    private Integer showBut;
    /**
     *	按钮对象
     */
    private String butName;

}
