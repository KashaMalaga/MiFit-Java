package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.j;
import cn.com.smartdevices.bracelet.shoes.sync.b.i;
import cn.com.smartdevices.bracelet.shoes.sync.b.l;
import java.util.ArrayList;
import java.util.List;

class F {
    private static final String a = ("{\"code\": 1, \"message\": \"success\",\"data\":{\"data\": [{\"brand\": \"LN\",\"type\":\"4\",\"summary\":[{\"language\":\"zh_CN\",\"name\":\"\u674e\u5b81\u667a\u80fd\u8dd1\u978b\",\"full_name\":\"\u674e\u5b81\u667a\u80fd\u8dd1\u978b\",\"des\":\"\u4e13\u4e1a\u7a33\u5b9a\u7c7b\u4ea7\u54c1\uff0c\u63d0\u4f9b\u540e\u8ddf\u51cf\u9707\uff0c\u8db3\u5f13\u53ca\u5e2e\u9762\u652f\u6491\uff0c\u5927\u5927\u52a0\u5f3a\u5bf9\u8db3\u90e8\u7684\u4fdd\u62a4\u3002\u51cf\u5c11\u56e0\u540e\u8ddf\u5916\u7ffb\u7684\u8dd1\u6b65\u59ff\u6001\u9020\u6210\u7684\u8db3\u90e8\u53ca\u4e0b\u80a2\u5173\u8282\u7684\u635f\u4f24\u3002\u901a\u8fc7\u534e\u7c73\u667a\u82af\u53ca\u5c0f\u7c73\u8fd0\u52a8APP\u63d0\u4f9b\u6570\u636e\u8bb0\u5f55\u3001\u8dd1\u6b65\u7740\u5730\u65b9\u5f0f\u5206\u6790\u3002\",\"avatar\":\"http://cdn.fds.api.xiaomi.com/huami/sport_liejun.png?GalaxyAccessKeyId=5341713837557&Expires=316790981873000&Signature=oslGJ2n+MOOZcIUb/hVWOP2N9jc=\",\"life\":\"800\",\"link\":\"http://brand.tmall.com/mobilestreet/subject.htm?spm=0.0.0.0.JOLBip&id=7245\",\"image\":\"https://cdn.fds-ssl.api.xiaomi.com/huami/liejun.png?GalaxyAccessKeyId=5341713837557&Expires=316796276117000&Signature=sR3Lq2Eq5teT6faLwJP6rAxw3fE=\"},{\"language\":\"en_US\",\"name\":\"LN Smart\",\"full_name\":\"LN Smart\",\"des\":\"A smart stability running shoe has superior heel cushioning and arch & upper supports to reduce overpronation injury and offer mileage, speed, stride frequency and strike pattern using Huami Smart Module. \",\"avatar\":\"http://cdn.fds.api.xiaomi.com/huami/sport_liejun.png?GalaxyAccessKeyId=5341713837557&Expires=316790981873000&Signature=oslGJ2n+MOOZcIUb/hVWOP2N9jc=\",\"life\":\"800\",\"link\":\"http://brand.tmall.com/mobilestreet/subject.htm?spm=0.0.0.0.JOLBip&id=7245\",\"image\":\"https://cdn.fds-ssl.api.xiaomi.com/huami/liejun.png?GalaxyAccessKeyId=5341713837557&Expires=316796276117000&Signature=sR3Lq2Eq5teT6faLwJP6rAxw3fE=\"},{\"language\":\"zh_TW\",\"name\":\"\u674e\u5be7\u667a\u6167\u8dd1\u978b\",\"full_name\":\"\u674e\u5be7\u667a\u6167\u8dd1\u978b\",\"des\":\"\u5c08\u696d\u7a69\u5b9a\u985e\u7522\u54c1\uff0c\u63d0\u4f9b\u5f8c\u8ddf\u51cf\u9707\uff0c\u8db3\u5f13\u53ca\u5e6b\u9762\u652f\u6490\uff0c\u5927\u5927\u52a0\u5f3a\u5c0d\u8db3\u90e8\u7684\u4fdd\u8b77\u3002\u51cf\u5c11\u56e0\u5f8c\u8ddf\u5916\u7ffb\u7684\u8dd1\u6b65\u59ff\u614b\u9020\u6210\u7684\u8db3\u90e8\u53ca\u4e0b\u80a2\u95dc\u7bc0\u7684\u640d\u50b7\u3002\u901a\u904e\u83ef\u7c73\u667a\u82af\u53ca\u5c0f\u7c73\u904b\u52d5APP\u63d0\u4f9b\u6578\u64da\u8a18\u9304\u3001\u8dd1\u6b65\u8457\u5730\u65b9\u5f0f\u5206\u6790\u3002\",\"avatar\":\"http://cdn.fds.api.xiaomi.com/huami/sport_liejun.png?GalaxyAccessKeyId=5341713837557&Expires=316790981873000&Signature=oslGJ2n+MOOZcIUb/hVWOP2N9jc=\",\"life\":\"800\",\"link\":\"http://brand.tmall.com/mobilestreet/subject.htm?spm=0.0.0.0.JOLBip&id=7245\",\"image\":\"https://cdn.fds-ssl.api.xiaomi.com/huami/liejun.png?GalaxyAccessKeyId=5341713837557&Expires=316796276117000&Signature=sR3Lq2Eq5teT6faLwJP6rAxw3fE=\"}],\"sync_time\": " + (System.currentTimeMillis() / 1000) + "} ]}}");

