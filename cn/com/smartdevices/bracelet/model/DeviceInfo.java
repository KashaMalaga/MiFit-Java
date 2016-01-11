package cn.com.smartdevices.bracelet.model;

import com.xiaomi.e.a;

public class DeviceInfo {
    private String mDeviceId;
    private String mFwVersion;
    private String mHRFwVersion;
    private String mMacAddress;
    private int mSource;
    private int mType;

    public DeviceInfo(int i, String str) {
        this(i, str, null, null);
    }

    public DeviceInfo(int i, String str, String str2) {
        this(i, str, str2, null);
    }

    public DeviceInfo(int i, String str, String str2, String str3) {
        this.mType = -1;
        this.mSource = -1;
        this.mDeviceId = a.f;
        this.mMacAddress = a.f;
        this.mFwVersion = a.f;
        this.mHRFwVersion = a.f;
        this.mType = i;
        if (str == null) {
            str = a.f;
        }
        this.mDeviceId = str;
        if (str2 == null) {
            str2 = a.f;
        }
        this.mMacAddress = str2;
        if (str3 == null) {
            str3 = a.f;
        }
        this.mFwVersion = str3;
    }

    public DeviceInfo(int i, String str, String str2, String str3, int i2) {
        this(i, str, str2, str3);
        this.mSource = i2;
    }

    public DeviceInfo(int i, String str, String str2, String str3, String str4, int i2) {
        this(i, str, str2, str3, i2);
        if (str4 == null) {
            str4 = a.f;
        }
        this.mHRFwVersion = str4;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getFwVersion() {
        return this.mFwVersion;
    }

    public String getHRFwVersion() {
        return this.mHRFwVersion;
    }

    public String getMacAddress() {
        return this.mMacAddress;
    }

    public int getSource() {
        return this.mSource;
    }

    public int getType() {
        return this.mType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("deviceId:").append(this.mDeviceId).append("\n").append("macAddress:").append(this.mMacAddress).append("\n").append("fwVersion:").append(this.mFwVersion);
        return stringBuffer.toString();
    }
}
