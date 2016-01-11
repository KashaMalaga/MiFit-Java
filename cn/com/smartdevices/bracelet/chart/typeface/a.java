package cn.com.smartdevices.bracelet.chart.typeface;

import cn.com.smartdevices.bracelet.ui.C0763dl;

public enum a implements d {
    NORMAL(C0763dl.b, "fonts/MIUI/MIUI-Normal.ttf"),
    LIGHT("miui-light", "fonts/MIUI/MIUI-Light.ttf"),
    BOLD("miui-bold", "fonts/MIUI/MIUI-Bold.ttf");
    
    private String d;
    private String e;

    private a(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public String a() {
        return this.e;
    }

    public String b() {
        return this.d;
    }
}
