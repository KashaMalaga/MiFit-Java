package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class R {
    public static final int a = 1;

    public static void a(boolean z) {
        U.b = z;
    }

    public abstract SavedState a(Fragment fragment);

    public abstract Fragment a(int i);

    public abstract Fragment a(Bundle bundle, String str);

    public abstract Fragment a(String str);

    public abstract aj a();

    public abstract void a(int i, int i2);

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public abstract void a(T t);

    public abstract void a(String str, int i);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract S b(int i);

    @Deprecated
    public aj b() {
        return a();
    }

    public abstract void b(T t);

    public abstract boolean b(int i, int i2);

    public abstract boolean b(String str, int i);

    public abstract boolean c();

    public abstract void d();

    public abstract boolean e();

    public abstract int f();

    public abstract List<Fragment> g();

    public abstract boolean h();
}
