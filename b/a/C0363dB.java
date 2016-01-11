package b.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class C0363dB {
    private final String a = "umeng_event_snapshot";
    private boolean b = false;
    private SharedPreferences c;
    private Map<String, ArrayList<C0308b>> d = new HashMap();

    public C0363dB(Context context) {
        this.c = C0366dK.a(context, "umeng_event_snapshot");
    }

    private void c(String str) {
        String str2 = null;
        if (this.d.containsKey(str)) {
            Serializable serializable = (ArrayList) this.d.get(str);
            while (serializable.size() > 4) {
                serializable.remove(0);
            }
            str2 = C0364dI.a(serializable);
        }
        this.c.edit().putString(str, str2).commit();
    }

    private boolean d(String str) {
        if (this.d.containsKey(str)) {
            return true;
        }
        String string = this.c.getString(str, null);
        if (string != null) {
            ArrayList arrayList = (ArrayList) C0364dI.a(string);
            if (arrayList != null) {
                this.d.put(str, arrayList);
                return true;
            }
        }
        return false;
    }

    public int a(String str) {
        return this.d.containsKey(str) ? ((ArrayList) this.d.get(str)).size() : 0;
    }

    public void a(String str, C0308b c0308b) {
        if (this.b) {
            d(str);
        }
        if (this.d.containsKey(str)) {
            ((ArrayList) this.d.get(str)).add(c0308b);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(c0308b);
            this.d.put(str, arrayList);
        }
        if (this.b) {
            c(str);
        }
    }

    public void a(boolean z) {
        this.b = z;
    }

    public C0308b b(String str) {
        C0308b c0308b;
        if (this.b) {
            d(str);
        }
        if (this.d.containsKey(str)) {
            ArrayList arrayList = (ArrayList) this.d.get(str);
            if (arrayList.size() > 0) {
                c0308b = (C0308b) arrayList.remove(arrayList.size() - 1);
                if (this.b) {
                    c(str);
                }
                return c0308b;
            }
        }
        c0308b = null;
        if (this.b) {
            c(str);
        }
        return c0308b;
    }
}
