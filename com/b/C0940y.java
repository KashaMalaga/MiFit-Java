package com.b;

import android.location.GpsSatellite;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kankan.wheel.widget.a;

public final class C0940y implements Listener, NmeaListener {
    private long a = 0;
    private long b = 0;
    private boolean c = false;
    private List d = new ArrayList();
    private String e = null;
    private String f = null;
    private String g = null;
    private /* synthetic */ at h;

    protected C0940y(at atVar) {
        this.h = atVar;
    }

    public final void a(String str) {
        if (System.currentTimeMillis() - this.b > 400 && this.c && this.d.size() > 0) {
            try {
                ar arVar = new ar(this.d, this.e, null, this.g);
                if (arVar.a()) {
                    this.h.O = at.a(this.h, arVar, this.h.L);
                    if (this.h.O > 0) {
                        at.b(this.h, String.format(Locale.CHINA, "&nmea=%.1f|%.1f&g_tp=%d", new Object[]{Double.valueOf(arVar.c()), Double.valueOf(arVar.b()), Integer.valueOf(this.h.O)}));
                    }
                } else {
                    this.h.O = 0;
                }
            } catch (Exception e) {
                this.h.O = 0;
            }
            this.d.clear();
            this.g = null;
            this.f = null;
            this.e = null;
            this.c = false;
        }
        if (str.startsWith("$GPGGA")) {
            this.c = true;
            this.e = str.trim();
        } else if (str.startsWith("$GPGSV")) {
            this.d.add(str.trim());
        } else if (str.startsWith("$GPGSA")) {
            this.g = str.trim();
        }
        this.b = System.currentTimeMillis();
    }

    public final void onGpsStatusChanged(int i) {
        int i2 = 0;
        try {
            if (this.h.s != null) {
                switch (i) {
                    case a.k /*2*/:
                        this.h.N = 0;
                        return;
                    case a.aQ /*4*/:
                        if (at.a || System.currentTimeMillis() - this.a >= 10000) {
                            if (this.h.J == null) {
                                this.h.J = this.h.s.getGpsStatus(null);
                            } else {
                                this.h.s.getGpsStatus(this.h.J);
                            }
                            this.h.K = 0;
                            this.h.L = 0;
                            this.h.M = new HashMap();
                            int i3 = 0;
                            int i4 = 0;
                            for (GpsSatellite gpsSatellite : this.h.J.getSatellites()) {
                                i3++;
                                if (gpsSatellite.usedInFix()) {
                                    i4++;
                                }
                                if (gpsSatellite.getSnr() > 0.0f) {
                                    i2++;
                                }
                                if (gpsSatellite.getSnr() >= ((float) at.X)) {
                                    this.h.L = this.h.L + 1;
                                }
                            }
                            if (this.h.m == -1 || ((i4 >= 4 && this.h.m < 4) || (i4 < 4 && this.h.m >= 4))) {
                                this.h.m = i4;
                                if (i4 < 4) {
                                    if (this.h.t != null) {
                                        this.h.t.w();
                                    }
                                } else if (this.h.t != null) {
                                    this.h.t.v();
                                }
                            }
                            this.h.N = i2;
                            this.h.a(this.h.M);
                            if (!at.a) {
                                if ((i4 > 3 || i3 > 15) && this.h.s.getLastKnownLocation(GeocodeSearch.GPS) != null) {
                                    this.a = System.currentTimeMillis();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
        }
    }

    public final void onNmeaReceived(long j, String str) {
        try {
            if (at.a && str != null && !str.equals(com.xiaomi.e.a.f) && str.length() >= 9 && str.length() <= a.ap) {
                this.h.F.sendMessage(this.h.F.obtainMessage(1, str));
            }
        } catch (Exception e) {
        }
    }
}
