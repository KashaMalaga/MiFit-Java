package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.util.Log;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.amap.api.mapcore.util.h;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.DPoint;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT = new Gradient(a, b);
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int[] a = new int[]{Color.rgb(ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, 225, 0), Color.rgb(HeartRateInfo.HR_EMPTY_VALUE, 0, 0)};
    private static final float[] b = new float[]{d.b, 1.0f};
    private a c;
    private Collection<WeightedLatLng> d;
    private h e;
    private int f;
    private Gradient g;
    private int[] h;
    private double[] i;
    private double j;
    private double[] k;

    public class Builder {
        private Collection<WeightedLatLng> a;
        private int b = HeatmapTileProvider.DEFAULT_RADIUS;
        private Gradient c = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double d = HeatmapTileProvider.DEFAULT_OPACITY;

        public HeatmapTileProvider build() {
            if (this.a != null && this.a.size() != 0) {
                return new HeatmapTileProvider();
            }
            try {
                throw new AMapException("No input points.");
            } catch (AMapException e) {
                Log.e("amap", e.getErrorMessage());
                e.printStackTrace();
                return null;
            }
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.d(collection));
        }

        public Builder gradient(Gradient gradient) {
            this.c = gradient;
            return this;
        }

        public Builder radius(int i) {
            this.b = Math.max(10, Math.min(i, 50));
            return this;
        }

        public Builder transparency(double d) {
            this.d = Math.max(0.0d, Math.min(d, WeightedLatLng.DEFAULT_INTENSITY));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.a = collection;
            return this;
        }
    }

    private HeatmapTileProvider(Builder builder) {
        this.d = builder.a;
        this.f = builder.b;
        this.g = builder.c;
        if (this.g == null || !this.g.isAvailable()) {
            this.g = DEFAULT_GRADIENT;
        }
        this.j = builder.d;
        this.i = a(this.f, ((double) this.f) / 3.0d);
        a(this.g);
        c(this.d);
    }

    static double a(Collection<WeightedLatLng> collection, h hVar, int i, int i2) {
        double d = hVar.a;
        double d2 = hVar.c;
        double d3 = hVar.b;
        double d4 = hVar.d;
        double d5 = ((double) ((int) (((double) (i2 / (i * 2))) + 0.5d))) / (d2 - d > d4 - d3 ? d2 - d : d4 - d3);
        android.support.v4.l.h hVar2 = new android.support.v4.l.h();
        d4 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            android.support.v4.l.h hVar3;
            int i3 = (int) ((weightedLatLng.getPoint().x - d) * d5);
            int i4 = (int) ((weightedLatLng.getPoint().y - d3) * d5);
            android.support.v4.l.h hVar4 = (android.support.v4.l.h) hVar2.a((long) i3);
            if (hVar4 == null) {
                hVar4 = new android.support.v4.l.h();
                hVar2.b((long) i3, hVar4);
                hVar3 = hVar4;
            } else {
                hVar3 = hVar4;
            }
            Double d6 = (Double) hVar3.a((long) i4);
            if (d6 == null) {
                d6 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(weightedLatLng.intensity + d6.doubleValue());
            hVar3.b((long) i4, valueOf);
            d4 = valueOf.doubleValue() > d4 ? valueOf.doubleValue() : d4;
        }
        return d4;
    }

    static Bitmap a(double[][] dArr, int[] iArr, double d) {
        int i = iArr[iArr.length - 1];
        double length = ((double) (iArr.length - 1)) / d;
        int length2 = dArr.length;
        int[] iArr2 = new int[(length2 * length2)];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 == 0.0d) {
                    iArr2[i4] = 0;
                } else if (i5 < iArr.length) {
                    iArr2[i4] = iArr[i5];
                } else {
                    iArr2[i4] = i;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    static h a(Collection<WeightedLatLng> collection) {
        Iterator it = collection.iterator();
        WeightedLatLng weightedLatLng = (WeightedLatLng) it.next();
        double d = weightedLatLng.getPoint().x;
        double d2 = weightedLatLng.getPoint().x;
        double d3 = weightedLatLng.getPoint().y;
        double d4 = weightedLatLng.getPoint().y;
        while (it.hasNext()) {
            weightedLatLng = (WeightedLatLng) it.next();
            double d5 = weightedLatLng.getPoint().x;
            double d6 = weightedLatLng.getPoint().y;
            if (d5 < d) {
                d = d5;
            }
            if (d5 > d2) {
                d2 = d5;
            }
            if (d6 < d3) {
                d3 = d6;
            }
            if (d6 > d4) {
                d4 = d6;
            }
        }
        return new h(d, d2, d3, d4);
    }

    private static Tile a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return new Tile(PersonInfo.INCOMING_CALL_DISABLE_BIT, PersonInfo.INCOMING_CALL_DISABLE_BIT, byteArrayOutputStream.toByteArray());
    }

    private void a(Gradient gradient) {
        this.g = gradient;
        this.h = gradient.generateColorMap(this.j);
    }

    private double[] a(int i) {
        int i2 = 11;
        double[] dArr = new double[21];
        for (int i3 = 5; i3 < 11; i3++) {
            dArr[i3] = a(this.d, this.e, i, (int) (1280.0d * Math.pow(2.0d, (double) i3)));
            if (i3 == 5) {
                for (int i4 = 0; i4 < i3; i4++) {
                    dArr[i4] = dArr[i3];
                }
            }
        }
        while (i2 < 21) {
            dArr[i2] = dArr[10];
            i2++;
        }
        return dArr;
    }

    static double[] a(int i, double d) {
        double[] dArr = new double[((i * 2) + 1)];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((double) ((-i2) * i2)) / ((2.0d * d) * d));
        }
        return dArr;
    }

    static double[][] a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(((double) dArr2.length) / 2.0d);
        int length = dArr.length;
        int i = length - (floor * 2);
        int i2 = (floor + i) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{length, length});
        int i3 = 0;
        while (i3 < length) {
            int i4;
            for (i4 = 0; i4 < length; i4++) {
                int i5;
                double d = dArr[i3][i4];
                if (d != 0.0d) {
                    i5 = (i2 < i3 + floor ? i2 : i3 + floor) + 1;
                    int i6 = floor > i3 - floor ? floor : i3 - floor;
                    while (i6 < i5) {
                        double[] dArr4 = dArr3[i6];
                        dArr4[i4] = dArr4[i4] + (dArr2[i6 - (i3 - floor)] * d);
                        i6++;
                    }
                }
            }
            i3++;
        }
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, new int[]{i, i});
        for (i = floor; i < i2 + 1; i++) {
            i3 = 0;
            while (i3 < length) {
                d = dArr3[i][i3];
                if (d != 0.0d) {
                    i5 = (i2 < i3 + floor ? i2 : i3 + floor) + 1;
                    i4 = floor > i3 - floor ? floor : i3 - floor;
                    while (i4 < i5) {
                        dArr4 = dArr5[i - floor];
                        int i7 = i4 - floor;
                        dArr4[i7] = dArr4[i7] + (dArr2[i4 - (i3 - floor)] * d);
                        i4++;
                    }
                }
                i3++;
            }
        }
        return dArr5;
    }

    private void c(Collection<WeightedLatLng> collection) {
        Collection arrayList = new ArrayList();
        for (WeightedLatLng weightedLatLng : collection) {
            if (weightedLatLng.latLng.latitude < 85.0d && weightedLatLng.latLng.latitude > -85.0d) {
                arrayList.add(weightedLatLng);
            }
        }
        this.d = arrayList;
        this.e = a(this.d);
        this.c = new a(this.e);
        for (WeightedLatLng weightedLatLng2 : this.d) {
            this.c.a(weightedLatLng2);
        }
        this.k = a(this.f);
    }

    private static Collection<WeightedLatLng> d(Collection<LatLng> collection) {
        Collection arrayList = new ArrayList();
        for (LatLng weightedLatLng : collection) {
            arrayList.add(new WeightedLatLng(weightedLatLng));
        }
        return arrayList;
    }

    public Tile getTile(int i, int i2, int i3) {
        double d;
        double pow = WeightedLatLng.DEFAULT_INTENSITY / Math.pow(2.0d, (double) i3);
        double d2 = (((double) this.f) * pow) / 256.0d;
        double d3 = ((2.0d * d2) + pow) / ((double) ((this.f * 2) + PersonInfo.INCOMING_CALL_DISABLE_BIT));
        double d4 = (((double) i) * pow) - d2;
        double d5 = (((double) (i + 1)) * pow) + d2;
        double d6 = (((double) i2) * pow) - d2;
        double d7 = (pow * ((double) (i2 + 1))) + d2;
        ArrayList arrayList = new ArrayList();
        Collection a;
        if (d4 < 0.0d) {
            a = this.c.a(new h(WeightedLatLng.DEFAULT_INTENSITY + d4, WeightedLatLng.DEFAULT_INTENSITY, d6, d7));
            d = -1.0d;
        } else if (d5 > WeightedLatLng.DEFAULT_INTENSITY) {
            a = this.c.a(new h(0.0d, d5 - WeightedLatLng.DEFAULT_INTENSITY, d6, d7));
            d = WeightedLatLng.DEFAULT_INTENSITY;
        } else {
            Object obj = arrayList;
            d = 0.0d;
        }
        h hVar = new h(d4, d5, d6, d7);
        if (!hVar.a(new h(this.e.a - d2, this.e.c + d2, this.e.b - d2, d2 + this.e.d))) {
            return TileProvider.NO_TILE;
        }
        Collection<WeightedLatLng> a2 = this.c.a(hVar);
        if (a2.isEmpty()) {
            return TileProvider.NO_TILE;
        }
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{(this.f * 2) + PersonInfo.INCOMING_CALL_DISABLE_BIT, (this.f * 2) + PersonInfo.INCOMING_CALL_DISABLE_BIT});
        for (WeightedLatLng weightedLatLng : a2) {
            DPoint point = weightedLatLng.getPoint();
            int i4 = (int) ((point.x - d4) / d3);
            int i5 = (int) ((point.y - d6) / d3);
            double[] dArr2 = dArr[i4];
            dArr2[i5] = dArr2[i5] + weightedLatLng.intensity;
        }
        for (WeightedLatLng weightedLatLng2 : r20) {
            point = weightedLatLng2.getPoint();
            i4 = (int) (((point.x + d) - d4) / d3);
            i5 = (int) ((point.y - d6) / d3);
            dArr2 = dArr[i4];
            dArr2[i5] = dArr2[i5] + weightedLatLng2.intensity;
        }
        return a(a(a(dArr, this.i), this.h, this.k[i3]));
    }

    public int getTileHeight() {
        return PersonInfo.INCOMING_CALL_DISABLE_BIT;
    }

    public int getTileWidth() {
        return PersonInfo.INCOMING_CALL_DISABLE_BIT;
    }
}
