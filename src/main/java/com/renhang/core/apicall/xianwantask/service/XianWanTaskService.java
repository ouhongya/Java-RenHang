package com.renhang.core.apicall.xianwantask.service;


import com.renhang.core.apicall.xianwantask.pojo.TryApiAdClick.TryApiAdClick;
import com.renhang.core.apicall.xianwantask.pojo.TryApiAdClick.TryApiAdClickRes;
import com.renhang.core.apicall.xianwantask.pojo.TryApiAdInfo;
import com.renhang.core.apicall.xianwantask.pojo.TryApiAdInfoRes.*;
import com.renhang.core.apicall.xianwantask.pojo.TryApiList;
import com.renhang.core.apicall.xianwantask.pojo.TryApiListRes.TryApiListRes;

public interface XianWanTaskService {
    TryApiListRes TryApiList(TryApiList adListBean);
    TryApiAdInfoRes TryApiAdInfo(TryApiAdInfo TryApiAdInfo);
    LinkTask tryApiAdClick(TryApiAdClick tryApiAdClick);
    SubmitTaskResponse tryApiSubmitTask(TryApiSubmitTask tryapisubmittask);
    SubmitTaskResponse tryApiSubmitTaskList(TryApiSubmitTaskList tryapisubmittasklist);
    SubmitTaskResponse tryApiSubmitRecommend(TryApiAdClick tryapiadclick);
    SubmitTaskScreenshot tryApiSubmitScreenshot(TryApiScreenshot tryapiscreenshot);
    SubmitTaskScreenshot tryApiSubmitScreenshotbase(TryApiScreenshotbase tryapiscreenshotbase);
    SubmitTaskSignature tryApiSubmitSignature(TryApiSignature  tryapisignature);
}
