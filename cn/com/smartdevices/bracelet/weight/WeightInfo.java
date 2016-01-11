package cn.com.smartdevices.bracelet.weight;

import android.text.format.DateFormat;
import com.activeandroid.a.a;
import com.activeandroid.a.d;
import com.activeandroid.g;

@d(a = "WeightInfos")
public class WeightInfo extends g {
    public static final int TYPE_BABY = 2;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_USER = 1;
    @a(a = "DeviceId")
    public String deviceid;
    @a(a = "Synced")
    public int synced;
    @a(a = "Timestamp")
    public long timestamp;
    @a(a = "Type")
    public int type = TYPE_NORMAL;
    @a(a = "UserId")
    public int uid = -1;
    @a(a = "Weight")
    public float weight;

    public WeightInfo(float f, int i, long j) {
        this.weight = f;
        this.uid = i;
        this.timestamp = j;
    }

    public WeightInfo(WeightInfo weightInfo) {
        this.weight = weightInfo.weight;
        this.uid = weightInfo.uid;
        this.timestamp = weightInfo.timestamp;
        this.deviceid = weightInfo.deviceid;
        this.type = weightInfo.type;
        this.synced = weightInfo.synced;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(" : <").append("Weight : ").append(this.weight);
        stringBuilder.append(", ").append("UserId : ").append(this.uid);
        stringBuilder.append(", ").append("Time : ").append(DateFormat.format("yyyy-MM-dd HH:mm:ss", this.timestamp));
        stringBuilder.append(", ").append("DeviceId : ").append(this.deviceid);
        stringBuilder.append(", ").append("Type : ").append(this.type);
        stringBuilder.append(", ").append("Synced : ").append(this.synced);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
