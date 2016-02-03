package cn.com.smartdevices.bracelet.notification;

import android.support.v7.widget.aj;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.xiaomi.hm.health.R;

public class k extends aj {
    public ImageView r;
    public TextView s;
    public Switch t;

    public k(View view) {
        super(view);
        this.r = (ImageView) view.findViewById(R.id.icon);
        this.s = (TextView) view.findViewById(R.id.text);
        this.t = (Switch) view.findViewById(R.id.notifi_on);
    }
}