    private F() {
    }

    private static List<j> a(List<j> list, List<j> list2) {
        List<j> arrayList = new ArrayList(list2.size());
        for (j jVar : list2) {
            Object obj;
            Object obj2 = 1;
            for (j jVar2 : list) {
                if (jVar.equals(jVar2)) {
                    obj2 = null;
                    if (jVar.o != jVar2.o) {
                        arrayList.add(jVar);
                        obj = null;
                        if (obj == null) {
                            arrayList.add(jVar);
                        }
                    }
                    obj = obj2;
                    if (obj == null) {
                        arrayList.add(jVar);
                    }
                }
            }
            obj = obj2;
            if (obj == null) {
                arrayList.add(jVar);
            }
        }
        return arrayList;
    }

    public static boolean a(Context context) {
        return d(context).b();
    }

    private static boolean[] a(Context context, List<j> list) {
        List<j> i = t.i(context);
        List arrayList = new ArrayList(i.size());
        for (j jVar : i) {
            if (!list.contains(jVar)) {
                arrayList.add(jVar);
            }
        }
        i.removeAll(arrayList);
        List a = a((List) i, (List) list);
        boolean b = arrayList.size() > 0 ? t.b(context, arrayList) & 1 : true;
        boolean c = a.size() > 0 ? b & t.c(context, a) : b;
        b = c && a.size() > 0;
        C0596r.e(B.a, "setShoesPartners forceToSync:" + b + ",isSucceeded = " + c);
        arrayList.clear();
        a.clear();
        i.clear();
        list.clear();
        return new boolean[]{c, b};
    }

    public static boolean b(Context context) {
        H c = c(context);
        boolean b = c.b();
        return (c.b() && c.a) ? P.a(context) : b;
    }

    private static H c(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        i iVar = new i(context);
        H h = new H();
        if (iVar.o.isValid()) {
            C0641r.a(iVar, e.a(C0641r.a), new G(h));
        } else {
            h.a(false);
        }
        return h;
    }

    private static H d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        H h = new H();
        l lVar = new l();
        n a = C0642s.a(context, a, lVar);
        boolean c = a.c();
        C0596r.e(B.a, "success: " + a.c() + ",type shoes");
        if (c) {
            boolean[] a2 = a(context, lVar.a());
            h.a = a2[1];
            h.a(a2[0]);
        } else {
            h.a(false);
        }
        if (!c) {
            C0596r.d(B.a, "setShoesPartners isSucceeded:" + c + ",type shoes");
        }
        return h;
    }
}
