package cn.com.smartdevices.bracelet.weight;

import java.util.Comparator;

class C0860ab implements Comparator {
    float a;
    final /* synthetic */ Q b;

    public C0860ab(Q q, float f) {
        this.b = q;
        this.a = f;
    }

    public int compare(Object obj, Object obj2) {
        float f = 0.0f;
        UserInfo userInfo = (UserInfo) obj2;
        WeightInfo e = ah.a().e(((UserInfo) obj).uid);
        WeightInfo e2 = ah.a().e(userInfo.uid);
        float abs = e != null ? Math.abs(e.weight - this.a) : 0.0f;
        if (e2 != null) {
            f = Math.abs(Math.abs(e2.weight - this.a));
        }
        return new Float(abs).compareTo(new Float(f));
    }
}
