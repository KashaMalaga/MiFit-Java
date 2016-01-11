package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.C;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0544h;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.StartingUpResInfo;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import java.util.List;

public class StartUpActivity extends Activity {
    private static final int b = 1;
    private static final int c = 3000;
    private static final int d = 4000;
    private static final int e = 1;
    private static final int f = 0;
    private static final int g = 1;
    private static final String h = "StartUpActivity";
    public Handler a = new x(this);
    private ImageView i;

    private void a() {
        this.i = (ImageView) findViewById(l.center_iv);
        List startupList = Keeper.getStartupList();
        if (startupList == null || startupList.size() == 0) {
            c();
            return;
        }
        StartingUpResInfo startingUpResInfo;
        for (int i = f; i < startupList.size(); i += g) {
            startingUpResInfo = (StartingUpResInfo) startupList.get(i);
            if (!a(startingUpResInfo.getStart_time(), startingUpResInfo.getExpire_time()) && startingUpResInfo.getBg_img_url() != null && !a.f.equals(startingUpResInfo.getBg_img_url())) {
                break;
            }
        }
        startingUpResInfo = null;
        if (startingUpResInfo == null) {
            c();
        } else {
            a(startingUpResInfo.getBg_img_url(), startingUpResInfo.getJump_url(), startingUpResInfo.getTitle());
        }
    }

    private void a(String str) {
        C0544h.a().d(str);
    }

    private void a(String str, String str2) {
        this.a.removeMessages(g);
        C0401a.a(getApplicationContext(), C0401a.hG);
        Intent intent = new Intent(this, AdvClickTargetActivity.class);
        intent.putExtra(SocialConstants.PARAM_TITLE, str2);
        intent.putExtra(SocialConstants.PARAM_URL, str);
        startActivityForResult(intent, g);
    }

    private void a(String str, String str2, String str3) {
        if (C0544h.a().c(str) == null) {
            C0596r.d(h, " fileCache is null. ");
            c();
            b(str);
            return;
        }
        if (str2 == null || a.f.equals(str2)) {
            C0596r.d(h, "jump_url = " + str2 + " , title = " + str3);
        } else {
            this.i.setOnClickListener(new y(this, str2, str3));
        }
        C0596r.d(h, "display file cache ");
        C0544h.a().a(str, this.i, new z(this, f));
        C0401a.a(getApplicationContext(), C0401a.hE);
        this.a.sendEmptyMessageDelayed(g, 4000);
    }

    private void a(List<StartingUpResInfo> list) {
        int size;
        int i = f;
        for (size = list.size() - 1; size >= 0; size--) {
            StartingUpResInfo startingUpResInfo = (StartingUpResInfo) list.get(size);
            C0596r.d(h, "mResInfo = " + startingUpResInfo.getBg_img_url() + " , startTime = " + startingUpResInfo.getStart_time() + " , endTime = " + startingUpResInfo.getExpire_time());
            if (!a((StartingUpResInfo) list.get(size))) {
                list.remove(size);
            }
        }
        List startupList = Keeper.getStartupList();
        if (list == null || list.size() == 0) {
            Keeper.keepStartupList(list);
            if (startupList != null) {
                while (i < startupList.size()) {
                    a(((StartingUpResInfo) startupList.get(i)).getBg_img_url());
                    i += g;
                }
            }
        } else if (startupList == null) {
            Keeper.keepStartupList(list);
        } else {
            if (list.size() == startupList.size()) {
                if ((list.containsAll(startupList) ? g : f) != 0) {
                    return;
                }
            }
            for (size = f; size < startupList.size(); size += g) {
                startingUpResInfo = (StartingUpResInfo) startupList.get(size);
                if (!list.contains(startingUpResInfo)) {
                    a(startingUpResInfo.getBg_img_url());
                }
            }
            while (i < list.size()) {
                if (!startupList.contains(list.get(i))) {
                    b(((StartingUpResInfo) list.get(i)).getBg_img_url());
                }
                i += g;
            }
            Keeper.keepStartupList(list);
        }
    }

    private boolean a(long j, long j2) {
        long d = d();
        return d < j || d > j2;
    }

    private boolean a(StartingUpResInfo startingUpResInfo) {
        String bg_img_url = startingUpResInfo.getBg_img_url();
        if (bg_img_url == null || a.f.equals(bg_img_url)) {
            return false;
        }
        long start_time = startingUpResInfo.getStart_time();
        long expire_time = startingUpResInfo.getExpire_time();
        if (start_time <= 0 || expire_time <= 0 || expire_time <= start_time) {
            C0596r.d(h, "time is invalid , start_time = " + start_time + " , expire_time = " + expire_time);
            return false;
        } else if (d() <= expire_time) {
            return true;
        } else {
            C0596r.d(h, "time is expired!");
            return false;
        }
    }

    private void b() {
        if (C.a(getApplicationContext())) {
            cn.com.smartdevices.bracelet.j.l.e((Context) this, new v(this));
        } else {
            C0596r.d(h, "no network, when request getStaringUpInfo ...");
        }
    }

    private void b(String str) {
        C0544h.a().a(str, new z(this, g));
    }

    private void c() {
        this.i.setBackgroundResource(k.start_up_default);
        C0401a.a(getApplicationContext(), C0401a.hF);
        this.a.sendEmptyMessageDelayed(g, kankan.wheel.widget.a.bX);
    }

    private long d() {
        return System.currentTimeMillis() / 1000;
    }

    private void e() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case g /*1*/:
                e();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.activity_start_up);
        a();
        b();
    }
}
