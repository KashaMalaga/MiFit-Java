package com.huami.android.picture;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.huami.android.bitmapfun.view.RecyclingImageView;
import com.huami.android.bitmapfun.x;

public class c extends CursorAdapter {
    private int a = 0;
    private int b = 0;
    private final x c;
    private LayoutParams d;

    public c(Context context, x xVar) {
        super(context, null, false);
        this.c = xVar;
        this.d = new LayoutParams(-1, -1);
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        if (i != this.a) {
            this.a = i;
            this.d = new LayoutParams(-1, this.a);
            this.c.a(i);
            notifyDataSetChanged();
        }
    }

    public void b(int i) {
        this.b = i;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        d dVar = (d) view.getTag();
        String string = cursor.getString(cursor.getColumnIndex("_data"));
        dVar.b = string;
        ImageView imageView = dVar.a;
        if (imageView.getLayoutParams().height != this.a) {
            imageView.setLayoutParams(this.d);
        }
        this.c.a(string, imageView);
    }

    public long getItemId(int i) {
        return super.getItemId(i);
    }

    public boolean hasStableIds() {
        return super.hasStableIds();
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        d dVar = new d();
        View recyclingImageView = new RecyclingImageView(context);
        recyclingImageView.setScaleType(ScaleType.CENTER_CROP);
        recyclingImageView.setLayoutParams(this.d);
        dVar.a = recyclingImageView;
        recyclingImageView.setTag(dVar);
        return recyclingImageView;
    }
}
