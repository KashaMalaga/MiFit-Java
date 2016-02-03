package cn.com.smartdevices.bracelet.tag;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0401a;
import com.xiaomi.hm.health.R;

public class k extends Fragment implements OnClickListener {
    private c a;

    public static k a() {
        k kVar = new k();
        kVar.setArguments(new Bundle());
        return kVar;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.a = (c) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.action_button:
                if (this.a != null) {
                    this.a.a(1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0401a.a(getActivity(), C0401a.bQ);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mark_guide, viewGroup, false);
        inflate.findViewById(R.id.action_button).setOnClickListener(this);
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        this.a = null;
    }

    public void onPause() {
        super.onPause();
        C0401a.b(getActivity());
        C0401a.b(C0401a.ag);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(getActivity());
        C0401a.a(C0401a.ag);
    }
}
