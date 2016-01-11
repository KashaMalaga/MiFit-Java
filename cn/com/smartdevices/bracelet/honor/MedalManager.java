package cn.com.smartdevices.bracelet.honor;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.honor.a.a;
import cn.com.smartdevices.bracelet.honor.a.b;
import cn.com.smartdevices.bracelet.honor.a.c;
import cn.com.smartdevices.bracelet.honor.a.d;
import cn.com.smartdevices.bracelet.honor.a.e;
import cn.com.smartdevices.bracelet.honor.a.f;
import cn.com.smartdevices.bracelet.honor.a.g;
import cn.com.smartdevices.bracelet.honor.a.h;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.c.a.C0993k;
import com.c.a.G;
import de.greenrobot.event.EventBus;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

public class MedalManager {
    public static final boolean a = false;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final String f = "medal.json";
    public static final String g = "medal_config_cache.json";
    public static final String h = "com.xiaomi.hm.health.MEDAL_UPLOAD_SUMMARY_ACTION";
    private static final String i = "MedalManager";
    private EventBus j;
    private ExecutorService k;
    private Context l;
    private List<a> m;
    private List<a> n;
    private Map<Integer, Map<Integer, List<String>>> o;
    private C0993k p;
    private ConcurrentLinkedQueue<d> q;
    private ConcurrentLinkedQueue<String> r;
    private int s;

    public class InnerService extends IntentService {
        public static final String a = "command";
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        private MedalManager f = MedalManager.a();
        private Context g;

        public InnerService() {
            super("HonorService");
        }

        public void onDestroy() {
            super.onDestroy();
        }

        protected void onHandleIntent(Intent intent) {
            this.g = getApplicationContext();
            switch (intent.getIntExtra(a, -1)) {
                case b /*1*/:
                    C0596r.e(MedalManager.i, "onHandleIntent --> onInit & onHandle");
                    this.f.c(this.g);
                    this.f.b(this.g);
                    return;
                case c /*2*/:
                    C0596r.e(MedalManager.i, "onHandleIntent --> onHandle");
                    this.f.b(this.g);
                    return;
                case d /*3*/:
                    C0596r.e(MedalManager.i, "onHandleIntent --> onUpdate & onHandle");
                    this.f.d(this.g);
                    this.f.b(this.g);
                    return;
                case e /*4*/:
                    C0596r.e(MedalManager.i, "onHandleIntent --> onSync");
                    this.f.f(this.g);
                    return;
                default:
                    return;
            }
        }
    }

    public class SummaryReceiver extends BroadcastReceiver {
        private MedalManager a = MedalManager.a();

        public void onReceive(Context context, Intent intent) {
        }
    }

    public class WifiConnectionReceiver extends BroadcastReceiver {
        private MedalManager a;

        public void onReceive(Context context, Intent intent) {
        }
    }

    private MedalManager() {
        this.j = null;
        this.q = null;
        this.r = null;
        this.s = b;
    }

    public static MedalManager a() {
        return C.a;
    }

    private a a(int i, int i2, String str) {
        a aVar = new a();
        aVar.a = new b(i, i2, str);
        aVar.b = new c(i, (long) i2, str);
        return aVar;
    }

    private Integer a(long j) {
        String valueOf = String.valueOf(j);
        return valueOf.indexOf(String.valueOf(ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE)) != -1 ? Integer.valueOf(ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE) : valueOf.indexOf(String.valueOf(ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD)) != -1 ? Integer.valueOf(ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD) : valueOf.indexOf(String.valueOf(ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE)) != -1 ? Integer.valueOf(ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE) : valueOf.indexOf(String.valueOf(d.e)) != -1 ? Integer.valueOf(d.e) : Integer.valueOf(0);
    }

    private void a(Context context, int i) {
        Intent intent = new Intent(context, InnerService.class);
        intent.putExtra(InnerService.a, i);
        context.startService(intent);
    }

