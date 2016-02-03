package cn.com.smartdevices.bracelet.weibo;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.model.ResponseEntity;
import cn.com.smartdevices.bracelet.model.ThirdLoginState;
import com.amap.api.location.LocationManagerProxy;
import com.d.a.a.p;
import com.huami.android.widget.f;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import org.apache.http.Header;
import org.json.JSONObject;

class A extends p<ResponseEntity> {
    final /* synthetic */ ResponseEntity a;
    final /* synthetic */ ThirdLoginState b;
    final /* synthetic */ Context c;
    final /* synthetic */ v d;

    A(v vVar, ResponseEntity responseEntity, ThirdLoginState thirdLoginState, Context context) {
        this.d = vVar;
        this.a = responseEntity;
        this.b = thirdLoginState;
        this.c = context;
    }

    protected ResponseEntity a(String str, boolean z) {
        C0596r.e("WeiboHealthManager", "queryBindStateFromServer parse: " + str);
        ResponseEntity responseEntity = new ResponseEntity();
        if (z) {
            responseEntity.state = false;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = !jSONObject.isNull(b.a) ? jSONObject.optInt(b.a) : -1;
                String str2 = a.f;
                if (!jSONObject.isNull(f.a)) {
                    str2 = jSONObject.optString(f.a);
                }
                if (!jSONObject.isNull(b.b)) {
                    jSONObject = jSONObject.getJSONObject(b.b);
                    if (!jSONObject.isNull(LocationManagerProxy.KEY_STATUS_CHANGED)) {
                        this.b.bindState = jSONObject.optInt(LocationManagerProxy.KEY_STATUS_CHANGED);
                    }
                }
                responseEntity.setData(this.b);
                responseEntity.code = optInt;
                responseEntity.msg = str2;
            } catch (Exception e) {
                responseEntity.state = false;
                responseEntity.msg = this.c.getString(R.string.parse_data_failed);
            }
        }
        return responseEntity;
    }

    public void a(int i, Header[] headerArr, String str, ResponseEntity responseEntity) {
        if (responseEntity == null) {
            this.a.state = false;
            return;
        }
        this.a.state = responseEntity.state;
        this.a.code = responseEntity.code;
        this.a.msg = responseEntity.msg;
        this.a.setData(responseEntity.getData());
    }

    public void a(int i, Header[] headerArr, Throwable th, String str, ResponseEntity responseEntity) {
        this.a.state = false;
    }

    public /* synthetic */ void onFailure(int i, Header[] headerArr, Throwable th, String str, Object obj) {
        a(i, headerArr, th, str, (ResponseEntity) obj);
    }

    public /* synthetic */ void onSuccess(int i, Header[] headerArr, String str, Object obj) {
        a(i, headerArr, str, (ResponseEntity) obj);
    }

    protected /* synthetic */ Object parseResponse(String str, boolean z) {
        return a(str, z);
    }
}
