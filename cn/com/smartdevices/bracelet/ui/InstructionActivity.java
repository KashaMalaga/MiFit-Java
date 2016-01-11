package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.ui.widget.c;
import com.activeandroid.b;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class InstructionActivity extends SystemBarTintActivity {
    private ViewPager a;
    private c b;
    private C0708bj c;
    private ArrayList<Fragment> d;
    private int e;

    private static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[b.a];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_instruction);
        this.a = (ViewPager) findViewById(l.view_pager);
        this.b = (c) findViewById(l.indicator);
        this.d = new ArrayList(3);
        this.d.add(Fragment.instantiate(this, C0710bl.class.getName()));
        this.d.add(Fragment.instantiate(this, C0711bm.class.getName()));
        this.d.add(Fragment.instantiate(this, C0713bo.class.getName()));
        this.c = new C0708bj(this, getFragmentManager());
        this.a.a(this.c);
        this.a.b(3);
        this.b.a(this.a);
        this.b.a(new C0707bi(this));
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.y);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.y);
        C0401a.a((Activity) this);
    }
}
