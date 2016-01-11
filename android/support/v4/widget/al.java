package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class al extends C0206j {
    private int l;
    private int m;
    private LayoutInflater n;

    @Deprecated
    public al(Context context, int i, Cursor cursor) {
        super(context, cursor);
        this.m = i;
        this.l = i;
        this.n = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public al(Context context, int i, Cursor cursor, int i2) {
        super(context, cursor, i2);
        this.m = i;
        this.l = i;
        this.n = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public al(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.m = i;
        this.l = i;
        this.n = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.n.inflate(this.l, viewGroup, false);
    }

    public void a(int i) {
        this.l = i;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.n.inflate(this.m, viewGroup, false);
    }

    public void b(int i) {
        this.m = i;
    }
}
