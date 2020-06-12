package com.renhang.core.apicall.meituan.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.apicall.meituan.pojo.SecondCashback;
import com.renhang.core.apicall.meituan.pojo.ShareCoupon;
import com.renhang.core.apicall.meituan.pojo.TryApiList;
import com.renhang.core.apicall.meituan.pojo.TryApiListRes;
import com.renhang.core.apicall.meituan.service.MeiTuanService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public TryApiListRes try_api_list(@RequestBody TryApiList adListBean) {
        TryApiListRes advertising = null;
        try {
             advertising = meiTuanService.TryApiList(adListBean);

        }catch (Exception e){
            log.error(e);
            log.error("核验订单数据\n");
            log.error(GlobalUtils.format(new Date()));
        }
        return advertising;
    }


    /**
     *有二级返佣的渠道：（需要对接订单接口，商务给出）
     * @param
     * @return
     */
    @GetMapping("/second_cashback")
    public String try_api_list(@RequestBody SecondCashback secondcashback) {
        String url=null;
        try {
            url = meiTuanService.TryApiSecondCash(secondcashback);
        }catch (Exception e){
            log.error(e);
            log.error("获取广告列表\n");
            log.error(GlobalUtils.format(new Date()));
        }
       return url;
    }


    /**
     *没有二级返佣的渠道：（需要对接订单接口，商务给出）
     * @param
     * @return
     */
    @GetMapping("/share_coupon")
    public String share_coupon(@RequestBody  ShareCoupon sharecoupon) {
        String url=null;
        try {
            url = meiTuanService.TryApiShareCoupon(sharecoupon);
        }catch (Exception e){
            log.error(e);
            log.error("获取广告列表\n");
            log.error(GlobalUtils.format(new Date()));
        }
        return  url;
    }


}
