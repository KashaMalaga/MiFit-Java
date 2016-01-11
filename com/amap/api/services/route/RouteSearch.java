package com.amap.api.services.route;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.b;
import com.amap.api.services.core.d;
import com.amap.api.services.core.e;
import com.amap.api.services.core.g;
import com.amap.api.services.core.v;
import com.xiaomi.channel.b.a;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.List;

public class RouteSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;
    Handler a = new m(this);
    private OnRouteSearchListener b;
    private Context c;

    public class BusRouteQuery implements Parcelable, Cloneable {
        public static final Creator<BusRouteQuery> CREATOR = new n();
        private FromAndTo a;
        private int b;
        private String c;
        private int d;

        public BusRouteQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readString();
            this.d = parcel.readInt();
        }

        public BusRouteQuery(FromAndTo fromAndTo, int i, String str, int i2) {
            this.a = fromAndTo;
            this.b = i;
            this.c = str;
            this.d = i2;
        }

        public BusRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new BusRouteQuery(this.a, this.b, this.c, this.d);
        }

        public int describeContents() {
            return RouteSearch.WalkDefault;
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
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            if (this.c == null) {
                if (busRouteQuery.c != null) {
                    return false;
                }
            } else if (!this.c.equals(busRouteQuery.c)) {
                return false;
            }
            if (this.a == null) {
                if (busRouteQuery.a != null) {
                    return false;
                }
            } else if (!this.a.equals(busRouteQuery.a)) {
                return false;
            }
            return this.b != busRouteQuery.b ? false : this.d == busRouteQuery.d;
        }

        public String getCity() {
            return this.c;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public int getNightFlag() {
            return this.d;
        }

        public int hashCode() {
            int i = RouteSearch.WalkDefault;
            int hashCode = ((this.c == null ? RouteSearch.WalkDefault : this.c.hashCode()) + 31) * 31;
            if (this.a != null) {
                i = this.a.hashCode();
            }
            return ((((hashCode + i) * 31) + this.b) * 31) + this.d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
            parcel.writeInt(this.d);
        }
    }

    public class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Creator<DriveRouteQuery> CREATOR = new o();
        private FromAndTo a;
        private int b;
        private List<LatLonPoint> c;
        private List<List<LatLonPoint>> d;
        private String e;

        public DriveRouteQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.d = null;
            } else {
                this.d = new ArrayList();
            }
            for (int i = RouteSearch.WalkDefault; i < readInt; i += RouteSearch.WalkMultipath) {
                this.d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.e = parcel.readString();
        }

        public DriveRouteQuery(FromAndTo fromAndTo, int i, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.a = fromAndTo;
            this.b = i;
            this.c = list;
            this.d = list2;
            this.e = str;
        }

        public DriveRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new DriveRouteQuery(this.a, this.b, this.c, this.d, this.e);
        }

        public int describeContents() {
            return RouteSearch.WalkDefault;
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
            DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
            if (this.e == null) {
                if (driveRouteQuery.e != null) {
                    return false;
                }
            } else if (!this.e.equals(driveRouteQuery.e)) {
                return false;
            }
            if (this.d == null) {
                if (driveRouteQuery.d != null) {
                    return false;
                }
            } else if (!this.d.equals(driveRouteQuery.d)) {
                return false;
            }
            if (this.a == null) {
                if (driveRouteQuery.a != null) {
                    return false;
                }
            } else if (!this.a.equals(driveRouteQuery.a)) {
                return false;
            }
            return this.b != driveRouteQuery.b ? false : this.c == null ? driveRouteQuery.c == null : this.c.equals(driveRouteQuery.c);
        }

        public String getAvoidRoad() {
            return this.e;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.d;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.d == null || this.d.size() == 0) {
                return null;
            }
            for (int i = RouteSearch.WalkDefault; i < this.d.size(); i += RouteSearch.WalkMultipath) {
                List list = (List) this.d.get(i);
                for (int i2 = RouteSearch.WalkDefault; i2 < list.size(); i2 += RouteSearch.WalkMultipath) {
                    LatLonPoint latLonPoint = (LatLonPoint) list.get(i2);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(f.i);
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i2 < list.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i < this.d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.c;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.c == null || this.c.size() == 0) {
                return null;
            }
            for (int i = RouteSearch.WalkDefault; i < this.c.size(); i += RouteSearch.WalkMultipath) {
                LatLonPoint latLonPoint = (LatLonPoint) this.c.get(i);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(f.i);
                stringBuffer.append(latLonPoint.getLatitude());
                if (i < this.c.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidRoad() {
            return !e.a(getAvoidRoad());
        }

        public boolean hasAvoidpolygons() {
            return !e.a(getAvoidpolygonsStr());
        }

        public boolean hasPassPoint() {
            return !e.a(getPassedPointStr());
        }

        public int hashCode() {
            int i = RouteSearch.WalkDefault;
            int hashCode = ((((this.a == null ? RouteSearch.WalkDefault : this.a.hashCode()) + (((this.d == null ? RouteSearch.WalkDefault : this.d.hashCode()) + (((this.e == null ? RouteSearch.WalkDefault : this.e.hashCode()) + 31) * 31)) * 31)) * 31) + this.b) * 31;
            if (this.c != null) {
                i = this.c.hashCode();
            }
            return hashCode + i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeTypedList(this.c);
            if (this.d == null) {
                parcel.writeInt(RouteSearch.WalkDefault);
            } else {
                parcel.writeInt(this.d.size());
                for (List writeTypedList : this.d) {
                    parcel.writeTypedList(writeTypedList);
                }
            }
            parcel.writeString(this.e);
        }
    }

    public class FromAndTo implements Parcelable, Cloneable {
        public static final Creator<FromAndTo> CREATOR = new p();
        private LatLonPoint a;
        private LatLonPoint b;
        private String c;
        private String d;

        public FromAndTo(Parcel parcel) {
            this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.c = parcel.readString();
            this.d = parcel.readString();
        }

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
        }

        public FromAndTo clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            FromAndTo fromAndTo = new FromAndTo(this.a, this.b);
            fromAndTo.setStartPoiID(this.c);
            fromAndTo.setDestinationPoiID(this.d);
            return fromAndTo;
        }

        public int describeContents() {
            return RouteSearch.WalkDefault;
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
            FromAndTo fromAndTo = (FromAndTo) obj;
            if (this.d == null) {
                if (fromAndTo.d != null) {
                    return false;
                }
            } else if (!this.d.equals(fromAndTo.d)) {
                return false;
            }
            if (this.a == null) {
                if (fromAndTo.a != null) {
                    return false;
                }
            } else if (!this.a.equals(fromAndTo.a)) {
                return false;
            }
            if (this.c == null) {
                if (fromAndTo.c != null) {
                    return false;
                }
            } else if (!this.c.equals(fromAndTo.c)) {
                return false;
            }
            return this.b == null ? fromAndTo.b == null : this.b.equals(fromAndTo.b);
        }

        public String getDestinationPoiID() {
            return this.d;
        }

        public LatLonPoint getFrom() {
            return this.a;
        }

        public String getStartPoiID() {
            return this.c;
        }

        public LatLonPoint getTo() {
            return this.b;
        }

        public int hashCode() {
            int i = RouteSearch.WalkDefault;
            int hashCode = ((this.c == null ? RouteSearch.WalkDefault : this.c.hashCode()) + (((this.a == null ? RouteSearch.WalkDefault : this.a.hashCode()) + (((this.d == null ? RouteSearch.WalkDefault : this.d.hashCode()) + 31) * 31)) * 31)) * 31;
            if (this.b != null) {
                i = this.b.hashCode();
            }
            return hashCode + i;
        }

        public void setDestinationPoiID(String str) {
            this.d = str;
        }

        public void setStartPoiID(String str) {
            this.c = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
        }
    }

    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i);
    }

    public class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Creator<WalkRouteQuery> CREATOR = new q();
        private FromAndTo a;
        private int b;

        public WalkRouteQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
        }

        public WalkRouteQuery(FromAndTo fromAndTo, int i) {
            this.a = fromAndTo;
            this.b = i;
        }

        public WalkRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new WalkRouteQuery(this.a, this.b);
        }

        public int describeContents() {
            return RouteSearch.WalkDefault;
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
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            if (this.a == null) {
                if (walkRouteQuery.a != null) {
                    return false;
                }
            } else if (!this.a.equals(walkRouteQuery.a)) {
                return false;
            }
            return this.b == walkRouteQuery.b;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public int hashCode() {
            return (((this.a == null ? RouteSearch.WalkDefault : this.a.hashCode()) + 31) * 31) + this.b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
        }
    }

    public RouteSearch(Context context) {
        this.c = context.getApplicationContext();
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) {
        d.a(this.c);
        BusRouteQuery clone = busRouteQuery.clone();
        BusRouteResult busRouteResult = (BusRouteResult) new b(clone, e.a(this.c)).getData();
        if (busRouteResult != null) {
            busRouteResult.setBusQuery(clone);
        }
        return busRouteResult;
    }

    public void calculateBusRouteAsyn(final BusRouteQuery busRouteQuery) {
        new Thread(this) {
            final /* synthetic */ RouteSearch b;

            public void run() {
                Message message = new Message();
                message.what = 10;
                Bundle bundle = new Bundle();
                Object obj = null;
                try {
                    obj = this.b.calculateBusRoute(busRouteQuery);
                    bundle.putInt(a.c, RouteSearch.WalkDefault);
                } catch (AMapException e) {
                    bundle.putInt(a.c, e.getErrorCode());
                } finally {
                    message.obj = obj;
                    message.setData(bundle);
                    this.b.a.sendMessage(message);
                }
            }
        }.start();
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) {
        d.a(this.c);
        DriveRouteQuery clone = driveRouteQuery.clone();
        DriveRouteResult driveRouteResult = (DriveRouteResult) new g(clone, e.a(this.c)).getData();
        if (driveRouteResult != null) {
            driveRouteResult.setDriveQuery(clone);
        }
        return driveRouteResult;
    }

    public void calculateDriveRouteAsyn(final DriveRouteQuery driveRouteQuery) {
        new Thread(this) {
            final /* synthetic */ RouteSearch b;

            public void run() {
                Message message = new Message();
                message.what = 11;
                Bundle bundle = new Bundle();
                Object obj = null;
                try {
                    obj = this.b.calculateDriveRoute(driveRouteQuery);
                    bundle.putInt(a.c, RouteSearch.WalkDefault);
                } catch (AMapException e) {
                    bundle.putInt(a.c, e.getErrorCode());
                } finally {
                    message.obj = obj;
                    message.setData(bundle);
                    this.b.a.sendMessage(message);
                }
            }
        }.start();
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) {
        d.a(this.c);
        WalkRouteQuery clone = walkRouteQuery.clone();
        WalkRouteResult walkRouteResult = (WalkRouteResult) new v(clone, e.a(this.c)).getData();
        if (walkRouteResult != null) {
            walkRouteResult.setWalkQuery(clone);
        }
        return walkRouteResult;
    }

    public void calculateWalkRouteAsyn(final WalkRouteQuery walkRouteQuery) {
        new Thread(this) {
            final /* synthetic */ RouteSearch b;

            public void run() {
                Message message = new Message();
                message.what = 12;
                Bundle bundle = new Bundle();
                Object obj = null;
                try {
                    obj = this.b.calculateWalkRoute(walkRouteQuery);
                    bundle.putInt(a.c, RouteSearch.WalkDefault);
                } catch (AMapException e) {
                    bundle.putInt(a.c, e.getErrorCode());
                } finally {
                    message.obj = obj;
                    message.setData(bundle);
                    this.b.a.sendMessage(message);
                }
            }
        }.start();
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        this.b = onRouteSearchListener;
    }
}
