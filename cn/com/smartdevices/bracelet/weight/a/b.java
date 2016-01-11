package cn.com.smartdevices.bracelet.weight.a;

import cn.com.smartdevices.bracelet.i.a.i;
import cn.com.smartdevices.bracelet.j.f;
import com.d.a.a.O;

class b extends i<String, O> {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public O a(String str) {
        O a = f.a(this.a.c);
        a.a("jsondata", str);
        a.a(f.aa, 1);
        return a;
    }

    public /* synthetic */ Object wrap(Object obj) {
        return a((String) obj);
    }
}
