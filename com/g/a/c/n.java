package com.g.a.c;

import android.content.Context;
import android.util.Log;
import com.g.a.p;
import com.xiaomi.e.a;

public abstract class n {
    private static void a(Context context, p pVar, String str, a... aVarArr) {
        int i = 0;
        if (aVarArr != null) {
            try {
                int length = aVarArr.length;
                while (i < length) {
                    if (aVarArr[i].f()) {
                        i++;
                    } else {
                        throw new q("parameter is not valid.");
                    }
                }
            } catch (Throwable e) {
                Log.e(p.e, "unable send event.", e);
                return;
            } catch (Throwable e2) {
                Log.e(p.e, a.f, e2);
                return;
            }
        }
        new o(v.a(context, str, aVarArr), pVar, aVarArr).execute(new Void[0]);
    }

    public static void a(Context context, String str, a... aVarArr) {
        a(context, null, str, aVarArr);
    }

    public static void a(Context context, a... aVarArr) {
        a(context, null, null, aVarArr);
    }
}
