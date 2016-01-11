package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.c;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class cp implements Iterable<Intent> {
    private static final String a = "TaskStackBuilder";
    private static final cr b;
    private final ArrayList<Intent> c = new ArrayList();
    private final Context d;

    static {
        if (VERSION.SDK_INT >= 11) {
            b = new ct();
        } else {
            b = new cs();
        }
    }

    private cp(Context context) {
        this.d = context;
    }

    public static cp a(Context context) {
        return new cp(context);
    }

    public static cp b(Context context) {
        return a(context);
    }

    public int a() {
        return this.c.size();
    }

    public PendingIntent a(int i, int i2) {
        return a(i, i2, null);
    }

    public PendingIntent a(int i, int i2, Bundle bundle) {
        if (this.c.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) this.c.toArray(new Intent[this.c.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return b.a(this.d, intentArr, i, i2, bundle);
    }

    public Intent a(int i) {
        return b(i);
    }

    public cp a(Activity activity) {
        Intent intent = null;
        if (activity instanceof cq) {
            intent = ((cq) activity).a();
        }
        Intent b = intent == null ? aC.b(activity) : intent;
        if (b != null) {
            ComponentName component = b.getComponent();
            if (component == null) {
                component = b.resolveActivity(this.d.getPackageManager());
            }
            a(component);
            a(b);
        }
        return this;
    }

    public cp a(ComponentName componentName) {
        int size = this.c.size();
        try {
            Intent a = aC.a(this.d, componentName);
            while (a != null) {
                this.c.add(size, a);
                a = aC.a(this.d, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e(a, "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public cp a(Intent intent) {
        this.c.add(intent);
        return this;
    }

    public cp a(Class<?> cls) {
        return a(new ComponentName(this.d, cls));
    }

    public void a(Bundle bundle) {
        if (this.c.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.c.toArray(new Intent[this.c.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!c.a(this.d, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.d.startActivity(intent);
        }
    }

    public Intent b(int i) {
        return (Intent) this.c.get(i);
    }

    public cp b(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.d.getPackageManager());
        }
        if (component != null) {
            a(component);
        }
        a(intent);
        return this;
    }

    public void b() {
        a(null);
    }

    public Intent[] c() {
        Intent[] intentArr = new Intent[this.c.size()];
        if (intentArr.length == 0) {
            return intentArr;
        }
        intentArr[0] = new Intent((Intent) this.c.get(0)).addFlags(268484608);
        for (int i = 1; i < intentArr.length; i++) {
            intentArr[i] = new Intent((Intent) this.c.get(i));
        }
        return intentArr;
    }

    public Iterator<Intent> iterator() {
        return this.c.iterator();
    }
}
