package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.DriveRouteQuery;
import java.util.List;

public class DriveRouteResult extends RouteResult implements Parcelable {
    public static final Creator<DriveRouteResult> CREATOR = new g();
    private List<DrivePath> a;
    private DriveRouteQuery b;

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.b = (DriveRouteQuery) parcel.readParcelable(DriveRouteQuery.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public DriveRouteQuery getDriveQuery() {
        return this.b;
    }

    public List<DrivePath> getPaths() {
        return this.a;
    }

    public void setDriveQuery(DriveRouteQuery driveRouteQuery) {
        this.b = driveRouteQuery;
    }

    public void setPaths(List<DrivePath> list) {
        this.a = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
        parcel.writeParcelable(this.b, i);
    }
}
