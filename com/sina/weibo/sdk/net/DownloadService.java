package com.sina.weibo.sdk.net;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbAppInstallActivator;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NotificationHelper;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import java.io.File;

public class DownloadService extends IntentService {
    private static final String APK_SAVE_DIR = WbAppInstallActivator.WB_APK_FILE_DIR;
    public static final String EXTRA_DOWNLOAD_URL = "download_url";
    public static final String EXTRA_NOTIFICATION_CONTENT = "notification_content";
    private static final String TAG = DownloadService.class.getCanonicalName();

    public DownloadService() {
        super(TAG);
    }

    private static String generateSaveFileName(String str) {
        String str2 = a.f;
        int lastIndexOf = str.lastIndexOf("/");
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1, str.length()) : str2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            stopSelf();
            return;
        }
        Object string = extras.getString(EXTRA_DOWNLOAD_URL);
        String string2 = extras.getString(EXTRA_NOTIFICATION_CONTENT);
        LogUtil.e(TAG, "onHandleIntent downLoadUrl:" + string + "!!!!!");
        if (TextUtils.isEmpty(string)) {
            LogUtil.e(TAG, "downloadurl is null");
            stopSelf();
            return;
        }
        String str = a.f;
        try {
            String openRedirectUrl4LocationUri = HttpManager.openRedirectUrl4LocationUri(getApplicationContext(), string, Constants.HTTP_GET, new WeiboParameters(a.f));
            String generateSaveFileName = generateSaveFileName(openRedirectUrl4LocationUri);
            if (TextUtils.isEmpty(generateSaveFileName) || !generateSaveFileName.endsWith(".apk")) {
                LogUtil.e(TAG, "redirectDownloadUrl is illeagle");
                stopSelf();
                return;
            }
            str = HttpManager.downloadFile(getApplicationContext(), openRedirectUrl4LocationUri, APK_SAVE_DIR, generateSaveFileName);
            if (TextUtils.isEmpty(str)) {
                LogUtil.e(TAG, "download failed!");
            } else if (new File(str).exists()) {
                LogUtil.e(TAG, "download successed!");
                NotificationHelper.showNotification(getApplicationContext(), string2, str);
            }
        } catch (WeiboException e) {
            e.printStackTrace();
        }
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
