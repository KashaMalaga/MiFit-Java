package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public final class Cinema implements Parcelable {
    public static final Creator<Cinema> CREATOR = new a();
    private boolean a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private List<Photo> h;

    public Cinema(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.a = zArr[0];
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.createTypedArrayList(Photo.CREATOR);
    }

    public int describeContents() {
        return 0;
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
        Cinema cinema = (Cinema) obj;
        if (this.d == null) {
            if (cinema.d != null) {
                return false;
            }
        } else if (!this.d.equals(cinema.d)) {
            return false;
        }
        if (this.b == null) {
            if (cinema.b != null) {
                return false;
            }
        } else if (!this.b.equals(cinema.b)) {
            return false;
        }
        if (this.g == null) {
            if (cinema.g != null) {
                return false;
            }
        } else if (!this.g.equals(cinema.g)) {
            return false;
        }
        if (this.f == null) {
            if (cinema.f != null) {
                return false;
            }
        } else if (!this.f.equals(cinema.f)) {
            return false;
        }
        if (this.e == null) {
            if (cinema.e != null) {
                return false;
            }
        } else if (!this.e.equals(cinema.e)) {
            return false;
        }
        if (this.h == null) {
            if (cinema.h != null) {
                return false;
            }
        } else if (!this.h.equals(cinema.h)) {
            return false;
        }
        if (this.c == null) {
            if (cinema.c != null) {
                return false;
            }
        } else if (!this.c.equals(cinema.c)) {
            return false;
        }
        return this.a == cinema.a;
    }

    public String getDeepsrc() {
        return this.d;
    }

    public String getIntro() {
        return this.b;
    }

    public String getOpentime() {
        return this.g;
    }

    public String getOpentimeGDF() {
        return this.f;
    }

    public String getParking() {
        return this.e;
    }

    public List<Photo> getPhotos() {
        return this.h;
    }

    public String getRating() {
        return this.c;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.h == null ? 0 : this.h.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((this.f == null ? 0 : this.f.hashCode()) + (((this.g == null ? 0 : this.g.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.c != null) {
            i = this.c.hashCode();
        }
        return (this.a ? 1231 : 1237) + ((hashCode + i) * 31);
    }

    public boolean isSeatOrdering() {
        return this.a;
    }

    public void setDeepsrc(String str) {
        this.d = str;
    }

    public void setIntro(String str) {
        this.b = str;
    }

    public void setOpentime(String str) {
        this.g = str;
    }

    public void setOpentimeGDF(String str) {
        this.f = str;
    }

    public void setParking(String str) {
        this.e = str;
    }

    public void setPhotos(List<Photo> list) {
        this.h = list;
    }

    public void setRating(String str) {
        this.c = str;
    }

    public void setSeatOrdering(boolean z) {
        this.a = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.a});
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeTypedList(this.h);
    }
}
