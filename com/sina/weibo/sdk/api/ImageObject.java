package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.C0113o;
import com.sina.weibo.sdk.utils.LogUtil;
import com.xiaomi.e.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageObject extends BaseMediaObject {
    public static final Creator<ImageObject> CREATOR = new Creator<ImageObject>() {
        public ImageObject createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        public ImageObject[] newArray(int i) {
            return new ImageObject[i];
        }
    };
    private static final int DATA_SIZE = 2097152;
    public byte[] imageData;
    public String imagePath;

    public ImageObject(Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }

    public boolean checkArgs() {
        if (this.imageData == null && this.imagePath == null) {
            LogUtil.e("Weibo.ImageObject", "imageData and imagePath are null");
            return false;
        } else if (this.imageData != null && this.imageData.length > DATA_SIZE) {
            LogUtil.e("Weibo.ImageObject", "imageData is too large");
            return false;
        } else if (this.imagePath == null || this.imagePath.length() <= C0113o.j) {
            if (this.imagePath != null) {
                File file = new File(this.imagePath);
                try {
                    if (!file.exists() || file.length() == 0 || file.length() > 10485760) {
                        LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
                        return false;
                    }
                } catch (SecurityException e) {
                    LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
                    return false;
                }
            }
            return true;
        } else {
            LogUtil.e("Weibo.ImageObject", "imagePath is too length");
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 2;
    }

    public final void setImageObject(Bitmap bitmap) {
        Exception e;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                this.imageData = byteArrayOutputStream.toByteArray();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    LogUtil.e("Weibo.ImageObject", "put thumb failed");
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
            e.printStackTrace();
            LogUtil.e("Weibo.ImageObject", "put thumb failed");
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }

    protected BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    protected String toExtraMediaString() {
        return a.f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }
}
