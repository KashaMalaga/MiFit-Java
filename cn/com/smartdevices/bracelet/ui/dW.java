package cn.com.smartdevices.bracelet.ui;

import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.d;
import cn.com.smartdevices.bracelet.upgrade.OtaVersionInfo;
import cn.com.smartdevices.bracelet.upgrade.UpgradeService;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.i;
import com.xiaomi.hm.health.bt.model.h;
import java.io.File;
import java.io.IOException;

public class dW extends Fragment {
    public static final int a = 1;
    public static final String b = ".fw";
    public static final String c = ".tmp";
    public static Handler d = null;
    private static final String e = "Setting.Firmware";
    private static final int f = 4098;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private ProgressDialog k;
    private h l;
    private OtaVersionInfo m;

    private void a(int i) {
        if (this.k == null) {
            this.k = new ProgressDialog(getActivity());
            this.k.setMax(i);
            this.k.setProgress(0);
            this.k.setTitle("\u56fa\u4ef6\u5347\u7ea7");
            this.k.setMessage("\u5347\u7ea7\u8fdb\u5ea6");
            this.k.setCancelable(false);
            this.k.setProgressStyle(a);
            this.k.setIndeterminate(false);
            this.k.show();
        }
    }

    private void a(View view) {
        this.g = (TextView) view.findViewById(R.id.current_firmware_version);
        this.h = (TextView) view.findViewById(R.id.new_firmware_version);
        this.i = (TextView) view.findViewById(R.id.firmware_change_log);
        this.j = view.findViewById(R.id.firmware_upgrade);
        this.j.setOnClickListener(new C0780eb(this));
        this.j.setEnabled(false);
    }

    private void a(OtaVersionInfo otaVersionInfo) {
        File file = new File(new File(Utils.j(getActivity().getApplicationContext()) + "/bracelet.fw").getPath() + c);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        d.a.b(cn.com.smartdevices.bracelet.j.h.b(otaVersionInfo.a, String.valueOf(System.currentTimeMillis())), new C0782ec(this, getActivity(), file, otaVersionInfo));
    }

    private void a(String str, String str2) {
        new i(str, str2, new dZ(this, str2)).f();
    }

    private void b() {
        if (this.k != null) {
            this.k.dismiss();
            this.k = null;
        }
        d.removeMessages(f);
    }

    private void b(int i) {
        if (this.k != null) {
            this.k.setProgress(i);
        }
    }

    private void b(OtaVersionInfo otaVersionInfo) {
        this.h.setText(otaVersionInfo.c);
        this.i.setText(otaVersionInfo.d);
        this.j.setEnabled(UpgradeService.a(otaVersionInfo, this.l));
    }

    private void c() {
        d = new C0779ea(this);
    }

    private void d() {
        d.sendEmptyMessageDelayed(f, 1000);
    }

    public void a() {
        CharSequence charSequence;
        Builder builder = new Builder(getActivity());
        builder.setTitle("\u56fa\u4ef6\u5347\u7ea7");
        String str = a.f;
        String str2 = Utils.j(getActivity().getApplicationContext()) + "/bracelet.fw";
        File file = new File(str2);
        if (file.exists() && file.canRead()) {
            charSequence = "\u624b\u73af\u56fa\u4ef6\u8def\u5f84\uff1a" + str2 + "\n" + "\u786e\u5b9a\u5347\u7ea7\uff1f";
            builder.setPositiveButton("\u786e\u5b9a", new dX(this, str2));
        } else {
            charSequence = "\u624b\u73af\u56fa\u4ef6\u8def\u5f84\uff1a" + str2 + "\u4e0d\u5b58\u5728," + "\u8bf7\u628a\u56fa\u4ef6\u590d\u5236\u5230\u76ee\u6807\u5730\u5740\u540e\u91cd\u8bd5\uff01";
        }
        builder.setMessage(charSequence);
        builder.setNegativeButton("\u53d6\u6d88", new dY(this));
        builder.show();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_setting_firmware_upgrade, viewGroup, false);
        a(inflate);
        c();
        this.l = com.xiaomi.hm.health.bt.bleservice.a.f();
        this.g.setText(this.l.l());
        UpgradeService.start(getActivity(), 2);
        return inflate;
    }
}
