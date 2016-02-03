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
import com.xiaomi.hm.health.R;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a.f;

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
        return R.layout.fragment_incoming_delay_sencond;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_button:
                dismiss();
                return;
            case R.id.right_button:
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
        this.c = (TextView) inflate.findViewById(R.id.choose_sencond_tv);
        this.d = (WheelView) inflate.findViewById(R.id.wheel);
        f c0763dl = new C0763dl(getActivity(), 3, 30, this.d, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), kankan.wheel.widget.a.bm, false, 46, (int) (aA.h * 0.8f), (int) (21.0f * 0.8f), (int) (0.8f * 21.0f), 1);
        c0763dl.a(C0763dl.c);
        c0763dl.a(this.e);
        c0763dl.e(R.string.second);
        this.d.a(5).e(R.drawable.wheel_custom_val_white_1).a(a.f, (float) aA.h).a(c0763dl);
        int e = B.a().e(this.h);
        if (e < 3) {
            e = 3;
        }
        this.d.c(e - 3);
        this.c.setText(getString(R.string.incoming_call_notify_tips, new Object[]{Integer.valueOf(e)}));
        this.d.a(new C0706bh(this));
        this.g = inflate.findViewById(R.id.right_button);
        this.g.setOnClickListener(this);
        this.f = inflate.findViewById(R.id.left_button);
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
