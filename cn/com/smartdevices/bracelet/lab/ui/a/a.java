package cn.com.smartdevices.bracelet.lab.ui.a;

import android.os.Bundle;
import android.view.View;
import cn.com.smartdevices.bracelet.C0401a;
import com.huami.android.view.c;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class a extends c {
    private View a;
    private View b;

    protected int inflateLayout() {
        return n.fragment_lab_share_photo;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.photo_selection_camera_area /*2131297034*/:
                onRightButtonClicked();
                return;
            case l.photo_selection_gallery_area /*2131297037*/:
                onRightButtonClicked();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.P);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.P);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.a = view.findViewById(l.photo_selection_camera_area);
        this.a.setOnClickListener(this);
        this.b = view.findViewById(l.photo_selection_gallery_area);
        this.b.setOnClickListener(this);
    }
}
