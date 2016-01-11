package com.b;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.telephony.CellLocation;
import java.util.List;

public final class C {
    private static int c = 10;
    private static int d = 100;
    private static float f = 0.5f;
    protected H a = new H(this);
    protected D b = new D(this);
    private C0930o e;

    protected C(C0930o c0930o) {
        this.e = c0930o;
    }

    protected static void a() {
    }

    protected static void a(int i) {
        c = i;
    }

    protected static void b(int i) {
        d = i;
    }

    protected final boolean a(Location location) {
        boolean z = false;
        if (this.e != null) {
            List j = this.e.j();
            if (!(j == null || location == null)) {
                "cell.list.size: " + j.size();
                F f = null;
                if (j.size() >= 2) {
                    F f2 = new F((CellLocation) j.get(1));
                    if (this.b.b == null) {
                        f = f2;
                        z = true;
                    } else {
                        boolean z2 = location.distanceTo(this.b.b) > ((float) d);
                        if (!z2) {
                            int i;
                            f = this.b.a;
                            if (f2.e == f.e && f2.d == f.d && f2.c == f.c && f2.b == f.b && f2.a == f.a) {
                                i = 1;
                            } else {
                                z2 = false;
                            }
                            z2 = i == 0;
                        }
                        "collect cell?: " + z2;
                        z = z2;
                        f = f2;
                    }
                }
                if (z) {
                    this.b.a = f;
                }
            }
        }
        return z;
    }

    protected final boolean b(Location location) {
        int i = 0;
        if (this.e == null) {
            return false;
        }
        boolean z;
        List list;
        List k = this.e.k();
        if (k.size() >= 2) {
            List list2 = (List) k.get(1);
            if (this.a.b == null) {
                z = true;
            } else if (list2 == null || list2.size() <= 0) {
                list = list2;
                z = false;
            } else {
                z = location.distanceTo(this.a.b) > ((float) c);
                if (z) {
                    list = list2;
                } else {
                    int i2;
                    List list3 = this.a.a;
                    float f = f;
                    if (list2 == null || list3 == null) {
                        i2 = 0;
                    } else if (list2 == null || list3 == null) {
                        i2 = 0;
                    } else {
                        int size = list2.size();
                        int size2 = list3.size();
                        float f2 = (float) (size + size2);
                        if (size == 0 && size2 == 0) {
                            i2 = 1;
                        } else if (size == 0 || size2 == 0) {
                            i2 = 0;
                        } else {
                            int i3 = 0;
                            int i4 = 0;
                            while (i3 < size) {
                                String str = ((ScanResult) list2.get(i3)).BSSID;
                                if (str != null) {
                                    for (int i5 = 0; i5 < size2; i5++) {
                                        if (str.equals(((G) list3.get(i5)).a)) {
                                            i2 = i4 + 1;
                                            break;
                                        }
                                    }
                                }
                                i2 = i4;
                                i3++;
                                i4 = i2;
                            }
                            i2 = ((float) (i4 << 1)) >= f2 * f ? 1 : 0;
                        }
                    }
                    z = i2 == 0;
                }
            }
            list = list2;
        } else {
            list = null;
            z = false;
        }
        if (z) {
            this.a.a.clear();
            int size3 = list.size();
            while (i < size3) {
                this.a.a.add(new G(((ScanResult) list.get(i)).BSSID));
                i++;
            }
        }
        return z;
    }
}
