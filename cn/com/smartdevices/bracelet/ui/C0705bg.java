package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.B;
import cn.com.smartdevices.bracelet.D;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import com.huami.android.view.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a.f;
import kankan.wheel.widget.g;
import kankan.wheel.widget.h;

public class C0705bg extends c {
    private static final String a = "IncomingDelaySencondFragment";
    private PersonInfo b;
    private TextView c;
    private WheelView d;
    private int e = 20;
    private View f = null;
    private View g = null;
    private String h = a.f;

    protected int inflateLayout() {
        return n.fragment_incoming_delay_sencond;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.left_button /*2131296944*/:
                dismiss();
                return;
            case l.right_button /*2131296946*/:
                onRightButtonClicked();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = Keeper.readPersonInfo();
        this.h = Keeper.readBraceletBtInfo().b;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(inflateLayout(), viewGroup, false);
        this.c = (TextView) inflate.findViewById(l.choose_sencond_tv);
        this.d = (WheelView) inflate.findViewById(l.wheel);
        f c0763dl = new C0763dl(getActivity(), 3, 30, this.d, getResources().getColor(g.highlight), getResources().getColor(g.main_ui_content_color), kankan.wheel.widget.a.bm, false, 46, (int) (aA.h * 0.8f), (int) (21.0f * 0.8f), (int) (0.8f * 21.0f), 1);
        c0763dl.a(C0763dl.c);
        c0763dl.a(this.e);
        c0763dl.e(r.second);
        this.d.a(5).e(h.wheel_custom_val_white_1).a(a.f, (float) aA.h).a(c0763dl);
        int e = B.a().e(this.h);
        if (e < 3) {
            e = 3;
        }
        this.d.c(e - 3);
        this.c.setText(getString(r.incoming_call_notify_tips, new Object[]{Integer.valueOf(e)}));
        this.d.a(new C0706bh(this));
        this.g = inflate.findViewById(l.right_button);
        this.g.setOnClickListener(this);
        this.f = inflate.findViewById(l.left_button);
        this.f.setOnClickListener(this);
        return inflate;
    }

    protected void onRightButtonClicked() {
        int f = this.d.f() + 3;
        D.a(getActivity(), f);
        B.a().d(this.h, true);
        B.a().a(this.h, f);
        EventBus.getDefault().post(new EventSettingFragmentUpdate());
        dismiss();
    }
}
