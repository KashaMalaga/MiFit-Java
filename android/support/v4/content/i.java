package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.s$android.support.v4.content.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class i extends C0090a<Cursor> {
    final t h = new t(this);
    Uri i;
    String[] j;
    String k;
    String[] l;
    String m;
    Cursor n;

    public i(Context context) {
        super(context);
    }

    public i(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.i = uri;
        this.j = strArr;
        this.k = str;
        this.l = strArr2;
        this.m = str2;
    }

    public void a(Cursor cursor) {
        if (!t()) {
            Cursor cursor2 = this.n;
            this.n = cursor;
            if (r()) {
                super.b(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public void a(Uri uri) {
        this.i = uri;
    }

    public /* synthetic */ void a(Object obj) {
        b((Cursor) obj);
    }

    public void a(String str) {
        this.k = str;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.i);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.j));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.k);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.l));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.u);
    }

    public void a(String[] strArr) {
        this.j = strArr;
    }

    public void b(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public /* synthetic */ void b(Object obj) {
        a((Cursor) obj);
    }

    public void b(String str) {
        this.m = str;
    }

    public void b(String[] strArr) {
        this.l = strArr;
    }

    public /* synthetic */ Object d() {
        return g();
    }

    public Cursor g() {
        Cursor query = p().getContentResolver().query(this.i, this.j, this.k, this.l, this.m);
        if (query != null) {
            query.getCount();
            query.registerContentObserver(this.h);
        }
        return query;
    }

    protected void h() {
        if (this.n != null) {
            a(this.n);
        }
        if (A() || this.n == null) {
            v();
        }
    }

    protected void i() {
        b();
    }

    protected void j() {
        super.j();
        i();
        if (!(this.n == null || this.n.isClosed())) {
            this.n.close();
        }
        this.n = null;
    }

    public Uri k() {
        return this.i;
    }

    public String[] l() {
        return this.j;
    }

    public String m() {
        return this.k;
    }

    public String[] n() {
        return this.l;
    }

    public String o() {
        return this.m;
    }
}
