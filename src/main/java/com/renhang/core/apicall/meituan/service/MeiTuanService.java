package com.renhang.core.apicall.meituan.service;

import com.renhang.core.apicall.meituan.pojo.SecondCashback;
import com.renhang.core.apicall.meituan.pojo.ShareCoupon;
import com.renhang.core.apicall.meituan.pojo.TryApiList;
import com.renhang.core.apicall.meituan.pojo.TryApiListRes;

import java.net.URISyntaxException;


public interface MeiTuanService {
    TryApiListRes TryApiList(TryApiList adListBean);
    String TryApiSecondCash(SecondCashback secondcashback) throws URISyntaxException;
    String TryApiShareCoupon(ShareCoupon sharecoupon) throws URISyntaxException;

}
