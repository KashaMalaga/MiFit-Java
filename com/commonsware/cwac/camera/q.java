package com.commonsware.cwac.camera;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import kankan.wheel.widget.a;
import org.xmlpull.v1.XmlPullParser;

public class q extends k {
    private boolean a;
    private boolean b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private boolean g;
    private int h;
    private d i;

    public q() {
        boolean z = VERSION.SDK_INT >= 16 && !i();
        this.a = z;
        this.b = false;
        this.c = 0;
        this.d = Integer.MAX_VALUE;
        this.e = true;
        this.f = -1;
        this.g = false;
        this.h = 0;
        this.i = d.NONE;
    }

    @SuppressLint({"DefaultLocale"})
    private void a(String str, String str2) {
        if ("useTextureView".equals(str)) {
            this.a = Boolean.parseBoolean(str2);
        } else if ("portraitFFCFlipped".equals(str)) {
            this.b = Boolean.parseBoolean(str2);
        } else if ("doesZoomActuallyWork".equals(str)) {
            this.e = Boolean.parseBoolean(str2);
        } else if ("useDeviceOrientation".equals(str)) {
            this.g = Boolean.parseBoolean(str2);
        } else if ("minPictureHeight".equals(str)) {
            this.c = Integer.parseInt(str2);
        } else if ("maxPictureHeight".equals(str)) {
            this.d = Integer.parseInt(str2);
        } else if ("pictureDelay".equals(str)) {
            this.h = Integer.parseInt(str2);
        } else if ("recordingHint".equals(str)) {
            String toUpperCase = str2.toUpperCase();
            if ("ANY".equals(toUpperCase)) {
                this.i = d.ANY;
            } else if ("STILL_ONLY".equals(toUpperCase)) {
                this.i = d.STILL_ONLY;
            } else if ("VIDEO_ONLY".equals(toUpperCase)) {
                this.i = d.VIDEO_ONLY;
            }
        }
    }

    private boolean i() {
        return System.getProperty("os.version").contains("cyanogenmod") || Build.HOST.contains("cyanogenmod");
    }

    q a(XmlPullParser xmlPullParser) {
        StringBuilder stringBuilder = null;
        while (xmlPullParser.getEventType() != 1) {
            try {
                switch (xmlPullParser.getEventType()) {
                    case a.k /*2*/:
                        stringBuilder = new StringBuilder();
                        break;
                    case a.l /*3*/:
                        if (stringBuilder != null) {
                            a(xmlPullParser.getName(), stringBuilder.toString().trim());
                            break;
                        }
                        break;
                    case a.aQ /*4*/:
                        if (stringBuilder != null) {
                            stringBuilder.append(xmlPullParser.getText());
                            break;
                        }
                        break;
                }
                xmlPullParser.next();
            } catch (Throwable e) {
                Log.e("CWAC-Camera", String.format("Exception parsing device profile for %s %s", new Object[]{Build.MANUFACTURER, Build.MODEL}), e);
            }
        }
        return this;
    }

    public boolean a() {
        return this.a;
    }

    public boolean a(boolean z) {
        return this.e;
    }

    public boolean b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public d h() {
        return this.i;
    }
}
