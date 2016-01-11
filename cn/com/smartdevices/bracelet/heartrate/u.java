package cn.com.smartdevices.bracelet.heartrate;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import java.util.ArrayList;

class u extends AsyncTask<Void, Void, ArrayList<HeartRateItem>> {
    final /* synthetic */ HeartRateMainActivity a;

    u(HeartRateMainActivity heartRateMainActivity) {
        this.a = heartRateMainActivity;
    }

    protected ArrayList<HeartRateItem> a(Void... voidArr) {
        return this.a.y.b(2, 100);
    }

    protected void a(ArrayList<HeartRateItem> arrayList) {
        this.a.a((ArrayList) arrayList);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((ArrayList) obj);
    }
}
