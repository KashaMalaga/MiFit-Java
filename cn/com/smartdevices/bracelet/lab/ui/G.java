package cn.com.smartdevices.bracelet.lab.ui;

import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.lab.d;
import cn.com.smartdevices.bracelet.lab.sportmode.DynamicGroupItemInfo;
import com.xiaomi.hm.health.r;

final class G extends Handler {
    public static final int a = 100;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 2;
    public static final int e = 1;
    final /* synthetic */ SportAnalyserActivity f;

    private G(SportAnalyserActivity sportAnalyserActivity) {
        this.f = sportAnalyserActivity;
    }

    public void a() {
        removeMessages(e);
        removeMessages(d);
        removeMessages(a);
    }

    public void dispatchMessage(Message message) {
        switch (message.what) {
            case e /*1*/:
                if (message.arg1 == d) {
                    int i = message.arg2;
                    if (this.f.e.isMarkedInGroup()) {
                        this.f.e = new DynamicGroupItemInfo(this.f.D.getSportType(), this.f.D.getRoundCountOfPB());
                        this.f.f(this.f.getResources().getColor(this.f.a(this.f.o)));
                        this.f.v.a(String.valueOf(0));
                    }
                    this.f.e.setCount(i);
                    this.f.v.a(String.valueOf(i));
                    this.f.d.a(i, this.f.e.isNewPBPoint());
                    if (this.f.D.getRoundCountOfPB() <= i) {
                        this.f.D.setRoundCountOfPB(i);
                        this.f.a(this.f.e);
                    }
                    this.f.i();
                    this.f.c(false);
                    this.f.v.d(i);
                    return;
                } else if (message.arg1 == e) {
                    this.f.H = 0;
                    this.f.e.setMarkedOneRoundFinished();
                    if (this.f.e.getCount() >= 5) {
                        this.f.D.addGroupItem(this.f.e);
                        this.f.m.add(Integer.valueOf(this.f.e.getCount()));
                        SportAnalyserActivity.c(this.f, this.f.e.getCount());
                        this.f.b(this.f.e);
                        this.f.e(this.f.h);
                        this.f.E.a(this.f.e.getCount());
                        this.f.c(true);
                        return;
                    }
                    if (this.f.e.getCount() > 0) {
                        this.f.v.a(this.f.A);
                        this.f.v.e(this.f.e.getCount());
                    }
                    TextView k = this.f.y;
                    SportAnalyserActivity sportAnalyserActivity = this.f;
                    Object[] objArr = new Object[e];
                    objArr[0] = Integer.valueOf(0);
                    k.setText(Html.fromHtml(sportAnalyserActivity.getString(r.lab_factory_sport_average_rate_per_minute, objArr)));
                    return;
                } else {
                    return;
                }
            case d /*2*/:
                this.f.u = message.arg1;
                this.f.c(message.arg1);
                return;
            case a /*100*/:
                if (E.a()) {
                    this.f.e.setMarkedOneRoundFinished();
                    this.f.v.a(this.f.A);
                    this.f.H = 0;
                    d.a(this.f.getApplicationContext()).c();
                    this.f.i();
                    this.f.g();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
