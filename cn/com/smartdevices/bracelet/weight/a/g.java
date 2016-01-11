package cn.com.smartdevices.bracelet.weight.a;

import cn.com.smartdevices.bracelet.i.a.i;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import com.d.a.a.O;
import com.sina.weibo.sdk.component.WidgetRequestParam;

class g extends i<i, O> {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public O a(i iVar) {
        O a = f.a(this.a.c);
        a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, iVar.c);
        if (iVar.a > -1) {
            a.a(SportBaseInfo.KEY_START_TIME, iVar.a);
        }
        if (iVar.b > -1) {
            a.a(SportBaseInfo.KEY_END_TIME, iVar.b);
        }
        if (iVar.d) {
            a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, QQLogin.PERMISSION_ALL);
        } else {
            a.a(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, iVar.c);
        }
        a.a(f.aa, 1);
        return a;
    }

    public /* synthetic */ Object wrap(Object obj) {
        return a((i) obj);
    }
}
