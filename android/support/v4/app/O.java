package android.support.v4.app;

import android.view.View;
import android.view.Window;

class O implements Q {
    final /* synthetic */ FragmentActivity a;

    O(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    public View a(int i) {
        return this.a.findViewById(i);
    }

    public boolean a() {
        Window window = this.a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }
}
