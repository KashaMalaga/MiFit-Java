package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;

final class aB extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ Context a;

    aB(Context context) {
        this.a = context;
    }

    protected Void a(Void... voidArr) {
        aA.k = true;
        J.a().b(this.a, new aC(this));
        aA.k = false;
        return null;
    }

    protected void a(Void voidR) {
        if (Keeper.readPersonInfoBaseNeedSync().getNeedSyncServer() != 0) {
            Utils.a(this.a, Keeper.readPersonInfo());
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }
}
