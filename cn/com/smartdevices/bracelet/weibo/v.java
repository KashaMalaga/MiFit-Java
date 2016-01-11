package cn.com.smartdevices.bracelet.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.ResponseEntity;
import cn.com.smartdevices.bracelet.model.ThirdLoginState;
import cn.com.smartdevices.bracelet.model.ThirdTokenState;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import com.huami.android.widget.share.m;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.openapi.RefreshTokenApi;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.xiaomi.account.openauth.h;
import de.greenrobot.event.EventBus;
import org.json.JSONObject;

public class v {
    public static final String a = "100005";
    public static final long b = 86400000;
    private static final String c = "WeiboHealthManager";
    private static final String d = "third_party_health";
    private static final String e = "only_once_day";
    private static final long f = 432000;
    private final b g;

    private v() {
        this.g = b.h();
    }

    public static v a() {
        return D.a;
    }

    public ResponseEntity a(Context context, ThirdLoginState thirdLoginState, int i) {
        LoginData f = a.f(context);
        ResponseEntity responseEntity = new ResponseEntity();
        l.a(a, i, f, thirdLoginState, new C(this, responseEntity, i, context));
        return responseEntity;
    }

    public ThirdLoginState a(Bundle bundle) {
        C0596r.e(c, "Token:" + bundle);
        if (bundle == null) {
            return null;
        }
        ThirdLoginState thirdLoginState = new ThirdLoginState();
        thirdLoginState.expiresIn = Long.parseLong(bundle.getString(h.L));
        thirdLoginState.accessToken = bundle.getString(h.I);
        thirdLoginState.refreshToken = bundle.getString(f.aX);
        thirdLoginState.uid = bundle.getString(kankan.wheel.widget.a.n);
        return thirdLoginState;
    }

    public ThirdLoginState a(String str) {
        if (str == null) {
            return null;
        }
        ThirdLoginState thirdLoginState = new ThirdLoginState();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(h.I)) {
                thirdLoginState.accessToken = jSONObject.optString(h.I);
            }
            if (!jSONObject.isNull(h.L)) {
                thirdLoginState.expiresIn = Long.parseLong(jSONObject.optString(h.L));
            }
            if (!jSONObject.isNull(f.aX)) {
                thirdLoginState.refreshToken = jSONObject.optString(f.aX);
            }
            if (jSONObject.isNull(kankan.wheel.widget.a.n)) {
                return thirdLoginState;
            }
            thirdLoginState.uid = jSONObject.optString(kankan.wheel.widget.a.n);
            return thirdLoginState;
        } catch (Exception e) {
            e.printStackTrace();
            return thirdLoginState;
        }
    }

    public void a(Context context, RequestListener requestListener) {
        ThirdLoginState e = q.e(context);
        if (e != null && !com.xiaomi.e.a.f.equals(e.refreshToken)) {
            RefreshTokenApi.create(context).refreshToken(m.l, e.refreshToken, requestListener);
        } else if (requestListener != null) {
            requestListener.onWeiboException(new WeiboException("refresh token is null"));
        }
    }

    public void a(boolean z) {
        ThirdTokenState thirdTokenState = new ThirdTokenState();
        thirdTokenState.accountType = 1;
        thirdTokenState.isExpired = z;
        EventBus.getDefault().post(thirdTokenState);
    }

    public boolean a(Context context) {
        return q.g(context) ? q.e(context).isSessionValid() : false;
    }

    public boolean a(Intent intent) {
        if ("android.intent.action.VIEW".equals(intent.getAction())) {
            Uri data = intent.getData();
            if (data != null && a.equals(data.getQueryParameter(QQLogin.KEY_FROM))) {
                return true;
            }
        }
        return false;
    }

    public boolean b(Context context) {
        return Long.parseLong(q.e(context).expiresTime) - System.currentTimeMillis() < f;
    }

    public void c(Context context) {
        Editor edit = context.getSharedPreferences(d, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putLong(e, System.currentTimeMillis());
        edit.commit();
    }

    public boolean d(Context context) {
        return context.getSharedPreferences(d, WXMediaMessage.THUMB_LENGTH_LIMIT).getLong(e, 0) + b < System.currentTimeMillis();
    }

    public void e(Context context) {
        if (context != null && this.g.c.f.booleanValue()) {
            new Thread(new w(this, context)).start();
        }
    }

    public ResponseEntity f(Context context) {
        LoginData f = a.f(context);
        ThirdLoginState e = q.e(context);
        ResponseEntity responseEntity = new ResponseEntity();
        l.b(a, f, e, new z(this, responseEntity, context));
        return responseEntity;
    }

    public ResponseEntity g(Context context) {
        LoginData f = a.f(context);
        ThirdLoginState e = q.e(context);
        ResponseEntity responseEntity = new ResponseEntity();
        l.a(a, f, e, new A(this, responseEntity, e, context));
        return responseEntity;
    }

    public ResponseEntity h(Context context) {
        LoginData f = a.f(context);
        ThirdLoginState thirdLoginState = new ThirdLoginState();
        ResponseEntity responseEntity = new ResponseEntity();
        l.a(a, f, new B(this, responseEntity, thirdLoginState));
        return responseEntity;
    }

    public boolean i(Context context) {
        return q.f(context);
    }
}
