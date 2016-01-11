package cn.com.smartdevices.bracelet.gps.services;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.model.f;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeResult;

class ab implements OnGeocodeSearchListener {
    final /* synthetic */ ac a;
    final /* synthetic */ aa b;

    ab(aa aaVar, ac acVar) {
        this.b = aaVar;
        this.a = acVar;
    }

    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
    }

    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        if (i == 0) {
            if (regeocodeResult != null && regeocodeResult.getRegeocodeAddress() != null) {
                f fVar = new f();
                fVar.a = regeocodeResult.getRegeocodeAddress().getCity();
                this.b.D = fVar;
                if (TextUtils.isEmpty(fVar.a)) {
                    fVar.a = regeocodeResult.getRegeocodeAddress().getProvince();
                }
                fVar.b = regeocodeResult.getRegeocodeAddress().getDistrict();
                if (this.a != null) {
                    this.a.a(fVar);
                }
            }
        } else if (i == 27) {
            C0596r.d("SportSummary", "\u7f51\u7edc\u6545\u969c\uff0c\u65e0\u6cd5\u83b7\u53d6\u5730\u7406\u4f4d\u7f6e\u53cd\u7f16\u7801\u4fe1\u606f");
            if (this.a != null) {
                this.a.a(null);
            }
        } else {
            C0596r.d("SportSummary", "\u672a\u77e5\u9519\u8bef\uff0c\u65e0\u6cd5\u83b7\u53d6\u5730\u7406\u4f4d\u7f6e\u53cd\u7f16\u7801\u4fe1\u606f");
            if (this.a != null) {
                this.a.a(null);
            }
        }
    }
}
