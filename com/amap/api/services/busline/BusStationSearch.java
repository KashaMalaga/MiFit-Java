package com.amap.api.services.busline;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.c;
import com.amap.api.services.core.d;
import com.amap.api.services.core.e;
import java.util.ArrayList;

public class BusStationSearch {
    Handler a = new d(this);
    private Context b;
    private OnBusStationSearchListener c;
    private BusStationQuery d;
    private BusStationQuery e;
    private ArrayList<BusStationResult> f;
    private int g;

    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult busStationResult, int i);
    }

    public BusStationSearch(Context context, BusStationQuery busStationQuery) {
        d.a(context);
        this.b = context.getApplicationContext();
        this.d = busStationQuery;
    }

    private void a(BusStationResult busStationResult) {
        this.f = new ArrayList();
        for (int i = 0; i <= this.g; i++) {
            this.f.add(null);
        }
        if (this.g > 0) {
            this.f.set(this.d.getPageNumber(), busStationResult);
        }
    }

    private boolean a(int i) {
        return i <= this.g && i >= 0;
    }

    private BusStationResult b(int i) {
        if (a(i)) {
            return (BusStationResult) this.f.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    public BusStationQuery getQuery() {
        return this.d;
    }

    public BusStationResult searchBusStation() {
        if (!this.d.weakEquals(this.e)) {
            this.e = this.d.clone();
            this.g = 0;
            if (this.f != null) {
                this.f.clear();
            }
        }
        if (this.g == 0) {
            c cVar = new c(this.d, e.a(this.b));
            BusStationResult a = BusStationResult.a(cVar, (ArrayList) cVar.getData());
            this.g = a.getPageCount();
            a(a);
            return a;
        }
        a = b(this.d.getPageNumber());
        if (a != null) {
            return a;
        }
        cVar = new c(this.d, e.a(this.b));
        a = BusStationResult.a(cVar, (ArrayList) cVar.getData());
        this.f.set(this.d.getPageNumber(), a);
        return a;
    }

    public void searchBusStationAsyn() {
        new Thread(new Runnable(this) {
            final /* synthetic */ BusStationSearch a;

            {
                this.a = r1;
            }

            public void run() {
                Message message = new Message();
                try {
                    BusStationResult searchBusStation = this.a.searchBusStation();
                    message.what = 0;
                    message.obj = searchBusStation;
                } catch (AMapException e) {
                    message.what = e.getErrorCode();
                } finally {
                    this.a.a.sendMessage(message);
                }
            }
        }).start();
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener onBusStationSearchListener) {
        this.c = onBusStationSearchListener;
    }

    public void setQuery(BusStationQuery busStationQuery) {
        if (!busStationQuery.weakEquals(this.d)) {
            this.d = busStationQuery;
        }
    }
}
