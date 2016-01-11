package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<C0023ai> a = new ArrayList();
    private FrameLayout b;
    private Context c;
    private R d;
    private int e;
    private OnTabChangeListener f;
    private C0023ai g;
    private boolean h;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0022ah();
        String a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
        }
    }

    public FragmentTabHost(Context context) {
        super(context, null);
        a(context, null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private aj a(String str, aj ajVar) {
        C0023ai c0023ai = null;
        int i = 0;
        while (i < this.a.size()) {
            C0023ai c0023ai2 = (C0023ai) this.a.get(i);
            if (!c0023ai2.a.equals(str)) {
                c0023ai2 = c0023ai;
            }
            i++;
            c0023ai = c0023ai2;
        }
        if (c0023ai == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.g != c0023ai) {
            if (ajVar == null) {
                ajVar = this.d.a();
            }
            if (!(this.g == null || this.g.d == null)) {
                ajVar.d(this.g.d);
            }
            if (c0023ai != null) {
                if (c0023ai.d == null) {
                    c0023ai.d = Fragment.instantiate(this.c, c0023ai.b.getName(), c0023ai.c);
                    ajVar.a(this.e, c0023ai.d, c0023ai.a);
                } else {
                    ajVar.e(c0023ai.d);
                }
            }
            this.g = c0023ai;
        }
        return ajVar;
    }

    private void a() {
        if (this.b == null) {
            this.b = (FrameLayout) findViewById(this.e);
            if (this.b == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.e);
            }
        }
    }

    private void a(Context context) {
        if (findViewById(16908307) == null) {
            View linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new LayoutParams(-1, -1));
            View tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            tabWidget = new FrameLayout(context);
            tabWidget.setId(16908305);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(0, 0, 0.0f));
            tabWidget = new FrameLayout(context);
            this.b = tabWidget;
            this.b.setId(this.e);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    public void a(Context context, R r) {
        a(context);
        super.setup();
        this.c = context;
        this.d = r;
        a();
    }

    public void a(Context context, R r, int i) {
        a(context);
        super.setup();
        this.c = context;
        this.d = r;
        this.e = i;
        a();
        this.b.setId(i);
        if (getId() == -1) {
            setId(16908306);
        }
    }

    public void a(TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new C0021ag(this.c));
        String tag = tabSpec.getTag();
        C0023ai c0023ai = new C0023ai(tag, cls, bundle);
        if (this.h) {
            c0023ai.d = this.d.a(tag);
            if (!(c0023ai.d == null || c0023ai.d.isDetached())) {
                aj a = this.d.a();
                a.d(c0023ai.d);
                a.h();
            }
        }
        this.a.add(c0023ai);
        addTab(tabSpec);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        aj ajVar = null;
        for (int i = 0; i < this.a.size(); i++) {
            C0023ai c0023ai = (C0023ai) this.a.get(i);
            c0023ai.d = this.d.a(c0023ai.a);
            if (!(c0023ai.d == null || c0023ai.d.isDetached())) {
                if (c0023ai.a.equals(currentTabTag)) {
                    this.g = c0023ai;
                } else {
                    if (ajVar == null) {
                        ajVar = this.d.a();
                    }
                    ajVar.d(c0023ai.d);
                }
            }
        }
        this.h = true;
        aj a = a(currentTabTag, ajVar);
        if (a != null) {
            a.h();
            this.d.c();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.a);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getCurrentTabTag();
        return savedState;
    }

    public void onTabChanged(String str) {
        if (this.h) {
            aj a = a(str, null);
            if (a != null) {
                a.h();
            }
        }
        if (this.f != null) {
            this.f.onTabChanged(str);
        }
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
