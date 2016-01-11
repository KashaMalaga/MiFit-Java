package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;

public class ao {
    private aj a = a(this.b);
    private Context b;

    public ao(Context context) {
        this.b = context;
    }

    private aj a(Context context) {
        try {
            return new aj(context);
        } catch (Throwable th) {
            az.a(th, "SDKDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    public List<ad> a() {
        List<ad> list = null;
        try {
            aq apVar = new ap();
            list = this.a.c(ap.c(), apVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return list;
    }

    public void a(ad adVar) {
        if (adVar != null) {
            try {
                if (this.a == null) {
                    this.a = a(this.b);
                }
                aq apVar = new ap();
                apVar.a(adVar);
                String a = ap.a(adVar.a());
                List c = this.a.c(a, new ap());
                if (c == null || c.size() == 0) {
                    this.a.a(apVar);
                } else {
                    this.a.b(a, apVar);
                }
            } catch (Throwable th) {
                az.a(th, "SDKDB", "insert");
                th.printStackTrace();
            }
        }
    }
}
