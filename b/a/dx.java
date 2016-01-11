package b.a;

import android.content.Context;
import com.g.a.b.b;
import com.g.a.b.f;
import com.g.a.z;

public final class dx implements dE {
    private static dx c;
    private dE a = new dw(this.b);
    private Context b;

    private dx(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized dx a(Context context) {
        dx dxVar;
        synchronized (dx.class) {
            if (c == null && context != null) {
                c = new dx(context);
            }
            dxVar = c;
        }
        return dxVar;
    }

    public void a() {
        z.b(new dz(this));
    }

    public void a(dE dEVar) {
        this.a = dEVar;
    }

    public void a(dF dFVar) {
        z.b(new dy(this, dFVar));
    }

    public void a(b bVar) {
        if (bVar != null && this.a != null) {
            bVar.a((f) this.a);
        }
    }

    public void b() {
        z.b(new dA(this));
    }

    public void b(dF dFVar) {
        this.a.b(dFVar);
    }
}
