package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Constant;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;

public class aM extends c {
    private String a;

    protected int inflateLayout() {
        return R.layout.fragment_found_weight_scale;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.a = arguments.getString(Constant.aJ);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ((TextView) onCreateView.findViewById(R.id.found_weight_value)).setText(this.a);
        return onCreateView;
    }

    protected void onLeftButtonClicked() {
        SearchWeightScaleActivity searchWeightScaleActivity = (SearchWeightScaleActivity) getActivity();
        if (searchWeightScaleActivity != null) {
            searchWeightScaleActivity.b(false);
        }
        dismiss();
    }

    protected void onRightButtonClicked() {
        SearchWeightScaleActivity searchWeightScaleActivity = (SearchWeightScaleActivity) getActivity();
        if (searchWeightScaleActivity != null) {
            searchWeightScaleActivity.b(true);
        }
        dismiss();
    }
}
