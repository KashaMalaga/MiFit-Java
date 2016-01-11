package com.xiaomi.mistatistic.sdk.b;

import com.xiaomi.e.a;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

class x implements p {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public void a() {
        if (this.a.a.c()) {
            try {
                List b = this.a.a.b();
                int size = b.size();
                int i = 0;
                while (i < size) {
                    Collection subList = i + 30 >= size ? b.subList(i, size) : b.subList(i, i + 30);
                    if (this.a.a.a((List) subList)) {
                        synchronized (this.a.a.c) {
                            this.a.a.c.removeAll(subList);
                        }
                    }
                    i += 30;
                }
            } catch (Throwable e) {
                new A().a(a.f, e);
            } catch (Throwable e2) {
                new A().a(a.f, e2);
            }
        } else if (this.a.a.d()) {
            try {
                this.a.a.a(new JSONArray().toString());
            } catch (Throwable e22) {
                new A().a(a.f, e22);
            } catch (Throwable e222) {
                new A().a(a.f, e222);
            }
        }
    }
}
