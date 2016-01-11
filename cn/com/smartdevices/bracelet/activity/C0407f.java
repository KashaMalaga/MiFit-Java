package cn.com.smartdevices.bracelet.activity;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.account.openauth.i;

class C0407f extends AsyncTask<Void, Void, V> {
    Exception a;
    final /* synthetic */ i b;
    final /* synthetic */ u c;
    final /* synthetic */ LoginActivity d;

    C0407f(LoginActivity loginActivity, i iVar, u uVar) {
        this.d = loginActivity;
        this.b = iVar;
        this.c = uVar;
    }

    protected V a(Void... voidArr) {
        V v = null;
        try {
            v = this.b.a();
        } catch (Exception e) {
            this.a = e;
        } catch (Exception e2) {
            this.a = e2;
        } catch (Exception e22) {
            this.a = e22;
        }
        return v;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected void onPostExecute(V v) {
        if (this.c != null && v != null) {
            this.c.a(v);
        } else if (this.a != null) {
            C0596r.d(C0401a.cc, this.b + "done and ... get no result :( error = " + this.a.toString());
            this.d.l();
        } else {
            C0596r.d(C0401a.cc, this.b + "done and ... get no result :(");
            this.d.i();
        }
    }

    protected void onPreExecute() {
        C0596r.e(C0401a.cc, "waiting for Future result...");
    }
}