    private void a(Context context, int i, d dVar) {
        Map map = (Map) this.o.get(Integer.valueOf(i));
        if (map != null) {
            long j;
            int i2;
            Integer valueOf;
            if (i == ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE) {
                Integer valueOf2;
                h hVar = (h) dVar;
                if (map.containsKey(Integer.valueOf(O.e))) {
                    j = hVar.h;
                    for (String parseInt : (List) map.get(Integer.valueOf(O.e))) {
                        valueOf2 = Integer.valueOf(Integer.parseInt(parseInt));
                        if (j >= ((long) valueOf2.intValue())) {
                            a(context, a((int) b, (int) O.e, String.valueOf(valueOf2)));
                        }
                    }
                }
                if (map.containsKey(Integer.valueOf(O.f))) {
                    j = (long) hVar.i;
                    for (String parseInt2 : (List) map.get(Integer.valueOf(O.f))) {
                        valueOf2 = Integer.valueOf(Integer.parseInt(parseInt2));
                        if (j >= ((long) valueOf2.intValue())) {
                            a(context, a((int) b, (int) O.f, String.valueOf(valueOf2)));
                        }
                    }
                }
                if (map.containsKey(Integer.valueOf(O.g))) {
                    j = (long) hVar.l;
                    for (String parseInt22 : (List) map.get(Integer.valueOf(O.g))) {
                        valueOf2 = Integer.valueOf(Integer.parseInt(parseInt22));
                        if (j >= ((long) valueOf2.intValue())) {
                            a(context, a((int) b, (int) O.g, String.valueOf(valueOf2)));
                        }
                    }
                }
                if (map.containsKey(Integer.valueOf(O.h))) {
                    ((List) map.get(Integer.valueOf(O.h))).iterator();
                    if (((long) hVar.k) == 1) {
                        a(context, a((int) b, (int) O.h, null));
                    }
                }
            }
            if (i == ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD) {
                g gVar = (g) dVar;
                if (map.containsKey(Integer.valueOf(O.i))) {
                    i2 = gVar.j;
                    for (String parseInt3 : (List) map.get(Integer.valueOf(O.i))) {
                        valueOf = Integer.valueOf(Integer.parseInt(parseInt3));
                        if (i2 >= valueOf.intValue()) {
                            a(context, a((int) b, (int) O.i, String.valueOf(valueOf)));
                        }
                    }
                }
            }
            if (i == ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE) {
                e eVar = (e) dVar;
                if (map.containsKey(Integer.valueOf(O.j)) && eVar.i >= 50) {
                    a(context, a((int) b, (int) O.j, null));
                }
                if (map.containsKey(Integer.valueOf(O.k))) {
                    j = eVar.h;
                    for (String parseInt222 : (List) map.get(Integer.valueOf(O.k))) {
                        Long valueOf3 = Long.valueOf(Long.parseLong(parseInt222));
                        if (j >= valueOf3.longValue()) {
                            a(context, a((int) b, (int) O.k, String.valueOf(valueOf3)));
                        }
                    }
                }
                if (map.containsKey(Integer.valueOf(O.l))) {
                    i2 = eVar.i;
                    for (String parseInt32 : (List) map.get(Integer.valueOf(O.l))) {
                        valueOf = Integer.valueOf(Integer.parseInt(parseInt32));
                        if (i2 >= valueOf.intValue()) {
                            a(context, a((int) b, (int) O.l, String.valueOf(valueOf)));
                        }
                    }
                }
            }
            if (i == d.e) {
                f fVar = (f) dVar;
                if (map.containsKey(Integer.valueOf(O.m))) {
                    int i3 = fVar.h;
                    for (String parseInt4 : (List) map.get(Integer.valueOf(O.m))) {
                        Integer valueOf4 = Integer.valueOf(Integer.parseInt(parseInt4));
                        if (i3 >= valueOf4.intValue()) {
                            a(context, a((int) b, (int) O.m, String.valueOf(valueOf4)));
                        }
                    }
                }
            }
        }
    }

    private void a(Context context, a aVar) {
        C0596r.e(i, "addMedal:" + aVar);
        if (this.m != null && this.n != null && aVar.b != null && this.o != null) {
            int i;
            List list;
            if (this.m == null || this.m.contains(aVar)) {
                i = 0;
            } else {
                this.m.add(aVar);
                i = b;
            }
            if (this.n != null && this.n.contains(aVar)) {
                this.n.remove(aVar);
            }
            long j = aVar.b.e;
            int intValue = a(j).intValue();
            String str = aVar.b.f;
            if (this.o.containsKey(Integer.valueOf(intValue))) {
                Map map = (Map) this.o.get(Integer.valueOf(intValue));
                if (map != null) {
                    list = (List) map.get(Long.valueOf(j));
                    if (list != null && list.size() > 0) {
                        list.remove(str);
                    }
                }
            }
            C0545a.a(context, this.m);
            C0545a.b(context, this.n);
            C0545a.a(context, this.o);
            if (i != 0) {
                C0596r.e(i, "Get medal notify:" + aVar);
                Intent intent = new Intent(context, MedalDetailActivity.class);
                intent.addFlags(268435456);
                intent.putExtra(MedalDetailActivity.a, aVar);
                context.startActivity(intent);
                list = C0545a.h(context);
                if (list == null) {
                    list = new ArrayList();
                }
                c cVar = aVar.b;
                cVar.g = b;
                cVar.h = System.currentTimeMillis() / 1000;
                list.add(cVar);
                C0545a.c(context, list);
                e(context);
            }
        }
    }

