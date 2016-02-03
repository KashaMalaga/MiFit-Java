package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.huami.android.view.c;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.R;

public class aN extends c implements OnClickListener {
    private C0704bf a = null;
    private eH b = null;

    public void a(eH eHVar) {
        this.b = eHVar;
    }

    protected int inflateLayout() {
        return R.layout.fragment_share_to_miliao_select;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.a = (C0704bf) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IScreenShotShare");
        }
    }

    public void onClick(View view) {
        if (this.a != null) {
            switch (view.getId()) {
                case R.id.share_to_miliao_target_friends_fl:
                    this.a.a(v.O, this.b);
                    break;
                case R.id.share_to_miliao_target_union_fl:
                    this.a.a(v.Q, this.b);
                    break;
                case R.id.share_to_miliao_target_feeds_fl:
                    this.a.a(v.P, this.b);
                    break;
            }
            dismiss();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.findViewById(R.id.share_to_miliao_target_feeds_fl).setOnClickListener(this);
        onCreateView.findViewById(R.id.share_to_miliao_target_friends_fl).setOnClickListener(this);
        onCreateView.findViewById(R.id.share_to_miliao_target_union_fl).setOnClickListener(this);
        return onCreateView;
    }
}
