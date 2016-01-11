package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.e.a;

public class aH extends al {
    protected int[] l;
    protected int[] m;
    String[] n;
    private int o = -1;
    private aI p;
    private aJ q;

    @Deprecated
    public aH(Context context, int i, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i, cursor);
        this.m = iArr;
        this.n = strArr;
        a(strArr);
    }

    public aH(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.m = iArr;
        this.n = strArr;
        a(strArr);
    }

    private void a(String[] strArr) {
        if (this.c != null) {
            int length = strArr.length;
            if (this.l == null || this.l.length != length) {
                this.l = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.l[i] = this.c.getColumnIndexOrThrow(strArr[i]);
            }
            return;
        }
        this.l = null;
    }

    public void a(Cursor cursor, String[] strArr, int[] iArr) {
        this.n = strArr;
        this.m = iArr;
        super.a(cursor);
        a(this.n);
    }

    public void a(aI aIVar) {
        this.p = aIVar;
    }

    public void a(aJ aJVar) {
        this.q = aJVar;
    }

    public void a(View view, Context context, Cursor cursor) {
        aJ aJVar = this.q;
        int length = this.m.length;
        int[] iArr = this.l;
        int[] iArr2 = this.m;
        for (int i = 0; i < length; i++) {
            View findViewById = view.findViewById(iArr2[i]);
            if (findViewById != null) {
                if (aJVar != null ? aJVar.a(findViewById, cursor, iArr[i]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr[i]);
                    if (string == null) {
                        string = a.f;
                    }
                    if (findViewById instanceof TextView) {
                        a((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        a((ImageView) findViewById, string);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void a(TextView textView, String str) {
        textView.setText(str);
    }

    public Cursor b(Cursor cursor) {
        Cursor b = super.b(cursor);
        a(this.n);
        return b;
    }

    public CharSequence c(Cursor cursor) {
        return this.p != null ? this.p.a(cursor) : this.o > -1 ? cursor.getString(this.o) : super.c(cursor);
    }

    public void c(int i) {
        this.o = i;
    }

    public aJ d() {
        return this.q;
    }

    public int e() {
        return this.o;
    }

    public aI f() {
        return this.p;
    }
}
