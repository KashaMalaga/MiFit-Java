package cn.com.smartdevices.bracelet.gps.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder.DeathRecipient;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.h.h;
import cn.com.smartdevices.bracelet.gps.model.k;
import cn.com.smartdevices.bracelet.gps.sync.C0467k;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import cn.com.smartdevices.bracelet.gps.sync.DataSyncObject;
import cn.com.smartdevices.bracelet.gps.sync.SyncSportDataService;
import com.huami.android.widget.f;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class C0500ak {
    private static final int a = 3;
    private ao b = null;
    private C0502am c = null;
    private C0505aq d = null;
    private HashMap<String, DataSyncObject> e = null;
    private HashMap<String, DataSyncObject> f = null;
    private C0503an g = null;
    private final DeathRecipient h = new C0501al(this);
    private C0467k i = null;
    private Context j = null;
    private ConcurrentLinkedQueue<C0504ap> k = null;

    public C0500ak(Context context) {
        this.j = context;
        this.k = new ConcurrentLinkedQueue();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new C0503an(this);
        this.d = new C0505aq();
        Intent intent = new Intent(this.j, SyncSportDataService.class);
        this.j.startService(intent);
        this.j.bindService(intent, this.d, 1);
    }

    private void a(DataSyncObject dataSyncObject) {
        boolean z = dataSyncObject.b.getBoolean(C0483q.g, false);
        int i = dataSyncObject.b.getInt(f.a, -1);
        C0596r.e("UI", "doTrackDiffSyncedDone ID isDiffSucceeded = " + z + ",diffResultMsg = " + i);
        String str = dataSyncObject.a;
        DataSyncObject dataSyncObject2 = (DataSyncObject) this.f.get(str);
        if (dataSyncObject2 != null) {
            dataSyncObject = dataSyncObject2;
        }
        this.f.remove(str);
        if (z && 1 == i) {
            long j = dataSyncObject.b.getLong(C0483q.e);
            long j2 = dataSyncObject.b.getLong(C0483q.f);
            if (this.b != null) {
                this.b.a(j2, j, true, -1);
            }
        } else if (this.b != null) {
            this.b.a(-1, -1, z, i);
        }
    }

    private void b(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j * 1000);
        k kVar = new k(instance);
        instance.setTimeInMillis(j2 * 1000);
        C0596r.e("UI", "printDayTime startDayTime = " + kVar.b() + ",endDayTime = " + new k(instance).b());
    }

    private void b(DataSyncObject dataSyncObject) {
        long j = -1;
        boolean z = dataSyncObject.b.getBoolean(C0483q.g, false);
        int i = dataSyncObject.b.getInt(f.a, -1);
        String str = dataSyncObject.a;
        try {
            long j2 = dataSyncObject.b.getLong(C0483q.b, 0);
            if (j2 <= -2) {
                j2 = -2;
            }
            C0596r.e("UI", "doTrackMoreSyncedDone ID isSucceeded = " + z + ",resultMsg = " + i + ",mNextToSyncTime = " + j2);
            if (!z || i == 2) {
                if (this.b != null) {
                    this.b.a(-1, -1, j2, false, i);
                }
                this.e.remove(str);
                return;
            }
            long j3;
            if (i == 1) {
                DataSyncObject dataSyncObject2 = (DataSyncObject) this.e.get(str);
                if (dataSyncObject2 != null) {
                    dataSyncObject = dataSyncObject2;
                }
                j3 = dataSyncObject.b.getLong(C0483q.e);
                j = dataSyncObject.b.getLong(C0483q.f);
            } else {
                j3 = -1;
            }
            if (this.b != null) {
                this.b.a(j, j3, j2, true, -1);
            }
            this.e.remove(str);
        } catch (Throwable th) {
            this.e.remove(str);
        }
    }

    private long[] b(long j) {
        if (j == -1) {
            j = System.currentTimeMillis() / 1000;
        }
        b(h.b(j, -2), h.a(j));
        return new long[]{r0, r2};
    }

    public void a() {
        if (this.g != null) {
            this.g.a();
        }
        if (!(this.c == null || this.i == null)) {
            this.i.b(this.c);
        }
        if (this.e != null) {
            this.e.clear();
        }
        if (this.f != null) {
            this.f.clear();
        }
        if (this.k != null) {
            this.k.clear();
        }
        if (this.d != null) {
            this.j.unbindService(this.d);
        }
    }

    void a(long j) {
        C0596r.e("UI", "syncMoreDataCommand");
        DataSyncObject dataSyncObject = new DataSyncObject();
        Bundle bundle = new Bundle();
        long[] b = b(j);
        bundle.putLong(C0483q.e, b[0]);
        bundle.putLong(C0483q.f, b[1]);
        bundle.putInt(C0483q.i, 2);
        dataSyncObject.b = bundle;
        this.e.put(dataSyncObject.a, dataSyncObject);
        if (this.i != null) {
            this.i.a(dataSyncObject);
        } else {
            this.k.add(new C0504ap(this, 1, j));
        }
    }

    public void a(ao aoVar) {
        if (aoVar != null) {
            this.b = aoVar;
        }
    }

    boolean a(long j, long j2) {
        long b = h.b(j <= 0 ? System.currentTimeMillis() / 1000 : j);
        long a = h.a(j2 <= 0 ? System.currentTimeMillis() / 1000 : j2);
        C0596r.e("UI", "syncDataTwoWayCommand");
        b(b, a);
        DataSyncObject dataSyncObject = new DataSyncObject();
        Bundle bundle = new Bundle();
        bundle.putLong(C0483q.e, b);
        bundle.putLong(C0483q.f, a);
        bundle.putInt(C0483q.i, 1);
        dataSyncObject.b = bundle;
        this.f.put(dataSyncObject.a, dataSyncObject);
        if (this.i != null) {
            this.i.a(dataSyncObject);
        } else {
            this.k.add(new C0504ap(this, 0, j, j2));
        }
        return true;
    }

    void b() {
        C0596r.e("UI", "syncSportStatCommand");
        DataSyncObject dataSyncObject = new DataSyncObject();
        Bundle bundle = new Bundle();
        bundle.putInt(C0483q.i, a);
        dataSyncObject.b = bundle;
        this.e.put(dataSyncObject.a, dataSyncObject);
        if (this.i != null) {
            this.i.a(dataSyncObject);
        } else {
            this.k.add(new C0504ap(this, 2, -1));
        }
    }

    public void b(ao aoVar) {
        this.b = null;
    }
}
