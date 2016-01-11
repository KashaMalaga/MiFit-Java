package cn.com.smartdevices.bracelet.config;

import android.content.Context;
import android.util.Log;
import com.d.a.a.h;
import com.xiaomi.channel.b.v;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import org.apache.http.Header;
import org.json.JSONObject;

final class c extends h {
    final /* synthetic */ Context a;

    c(Context context) {
        this.a = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        if (b.x) {
            String str = a.f;
            if (bArr != null) {
                str = new String(bArr);
            }
            Log.e("Config", "Status:" + i + " | content:" + str, th);
        }
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (i == v.C) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (jSONObject.optInt(b.a) == 1) {
                    String string = jSONObject.getString(b.b);
                    JSONObject b = b.b(this.a);
                    jSONObject = new JSONObject(string);
                    if (b != null) {
                        b.a(b, jSONObject);
                    } else {
                        b = jSONObject;
                    }
                    b.b((b) b.H.a(b.toString(), b.class));
                }
            } catch (Exception e) {
                if (b.x) {
                    Log.e("Config", e.getMessage());
                }
            }
        }
    }
}
