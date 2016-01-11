package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.xiaomi.account.openauth.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class bM implements ServiceConnection, Callback {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final String e = "binder";
    private final Context f;
    private final HandlerThread g;
    private final Handler h;
    private final Map<ComponentName, bN> i = new HashMap();
    private Set<String> j = new HashSet();

    public bM(Context context) {
        this.f = context;
        this.g = new HandlerThread("NotificationManagerCompat");
        this.g.start();
        this.h = new Handler(this.g.getLooper(), this);
    }

    private void a() {
        Set b = bE.b(this.f);
        if (!b.equals(this.j)) {
            this.j = b;
            List<ResolveInfo> queryIntentServices = this.f.getPackageManager().queryIntentServices(new Intent().setAction(bE.b), 4);
            Set<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (b.contains(resolveInfo.serviceInfo.packageName)) {
                    ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.i.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", d)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.i.put(componentName2, new bN(componentName2));
                }
            }
            Iterator it = this.i.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (!hashSet.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", d)) {
                        Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                    }
                    b((bN) entry.getValue());
                    it.remove();
                }
            }
        }
    }

    private void a(ComponentName componentName) {
        bN bNVar = (bN) this.i.get(componentName);
        if (bNVar != null) {
            b(bNVar);
        }
    }

    private void a(ComponentName componentName, IBinder iBinder) {
        bN bNVar = (bN) this.i.get(componentName);
        if (bNVar != null) {
            bNVar.c = C0032at.a(iBinder);
            bNVar.e = a;
            d(bNVar);
        }
    }

    private boolean a(bN bNVar) {
        if (bNVar.b) {
            return true;
        }
        bNVar.b = this.f.bindService(new Intent(bE.b).setComponent(bNVar.a), this, bE.h);
        if (bNVar.b) {
            bNVar.e = a;
        } else {
            Log.w("NotifManCompat", "Unable to bind to listener " + bNVar.a);
            this.f.unbindService(this);
        }
        return bNVar.b;
    }

    private void b(ComponentName componentName) {
        bN bNVar = (bN) this.i.get(componentName);
        if (bNVar != null) {
            d(bNVar);
        }
    }

    private void b(bN bNVar) {
        if (bNVar.b) {
            this.f.unbindService(this);
            bNVar.b = false;
        }
        bNVar.c = null;
    }

    private void b(bO bOVar) {
        a();
        for (bN bNVar : this.i.values()) {
            bNVar.d.add(bOVar);
            d(bNVar);
        }
    }

    private void c(bN bNVar) {
        if (!this.h.hasMessages(d, bNVar.a)) {
            bNVar.e += b;
            if (bNVar.e > 6) {
                Log.w("NotifManCompat", "Giving up on delivering " + bNVar.d.size() + " tasks to " + bNVar.a + " after " + bNVar.e + " retries");
                bNVar.d.clear();
                return;
            }
            int i = (b << (bNVar.e - 1)) * h.E;
            if (Log.isLoggable("NotifManCompat", d)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
            }
            this.h.sendMessageDelayed(this.h.obtainMessage(d, bNVar.a), (long) i);
        }
    }

    private void d(bN bNVar) {
        if (Log.isLoggable("NotifManCompat", d)) {
            Log.d("NotifManCompat", "Processing component " + bNVar.a + ", " + bNVar.d.size() + " queued tasks");
        }
        if (!bNVar.d.isEmpty()) {
            if (!a(bNVar) || bNVar.c == null) {
                c(bNVar);
                return;
            }
            while (true) {
                bO bOVar = (bO) bNVar.d.peek();
                if (bOVar == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", d)) {
                        Log.d("NotifManCompat", "Sending task " + bOVar);
                    }
                    bOVar.a(bNVar.c);
                    bNVar.d.remove();
                } catch (DeadObjectException e) {
                    if (Log.isLoggable("NotifManCompat", d)) {
                        Log.d("NotifManCompat", "Remote service has died: " + bNVar.a);
                    }
                } catch (Throwable e2) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + bNVar.a, e2);
                }
            }
            if (!bNVar.d.isEmpty()) {
                c(bNVar);
            }
        }
    }

    public void a(bO bOVar) {
        this.h.obtainMessage(a, bOVar).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case a /*0*/:
                b((bO) message.obj);
                return true;
            case b /*1*/:
                bL bLVar = (bL) message.obj;
                a(bLVar.a, bLVar.b);
                return true;
            case c /*2*/:
                a((ComponentName) message.obj);
                return true;
            case d /*3*/:
                b((ComponentName) message.obj);
                return true;
            default:
                return false;
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", d)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        this.h.obtainMessage(b, new bL(componentName, iBinder)).sendToTarget();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", d)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        this.h.obtainMessage(c, componentName).sendToTarget();
    }
}
