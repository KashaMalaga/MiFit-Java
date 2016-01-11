package cn.com.smartdevices.bracelet.honor;

import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.honor.a.a;
import com.huami.android.ui.ActionBarActivity;

public class MedalDetailActivity extends ActionBarActivity {
    public static final String a = "medal_meta";
    private static final String b = "MedalDetailActivity";
    private a c = null;

    public MedalDetailActivity() {
        super(C0401a.hx, C0401a.hw);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.c = (a) intent.getSerializableExtra(a);
        }
        if (this.c != null) {
            C0596r.e(b, "DATA:" + this.c);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
