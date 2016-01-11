package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.C0113o;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoObject extends BaseMediaObject {
    public static final Creator<VideoObject> CREATOR = new Creator<VideoObject>() {
        public VideoObject createFromParcel(Parcel parcel) {
            return new VideoObject(parcel);
        }

        public VideoObject[] newArray(int i) {
            return new VideoObject[i];
        }
    };
    public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
    public String dataHdUrl;
    public String dataUrl;
    public String defaultText;
    public int duration;
    public String h5Url;

    public VideoObject(Parcel parcel) {
        super(parcel);
        this.h5Url = parcel.readString();
        this.dataUrl = parcel.readString();
        this.dataHdUrl = parcel.readString();
        this.duration = parcel.readInt();
    }

    public boolean checkArgs() {
        if (!super.checkArgs()) {
            return false;
        }
        if (this.dataUrl != null && this.dataUrl.length() > C0113o.j) {
            LogUtil.e("Weibo.VideoObject", "checkArgs fail, dataUrl is invalid");
            return false;
        } else if (this.dataHdUrl != null && this.dataHdUrl.length() > C0113o.j) {
            LogUtil.e("Weibo.VideoObject", "checkArgs fail, dataHdUrl is invalid");
            return false;
        } else if (this.duration > 0) {
            return true;
        } else {
            LogUtil.e("Weibo.VideoObject", "checkArgs fail, duration is invalid");
            return false;
        }
    }

    public int getObjType() {
        return 4;
    }

    protected BaseMediaObject toExtraMediaObject(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.defaultText = new JSONObject(str).optString(EXTRA_KEY_DEFAULTTEXT);
            } catch (JSONException e) {
            }
        }
        return this;
    }

    protected String toExtraMediaString() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.defaultText)) {
                jSONObject.put(EXTRA_KEY_DEFAULTTEXT, this.defaultText);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return a.f;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.h5Url);
        parcel.writeString(this.dataUrl);
        parcel.writeString(this.dataHdUrl);
        parcel.writeInt(this.duration);
    }
}
