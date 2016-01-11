package cn.com.smartdevices.bracelet.notification;

import android.support.v7.widget.aj;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.xiaomi.hm.health.l;

public class k extends aj {
    public ImageView r;
    public TextView s;
    public Switch t;

    public k(View view) {
        super(view);
        this.r = (ImageView) view.findViewById(l.icon);
        this.s = (TextView) view.findViewById(l.text);
        this.t = (Switch) view.findViewById(l.notifi_on);
    }
}
