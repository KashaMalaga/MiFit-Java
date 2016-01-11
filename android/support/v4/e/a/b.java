package android.support.v4.e.a;

import android.support.v4.view.C0190n;
import android.support.v4.view.T;
import android.view.MenuItem;
import android.view.View;

public interface b extends MenuItem {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;

    b a(T t);

    b a(C0190n c0190n);

    C0190n a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
