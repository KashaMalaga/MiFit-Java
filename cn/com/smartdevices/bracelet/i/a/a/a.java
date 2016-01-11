package cn.com.smartdevices.bracelet.i.a.a;

import cn.com.smartdevices.bracelet.i.a.g;
import cn.com.smartdevices.bracelet.j.d;
import com.d.a.a.O;
import com.d.a.a.h;

public class a extends g<Object, String> {
    private String a;

    public a(String str) {
        this.a = str;
    }

    public /* synthetic */ Object a(Object obj) {
        return b(obj);
    }

    public String b(Object obj) {
        c cVar = new c();
        h bVar = new b(this, cVar);
        if (obj instanceof O) {
            cn.com.smartdevices.bracelet.j.a.b(d.b, this.a, (O) obj, bVar);
        }
        return cVar.a;
    }
}
