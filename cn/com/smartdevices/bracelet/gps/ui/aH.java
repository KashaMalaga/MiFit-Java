package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.C0151az;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.e.h;
import cn.com.smartdevices.bracelet.gps.e.k;
import cn.com.smartdevices.bracelet.gps.h.c;
import cn.com.smartdevices.bracelet.gps.model.i;
import cn.com.smartdevices.bracelet.gps.services.C0466z;
import cn.com.smartdevices.bracelet.gps.services.O;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import cn.com.smartdevices.bracelet.gps.ui.b.a;
import com.huami.android.view.TypefaceTextView;
import com.huami.android.view.b;
import com.huami.android.widget.share.l;
import com.xiaomi.hm.health.b.a.f;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.ArrayList;
import java.util.List;

public class aH extends Fragment {
    private static final String b = "PaceFragment";
    private static final String m = "sharedPace.jpg";
    private h a;
    private TextView c;
    private TextView d;
    private ListView e = null;
    private View f = null;
    private RelativeLayout g = null;
    private ar h = null;
    private RelativeLayout i = null;
    private C0466z j = null;
    private long k = 0;
    private long l = Long.MAX_VALUE;
    private l n;
    private View o = null;
    private List<i> p;
    private k q;
    private int r = 0;
    private int s = Integer.MAX_VALUE;

    private int a(int i) {
        float f;
        int i2;
        float f2 = 0.8f;
        float f3 = 0.6f;
        int i3 = i << 3;
        int i4 = i3 % 5;
        int i5 = (i3 / 5) - 1;
        if (i4 == 0) {
            i3 = 0;
            f = 0.6f;
            f3 = 0.0f;
            i2 = i5 - 1;
            f2 = 1.0f;
        } else if (i4 < 3) {
            i3 = i5 + 1;
            i2 = i5 - 1;
            f2 = 1.0f;
            f = ((float) (3 - i4)) / 5.0f;
            f3 = ((float) i4) / 5.0f;
        } else if (i4 == 3) {
            f = 0.0f;
            i2 = 0;
            i3 = i5 + 1;
            f2 = 1.0f;
        } else if (i4 == 4) {
            f = 0.0f;
            i2 = 0;
            i3 = i5 + 1;
            f3 = 0.8f;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
            f = 0.0f;
            i2 = 0;
            i3 = 0;
        }
        C0596r.e(b, f + " " + i2 + " + " + f2 + " " + i5 + " + " + f3 + " " + i3);
        return Math.round((((float) a.a(((i) this.p.get(i3)).c)) * f3) + ((f * ((float) a.a(((i) this.p.get(i2)).c))) + (((float) a.a(((i) this.p.get(i5)).c)) * f2)));
    }

