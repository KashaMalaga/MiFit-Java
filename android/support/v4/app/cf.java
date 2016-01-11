package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.content.l;
import android.support.v4.view.a.C0099a;
import android.text.Html;
import java.util.ArrayList;

public class cf {
    private Activity a;
    private Intent b = new Intent().setAction("android.intent.action.SEND");
    private CharSequence c;
    private ArrayList<String> d;
    private ArrayList<String> e;
    private ArrayList<String> f;
    private ArrayList<Uri> g;

    private cf(Activity activity) {
        this.a = activity;
        this.b.putExtra(ce.a, activity.getPackageName());
        this.b.putExtra(ce.b, activity.getComponentName());
        this.b.addFlags(C0099a.m);
    }

    public static cf a(Activity activity) {
        return new cf(activity);
    }

    private void a(String str, ArrayList<String> arrayList) {
        Object stringArrayExtra = this.b.getStringArrayExtra(str);
        int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
        Object obj = new String[(arrayList.size() + length)];
        arrayList.toArray(obj);
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, obj, arrayList.size(), length);
        }
        this.b.putExtra(str, obj);
    }

    private void a(String str, String[] strArr) {
        Intent a = a();
        Object stringArrayExtra = a.getStringArrayExtra(str);
        int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
        Object obj = new String[(strArr.length + length)];
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, obj, 0, length);
        }
        System.arraycopy(strArr, 0, obj, length, strArr.length);
        a.putExtra(str, obj);
    }

    public Intent a() {
        if (this.d != null) {
            a("android.intent.extra.EMAIL", this.d);
            this.d = null;
        }
        if (this.e != null) {
            a("android.intent.extra.CC", this.e);
            this.e = null;
        }
        if (this.f != null) {
            a("android.intent.extra.BCC", this.f);
            this.f = null;
        }
        int i = (this.g == null || this.g.size() <= 1) ? 0 : 1;
        boolean equals = this.b.getAction().equals("android.intent.action.SEND_MULTIPLE");
        if (i == 0 && equals) {
            this.b.setAction("android.intent.action.SEND");
            if (this.g == null || this.g.isEmpty()) {
                this.b.removeExtra("android.intent.extra.STREAM");
            } else {
                this.b.putExtra("android.intent.extra.STREAM", (Parcelable) this.g.get(0));
            }
            this.g = null;
        }
        if (!(i == 0 || equals)) {
            this.b.setAction("android.intent.action.SEND_MULTIPLE");
            if (this.g == null || this.g.isEmpty()) {
                this.b.removeExtra("android.intent.extra.STREAM");
            } else {
                this.b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.g);
            }
        }
        return this.b;
    }

    public cf a(int i) {
        return a(this.a.getText(i));
    }

    public cf a(Uri uri) {
        if (!this.b.getAction().equals("android.intent.action.SEND")) {
            this.b.setAction("android.intent.action.SEND");
        }
        this.g = null;
        this.b.putExtra("android.intent.extra.STREAM", uri);
        return this;
    }

    public cf a(CharSequence charSequence) {
        this.c = charSequence;
        return this;
    }

    public cf a(String str) {
        this.b.setType(str);
        return this;
    }

    public cf a(String[] strArr) {
        if (this.d != null) {
            this.d = null;
        }
        this.b.putExtra("android.intent.extra.EMAIL", strArr);
        return this;
    }

    Activity b() {
        return this.a;
    }

    public cf b(Uri uri) {
        Uri uri2 = (Uri) this.b.getParcelableExtra("android.intent.extra.STREAM");
        if (uri2 == null) {
            return a(uri);
        }
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (uri2 != null) {
            this.b.removeExtra("android.intent.extra.STREAM");
            this.g.add(uri2);
        }
        this.g.add(uri);
        return this;
    }

    public cf b(CharSequence charSequence) {
        this.b.putExtra("android.intent.extra.TEXT", charSequence);
        return this;
    }

    public cf b(String str) {
        this.b.putExtra(l.e, str);
        if (!this.b.hasExtra("android.intent.extra.TEXT")) {
            b(Html.fromHtml(str));
        }
        return this;
    }

    public cf b(String[] strArr) {
        a("android.intent.extra.EMAIL", strArr);
        return this;
    }

    public Intent c() {
        return Intent.createChooser(a(), this.c);
    }

    public cf c(String str) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(str);
        return this;
    }

    public cf c(String[] strArr) {
        this.b.putExtra("android.intent.extra.CC", strArr);
        return this;
    }

    public cf d(String str) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(str);
        return this;
    }

    public cf d(String[] strArr) {
        a("android.intent.extra.CC", strArr);
        return this;
    }

    public void d() {
        this.a.startActivity(c());
    }

    public cf e(String str) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(str);
        return this;
    }

    public cf e(String[] strArr) {
        this.b.putExtra("android.intent.extra.BCC", strArr);
        return this;
    }

    public cf f(String str) {
        this.b.putExtra("android.intent.extra.SUBJECT", str);
        return this;
    }

    public cf f(String[] strArr) {
        a("android.intent.extra.BCC", strArr);
        return this;
    }
}
