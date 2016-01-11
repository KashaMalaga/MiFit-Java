package cn.com.smartdevices.bracelet.activity;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.j.m;
import cn.com.smartdevices.bracelet.model.PersonInfo;

public class G {
    final /* synthetic */ WebActivity a;

    public G(WebActivity webActivity) {
        this.a = webActivity;
    }

    @JavascriptInterface
    public void a(String str, String str2) {
        C0596r.e("WPJ", "uid:" + str + ",security:" + str2);
    }

    @JavascriptInterface
    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z = true;
        C0596r.e("WebActivity", "uid:" + str + ",security:" + str2 + ",iconUrl:" + str3 + ",nick name:" + str4 + ",has bind:" + str5);
        a.a(this.a.mContext, Long.parseLong(str), str2);
        if (Integer.parseInt(str5) != 1) {
            z = false;
        }
        if (z) {
            C0596r.e("WebActivity", "userInfo=" + str6);
            PersonInfo readPersonInfo = Keeper.readPersonInfo();
            m.a(str6, readPersonInfo);
            readPersonInfo.uid = Long.parseLong(str);
            Keeper.keepPersonInfo(readPersonInfo);
        }
        Intent intent = new Intent();
        intent.putExtra(kankan.wheel.widget.a.N, str3);
        intent.putExtra(kankan.wheel.widget.a.O, str4);
        intent.putExtra(kankan.wheel.widget.a.P, z);
        this.a.setResult(3, intent);
        this.a.finish();
    }
}
