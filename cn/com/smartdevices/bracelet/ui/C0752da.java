package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventUserInfoUpdate;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;
import de.greenrobot.event.EventBus;
import java.util.Calendar;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;

public class C0752da extends c {
    private static final String h = C0752da.class.getSimpleName();
    private static int j;
    private PersonInfo a;
    private UserInfo b;
    private WheelView c;
    private WheelView d;
    private Birthday e;
    private int f;
    private int g;
    private C0763dl i;

    public static Fragment a(int i) {
        C0596r.e(h, "get the uid " + i);
        j = i;
        return new C0752da();
    }

    protected int inflateLayout() {
        return R.layout.fragment_person_info_setting_birthday;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (j == -1) {
            this.a = Keeper.readPersonInfo();
            this.e = Birthday.fromStr(this.a.getBirthday());
            return;
        }
        this.b = J.a().a(j);
        this.e = Birthday.fromStr(this.b.birthday);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.c = (WheelView) onCreateView.findViewById(R.id.setting_birth_wheel_year);
        this.d = (WheelView) onCreateView.findViewById(R.id.setting_birth_wheel_month);
        int i = Calendar.getInstance().get(1);
        this.g = Calendar.getInstance().get(2);
        C0596r.e(h, "maxMonth is " + this.g);
        this.f = i - 100;
        int i2 = i + 0;
        this.c.a(5).e(R.drawable.wheel_custom_val_white_1).a(getString(R.string.year), 40.0f).a(new C0763dl(getActivity(), this.f, i2, this.c, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1));
        this.i = new C0763dl(getActivity(), 1, 12, this.d, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), a.bm, true, 46, 24, 21, 21, 1);
        if (!this.e.isValid() || this.e.getYear() - this.f < 100) {
            this.d.a(5).e(R.drawable.wheel_custom_val_white_1).a(getString(R.string.month), (float) aA.h).a(this.i);
        } else {
            this.d.a(5).e(R.drawable.wheel_custom_val_white_1).a(getString(R.string.month), (float) aA.h).a(new C0763dl(getActivity(), 1, this.g + 1, this.d, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1));
        }
        if (this.e.isValid()) {
            this.c.c(this.e.getYear() - this.f);
            this.d.d(this.e.getMonth() - 1);
        } else {
            this.c.c(1990 - this.f);
            this.d.d(0);
        }
        this.c.a(new C0753db(this));
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.i);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.i);
    }

    protected void onRightButtonClicked() {
        String birthday;
        if (this.a != null) {
            birthday = this.a.getBirthday();
            this.e.setYear(this.c.f() + this.f);
            this.e.setMonth(this.d.f() + 1);
            if (this.e.toStringData().equals(birthday)) {
                dismiss();
                return;
            }
            this.a.setBirthday(this.e.toStringData());
            this.a.setAge(this.e.getAge());
            this.a.setNeedSyncServer(2);
            Keeper.keepPersonInfo(this.a);
            EventBus.getDefault().post(new EventPersonInfoUpdate());
        } else {
            birthday = this.b.birthday;
            this.e.setYear(this.c.f() + this.f);
            this.e.setMonth(this.d.f() + 1);
            this.b.birthday = this.e.toStringData();
            if (this.e.toStringData().equals(birthday)) {
                dismiss();
                return;
            }
            this.b.birthday = this.e.toStringData();
            EventBus.getDefault().post(new EventUserInfoUpdate(this.b));
        }
        dismiss();
    }
}
