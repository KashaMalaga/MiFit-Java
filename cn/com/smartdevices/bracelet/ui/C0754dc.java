package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventUserInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.huami.android.view.c;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.g;

public class C0754dc extends c {
    private static final String a = C0754dc.class.getSimpleName();
    private static int k;
    private PersonInfo b;
    private UserInfo c;
    private View d;
    private View e;
    private View f;
    private View g;
    private TextView h;
    private TextView i;
    private int j = 0;

    public static Fragment a(int i) {
        C0596r.e(a, "receive the uid" + i);
        k = i;
        return new C0754dc();
    }

    private void a() {
        if (this.j == 1) {
            this.d.setVisibility(0);
            this.e.setVisibility(4);
            this.i.setTextColor(getResources().getColor(g.highlight));
            this.h.setTextColor(getResources().getColor(g.main_ui_title_color));
        } else if (this.j == 0) {
            this.d.setVisibility(4);
            this.e.setVisibility(0);
            this.h.setTextColor(getResources().getColor(g.highlight));
            this.i.setTextColor(getResources().getColor(g.main_ui_title_color));
        }
    }

    protected int inflateLayout() {
        return n.fragment_person_info_setting_gender;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.person_info_male_area /*2131297070*/:
                this.j = 1;
                onRightButtonClicked();
                break;
            case l.person_info_female_area /*2131297072*/:
                this.j = 0;
                onRightButtonClicked();
                break;
        }
        super.onClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (k == -1) {
            this.b = Keeper.readPersonInfo();
        } else {
            this.c = J.a().a(k);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.d = onCreateView.findViewById(l.info_gender_male);
        this.e = onCreateView.findViewById(l.info_gender_female);
        this.f = onCreateView.findViewById(l.person_info_female_area);
        this.f.setOnClickListener(this);
        this.g = onCreateView.findViewById(l.person_info_male_area);
        this.g.setOnClickListener(this);
        this.h = (TextView) onCreateView.findViewById(l.info_gender_female_txt);
        this.i = (TextView) onCreateView.findViewById(l.info_gender_male_txt);
        if (this.b != null) {
            this.j = this.b.gender;
        } else {
            this.j = this.c.gender;
        }
        a();
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.g);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.g);
    }

    protected void onRightButtonClicked() {
        a();
        if (this.b != null) {
            if (this.j == this.b.gender) {
                dismiss();
                return;
            }
            this.b.gender = this.j;
            this.b.setNeedSyncServer(2);
            Keeper.keepPersonInfo(this.b);
            EventBus.getDefault().post(new EventPersonInfoUpdate());
        } else if (this.j == this.c.gender) {
            dismiss();
            return;
        } else {
            this.c.gender = this.j;
            EventBus.getDefault().post(new EventUserInfoUpdate(this.c));
        }
        dismiss();
    }
}
