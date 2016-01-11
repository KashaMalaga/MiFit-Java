package cn.com.smartdevices.bracelet.gps.services;

import android.os.AsyncTask;
import java.util.UUID;

abstract class C0446e extends AsyncTask<Void, Void, Void> {
    protected String a;
    protected boolean b;
    final /* synthetic */ C0445d c;

    public C0446e(C0445d c0445d) {
        this.c = c0445d;
        this.a = null;
        this.b = false;
        this.a = UUID.randomUUID().toString();
    }

    protected Void a(Void... voidArr) {
        return null;
    }

    public void a() {
        this.b = true;
        super.cancel(true);
    }

    protected void a(Void voidR) {
        this.c.d.remove(this.a);
    }

    protected String b() {
        return this.a;
    }

    protected void b(Void voidR) {
        this.c.d.remove(this.a);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onCancelled(Object obj) {
        a((Void) obj);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        b((Void) obj);
    }
}
