package cn.com.smartdevices.bracelet;

import android.app.Activity;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.r;
import com.xiaomi.market.sdk.C1123b;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

final class U extends h {
    final /* synthetic */ boolean a;
    final /* synthetic */ Activity b;

    U(boolean z, Activity activity) {
        this.a = z;
        this.b = activity;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Utils", "checkBetaApk, onFailure = " + i);
        Utils.a(this.a);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String str = new String(bArr);
        C0596r.e("Utils", "checkBetaApk, onSuccess, statusCode = " + i + ", " + new String(bArr));
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(b.a);
            if (optInt == n.g) {
                C0596r.e("Utils", "checkBetaApk, not beta apk user ! check mi store now. ");
                Utils.a(this.a);
            }
            if (optInt == n.f) {
                str = a.f;
                if (!jSONObject.isNull(b.b)) {
                    str = jSONObject.getJSONObject(b.b).optString("groupname") + "\n";
                }
                if (this.a) {
                    com.huami.android.view.b.a(this.b, str + this.b.getString(r.apk_uptodate), 1, 1).show();
                }
            } else if (!jSONObject.isNull(b.b)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
                String optString = jSONObject2.optString("apkurl");
                String optString2 = jSONObject2.optString("versionname");
                str = jSONObject2.optString("changelog");
                C0596r.e("Utils", "checkBetaApk, url=" + optString);
                C1123b c1123b = new C1123b();
                c1123b.d = optString;
                c1123b.b = optString2;
                c1123b.a = str;
                Utils.b(c1123b, this.b);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
