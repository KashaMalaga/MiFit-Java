package cn.com.smartdevices.bracelet.ui;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.f.d;
import cn.com.smartdevices.bracelet.j.l;
import com.xiaomi.hm.health.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class dE extends p implements OnClickListener {
    private static final String b = "SettingAboutActivity";
    private Context c = null;
    private View d;
    private View e;
    private View f = null;
    private TextView g;
    private final int h = 1;
    private final int i = 2;
    private final int j = 3;
    private ProgressDialog k = null;
    private b l = b.h();
    private Handler m = new dF(this);
    private boolean n;
    private View o;

    private void a(Context context) {
        new Thread(new dK(this, context)).start();
    }

    private void a(View view) {
        this.d = view.findViewById(R.id.setting_about_user_agreement);
        if (Utils.k()) {
            ((TextView) view.findViewById(R.id.user_agreement_txt)).setText(getString(R.string.user_agreement_play));
        }
        this.e = view.findViewById(R.id.setting_about_website);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        View findViewById = view.findViewById(R.id.setting_check_apk_upgrade);
        findViewById.setOnClickListener(this);
        View findViewById2 = view.findViewById(R.id.buy_bracelet_stuff);
        findViewById2.setOnClickListener(this);
        if (this.l.n.a.booleanValue()) {
            this.o = view.findViewById(R.id.setting_check_apk_upgrade_new_icon);
            if (this.n) {
                this.o.setVisibility(0);
            }
            findViewById.setVisibility(0);
            view.findViewById(R.id.split_line_about_apk_upgrade).setVisibility(0);
        } else {
            findViewById.setVisibility(8);
            view.findViewById(R.id.split_line_about_apk_upgrade).setVisibility(8);
        }
        if (this.l.h.a.booleanValue()) {
            findViewById2.setVisibility(0);
            view.findViewById(R.id.split_line_about_buy_band).setVisibility(0);
        } else {
            findViewById2.setVisibility(8);
            view.findViewById(R.id.split_line_about_buy_band).setVisibility(8);
        }
        this.g = (TextView) view.findViewById(R.id.setting_about_version_value);
        view.findViewById(R.id.setting_feedback).setOnClickListener(this);
        view.findViewById(R.id.setting_feedback).setOnLongClickListener(new dG(this));
        this.f = view.findViewById(R.id.logo);
        this.f.setOnClickListener(this);
        this.f.setOnLongClickListener(new dH(this));
        view.findViewById(R.id.enable_hidden_feature).setOnClickListener(this);
    }

    private void b(Context context) {
        try {
            if (this.m != null) {
                this.m.sendEmptyMessage(1);
            }
            String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            File file = new File(absolutePath + "/mili_log_" + format + ".zip");
            if (file.exists()) {
                file.delete();
            }
            byte[] bArr = new byte[ChartData.d];
            File file2 = new File(absolutePath + "/mili_log.txt");
            FileInputStream fileInputStream = new FileInputStream(file2);
            long length = file2.length() - 52428800;
            while (length > 0) {
                long skip = fileInputStream.skip(length);
                if (skip == -1) {
                    break;
                }
                length -= skip;
            }
            ZipEntry zipEntry = new ZipEntry("mili_log_" + format + ".txt");
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            zipOutputStream.putNextEntry(zipEntry);
            while (true) {
                int read = fileInputStream.read(bArr, 0, bArr.length);
                if (read > 0) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    fileInputStream.close();
                    zipOutputStream.close();
                    l.a(context, a.f(context), file, new dL(this, context, file));
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c() {
        try {
            startActivity(new Intent(getActivity(), Class.forName("cn.com.smartdevices.ble.WeightTestAcitvity")));
        } catch (Exception e) {
        }
    }

    private void d() {
        try {
            startActivity(new Intent(getActivity(), Class.forName("cn.com.smartdevices.bracelet.shoes.ui.ShoesBindTestActivity")));
        } catch (Exception e) {
        }
    }

    private void e() {
        Builder builder = new Builder(getActivity());
        builder.setTitle(R.string.upload_log);
        builder.setMessage(R.string.upload_log_info);
        builder.setPositiveButton(R.string.confirm, new dI(this));
        builder.setNegativeButton(R.string.cancel, new dJ(this));
        builder.show();
    }

    private void f() {
        if (Utils.k()) {
            startActivity(new Intent(getActivity(), SettingAboutUserAgreementActivity.class));
            return;
        }
        Utils.r(getActivity());
        C0401a.a(getActivity(), C0401a.ef);
    }

    protected boolean b() {
        return true;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_feedback:
                startActivity(new Intent(getActivity(), SettingFeedbackActivity.class));
                C0401a.a(getActivity(), C0401a.ed);
                return;
            case R.id.setting_about_website:
                String str = "http://www.mi.com/en/";
                String locale = Locale.getDefault().toString();
                if (locale.startsWith(Locale.ENGLISH.toString())) {
                    str = "http://www.mi.com/en/";
                } else if (Locale.SIMPLIFIED_CHINESE.toString().equals(locale)) {
                    str = "http://www.mi.com/";
                } else if (Locale.TRADITIONAL_CHINESE.toString().equals(locale)) {
                    str = "http://www.mi.com/tw/";
                } else if ("zh_HK".equals(locale)) {
                    str = "http://www.mi.com/hk/";
                }
                C0596r.e(b, "Locale.getdefault =" + Locale.getDefault() + str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                startActivity(intent);
                C0401a.a(getActivity(), C0401a.ec);
                return;
            case R.id.setting_check_apk_upgrade:
                if (Utils.l(getActivity())) {
                    if (this.n) {
                        this.o.setVisibility(8);
                    }
                    com.huami.android.view.b.a(getActivity(), (int) R.string.checking_new_apk, 0).show();
                    Utils.a(getActivity(), true);
                } else {
                    com.huami.android.view.b.a(getActivity(), (int) R.string.no_network_connection, 0).show();
                }
                C0401a.a(getActivity(), C0401a.eb);
                return;
            case R.id.buy_bracelet_stuff:
                d.a(getActivity(), true);
                C0401a.a(getActivity(), C0401a.be, C0401a.ce);
                return;
            case R.id.setting_about_user_agreement:
                f();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = getActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.n = arguments.getBoolean(Constant.aP, false);
        }
        C0596r.e(b, "bundle = " + arguments + " isNew = " + this.n);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_setting_about, viewGroup, false);
        a(inflate);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        this.m.removeCallbacksAndMessages(null);
        this.m = null;
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.L);
    }

    public void onResume() {
        super.onResume();
        C0596r.e(b, "onResume() ");
        try {
            this.g.setText(getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        C0401a.a(C0401a.L);
    }
}
