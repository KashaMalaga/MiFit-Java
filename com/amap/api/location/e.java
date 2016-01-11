package com.amap.api.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.location.core.c;
import com.b.ap;

class e implements LocationListener {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void onLocationChanged(Location location) {
        AMapLocation aMapLocation;
        AMapLocation aMapLocation2;
        Exception e;
        Throwable th;
        Message message;
        Message message2;
        try {
            this.a.d.b(true);
            this.a.d.d = System.currentTimeMillis();
            aMapLocation = null;
            if (location == null) {
                message2 = new Message();
                message2.obj = null;
                message2.what = 100;
                if (this.a.c != null) {
                    this.a.c.sendMessage(message2);
                }
                this.a.d.c = true;
                this.a.d.d = System.currentTimeMillis();
                if (this.a.d.b != null && this.a.d.b.a != null) {
                    this.a.d.b.a.a(null);
                    return;
                }
                return;
            }
            if (c.a(location.getLatitude(), location.getLongitude())) {
                double[] a = ap.a(location.getLongitude(), location.getLatitude());
                aMapLocation2 = new AMapLocation(location);
                try {
                    aMapLocation2.setLatitude(a[1]);
                    aMapLocation2.setLongitude(a[0]);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        message2 = new Message();
                        message2.obj = aMapLocation2;
                        message2.what = 100;
                        if (this.a.c != null) {
                            this.a.c.sendMessage(message2);
                        }
                        this.a.d.c = true;
                        this.a.d.d = System.currentTimeMillis();
                        if (this.a.d.b != null && this.a.d.b.a != null) {
                            this.a.d.b.a.a(aMapLocation2);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        aMapLocation = aMapLocation2;
                        message = new Message();
                        message.obj = aMapLocation;
                        message.what = 100;
                        if (this.a.c != null) {
                            this.a.c.sendMessage(message);
                        }
                        this.a.d.c = true;
                        this.a.d.d = System.currentTimeMillis();
                        this.a.d.b.a.a(aMapLocation);
                        throw th;
                    }
                }
            }
            aMapLocation2 = new AMapLocation(location);
            message2 = new Message();
            message2.obj = aMapLocation2;
            message2.what = 100;
            if (this.a.c != null) {
                this.a.c.sendMessage(message2);
            }
            this.a.d.c = true;
            this.a.d.d = System.currentTimeMillis();
            if (this.a.d.b != null && this.a.d.b.a != null) {
                this.a.d.b.a.a(aMapLocation2);
            }
        } catch (Exception e3) {
            e = e3;
            aMapLocation2 = null;
            e.printStackTrace();
            message2 = new Message();
            message2.obj = aMapLocation2;
            message2.what = 100;
            if (this.a.c != null) {
                this.a.c.sendMessage(message2);
            }
            this.a.d.c = true;
            this.a.d.d = System.currentTimeMillis();
            if (this.a.d.b != null) {
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
