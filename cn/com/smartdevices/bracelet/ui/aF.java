package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.r;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.widget.c;
import cn.com.smartdevices.bracelet.view.DynamicView;
import cn.com.smartdevices.bracelet.weight.P;
import cn.com.smartdevices.bracelet.weight.RecordWeightActivity;
import cn.com.smartdevices.bracelet.weight.WeightGoalSetActivity;

public class aF extends Fragment {
    private DynamicView a;
    private r b;
    private int c;
    private c d;

    private void a(DynamicView dynamicView, r rVar) {
        if (this.c == 1) {
            dynamicView.a(Keeper.readPersonInfoBaseConfig().getDaySportGoalSteps());
            dynamicView.b(rVar.c());
            dynamicView.a(ChartData.a(getActivity(), rVar.d()));
            if (rVar.e() != 0) {
                dynamicView.c(0);
                dynamicView.b(ChartData.a(getActivity(), rVar.e()));
            } else {
                dynamicView.c(4);
            }
            dynamicView.d(rVar.f());
            dynamicView.a(rVar.g());
        } else if (this.c == 16) {
            dynamicView.e(rVar.h());
            dynamicView.f(rVar.i());
            dynamicView.b(rVar.l());
        } else if (this.c == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            dynamicView.a(rVar.b());
            dynamicView.a(rVar.n(), rVar.o(), rVar.p());
            dynamicView.c(rVar.q());
            dynamicView.a(rVar.r(), rVar.v(), rVar.w());
            dynamicView.d(rVar.s());
        }
        C0596r.e("DynamicFragment", "BindData : " + rVar + " , Mode : " + this.c);
    }

    void a() {
        Context activity = getActivity();
        Intent intent;
        if (this.c == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            intent = new Intent(activity, RecordWeightActivity.class);
            P b = this.b.b();
            if (b != null) {
                intent.putExtra(WeightGoalSetActivity.a, b.c);
            } else {
                intent.putExtra(WeightGoalSetActivity.a, -1);
            }
            startActivity(intent);
            C0401a.a(activity, C0401a.gr, C0401a.gt);
        } else if (this.c == 1) {
            intent = new Intent("com.xiaomi.hm.health.action.RUNNING");
            intent.setPackage(getActivity().getPackageName());
            startActivity(intent);
            C0401a.a(activity, C0401a.gr, C0401a.gs);
        }
    }

    public void a(float f) {
        if (this.a != null) {
            this.a.a(f);
        }
    }

    public void a(c cVar) {
        this.d = cVar;
        if (this.a != null) {
            this.a.a(this.d);
        }
    }

    public void a(Boolean bool) {
        if (this.a != null) {
            this.a.a(bool);
        }
    }

    public void a(boolean z) {
        if (this.a != null) {
            a(this.a, this.b);
            if (this.c == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
                this.a.c(true);
            } else {
                this.a.c(z);
            }
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.a.c(true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.c = arguments.getInt(ChartData.KEY_MODE);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View dynamicView = new DynamicView(getActivity());
        this.a = (DynamicView) dynamicView;
        this.a.g(this.c);
        this.b = ChartData.a();
        a(this.a, this.b);
        this.a.a();
        this.a.a(this.d);
        return dynamicView;
    }
}
