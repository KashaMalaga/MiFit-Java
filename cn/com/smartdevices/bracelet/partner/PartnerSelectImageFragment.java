package cn.com.smartdevices.bracelet.partner;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.a.a;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;

public class PartnerSelectImageFragment extends c {
    protected int inflateLayout() {
        return R.layout.fragment_web_select_image;
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.select_image_camera_area:
                C0401a.a(getActivity(), C0401a.cf);
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", Uri.fromFile(a.a("lining_tmp.jpg")));
                try {
                    getActivity().startActivityForResult(intent, 18);
                    return;
                } catch (ActivityNotFoundException e) {
                    C0596r.c("Camrea can't be started");
                    return;
                }
            case R.id.select_image_local_area:
                C0401a.a(getActivity(), C0401a.cg);
                intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("image/*");
                try {
                    getActivity().startActivityForResult(Intent.createChooser(intent, null), 17);
                    return;
                } catch (ActivityNotFoundException e2) {
                    C0596r.c("Gallery can't be started");
                    return;
                }
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.findViewById(R.id.select_image_camera_area).setOnClickListener(this);
        onCreateView.findViewById(R.id.select_image_local_area).setOnClickListener(this);
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
