package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0401a;
import com.huami.android.view.c;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class dC extends c {
    protected int inflateLayout() {
        return n.fragment_select_image_question;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.select_image_camera_area /*2131297177*/:
                C0401a.a(getActivity(), C0401a.cf);
                getActivity().startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), 18);
                break;
            case l.select_image_local_area /*2131297178*/:
                C0401a.a(getActivity(), C0401a.cg);
                getActivity().startActivityForResult(new Intent(getActivity(), CropImageActivity.class), 17);
                break;
        }
        dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.findViewById(l.select_image_camera_area).setOnClickListener(this);
        onCreateView.findViewById(l.select_image_local_area).setOnClickListener(this);
        return onCreateView;
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.l);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.l);
    }
}
