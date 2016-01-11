package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.P;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.huami.android.view.b;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import com.xiaomi.hm.health.r;
import java.util.List;

class aB extends Handler {
    final /* synthetic */ C0694ax a;

    aB(C0694ax c0694ax) {
        this.a = c0694ax;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 4114:
                this.a.n();
                C0596r.e("DDDD", "Dynamic Update : Data Loaded,Prev/Next Day,Animation");
                this.a.b(false);
                return;
            case 4115:
                if (this.a.k != message.arg1) {
                    C0401a.a(this.a.getActivity(), C0401a.cQ);
                }
                this.a.k = message.arg1;
                this.a.b(true);
                return;
            case 4116:
                P p = (P) message.obj;
                e eVar = p.a;
                if (eVar.f() && !eVar.d()) {
                    this.a.H = p;
                }
                if (eVar.d()) {
                    this.a.G = this.a.H;
                } else {
                    this.a.G = p;
                }
                if (this.a.isAdded()) {
                    C0596r.e("DynamicFragment", "Dynamic Update : WeightAdvData receive:" + p);
                    if (!(this.a.z == PersonInfo.INCOMING_CALL_DISABLE_BIT || eVar.d())) {
                        this.a.b((int) PersonInfo.INCOMING_CALL_DISABLE_BIT, true);
                    }
                    if (eVar.m()) {
                        this.a.l();
                    } else if (eVar.d() && !eVar.f() && eVar.c()) {
                        if (Utils.c(this.a.getActivity())) {
                            b.a(this.a.getActivity(), (int) r.weighting_failed, 1, 17).show();
                        }
                    } else if (!eVar.d() && eVar.f() && p.c == 0) {
                        List<UserInfo> list = p.f;
                        if (list.size() == 0) {
                            C0596r.e("MATCHED_USERS", "userinfos size is 0");
                        } else if (list.size() == 1) {
                            C0596r.e("MATCHED_USERS", "match 1 user");
                        } else {
                            C0596r.e("MATCHED_USERS", "match more than 1 user ");
                            for (UserInfo userInfo : list) {
                                C0596r.e("MATCHED_USERS", "info : " + userInfo.toString());
                            }
                        }
                        this.a.a(eVar, (List) list);
                    }
                    this.a.b(true);
                    return;
                }
                return;
            case 4117:
                this.a.a(message);
                return;
            default:
                return;
        }
    }
}
