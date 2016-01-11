package cn.com.smartdevices.bracelet.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.f.c;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import cn.com.smartdevices.bracelet.partner.Partner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C0425b extends C0424a {
    private static C0425b a = null;

    private C0425b(Context context) {
        super(context);
    }

    public static synchronized C0425b a(Context context) {
        C0425b c0425b;
        synchronized (C0425b.class) {
            if (a == null) {
                a = new C0425b(context);
                try {
                    a.a(false);
                } catch (Exception e) {
                    a.b();
                }
            }
            c0425b = a;
        }
        return c0425b;
    }

    public int a(String str, C0595q c0595q) {
        return y.a(a(false), str, c0595q);
    }

    public SQLiteDatabase a(boolean z) {
        return super.a(z);
    }

    public Partner a(String str) {
        return y.a(a(false), str);
    }

    public String a(String str, boolean z) {
        return TextUtils.isEmpty(str) ? null : y.a(a(false), str, z);
    }

    public ArrayList<HeartRateItem> a(int i) {
        return y.a(a(false), i);
    }

    public ArrayList<HeartRateItem> a(int i, int i2) {
        return y.a(a(false), i, i2);
    }

    public ArrayList<HeartRateItem> a(int i, long j, long j2) {
        return y.a(a(false), i, j, j2);
    }

    public ArrayList<BasicDateData> a(C0595q c0595q) {
        return y.a(a(false), c0595q);
    }

    public Map<String, String> a(String[] strArr) {
        return strArr == null ? new HashMap(0) : y.a(a(false), strArr);
    }

    public boolean a(long j) {
        return y.a(a(true), j);
    }

    public boolean a(BasicDateData basicDateData, int i, C0595q c0595q) {
        return y.a(a(true), basicDateData.date, basicDateData.data, c0595q, i, basicDateData.summary, basicDateData.indexs);
    }

    public boolean a(HeartRateItem heartRateItem) {
        return heartRateItem == null ? false : y.a(a(true), heartRateItem);
    }

    public boolean a(String str, int i, String str2) {
        return y.a(a(true), str, i, str2);
    }

    public boolean a(String str, String str2, c cVar) {
        return TextUtils.isEmpty(str) ? false : y.a(a(true), str, str2, cVar);
    }

    public boolean a(String str, String str2, C0595q c0595q) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : y.a(a(true), str, str2, c0595q);
    }

    public boolean a(String str, byte[] bArr, String str2, String str3, C0595q c0595q) {
        return a(str, bArr, str2, str3, c0595q, null, null);
    }

    public boolean a(String str, byte[] bArr, String str2, String str3, C0595q c0595q, byte[] bArr2, String str4) {
        return y.a(a(true), str, bArr, str2, str3, c0595q, bArr2, str4);
    }

    public boolean a(ArrayList<HeartRateItem> arrayList, int i) {
        return y.a(a(true), (ArrayList) arrayList, i);
    }

    public boolean a(ArrayList<BasicDateData> arrayList, int i, C0595q c0595q) {
        return (arrayList == null || arrayList.size() < 1) ? true : y.a(a(true), (List) arrayList, i, c0595q);
    }

    public boolean a(List<Partner> list) {
        return (list == null || list.isEmpty()) ? false : y.a(a(true), (List) list);
    }

    public boolean a(List<HeartRateItem> list, int i) {
        return (list == null || list.isEmpty()) ? false : y.a(a(true), (List) list, i);
    }

    public boolean a(String[] strArr, String[] strArr2) {
        if (strArr != null && !C0427d.a(strArr)) {
            return y.a(a(true), strArr, strArr2);
        }
        throw new IllegalArgumentException();
    }

    public boolean b(int i, long j, long j2) {
        return y.b(a(true), i, j, j2);
    }

    public boolean b(ArrayList<BasicDateData> arrayList, int i, C0595q c0595q) {
        return (arrayList == null || arrayList.size() < 1) ? true : y.b(a(true), (ArrayList) arrayList, i, c0595q);
    }

    public boolean b(List<HeartRateItem> list) {
        return a((List) list, 1);
    }

    public byte[] b(String str, C0595q c0595q) {
        return y.b(a(false), str, c0595q);
    }

    public byte[] c(String str, C0595q c0595q) {
        return y.c(a(false), str, c0595q);
    }

    public String[] c() {
        return y.a(a(false));
    }

    public void d() {
        a();
    }

    public byte[] d(String str, C0595q c0595q) {
        return y.d(a(false), str, c0595q);
    }

    public String e(String str, C0595q c0595q) {
        return y.e(a(false), str, c0595q);
    }

    public List<Partner> e() {
        return y.b(a(true));
    }

    public String f(String str, C0595q c0595q) {
        return y.a(a(false), str, c0595q, 1);
    }

    public boolean f() {
        return y.c(a(true));
    }

    public BasicDateData g(String str, C0595q c0595q) {
        return y.f(a(false), str, c0595q);
    }

    public SQLiteDatabase getReadableDatabase() {
        return super.a(false);
    }

    public SQLiteDatabase getWritableDatabase() {
        return super.a(true);
    }
}
