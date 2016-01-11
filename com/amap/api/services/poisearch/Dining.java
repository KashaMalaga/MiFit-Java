package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public final class Dining implements Parcelable {
    public static final Creator<Dining> CREATOR = new b();
    private boolean a;
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
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private List<Photo> t;

    public Dining(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.a = zArr[0];
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
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.t = parcel.createTypedArrayList(Photo.CREATOR);
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
        Dining dining = (Dining) obj;
        if (this.s == null) {
            if (dining.s != null) {
                return false;
            }
        } else if (!this.s.equals(dining.s)) {
            return false;
        }
        if (this.m == null) {
            if (dining.m != null) {
                return false;
            }
        } else if (!this.m.equals(dining.m)) {
            return false;
        }
        if (this.k == null) {
            if (dining.k != null) {
                return false;
            }
        } else if (!this.k.equals(dining.k)) {
            return false;
        }
        if (this.f == null) {
            if (dining.f != null) {
                return false;
            }
        } else if (!this.f.equals(dining.f)) {
            return false;
        }
        if (this.b == null) {
            if (dining.b != null) {
                return false;
            }
        } else if (!this.b.equals(dining.b)) {
            return false;
        }
        if (this.g == null) {
            if (dining.g != null) {
                return false;
            }
        } else if (!this.g.equals(dining.g)) {
            return false;
        }
        if (this.i == null) {
            if (dining.i != null) {
                return false;
            }
        } else if (!this.i.equals(dining.i)) {
            return false;
        }
        if (this.d == null) {
            if (dining.d != null) {
                return false;
            }
        } else if (!this.d.equals(dining.d)) {
            return false;
        }
        if (this.a != dining.a) {
            return false;
        }
        if (this.r == null) {
            if (dining.r != null) {
                return false;
            }
        } else if (!this.r.equals(dining.r)) {
            return false;
        }
        if (this.q == null) {
            if (dining.q != null) {
                return false;
            }
        } else if (!this.q.equals(dining.q)) {
            return false;
        }
        if (this.p == null) {
            if (dining.p != null) {
                return false;
            }
        } else if (!this.p.equals(dining.p)) {
            return false;
        }
        if (this.n == null) {
            if (dining.n != null) {
                return false;
            }
        } else if (!this.n.equals(dining.n)) {
            return false;
        }
        if (this.o == null) {
            if (dining.o != null) {
                return false;
            }
        } else if (!this.o.equals(dining.o)) {
            return false;
        }
        if (this.t == null) {
            if (dining.t != null) {
                return false;
            }
        } else if (!this.t.equals(dining.t)) {
            return false;
        }
        if (this.e == null) {
            if (dining.e != null) {
                return false;
            }
        } else if (!this.e.equals(dining.e)) {
            return false;
        }
        if (this.l == null) {
            if (dining.l != null) {
                return false;
            }
        } else if (!this.l.equals(dining.l)) {
            return false;
        }
        if (this.j == null) {
            if (dining.j != null) {
                return false;
            }
        } else if (!this.j.equals(dining.j)) {
            return false;
        }
        if (this.c == null) {
            if (dining.c != null) {
                return false;
            }
        } else if (!this.c.equals(dining.c)) {
            return false;
        }
        return this.h == null ? dining.h == null : this.h.equals(dining.h);
    }

    public String getAddition() {
        return this.s;
    }

    public String getAtmosphere() {
        return this.m;
    }

    public String getCost() {
        return this.k;
    }

    public String getCpRating() {
        return this.f;
    }

    public String getCuisines() {
        return this.b;
    }

    public String getDeepsrc() {
        return this.g;
    }

    public String getEnvironmentRating() {
        return this.i;
    }

    public String getIntro() {
        return this.d;
    }

    public String getOpentime() {
        return this.r;
    }

    public String getOpentimeGDF() {
        return this.q;
    }

    public String getOrderinAppUrl() {
        return this.p;
    }

    public String getOrderingWapUrl() {
        return this.n;
    }

    public String getOrderingWebUrl() {
        return this.o;
    }

    public List<Photo> getPhotos() {
        return this.t;
    }

    public String getRating() {
        return this.e;
    }

    public String getRecommend() {
        return this.l;
    }

    public String getServiceRating() {
        return this.j;
    }

    public String getTag() {
        return this.c;
    }

    public String getTasteRating() {
        return this.h;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.c == null ? 0 : this.c.hashCode()) + (((this.j == null ? 0 : this.j.hashCode()) + (((this.l == null ? 0 : this.l.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((this.t == null ? 0 : this.t.hashCode()) + (((this.o == null ? 0 : this.o.hashCode()) + (((this.n == null ? 0 : this.n.hashCode()) + (((this.p == null ? 0 : this.p.hashCode()) + (((this.q == null ? 0 : this.q.hashCode()) + (((this.r == null ? 0 : this.r.hashCode()) + (((this.a ? 1231 : 1237) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.i == null ? 0 : this.i.hashCode()) + (((this.g == null ? 0 : this.g.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + (((this.f == null ? 0 : this.f.hashCode()) + (((this.k == null ? 0 : this.k.hashCode()) + (((this.m == null ? 0 : this.m.hashCode()) + (((this.s == null ? 0 : this.s.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.h != null) {
            i = this.h.hashCode();
        }
        return hashCode + i;
    }

    public boolean isMealOrdering() {
        return this.a;
    }

    public void setAddition(String str) {
        this.s = str;
    }

    public void setAtmosphere(String str) {
        this.m = str;
    }

    public void setCost(String str) {
        this.k = str;
    }

    public void setCpRating(String str) {
        this.f = str;
    }

    public void setCuisines(String str) {
        this.b = str;
    }

    public void setDeepsrc(String str) {
        this.g = str;
    }

    public void setEnvironmentRating(String str) {
        this.i = str;
    }

    public void setIntro(String str) {
        this.d = str;
    }

    public void setMealOrdering(boolean z) {
        this.a = z;
    }

    public void setOpentime(String str) {
        this.r = str;
    }

    public void setOpentimeGDF(String str) {
        this.q = str;
    }

    public void setOrderinAppUrl(String str) {
        this.p = str;
    }

    public void setOrderingWapUrl(String str) {
        this.n = str;
    }

    public void setOrderingWebUrl(String str) {
        this.o = str;
    }

    public void setPhotos(List<Photo> list) {
        this.t = list;
    }

    public void setRating(String str) {
        this.e = str;
    }

    public void setRecommend(String str) {
        this.l = str;
    }

    public void setServiceRating(String str) {
        this.j = str;
    }

    public void setTag(String str) {
        this.c = str;
    }

    public void setTasteRating(String str) {
        this.h = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.a});
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
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeTypedList(this.t);
    }
}
