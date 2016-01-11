package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.model.MiliConfig;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.huami.android.view.c;
import com.xiaomi.hm.health.bt.a.r;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.g;

public class cY extends c {
    private PersonInfo a;
    private String b;
    private View c;
    private View d;
    private View e;
    private View f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;

    private void a() {
        this.c.setVisibility(4);
        this.e.setVisibility(4);
        this.f.setVisibility(4);
        this.d.setVisibility(4);
        this.g.setTextColor(getResources().getColor(g.main_ui_title_color));
        this.j.setTextColor(getResources().getColor(g.main_ui_title_color));
        this.i.setTextColor(getResources().getColor(g.main_ui_title_color));
        this.h.setTextColor(getResources().getColor(g.main_ui_title_color));
        if (this.a.getMiliColor().equals(MiliConfig.BLUE)) {
            this.g.setTextColor(getResources().getColor(g.highlight));
            this.c.setVisibility(0);
        } else if (this.a.getMiliColor().equals(MiliConfig.ORANGE)) {
            this.j.setTextColor(getResources().getColor(g.highlight));
            this.e.setVisibility(0);
        } else if (this.a.getMiliColor().equals(MiliConfig.GREEN)) {
            this.i.setTextColor(getResources().getColor(g.highlight));
            this.f.setVisibility(0);
        } else if (this.a.getMiliColor().equals(MiliConfig.RED)) {
            this.h.setTextColor(getResources().getColor(g.highlight));
            this.d.setVisibility(0);
        }
    }

    private void a(View view) {
        this.c = view.findViewById(l.person_info_light_color_blue);
        this.e = view.findViewById(l.person_info_light_color_oragne);
        this.f = view.findViewById(l.person_info_light_color_green);
        this.d = view.findViewById(l.person_info_light_color_red);
        this.g = (TextView) view.findViewById(l.person_info_light_color_blue_txt);
        this.j = (TextView) view.findViewById(l.person_info_light_color_oragne_txt);
        this.i = (TextView) view.findViewById(l.person_info_light_color_green_txt);
        this.h = (TextView) view.findViewById(l.person_info_light_color_red_txt);
        view.findViewById(l.person_info_light_color_blue_area).setOnClickListener(this);
        view.findViewById(l.person_info_light_color_oragne_area).setOnClickListener(this);
        view.findViewById(l.person_info_light_color_green_area).setOnClickListener(this);
        view.findViewById(l.person_info_light_color_red_area).setOnClickListener(this);
    }

    protected int inflateLayout() {
        return n.fragment_person_info_set_light_color;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.person_info_light_color_blue_area /*2131297056*/:
                this.a.setMiliColor(MiliConfig.BLUE);
                onRightButtonClicked();
                return;
            case l.person_info_light_color_oragne_area /*2131297059*/:
                this.a.setMiliColor(MiliConfig.ORANGE);
                onRightButtonClicked();
                return;
            case l.person_info_light_color_green_area /*2131297062*/:
                this.a.setMiliColor(MiliConfig.GREEN);
                onRightButtonClicked();
                return;
            case l.person_info_light_color_red_area /*2131297065*/:
                this.a.setMiliColor(MiliConfig.RED);
                onRightButtonClicked();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (t.a()) {
            t.a(getActivity(), (int) BaseActivity.MI_NOTE_ORIGINAL_DPI);
        }
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.a = Keeper.readPersonInfo();
        this.b = this.a.getMiliColor();
        a(onCreateView);
        a();
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        C0401a.a(getActivity(), C0401a.dM, this.a.getMiliColor());
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.O);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.O);
    }

    protected void onRightButtonClicked() {
        int i = r.c;
        if (!this.a.getMiliColor().equals(MiliConfig.BLUE)) {
            if (this.a.getMiliColor().equals(MiliConfig.ORANGE)) {
                i = r.d;
            } else if (this.a.getMiliColor().equals(MiliConfig.GREEN)) {
                i = r.e;
            } else if (this.a.getMiliColor().equals(MiliConfig.RED)) {
                i = r.f;
            }
        }
        new r(null, i).f();
        a();
        if (this.b.equals(this.a.getMiliColor())) {
            dismiss();
            return;
        }
        this.a.setNeedSyncServer(2);
        Keeper.keepPersonInfo(this.a);
        EventBus.getDefault().post(new EventSettingFragmentUpdate());
        dismiss();
    }
}
