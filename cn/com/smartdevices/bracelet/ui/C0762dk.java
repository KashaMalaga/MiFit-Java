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
import com.xiaomi.hm.health.bt.a.x;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.g;

public class C0762dk extends c {
    private PersonInfo a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private TextView h;
    private TextView i;
    private TextView j;
    private String k;

    private void a() {
        if (this.a.getMiliWearHand().equals(MiliConfig.LEFT_HAND)) {
            this.b.setVisibility(0);
            this.c.setVisibility(4);
            this.d.setVisibility(4);
            this.i.setTextColor(getResources().getColor(g.highlight));
            this.h.setTextColor(getResources().getColor(g.main_ui_title_color));
            this.j.setTextColor(getResources().getColor(g.main_ui_title_color));
        } else if (this.a.getMiliWearHand().equals(MiliConfig.RIGHT_HAND)) {
            this.b.setVisibility(4);
            this.c.setVisibility(0);
            this.d.setVisibility(4);
            this.h.setTextColor(getResources().getColor(g.highlight));
            this.i.setTextColor(getResources().getColor(g.main_ui_title_color));
            this.j.setTextColor(getResources().getColor(g.main_ui_title_color));
        } else if (this.a.getMiliWearHand().equals(MiliConfig.ONBODY)) {
            this.b.setVisibility(4);
            this.c.setVisibility(4);
            this.d.setVisibility(0);
            this.h.setTextColor(getResources().getColor(g.main_ui_title_color));
            this.i.setTextColor(getResources().getColor(g.main_ui_title_color));
            this.j.setTextColor(getResources().getColor(g.highlight));
        }
    }

    protected int inflateLayout() {
        return n.fragment_person_info_wear_hand;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.person_info_left_hand_area /*2131297080*/:
                this.a.setMiliWearHand(MiliConfig.LEFT_HAND);
                onRightButtonClicked();
                return;
            case l.person_info_right_hand_area /*2131297082*/:
                this.a.setMiliWearHand(MiliConfig.RIGHT_HAND);
                onRightButtonClicked();
                return;
            case l.person_info_body_area /*2131297085*/:
                this.a.setMiliWearHand(MiliConfig.ONBODY);
                onRightButtonClicked();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = Keeper.readPersonInfo();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (t.a()) {
            t.a(getActivity(), (int) BaseActivity.MI_NOTE_ORIGINAL_DPI);
        }
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.b = onCreateView.findViewById(l.person_info_left_hand);
        this.c = onCreateView.findViewById(l.person_info_right_hand);
        this.d = onCreateView.findViewById(l.person_info_body);
        this.e = onCreateView.findViewById(l.person_info_right_hand_area);
        this.e.setOnClickListener(this);
        this.f = onCreateView.findViewById(l.person_info_left_hand_area);
        this.f.setOnClickListener(this);
        this.g = onCreateView.findViewById(l.person_info_body_area);
        this.g.setOnClickListener(this);
        this.h = (TextView) onCreateView.findViewById(l.person_info_right_hand_txt);
        this.i = (TextView) onCreateView.findViewById(l.person_info_left_hand_txt);
        this.j = (TextView) onCreateView.findViewById(l.person_info_body_txt);
        this.k = this.a.getMiliWearHand();
        a();
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        C0401a.a(getActivity(), C0401a.dN, this.a.getMiliWearHand());
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.P);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.P);
    }

    protected void onRightButtonClicked() {
        a();
        byte b = this.a.getMiliWearHand().equals(MiliConfig.LEFT_HAND) ? (byte) 0 : this.a.getMiliWearHand().equals(MiliConfig.RIGHT_HAND) ? (byte) 1 : (byte) 2;
        new x(null, b).f();
        if (this.k.equals(this.a.getMiliWearHand())) {
            dismiss();
            return;
        }
        this.a.setNeedSyncServer(2);
        Keeper.keepPersonInfo(this.a);
        EventBus.getDefault().post(new EventSettingFragmentUpdate());
        dismiss();
    }
}
