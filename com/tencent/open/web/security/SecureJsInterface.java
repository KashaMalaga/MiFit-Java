package com.tencent.open.web.security;

import com.tencent.open.a.b;
import com.tencent.open.a.f;
import com.xiaomi.e.a;

public class SecureJsInterface extends b {
    public static boolean isPWDEdit = false;
    private String a;

    public void clearAllEdit() {
        f.c("openSDK_LOG.SI", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Throwable e) {
            f.e("openSDK_LOG.SI", "-->clear all edit exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void curPosFromJS(String str) {
        f.b("openSDK_LOG.SI", "-->curPosFromJS: " + str);
        int i = -1;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            f.e("openSDK_LOG.SI", "-->curPosFromJS number format exception.");
        }
        if (i < 0) {
            throw new RuntimeException("position is illegal.");
        }
        if (a.c) {
        }
        if (!a.b) {
            this.a = a.a;
            JniInterface.insetTextToArray(i, this.a, this.a.length());
            f.b("openSDK_LOG.SI", "mKey: " + this.a);
        } else if (Boolean.valueOf(JniInterface.BackSpaceChar(a.b, i)).booleanValue()) {
            a.b = false;
        }
    }

    public boolean customCallback() {
        return true;
    }

    public String getMD5FromNative() {
        f.c("openSDK_LOG.SI", "-->get md5 form native");
        String str = a.f;
        try {
            str = JniInterface.getPWDKeyToMD5(null);
            f.b("openSDK_LOG.SI", "-->getMD5FromNative, MD5= " + str);
            return str;
        } catch (Throwable e) {
            f.e("openSDK_LOG.SI", "-->get md5 form native exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void isPasswordEdit(String str) {
        f.c("openSDK_LOG.SI", "-->is pswd edit, flag: " + str);
        int i = -1;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            f.e("openSDK_LOG.SI", "-->is pswd edit exception: " + e.getMessage());
        }
        if (i != 0 && i != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        } else if (i == 0) {
            isPWDEdit = false;
        } else if (i == 1) {
            isPWDEdit = true;
        }
    }
}
