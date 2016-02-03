package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.C0056bn;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import de.greenrobot.event.EventBus;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kankan.wheel.widget.a;

public class AlarmActivity extends SystemBarTintActivity implements OnClickListener {
    public static final int a = 3;
    public static final String b = "ref_alarm_index";
    public static final String c = "hour";
    public static final String d = "_id";
    public static final String e = "minutes";
    public static final String f = "daysofweek";
    public static final String g = "alarmtime";
    public static final String h = "enabled";
    public static final String i = "vibrate";
    public static final String j = "message";
    public static final String k = "alert";
    private static final int l = 257;
    private static final int m = 1;
    private static final String n = "AlarmActivity";
    private static final String o = "ALARM_ONCE_TRIGGLED";
    private static final String w = "content://com.android.deskclock/alarm";
    private Button A;
    private List<Switch> B;
    private List<ImageView> C;
    private boolean D;
    private Activity p;
    private Handler q;
    private PersonInfo r;
    private ListView s;
    private C0778e t;
    private ArrayList<AlarmClockItem> u = new ArrayList();
    private int v;
    private BroadcastReceiver x;
    private View y;
    private View z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.ContentResolver r11) {
        /*
        r10 = this;
        r9 = 5;
        r8 = 3;
        r6 = 1;
        r7 = 0;
        r3 = 0;
        r0 = "alarm_alert";
        r0 = android.provider.Settings.System.getString(r11, r0);
        r1 = "next_alarm_formatted";
        r1 = android.provider.Settings.System.getString(r11, r1);
        r2 = "AlarmActivity";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "system alarm = ";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r4 = ", nextAlarm=";
        r0 = r0.append(r4);
        r0 = r0.append(r1);
        r0 = r0.toString();
        cn.com.smartdevices.bracelet.C0596r.e(r2, r0);
        r0 = "content://com.android.deskclock/alarm";
        r1 = android.net.Uri.parse(r0);
        r0 = r10.p;
        r0 = r0.getContentResolver();
        r2 = new java.lang.String[r9];
        r4 = "_id";
        r2[r7] = r4;
        r4 = "hour";
        r2[r6] = r4;
        r4 = 2;
        r5 = "minutes";
        r2[r4] = r5;
        r4 = "daysofweek";
        r2[r8] = r4;
        r4 = 4;
        r5 = "enabled";
        r2[r4] = r5;
        r4 = r3;
        r5 = r3;
        r2 = r0.query(r1, r2, r3, r4, r5);
        if (r2 == 0) goto L_0x010a;
    L_0x005f:
        r0 = r3;
    L_0x0060:
        r1 = r2.moveToNext();	 Catch:{ Exception -> 0x0103 }
        if (r1 == 0) goto L_0x010d;
    L_0x0066:
        r1 = "AlarmActivity";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0103 }
        r3.<init>();	 Catch:{ Exception -> 0x0103 }
        r4 = "id: ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0103 }
        r4 = 0;
        r4 = r2.getInt(r4);	 Catch:{ Exception -> 0x0103 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0103 }
        r4 = "\t hour: ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0103 }
        r4 = "hour";
        r4 = r2.getColumnIndex(r4);	 Catch:{ Exception -> 0x0103 }
        r4 = r2.getInt(r4);	 Catch:{ Exception -> 0x0103 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0103 }
        r4 = ", min=";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0103 }
        r4 = "minutes";
        r4 = r2.getColumnIndex(r4);	 Catch:{ Exception -> 0x0103 }
        r4 = r2.getInt(r4);	 Catch:{ Exception -> 0x0103 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0103 }
        r4 = ", enabled=";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0103 }
        r4 = "enabled";
        r4 = r2.getColumnIndex(r4);	 Catch:{ Exception -> 0x0103 }
        r4 = r2.getInt(r4);	 Catch:{ Exception -> 0x0103 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0103 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0103 }
        cn.com.smartdevices.bracelet.C0596r.e(r1, r3);	 Catch:{ Exception -> 0x0103 }
        r1 = "hour";
        r1 = r2.getColumnIndex(r1);	 Catch:{ Exception -> 0x0103 }
        r3 = r2.getInt(r1);	 Catch:{ Exception -> 0x0103 }
        r1 = "minutes";
        r1 = r2.getColumnIndex(r1);	 Catch:{ Exception -> 0x0103 }
        r4 = r2.getInt(r1);	 Catch:{ Exception -> 0x0103 }
        r1 = "enabled";
        r1 = r2.getColumnIndex(r1);	 Catch:{ Exception -> 0x0103 }
        r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 != r6) goto L_0x010b;
    L_0x00df:
        r1 = r6;
    L_0x00e0:
        if (r1 == 0) goto L_0x0060;
    L_0x00e2:
        if (r3 < r9) goto L_0x0060;
    L_0x00e4:
        r1 = 10;
        if (r3 > r1) goto L_0x0060;
    L_0x00e8:
        if (r0 != 0) goto L_0x00f0;
    L_0x00ea:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0103 }
        r1 = 3;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0103 }
    L_0x00f0:
        r1 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x0103 }
        r5 = 11;
        r1.set(r5, r3);	 Catch:{ Exception -> 0x0103 }
        r3 = 12;
        r1.set(r3, r4);	 Catch:{ Exception -> 0x0103 }
        r0.add(r1);	 Catch:{ Exception -> 0x0103 }
        goto L_0x0060;
    L_0x0103:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0137 }
        r2.close();
    L_0x010a:
        return;
    L_0x010b:
        r1 = r7;
        goto L_0x00e0;
    L_0x010d:
        if (r0 == 0) goto L_0x0131;
    L_0x010f:
        r1 = r0.size();	 Catch:{ Exception -> 0x0103 }
        if (r1 <= 0) goto L_0x0131;
    L_0x0115:
        r1 = "AlarmActivity";
        r3 = cn.com.smartdevices.bracelet.Utils.c();	 Catch:{ Exception -> 0x0103 }
        r3 = r3.b(r0);	 Catch:{ Exception -> 0x0103 }
        cn.com.smartdevices.bracelet.C0596r.e(r1, r3);	 Catch:{ Exception -> 0x0103 }
        r1 = cn.com.smartdevices.bracelet.Utils.c();	 Catch:{ Exception -> 0x0103 }
        r0 = r1.b(r0);	 Catch:{ Exception -> 0x0103 }
        cn.com.smartdevices.bracelet.Keeper.keepMorningAlarms(r0);	 Catch:{ Exception -> 0x0103 }
    L_0x012d:
        r2.close();
        goto L_0x010a;
    L_0x0131:
        r0 = "";
        cn.com.smartdevices.bracelet.Keeper.keepMorningAlarms(r0);	 Catch:{ Exception -> 0x0103 }
        goto L_0x012d;
    L_0x0137:
        r0 = move-exception;
        r2.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.ui.AlarmActivity.a(android.content.ContentResolver):void");
    }

    public static void a(AlarmClockItem alarmClockItem, Context context) {
        Calendar instance = Calendar.getInstance();
        instance.set(instance.get(m), instance.get(2), instance.get(5), alarmClockItem.getHour(), alarmClockItem.getMinute(), 0);
        Calendar instance2 = Calendar.getInstance();
        if (alarmClockItem.getDays() == AlarmClockItem.ALARM_ONCE && instance.before(instance2)) {
            instance.add(6, m);
            C0596r.e(n, "after add one day :" + instance);
        }
        alarmClockItem.setCalendar(instance);
        alarmClockItem.setUpdate(true);
        if (alarmClockItem.getDays() == AlarmClockItem.ALARM_ONCE) {
            ((AlarmManager) context.getSystemService(C0056bn.f)).set(0, instance.getTimeInMillis(), PendingIntent.getBroadcast(context, instance.hashCode(), new Intent(o), 134217728));
        }
    }

    private void a(boolean z) {
        float scaleY;
        float scaleX;
        float alpha;
        Animator ofFloat;
        Animator ofFloat2;
        Animator ofFloat3;
        AnimatorSet animatorSet;
        if (z) {
            for (Switch switchR : this.B) {
                scaleY = switchR.getScaleY();
                scaleX = switchR.getScaleX();
                alpha = switchR.getAlpha();
                ofFloat = ObjectAnimator.ofFloat(switchR, "scaleY", new float[]{scaleY, 0.0f});
                ofFloat2 = ObjectAnimator.ofFloat(switchR, "scaleX", new float[]{scaleX, 0.0f});
                ofFloat3 = ObjectAnimator.ofFloat(switchR, "alpha", new float[]{alpha, 0.0f});
                animatorSet = new AnimatorSet();
                animatorSet.setDuration((long) 250);
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
                animatorSet.start();
            }
            for (ImageView imageView : this.C) {
                scaleY = imageView.getScaleY();
                scaleX = imageView.getScaleX();
                alpha = imageView.getAlpha();
                ofFloat = ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{scaleY, 1.0f});
                ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{scaleX, 1.0f});
                ofFloat3 = ObjectAnimator.ofFloat(imageView, "alpha", new float[]{alpha, 1.0f});
                animatorSet = new AnimatorSet();
                animatorSet.setDuration((long) 250);
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
                animatorSet.start();
            }
            return;
        }
        for (Switch switchR2 : this.B) {
            scaleY = switchR2.getScaleY();
            scaleX = switchR2.getScaleX();
            alpha = switchR2.getAlpha();
            ofFloat = ObjectAnimator.ofFloat(switchR2, "scaleY", new float[]{scaleY, 1.0f});
            ofFloat2 = ObjectAnimator.ofFloat(switchR2, "scaleX", new float[]{scaleX, 1.0f});
            ofFloat3 = ObjectAnimator.ofFloat(switchR2, "alpha", new float[]{alpha, 1.0f});
            animatorSet = new AnimatorSet();
            animatorSet.setDuration((long) 250);
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
            animatorSet.start();
        }
        for (ImageView imageView2 : this.C) {
            scaleY = imageView2.getScaleY();
            scaleX = imageView2.getScaleX();
            alpha = imageView2.getAlpha();
            ofFloat = ObjectAnimator.ofFloat(imageView2, "scaleY", new float[]{scaleY, 0.0f});
            ofFloat2 = ObjectAnimator.ofFloat(imageView2, "scaleX", new float[]{scaleX, 0.0f});
            ofFloat3 = ObjectAnimator.ofFloat(imageView2, "alpha", new float[]{alpha, 0.0f});
            animatorSet = new AnimatorSet();
            animatorSet.setDuration((long) 250);
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
            animatorSet.start();
        }
    }

    private void b() {
        this.y.setVisibility(8);
        this.A.setVisibility(0);
        this.z.setBackgroundResource(R.color.bg_color_blue);
    }

    private void c() {
        this.y.setVisibility(0);
        this.A.setVisibility(8);
        this.z.setBackgroundResource(R.color.bg_color_grey);
    }

    private void d() {
        this.x = new C0697b(this);
        this.p.registerReceiver(this.x, new IntentFilter(o));
    }

    private void e() {
        this.s = (ListView) findViewById(R.id.alarm_clock_lv);
        this.t = new C0778e(this);
        this.s.setAdapter(this.t);
        this.y = findViewById(R.id.mask_view);
        this.z = findViewById(R.id.home_back_area);
        this.A = (Button) findViewById(R.id.alarm_edit);
        this.A.setOnClickListener(this);
    }

    private void f() {
        try {
            i();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.u = this.r.getAlarmClockItems();
    }

    private void g() {
        this.q.removeMessages(m);
        this.q.sendMessageDelayed(this.q.obtainMessage(m), 2000);
    }

    private void h() {
        HashMap hashMap = new HashMap();
        try {
            String encode = URLEncoder.encode(Utils.c().b(this.u), a.bO);
            hashMap.put(f.W, encode);
            C0596r.e(n, "alarm encoded str = " + encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Utils.a(this.p.getApplicationContext(), this.r, hashMap, new C0724c(this));
    }

    private void i() {
        ContentResolver contentResolver = this.p.getContentResolver();
        contentResolver.registerContentObserver(Uri.parse(w), true, new C0751d(this, null, contentResolver));
        a(contentResolver);
    }

    public void a() {
        this.u = this.r.getAlarmClockItems();
        Calendar instance = Calendar.getInstance();
        Iterator it = this.u.iterator();
        while (it.hasNext()) {
            AlarmClockItem alarmClockItem = (AlarmClockItem) it.next();
            if (alarmClockItem.getDays() == AlarmClockItem.ALARM_ONCE && alarmClockItem.getCalendar().before(instance)) {
                alarmClockItem.setEnabled(false);
            }
        }
        Keeper.keepPersonInfo(this.r);
        this.t.notifyDataSetChanged();
    }

    protected boolean isExceptForMiNote() {
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == l && i2 == -1) {
            Object stringExtra = intent.getStringExtra(a.al);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.u.set(this.v, AlarmClockItem.fromJson(stringExtra));
                this.t.notifyDataSetChanged();
                this.r.setNeedSyncServer(2);
                Keeper.keepPersonInfo(this.r);
                g();
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alarm_edit:
                if (getString(R.string.edit).equals(this.A.getText())) {
                    this.A.setText(getString(R.string.alarm_edit_complete));
                    a(true);
                    return;
                }
                this.A.setText(getString(R.string.edit));
                a(false);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        setContentView((int) R.layout.alarm_activity);
        this.p = this;
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.q = new C0670a(this);
        this.r = Keeper.readPersonInfo();
        f();
        e();
        d();
        if (!com.xiaomi.hm.health.bt.bleservice.a.c()) {
            c();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        this.p.unregisterReceiver(this.x);
        Iterator it = this.u.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            int i3;
            AlarmClockItem alarmClockItem = (AlarmClockItem) it.next();
            if (!alarmClockItem.isEnabled()) {
                i3 = i;
                i = i2;
            } else if (alarmClockItem.isSmartWakeup()) {
                i3 = i + m;
                i = i2;
            } else {
                i3 = i;
                i = i2 + m;
            }
            i2 = i;
            i = i3;
        }
        String str = "Normal:" + i2 + ", Smart:" + i;
        C0596r.e(n, "alarm result " + str);
        C0401a.a(this.p, C0401a.ea, str);
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        if (hwConnStatus.k()) {
            b();
            applyStatusBarTintAuto();
            return;
        }
        c();
        applyStatusBarTintAuto();
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.G);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        a();
        this.D = DateFormat.is24HourFormat(this);
        this.A.setText(getString(R.string.edit));
        if (this.t != null) {
            this.t.notifyDataSetChanged();
        }
        C0401a.a(C0401a.G);
        C0401a.a((Activity) this);
    }
}
