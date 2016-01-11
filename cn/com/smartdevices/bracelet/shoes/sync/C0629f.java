package cn.com.smartdevices.bracelet.shoes.sync;

import java.util.Set;

final class C0629f {
    public boolean a = false;
    public Set<String> b = null;

    public C0629f(boolean z, Set<String> set) {
        this.a = z;
        this.b = set;
    }

    public void a() {
        if (this.b != null) {
            this.b.clear();
        }
    }

    public boolean b() {
        return this.b != null && this.b.size() > 0;
    }
}
