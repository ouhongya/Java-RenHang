package com.renhang.core.apicall.xiaoju.controller;

import com.renhang.common.Utils.GlobalUtils;
import com.renhang.core.apicall.xiaoju.pojo.QueryEnergyUrlVo;
import com.renhang.core.apicall.xiaoju.pojo.QueryOrderInfoVo;
import com.renhang.core.apicall.xiaoju.pojo.QueryOrderListVo;
import com.renhang.core.apicall.xiaoju.pojo.QueryStoreListData;
import com.renhang.core.apicall.xiaoju.service.XiaoJuService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping()
@Log4j2
public class XiaoJuController {

    @Autowired
    XiaoJuService xiaoJuService;

    /**
     * Token查询
     * @return
     */
    @PostMapping("/queryToken")
    public String queryToken() {
        String token = null;
        try {
            token=xiaoJuService.queryToken();
        } catch (Exception e) {
            log.error("拉取token出错啦\n");
            log.error(GlobalUtils.format(new Date()));
           return token;
        }
        return token;
    }
    /**
     * 油站列表查询
     * @return
     */
    @PostMapping("/queryStoreList")
    public QueryStoreListData queryStoreList() {
        QueryStoreListData queryStoreListData = null;
        try {
            queryStoreListData=xiaoJuService.queryStoreList();
        } catch (Exception e) {
            log.error("油站列表查询出错啦\n");
            log.error(GlobalUtils.format(new Date()));
            return queryStoreListData;
        }
        return queryStoreListData;
    }

    /**
     * 油站实时价格批量查询
     * @return
     */
    @PostMapping("/queryStorePrice")
    public QueryStoreListData queryStorePrice() {
        QueryStoreListData queryStoreListData = null;
        try {
            queryStoreListData=xiaoJuService.queryStorePrice();
        } catch (Exception e) {
            log.error("油站实时价格批量查询出错啦\n");
            log.error(GlobalUtils.format(new Date()));
            return queryStoreListData;
        }
        return queryStoreListData;
    }

    /**
     * 订单查询
     * @return
     */
    @PostMapping("/queryOrderInfo")
    public QueryOrderInfoVo queryOrderInfo() {
        QueryOrderInfoVo queryOrderInfo = null;
        try {
            queryOrderInfo=xiaoJuService.queryOrderInfo();
        } catch (Exception e) {
            log.error("订单查询出错啦\n");
            log.error(GlobalUtils.format(new Date()));
            return queryOrderInfo;
        }
        return queryOrderInfo;
    }

    /**
     * 跳转地址查询
     * @return
     */
    @PostMapping("/queryEnergyUrl")
    public QueryEnergyUrlVo queryEnergyUrl() {
        QueryEnergyUrlVo queryEnergyUrl = null;
        try {
            queryEnergyUrl=xiaoJuService.queryEnergyUrl();
        } catch (Exception e) {
            log.error("跳转地址查询出错啦\n");
            log.error(GlobalUtils.format(new Date()));
            return queryEnergyUrl;
        }
        return queryEnergyUrl;
    }

    /**
     * 订单批量查询
     * @return
     */
    @PostMapping("/queryOrderList")
    public QueryOrderListVo queryOrderList() {
        QueryOrderListVo queryOrderList = null;
        try {
            queryOrderList=xiaoJuService.queryOrderList();
        } catch (Exception e) {
            log.error("订单批量查询出错啦\n");
            log.error(GlobalUtils.format(new Date()));
            return queryOrderList;
        }
        return queryOrderList;
    }
}
