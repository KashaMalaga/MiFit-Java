package cn.com.smartdevices.bracelet.shoes.sync.b;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.sync.B;
import com.xiaomi.e.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class j extends h {
    private ArrayList<String> a = null;
    private int d = -1;
    private String e = a.f;

    public j(String str) {
        this.e = str;
        this.a = new ArrayList();
    }

    public ArrayList<String> a() {
        return this.a;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length != 0) {
            this.a.ensureCapacity(length);
            String str = a.f;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!jSONObject.isNull(g.n)) {
                    str = jSONObject.getString(g.n);
                }
                if (TextUtils.isEmpty(str) || str.equals(this.e)) {
                    C0596r.d(B.a, "Found wrong result serverUUID = " + str + ",localUUID = " + this.e);
                } else if (!jSONObject.isNull(g.a)) {
                    this.a.add(jSONObject.getString(g.a));
                }
            }
        }
    }

    public int c() {
        return this.d;
    }
}
