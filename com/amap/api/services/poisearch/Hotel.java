package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public final class Hotel implements Parcelable {
    public static final Creator<Hotel> CREATOR = new e();
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private List<Photo> l;

    public Hotel(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.createTypedArrayList(Photo.CREATOR);
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
        Hotel hotel = (Hotel) obj;
        if (this.j == null) {
            if (hotel.j != null) {
                return false;
            }
        } else if (!this.j.equals(hotel.j)) {
            return false;
        }
        if (this.k == null) {
            if (hotel.k != null) {
                return false;
            }
        } else if (!this.k.equals(hotel.k)) {
            return false;
        }
        if (this.g == null) {
            if (hotel.g != null) {
                return false;
            }
        } else if (!this.g.equals(hotel.g)) {
            return false;
        }
        if (this.e == null) {
            if (hotel.e != null) {
                return false;
            }
        } else if (!this.e.equals(hotel.e)) {
            return false;
        }
        if (this.f == null) {
            if (hotel.f != null) {
                return false;
            }
        } else if (!this.f.equals(hotel.f)) {
            return false;
        }
        if (this.c == null) {
            if (hotel.c != null) {
                return false;
            }
        } else if (!this.c.equals(hotel.c)) {
            return false;
        }
        if (this.d == null) {
            if (hotel.d != null) {
                return false;
            }
        } else if (!this.d.equals(hotel.d)) {
            return false;
        }
        if (this.l == null) {
            if (hotel.l != null) {
                return false;
            }
        } else if (!this.l.equals(hotel.l)) {
            return false;
        }
        if (this.a == null) {
            if (hotel.a != null) {
                return false;
            }
        } else if (!this.a.equals(hotel.a)) {
            return false;
        }
        if (this.h == null) {
            if (hotel.h != null) {
                return false;
            }
        } else if (!this.h.equals(hotel.h)) {
            return false;
        }
        if (this.b == null) {
            if (hotel.b != null) {
                return false;
            }
        } else if (!this.b.equals(hotel.b)) {
            return false;
        }
        return this.i == null ? hotel.i == null : this.i.equals(hotel.i);
    }

    public String getAddition() {
        return this.j;
    }

    public String getDeepsrc() {
        return this.k;
    }

    public String getEnvironmentRating() {
        return this.g;
    }

    public String getFaciRating() {
        return this.e;
    }

    public String getHealthRating() {
        return this.f;
    }

    public String getIntro() {
        return this.c;
    }

    public String getLowestPrice() {
        return this.d;
    }

    public List<Photo> getPhotos() {
        return this.l;
    }

    public String getRating() {
        return this.a;
    }

    public String getServiceRating() {
        return this.h;
    }

    public String getStar() {
        return this.b;
    }

    public String getTraffic() {
        return this.i;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.b == null ? 0 : this.b.hashCode()) + (((this.h == null ? 0 : this.h.hashCode()) + (((this.a == null ? 0 : this.a.hashCode()) + (((this.l == null ? 0 : this.l.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + (((this.f == null ? 0 : this.f.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((this.g == null ? 0 : this.g.hashCode()) + (((this.k == null ? 0 : this.k.hashCode()) + (((this.j == null ? 0 : this.j.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.i != null) {
            i = this.i.hashCode();
        }
        return hashCode + i;
    }

    public void setAddition(String str) {
        this.j = str;
    }

    public void setDeepsrc(String str) {
        this.k = str;
    }

    public void setEnvironmentRating(String str) {
        this.g = str;
    }

    public void setFaciRating(String str) {
        this.e = str;
    }

    public void setHealthRating(String str) {
        this.f = str;
    }

    public void setIntro(String str) {
        this.c = str;
    }

    public void setLowestPrice(String str) {
        this.d = str;
    }

    public void setPhotos(List<Photo> list) {
        this.l = list;
    }

    public void setRating(String str) {
        this.a = str;
    }

    public void setServiceRating(String str) {
        this.h = str;
    }

    public void setStar(String str) {
        this.b = str;
    }

    public void setTraffic(String str) {
        this.i = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeTypedList(this.l);
    }
}
