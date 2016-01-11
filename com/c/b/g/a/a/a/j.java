package com.c.b.g.a.a.a;

import com.c.b.c.a;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.t;

public abstract class j {
    private final a a;
    private final t b;

    j(a aVar) {
        this.a = aVar;
        this.b = new t(aVar);
    }

    public static j a(a aVar) {
        if (aVar.a(1)) {
            return new g(aVar);
        }
        if (!aVar.a(2)) {
            return new k(aVar);
        }
        switch (t.a(aVar, 1, 4)) {
            case kankan.wheel.widget.a.aQ /*4*/:
                return new a(aVar);
            case kankan.wheel.widget.a.X /*5*/:
                return new b(aVar);
            default:
                switch (t.a(aVar, 1, 5)) {
                    case kankan.wheel.widget.a.be /*12*/:
                        return new c(aVar);
                    case t.WeightView_wv_bmi_size /*13*/:
                        return new d(aVar);
                    default:
                        switch (t.a(aVar, 1, 7)) {
                            case 56:
                                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                            case 57:
                                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                            case 58:
                                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                            case 59:
                                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                            case kankan.wheel.widget.a.aD /*60*/:
                                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_WPA_STATE);
                            case 61:
                                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_WPA_STATE);
                            case 62:
                                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_START_GROUP);
                            case 63:
                                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_START_GROUP);
                            default:
                                throw new IllegalStateException("unknown decoder: " + aVar);
                        }
                }
        }
    }

    public abstract String a();

    protected final a b() {
        return this.a;
    }

    protected final t c() {
        return this.b;
    }
}
