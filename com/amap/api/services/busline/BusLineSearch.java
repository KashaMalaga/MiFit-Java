package com.amap.api.services.busline;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.c;
import com.amap.api.services.core.d;
import com.amap.api.services.core.e;
import java.util.ArrayList;

public class BusLineSearch {
    Handler a = new b(this);
    private Context b;
    private OnBusLineSearchListener c;
    private BusLineQuery d;
    private BusLineQuery e;
    private int f;
    private ArrayList<BusLineResult> g;

    public interface OnBusLineSearchListener {
        void onBusLineSearched(BusLineResult busLineResult, int i);
    }

    public BusLineSearch(Context context, BusLineQuery busLineQuery) {
        d.a(context);
        this.b = context.getApplicationContext();
        this.d = busLineQuery;
        this.e = busLineQuery.clone();
    }

    private void a(BusLineResult busLineResult) {
        this.g = new ArrayList();
        for (int i = 0; i < this.f; i++) {
            this.g.add(null);
        }
        if (this.f >= 0 && a(this.d.getPageNumber())) {
            this.g.set(this.d.getPageNumber(), busLineResult);
        }
    }

    private boolean a(int i) {
        return i < this.f && i >= 0;
    }

    private BusLineResult b(int i) {
        if (a(i)) {
            return (BusLineResult) this.g.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    public BusLineQuery getQuery() {
        return this.d;
    }

    public BusLineResult searchBusLine() {
        if (!this.d.weakEquals(this.e)) {
            this.e = this.d.clone();
            this.f = 0;
            if (this.g != null) {
                this.g.clear();
            }
        }
        if (this.f == 0) {
            c cVar = new c(this.d.clone(), e.a(this.b));
            BusLineResult a = BusLineResult.a(cVar, (ArrayList) cVar.getData());
            this.f = a.getPageCount();
            a(a);
            return a;
        }
        a = b(this.d.getPageNumber());
        if (a != null) {
            return a;
        }
        cVar = new c(this.d, e.a(this.b));
        a = BusLineResult.a(cVar, (ArrayList) cVar.getData());
        this.g.set(this.d.getPageNumber(), a);
        return a;
    }

    public void searchBusLineAsyn() {
        new Thread(new Runnable(this) {
            final /* synthetic */ BusLineSearch a;

            {
                this.a = r1;
            }

            public void run() {
                Message message = new Message();
                try {
                    BusLineResult searchBusLine = this.a.searchBusLine();
                    message.what = 0;
                    message.obj = searchBusLine;
                } catch (AMapException e) {
                    message.what = e.getErrorCode();
                } finally {
                    this.a.a.sendMessage(message);
                }
            }
        }).start();
    }

    public void setOnBusLineSearchListener(OnBusLineSearchListener onBusLineSearchListener) {
        this.c = onBusLineSearchListener;
    }

    public void setQuery(BusLineQuery busLineQuery) {
        if (!this.d.weakEquals(busLineQuery)) {
            this.d = busLineQuery;
            this.e = busLineQuery.clone();
        }
    }
}
