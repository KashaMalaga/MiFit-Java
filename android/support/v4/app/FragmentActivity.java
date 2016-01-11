package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.a.q;
import android.support.v4.l.u;
import android.support.v4.view.C0151az;
import android.support.v4.view.a.C0113o;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import kankan.wheel.widget.a;

public class FragmentActivity extends Activity {
    static final String a = "android:support:fragments";
    static final int b = 1;
    static final int c = 2;
    private static final String q = "FragmentActivity";
    private static final int r = 11;
    final Handler d = new N(this);
    final U e = new U();
    final Q f = new O(this);
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    u<String, aA> o;
    aA p;

    private static String a(View view) {
        char c = 'F';
        char c2 = '.';
        StringBuilder stringBuilder = new StringBuilder(C0113o.h);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case a.i /*0*/:
                stringBuilder.append('V');
                break;
            case a.aQ /*4*/:
                stringBuilder.append('I');
                break;
            case a.ba /*8*/:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        stringBuilder.append(view.isFocusable() ? 'F' : '.');
        stringBuilder.append(view.isEnabled() ? 'E' : '.');
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        stringBuilder.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        stringBuilder.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        stringBuilder.append(view.isClickable() ? 'C' : '.');
        stringBuilder.append(view.isLongClickable() ? 'L' : '.');
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c2 = 'P';
        }
        stringBuilder.append(c2);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (C0151az.s & id) {
                    case C0151az.u /*16777216*/:
                        str = MiPushMessageReceiver.ANDROID;
                        break;
                    case 2130706432:
                        str = NativeInterface.APP_SCHEME;
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(a.ci);
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i += b) {
                    a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    aA a(String str, boolean z, boolean z2) {
        if (this.o == null) {
            this.o = new u();
        }
        aA aAVar = (aA) this.o.get(str);
        if (aAVar != null) {
            aAVar.a(this);
            return aAVar;
        } else if (!z2) {
            return aAVar;
        } else {
            aAVar = new aA(str, this, z);
            this.o.put(str, aAVar);
            return aAVar;
        }
    }

    public void a() {
        C0075m.c(this);
    }

    public void a(Fragment fragment) {
    }

    public void a(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if ((android.support.v4.e.a.a.c & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            super.startActivityForResult(intent, ((fragment.mIndex + b) << 16) + (android.support.v4.e.a.a.a & i));
        }
    }

    public void a(cn cnVar) {
        C0075m.a(this, cnVar);
    }

    void a(String str) {
        if (this.o != null) {
            aA aAVar = (aA) this.o.get(str);
            if (aAVar != null && !aAVar.h) {
                aAVar.h();
                this.o.remove(str);
            }
        }
    }

    void a(boolean z) {
        if (!this.j) {
            this.j = true;
            this.k = z;
            this.d.removeMessages(b);
            h();
        }
    }

    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public void b() {
        C0075m.d(this);
    }

    public void b(cn cnVar) {
        C0075m.b(this, cnVar);
    }

    public void c() {
        C0075m.e(this);
    }

    protected void d() {
        this.e.r();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= r) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.g);
            printWriter.print("mResumed=");
            printWriter.print(this.h);
            printWriter.print(" mStopped=");
            printWriter.print(this.i);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.j);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.n);
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.g);
            printWriter.print("mResumed=");
            printWriter.print(this.h);
            printWriter.print(" mStopped=");
            printWriter.print(this.i);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.j);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.n);
        }
        if (this.p != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.p)));
            printWriter.println(a.ci);
            this.p.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.e.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        a(str + "  ", printWriter, getWindow().getDecorView());
    }

    public Object e() {
        return null;
    }

    public Object f() {
        P p = (P) getLastNonConfigurationInstance();
        return p != null ? p.b : null;
    }

    public void g() {
        if (VERSION.SDK_INT >= r) {
            C0080r.a(this);
        } else {
            this.l = true;
        }
    }

    void h() {
        if (this.n) {
            this.n = false;
            if (this.p != null) {
                if (this.k) {
                    this.p.d();
                } else {
                    this.p.c();
                }
            }
        }
        this.e.u();
    }

    public R i() {
        return this.e;
    }

    public ay j() {
        if (this.p != null) {
            return this.p;
        }
        this.m = true;
        this.p = a("(root)", this.n, true);
        return this.p;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.e.n();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            if (this.e.l == null || i3 < 0 || i3 >= this.e.l.size()) {
                Log.w(q, "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.e.l.get(i3);
            if (fragment == null) {
                Log.w(q, "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.onActivityResult(android.support.v4.e.a.a.a & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.e.e()) {
            a();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.e.a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.e.a(this, this.f, null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        P p = (P) getLastNonConfigurationInstance();
        if (p != null) {
            this.o = p.e;
        }
        if (bundle != null) {
            this.e.a(bundle.getParcelable(a), p != null ? p.d : null);
        }
        this.e.o();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        return VERSION.SDK_INT >= r ? super.onCreatePanelMenu(i, menu) | this.e.a(menu, getMenuInflater()) : true;
    }

    public View onCreateView(String str, @q Context context, @q AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        View onCreateView = this.e.onCreateView(str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }

    protected void onDestroy() {
        super.onDestroy();
        a(false);
        this.e.w();
        if (this.p != null) {
            this.p.h();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.e.x();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case a.i /*0*/:
                return this.e.a(menuItem);
            case a.bt /*6*/:
                return this.e.b(menuItem);
            default:
                return false;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.e.n();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case a.i /*0*/:
                this.e.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.h = false;
        if (this.d.hasMessages(c)) {
            this.d.removeMessages(c);
            d();
        }
        this.e.s();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.d.removeMessages(c);
        d();
        this.e.j();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.l) {
            this.l = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return a(view, menu) | this.e.a(menu);
    }

    protected void onResume() {
        super.onResume();
        this.d.sendEmptyMessage(c);
        this.h = true;
        this.e.j();
    }

    public final Object onRetainNonConfigurationInstance() {
        int i = 0;
        if (this.i) {
            a(true);
        }
        Object e = e();
        ArrayList l = this.e.l();
        int i2;
        if (this.o != null) {
            int size = this.o.size();
            aA[] aAVarArr = new aA[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                aAVarArr[i3] = (aA) this.o.c(i3);
            }
            i2 = 0;
            while (i < size) {
                aA aAVar = aAVarArr[i];
                if (aAVar.h) {
                    i2 = true;
                } else {
                    aAVar.h();
                    this.o.remove(aAVar.e);
                }
                i += b;
            }
        } else {
            i2 = 0;
        }
        if (l == null && r0 == 0 && e == null) {
            return null;
        }
        P p = new P();
        p.a = null;
        p.b = e;
        p.c = null;
        p.d = l;
        p.e = this.o;
        return p;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable m = this.e.m();
        if (m != null) {
            bundle.putParcelable(a, m);
        }
    }

    protected void onStart() {
        super.onStart();
        this.i = false;
        this.j = false;
        this.d.removeMessages(b);
        if (!this.g) {
            this.g = true;
            this.e.p();
        }
        this.e.n();
        this.e.j();
        if (!this.n) {
            this.n = true;
            if (this.p != null) {
                this.p.b();
            } else if (!this.m) {
                this.p = a("(root)", this.n, false);
                if (!(this.p == null || this.p.g)) {
                    this.p.b();
                }
            }
            this.m = true;
        }
        this.e.q();
        if (this.o != null) {
            int size = this.o.size();
            aA[] aAVarArr = new aA[size];
            for (int i = size - 1; i >= 0; i--) {
                aAVarArr[i] = (aA) this.o.c(i);
            }
            for (int i2 = 0; i2 < size; i2 += b) {
                aA aAVar = aAVarArr[i2];
                aAVar.e();
                aAVar.g();
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.i = true;
        this.d.sendEmptyMessage(b);
        this.e.t();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (android.support.v4.e.a.a.c & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
}
