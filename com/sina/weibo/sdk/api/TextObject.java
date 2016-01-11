package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.activeandroid.b;
import com.sina.weibo.sdk.utils.LogUtil;
import com.xiaomi.e.a;

public class TextObject extends BaseMediaObject {
    public static final Creator<TextObject> CREATOR = new Creator<TextObject>() {
        public TextObject createFromParcel(Parcel parcel) {
            return new TextObject(parcel);
        }

        public TextObject[] newArray(int i) {
            return new TextObject[i];
        }
    };
    public String text;

    public TextObject(Parcel parcel) {
        this.text = parcel.readString();
    }

    public boolean checkArgs() {
        if (this.text != null && this.text.length() != 0 && this.text.length() <= b.a) {
            return true;
        }
        LogUtil.e("Weibo.TextObject", "checkArgs fail, text is invalid");
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 1;
    }

    protected BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    protected String toExtraMediaString() {
        return a.f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
    }
}
