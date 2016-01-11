package cn.com.smartdevices.bracelet.weibo;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.model.ResponseEntity;
import cn.com.smartdevices.bracelet.model.ThirdLoginState;
import com.amap.api.location.LocationManagerProxy;
import com.d.a.a.p;
import com.huami.android.widget.f;
import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import org.apache.http.Header;
import org.json.JSONObject;

class B extends p<ResponseEntity> {
    final /* synthetic */ ResponseEntity a;
    final /* synthetic */ ThirdLoginState b;
    final /* synthetic */ v c;

    B(v vVar, ResponseEntity responseEntity, ThirdLoginState thirdLoginState) {
        this.c = vVar;
        this.a = responseEntity;
        this.b = thirdLoginState;
    }

    protected ResponseEntity a(String str, boolean z) {
        C0596r.e("WeiboHealthManager", "queryLoginStateFromServer:" + str);
        ResponseEntity responseEntity = new ResponseEntity();
        if (z) {
            responseEntity.state = false;
            return responseEntity;
        }
        JSONObject jSONObject = new JSONObject(str);
        int optInt = !jSONObject.isNull(b.a) ? jSONObject.optInt(b.a) : -1;
        String optString = !jSONObject.isNull(f.a) ? jSONObject.optString(f.a) : a.f;
        if (!jSONObject.isNull(b.b)) {
            Object obj = jSONObject.get(b.b);
            if (obj instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) obj;
                if (!jSONObject2.isNull(h.I)) {
                    this.b.accessToken = jSONObject2.optString(h.I);
                }
                if (!jSONObject2.isNull(cn.com.smartdevices.bracelet.j.f.aR)) {
                    this.b.uid = jSONObject2.optString(cn.com.smartdevices.bracelet.j.f.aR);
                }
                if (!jSONObject2.isNull(cn.com.smartdevices.bracelet.j.f.av)) {
                    this.b.appId = jSONObject2.optString(cn.com.smartdevices.bracelet.j.f.av);
                }
                if (!jSONObject2.isNull(cn.com.smartdevices.bracelet.j.f.aS)) {
                    this.b.expiresTime = jSONObject2.optString(cn.com.smartdevices.bracelet.j.f.aS);
                }
                if (!jSONObject2.isNull(h.L)) {
                    this.b.expiresIn = jSONObject2.optLong(h.L);
                }
                if (!jSONObject2.isNull(cn.com.smartdevices.bracelet.j.f.aX)) {
                    this.b.refreshToken = jSONObject2.optString(cn.com.smartdevices.bracelet.j.f.aX);
                }
                if (!jSONObject2.isNull(cn.com.smartdevices.bracelet.j.f.y)) {
                    this.b.nickName = jSONObject2.optString(cn.com.smartdevices.bracelet.j.f.y);
                }
                if (!jSONObject2.isNull(LocationManagerProxy.KEY_STATUS_CHANGED)) {
                    this.b.bindState = jSONObject2.optInt(LocationManagerProxy.KEY_STATUS_CHANGED);
                }
            }
        }
        responseEntity.code = optInt;
        responseEntity.msg = optString;
        responseEntity.setData(this.b);
        return responseEntity;
    }

    public void a(int i, Header[] headerArr, String str, ResponseEntity responseEntity) {
        if (responseEntity == null) {
            this.a.state = false;
            return;
        }
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
