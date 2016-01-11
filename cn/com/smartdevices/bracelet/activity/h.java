package cn.com.smartdevices.bracelet.activity;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.m;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import cn.com.smartdevices.bracelet.weight.WeightGoalSetActivity;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.r;
import java.util.Locale;
import org.apache.http.Header;
import org.json.JSONObject;

class h extends com.d.a.a.h {
    final /* synthetic */ LoginActivity a;

    h(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d(C0401a.cc, "fail, content =" + Utils.b(bArr) + " statusCode=" + i + ", error = " + th);
        this.a.j();
        C0401a.a(this.a.p, C0409b.M, C0410c.j, i + a.f);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String b = Utils.b(bArr);
        C0596r.e(C0401a.cc, "login result content =" + b);
        n a = n.a(this.a.p.getApplicationContext(), b);
        if (a.c()) {
            try {
                JSONObject optJSONObject = new JSONObject(b).optJSONObject(b.b);
                if (optJSONObject != null) {
                    Long valueOf = Long.valueOf(Long.parseLong(optJSONObject.optString(g.f)));
                    cn.com.smartdevices.bracelet.e.a.a(this.a.p, valueOf.longValue(), optJSONObject.optString(kankan.wheel.widget.a.o));
                    boolean equals = Constants.VIA_TO_TYPE_QQ_GROUP.equals(optJSONObject.optString("hasBinded"));
                    PersonInfo readPersonInfo = Keeper.readPersonInfo();
                    if (equals) {
                        readPersonInfo = m.a(optJSONObject.toString(), readPersonInfo);
                    } else {
                        readPersonInfo.nickname = this.a.q.miliaoNick;
                        if (Locale.getDefault().toString().equals(Locale.US.toString())) {
                            readPersonInfo.miliConfig.unit = 1;
                            readPersonInfo.miliConfig.weightUnit = 1;
                            C0596r.d(C0401a.cc, "Set US default weightUnit to YB and unit to british system ");
                        }
                    }
                    readPersonInfo.uid = valueOf.longValue();
                    C0596r.e(C0401a.cc, "unit = " + readPersonInfo.miliConfig.unit + ", weightunit=" + readPersonInfo.miliConfig.weightUnit);
                    Keeper.keepPersonInfo(readPersonInfo);
                    C0401a.a(this.a.p, C0409b.L, WeightGoalSetActivity.a, readPersonInfo.uid + a.f);
                    new i(this).execute(new Void[0]);
                    this.a.a(equals);
                    return;
                }
                return;
            } catch (Exception e) {
                C0596r.d(C0401a.cc, "Catched exception: " + e);
                e.printStackTrace();
                this.a.j();
                C0401a.a(this.a.p, C0409b.M, C0410c.j, e.getMessage());
                return;
            }
        }
        com.huami.android.view.b.a(this.a.p, this.a.getString(r.login_failed) + "\uff0c" + this.a.getString(r.error_code) + kankan.wheel.widget.a.ci + a.h, 1).show();
        this.a.l();
        C0596r.d(C0401a.cc, "Login webstatus fail, code = " + a.h);
    }
}
