package com.amap.api.mapcore.util;

import android.content.Context;
import com.xiaomi.market.sdk.o;
import java.util.List;

public class ar {
    private aj a = a(this.b);
    private Context b;

    public ar(Context context) {
        this.b = context;
    }

    private aj a(Context context) {
        try {
            return new aj(context);
        } catch (Throwable th) {
            az.a(th, "UpdateLogDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    public at a() {
        try {
            if (this.a == null) {
                this.a = a(this.b);
            }
            List c = this.a.c("1=1", new as());
            if (c.size() > 0) {
                return (at) c.get(0);
            }
        } catch (Throwable th) {
            az.a(th, "UpdateLogDB", "getUpdateLog");
            th.printStackTrace();
        }
        return null;
    }

    public void a(at atVar) {
        if (atVar != null) {
            try {
                if (this.a == null) {
                    this.a = a(this.b);
                }
                aq asVar = new as();
                asVar.a(atVar);
                String str = "1=1";
                List c = this.a.c(str, new as());
                if (c == null || c.size() == 0) {
                    this.a.a(asVar);
                } else {
                    this.a.b(str, asVar);
                }
            } catch (Throwable th) {
                az.a(th, "UpdateLogDB", o.C);
                th.printStackTrace();
            }
        }
    }
}
