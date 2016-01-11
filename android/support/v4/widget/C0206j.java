package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.p;

public abstract class C0206j extends BaseAdapter implements C0205o, Filterable {
    @Deprecated
    public static final int j = 1;
    public static final int k = 2;
    protected boolean a;
    protected boolean b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected C0242l f;
    protected DataSetObserver g;
    protected C0244n h;
    protected FilterQueryProvider i;

    @Deprecated
    public C0206j(Context context, Cursor cursor) {
        a(context, cursor, (int) j);
    }

    public C0206j(Context context, Cursor cursor, int i) {
        a(context, cursor, i);
    }

    public C0206j(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? j : k);
    }

    public Cursor a() {
        return this.c;
    }

    public Cursor a(CharSequence charSequence) {
        return this.i != null ? this.i.runQuery(charSequence) : this.c;
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    void a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & j) == j) {
            i |= k;
            this.b = true;
        } else {
            this.b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.c = cursor;
        this.a = z;
        this.d = context;
        this.e = z ? cursor.getColumnIndexOrThrow(p.a) : -1;
        if ((i & k) == k) {
            this.f = new C0242l(this);
            this.g = new C0243m();
        } else {
            this.f = null;
            this.g = null;
        }
        if (z) {
            if (this.f != null) {
                cursor.registerContentObserver(this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
        }
    }

    @Deprecated
    protected void a(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? j : k);
    }

    public void a(Cursor cursor) {
        Cursor b = b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public void a(FilterQueryProvider filterQueryProvider) {
        this.i = filterQueryProvider;
    }

    public Cursor b(Cursor cursor) {
        if (cursor == this.c) {
            return null;
        }
        Cursor cursor2 = this.c;
        if (cursor2 != null) {
            if (this.f != null) {
                cursor2.unregisterContentObserver(this.f);
            }
            if (this.g != null) {
                cursor2.unregisterDataSetObserver(this.g);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            if (this.f != null) {
                cursor.registerContentObserver(this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
            this.e = cursor.getColumnIndexOrThrow(p.a);
            this.a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.e = -1;
        this.a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    public FilterQueryProvider b() {
        return this.i;
    }

    public CharSequence c(Cursor cursor) {
        return cursor == null ? a.f : cursor.toString();
    }

    protected void c() {
        if (this.b && this.c != null && !this.c.isClosed()) {
            this.a = this.c.requery();
        }
    }

    public int getCount() {
        return (!this.a || this.c == null) ? 0 : this.c.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.a) {
            return null;
        }
        this.c.moveToPosition(i);
        if (view == null) {
            view = b(this.d, this.c, viewGroup);
        }
        a(view, this.d, this.c);
        return view;
    }

    public Filter getFilter() {
        if (this.h == null) {
            this.h = new C0244n(this);
        }
        return this.h;
    }

    public Object getItem(int i) {
        if (!this.a || this.c == null) {
            return null;
        }
        this.c.moveToPosition(i);
        return this.c;
    }

    public long getItemId(int i) {
        return (this.a && this.c != null && this.c.moveToPosition(i)) ? this.c.getLong(this.e) : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.c.moveToPosition(i)) {
            if (view == null) {
                view = a(this.d, this.c, viewGroup);
            }
            a(view, this.d, this.c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public boolean hasStableIds() {
        return true;
    }
}
