package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.g.a.b.b;
import com.sina.weibo.sdk.WeiboAppManager.WeiboInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.DownloadService;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.NotificationHelper;
import com.sina.weibo.sdk.utils.Utility;
import com.tencent.connect.common.Constants;
import com.xiaomi.account.openauth.h;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.q;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class WbAppInstallActivator {
    private static final String TAG = WbAppInstallActivator.class.getName();
    public static final String WB_APK_FILE_DIR = (Environment.getExternalStorageDirectory() + "/Android/org_share_data/");
    private static WbAppInstallActivator mInstance;
    private boolean isFree = true;
    private String mAppkey;
    private Context mContext;
    private CountDownLatch mCountDownlatch;
    private NotificationInfo mNotificationInfo;

    public class NotificationInfo {
        private String downloadUrl;
        private String notificationContent;
        private int versionCode;

        public NotificationInfo(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(h.P) || jSONObject.has("error_code")) {
                    LogUtil.d(WbAppInstallActivator.TAG, "parse NotificationInfo error !!!");
                    return;
                }
                this.downloadUrl = jSONObject.optString("sdk_url", a.f);
                this.notificationContent = jSONObject.optString("sdk_push", a.f);
                this.versionCode = jSONObject.optInt(q.e);
            } catch (JSONException e) {
                LogUtil.d(WbAppInstallActivator.TAG, "parse NotificationInfo error: " + e.getMessage());
            }
        }

        public String getDownloadUrl() {
            return this.downloadUrl;
        }

        public String getNotificationContent() {
            return this.notificationContent;
        }

        public int getVersionCode() {
            return this.versionCode;
        }

        public boolean isNotificationInfoValid() {
            return !TextUtils.isEmpty(this.notificationContent);
        }

        public void setDownloadUrl(String str) {
            this.downloadUrl = str;
        }

        public void setNotificationContent(String str) {
            this.notificationContent = str;
        }

        public void setVersionCode(int i) {
            this.versionCode = i;
        }
    }

    private WbAppInstallActivator(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.mAppkey = str;
    }

    private static boolean checkApkSign(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (packageInfo.signatures == null) {
            return VERSION.SDK_INT < 11;
        } else {
            Object obj = a.f;
            for (Signature toByteArray : packageInfo.signatures) {
                byte[] toByteArray2 = toByteArray.toByteArray();
                if (toByteArray2 != null) {
                    obj = MD5.hexdigest(toByteArray2);
                }
            }
            return WBConstants.WEIBO_SIGN.equals(obj);
        }
    }

    private static boolean checkPackageName(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        return "com.sina.weibo".equals(str) || "com.sina.weibog3".equals(str);
    }

    public static synchronized WbAppInstallActivator getInstance(Context context, String str) {
        WbAppInstallActivator wbAppInstallActivator;
        synchronized (WbAppInstallActivator.class) {
            if (mInstance == null) {
                mInstance = new WbAppInstallActivator(context, str);
            }
            wbAppInstallActivator = mInstance;
        }
        return wbAppInstallActivator;
    }

    private static boolean isWeiboApk(PackageInfo packageInfo) {
        return checkPackageName(packageInfo) && checkApkSign(packageInfo);
    }

    private void loadNotificationInfo() {
        requestNotificationInfo(this.mContext, this.mAppkey, new RequestListener() {
            public void onComplete(String str) {
                WbAppInstallActivator.this.mNotificationInfo = new NotificationInfo(str);
                WbAppInstallActivator.this.mCountDownlatch.countDown();
            }

            public void onWeiboException(WeiboException weiboException) {
                LogUtil.d(WbAppInstallActivator.TAG, "requestNotificationInfo WeiboException Msg : " + weiboException.getMessage());
                WbAppInstallActivator.this.mCountDownlatch.countDown();
            }
        });
    }

    private static void requestNotificationInfo(Context context, String str, RequestListener requestListener) {
        String str2 = "http://api.weibo.cn/2/client/common_config";
        str2 = context.getPackageName();
        String sign = Utility.getSign(context, str2);
        WeiboParameters weiboParameters = new WeiboParameters(str);
        weiboParameters.put(b.f, str);
        weiboParameters.put(ParamKey.PACKAGENAME, str2);
        weiboParameters.put(WBConstants.SSO_KEY_HASH, sign);
        new AsyncWeiboRunner(context).requestAsync("http://api.weibo.cn/2/client/common_config", weiboParameters, Constants.HTTP_GET, requestListener);
    }

    private static void showNotification(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            NotificationHelper.showNotification(context, str, str2);
        }
    }

    private static void startDownloadService(Context context, String str, String str2) {
        Intent intent = new Intent(context, DownloadService.class);
        Bundle bundle = new Bundle();
        bundle.putString(DownloadService.EXTRA_NOTIFICATION_CONTENT, str);
        bundle.putString(DownloadService.EXTRA_DOWNLOAD_URL, str2);
        intent.putExtras(bundle);
        context.startService(intent);
    }

    private static Pair<Integer, File> walkDir(Context context, String str) {
        Object obj = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        int length = listFiles.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            File file2 = listFiles[i];
            String name = file2.getName();
            if (file2.isFile() && name.endsWith(".apk")) {
                PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file2.getAbsolutePath(), 64);
                if (!isWeiboApk(packageArchiveInfo)) {
                    i3 = i2;
                } else if (packageArchiveInfo.versionCode > i2) {
                    File file3 = file2;
                    i3 = packageArchiveInfo.versionCode;
                    File file4 = file3;
                }
                i++;
                i2 = i3;
            }
            i3 = i2;
            i++;
            i2 = i3;
        }
        return new Pair(Integer.valueOf(i2), obj);
    }

    public void activateWeiboInstall() {
        WeiboInfo weiboInfo = WeiboAppManager.getInstance(this.mContext).getWeiboInfo();
        boolean z = weiboInfo == null || !weiboInfo.isLegal();
        if (z && this.isFree) {
            this.isFree = false;
            this.mCountDownlatch = new CountDownLatch(1);
            loadNotificationInfo();
            final String str = WB_APK_FILE_DIR;
            new Thread(new Runnable() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                    r6 = this;
                    r5 = 1;
                    r0 = com.sina.weibo.sdk.WbAppInstallActivator.this;
                    r0 = r0.mContext;
                    r1 = r0;
                    r1 = com.sina.weibo.sdk.WbAppInstallActivator.walkDir(r0, r1);
                    r0 = com.sina.weibo.sdk.WbAppInstallActivator.this;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = r0.mCountDownlatch;	 Catch:{ InterruptedException -> 0x008b }
                    r0.await();	 Catch:{ InterruptedException -> 0x008b }
                    r0 = com.sina.weibo.sdk.WbAppInstallActivator.this;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = r0.mNotificationInfo;	 Catch:{ InterruptedException -> 0x008b }
                    if (r0 == 0) goto L_0x0069;
                L_0x001e:
                    r0 = com.sina.weibo.sdk.WbAppInstallActivator.this;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = r0.mNotificationInfo;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = r0.isNotificationInfoValid();	 Catch:{ InterruptedException -> 0x008b }
                    if (r0 == 0) goto L_0x0069;
                L_0x002a:
                    r0 = com.sina.weibo.sdk.WbAppInstallActivator.this;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = r0.mNotificationInfo;	 Catch:{ InterruptedException -> 0x008b }
                    r2 = r0.downloadUrl;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = com.sina.weibo.sdk.WbAppInstallActivator.this;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = r0.mNotificationInfo;	 Catch:{ InterruptedException -> 0x008b }
                    r3 = r0.notificationContent;	 Catch:{ InterruptedException -> 0x008b }
                    if (r1 == 0) goto L_0x006f;
                L_0x0040:
                    r0 = r1.second;	 Catch:{ InterruptedException -> 0x008b }
                    if (r0 == 0) goto L_0x006f;
                L_0x0044:
                    r0 = r1.first;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = (java.lang.Integer) r0;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = r0.intValue();	 Catch:{ InterruptedException -> 0x008b }
                    r4 = com.sina.weibo.sdk.WbAppInstallActivator.this;	 Catch:{ InterruptedException -> 0x008b }
                    r4 = r4.mNotificationInfo;	 Catch:{ InterruptedException -> 0x008b }
                    r4 = r4.versionCode;	 Catch:{ InterruptedException -> 0x008b }
                    if (r0 < r4) goto L_0x006f;
                L_0x0058:
                    r0 = com.sina.weibo.sdk.WbAppInstallActivator.this;	 Catch:{ InterruptedException -> 0x008b }
                    r2 = r0.mContext;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = r1.second;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = (java.io.File) r0;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = r0.getAbsolutePath();	 Catch:{ InterruptedException -> 0x008b }
                    com.sina.weibo.sdk.WbAppInstallActivator.showNotification(r2, r3, r0);	 Catch:{ InterruptedException -> 0x008b }
                L_0x0069:
                    r0 = com.sina.weibo.sdk.WbAppInstallActivator.this;
                    r0.isFree = r5;
                L_0x006e:
                    return;
                L_0x006f:
                    r0 = com.sina.weibo.sdk.WbAppInstallActivator.this;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = r0.mContext;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = com.sina.weibo.sdk.utils.NetworkHelper.isWifiValid(r0);	 Catch:{ InterruptedException -> 0x008b }
                    if (r0 == 0) goto L_0x0069;
                L_0x007b:
                    r0 = android.text.TextUtils.isEmpty(r2);	 Catch:{ InterruptedException -> 0x008b }
                    if (r0 != 0) goto L_0x0069;
                L_0x0081:
                    r0 = com.sina.weibo.sdk.WbAppInstallActivator.this;	 Catch:{ InterruptedException -> 0x008b }
                    r0 = r0.mContext;	 Catch:{ InterruptedException -> 0x008b }
                    com.sina.weibo.sdk.WbAppInstallActivator.startDownloadService(r0, r3, r2);	 Catch:{ InterruptedException -> 0x008b }
                    goto L_0x0069;
                L_0x008b:
                    r0 = move-exception;
                    r0.printStackTrace();	 Catch:{ all -> 0x0095 }
                    r0 = com.sina.weibo.sdk.WbAppInstallActivator.this;
                    r0.isFree = r5;
                    goto L_0x006e;
                L_0x0095:
                    r0 = move-exception;
                    r1 = com.sina.weibo.sdk.WbAppInstallActivator.this;
                    r1.isFree = r5;
                    throw r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.WbAppInstallActivator.1.run():void");
                }
            }).start();
        }
    }
}
