package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.huami.android.view.b;
import com.huami.android.view.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import de.greenrobot.event.EventBus;

public class C0759dh extends c {
    private PersonInfo a;
    private EditText b;

    protected int inflateLayout() {
        return R.layout.fragment_person_info_setting_signature;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = Keeper.readPersonInfo();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.b = (EditText) onCreateView.findViewById(R.id.info_person_signature);
        this.b.setText(this.a.personSignature);
        this.b.setSelection(this.b.length());
        return onCreateView;
    }

    protected void onRightButtonClicked() {
        String str = this.a.personSignature;
        if (TextUtils.isEmpty(this.b.getText().toString().trim())) {
            this.a.personSignature = a.f;
        } else {
            this.a.personSignature = this.b.getText().toString().replaceAll("\\s+", a.f);
        }
        if (!Utils.b(this.a.personSignature)) {
            b.a(getActivity(), (int) R.string.content_too_short, 0).show();
        } else if (this.a.personSignature.equals(str)) {
            dismiss();
        } else {
            this.a.setNeedSyncServer(2);
            Keeper.keepPersonInfo(this.a);
            EventBus.getDefault().post(new EventPersonInfoUpdate());
            dismiss();
        }
    }
}
