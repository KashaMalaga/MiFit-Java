package cn.com.smartdevices.bracelet.model;

import com.xiaomi.e.a;

public class SystemInfo {
    public String mMiuiVersionCode = a.f;
    public String mMiuiVersionName = a.f;
    public String mPhoneBrand = a.f;
    public String mPhoneModel = a.f;
    public String mPhoneSystem = a.f;
    public String mSoftVersion = a.f;

    public SystemInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.mMiuiVersionName = str;
        this.mMiuiVersionCode = str2;
        this.mPhoneBrand = str3;
        this.mPhoneModel = str4;
        this.mPhoneSystem = str5;
        this.mSoftVersion = str6;
    }

    public String getMiuiVersionCode() {
        return this.mMiuiVersionCode;
    }

    public String getMiuiVersionName() {
        return this.mMiuiVersionName;
    }

    public String getPhoneBrand() {
        return this.mPhoneBrand;
    }

    public String getPhoneModel() {
        return this.mPhoneModel;
    }

    public String getPhoneSystem() {
        return this.mPhoneSystem;
    }

    public String getSoftVersion() {
        return this.mSoftVersion;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("miuiVersionName:").append(this.mMiuiVersionName).append("\n");
        stringBuffer.append("miuiVersionCode:").append(this.mMiuiVersionCode).append("\n");
        stringBuffer.append("phoneBrand:").append(this.mPhoneBrand).append("\n");
        stringBuffer.append("phoneModel:").append(this.mPhoneModel).append("\n");
        stringBuffer.append("phoneSystem:").append(this.mPhoneSystem).append("\n");
        stringBuffer.append("softVersion:").append(this.mSoftVersion).append("\n");
        return stringBuffer.toString();
    }
}
