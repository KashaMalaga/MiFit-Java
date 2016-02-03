package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.chart.DynamicShareChartView;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.account.openauth.h;
import com.xiaomi.hm.health.R;
import java.util.HashMap;
import kankan.wheel.widget.a;

public class ActiveShareDataView extends FrameLayout {
    private DynamicShareChartView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;

    public ActiveShareDataView(Context context) {
        this(context, null, 0);
    }

    public ActiveShareDataView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActiveShareDataView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflate(context, R.layout.view_active_share_data, this);
        this.a = (DynamicShareChartView) findViewById(R.id.share_chart);
        this.b = (TextView) findViewById(R.id.active_step_value);
        this.c = (TextView) findViewById(R.id.active_step_distance_value);
        this.d = (TextView) findViewById(R.id.active_step_distance_unit);
        this.e = (TextView) findViewById(R.id.active_step_calorie_value);
    }

    private HashMap<Integer, Integer> a() {
        HashMap<Integer, Integer> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(1), Integer.valueOf(h.E));
        hashMap.put(Integer.valueOf(2), Integer.valueOf(a.bZ));
        hashMap.put(Integer.valueOf(5), Integer.valueOf(3000));
        hashMap.put(Integer.valueOf(7), Integer.valueOf(4000));
        hashMap.put(Integer.valueOf(10), Integer.valueOf(com.f.a.b.d.a.a));
        hashMap.put(Integer.valueOf(13), Integer.valueOf(6000));
        hashMap.put(Integer.valueOf(14), Integer.valueOf(7000));
        return hashMap;
    }

    public static String[] a(Context context, int i) {
        String[] strArr = new String[2];
        float f = (float) i;
        if (i >= h.E) {
            strArr[0] = String.valueOf(((float) Math.round((f / 1000.0f) * CropOverlayView.a)) / CropOverlayView.a);
            strArr[1] = context.getString(R.string.unit_kilometer);
        } else {
            strArr[0] = String.valueOf(i);
            strArr[1] = context.getString(R.string.unit_meter);
        }
        return strArr;
    }

    public void a(int i) {
        this.b.setText(String.valueOf(i));
    }

    public void a(HashMap<Integer, Integer> hashMap) {
        this.a.a((HashMap) hashMap);
    }

    public void b(int i) {
        String[] a = a(getContext(), i);
        this.c.setText(a[0]);
        this.d.setText(a[1]);
    }

    public void c(int i) {
        this.e.setText(String.valueOf(i));
    }
}
