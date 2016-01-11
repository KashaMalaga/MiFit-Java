package cn.com.smartdevices.bracelet.shoes.sync.b;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.model.j;
import cn.com.smartdevices.bracelet.shoes.sync.B;
import com.xiaomi.e.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class l {
    public static final String a = "brand";
    public static final String b = "type";
    public static final String c = "summary";
    public static final String d = "sync_time";
    private ArrayList<j> e;
    private int f;

    public l() {
        this.e = null;
        this.f = -1;
        this.e = new ArrayList();
    }

    public List<j> a() {
        return this.e;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length != 0) {
            this.e.ensureCapacity(length);
            int i = -1;
            Object obj = null;
            String str = a.f;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (!jSONObject.isNull(a)) {
                    str = jSONObject.getString(a);
                }
                if (!jSONObject.isNull(b)) {
                    i = jSONObject.getInt(b);
                }
                if (TextUtils.isEmpty(str) || i <= 0) {
                    C0596r.d(B.a, "PARAM_SHOES_BRAND PARAM_SHOES_TYPE is gone");
                } else {
                    if (!jSONObject.isNull(c)) {
                        obj = jSONObject.getString(c);
                    }
                    if (TextUtils.isEmpty(obj)) {
                        C0596r.d(B.a, "PARAM_SUMMARY is gone brand:" + str + ",model:" + i);
                    } else {
                        j jVar = new j(str, i);
                        jVar.h(obj);
                        if (!jSONObject.isNull(d)) {
                            jVar.o = jSONObject.getLong(d);
                        }
                        this.e.add(jVar);
                    }
                }
            }
        }
    }

    public int b() {
        return this.f;
    }
}
