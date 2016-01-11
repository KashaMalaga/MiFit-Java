package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public final class Scenic implements Parcelable {
    public static final Creator<Scenic> CREATOR = new i();
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
    private String l;
    private List<Photo> m;

    public Scenic(Parcel parcel) {
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
        this.l = parcel.readString();
        this.m = parcel.createTypedArrayList(Photo.CREATOR);
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
        Scenic scenic = (Scenic) obj;
        if (this.c == null) {
            if (scenic.c != null) {
                return false;
            }
        } else if (!this.c.equals(scenic.c)) {
            return false;
        }
        if (this.a == null) {
            if (scenic.a != null) {
                return false;
            }
        } else if (!this.a.equals(scenic.a)) {
            return false;
        }
        if (this.d == null) {
            if (scenic.d != null) {
                return false;
            }
        } else if (!this.d.equals(scenic.d)) {
            return false;
        }
        if (this.l == null) {
            if (scenic.l != null) {
                return false;
            }
        } else if (!this.l.equals(scenic.l)) {
            return false;
        }
        if (this.k == null) {
            if (scenic.k != null) {
                return false;
            }
        } else if (!this.k.equals(scenic.k)) {
            return false;
        }
        if (this.i == null) {
            if (scenic.i != null) {
                return false;
            }
        } else if (!this.i.equals(scenic.i)) {
            return false;
        }
        if (this.j == null) {
            if (scenic.j != null) {
                return false;
            }
        } else if (!this.j.equals(scenic.j)) {
            return false;
        }
        if (this.m == null) {
            if (scenic.m != null) {
                return false;
            }
        } else if (!this.m.equals(scenic.m)) {
            return false;
        }
        if (this.e == null) {
            if (scenic.e != null) {
                return false;
            }
        } else if (!this.e.equals(scenic.e)) {
            return false;
        }
        if (this.b == null) {
            if (scenic.b != null) {
                return false;
            }
        } else if (!this.b.equals(scenic.b)) {
            return false;
        }
        if (this.g == null) {
            if (scenic.g != null) {
                return false;
            }
        } else if (!this.g.equals(scenic.g)) {
            return false;
        }
        if (this.f == null) {
            if (scenic.f != null) {
                return false;
            }
        } else if (!this.f.equals(scenic.f)) {
            return false;
        }
        return this.h == null ? scenic.h == null : this.h.equals(scenic.h);
    }

    public String getDeepsrc() {
        return this.c;
    }

    public String getIntro() {
        return this.a;
    }

    public String getLevel() {
        return this.d;
    }

    public String getOpentime() {
        return this.l;
    }

    public String getOpentimeGDF() {
        return this.k;
    }

    public String getOrderWapUrl() {
        return this.i;
    }

    public String getOrderWebUrl() {
        return this.j;
    }

    public List<Photo> getPhotos() {
        return this.m;
    }

    public String getPrice() {
        return this.e;
    }

    public String getRating() {
        return this.b;
    }

    public String getRecommend() {
        return this.g;
    }

    public String getSeason() {
        return this.f;
    }

    public String getTheme() {
        return this.h;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f == null ? 0 : this.f.hashCode()) + (((this.g == null ? 0 : this.g.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((this.m == null ? 0 : this.m.hashCode()) + (((this.j == null ? 0 : this.j.hashCode()) + (((this.i == null ? 0 : this.i.hashCode()) + (((this.k == null ? 0 : this.k.hashCode()) + (((this.l == null ? 0 : this.l.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.a == null ? 0 : this.a.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.h != null) {
            i = this.h.hashCode();
        }
        return hashCode + i;
    }

    public void setDeepsrc(String str) {
        this.c = str;
    }

    public void setIntro(String str) {
        this.a = str;
    }

    public void setLevel(String str) {
        this.d = str;
    }

    public void setOpentime(String str) {
        this.l = str;
    }

    public void setOpentimeGDF(String str) {
        this.k = str;
    }

    public void setOrderWapUrl(String str) {
        this.i = str;
    }

    public void setOrderWebUrl(String str) {
        this.j = str;
    }

    public void setPhotos(List<Photo> list) {
        this.m = list;
    }

    public void setPrice(String str) {
        this.e = str;
    }

    public void setRating(String str) {
        this.b = str;
    }

    public void setRecommend(String str) {
        this.g = str;
    }

    public void setSeason(String str) {
        this.f = str;
    }

    public void setTheme(String str) {
        this.h = str;
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
        parcel.writeString(this.l);
        parcel.writeTypedList(this.m);
    }
}
