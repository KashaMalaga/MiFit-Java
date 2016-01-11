package b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.g.a.p;
import com.xiaomi.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class dP {
    private static final String a = "activities";
    private final Map<String, Long> b = new HashMap();
    private final ArrayList<dN> c = new ArrayList();

    public static List<aW> a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(a, a.f);
        if (a.f.equals(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            String[] split = string.split(";");
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new C0380f(str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList.size() > 0 ? arrayList : null;
    }

    public void a() {
        synchronized (this.b) {
            String str = null;
            long j = 0;
            for (Entry entry : this.b.entrySet()) {
                if (((Long) entry.getValue()).longValue() > j) {
                    j = ((Long) entry.getValue()).longValue();
                    str = (String) entry.getKey();
                }
            }
        }
        if (str != null) {
            b(str);
        }
    }

    public void a(Context context) {
        SharedPreferences a = C0366dK.a(context);
        Editor edit = a.edit();
        if (this.c.size() > 0) {
            Object string = a.getString(a, a.f);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(string)) {
                stringBuilder.append(string);
                stringBuilder.append(";");
            }
            synchronized (this.c) {
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    dN dNVar = (dN) it.next();
                    stringBuilder.append(String.format("[\"%s\",%d]", new Object[]{dNVar.a, Long.valueOf(dNVar.b)}));
                    stringBuilder.append(";");
                }
                this.c.clear();
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            edit.remove(a);
            edit.putString(a, stringBuilder.toString());
        }
        edit.commit();
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.b) {
                this.b.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Long l;
            synchronized (this.b) {
                l = (Long) this.b.remove(str);
            }
            if (l == null) {
                bX.e(p.e, String.format("please call 'onPageStart(%s)' before onPageEnd", new Object[]{str}));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - l.longValue();
            synchronized (this.c) {
                this.c.add(new dN(str, currentTimeMillis));
            }
        }
    }
}
