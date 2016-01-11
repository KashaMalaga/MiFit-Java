package cn.com.smartdevices.bracelet.gps.f;

import android.util.SparseArray;
import cn.com.smartdevices.bracelet.gps.algorithm.GPSManager;
import cn.com.smartdevices.bracelet.gps.h.e;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.g;
import com.tencent.mm.sdk.modelbase.BaseResp.ErrCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class z {
    private static final int a = GPSManager.STEP_SIZE;
    private static final int b = GPSManager.RING_SIZE;
    private static final int c = b;
    private static final int d = ((b + a) * 2);
    private static final String h = "RouteLineSM";
    private SparseArray<c> e;
    private A f;
    private int g;

    public z() {
        this.e = null;
        this.f = null;
        this.g = d;
        this.e = new SparseArray();
    }

    public z(A a) {
        this.e = null;
        this.f = null;
        this.g = d;
        this.f = a;
        this.e = new SparseArray();
    }

    private int a(SparseArray<c> sparseArray, g gVar, int i) {
        int size = sparseArray.size();
        List arrayList = new ArrayList(size - 1);
        List<Integer> arrayList2 = new ArrayList(size - 1);
        HashMap hashMap = new HashMap();
        int i2 = -1;
        Object obj = null;
        int i3 = d;
        int i4 = i;
        while (i3 < size) {
            Object obj2;
            int i5;
            c cVar = (c) sparseArray.valueAt(i3);
            if (cVar == null) {
                obj2 = obj;
                i5 = i2;
                i2 = i4;
            } else {
                i2 = cVar.b();
                int d = cVar.d();
                arrayList.add(cVar);
                arrayList2.add(Integer.valueOf(d));
                if (obj == null && a(i2, i4)) {
                    obj = 1;
                }
                switch (i2) {
                    case ErrCode.ERR_AUTH_DENIED /*-4*/:
                    case ErrCode.ERR_SENT_FAILED /*-3*/:
                        cVar.b(1);
                        arrayList.clear();
                        arrayList.add(cVar);
                        break;
                    case d /*?: ONE_ARG  (wrap: int
  0x0011: ARITH  (r0_5 int) = (wrap: int
  0x0010: ARITH  (r0_4 int) = (wrap: int
  0x000c: SGET  (r0_3 int) =  cn.com.smartdevices.bracelet.gps.f.z.b int) + (wrap: int
  0x000e: SGET  (r1_0 int) =  cn.com.smartdevices.bracelet.gps.f.z.a int)) * (2 int))*/:
                    case l.a /*1*/:
                        if (Math.abs(i4) == 2 && d != 0) {
                            a(cVar, 2);
                        }
                        if (Math.abs(i4) == 4) {
                            if (d != 0) {
                                a(cVar, 2);
                            }
                            e.a("Lost", "PRE LOST = " + arrayList.size());
                            if (arrayList.size() > 0) {
                                g a = gVar.a();
                                a.f = true;
                                b(arrayList, a);
                                arrayList.clear();
                                arrayList.add(cVar);
                                break;
                            }
                        }
                        break;
                    case a.k /*2*/:
                        if (d != 0) {
                            a(cVar, 2);
                        }
                        if (arrayList.size() > 0) {
                            b(arrayList, gVar);
                        }
                        arrayList.clear();
                        break;
                    case a.l /*3*/:
                    case a.aQ /*4*/:
                        if (d != 0) {
                            a(cVar, 2);
                        }
                        if (arrayList.size() > 0) {
                            b(arrayList, gVar);
                        }
                        arrayList.clear();
                        arrayList.add(cVar);
                        cVar = cVar.a();
                        cVar.b(-i2);
                        hashMap.put(Integer.valueOf(d), cVar);
                        break;
                }
                int abs = Math.abs(i2);
                if (i3 == size - 1 && arrayList.size() > 0 && size > 1) {
                    a(arrayList, gVar, false);
                }
                Object obj3 = obj;
                i5 = i2;
                i2 = abs;
                obj2 = obj3;
            }
            i3++;
            i4 = i2;
            i2 = i5;
            obj = obj2;
        }
        if (obj != null) {
            for (Integer intValue : arrayList2) {
                sparseArray.remove(intValue.intValue());
            }
            for (Entry entry : hashMap.entrySet()) {
                sparseArray.put(((Integer) entry.getKey()).intValue(), entry.getValue());
            }
        }
        arrayList2.clear();
        arrayList.clear();
        hashMap.clear();
        return i2;
    }

    private int a(List<c> list) {
        int size = this.e.size();
        if (size <= 0) {
            return this.g;
        }
        c cVar = (c) this.e.valueAt(size - 1);
        if (cVar == null) {
            return this.g;
        }
        int d = ((c) list.get(d)).d();
        if (cVar.d() < d) {
            return cVar.b();
        }
        cVar = (c) this.e.get(d - 1);
        return cVar != null ? cVar.b() : d;
    }

    private void a(SparseArray<c> sparseArray, List<c> list) {
        for (c cVar : list) {
            sparseArray.put(cVar.d(), cVar);
        }
    }

    private void a(c cVar, int i) {
        if (this.f != null) {
            this.f.a(cVar, i);
        }
    }

    private void a(List<c> list, g gVar, boolean z) {
        if (this.f != null) {
            gVar.j = 1;
            this.f.a(list, gVar, z);
        }
    }

    private boolean a(int i, int i2) {
        return (i == 3 || i == 2 || i == 4) ? true : i2 == 4 && i == 1;
    }

    private boolean a(g gVar) {
        int i = d;
        if (this.e.size() != d) {
            return false;
        }
        int i2;
        List arrayList = new ArrayList(c);
        for (i2 = d; i2 < c; i2++) {
            arrayList.add(this.e.get(i2));
        }
        if (arrayList.size() >= 2 && this.f != null) {
            gVar.j = d;
            this.f.a(arrayList, gVar);
        }
        arrayList.clear();
        int i3 = c - 1;
        for (i2 = d; i2 < i3; i2++) {
            this.e.remove(d);
        }
        if (this.f != null) {
            gVar.j = 1;
            i3 = this.e.size();
            List arrayList2 = new ArrayList(i3);
            while (i < i3) {
                arrayList2.add((c) this.e.valueAt(i));
                i++;
            }
            this.f.a(arrayList2, gVar, true);
        }
        return true;
    }

    private void b(List<c> list, g gVar) {
        if (this.f != null) {
            gVar.j = d;
            this.f.a((List) list, gVar);
        }
    }

    public void a() {
        if (this.e != null) {
            this.e.clear();
        }
        this.f = null;
    }

    public void a(A a) {
        if (a == null) {
            throw new IllegalArgumentException("Argument can't be null");
        }
        this.f = a;
    }

    public boolean a(List<c> list, g gVar) {
        int a = a((List) list);
        a(this.e, (List) list);
        this.g = a(this.e, gVar, a);
        a(gVar);
        return true;
    }

    public void b(A a) {
        if (a == null) {
            throw new IllegalArgumentException("Argument can't be null");
        }
        this.f = null;
    }
}
