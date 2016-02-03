package cn.com.smartdevices.bracelet.ui;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventUserInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.huami.android.view.b;
import com.huami.android.view.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import de.greenrobot.event.EventBus;

public class C0758dg extends c {
    private static final String a = C0758dg.class.getSimpleName();
    private static int e;
    private UserInfo b;
    private PersonInfo c;
    private EditText d;

    public static Fragment a(int i) {
        C0596r.e(a, "receive the uid" + i);
        e = i;
        return new C0758dg();
    }

    protected int inflateLayout() {
        return R.layout.fragment_person_info_setting_nickname;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (e == -1) {
            this.c = Keeper.readPersonInfo();
        } else {
            this.b = J.a().a(e);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return super.onCreateDialog(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.d = (EditText) onCreateView.findViewById(R.id.info_nick_name);
        if (this.c != null) {
            this.d.setText(this.c.nickname != null ? this.c.nickname : a.f);
        } else {
            this.d.setText(this.b.name != null ? this.b.name : a.f);
        }
        this.d.setSelection(this.d.length());
        return onCreateView;
    }

    protected void onLeftButtonClicked() {
        super.onLeftButtonClicked();
        dismiss();
    }

    protected void onRightButtonClicked() {
        String str;
        if (this.c != null) {
            str = this.c.nickname;
            if (TextUtils.isEmpty(this.d.getText())) {
                this.c.nickname = a.f;
            } else {
                this.c.nickname = this.d.getText().toString().trim();
            }
            if (!Utils.b(this.c.nickname)) {
                b.a(getActivity(), (int) R.string.content_too_short, 0).show();
                return;
            } else if (!Utils.g(this.c.nickname)) {
                b.a(getActivity(), (int) R.string.invalid_name, 0).show();
                return;
            } else if (this.c.nickname.equals(str)) {
                dismiss();
                return;
            } else {
                this.c.setNeedSyncServer(2);
                Keeper.keepPersonInfo(this.c);
                EventBus.getDefault().post(new EventPersonInfoUpdate());
            }
        } else {
            str = this.b.name;
            if (TextUtils.isEmpty(this.d.getText())) {
                this.b.name = a.f;
            } else {
                this.b.name = this.d.getText().toString().trim();
            }
            if (!Utils.b(this.b.name)) {
                b.a(getActivity(), (int) R.string.content_too_short, 0).show();
                return;
            } else if (!Utils.g(this.b.name)) {
                b.a(getActivity(), (int) R.string.invalid_name, 0).show();
                return;
            } else if (this.b.equals(str)) {
                dismiss();
                return;
            } else {
                EventBus.getDefault().post(new EventUserInfoUpdate(this.b));
            }
        }
        dismiss();
    }
}
