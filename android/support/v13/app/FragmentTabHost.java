package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
    private final ArrayList<m> a = new ArrayList();
    private FrameLayout b;
    private Context c;
    private FragmentManager d;
    private int e;
    private OnTabChangeListener f;
    private m g;
    private boolean h;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new l();
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

    private FragmentTransaction a(String str, FragmentTransaction fragmentTransaction) {
        m mVar = null;
        int i = 0;
        while (i < this.a.size()) {
            m mVar2 = (m) this.a.get(i);
            if (!mVar2.a.equals(str)) {
                mVar2 = mVar;
            }
            i++;
            mVar = mVar2;
        }
        if (mVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.g != mVar) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.d.beginTransaction();
            }
            if (!(this.g == null || this.g.d == null)) {
                fragmentTransaction.detach(this.g.d);
            }
            if (mVar != null) {
                if (mVar.d == null) {
                    mVar.d = Fragment.instantiate(this.c, mVar.b.getName(), mVar.c);
                    fragmentTransaction.add(this.e, mVar.d, mVar.a);
                } else {
                    fragmentTransaction.attach(mVar.d);
                }
            }
            this.g = mVar;
        }
        return fragmentTransaction;
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

    public void a(Context context, FragmentManager fragmentManager) {
        a(context);
        super.setup();
        this.c = context;
        this.d = fragmentManager;
        a();
    }

    public void a(Context context, FragmentManager fragmentManager, int i) {
        a(context);
        super.setup();
        this.c = context;
        this.d = fragmentManager;
        this.e = i;
        a();
        this.b.setId(i);
        if (getId() == -1) {
            setId(16908306);
        }
    }

    public void a(TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new k(this.c));
        String tag = tabSpec.getTag();
        m mVar = new m(tag, cls, bundle);
        if (this.h) {
            mVar.d = this.d.findFragmentByTag(tag);
            if (!(mVar.d == null || mVar.d.isDetached())) {
                FragmentTransaction beginTransaction = this.d.beginTransaction();
                beginTransaction.detach(mVar.d);
                beginTransaction.commit();
            }
        }
        this.a.add(mVar);
        addTab(tabSpec);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.a.size(); i++) {
            m mVar = (m) this.a.get(i);
            mVar.d = this.d.findFragmentByTag(mVar.a);
            if (!(mVar.d == null || mVar.d.isDetached())) {
                if (mVar.a.equals(currentTabTag)) {
                    this.g = mVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.d.beginTransaction();
                    }
                    fragmentTransaction.detach(mVar.d);
                }
            }
        }
        this.h = true;
        FragmentTransaction a = a(currentTabTag, fragmentTransaction);
        if (a != null) {
            a.commit();
            this.d.executePendingTransactions();
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
            FragmentTransaction a = a(str, null);
            if (a != null) {
                a.commit();
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
