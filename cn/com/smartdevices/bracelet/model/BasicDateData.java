package cn.com.smartdevices.bracelet.model;

import android.util.Base64;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.d.F;
import cn.com.smartdevices.bracelet.d.H;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import org.json.JSONException;
import org.json.JSONObject;

public class BasicDateData {
    private static final String TAG = "UploadData";
    public byte[] data;
    public byte[] dataHR;
    public String date;
    public String indexs;
    public int source;
    public String summary;
    public String summaryHR;
    public int type;

    public BasicDateData() {
        this.date = a.f;
        this.data = null;
        this.summary = a.f;
        this.indexs = a.f;
        this.dataHR = null;
        this.summaryHR = a.f;
        this.type = 0;
        this.source = 0;
    }

    public BasicDateData(String str, String str2, byte[] bArr) {
        this.date = a.f;
        this.data = null;
        this.summary = a.f;
        this.indexs = a.f;
        this.dataHR = null;
        this.summaryHR = a.f;
        this.type = 0;
        this.source = 0;
        this.date = str;
        this.summary = str2;
        this.data = bArr;
    }

    public BasicDateData(String str, String str2, byte[] bArr, String str3, byte[] bArr2) {
        this(str, str2, bArr);
        this.summaryHR = str3;
        this.dataHR = bArr2;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            String encodeToString = Base64.encodeToString(this.data, 2);
            String str = a.f;
            if (this.dataHR != null && this.dataHR.length > 0) {
                str = Base64.encodeToString(this.dataHR, 2);
                jSONObject.put(F.i, str);
            }
            jSONObject.put(g.a, this.date);
            jSONObject.put(b.b, encodeToString);
            jSONObject.put(SocialConstants.PARAM_SUMMARY, this.summary);
            jSONObject.put(H.k, this.indexs);
            jSONObject.put(F.j, this.summaryHR);
            jSONObject.put(o.L, this.source);
            jSONObject.put(com.xiaomi.channel.relationservice.data.a.h, this.type);
            C0596r.e(TAG, "toJSONObject date:\n" + this.date);
            C0596r.e(TAG, "toJSONObject summary:\n" + this.summary);
            C0596r.e(TAG, "toJSONObject data:\n" + encodeToString);
            C0596r.e(TAG, "toJSONObject summary_hr:\n" + this.summaryHR);
            C0596r.e(TAG, "toJSONObject data_hr:\n" + str);
            C0596r.e(TAG, "toJSONObject indexs:\n" + this.indexs);
            C0596r.e(TAG, "toJSONObject source:\n" + this.source);
            C0596r.e(TAG, "toJSONObject type:\n" + this.type);
        } catch (JSONException e) {
            C0596r.e(TAG, "toJSONObject:" + e.getMessage());
        }
        return jSONObject;
    }
}
