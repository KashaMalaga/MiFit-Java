package com.huami.android.widget.share;

import java.io.Serializable;

public class l implements Serializable {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public String toString() {
        return "title: " + this.a + "; topic: " + this.b + "; content: " + this.c + "; url: " + this.d + "; imageFile: " + this.e + "; type: " + this.f;
    }
}
