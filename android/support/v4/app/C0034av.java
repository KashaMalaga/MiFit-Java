package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class C0034av extends Fragment {
    static final int a = 16711681;
    static final int b = 16711682;
    static final int c = 16711683;
    ListAdapter d;
    ListView e;
    View f;
    TextView g;
    View h;
    View i;
    CharSequence j;
    boolean k;
    private final Handler l = new Handler();
    private final Runnable m = new C0035aw(this);
    private final OnItemClickListener n = new C0036ax(this);

    private void a(boolean z, boolean z2) {
        e();
        if (this.h == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.k != z) {
            this.k = z;
            if (z) {
                if (z2) {
                    this.h.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
                    this.i.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                } else {
                    this.h.clearAnimation();
                    this.i.clearAnimation();
                }
                this.h.setVisibility(8);
                this.i.setVisibility(0);
                return;
            }
            if (z2) {
                this.h.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                this.i.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
            } else {
                this.h.clearAnimation();
                this.i.clearAnimation();
            }
            this.h.setVisibility(0);
            this.i.setVisibility(8);
        }
    }

    private void e() {
        if (this.e == null) {
            View view = getView();
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ListView) {
                this.e = (ListView) view;
            } else {
                this.g = (TextView) view.findViewById(a);
                if (this.g == null) {
                    this.f = view.findViewById(16908292);
                } else {
                    this.g.setVisibility(8);
                }
                this.h = view.findViewById(b);
                this.i = view.findViewById(c);
                view = view.findViewById(16908298);
                if (view instanceof ListView) {
                    this.e = (ListView) view;
                    if (this.f != null) {
                        this.e.setEmptyView(this.f);
                    } else if (this.j != null) {
                        this.g.setText(this.j);
                        this.e.setEmptyView(this.g);
                    }
                } else if (view == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            this.k = true;
            this.e.setOnItemClickListener(this.n);
            if (this.d != null) {
                ListAdapter listAdapter = this.d;
                this.d = null;
                a(listAdapter);
            } else if (this.h != null) {
                a(false, false);
            }
            this.l.post(this.m);
        }
    }

    public int a() {
        e();
        return this.e.getSelectedItemPosition();
    }

    public void a(int i) {
        e();
        this.e.setSelection(i);
    }

    public void a(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.d != null;
        this.d = listAdapter;
        if (this.e != null) {
            this.e.setAdapter(listAdapter);
            if (!this.k && !z2) {
                if (getView().getWindowToken() != null) {
                    z = true;
                }
                a(true, z);
            }
        }
    }

    public void a(ListView listView, View view, int i, long j) {
    }

    public void a(CharSequence charSequence) {
        e();
        if (this.g == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        this.g.setText(charSequence);
        if (this.j == null) {
            this.e.setEmptyView(this.g);
        }
        this.j = charSequence;
    }

    public void a(boolean z) {
        a(z, true);
    }

    public long b() {
        e();
        return this.e.getSelectedItemId();
    }

    public void b(boolean z) {
        a(z, false);
    }

    public ListView c() {
        e();
        return this.e;
    }

    public ListAdapter d() {
        return this.d;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context activity = getActivity();
        View frameLayout = new FrameLayout(activity);
        View linearLayout = new LinearLayout(activity);
        linearLayout.setId(b);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(activity, null, 16842874), new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        linearLayout = new FrameLayout(activity);
        linearLayout.setId(c);
        View textView = new TextView(getActivity());
        textView.setId(a);
        textView.setGravity(17);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        textView = new ListView(getActivity());
        textView.setId(16908298);
        textView.setDrawSelectorOnTop(false);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onDestroyView() {
        this.l.removeCallbacks(this.m);
        this.e = null;
        this.k = false;
        this.i = null;
        this.h = null;
        this.f = null;
        this.g = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        e();
    }
}
