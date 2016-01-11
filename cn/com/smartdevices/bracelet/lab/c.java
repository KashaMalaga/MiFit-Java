package cn.com.smartdevices.bracelet.lab;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;

public class c {
    public static final String a = "ropeSkippingBestRecord";
    public static final String b = "sitUpBestRecord";
    public static final String c = "sportRhythmTone";
    public static final String d = "sportRhythmPitchTone";
    public static final String e = "sportRhythmNewPBTone";
    public static final String f = "isUserConfirmAutoCounter";
    private static final String h = "PersonalLabRecord";
    private SharedPreferences g = null;

    public c(Context context) {
        this.g = context.getSharedPreferences(h, 0);
    }

    public Uri a() {
        Object string = this.g.getString(e, null);
        return TextUtils.isEmpty(string) ? null : Uri.parse(string);
    }

    public boolean a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        Editor edit = this.g.edit();
        edit.putInt(a, i);
        return edit.commit();
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        Editor edit = this.g.edit();
        edit.putString(c, uri.toString());
        return edit.commit();
    }

    public Uri b() {
        Object string = this.g.getString(c, null);
        return TextUtils.isEmpty(string) ? null : Uri.parse(string);
    }

    public boolean b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        Editor edit = this.g.edit();
        edit.putInt(b, i);
        return edit.commit();
    }

    public boolean b(Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        Editor edit = this.g.edit();
        edit.putString(d, uri.toString());
        return edit.commit();
    }

    public Uri c() {
        Object string = this.g.getString(d, null);
        return TextUtils.isEmpty(string) ? null : Uri.parse(string);
    }

    public boolean c(Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        Editor edit = this.g.edit();
        edit.putString(e, uri.toString());
        return edit.commit();
    }

    public int d() {
        return this.g.getInt(a, 0);
    }

    public int e() {
        return this.g.getInt(b, 0);
    }

    public boolean f() {
        return this.g.getBoolean(f, false);
    }

    public boolean g() {
        Editor edit = this.g.edit();
        edit.putBoolean(f, true);
        return edit.commit();
    }
}
