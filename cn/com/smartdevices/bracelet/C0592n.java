package cn.com.smartdevices.bracelet;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;

class C0592n extends AsyncTask<Void, Void, UserTotalSportData> {
    final /* synthetic */ C0594p a;
    final /* synthetic */ C0591m b;

    C0592n(C0591m c0591m, C0594p c0594p) {
        this.b = c0591m;
        this.a = c0594p;
    }

    protected UserTotalSportData a(Void... voidArr) {
        return this.b.e(this.b.l());
    }

    protected void a(UserTotalSportData userTotalSportData) {
        super.onPostExecute(userTotalSportData);
        this.a.a(userTotalSportData);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((UserTotalSportData) obj);
    }
}
