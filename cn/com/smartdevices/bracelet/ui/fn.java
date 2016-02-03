package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;
import java.util.Locale;

public class fn extends c implements OnClickListener {
    private static final String a = "UserAgreementFragment";
    private TextView b;
    private boolean c;
    private CheckBox d;
    private TextView e;
    private boolean f;

    protected int inflateLayout() {
        return R.layout.fragment_useragreement;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = true;
        this.f = false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.b = (TextView) onCreateView.findViewById(R.id.useragreement_info);
        Object string = getString(R.string.user_agreement);
        this.b.setText(R.string.user_agreement_prefix);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new fo(this), 0, string.length(), 33);
        Utils.a(this.b, spannableString);
        if (Locale.getDefault().getLanguage().equals(Locale.ENGLISH.getLanguage())) {
            this.b.append(".");
        }
        this.d = (CheckBox) onCreateView.findViewById(R.id.useragreement_ux_checkbox);
        this.e = (TextView) onCreateView.findViewById(R.id.useragreement_ux);
        if (Utils.k()) {
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.e.setText(R.string.agree_ux);
            TextView rightButton = getRightButton();
            rightButton.setTextColor(getResources().getColor(R.color.main_ui_title_color));
            this.d.setOnCheckedChangeListener(new fp(this, rightButton));
        } else {
            this.d.setVisibility(8);
            this.e.setVisibility(8);
        }
        getDialog().setCanceledOnTouchOutside(true);
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        if (!this.f) {
            getActivity().finish();
        }
    }

    protected void onEmptyAreaClicked() {
    }

    protected void onLeftButtonClicked() {
        super.onLeftButtonClicked();
        dismiss();
        getActivity().finish();
    }

    protected void onRightButtonClicked() {
        super.onRightButtonClicked();
        dismiss();
        Keeper.keepUserAgreement(this.c);
        Keeper.keepShowedUserAgreement(true);
        this.f = true;
    }
}
