package com.huami.android.picture;

import android.annotation.SuppressLint;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Checkable;
import android.widget.GridView;
import cn.com.smartdevices.bracelet.C0401a;
import com.huami.android.a.e;
import com.huami.android.a.f;
import com.huami.android.a.g;
import com.huami.android.a.h;
import com.huami.android.a.j;
import com.huami.android.bitmapfun.u;
import com.huami.android.bitmapfun.x;
import com.huami.android.ui.ActionBarActivity;
import com.xiaomi.market.sdk.p;

@SuppressLint({"NewApi"})
public class GalleryPickerActivity extends ActionBarActivity implements LoaderCallbacks<Cursor>, MultiChoiceModeListener, OnItemClickListener {
    public static final String a = "cn.com.smartdevices.bracelet.action.PICK";
    public static final String b = "cn.com.smartdevices.bracelet.action.MULTIPLE_PICK";
    public static final String c = "cn.com.smartdevices.bracelet.extra.DATA";
    static final Uri d = Media.EXTERNAL_CONTENT_URI;
    static final String[] e = new String[]{"_data", p.a};
    static final String f = "_id DESC";
    public static final int g = 1;
    public static final int h = 0;
    private static final String i = "GalleryPickerActivity";
    private static final int j = 0;
    private static final String q = "thumbs";
    private GridView k;
    private c l;
    private boolean m;
    private int n;
    private int o;
    private x p;

    public GalleryPickerActivity() {
        super(C0401a.gP, C0401a.aB);
    }

    private void b() {
        u uVar = new u(this, q);
        uVar.a(0.25f);
        this.p = new x(this, this.n);
        this.p.b(f.picker_empty_photo);
        this.p.a(getFragmentManager(), uVar);
    }

    private void c() {
        d();
        this.l = new c(this, this.p);
        this.k = (GridView) findViewById(g.picker_grid);
        this.k.setAdapter(this.l);
        this.k.setOnItemClickListener(this);
        this.k.setMultiChoiceModeListener(this);
        this.k.setOnScrollListener(new a(this));
        this.k.getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
    }

    private void d() {
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        this.l.swapCursor(cursor);
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        int i = j;
        if (menuItem.getItemId() != g.menu_done) {
            return false;
        }
        long[] checkedItemIds = this.k.getCheckedItemIds();
        Intent intent = new Intent();
        if (this.m) {
            Parcelable[] parcelableArr = new Uri[checkedItemIds.length];
            while (i < checkedItemIds.length) {
                parcelableArr[i] = ContentUris.withAppendedId(d, checkedItemIds[i]);
                i += g;
            }
            intent.putExtra(c, parcelableArr);
        } else if (checkedItemIds.length <= 0) {
            return true;
        } else {
            intent.putExtra(c, ContentUris.withAppendedId(d, checkedItemIds[j]));
        }
        setResult(-1, intent);
        finish();
        return true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.activity_picture_picker);
        this.m = b.equals(getIntent().getAction());
        this.n = getResources().getDimensionPixelSize(e.image_thumbnail_size);
        this.o = getResources().getDimensionPixelSize(e.image_thumbnail_spacing);
        b();
        c();
        getLoaderManager().initLoader(j, null, this);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, d, e, null, null, f);
    }

    public void onDestroy() {
        super.onDestroy();
        this.p.i();
    }

    public void onDestroyActionMode(ActionMode actionMode) {
    }

    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        int checkedItemCount = this.k.getCheckedItemCount();
        Resources resources = getResources();
        int i2 = j.picker_number_of_items_selected;
        Object[] objArr = new Object[g];
        objArr[j] = Integer.valueOf(checkedItemCount);
        actionMode.setTitle(resources.getQuantityString(i2, checkedItemCount, objArr));
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.m) {
            String str = ((d) view.getTag()).b;
            Log.i(i, "path:" + str);
            Intent intent = new Intent();
            intent.putExtra(c, str);
            setResult(-1, intent);
            finish();
        } else if (view instanceof Checkable) {
            this.k.setItemChecked(i, !((Checkable) view).isChecked());
        }
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        this.l.swapCursor(null);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onPause() {
        super.onPause();
        this.p.c(false);
        this.p.b(true);
        this.p.h();
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    public void onResume() {
        super.onResume();
        this.p.b(false);
        this.l.notifyDataSetChanged();
    }
}
