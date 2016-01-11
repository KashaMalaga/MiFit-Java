package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.l;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import java.util.ArrayList;

public class cg {
    private static final String a = "IntentReader";
    private Activity b;
    private Intent c;
    private String d;
    private ComponentName e;
    private ArrayList<Uri> f;

    private cg(Activity activity) {
        this.b = activity;
        this.c = activity.getIntent();
        this.d = ce.a(activity);
        this.e = ce.b(activity);
    }

    public static cg a(Activity activity) {
        return new cg(activity);
    }

    public Uri a(int i) {
        if (this.f == null && c()) {
            this.f = this.c.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        if (this.f != null) {
            return (Uri) this.f.get(i);
        }
        if (i == 0) {
            return (Uri) this.c.getParcelableExtra("android.intent.extra.STREAM");
        }
        throw new IndexOutOfBoundsException("Stream items available: " + h() + " index requested: " + i);
    }

    public boolean a() {
        String action = this.c.getAction();
        return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
    }

    public boolean b() {
        return "android.intent.action.SEND".equals(this.c.getAction());
    }

    public boolean c() {
        return "android.intent.action.SEND_MULTIPLE".equals(this.c.getAction());
    }

    public String d() {
        return this.c.getType();
    }

    public CharSequence e() {
        return this.c.getCharSequenceExtra("android.intent.extra.TEXT");
    }

    public String f() {
        String stringExtra = this.c.getStringExtra(l.e);
        if (stringExtra == null) {
            CharSequence e = e();
            if (e instanceof Spanned) {
                return Html.toHtml((Spanned) e);
            }
            if (e != null) {
                return ce.c.a(e);
            }
        }
        return stringExtra;
    }

    public Uri g() {
        return (Uri) this.c.getParcelableExtra("android.intent.extra.STREAM");
    }

    public int h() {
        if (this.f == null && c()) {
            this.f = this.c.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        return this.f != null ? this.f.size() : this.c.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
    }

    public String[] i() {
        return this.c.getStringArrayExtra("android.intent.extra.EMAIL");
    }

    public String[] j() {
        return this.c.getStringArrayExtra("android.intent.extra.CC");
    }

    public String[] k() {
        return this.c.getStringArrayExtra("android.intent.extra.BCC");
    }

    public String l() {
        return this.c.getStringExtra("android.intent.extra.SUBJECT");
    }

    public String m() {
        return this.d;
    }

    public ComponentName n() {
        return this.e;
    }

    public Drawable o() {
        Drawable drawable = null;
        if (this.e != null) {
            try {
                drawable = this.b.getPackageManager().getActivityIcon(this.e);
            } catch (Throwable e) {
                Log.e(a, "Could not retrieve icon for calling activity", e);
            }
        }
        return drawable;
    }

    public Drawable p() {
        Drawable drawable = null;
        if (this.d != null) {
            try {
                drawable = this.b.getPackageManager().getApplicationIcon(this.d);
            } catch (Throwable e) {
                Log.e(a, "Could not retrieve icon for calling application", e);
            }
        }
        return drawable;
    }

    public CharSequence q() {
        CharSequence charSequence = null;
        if (this.d != null) {
            PackageManager packageManager = this.b.getPackageManager();
            try {
                charSequence = packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.d, 0));
            } catch (Throwable e) {
                Log.e(a, "Could not retrieve label for calling application", e);
            }
        }
        return charSequence;
    }
}
