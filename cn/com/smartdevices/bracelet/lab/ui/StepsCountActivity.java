package cn.com.smartdevices.bracelet.lab.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.DynamicPieChartView;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.datasource.RtStep;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;
import cn.com.smartdevices.bracelet.shoes.sync.C0639p;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.tencent.connect.common.Constants;
import com.xiaomi.account.openauth.h;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.bt.d.e;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import de.greenrobot.event.EventBus;
import java.util.LinkedList;
import java.util.Timer;

public class StepsCountActivity extends SystemBarTintActivity implements e {
    public static Handler a = null;
    private RelativeLayout A;
    private SlidingUpPanelLayout B;
    private int C;
    private Button b;
    private Button c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private DynamicPieChartView h;
    private A i = null;
    private boolean j;
    private int k;
    private int l;
    private LinkedList<Integer> m;
    private LinkedList<Long> n;
    private CountDownTimer o = null;
    private int p = 30;
    private Timer q = null;
    private final int r = 4115;
    private final int s = 4112;
    private View t;
    private View u;
    private View v = null;
    private C0639p w;
    private ae x = null;
    private int y;
    private LinearLayout z;

    private void a() {
        this.b.setClickable(false);
        b(getResources().getColor(R.color.bg_color_steps_gray));
        d();
    }

    private void b() {
        C0596r.e("RtStep", "handler init");
        a = new am(this);
    }

    private void b(int i) {
        this.v.setBackgroundColor(i);
        applyStatusBarTint(i);
    }

    static /* synthetic */ int c(StepsCountActivity stepsCountActivity, int i) {
        int i2 = stepsCountActivity.y + i;
        stepsCountActivity.y = i2;
        return i2;
    }

    private void c() {
        this.e.setText(R.string.lab_factory_average_pace_frequency);
        if (this.k - this.l < 5) {
            this.g.setText(Integer.toString(0));
        } else {
            this.g.setText(Integer.toString((int) ((float) (((this.k - this.l) * 60) / this.p))));
        }
        RtStep.enableRtSteps(this, 3, false, this);
        this.m.clear();
        this.n.clear();
        this.j = false;
        this.b.setText(R.string.lab_factory_start);
        this.t.setVisibility(4);
        this.u.setVisibility(0);
    }

    private void c(int i) {
        if (this.m.size() >= 15) {
            this.m.remove();
            this.n.remove();
            this.m.add(Integer.valueOf(i));
            this.n.add(Long.valueOf(System.currentTimeMillis()));
            return;
        }
        this.m.add(Integer.valueOf(i));
        this.n.add(Long.valueOf(System.currentTimeMillis()));
    }

    private void d() {
        Bundle bundle = new Bundle();
        bundle.putString(ae.a, getString(R.string.confirm));
        bundle.putString(ae.b, getString(R.string.lab_factory_sport_monitor_shoes_offline_notice) + getString(R.string.lab_factory_pace_frequency_test));
        bundle.putString(ae.c, getString(R.string.lab_factory_shoes_not_connected));
        if (this.x == null) {
            this.x = ae.a(this, ae.class, bundle, new ao(this));
        }
    }

    private void e() {
        runOnUiThread(new ap(this));
    }

    private float f() {
        if (this.m.size() == 1 || this.m.size() == 0) {
            return 0.0f;
        }
        if (System.currentTimeMillis() - ((Long) this.n.getLast()).longValue() > 3500 && this.k - ((Integer) this.m.getLast()).intValue() < 1) {
            return 0.0f;
        }
        long longValue = ((Long) this.n.getFirst()).longValue();
        long longValue2 = ((Long) this.n.getLast()).longValue();
        float intValue = longValue2 - longValue != 0 ? (float) (((long) (((((Integer) this.m.getLast()).intValue() - ((Integer) this.m.getFirst()).intValue()) * 60) * h.E)) / (longValue2 - longValue)) : 0.0f;
        int i = (int) intValue;
        if (this.i != null) {
            intValue = this.i.a(i);
        }
        return intValue;
    }

    private void g() {
        this.q = new Timer();
        this.q.schedule(new aq(this), 0, 30000);
    }

    private void on_start_button_click_count() {
        if (this.j) {
            a.removeMessages(4112);
            this.h.c(0.0f);
            this.o.cancel();
            c();
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 4112;
        if (a != null) {
            a.sendMessage(obtain);
        }
        this.j = true;
        this.b.setText(R.string.lab_factory_restart);
        try {
            this.p = Integer.valueOf(this.f.getText().toString()).intValue();
        } catch (Exception e) {
            this.p = 30;
        }
        start();
    }

    private void start() {
        this.e.setText(R.string.lab_factory_rt_pace_frequency);
        this.u.setVisibility(4);
        this.t.setVisibility(0);
        this.d.setText(String.valueOf(this.p));
        this.h.a((float) ((this.p * h.E) + 250));
        this.y = 0;
        this.m.clear();
        this.n.clear();
        RtStep.enableRtSteps(this, 3, true, this);
        this.i = new A();
        this.i.a();
        this.l = this.k;
        this.o = new an(this, (long) ((this.p * h.E) + 250), 1000);
        this.o.start();
    }

    public void a(int i) {
        C0596r.e("RtStep", "steps: " + i);
        Message message = new Message();
        message.arg1 = i;
        message.what = 4115;
        if (a != null) {
            a.sendMessage(message);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        g();
        setContentView((int) R.layout.activity_lab_steps_count_test);
        b();
        C0596r.e("RtStep", "init page");
        this.B = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        this.B.setEnableDragViewTouchEvents(true);
        this.v = findViewById(R.id.lab_main_sport);
        this.z = (LinearLayout) findViewById(R.id.disconnect_sport);
        this.A = (RelativeLayout) findViewById(R.id.personal_best_sport_record);
        this.b = (Button) findViewById(R.id.start_button_count);
        this.b.setOnClickListener(new aj(this));
        this.c = (Button) findViewById(R.id.ok_button);
        this.c.setOnClickListener(new ak(this));
        this.d = (TextView) findViewById(R.id.textView3);
        this.e = (TextView) findViewById(R.id.title_back);
        this.e.setText(R.string.lab_factory_rt_pace_frequency);
        this.f = (TextView) findViewById(R.id.edit_text);
        this.f.setOnFocusChangeListener(new al(this));
        this.g = (TextView) findViewById(R.id.sport_rating);
        this.h = (DynamicPieChartView) findViewById(R.id.sport_progress_state);
        this.h.a((int) ChartData.e);
        this.g.setText(Constants.VIA_RESULT_SUCCESS);
        this.t = findViewById(R.id.countdown_container);
        this.u = findViewById(R.id.time_container);
        this.j = false;
        this.m = new LinkedList();
        this.n = new LinkedList();
        this.m.clear();
        this.n.clear();
        start();
        this.o.cancel();
        c();
        this.m.clear();
        this.n.clear();
        this.w = new C0639p(this, false, false);
    }

    public void onDestroy() {
        RtStep.enableRtSteps(this, 3, false, this);
        C0596r.e("RtStep", "destory page");
        if (this.w != null) {
            this.w.a();
        }
        this.q.cancel();
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        if (hwConnStatus.b() == c.SHOES && hwConnStatus.a() != 6) {
            a();
        }
    }

    protected void onResume() {
        super.onResume();
        if (!this.w.e()) {
            a();
        }
    }
}
