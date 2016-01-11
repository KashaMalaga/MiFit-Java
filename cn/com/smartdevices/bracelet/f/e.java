package cn.com.smartdevices.bracelet.f;

public class e {
    private static e a = null;
    private boolean b = false;

    private e() {
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return this.b;
    }
}
