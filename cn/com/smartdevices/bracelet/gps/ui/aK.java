package cn.com.smartdevices.bracelet.gps.ui;

import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.gps.e.k;
import cn.com.smartdevices.bracelet.gps.ui.b.a;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.n;

class aK {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    final /* synthetic */ aJ f;

    public aK(aJ aJVar, View view) {
        this.f = aJVar;
        this.a = (TextView) view.findViewById(i.tv_kilometer);
        this.b = (TextView) view.findViewById(i.tv_costtime);
        this.c = (TextView) view.findViewById(i.tv_pace);
        this.d = (TextView) view.findViewById(i.tv_kilometer_unit);
        this.e = (TextView) view.findViewById(i.tv_hr);
    }

    public void a(cn.com.smartdevices.bracelet.gps.model.i iVar) {
        this.a.setTag(iVar);
        this.a.setText(iVar.a);
        this.b.setText(iVar.b);
        this.c.setText(iVar.c);
        this.e.setText(a.a(iVar.e));
        if (this.f.a.q == k.British) {
            this.d.setText(n.running_mile);
        }
    }
}
