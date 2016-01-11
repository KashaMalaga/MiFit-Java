package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class OfflineMapManager {
    protected static final String UPDATE_OFFLINE_FILE = "update_file";
    static String a = com.xiaomi.e.a.f;
    private static String b = "citycode";
    private static String c = "cityname";
    protected static final int mMessageUpdateFile = 1;
    private d d;
    private OfflineMapDownloadListener e;
    private CopyOnWriteArrayList<OfflineMapCity> f = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<OfflineMapProvince> g = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<OfflineMapCity> h = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<OfflineMapProvince> i = new CopyOnWriteArrayList();
    private Context j;
    private String k = com.xiaomi.e.a.f;
    private String l = com.xiaomi.e.a.f;
    private AMap m;
    protected boolean mIsStart = false;

    public interface OfflineMapDownloadListener {
        void onDownload(int i, int i2, String str);
    }

    class a extends Handler {
        final /* synthetic */ OfflineMapManager a;

        public a(OfflineMapManager offlineMapManager, Looper looper) {
            this.a = offlineMapManager;
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                if (message.what == OfflineMapManager.mMessageUpdateFile) {
                    Bundle data = message.getData();
                    if (data != null) {
                        List parcelableArrayList = data.getParcelableArrayList(OfflineMapManager.UPDATE_OFFLINE_FILE);
                        if (parcelableArrayList != null) {
                            this.a.d.e();
                            this.a.d.a(parcelableArrayList);
                        }
                    }
                } else if (this.a.e != null) {
                    this.a.e.onDownload(message.getData().getInt(LocationManagerProxy.KEY_STATUS_CHANGED), message.getData().getInt("complete"), message.getData().getString("name"));
                    this.a.a(message);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) {
        a(context, offlineMapDownloadListener);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.m = aMap;
        a(context, offlineMapDownloadListener);
    }

    private OfflineMapCity a(OfflineMapProvince offlineMapProvince) {
        ArrayList cityList = offlineMapProvince.getCityList();
        return (cityList == null || cityList.size() != mMessageUpdateFile) ? null : (OfflineMapCity) cityList.get(0);
    }

    private void a() {
        File file = new File(d.a());
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i = 0; i < length; i += mMessageUpdateFile) {
                File file2 = listFiles[i];
                if (file2.getName().endsWith(".zip.tmp.dt")) {
                    l d = d(file2);
                    if (!(d == null || d.b() == null)) {
                        if (!a(file2)) {
                            a(d);
                        }
                        if (a(file2)) {
                            b(d);
                        }
                    }
                }
            }
        }
    }

    private void a(int i, String str, String str2, int i2) {
        int i3 = 0;
        while (i3 < this.f.size()) {
            try {
                OfflineMapCity offlineMapCity = (OfflineMapCity) this.f.get(i3);
                if (offlineMapCity.getCity().equals(str) && offlineMapCity.getAdcode().equals(str2)) {
                    offlineMapCity.setCompleteCode(i2);
                    offlineMapCity.setState(i);
                    if (a(i, i2)) {
                        this.f.remove(offlineMapCity);
                        this.h.add(offlineMapCity);
                        this.k = com.xiaomi.e.a.f;
                        this.mIsStart = false;
                    }
                }
                i3 += mMessageUpdateFile;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    private void a(Context context, OfflineMapDownloadListener offlineMapDownloadListener) {
        this.j = context.getApplicationContext();
        this.d = new d(context, new a(this, context.getMainLooper()), this, this.m);
        this.e = offlineMapDownloadListener;
        this.d.d();
        a();
        if (this.mIsStart) {
            pause();
        }
    }

    private void a(Message message) {
        String string = message.getData().getString("adcode");
        String string2 = message.getData().getString("name");
        int i = message.getData().getInt(LocationManagerProxy.KEY_STATUS_CHANGED);
        int i2 = message.getData().getInt("complete");
        boolean z = message.getData().getBoolean("sheng");
        if (i == -1) {
            this.mIsStart = false;
        }
        if (d(string2)) {
            b(i, string2, string, i2);
            a(i, string2, string, i2);
        } else if (z) {
            b(i, string2, string, i2);
        } else {
            a(i, string2, string, i2);
        }
    }

    private void a(OfflineMapCity offlineMapCity) {
        if (!c(offlineMapCity)) {
            if (d(offlineMapCity.getCity())) {
                this.g.add(b(offlineMapCity));
            }
            this.f.add(offlineMapCity);
        }
        l lVar = new l(offlineMapCity);
        lVar.a(this.d.b.size());
        lVar.a = 2;
        this.d.b.add(lVar);
        this.d.a(this.d.b.size() - 1);
        this.k = offlineMapCity.getCity();
    }

    private void a(l lVar) {
        if (d(lVar.b())) {
            this.g.add(d(lVar));
            this.f.add(c(lVar));
        } else if (lVar.i()) {
            this.g.add(d(lVar));
        } else {
            this.f.add(c(lVar));
        }
    }

    private void a(Object obj, long j, long j2) {
        if (obj == null) {
            throw new AMapException(com.amap.api.services.core.AMapException.ERROR_INVALID_PARAMETER);
        } else if (((double) m.a()) < (((double) j) * 2.5d) - ((double) j2)) {
            throw new AMapException(AMapException.ERROR_NOT_ENOUGH_SPACE);
        } else if (!m.b()) {
            throw new AMapException(AMapException.ERROR_NOT_AVAILABLE);
        }
    }

    private boolean a(int i, int i2) {
        return i == 4;
    }

    private boolean a(File file) {
        return file != null && file.getName().endsWith(".zip.tmp.dt") && c(file) == 4;
    }

    private boolean a(String str) {
        OfflineMapCity itemByCityName = getItemByCityName(str);
        if (itemByCityName == null) {
            return false;
        }
        boolean a = this.d.a(new l(itemByCityName));
        if (a) {
            OfflineMapCity offlineMapCity;
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                offlineMapCity = (OfflineMapCity) it.next();
                if (itemByCityName.getCity().equalsIgnoreCase(offlineMapCity.getCity())) {
                    this.f.remove(offlineMapCity);
                }
            }
            it = this.h.iterator();
            while (it.hasNext()) {
                offlineMapCity = (OfflineMapCity) it.next();
                if (itemByCityName.getCity().equalsIgnoreCase(offlineMapCity.getCity())) {
                    this.h.remove(offlineMapCity);
                }
            }
            if (d(str)) {
                OfflineMapProvince offlineMapProvince;
                it = this.g.iterator();
                while (it.hasNext()) {
                    offlineMapProvince = (OfflineMapProvince) it.next();
                    if (offlineMapProvince.getProvinceName().equalsIgnoreCase(itemByCityName.getCity())) {
                        this.g.remove(offlineMapProvince);
                    }
                }
                it = this.i.iterator();
                while (it.hasNext()) {
                    offlineMapProvince = (OfflineMapProvince) it.next();
                    if (offlineMapProvince.getProvinceName().equalsIgnoreCase(itemByCityName.getCity())) {
                        this.i.remove(offlineMapProvince);
                    }
                }
            }
        }
        return a;
    }

    private boolean a(String str, String str2) {
        if (this.d.d.size() <= 0) {
            return false;
        }
        if (str == null || str.equals(com.xiaomi.e.a.f)) {
            throw new AMapException(com.amap.api.services.core.AMapException.ERROR_INVALID_PARAMETER);
        }
        int i = 0;
        boolean z = false;
        while (i < this.d.d.size() && !str.trim().equals(((OfflineMapProvince) this.d.d.get(i)).getProvinceName().trim())) {
            Iterator it = ((OfflineMapProvince) this.d.d.get(i)).getCityList().iterator();
            while (it.hasNext()) {
                OfflineMapCity offlineMapCity = (OfflineMapCity) it.next();
                if (!str.trim().equals(offlineMapCity.getCode().trim())) {
                    if (str.trim().equals(offlineMapCity.getCity().trim())) {
                    }
                }
                z = mMessageUpdateFile;
            }
            if (z) {
                break;
            } else if (i == this.d.d.size() - 1) {
                throw new AMapException(com.amap.api.services.core.AMapException.ERROR_INVALID_PARAMETER);
            } else {
                i += mMessageUpdateFile;
            }
        }
        Iterator it2 = this.f.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            z2 = ((OfflineMapCity) it2.next()).getCity().equals(str) ? mMessageUpdateFile : z2;
        }
        it2 = this.h.iterator();
        while (it2.hasNext()) {
            if (((OfflineMapCity) it2.next()).getCity().equals(str)) {
                z2 = mMessageUpdateFile;
            }
        }
        it2 = this.g.iterator();
        while (it2.hasNext()) {
            if (((OfflineMapProvince) it2.next()).getProvinceName().equals(str)) {
                z2 = mMessageUpdateFile;
            }
        }
        it2 = this.i.iterator();
        while (it2.hasNext()) {
            if (((OfflineMapProvince) it2.next()).getProvinceName().equals(str)) {
                z2 = mMessageUpdateFile;
            }
        }
        if (!z2) {
            return true;
        }
        OfflineInitBean offlineInitBean = (OfflineInitBean) new e(this.j, a).getData();
        if (offlineInitBean == null || !offlineInitBean.a) {
            return false;
        }
        updateAllCity();
        return true;
    }

    private OfflineMapProvince b(OfflineMapCity offlineMapCity) {
        if (offlineMapCity == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        ArrayList arrayList = new ArrayList();
        arrayList.add(offlineMapCity);
        offlineMapProvince.setCityList(arrayList);
        offlineMapProvince.setCompleteCode(offlineMapCity.getcompleteCode());
        offlineMapProvince.setJianpin(offlineMapCity.getJianpin());
        offlineMapProvince.setPinyin(offlineMapCity.getPinyin());
        offlineMapProvince.setProvinceCode(offlineMapCity.getAdcode());
        offlineMapProvince.setProvinceName(offlineMapCity.getCity());
        offlineMapProvince.setSize(offlineMapCity.getSize());
        offlineMapProvince.setState(offlineMapCity.getState());
        offlineMapProvince.setUrl(offlineMapCity.getUrl());
        offlineMapProvince.setVersion(offlineMapCity.getVersion());
        return offlineMapProvince;
    }

    private String b(File file) {
        return d(file).c();
    }

    private void b() {
        if (!u.c(this.j)) {
            throw new AMapException(com.amap.api.services.core.AMapException.ERROR_CONNECTION);
        }
    }

    private void b(int i, String str, String str2, int i2) {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
            if (offlineMapProvince.getProvinceName().equals(str) && offlineMapProvince.getProvinceCode().equals(str2)) {
                offlineMapProvince.setCompleteCode(i2);
                offlineMapProvince.setState(i);
                if (a(i, i2)) {
                    this.g.remove(offlineMapProvince);
                    this.i.add(offlineMapProvince);
                    this.l = com.xiaomi.e.a.f;
                    this.mIsStart = false;
                }
                Iterator it2 = offlineMapProvince.getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity offlineMapCity = (OfflineMapCity) it2.next();
                    offlineMapCity.setCompleteCode(i2);
                    offlineMapCity.setState(i);
                }
            }
        }
    }

    private void b(OfflineMapProvince offlineMapProvince) {
        if (!c(offlineMapProvince)) {
            if (d(offlineMapProvince.getProvinceName())) {
                this.f.add(a(offlineMapProvince));
            }
            this.g.add(offlineMapProvince);
        }
        l lVar = new l(offlineMapProvince);
        lVar.a(this.d.b.size());
        lVar.a = 2;
        this.d.b.add(lVar);
        this.d.a(this.d.b.size() - 1);
        this.l = offlineMapProvince.getProvinceName();
    }

    private void b(l lVar) {
        if (d(lVar.b())) {
            this.i.add(d(lVar));
            this.h.add(c(lVar));
        } else if (lVar.i()) {
            this.i.add(d(lVar));
        } else {
            this.h.add(c(lVar));
        }
    }

    private boolean b(String str) {
        OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
        if (itemByProvinceName == null) {
            return false;
        }
        boolean a = this.d.a(new l(itemByProvinceName));
        if (a) {
            OfflineMapProvince offlineMapProvince;
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                offlineMapProvince = (OfflineMapProvince) it.next();
                if (offlineMapProvince.getProvinceName().equalsIgnoreCase(itemByProvinceName.getProvinceName())) {
                    this.g.remove(offlineMapProvince);
                }
            }
            it = this.i.iterator();
            while (it.hasNext()) {
                offlineMapProvince = (OfflineMapProvince) it.next();
                if (itemByProvinceName.getProvinceName().equalsIgnoreCase(itemByProvinceName.getProvinceName())) {
                    this.i.remove(offlineMapProvince);
                }
            }
        }
        return a;
    }

    private boolean b(String str, String str2) {
        Iterator it;
        for (OfflineMapCity adcode : this.h) {
            if (adcode.getAdcode().equalsIgnoreCase(str)) {
                return true;
            }
        }
        if (d(str2)) {
            it = getDownloadOfflineMapProvinceList().iterator();
            while (it.hasNext()) {
                if (((OfflineMapProvince) it.next()).getProvinceCode().equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int c(File file) {
        return d(file).a;
    }

    private OfflineMapCity c(l lVar) {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setCity(lVar.b());
        offlineMapCity.setAdcode(lVar.e());
        offlineMapCity.setSize(lVar.g());
        offlineMapCity.setState(lVar.a);
        offlineMapCity.setUrl(lVar.f());
        offlineMapCity.setVersion(lVar.c());
        offlineMapCity.setCompleteCode(lVar.j());
        offlineMapCity.setCode(lVar.k());
        return offlineMapCity;
    }

    private void c(String str) {
        File[] listFiles = new File(d.a()).listFiles();
        if (listFiles != null && listFiles.length != 0) {
            int length = listFiles.length;
            for (int i = 0; i < length; i += mMessageUpdateFile) {
                File file = listFiles[i];
                if (file.getName().contains(str)) {
                    file.delete();
                }
            }
        }
    }

    private boolean c(OfflineMapCity offlineMapCity) {
        if (offlineMapCity == null) {
            return false;
        }
        try {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                OfflineMapCity offlineMapCity2 = (OfflineMapCity) it.next();
                String city = offlineMapCity2.getCity();
                String adcode = offlineMapCity2.getAdcode();
                if (city.equals(offlineMapCity.getCity()) && adcode.equals(offlineMapCity.getAdcode())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private boolean c(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            OfflineMapProvince offlineMapProvince2 = (OfflineMapProvince) it.next();
            String provinceName = offlineMapProvince2.getProvinceName();
            String provinceCode = offlineMapProvince2.getProvinceCode();
            if (provinceName.equals(offlineMapProvince.getProvinceName()) && provinceCode.equals(offlineMapProvince.getProvinceCode())) {
                return true;
            }
        }
        return false;
    }

    private boolean c(String str, String str2) {
        Iterator it = getDownloadOfflineMapProvinceList().iterator();
        while (it.hasNext()) {
            if (((OfflineMapProvince) it.next()).getProvinceCode().equalsIgnoreCase(str)) {
                return true;
            }
        }
        if (d(str2)) {
            for (OfflineMapCity adcode : getDownloadOfflineMapCityList()) {
                if (adcode.getAdcode().equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private OfflineMapProvince d(l lVar) {
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setProvinceName(lVar.b());
        offlineMapProvince.setProvinceCode(lVar.e());
        offlineMapProvince.setSize(lVar.g());
        offlineMapProvince.setState(lVar.a);
        offlineMapProvince.setUrl(lVar.f());
        offlineMapProvince.setVersion(lVar.c());
        offlineMapProvince.setCompleteCode(lVar.j());
        return offlineMapProvince;
    }

    private l d(File file) {
        String a = u.a(file);
        l lVar = new l();
        lVar.g(a);
        return lVar;
    }

    private boolean d(OfflineMapCity offlineMapCity) {
        long j;
        long j2 = 0;
        try {
            Iterator it = getDownloadingCityList().iterator();
            while (it.hasNext()) {
                long size;
                OfflineMapCity offlineMapCity2 = (OfflineMapCity) it.next();
                if (offlineMapCity.getCity().equals(offlineMapCity2.getCity())) {
                    size = (((long) offlineMapCity2.getcompleteCode()) * offlineMapCity2.getSize()) / 100;
                } else {
                    size = j2;
                }
                j2 = size;
            }
            j = j2;
        } catch (Throwable th) {
            j = 0;
            th.printStackTrace();
        }
        a(offlineMapCity, offlineMapCity.getSize(), j);
        if (this.mIsStart) {
            return false;
        }
        d(offlineMapCity.getAdcode(), offlineMapCity.getVersion());
        if (b(offlineMapCity.getAdcode(), offlineMapCity.getCity())) {
            return false;
        }
        a(offlineMapCity);
        return true;
    }

    private boolean d(OfflineMapProvince offlineMapProvince) {
        long j;
        long j2 = 0;
        try {
            Iterator it = getDownloadingProvinceList().iterator();
            while (it.hasNext()) {
                long size;
                OfflineMapProvince offlineMapProvince2 = (OfflineMapProvince) it.next();
                if (offlineMapProvince2.getProvinceName().equals(offlineMapProvince.getProvinceName())) {
                    size = (((long) offlineMapProvince2.getcompleteCode()) * offlineMapProvince2.getSize()) / 100;
                } else {
                    size = j2;
                }
                j2 = size;
            }
            j = j2;
        } catch (Throwable th) {
            j = 0;
            th.printStackTrace();
        }
        a(offlineMapProvince, offlineMapProvince.getSize(), j);
        if (this.mIsStart) {
            return false;
        }
        d(offlineMapProvince.getProvinceCode(), offlineMapProvince.getVersion());
        if (c(offlineMapProvince.getProvinceCode(), offlineMapProvince.getProvinceName())) {
            return false;
        }
        b(offlineMapProvince);
        return true;
    }

    private boolean d(String str) {
        return (str == null || com.xiaomi.e.a.f.equals(str)) ? false : str.equals("\u5317\u4eac") || str.equals("\u4e0a\u6d77") || str.equals("\u5929\u6d25") || str.equals("\u91cd\u5e86") || str.equals("\u9999\u6e2f") || str.equals("\u6fb3\u95e8") || str.equals("\u5168\u56fd\u6982\u8981\u56fe");
    }

    private boolean d(String str, String str2) {
        File file = new File(d.a() + (str + ".zip.tmp.dt"));
        if (file.exists() && e(str2, b(file))) {
            c(str);
        }
        return false;
    }

    private boolean e(String str, String str2) {
        return com.xiaomi.e.a.f.equals(str2) || !str.equals(str2);
    }

    private boolean f(String str, String str2) {
        try {
            b();
            OfflineMapCity offlineMapCity = null;
            if (str2.equals(b)) {
                offlineMapCity = getItemByCityCode(str);
            }
            if (str2.equals(c)) {
                offlineMapCity = getItemByCityName(str);
            }
            if (offlineMapCity != null) {
                return d(offlineMapCity);
            }
            throw new AMapException(com.amap.api.services.core.AMapException.ERROR_INVALID_PARAMETER);
        } catch (Throwable th) {
            if (th instanceof AMapException) {
                AMapException aMapException = (AMapException) th;
            } else {
                th.printStackTrace();
                return false;
            }
        }
    }

    public boolean downloadByCityCode(String str) {
        return f(str, b);
    }

    public boolean downloadByCityName(String str) {
        return f(str, c);
    }

    public boolean downloadByProvinceName(String str) {
        try {
            b();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName != null) {
                return d(itemByProvinceName);
            }
            throw new AMapException(com.amap.api.services.core.AMapException.ERROR_INVALID_PARAMETER);
        } catch (Throwable th) {
            if (th instanceof AMapException) {
                AMapException aMapException = (AMapException) th;
            } else {
                th.printStackTrace();
                return false;
            }
        }
    }

    public List<OfflineMapCity> getDownloadOfflineMapCityList() {
        List arrayList = new ArrayList();
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            arrayList.add((OfflineMapCity) it.next());
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList();
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            arrayList.add((OfflineMapProvince) it.next());
        }
        return arrayList;
    }

    public ArrayList<OfflineMapCity> getDownloadingCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add((OfflineMapCity) it.next());
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList();
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            arrayList.add((OfflineMapProvince) it.next());
        }
        return arrayList;
    }

    public OfflineMapCity getItemByCityCode(String str) {
        if (str == null || str.equals(com.xiaomi.e.a.f)) {
            return null;
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            OfflineMapCity offlineMapCity = (OfflineMapCity) it.next();
            if (offlineMapCity.getCode().equals(str)) {
                return offlineMapCity;
            }
        }
        it = this.f.iterator();
        while (it.hasNext()) {
            offlineMapCity = (OfflineMapCity) it.next();
            if (offlineMapCity.getCode().equals(str)) {
                return offlineMapCity;
            }
        }
        it = this.d.d.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
            while (it2.hasNext()) {
                offlineMapCity = (OfflineMapCity) it2.next();
                if (offlineMapCity.getCode().equals(str)) {
                    return offlineMapCity;
                }
            }
        }
        return null;
    }

    public OfflineMapCity getItemByCityName(String str) {
        if (str == null || str.equals(com.xiaomi.e.a.f)) {
            return null;
        }
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            OfflineMapCity offlineMapCity = (OfflineMapCity) it.next();
            if (offlineMapCity.getCity().trim().equalsIgnoreCase(str.trim())) {
                return offlineMapCity;
            }
        }
        it = this.f.iterator();
        while (it.hasNext()) {
            offlineMapCity = (OfflineMapCity) it.next();
            if (offlineMapCity.getCity().trim().equalsIgnoreCase(str.trim())) {
                return offlineMapCity;
            }
        }
        it = this.d.d.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
            while (it2.hasNext()) {
                offlineMapCity = (OfflineMapCity) it2.next();
                if (offlineMapCity.getCity().trim().equalsIgnoreCase(str.trim())) {
                    return offlineMapCity;
                }
            }
        }
        return null;
    }

    public OfflineMapProvince getItemByProvinceName(String str) {
        if (str == null || str.equals(com.xiaomi.e.a.f)) {
            return null;
        }
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
            if (offlineMapProvince.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                return offlineMapProvince;
            }
        }
        it = this.g.iterator();
        while (it.hasNext()) {
            offlineMapProvince = (OfflineMapProvince) it.next();
            if (offlineMapProvince.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                return offlineMapProvince;
            }
        }
        it = this.d.d.iterator();
        while (it.hasNext()) {
            offlineMapProvince = (OfflineMapProvince) it.next();
            if (offlineMapProvince.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                return offlineMapProvince;
            }
        }
        return null;
    }

    public ArrayList<OfflineMapCity> getOfflineMapCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList();
        Iterator it = this.d.d.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
            while (it2.hasNext()) {
                OfflineMapCity offlineMapCity = (OfflineMapCity) it2.next();
                Iterator it3 = this.f.iterator();
                while (it3.hasNext()) {
                    OfflineMapCity offlineMapCity2 = (OfflineMapCity) it3.next();
                    if (offlineMapCity.getCity().equalsIgnoreCase(offlineMapCity2.getCity())) {
                        offlineMapCity.setCompleteCode(offlineMapCity2.getcompleteCode());
                        offlineMapCity.setState(offlineMapCity2.getState());
                    }
                }
                it3 = this.h.iterator();
                while (it3.hasNext()) {
                    offlineMapCity2 = (OfflineMapCity) it3.next();
                    if (offlineMapCity.getCity().equalsIgnoreCase(offlineMapCity2.getCity())) {
                        offlineMapCity.setCompleteCode(offlineMapCity2.getcompleteCode());
                        offlineMapCity.setState(offlineMapCity2.getState());
                    }
                }
                arrayList.add(offlineMapCity);
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList();
        Iterator it = this.d.d.iterator();
        while (it.hasNext()) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                OfflineMapProvince offlineMapProvince2 = (OfflineMapProvince) it2.next();
                if (offlineMapProvince.getProvinceName().equalsIgnoreCase(offlineMapProvince2.getProvinceName())) {
                    offlineMapProvince.setCompleteCode(offlineMapProvince2.getcompleteCode());
                    offlineMapProvince.setState(offlineMapProvince2.getState());
                }
            }
            Iterator it3 = this.f.iterator();
            while (it3.hasNext()) {
                OfflineMapCity offlineMapCity = (OfflineMapCity) it3.next();
                Iterator it4 = offlineMapProvince.getCityList().iterator();
                while (it4.hasNext()) {
                    OfflineMapCity offlineMapCity2 = (OfflineMapCity) it4.next();
                    if (offlineMapCity2.getCity().equalsIgnoreCase(offlineMapCity.getCity())) {
                        offlineMapCity2.setCompleteCode(offlineMapCity.getcompleteCode());
                        offlineMapCity2.setState(offlineMapCity2.getState());
                    }
                }
            }
            it2 = this.i.iterator();
            while (it2.hasNext()) {
                offlineMapProvince2 = (OfflineMapProvince) it2.next();
                if (offlineMapProvince.getProvinceName().equalsIgnoreCase(offlineMapProvince2.getProvinceName())) {
                    offlineMapProvince.setCompleteCode(offlineMapProvince2.getcompleteCode());
                    offlineMapProvince.setState(offlineMapProvince2.getState());
                }
            }
            it3 = this.h.iterator();
            while (it3.hasNext()) {
                offlineMapCity = (OfflineMapCity) it3.next();
                it4 = offlineMapProvince.getCityList().iterator();
                while (it4.hasNext()) {
                    offlineMapCity2 = (OfflineMapCity) it4.next();
                    if (offlineMapCity2.getCity().equalsIgnoreCase(offlineMapCity.getCity())) {
                        offlineMapCity2.setCompleteCode(offlineMapCity.getcompleteCode());
                        offlineMapCity2.setState(offlineMapCity.getState());
                    }
                }
            }
            arrayList.add(offlineMapProvince);
        }
        return arrayList;
    }

    protected boolean isStart() {
        return this.mIsStart;
    }

    public void pause() {
        this.mIsStart = false;
        this.d.b(0);
    }

    public boolean remove(String str) {
        if (str.equals(this.k) || str.equals(this.l)) {
            this.mIsStart = false;
            this.d.b(0);
            this.k = com.xiaomi.e.a.f;
            this.l = com.xiaomi.e.a.f;
        }
        return a(str) || b(str);
    }

    public void restart() {
        if (!this.mIsStart) {
            this.d.a(this.d.b.size() - 1);
        }
    }

    protected void setStart(boolean z) {
        this.mIsStart = z;
    }

    public void stop() {
        this.mIsStart = false;
        this.d.c();
    }

    protected void updateAllCity() {
        h hVar = new h(this.j, com.xiaomi.e.a.f);
        hVar.a(this.j);
        List list = (List) hVar.getData();
        this.d.e();
        this.d.a(list);
    }

    public boolean updateOfflineCityByCode(String str) {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode != null && itemByCityCode.getCity() != null) {
            return a(itemByCityCode.getCity(), c);
        }
        throw new AMapException(com.amap.api.services.core.AMapException.ERROR_INVALID_PARAMETER);
    }

    public boolean updateOfflineCityByName(String str) {
        return a(str, c);
    }

    public boolean updateOfflineMapProvinceByName(String str) {
        return a(str, c);
    }
}
