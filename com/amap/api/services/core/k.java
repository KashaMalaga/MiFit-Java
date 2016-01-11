package com.amap.api.services.core;

import com.amap.api.services.help.Tip;
import java.net.Proxy;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class k extends s<l, ArrayList<Tip>> {
    public k(l lVar, Proxy proxy) {
        super(lVar, proxy);
    }

    protected ArrayList<Tip> a(String str) {
        ArrayList<Tip> arrayList = null;
        try {
            arrayList = m.o(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&keywords=").append(strEncoder(((l) this.task).a, z));
        String str = ((l) this.task).b;
        if (!m.h(str)) {
            stringBuffer.append("&city=").append(strEncoder(str, z));
        }
        stringBuffer.append("&key=" + d.a(null).f());
        return e.f(stringBuffer.toString());
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/assistant/inputtips?";
    }

    protected /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
