package a.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.support.v7.widget.af;
import android.util.SparseArray;
import java.util.UUID;

public class B {
    public static final String A = "miui.bluetooth.extra.MIBLE_PROPERTY";
    private static final int G = 1;
    private static final int H = 2;
    public static final int a = -1;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = 6;
    public static final int i = 7;
    public static final int j = 101;
    public static final int k = 102;
    public static final int l = 103;
    public static final int m = 104;
    public static final int n = 105;
    public static final int o = 106;
    public static final int p = 107;
    public static final int q = -1;
    public static final int r = 0;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = 3;
    public static final int v = 4;
    protected static final boolean w = true;
    protected static final String x = "MiBleProfile";
    public static final String y = "miui.bluetooth.mible.Service";
    public static final String z = "miui.bluetooth.action.PICK_DEVICE";
    protected String B;
    protected C0007e C;
    protected Context D;
    protected G E;
    protected final ParcelUuid F;
    private final IBinder I;
    private boolean J;
    private SparseArray<C0000H> K;
    private Handler L;
    private int M;
    private ServiceConnection N;
    private h O;
    private k P;

    public B(Context context, String str) {
        this(context, str, null);
    }

    public B(Context context, String str, G g) {
        this.F = new ParcelUuid(UUID.randomUUID());
        this.I = new Binder();
        this.J = false;
        this.K = new SparseArray();
        this.M = r;
        this.N = new C(this);
        this.O = new D(this);
        this.P = new E(this);
        this.B = str;
        this.D = context;
        this.E = g;
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        this.L = new Handler(new F(this));
    }

    public void a(G g) {
        this.E = g;
    }

    public boolean a(int i) {
        try {
            return (this.C == null || !this.C.a(this.B, i)) ? false : w;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean a(int i, C0000H c0000h) {
        boolean a;
        this.K.put(i, c0000h);
        if (this.C != null) {
            try {
                a = this.C.a(this.B, this.F, i, this.P);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if (!a) {
                return w;
            }
            this.K.remove(i);
            return false;
        }
        a = false;
        if (!a) {
            return w;
        }
        this.K.remove(i);
        return false;
    }

    public boolean a(int i, byte[] bArr) {
        if (this.C != null) {
            try {
                return this.C.a(this.B, this.F, i, bArr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int b() {
        if (this.C != null) {
            try {
                return this.C.b();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return q;
    }

    public byte[] b(int i) {
        if (this.C != null) {
            try {
                return this.C.a(this.B, this.F, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String c() {
        return this.B;
    }

    public boolean c(int i) {
        this.K.remove(i);
        if (this.K.get(i) != null) {
            return w;
        }
        try {
            return this.C != null ? this.C.b(this.B, this.F, i, this.P) : w;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void d() {
        if (this.C == null) {
            this.J = w;
            Intent intent = new Intent(y);
            intent.setClassName("com.android.bluetooth", "com.android.bluetooth.ble.BluetoothMiBleService");
            intent.setPackage("com.android.bluetooth");
            if (!this.D.bindService(intent, this.N, s)) {
                this.L.sendMessage(this.L.obtainMessage(s, q, r));
                return;
            }
            return;
        }
        try {
            this.C.a(this.B, this.F);
        } catch (RemoteException e) {
            e.printStackTrace();
            this.L.sendMessage(this.L.obtainMessage(s, q, r));
        }
    }

    public void e() {
        if (this.C != null) {
            try {
                this.C.a(this.I, this.B, this.F);
                this.D.unbindService(this.N);
            } catch (RemoteException e) {
                e.printStackTrace();
                this.L.sendMessage(this.L.obtainMessage(s, q, r));
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                this.L.sendMessage(this.L.obtainMessage(s, q, r));
            }
        }
    }

    public boolean f() {
        return this.M == v ? w : false;
    }

    public int g() {
        if (f()) {
            try {
                return this.C.c(this.B, this.F);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return af.a;
    }
}
