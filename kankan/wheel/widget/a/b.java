package kankan.wheel.widget.a;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.e.a;

public abstract class b extends a {
    public static final int a = -1;
    protected static final int b = 0;
    public static final int c = -15724528;
    public static final int d = -9437072;
    public static final int e = 20;
    protected Context f;
    protected LayoutInflater g;
    protected int h;
    protected int i;
    protected int j;
    private int k;
    private int l;

    protected b(Context context) {
        this(context, a);
    }

    protected b(Context context, int i) {
        this(context, i, b);
    }

    protected b(Context context, int i, int i2) {
        this.k = c;
        this.l = e;
        this.f = context;
        this.h = i;
        this.i = i2;
        this.g = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private View a(int i, ViewGroup viewGroup) {
        switch (i) {
            case a /*-1*/:
                return new TextView(this.f);
            case b /*0*/:
                return null;
            default:
                return this.g.inflate(i, viewGroup, false);
        }
    }

    private TextView a(View view, int i) {
        if (i == 0) {
            try {
                if (view instanceof TextView) {
                    return (TextView) view;
                }
            } catch (Throwable e) {
                Log.e("AbstractWheelAdapter", "You must supply a resource ID for a TextView");
                throw new IllegalStateException("AbstractWheelAdapter requires the resource ID to be a TextView", e);
            }
        }
        return i != 0 ? (TextView) view.findViewById(i) : null;
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        if (i < 0 || i >= a()) {
            return null;
        }
        if (view == null) {
            view = a(this.h, viewGroup);
        }
        TextView a = a(view, this.i);
        if (a == null) {
            return view;
        }
        CharSequence f = f(i);
        if (f == null) {
            f = a.f;
        }
        a.setText(f);
        if (this.h != a) {
            return view;
        }
        a(a);
        return view;
    }

    public View a(View view, ViewGroup viewGroup) {
        View a = view == null ? a(this.j, viewGroup) : view;
        if (this.j == a && (a instanceof TextView)) {
            a((TextView) a);
        }
        return a;
    }

    public void a(int i) {
        this.k = i;
    }

    protected void a(TextView textView) {
        textView.setGravity(17);
        textView.setTextSize((float) this.l);
        textView.setLines(1);
        textView.setTypeface(Typeface.SANS_SERIF, b);
        textView.setPadding(b, 10, b, 10);
    }

    public void b(int i) {
        this.l = i;
    }

    public void c(int i) {
        this.h = i;
    }

    public void d(int i) {
        this.i = i;
    }

    public void e(int i) {
        this.j = i;
    }

    protected abstract CharSequence f(int i);

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public int i() {
        return this.h;
    }

    public int j() {
        return this.i;
    }

    public int k() {
        return this.j;
    }
}
