package cn.com.smartdevices.bracelet.ui;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.heartrate.b;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.lab.sync.i;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import cn.com.smartdevices.bracelet.shoes.sync.J;
import cn.com.smartdevices.bracelet.weight.aA;
import com.xiaomi.hm.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

final class cU extends AsyncTask<Void, Integer, Boolean> {
    final /* synthetic */ cL a;

    private cU(cL cLVar) {
        this.a = cLVar;
    }

    protected Boolean a(Void... voidArr) {
        C0596r.d("PersonInfoFragment", "start doInBackground");
        if (Utils.l(this.a.getActivity())) {
            cX cXVar = new cX();
            C0595q c0595q = new C0595q();
            ArrayList a = C0591m.a().a(c0595q);
            if (a != null && a.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((BasicDateData) it.next()).toJSONObject());
                }
                l.b(a.f(this.a.getActivity()), a.d(this.a.getActivity()), c0595q, jSONArray.toString(), new cW(this, cXVar));
            }
            C0596r.d("PersonInfoFragment", "basic data result.mIsSucceeded = " + cXVar.a);
            cXVar.a &= b.a(this.a.getActivity()).b();
            C0596r.d("PersonInfoFragment", "heartrate data result.mIsSucceeded = " + cXVar.a);
            cXVar.a &= i.a(this.a.getActivity(), null);
            C0596r.d("PersonInfoFragment", "sport data result.mIsSucceeded = " + cXVar.a);
            cXVar.a &= J.b(this.a.getActivity());
            C0596r.d("PersonInfoFragment", "shoes data result.mIsSucceeded = " + cXVar.a);
            if (cn.com.smartdevices.bracelet.config.b.h().l.a.booleanValue()) {
                cXVar.a &= aA.a(this.a.getActivity());
                C0596r.d("PersonInfoFragment", "weight data result.mIsSucceeded = " + cXVar.a);
            }
            C0596r.d("PersonInfoFragment", "end doInBackground\uff0csucess:" + cXVar.a);
            return Boolean.valueOf(cXVar.a);
        }
        return Boolean.valueOf(!this.a.d());
    }

    public void a(Boolean bool) {
        C0596r.d("PersonInfoFragment", "onPostExecute");
        if (this.a.getActivity() != null) {
            this.a.f.postDelayed(new cV(this, bool), 1000);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    public void onCancelled() {
        Utils.a(this.a.getActivity());
    }

    public /* synthetic */ void onPostExecute(Object obj) {
        a((Boolean) obj);
    }

    public void onPreExecute() {
        super.onPreExecute();
        Utils.a(this.a.getActivity(), (int) R.string.sync_to_server, false);
        C0596r.d("PersonInfoFragment", "onPreExecute");
    }
}