    private void a(Context context, Map<Integer, Map<Integer, List<String>>> map, List<a> list, List<a> list2) {
        if (map == null || list == null || list2 == null) {
            throw new IllegalArgumentException("Medal params is null");
        }
        if (!map.isEmpty()) {
            map.clear();
        }
        if (!list.isEmpty()) {
            list.clear();
        }
        if (!list2.isEmpty()) {
            list2.clear();
        }
        Message message = new Message();
        Set g = g(context);
        D.a(context, a, new t(this, message, context));
        if (message.obj != null) {
            Type type = new u(this).getType();
            try {
                List<b> list3 = (List) this.p.a((String) message.obj, type);
                D.b(context, a, new v(this, message, context));
                if (message.obj != null) {
                    try {
                        List list4 = (List) this.p.a((String) message.obj, new w(this).getType());
                        if (list3 != null && list4 != null) {
                            for (b bVar : list3) {
                                if (g.contains(Integer.valueOf(bVar.d))) {
                                    int indexOf = list4.indexOf(new c(bVar.c, (long) bVar.d, bVar.e));
                                    if (indexOf != -1) {
                                        c cVar = (c) list4.get(indexOf);
                                        a aVar = new a();
                                        aVar.a = bVar;
                                        if (cVar.g == b) {
                                            aVar.b = cVar;
                                            list.add(aVar);
                                        }
                                    } else if (bVar.c == b) {
                                        a aVar2 = new a();
                                        aVar2.a = bVar;
                                        c cVar2 = new c(bVar.c, (long) bVar.d, bVar.e);
                                        cVar2.g = c;
                                        aVar2.b = cVar2;
                                        list2.add(aVar2);
                                        String str = bVar.e;
                                        int i = bVar.d;
                                        int intValue = a((long) i).intValue();
                                        if (map.containsKey(Integer.valueOf(intValue))) {
                                            Map map2 = (Map) map.get(Integer.valueOf(intValue));
                                            if (map2.containsKey(Integer.valueOf(i))) {
                                                ((List) map2.get(Integer.valueOf(i))).add(str);
                                            } else {
                                                List arrayList = new ArrayList();
                                                arrayList.add(str);
                                                map2.put(Integer.valueOf(i), arrayList);
                                            }
                                        } else {
                                            Map hashMap = new HashMap();
                                            List arrayList2 = new ArrayList();
                                            arrayList2.add(str);
                                            hashMap.put(Integer.valueOf(i), arrayList2);
                                            map.put(Integer.valueOf(intValue), hashMap);
                                        }
                                    }
                                }
                            }
                            C0545a.a(context, (Map) map);
                            C0545a.a(context, (List) list);
                            C0545a.b(context, list2);
                        }
                    } catch (G e) {
                        e.printStackTrace();
                    }
                }
            } catch (G e2) {
                e2.printStackTrace();
            }
        }
    }

    private boolean b(long j) {
        Integer valueOf = Integer.valueOf(Integer.parseInt(new SimpleDateFormat("HH").format(new Date(j))));
        return (valueOf.intValue() > 23 || valueOf.intValue() <= 17) ? a : true;
    }

    @SuppressLint({"UseSparseArrays"})
    private void c(Context context) {
        C0596r.e(i, "onInit");
        this.s = b;
        this.o = C0545a.a(context);
        this.m = C0545a.b(context);
        this.n = C0545a.c(context);
        if (this.o == null || ((this.o != null && this.o.isEmpty()) || this.m == null || ((this.m != null && this.m.isEmpty()) || this.n == null || (this.n != null && this.n.isEmpty())))) {
            this.o = new HashMap();
            this.m = new ArrayList();
            this.n = new ArrayList();
            a(context, this.o, this.m, this.n);
        }
        if (this.o == null || (this.o != null && this.o.isEmpty())) {
            this.s = e;
            C0596r.e(i, "Disable STATE");
            return;
        }
        C0596r.e(i, "Started STATE");
        this.s = d;
        this.k.execute(new x(this, context));
    }

    private void d(Context context) {
        this.s = c;
        C0596r.e(i, "onUpdate state:UPDATE_STATE");
        this.o = C0545a.a(context);
        this.m = C0545a.b(context);
        this.n = C0545a.c(context);
        this.s = d;
        C0596r.e(i, "onUpdate state:STARTED_STATE");
    }

    private void e(Context context) {
        a(context, (int) e);
    }