    private int a(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        int count = adapter.getCount();
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            View view = adapter.getView(i2, null, listView);
            view.measure(MeasureSpec.makeMeasureSpec(listView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            i += view.getMeasuredHeight();
        }
        return i;
    }

    private List<i> a(C0466z c0466z) {
        if (c0466z == null) {
            return new ArrayList(0);
        }
        List n = c0466z.n();
        List<i> arrayList = new ArrayList(n.size());
        boolean K = c0466z.K();
        long j = 0;
        int size = n.size();
        int i = 0;
        while (i < size) {
            long f;
            O o = (O) n.get(i);
            i iVar = new i();
            iVar.a = String.valueOf(o.d() + 1);
            float b = cn.com.smartdevices.bracelet.gps.h.i.b(o.c());
            iVar.d = cn.com.smartdevices.bracelet.gps.h.h.b(b, 2);
            long j2 = 0;
            if (((double) b) >= 0.01d) {
                j2 = cn.com.smartdevices.bracelet.gps.h.i.c(o.b());
            }
            if (K) {
                if (j2 <= 0 && ((double) b) >= 0.01d) {
                    j2 = o.f();
                }
                if (((double) b) < 0.01d) {
                    j2 = 0;
                }
                iVar.c = a.a(j2);
                f = o.f() + j;
                iVar.b = a.a(f, true);
            } else {
                iVar.b = a.a(o.f(), true);
                iVar.c = a.a(j2);
                iVar.e = o.g();
                f = j;
            }
            if (this.l > j2) {
                this.l = j2;
            }
            if (this.k < j2) {
                this.k = j2;
            }
            arrayList.add(iVar);
            i++;
            j = f;
        }
        return arrayList;
    }

    private void a(l lVar) {
        this.f.post(new aI(this, lVar));
    }

    private Bitmap b(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        int count = adapter.getCount();
        List arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            View view = adapter.getView(i2, null, listView);
            view.measure(MeasureSpec.makeMeasureSpec(listView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            arrayList.add(view.getDrawingCache());
            i += view.getMeasuredHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(listView.getMeasuredWidth(), i, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        for (i = 0; i < arrayList.size(); i++) {
            Bitmap bitmap = (Bitmap) arrayList.get(i);
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), paint);
            canvas.translate(0.0f, (float) bitmap.getHeight());
            bitmap.recycle();
        }
        return createBitmap;
    }

    private void b() {
        this.e.setAdapter(new aJ(this, getActivity(), c()));
        int g = this.j.g();
        if (HeartRateInfo.isHRValueValid(g)) {
            this.d.setText(String.valueOf(g));
        }
        this.c.setText(String.valueOf(a.a((long) this.a.b((double) cn.com.smartdevices.bracelet.gps.h.i.c(this.j.d())).a)));
    }

    private List<i> c() {
        if (this.q != k.British) {
            return this.p;
        }
        float f = (float) this.a.a((double) (this.j.C() / 1000.0f)).a;
        long F = this.j.F();
        int i = (int) f;
        ArrayList arrayList = new ArrayList(i);
        int[] iArr = new int[(i + 1)];
        int i2 = i + 1;
        int i3 = 1;
        while (i3 < i2) {
            int a = i3 == i ? (int) (((float) (F - ((long) iArr[i3 - 1]))) / ((f - ((float) i3)) + 1.0f)) : a(i3);
            iArr[i3] = iArr[i3 - 1] + a;
            if (a > this.r) {
                this.r = a;
            } else if (a < this.s) {
                this.s = a;
            }
            i iVar = new i();
            iVar.a = String.valueOf(i3);
            iVar.c = a.a((long) a);
            iVar.b = a.a((long) iArr[i3], true);
            iVar.e = ((i) this.p.get(i3)).e;
            arrayList.add(iVar);
            i3++;
        }
        return arrayList;
    }

    private long d() {
        return getArguments() != null ? getArguments().getLong(C0483q.a, -1) : -1;
    }

    void a() {
        if (this.h != null && this.f != null && this.i != null && this.e != null) {
            if (this.n != null) {
                a(this.n);
                return;
            }
            Bitmap createBitmap;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            int height = this.o.getHeight();
            int height2 = this.i.getHeight();
            int a = a(this.e);
            int height3 = this.g.getHeight();
            int width = this.i.getWidth();
            int height4 = this.f.getHeight() + height3;
            height = ((height + height2) + a) + height3;
            Paint paint;
            Canvas canvas;
            Rect rect;
            Bitmap drawingCache;
            if (height <= i) {
                createBitmap = Bitmap.createBitmap(width, height4, Config.RGB_565);
                if (createBitmap != null) {
                    paint = new Paint();
                    paint.setColor(getActivity().getResources().getColor(f.main_ui_bg));
                    canvas = new Canvas(createBitmap);
                    rect = new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
                    this.f.setDrawingCacheEnabled(true);
                    this.f.buildDrawingCache();
                    drawingCache = this.f.getDrawingCache();
                    canvas.drawBitmap(drawingCache, new Rect(0, 0, drawingCache.getWidth(), drawingCache.getHeight()), new Rect(0, 0, drawingCache.getWidth(), drawingCache.getHeight()), paint);
                    canvas.translate(0.0f, (float) drawingCache.getHeight());
                    drawingCache.recycle();
                    this.g.setDrawingCacheEnabled(true);
                    this.g.buildDrawingCache();
                    drawingCache = this.g.getDrawingCache();
                    canvas.drawColor(C0151az.r);
                    canvas.drawRect(new Rect(0, 0, drawingCache.getWidth(), drawingCache.getHeight()), paint);
                    canvas.drawBitmap(drawingCache, new Rect(0, 0, drawingCache.getWidth(), drawingCache.getHeight()), new Rect(0, 0, drawingCache.getWidth(), drawingCache.getHeight()), paint);
                    drawingCache.recycle();
                }
            } else {
                createBitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
                if (createBitmap != null) {
                    paint = new Paint();
                    paint.setColor(getActivity().getResources().getColor(f.main_ui_bg));
                    canvas = new Canvas(createBitmap);
                    rect = new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
                    this.o.setDrawingCacheEnabled(true);
                    this.o.buildDrawingCache();
                    Bitmap drawingCache2 = this.o.getDrawingCache();
                    canvas.drawRect(rect, paint);
                    canvas.drawBitmap(drawingCache2, new Rect(0, 0, drawingCache2.getWidth(), drawingCache2.getHeight()), new Rect(0, 0, drawingCache2.getWidth(), drawingCache2.getHeight()), paint);
                    canvas.translate(0.0f, (float) drawingCache2.getHeight());
                    drawingCache2.recycle();
                    this.i.setDrawingCacheEnabled(true);
                    this.i.buildDrawingCache();
                    drawingCache = this.i.getDrawingCache();
                    canvas.drawBitmap(drawingCache, new Rect(0, 0, drawingCache.getWidth(), drawingCache.getHeight()), new Rect(0, 0, drawingCache.getWidth(), drawingCache.getHeight()), paint);
                    canvas.translate(0.0f, (float) drawingCache.getHeight());
                    drawingCache.recycle();
                    drawingCache = b(this.e);
                    canvas.drawBitmap(drawingCache, new Rect(0, 0, drawingCache.getWidth(), drawingCache.getHeight()), new Rect(0, 0, drawingCache.getWidth(), drawingCache.getHeight()), paint);
                    canvas.translate(0.0f, (float) drawingCache.getHeight());
                    drawingCache.recycle();
                    this.g.setDrawingCacheEnabled(true);
                    this.g.buildDrawingCache();
                    drawingCache = this.g.getDrawingCache();
                    canvas.drawBitmap(drawingCache, new Rect(0, 0, drawingCache.getWidth(), drawingCache.getHeight()), new Rect(0, 0, drawingCache.getWidth(), drawingCache.getHeight()), paint);
                    drawingCache.recycle();
                }
            }
            String e = cn.com.smartdevices.bracelet.a.a.e(m);
            boolean a2 = c.a(e, createBitmap, 30);
            C0596r.g(b, "isSucceeded : " + a2);
            if (a2) {
                this.n = new l();
                this.n.d = e;
                a(this.n);
            } else {
                b.a(getActivity(), n.running_share_img_failed_to_create, 0).show();
            }
            createBitmap.recycle();
            this.o.destroyDrawingCache();
            this.i.destroyDrawingCache();
            this.g.destroyDrawingCache();
            this.f.destroyDrawingCache();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.h = (ar) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement IScreenShotShare");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f = layoutInflater.inflate(j.fragment_running_pace, viewGroup, false);
        this.i = (RelativeLayout) this.f.findViewById(com.xiaomi.hm.health.b.a.i.pace_head_layout);
        this.c = (TypefaceTextView) this.f.findViewById(com.xiaomi.hm.health.b.a.i.tvv_miles_pace);
        this.d = (TypefaceTextView) this.f.findViewById(com.xiaomi.hm.health.b.a.i.tvv_avg_hr);
        this.o = this.f.findViewById(com.xiaomi.hm.health.b.a.i.share_title);
        this.g = (RelativeLayout) this.f.findViewById(com.xiaomi.hm.health.b.a.i.share_logo);
        if (d() <= 0) {
            return this.f;
        }
        this.a = cn.com.smartdevices.bracelet.gps.e.c.a();
        this.q = this.a.a();
        this.j = p.d(getActivity(), d());
        this.e = (ListView) this.f.findViewById(com.xiaomi.hm.health.b.a.i.listView);
        this.p = a(this.j);
        b();
        return this.f;
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.ao);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.ao);
    }
}
