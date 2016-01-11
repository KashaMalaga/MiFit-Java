package com.g.a.c;

import android.os.AsyncTask;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import org.json.JSONObject;

class o extends AsyncTask<Void, Void, t> {
    String a;
    String b;
    p c;
    a[] d;

    public o(String[] strArr, p pVar, a[] aVarArr) {
        this.a = strArr[0];
        this.b = strArr[1];
        this.c = pVar;
        this.d = aVarArr;
    }

    protected t a(Void... voidArr) {
        try {
            JSONObject jSONObject = new JSONObject(TextUtils.isEmpty(this.b) ? s.a(this.a) : s.a(this.a, this.b));
            int optInt = jSONObject.optInt(SportBaseInfo.KEY_START_TIME);
            t tVar = new t(optInt == 0 ? u.t : optInt);
            String optString = jSONObject.optString(SocialConstants.PARAM_SEND_MSG);
            if (!TextUtils.isEmpty(optString)) {
                tVar.a(optString);
            }
            Object optString2 = jSONObject.optString(b.b);
            if (TextUtils.isEmpty(optString2)) {
                return tVar;
            }
            tVar.b(optString2);
            return tVar;
        } catch (Exception e) {
            return new t(-99, e);
        }
    }

    protected void a(t tVar) {
        if (this.c != null) {
            this.c.a(tVar, this.d);
        }
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((t) obj);
    }

    protected void onPreExecute() {
        if (this.c != null) {
            this.c.a();
        }
    }
}
