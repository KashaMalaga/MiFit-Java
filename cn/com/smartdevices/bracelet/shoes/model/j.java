package cn.com.smartdevices.bracelet.shoes.model;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;
import java.io.Serializable;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class j implements Serializable {
    private static final String a = "avatar";
    private static final String b = "life";
    private static final String p = "des";
    private static final String q = "name";
    private static final String r = "link";
    private static final String s = "full_name";
    private static final long serialVersionUID = 1;
    private static final String t = "image";
    private static final String u = "language";
    public String c = a.f;
    public String d = a.f;
    public String e = a.f;
    public int f = -1;
    public String g = a.f;
    public int h = 0;
    public String i = a.f;
    public String j = a.f;
    public String k = a.f;
    public String l = a.f;
    public String m = a.f;
    public String n = a.f;
    public long o = 0;
    private String v = null;

    public j(String str, int i) {
        this.e = str;
        this.f = i;
    }

    private boolean a(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                z = a(new JSONObject(str));
            } catch (Exception e) {
                C0596r.d("SOI", e.getMessage());
            }
        }
        return z;
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            if (!jSONObject.isNull(u)) {
                this.l = jSONObject.getString(u);
            }
            if (!jSONObject.isNull(a)) {
                this.c = jSONObject.getString(a);
            }
            if (!jSONObject.isNull(b)) {
                this.h = jSONObject.getInt(b);
            }
            if (!jSONObject.isNull(p)) {
                this.g = jSONObject.getString(p);
            }
            if (!jSONObject.isNull(q)) {
                this.i = jSONObject.getString(q);
            }
            if (!jSONObject.isNull(r)) {
                this.d = jSONObject.getString(r);
            }
            if (!jSONObject.isNull(s)) {
                this.j = jSONObject.getString(s);
            }
            if (!jSONObject.isNull(t)) {
                this.k = jSONObject.getString(t);
            }
            return true;
        } catch (Exception e) {
            C0596r.d("SOI", e.getMessage());
            return false;
        }
    }

    public void a(long j) {
        this.o = j;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return !TextUtils.isEmpty(this.e) && this.e.equals(jVar.e) && jVar.f == this.f;
    }

    public boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            C0596r.d("SOI", "parseJsonArraySummary is empty");
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 0) {
                C0596r.d("SOI", "parseJsonArraySummary is size 0");
                return false;
            }
            boolean z;
            CharSequence language = Locale.getDefault().getLanguage();
            CharSequence country = Locale.getDefault().getCountry();
            CharSequence language2 = Locale.CHINA.getLanguage();
            CharSequence country2 = Locale.CHINA.getCountry();
            if (TextUtils.isEmpty(language2)) {
                language2 = "zh";
            }
            if (TextUtils.isEmpty(country2)) {
                language2 = "CN";
            }
            int i = -1;
            String str2 = null;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (!jSONObject.isNull(u)) {
                    str2 = jSONObject.getString(u);
                }
                if (!TextUtils.isEmpty(str2) && str2.contains(r0) && str2.contains(country2)) {
                    i = i2;
                }
                if (!TextUtils.isEmpty(str2) && str2.contains(language) && str2.contains(country)) {
                    z = true;
                    a(jSONObject);
                    break;
                }
            }
            z = false;
            if (!z && i >= 0) {
                z = a(jSONArray.getJSONObject(i));
            }
            if (z) {
                return z;
            }
            C0596r.d("SOI", "parseJsonArraySummary isMatched = " + z);
            return z;
        } catch (Exception e) {
            C0596r.d("SOI", e.getMessage());
            return false;
        }
    }

    public boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean f = f(str);
        if (!f) {
            f = a(str);
        }
        if (f) {
            return f;
        }
        C0596r.d("SOI", "Failed to parseSummary");
        return f;
    }

    public void h(String str) {
        this.v = str;
    }

    public String l() {
        return this.v;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShoesOfficalInfo mBrand:").append(this.e).append(",mSubModel:").append(this.f).append(",mDescription:").append(this.g).append(",mUri:").append(this.c).append(",mSyncTime:").append(this.o).append(",language:").append(this.l);
        return stringBuilder.toString();
    }
}
