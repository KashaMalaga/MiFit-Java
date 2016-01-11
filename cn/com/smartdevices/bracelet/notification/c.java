package cn.com.smartdevices.bracelet.notification;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import java.io.File;

public class c {
    private final f a;
    private final ApplicationInfo b;
    private final File c;
    private String d;
    private Drawable e;
    private boolean f;
    private boolean g;

    public c(f fVar, ApplicationInfo applicationInfo) {
        this.a = fVar;
        this.b = applicationInfo;
        this.c = new File(applicationInfo.sourceDir);
    }

    public ApplicationInfo a() {
        return this.b;
    }

    void a(Context context) {
        if (this.d != null && this.f) {
            return;
        }
        if (this.c.exists()) {
            this.f = true;
            CharSequence loadLabel = this.b.loadLabel(context.getPackageManager());
            this.d = loadLabel != null ? loadLabel.toString() : this.b.packageName;
            return;
        }
        this.f = false;
        this.d = this.b.packageName;
    }

    public String b() {
        return this.d;
    }

    public boolean c() {
        return this.g;
    }

    public Drawable d() {
        if (this.e == null) {
            if (this.c.exists()) {
                this.e = this.b.loadIcon(this.a.b);
                return this.e;
            }
            this.f = false;
        } else if (this.f) {
            return this.e;
        } else {
            if (this.c.exists()) {
                this.f = true;
                this.e = this.b.loadIcon(this.a.b);
                return this.e;
            }
        }
        return this.a.getContext().getResources().getDrawable(17301651);
    }

    public String toString() {
        return this.d;
    }
}
