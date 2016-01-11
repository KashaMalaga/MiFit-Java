package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import java.io.File;
import java.util.List;

final class C0448g extends C0446e {
    final /* synthetic */ C0445d d;
    private int e = 0;
    private Context f = null;
    private List<Long> g = null;

    public C0448g(C0445d c0445d, Context context, int i) {
        this.d = c0445d;
        super(c0445d);
        this.e = i;
        this.f = context;
    }

    protected Void a(Void... voidArr) {
        if (this.g != null && this.g.size() > 0) {
            c();
        }
        return null;
    }

    public void a(List<Long> list) {
        this.g = list;
    }

    void c() {
        try {
            for (Long longValue : this.g) {
                long longValue2 = longValue.longValue();
                C0453l c = p.c(this.f, longValue2, this.e);
                if (c == null) {
                    C0596r.e("Track", "LoadContourTrackTask track is null trackId = " + longValue2);
                } else {
                    String d = c.d();
                    if (TextUtils.isEmpty(d) || !new File(d).exists()) {
                        String a = this.d.a(this.f, c);
                        if (TextUtils.isEmpty(a)) {
                            C0596r.e("Track", "LoadContourTrackTask newUri is null");
                        } else {
                            boolean a2 = p.a(this.f, longValue2, a);
                            if (!a2) {
                                C0596r.e("Track", "LoadContourTrackTask isSaved = " + a2 + ",trackId = " + longValue2 + ",newUri = " + a);
                            }
                            this.d.a(longValue2, a);
                        }
                    } else {
                        this.d.a(longValue2, d);
                        C0596r.e("Track", "LoadContourTrackTask existed oldUri = " + d + ",trackId = " + longValue2);
                    }
                }
            }
        } catch (Exception e) {
            C0596r.a("Track", e.getMessage());
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }
}
