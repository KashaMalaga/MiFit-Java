package com.b;

import com.amap.api.services.district.DistrictSearchQuery;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class ad extends DefaultHandler {
    public M a;
    private String b;

    private ad() {
        this.a = new M();
        this.b = a.f;
    }

    public void characters(char[] cArr, int i, int i2) {
        this.b = String.valueOf(cArr, i, i2);
    }

    public void endElement(String str, String str2, String str3) {
        if (str2.equals("retype")) {
            this.a.h(this.b);
        } else if (str2.equals("adcode")) {
            this.a.k(this.b);
        } else if (str2.equals("citycode")) {
            this.a.i(this.b);
        } else if (str2.equals("radius")) {
            try {
                this.a.a(Float.valueOf(this.b).floatValue());
            } catch (Throwable th) {
                th.printStackTrace();
                ao.a(th);
                this.a.a(3891.0f);
            }
        } else if (str2.equals("cenx")) {
            try {
                this.b = ak.a(Double.valueOf(this.b), "#.000000");
                this.a.a(Double.valueOf(this.b).doubleValue());
            } catch (Throwable th2) {
                th2.printStackTrace();
                ao.a(th2);
                this.a.a(0.0d);
            }
        } else if (str2.equals("ceny")) {
            try {
                this.b = ak.a(Double.valueOf(this.b), "#.000000");
                this.a.b(Double.valueOf(this.b).doubleValue());
            } catch (Throwable th22) {
                th22.printStackTrace();
                ao.a(th22);
                this.a.b(0.0d);
            }
        } else if (str2.equals(SocialConstants.PARAM_APP_DESC)) {
            this.a.j(this.b);
        } else if (str2.equals(DistrictSearchQuery.KEYWORDS_COUNTRY)) {
            this.a.l(this.b);
        } else if (str2.equals(DistrictSearchQuery.KEYWORDS_PROVINCE)) {
            this.a.m(this.b);
        } else if (str2.equals(DistrictSearchQuery.KEYWORDS_CITY)) {
            this.a.n(this.b);
        } else if (str2.equals("road")) {
            this.a.o(this.b);
        } else if (str2.equals("street")) {
            this.a.p(this.b);
        } else if (str2.equals(ParamKey.POINAME)) {
            this.a.q(this.b);
        } else if (str2.equals("BIZ")) {
            if (this.a.t() == null) {
                this.a.a(new JSONObject());
            }
            try {
                this.a.t().put("BIZ", this.b);
            } catch (Throwable th222) {
                th222.printStackTrace();
            }
        } else if (str2.equals("flr")) {
            this.a.b(this.b);
        } else if (str2.equals("pid")) {
            this.a.a(this.b);
        } else if (str2.equals("apiTime")) {
            try {
                if (!a.f.equals(this.b)) {
                    this.a.a(Long.parseLong(this.b));
                }
            } catch (Throwable th2222) {
                th2222.printStackTrace();
                ao.a(th2222);
                this.a.a(ao.a());
            }
        } else if (str2.equals("coord")) {
            try {
                this.a.d(this.b);
            } catch (Throwable th22222) {
                th22222.printStackTrace();
                ao.a(th22222);
            }
        } else if (str2.equals("mcell")) {
            try {
                this.a.e(this.b);
            } catch (Throwable th222222) {
                th222222.printStackTrace();
                ao.a(th222222);
            }
        } else if (str2.equals(DistrictSearchQuery.KEYWORDS_DISTRICT)) {
            try {
                this.a.c(this.b);
            } catch (Throwable th2222222) {
                th2222222.printStackTrace();
                ao.a(th2222222);
            }
        }
        if (this.a.t() == null) {
            this.a.a(new JSONObject());
        }
        try {
            if (str2.equals("eab")) {
                this.a.t().put(str2, this.b);
            } else if (str2.equals("ctl")) {
                this.a.t().put(str2, this.b);
            } else if (str2.equals("suc")) {
                this.a.t().put(str2, this.b);
            } else if (str2.equals("spa")) {
                this.a.t().put(str2, this.b);
            }
        } catch (Throwable th22222222) {
            th22222222.printStackTrace();
        }
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.b = a.f;
    }
}
