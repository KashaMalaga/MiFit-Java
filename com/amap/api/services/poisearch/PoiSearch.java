package com.amap.api.services.poisearch;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.d;
import com.amap.api.services.core.e;
import com.amap.api.services.core.q;
import com.amap.api.services.core.r;
import com.amap.api.services.core.t;
import com.xiaomi.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PoiSearch {
    private static HashMap<Integer, PoiResult> i;
    Handler a = new h(this);
    private SearchBound b;
    private Query c;
    private Context d;
    private OnPoiSearchListener e;
    private Query f;
    private SearchBound g;
    private int h;

    public interface OnPoiSearchListener {
        void onPoiItemDetailSearched(PoiItemDetail poiItemDetail, int i);

        void onPoiSearched(PoiResult poiResult, int i);
    }

    public class Query implements Cloneable {
        private String a;
        private String b;
        private String c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        public Query(String str, String str2, String str3) {
            this.d = 0;
            this.e = 20;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        private String a() {
            return a.f;
        }

        public Query clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            Query query = new Query(this.a, this.b, this.c);
            query.setPageNum(this.d);
            query.setPageSize(this.e);
            query.setLimitDiscount(this.g);
            query.setLimitGroupbuy(this.f);
            return query;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Query query = (Query) obj;
            if (this.b == null) {
                if (query.b != null) {
                    return false;
                }
            } else if (!this.b.equals(query.b)) {
                return false;
            }
            if (this.c == null) {
                if (query.c != null) {
                    return false;
                }
            } else if (!this.c.equals(query.c)) {
                return false;
            }
            return this.g != query.g ? false : this.f != query.f ? false : this.d != query.d ? false : this.e != query.e ? false : this.a == null ? query.a == null : this.a.equals(query.a);
        }

        public String getCategory() {
            return (this.b == null || this.b.equals("00") || this.b.equals("00|")) ? a() : this.b;
        }

        public String getCity() {
            return this.c;
        }

        public int getPageNum() {
            return this.d;
        }

        public int getPageSize() {
            return this.e;
        }

        public String getQueryString() {
            return this.a;
        }

        public boolean hasDiscountLimit() {
            return this.g;
        }

        public boolean hasGroupBuyLimit() {
            return this.f;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((this.g ? 1231 : 1237) + (((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + 31) * 31)) * 31)) * 31;
            if (!this.f) {
                i = 1237;
            }
            hashCode = (((((hashCode + i) * 31) + this.d) * 31) + this.e) * 31;
            if (this.a != null) {
                i2 = this.a.hashCode();
            }
            return hashCode + i2;
        }

        public boolean queryEquals(Query query) {
            return query == null ? false : query != this ? PoiSearch.b(query.a, this.a) && PoiSearch.b(query.b, this.b) && PoiSearch.b(query.c, this.c) && query.e == this.e : true;
        }

        public void setLimitDiscount(boolean z) {
            this.g = z;
        }

        public void setLimitGroupbuy(boolean z) {
            this.f = z;
        }

        public void setPageNum(int i) {
            this.d = i;
        }

        public void setPageSize(int i) {
            this.e = i;
        }
    }

    public class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";
        private LatLonPoint a;
        private LatLonPoint b;
        private int c;
        private LatLonPoint d;
        private String e;
        private boolean f;
        private List<LatLonPoint> g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.f = true;
            this.e = BOUND_SHAPE;
            this.c = i;
            this.d = latLonPoint;
            a(latLonPoint, e.a(i), e.a(i));
        }

        public SearchBound(LatLonPoint latLonPoint, int i, boolean z) {
            this.f = true;
            this.e = BOUND_SHAPE;
            this.c = i;
            this.d = latLonPoint;
            a(latLonPoint, e.a(i), e.a(i));
            this.f = z;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f = true;
            this.e = RECTANGLE_SHAPE;
            a(latLonPoint, latLonPoint2);
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z) {
            this.f = true;
            this.a = latLonPoint;
            this.b = latLonPoint2;
            this.c = i;
            this.d = latLonPoint3;
            this.e = str;
            this.g = list;
            this.f = z;
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f = true;
            this.e = POLYGON_SHAPE;
            this.g = list;
        }

        private void a(LatLonPoint latLonPoint, double d, double d2) {
            double d3 = d / 2.0d;
            double d4 = d2 / 2.0d;
            double latitude = latLonPoint.getLatitude();
            double longitude = latLonPoint.getLongitude();
            a(new LatLonPoint(latitude - d3, longitude - d4), new LatLonPoint(d3 + latitude, d4 + longitude));
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
            if (this.a.getLatitude() >= this.b.getLatitude() || this.a.getLongitude() >= this.b.getLongitude()) {
                throw new IllegalArgumentException("invalid rect ");
            }
            this.d = new LatLonPoint((this.a.getLatitude() + this.b.getLatitude()) / 2.0d, (this.a.getLongitude() + this.b.getLongitude()) / 2.0d);
        }

        public SearchBound clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new SearchBound(this.a, this.b, this.c, this.d, this.e, this.g, this.f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            if (this.d == null) {
                if (searchBound.d != null) {
                    return false;
                }
            } else if (!this.d.equals(searchBound.d)) {
                return false;
            }
            if (this.f != searchBound.f) {
                return false;
            }
            if (this.a == null) {
                if (searchBound.a != null) {
                    return false;
                }
            } else if (!this.a.equals(searchBound.a)) {
                return false;
            }
            if (this.b == null) {
                if (searchBound.b != null) {
                    return false;
                }
            } else if (!this.b.equals(searchBound.b)) {
                return false;
            }
            if (this.g == null) {
                if (searchBound.g != null) {
                    return false;
                }
            } else if (!this.g.equals(searchBound.g)) {
                return false;
            }
            return this.c != searchBound.c ? false : this.e == null ? searchBound.e == null : this.e.equals(searchBound.e);
        }

        public LatLonPoint getCenter() {
            return this.d;
        }

        public double getLatSpanInMeter() {
            return !RECTANGLE_SHAPE.equals(getShape()) ? 0.0d : this.b.getLatitude() - this.a.getLatitude();
        }

        public double getLonSpanInMeter() {
            return !RECTANGLE_SHAPE.equals(getShape()) ? 0.0d : this.b.getLongitude() - this.a.getLongitude();
        }

        public LatLonPoint getLowerLeft() {
            return this.a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.g;
        }

        public int getRange() {
            return this.c;
        }

        public String getShape() {
            return this.e;
        }

        public LatLonPoint getUpperRight() {
            return this.b;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.g == null ? 0 : this.g.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + (((this.a == null ? 0 : this.a.hashCode()) + (((this.f ? 1231 : 1237) + (((this.d == null ? 0 : this.d.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31) + this.c) * 31;
            if (this.e != null) {
                i = this.e.hashCode();
            }
            return hashCode + i;
        }

        public boolean isDistanceSort() {
            return this.f;
        }
    }

    public PoiSearch(Context context, Query query) {
        d.a(context);
        this.d = context.getApplicationContext();
        setQuery(query);
    }

    private void a(PoiResult poiResult) {
        i = new HashMap();
        if (this.c != null && poiResult != null && this.h > 0 && this.h > this.c.getPageNum()) {
            i.put(Integer.valueOf(this.c.getPageNum()), poiResult);
        }
    }

    private boolean a() {
        return (e.a(this.c.a) && e.a(this.c.b)) ? false : true;
    }

    private boolean a(int i) {
        return i <= this.h && i >= 0;
    }

    private boolean b() {
        SearchBound bound = getBound();
        return bound != null && bound.equals(SearchBound.BOUND_SHAPE);
    }

    private static boolean b(String str, String str2) {
        return (str == null && str2 == null) ? true : (str == null || str2 == null) ? false : str.equals(str2);
    }

    public SearchBound getBound() {
        return this.b;
    }

    protected PoiResult getPageLocal(int i) {
        if (a(i)) {
            return (PoiResult) i.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("page out of range");
    }

    public Query getQuery() {
        return this.c;
    }

    public PoiResult searchPOI() {
        if (b() || a()) {
            if ((!this.c.queryEquals(this.f) && this.b == null) || !(this.c.queryEquals(this.f) || this.b.equals(this.g))) {
                this.h = 0;
                this.f = this.c.clone();
                if (this.b != null) {
                    this.g = this.b.clone();
                }
                if (i != null) {
                    i.clear();
                }
            }
            SearchBound searchBound = null;
            if (this.b != null) {
                searchBound = this.b.clone();
            }
            r rVar;
            PoiResult a;
            if (this.h == 0) {
                rVar = new r(new t(this.c.clone(), searchBound), e.a(this.d));
                rVar.a(this.c.d);
                rVar.b(this.c.e);
                a = PoiResult.a(rVar, (ArrayList) rVar.getData());
                a(a);
                return a;
            }
            PoiResult pageLocal = getPageLocal(this.c.getPageNum());
            if (pageLocal != null) {
                return pageLocal;
            }
            rVar = new r(new t(this.c.clone(), searchBound), e.a(this.d));
            rVar.a(this.c.d);
            rVar.b(this.c.e);
            a = PoiResult.a(rVar, (ArrayList) rVar.getData());
            i.put(Integer.valueOf(this.c.d), a);
            return a;
        }
        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
    }

    public void searchPOIAsyn() {
        new Thread(this) {
            final /* synthetic */ PoiSearch a;

            {
                this.a = r1;
            }

            public void run() {
                Message message = new Message();
                message.what = 100;
                Bundle bundle = new Bundle();
                Object obj = null;
                try {
                    obj = this.a.searchPOI();
                    bundle.putInt(com.xiaomi.channel.b.a.c, 0);
                } catch (AMapException e) {
                    bundle.putInt(com.xiaomi.channel.b.a.c, e.getErrorCode());
                } finally {
                    message.obj = obj;
                    message.setData(bundle);
                    this.a.a.sendMessage(message);
                }
            }
        }.start();
    }

    public PoiItemDetail searchPOIDetail(String str) {
        return (PoiItemDetail) new q(str, e.a(this.d)).getData();
    }

    public void searchPOIDetailAsyn(final String str) {
        new Thread(this) {
            final /* synthetic */ PoiSearch b;

            public void run() {
                Message message = new Message();
                message.what = ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE;
                Bundle bundle = new Bundle();
                Object obj = null;
                try {
                    obj = this.b.searchPOIDetail(str);
                    bundle.putInt(com.xiaomi.channel.b.a.c, 0);
                } catch (AMapException e) {
                    bundle.putInt(com.xiaomi.channel.b.a.c, e.getErrorCode());
                } finally {
                    message.obj = obj;
                    message.setData(bundle);
                    this.b.a.sendMessage(message);
                }
            }
        }.start();
    }

    public void setBound(SearchBound searchBound) {
        this.b = searchBound;
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        this.e = onPoiSearchListener;
    }

    public void setQuery(Query query) {
        this.c = query;
    }
}
