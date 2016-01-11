package android.support.v4.app;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

class C0021ag implements TabContentFactory {
    private final Context a;

    public C0021ag(Context context) {
        this.a = context;
    }

    public View createTabContent(String str) {
        View view = new View(this.a);
        view.setMinimumWidth(0);
        view.setMinimumHeight(0);
        return view;
    }
}
