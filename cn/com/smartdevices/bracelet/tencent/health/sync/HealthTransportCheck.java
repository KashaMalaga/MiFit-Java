package cn.com.smartdevices.bracelet.tencent.health.sync;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.i.a.h;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.Tencent;
import org.json.JSONException;
import org.json.JSONObject;

public class HealthTransportCheck extends h<String> {
    public static void checkRelogin(String str, int i, QQLogin qQLogin) {
        C0596r.e(str, "QQ Check Need Re-login Code : " + i);
        if (i == -73) {
            C0596r.g(str, "Login is invalid : " + i);
            Tencent tencent = qQLogin.getTencent();
            tencent.setAccessToken(tencent.getAccessToken(), Constants.VIA_RESULT_SUCCESS);
            qQLogin.saveOAuthInfo();
        }
    }

    public void check(String str) {
        if (TextUtils.isEmpty(str)) {
            failure();
            return;
        }
        try {
            int optInt = new JSONObject(str).optInt(QQLogin.KEY_RESULT, -1);
            if (optInt == 0) {
                success();
                return;
            }
            state().a(optInt);
            state().a(str);
            failure();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
