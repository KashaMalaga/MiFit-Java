package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.support.v4.g.c;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.g.a.b.b;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.tencent.connect.common.Constants;
import com.xiaomi.account.openauth.h;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.t;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

public class AidTask {
    private static final String AID_FILE_NAME = "weibo_sdk_aid";
    private static final String TAG = "AidTask";
    private static final int VERSION = 1;
    public static final int WHAT_LOAD_AID_API_ERR = 1002;
    public static final int WHAT_LOAD_AID_IO_ERR = 1003;
    public static final int WHAT_LOAD_AID_SUC = 1001;
    private static AidTask sInstance;
    private String mAppKey;
    private Context mContext;
    private volatile ReentrantLock mTaskLock = new ReentrantLock(true);

    public final class AidInfo {
        private String mAid;
        private String mSubCookie;

        public static AidInfo parseJson(String str) {
            AidInfo aidInfo = new AidInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(h.P) || jSONObject.has("error_code")) {
                    LogUtil.d(AidTask.TAG, "loadAidFromNet has error !!!");
                    throw new WeiboException("loadAidFromNet has error !!!");
                }
                aidInfo.mAid = jSONObject.optString(WBConstants.AUTH_PARAMS_AID, a.f);
                aidInfo.mSubCookie = jSONObject.optString("sub", a.f);
                return aidInfo;
            } catch (JSONException e) {
                LogUtil.d(AidTask.TAG, "loadAidFromNet JSONException Msg : " + e.getMessage());
                throw new WeiboException("loadAidFromNet has error !!!");
            }
        }

        public String getAid() {
            return this.mAid;
        }

        public String getSubCookie() {
            return this.mSubCookie;
        }
    }

    private AidTask(Context context) {
        this.mContext = context.getApplicationContext();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < AidTask.VERSION; i += AidTask.VERSION) {
                    try {
                        AidTask.this.getAidInfoFile(i).delete();
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }

    private synchronized void cacheAidInfo(String str) {
        Throwable th;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            FileOutputStream fileOutputStream2;
            try {
                fileOutputStream2 = new FileOutputStream(getAidInfoFile(VERSION));
                try {
                    fileOutputStream2.write(str.getBytes());
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    fileOutputStream = fileOutputStream2;
                    th = th3;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileOutputStream2 = null;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return;
            } catch (Throwable th4) {
                th = th4;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
        return;
    }

    private String encryptRsa(String str, String str2) {
        Throwable th;
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(VERSION, getPublicKey(str2));
        byte[] bytes = str.getBytes(com.d.a.a.h.DEFAULT_CHARSET);
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while (true) {
                int splite = splite(bytes, i, 117);
                if (splite == -1) {
                    break;
                }
                try {
                    byte[] doFinal = instance.doFinal(bytes, i, splite);
                    byteArrayOutputStream.write(doFinal);
                    LogUtil.d(TAG, "encryptRsa offset = " + i + "     len = " + splite + "     enBytes len = " + doFinal.length);
                    i += splite;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            byteArrayOutputStream.flush();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            LogUtil.d(TAG, "encryptRsa total enBytes len = " + toByteArray.length);
            toByteArray = Base64.encodebyte(toByteArray);
            LogUtil.d(TAG, "encryptRsa total base64byte len = " + toByteArray.length);
            String str3 = "01";
            String str4 = "01" + new String(toByteArray, com.d.a.a.h.DEFAULT_CHARSET);
            LogUtil.d(TAG, "encryptRsa total base64string : " + str4);
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
            return str4;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            }
            throw th;
        }
    }

    private String genMfpString() {
        JSONObject jSONObject = new JSONObject();
        try {
            CharSequence os = getOS();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_TO_TYPE_QQ_GROUP, os);
            }
            os = getImei();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_SSO_LOGIN, os);
            }
            os = getMeid();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP, os);
            }
            os = getImsi();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_TO_TYPE_QZONE, os);
            }
            os = getMac();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_SHARE_TYPE_TEXT, os);
            }
            os = getIccid();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_SHARE_TYPE_INFO, os);
            }
            os = getSerialNo();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("7", os);
            }
            os = getAndroidId();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, os);
            }
            os = getCpu();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, os);
            }
            os = getModel();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, os);
            }
            os = getSdSize();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, os);
            }
            os = getResolution();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, os);
            }
            os = getSsid();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, os);
            }
            os = getDeviceName();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_BIND_GROUP, os);
            }
            os = getConnectType();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, os);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return a.f;
        }
    }

    private File getAidInfoFile(int i) {
        return new File(this.mContext.getFilesDir(), new StringBuilder(AID_FILE_NAME).append(i).toString());
    }

    private String getAndroidId() {
        try {
            return Secure.getString(this.mContext.getContentResolver(), "android_id");
        } catch (Exception e) {
            return a.f;
        }
    }

    private String getConnectType() {
        String str = "none";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case VERSION /*1*/:
                        case kankan.wheel.widget.a.k /*2*/:
                        case kankan.wheel.widget.a.aQ /*4*/:
                        case kankan.wheel.widget.a.bc /*7*/:
                        case kankan.wheel.widget.a.aW /*11*/:
                            return "2G";
                        case kankan.wheel.widget.a.l /*3*/:
                        case kankan.wheel.widget.a.X /*5*/:
                        case kankan.wheel.widget.a.bt /*6*/:
                        case kankan.wheel.widget.a.ba /*8*/:
                        case kankan.wheel.widget.a.bo /*9*/:
                        case kankan.wheel.widget.a.bd /*10*/:
                        case kankan.wheel.widget.a.be /*12*/:
                        case t.WeightView_wv_tips /*14*/:
                        case kankan.wheel.widget.a.aV /*15*/:
                            return "3G";
                        case t.WeightView_wv_bmi_size /*13*/:
                            return "4G";
                        default:
                            return "none";
                    }
                } else if (activeNetworkInfo.getType() == VERSION) {
                    return "wifi";
                }
            }
            return str;
        } catch (Exception e) {
            return str;
        }
    }

    private String getCpu() {
        try {
            return Build.CPU_ABI;
        } catch (Exception e) {
            return a.f;
        }
    }

    private String getDeviceName() {
        try {
            return Build.BRAND;
        } catch (Exception e) {
            return a.f;
        }
    }

    private String getIccid() {
        try {
            return ((TelephonyManager) this.mContext.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception e) {
            return a.f;
        }
    }

    private String getImei() {
        try {
            return ((TelephonyManager) this.mContext.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return a.f;
        }
    }

    private String getImsi() {
        try {
            return ((TelephonyManager) this.mContext.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            return a.f;
        }
    }

    public static synchronized AidTask getInstance(Context context) {
        AidTask aidTask;
        synchronized (AidTask.class) {
            if (sInstance == null) {
                sInstance = new AidTask(context);
            }
            aidTask = sInstance;
        }
        return aidTask;
    }

    private String getMac() {
        try {
            WifiManager wifiManager = (WifiManager) this.mContext.getSystemService("wifi");
            if (wifiManager == null) {
                return a.f;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getMacAddress() : a.f;
        } catch (Exception e) {
            return a.f;
        }
    }

    private String getMeid() {
        try {
            return ((TelephonyManager) this.mContext.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return a.f;
        }
    }

    private String getMfp() {
        String str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB";
        String genMfpString = genMfpString();
        String str2 = a.f;
        try {
            str = new String(genMfpString.getBytes(), com.d.a.a.h.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            str = str2;
        }
        LogUtil.d(TAG, "genMfpString() utf-8 string : " + str);
        try {
            str = encryptRsa(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB");
            LogUtil.d(TAG, "encryptRsa() string : " + str);
            return str;
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage());
            return a.f;
        }
    }

    private String getModel() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            return a.f;
        }
    }

    private String getOS() {
        try {
            return "Android " + VERSION.RELEASE;
        } catch (Exception e) {
            return a.f;
        }
    }

    private PublicKey getPublicKey(String str) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
    }

    private String getResolution() {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return new StringBuilder(String.valueOf(String.valueOf(displayMetrics.widthPixels))).append("*").append(String.valueOf(displayMetrics.heightPixels)).toString();
        } catch (Exception e) {
            return a.f;
        }
    }

    private String getSdSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()));
        } catch (Exception e) {
            return a.f;
        }
    }

    private String getSerialNo() {
        String str = a.f;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{"ro.serialno", c.a});
        } catch (Exception e) {
            return str;
        }
    }

    private String getSsid() {
        try {
            WifiInfo connectionInfo = ((WifiManager) this.mContext.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getSSID();
            }
        } catch (Exception e) {
        }
        return a.f;
    }

    private String loadAidFromNet() {
        String str = "http://api.weibo.com/oauth2/getaid.json";
        str = this.mContext.getPackageName();
        String sign = Utility.getSign(this.mContext, str);
        String mfp = getMfp();
        WeiboParameters weiboParameters = new WeiboParameters(this.mAppKey);
        weiboParameters.put(b.f, this.mAppKey);
        weiboParameters.put("mfp", mfp);
        weiboParameters.put(ParamKey.PACKAGENAME, str);
        weiboParameters.put(WBConstants.SSO_KEY_HASH, sign);
        try {
            str = new AsyncWeiboRunner(this.mContext).request("http://api.weibo.com/oauth2/getaid.json", weiboParameters, Constants.HTTP_GET);
            LogUtil.d(TAG, "loadAidFromNet response : " + str);
            return str;
        } catch (WeiboException e) {
            LogUtil.d(TAG, "loadAidFromNet WeiboException Msg : " + e.getMessage());
            throw e;
        }
    }

    private synchronized AidInfo loadAidInfoFromCache() {
        FileInputStream fileInputStream;
        Throwable th;
        AidInfo aidInfo = null;
        synchronized (this) {
            try {
                fileInputStream = new FileInputStream(getAidInfoFile(VERSION));
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    aidInfo = AidInfo.parseJson(new String(bArr));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return aidInfo;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream = aidInfo;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return aidInfo;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream = aidInfo;
                th = th4;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return aidInfo;
    }

    private int splite(byte[] bArr, int i, int i2) {
        return i >= bArr.length ? -1 : Math.min(bArr.length - i, i2);
    }

    public void aidTaskInit() {
        aidTaskInit(this.mAppKey);
    }

    public void aidTaskInit(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mAppKey = str;
            new Thread(new Runnable() {
                public void run() {
                    if (!AidTask.this.mTaskLock.tryLock()) {
                        return;
                    }
                    if (TextUtils.isEmpty(AidTask.this.loadAidFromCache())) {
                        int i = 0;
                        while (i < 3) {
                            try {
                                String access$2 = AidTask.this.loadAidFromNet();
                                AidInfo.parseJson(access$2);
                                AidTask.this.cacheAidInfo(access$2);
                                break;
                            } catch (WeiboException e) {
                                LogUtil.e(AidTask.TAG, "AidTaskInit WeiboException Msg : " + e.getMessage());
                                i += AidTask.VERSION;
                            }
                        }
                        AidTask.this.mTaskLock.unlock();
                        return;
                    }
                    AidTask.this.mTaskLock.unlock();
                }
            }).start();
        }
    }

    public void getAidAsync(final Handler handler) {
        if (!TextUtils.isEmpty(this.mAppKey)) {
            final Message obtain = Message.obtain();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        String access$2 = AidTask.this.loadAidFromNet();
                        AidInfo parseJson = AidInfo.parseJson(access$2);
                        AidTask.this.cacheAidInfo(access$2);
                        obtain.what = AidTask.WHAT_LOAD_AID_SUC;
                        obtain.obj = parseJson;
                        if (handler != null) {
                            handler.sendMessage(obtain);
                        }
                    } catch (WeiboException e) {
                        if ((e.getCause() instanceof IOException) || (e instanceof WeiboHttpException)) {
                            obtain.what = AidTask.WHAT_LOAD_AID_IO_ERR;
                            if (handler != null) {
                                handler.sendMessage(obtain);
                                return;
                            }
                            return;
                        }
                        obtain.what = AidTask.WHAT_LOAD_AID_API_ERR;
                        if (handler != null) {
                            handler.sendMessage(obtain);
                        }
                    }
                }
            }).start();
        }
    }

    public AidInfo getAidSync() {
        if (TextUtils.isEmpty(this.mAppKey)) {
            return null;
        }
        String loadAidFromNet = loadAidFromNet();
        AidInfo parseJson = AidInfo.parseJson(loadAidFromNet);
        cacheAidInfo(loadAidFromNet);
        return parseJson;
    }

    public ReentrantLock getTaskLock() {
        return this.mTaskLock;
    }

    public synchronized String loadAidFromCache() {
        AidInfo loadAidInfoFromCache;
        loadAidInfoFromCache = loadAidInfoFromCache();
        return loadAidInfoFromCache != null ? loadAidInfoFromCache.getAid() : a.f;
    }

    public synchronized String loadSubCookieFromCache() {
        AidInfo loadAidInfoFromCache;
        loadAidInfoFromCache = loadAidInfoFromCache();
        return loadAidInfoFromCache != null ? loadAidInfoFromCache.getSubCookie() : a.f;
    }

    public void setAppkey(String str) {
        this.mAppKey = str;
    }
}