    private void f(Context context) {
        String j = C0545a.j(context);
        if (j == null) {
            C0596r.e(i, "Unsynchronized data");
            return;
        }
        this.r.add(j);
        C0596r.e(i, "onSync:" + j);
        this.k.execute(new y(this, context));
    }

    private Set<Integer> g(Context context) {
        Set<Integer> set;
        Exception exception;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().getAssets().open(f));
            char[] cArr = new char[C0113o.j];
            StringBuilder stringBuilder = new StringBuilder();
            int read;
            do {
                read = inputStreamReader.read(cArr, 0, cArr.length);
                if (read > 0) {
                    stringBuilder.append(cArr, 0, read);
                    continue;
                }
            } while (read > 0);
            if (stringBuilder.length() > 0) {
                HashSet hashSet = new HashSet();
                try {
                    String stringBuilder2 = stringBuilder.toString();
                    C0596r.e(i, "supportConfig:" + stringBuilder2);
                    set = (Set) this.p.a(stringBuilder2, new B(this).getType());
                } catch (Exception e) {
                    exception = e;
                    Object obj = hashSet;
                    exception.printStackTrace();
                    return set;
                }
            }
            set = null;
            try {
                inputStreamReader.close();
            } catch (Exception e2) {
                exception = e2;
                exception.printStackTrace();
                return set;
            }
        } catch (Exception e3) {
            Exception exception2 = e3;
            set = null;
            exception = exception2;
            exception.printStackTrace();
            return set;
        }
        return set;
    }

    public void a(Context context) {
    }

    public void a(d dVar) {
    }

    public void b() {
    }

    public void b(Context context) {
        if (this.q == null || this.q.isEmpty()) {
            C0596r.e(i, "onHandle-- MedalQueue --isEmpty");
            return;
        }
        C0596r.e(i, "onHandle START");
        int size = this.q.size();
        for (int i = 0; i < size; i += b) {
            d dVar = (d) this.q.poll();
            int i2 = dVar.a;
            C0596r.e(i, "Medal queue peek:" + dVar);
            long j;
            long j2;
            boolean a;
            boolean b;
            switch (i2) {
                case ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE /*101*/:
                    C0596r.e(i, "onHandle STEP_MOUDLE");
                    dVar = (h) dVar;
                    d d = C0545a.d(context);
                    i2 = dVar.i >= dVar.j ? b : 0;
                    if (d != null) {
                        j = dVar.f;
                        j2 = d.f;
                        a = P.a(j, j2);
                        b = P.b(j, j2);
                        if ((i2 != 0 && a && d.k == 0) || b) {
                            d.l += b;
                            d.k = b;
                        } else {
                            d.l = 0;
                            d.k = 0;
                        }
                        d.h = dVar.h;
                        d.i = dVar.i;
                        d.j = dVar.j;
                        d.f = dVar.f;
                        C0545a.a(context, (h) d);
                        a(context, (int) ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE, d);
                        break;
                    }
                    C0545a.a(context, (h) dVar);
                    if (i2 == 0) {
                        break;
                    }
                    dVar.l += b;
                    dVar.k = b;
                    a(context, (int) ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE, dVar);
                    break;
                    break;
                case ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD /*102*/:
                    C0596r.e(i, "onHandle SLEEP_MOUDLE");
                    dVar = (g) dVar;
                    d e = C0545a.e(context);
                    boolean b2 = b(dVar.h);
                    if (e != null) {
                        j = dVar.f;
                        j2 = e.f;
                        a = P.a(j, j2);
                        b = P.b(j, j2);
                        if ((b2 && a && e.i == 0) || b) {
                            e.j += b;
                            e.i = b;
                        } else {
                            e.j = 0;
                            e.i = 0;
                        }
                        e.f = dVar.f;
                        e.h = dVar.h;
                        C0545a.a(context, (g) e);
                        a(context, (int) ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, e);
                        break;
                    }
                    C0545a.a(context, (g) dVar);
                    if (!b2) {
                        break;
                    }
                    dVar.j += b;
                    dVar.i = b;
                    a(context, (int) ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, dVar);
                    break;
                    break;
                case ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE /*103*/:
                    C0596r.e(i, "onHandle RUN_MOUDLE");
                    a(context, (int) ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE, (e) dVar);
                    break;
                case d.e /*104*/:
                    C0596r.e(i, "onHandle SHARE_MOUDLE");
                    a(context, (int) d.e, (f) dVar);
                    break;
                default:
                    break;
            }
        }
        C0596r.e(i, "onHandle END");
    }

    public void onEvent(d dVar) {
        a(dVar);
    }
}
