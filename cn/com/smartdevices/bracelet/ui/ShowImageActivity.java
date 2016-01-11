package cn.com.smartdevices.bracelet.ui;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.C0544h;
import cn.com.smartdevices.bracelet.C0596r;
import com.f.a.b.a.f;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class ShowImageActivity extends SystemBarTintActivity {
    private ImageView a = null;
    private Uri b = null;
    private Bitmap c = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getIntent().getData();
        C0596r.e("WPJ", "URI:" + this.b.toString());
        setContentView((int) n.acvitiy_show_image);
        this.a = (ImageView) findViewById(l.show_image_iv);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        C0544h.a().a(this.b.toString(), new f(displayMetrics.widthPixels, displayMetrics.heightPixels), new eI(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
    }
}
