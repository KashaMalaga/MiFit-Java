package cn.com.smartdevices.bracelet.notification;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import java.io.File;

public class j {
    private final Context a;
    private final PackageManager b;
    private final ApplicationInfo c;
    private final File d;
    private String e;
    private Drawable f;
    private boolean g;

    public j(Context context, PackageManager packageManager, ApplicationInfo applicationInfo) {
        this.a = context;
        this.b = packageManager;
        this.c = applicationInfo;
        this.d = new File(applicationInfo.sourceDir);
    }

    void a() {
        if (this.e != null && this.g) {
            return;
        }
        if (this.d.exists()) {
            this.g = true;
            CharSequence loadLabel = this.c.loadLabel(this.b);
            this.e = loadLabel != null ? loadLabel.toString() : this.c.packageName;
            return;
        }
        this.g = false;
        this.e = this.c.packageName;
    }

    public String b() {
        return this.e;
    }

    public Drawable c() {
        if (this.f == null) {
            if (this.d.exists()) {
                this.f = this.c.loadIcon(this.b);
                return this.f;
            }
            this.g = false;
        } else if (this.g) {
            return this.f;
        } else {
            if (this.d.exists()) {
                this.g = true;
                this.f = this.c.loadIcon(this.b);
                return this.f;
            }
        }
        return this.a.getResources().getDrawable(17301651);
    }

    public String toString() {
        return this.e;
    }
}
