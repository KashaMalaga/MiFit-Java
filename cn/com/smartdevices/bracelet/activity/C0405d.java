package cn.com.smartdevices.bracelet.activity;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.config.b;
import com.sina.weibo.sdk.exception.WeiboAuthException;

class C0405d extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ LoginActivity a;

    C0405d(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    protected Void a(Void... voidArr) {
        if (b.h().l.a.booleanValue()) {
            Utils.a(this.a.p.getApplicationContext(), WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, System.currentTimeMillis() / 1000, new C0406e(this));
        }
        return null;
    }

    protected void a(Void voidR) {
        super.onPostExecute(voidR);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }
}
