package com.xiaomi.push.service;

import android.os.Parcelable;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.xiaomi.f.A;
import com.xiaomi.f.c.a;
import com.xiaomi.f.c.b;
import com.xiaomi.f.c.d;
import com.xiaomi.f.c.e;
import com.xiaomi.f.c.k;
import com.xiaomi.f.e.i;
import com.xiaomi.f.l;
import com.xiaomi.f.o;
import com.xiaomi.f.y;
import com.xiaomi.f.z;
import com.xiaomi.network.c;
import com.xiaomi.network.f;

public class PacketSync {
    private XMPushService a;

    public interface PacketReceiveHandler extends Parcelable {
    }

    PacketSync(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(a aVar) {
        Object c = aVar.c();
        if (!TextUtils.isEmpty(c)) {
            String[] split = c.split(";");
            c a = f.a().a(o.d());
            if (a != null && split.length > 0) {
                a.a(split);
                this.a.b(20, null);
                this.a.a(true);
            }
        }
    }

    private void b(e eVar) {
        Object m = eVar.m();
        Object l = eVar.l();
        if (!TextUtils.isEmpty(m) && !TextUtils.isEmpty(l)) {
            Z b = X.a().b(l, m);
            if (b != null) {
                i.a(this.a, b.a, (long) i.a(eVar.c()), true, System.currentTimeMillis());
            }
        }
    }

    public void a(e eVar) {
        if (!Constants.VIA_SHARE_TYPE_TEXT.equals(eVar.l())) {
            b(eVar);
        }
        Z b;
        if (eVar instanceof y) {
            y yVar = (y) eVar;
            z a = yVar.a();
            String l = yVar.l();
            String m = yVar.m();
            if (!TextUtils.isEmpty(l)) {
                b = X.a().b(l, m);
                if (b == null) {
                    return;
                }
                if (a == z.a) {
                    b.a(ab.binded, 1, 0, null, null);
                    com.xiaomi.channel.a.b.c.a("SMACK: channel bind succeeded, chid=" + l);
                    return;
                }
                k p = yVar.p();
                com.xiaomi.channel.a.b.c.a("SMACK: channel bind failed, error=" + p.d());
                if (p != null) {
                    if ("auth".equals(p.b())) {
                        b.a(ab.unbind, 1, 5, p.a(), p.b());
                        X.a().a(l, m);
                    } else if (com.huami.android.widget.f.b.equals(p.b())) {
                        b.a(ab.unbind, 1, 7, p.a(), p.b());
                        X.a().a(l, m);
                    } else if ("wait".equals(p.b())) {
                        this.a.b(b);
                        b.a(ab.unbind, 1, 7, p.a(), p.b());
                    }
                    com.xiaomi.channel.a.b.c.a("SMACK: channel bind failed, chid=" + l + " reason=" + p.a());
                    return;
                }
                return;
            }
            return;
        }
        String l2 = eVar.l();
        if (TextUtils.isEmpty(l2)) {
            l2 = Constants.VIA_TO_TYPE_QQ_GROUP;
            eVar.l(l2);
        }
        if (!l2.equals(Constants.VIA_RESULT_SUCCESS)) {
            a p2;
            if (eVar instanceof b) {
                p2 = eVar.p("kick");
                if (p2 != null) {
                    String m2 = eVar.m();
                    String a2 = p2.a(SocialConstants.PARAM_TYPE);
                    String a3 = p2.a("reason");
                    com.xiaomi.channel.a.b.c.a("kicked by server, chid=" + l2 + " userid=" + m2 + " type=" + a2 + " reason=" + a3);
                    if ("wait".equals(a2)) {
                        b = X.a().b(l2, m2);
                        if (b != null) {
                            this.a.b(b);
                            b.a(ab.unbind, 3, 0, a3, a2);
                            return;
                        }
                        return;
                    }
                    this.a.a(l2, m2, 3, a3, a2);
                    X.a().a(l2, m2);
                    return;
                }
            } else if (eVar instanceof d) {
                d dVar = (d) eVar;
                if ("redir".equals(dVar.a())) {
                    p2 = dVar.p("hosts");
                    if (p2 != null) {
                        a(p2);
                        return;
                    }
                    return;
                }
            }
            this.a.e().a(this.a, l2, eVar);
        } else if ((eVar instanceof b) && Constants.VIA_RESULT_SUCCESS.equals(eVar.k()) && C0483q.g.equals(((b) eVar).a().toString())) {
            l h = this.a.h();
            if (h instanceof A) {
                ((A) h).x();
            }
            com.xiaomi.g.i.b();
        }
    }
}
