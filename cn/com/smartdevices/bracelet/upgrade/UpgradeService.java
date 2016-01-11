package cn.com.smartdevices.bracelet.upgrade;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ui.dW;
import com.xiaomi.hm.health.bt.model.h;

public class UpgradeService extends IntentService {
    public static final int a = 1;
    public static final int b = 2;
    private static final String c = "UpgradeService";

    public UpgradeService() {
        super(c);
    }

    private void a() {
        f a = i.a(this, i.a());
        C0596r.e(c, "VersionInfo : " + a.toString());
        int c = i.c(this, getPackageName());
        if (c < a.d()) {
            Message message = new Message();
            message.what = i.a;
            Bundle bundle = new Bundle();
            bundle.putString(i.d, a.e());
            bundle.putInt(i.e, a.d());
            String str = new String();
            if (c < a.d()) {
                str = a.b();
            }
            bundle.putString(i.f, str);
            message.setData(bundle);
        }
    }

    public static boolean a(OtaVersionInfo otaVersionInfo, h hVar) {
        C0596r.a("DDDD", "DeviceInfo : " + hVar);
        String str = hVar.d() + "." + hVar.e() + hVar.f() + hVar.c();
        C0596r.a("DDDD", "DeviceFirmwareVersionCode : " + str);
        if (otaVersionInfo.b <= Float.valueOf(str).floatValue()) {
            return false;
        }
        C0596r.a("DDDD", "Need Upgrade Firmware : " + Float.valueOf(str) + " , " + otaVersionInfo.b);
        return true;
    }

    private void b() {
        OtaVersionInfo b = i.b(this, i.b());
        C0596r.a("DDDD", "OTAInfo : " + b);
        if (dW.d != null) {
            Message message = new Message();
            message.what = a;
            message.obj = b;
            dW.d.sendMessage(message);
        }
    }

    public static void start(Context context, int i) {
        Intent intent = new Intent(context, UpgradeService.class);
        intent.putExtra("Request", i);
        context.startService(intent);
    }

    protected void onHandleIntent(Intent intent) {
        switch (intent.getIntExtra("Request", 0)) {
            case a /*1*/:
                a();
                return;
            case b /*2*/:
                b();
                return;
            default:
                return;
        }
    }
}
