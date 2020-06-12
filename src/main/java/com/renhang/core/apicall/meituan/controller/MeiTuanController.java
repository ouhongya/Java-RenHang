package com.renhang.core.apicall.meituan.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.apicall.meituan.pojo.SecondCashback;
import com.renhang.core.apicall.meituan.pojo.TryApiList;
import com.renhang.core.apicall.meituan.pojo.TryApiListRes;
import com.renhang.core.apicall.meituan.service.MeiTuanService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/verify/item")
@Log4j2
public class MeiTuanController {


    @Autowired
    MeiTuanService meiTuanService;

    /**
     * 核验订单数据
     * @param adListBean
     * @return
     */
    @GetMapping("/try_api_list")
    public TryApiListRes try_api_list(TryApiList adListBean) {
        TryApiListRes advertising = null;
        try {
             advertising = meiTuanService.TryApiList(adListBean);
            return advertising;
        }catch (Exception e){
            log.error(e);
            log.error("获取广告列表\n");
            log.error(GlobalUtils.format(new Date()));
            return advertising;
        }
    }



}
