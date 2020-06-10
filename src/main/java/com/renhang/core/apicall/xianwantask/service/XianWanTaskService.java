package com.renhang.core.apicall.xianwantask.service;


import com.renhang.core.apicall.xianwantask.pojo.*;


public interface XianWanTaskService {
//    TryApiListRes TryApiList(TryApiList adListBean);
//    TryApiAdInfoRes TryApiAdInfo(TryApiAdInfo TryApiAdInfo);
    LinkTask tryApiAdClick(TryApiAdClick tryApiAdClick);
    SubmitTaskResponse tryApiSubmitTask(TryApiSubmitTask tryapisubmittask);
    SubmitTaskResponse tryApiSubmitTaskList(TryApiSubmitTaskList tryapisubmittasklist);
    SubmitTaskResponse tryApiSubmitRecommend(TryApiAdClick tryapiadclick);
    SubmitTaskScreenshot tryApiSubmitScreenshot(TryApiScreenshot tryapiscreenshot);
    SubmitTaskScreenshot tryApiSubmitScreenshotbase(TryApiScreenshotbase tryapiscreenshotbase);
    SubmitTaskSignature tryApiSubmitSignature(TryApiSignature  tryapisignature);
}
