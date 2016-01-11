package com.amap.api.services.district;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.d;
import com.amap.api.services.core.e;
import com.amap.api.services.core.f;
import java.util.HashMap;

public class DistrictSearch {
    private static HashMap<Integer, DistrictResult> g;
    Handler a = new c(this);
    private Context b;
    private DistrictSearchQuery c;
    private OnDistrictSearchListener d;
    private DistrictSearchQuery e;
    private int f;

    public interface OnDistrictSearchListener {
        void onDistrictSearched(DistrictResult districtResult);
    }

    public DistrictSearch(Context context) {
        d.a(context);
        this.b = context.getApplicationContext();
    }

    private void a(DistrictResult districtResult) {
        g = new HashMap();
        if (this.c != null && districtResult != null && this.f > 0 && this.f > this.c.getPageNum()) {
            g.put(Integer.valueOf(this.c.getPageNum()), districtResult);
        }
    }

    private boolean a() {
        return this.c != null;
    }

    private boolean a(int i) {
        return i < this.f && i >= 0;
    }

    private DistrictResult b() {
        DistrictResult districtResult = new DistrictResult();
        if (!a()) {
            this.c = new DistrictSearchQuery();
        }
        districtResult.setQuery(this.c.clone());
        if (!this.c.weakEquals(this.e)) {
            this.f = 0;
            this.e = this.c.clone();
            if (g != null) {
                g.clear();
            }
        }
        if (this.f == 0) {
            districtResult = (DistrictResult) new f(this.c.clone(), e.a(this.b)).getData();
            if (districtResult == null) {
                return null;
            }
            this.f = districtResult.getPageCount();
            a(districtResult);
            return districtResult;
        }
        districtResult = getPageLocal(this.c.getPageNum());
        if (districtResult != null) {
            return districtResult;
        }
        districtResult = (DistrictResult) new f(this.c.clone(), e.a(this.b)).getData();
        if (this.c == null || districtResult == null) {
            return null;
        }
        if (this.f <= 0 || this.f <= this.c.getPageNum()) {
            return districtResult;
        }
        g.put(Integer.valueOf(this.c.getPageNum()), districtResult);
        return districtResult;
    }

    protected DistrictResult getPageLocal(int i) {
        if (a(i)) {
            return (DistrictResult) g.get(Integer.valueOf(i));
        }
        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
    }

    public DistrictSearchQuery getQuery() {
        return this.c;
    }

    public void searchDistrictAnsy() {
        new Thread(this) {
            final /* synthetic */ DistrictSearch a;

            {
                this.a = r1;
            }

            public void run() {
                Message message = new Message();
                Object districtResult = new DistrictResult();
                districtResult.setQuery(this.a.c);
                try {
                    districtResult = this.a.b();
                    districtResult.setAMapException(new AMapException());
                } catch (AMapException e) {
                    districtResult.setAMapException(e);
                } finally {
                    message.obj = districtResult;
                    this.a.a.sendMessage(message);
                }
            }
        }.start();
    }

    public void setOnDistrictSearchListener(OnDistrictSearchListener onDistrictSearchListener) {
        this.d = onDistrictSearchListener;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.c = districtSearchQuery;
    }
}
