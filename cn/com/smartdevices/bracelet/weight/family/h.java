package cn.com.smartdevices.bracelet.weight.family;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0544h;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventUserInfoUpdate;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.ui.C0752da;
import cn.com.smartdevices.bracelet.ui.C0754dc;
import cn.com.smartdevices.bracelet.ui.C0755dd;
import cn.com.smartdevices.bracelet.ui.C0758dg;
import cn.com.smartdevices.bracelet.ui.C0760di;
import cn.com.smartdevices.bracelet.ui.C0812l;
import cn.com.smartdevices.bracelet.ui.CropImageActivity;
import cn.com.smartdevices.bracelet.ui.dC;
import cn.com.smartdevices.bracelet.ui.fq;
import cn.com.smartdevices.bracelet.ui.p;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightGoalSetActivity;
import cn.com.smartdevices.bracelet.weight.aA;
import com.huami.android.view.c;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.hm.health.R;
import de.greenrobot.event.EventBus;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public class h extends p implements OnClickListener {
    public static final int b = 17;
    public static final int c = 18;
    public static final int d = 273;
    public static final String e = "EXTRA_USER_INFO_UID";
    private static final String f = "UserInfoFragment";
    private UserInfo g = null;
    private Birthday h;
    private TextView i;
    private View j;
    private TextView k;
    private View l;
    private TextView m;
    private View n;
    private TextView o;
    private View p;
    private View q;
    private ImageButton r;
    private TextView s;
    private ImageButton t;
    private TextView u;
    private Bitmap v;
    private TextView w;
    private LinearLayout x;
    private TextView y;

    public static Fragment a(int i) {
        Fragment hVar = new h();
        Bundle bundle = new Bundle();
        if (i >= 0) {
            bundle.putInt(e, i);
        }
        hVar.setArguments(bundle);
        return hVar;
    }

    private void a(View view) {
        this.i = (TextView) view.findViewById(R.id.info_gender_value);
        this.j = view.findViewById(R.id.info_gender);
        this.j.setOnClickListener(this);
        this.k = (TextView) view.findViewById(R.id.info_height_value);
        this.l = view.findViewById(R.id.info_height);
        this.l.setOnClickListener(this);
        this.m = (TextView) view.findViewById(R.id.info_weight_value);
        this.n = view.findViewById(R.id.info_weight);
        this.n.setOnClickListener(this);
        this.o = (TextView) view.findViewById(R.id.info_age_value);
        this.p = view.findViewById(R.id.info_age_area);
        this.p.setOnClickListener(this);
        this.x = (LinearLayout) view.findViewById(R.id.device_set_goal);
        this.x.setOnClickListener(this);
        this.y = (TextView) view.findViewById(R.id.device_set_goal_text);
        view.findViewById(R.id.del_member).setOnClickListener(this);
        this.q = view.findViewById(R.id.member_info_user_info_area);
        c();
    }

    private void c() {
        this.r = (ImageButton) this.q.findViewById(R.id.member_page_icon);
        this.r.setOnClickListener(this);
        this.s = (TextView) this.q.findViewById(R.id.member_page_nickname);
        this.s.setOnClickListener(this);
        this.t = (ImageButton) this.q.findViewById(R.id.edit_member_name);
        this.t.setOnClickListener(this);
        this.u = (TextView) this.q.findViewById(R.id.member_page_figure);
        this.w = (TextView) this.q.findViewById(R.id.member_page_bmi);
    }

    private void d() {
        if (getActivity() == null) {
            C0596r.a(f, "getActivity is null");
            return;
        }
        this.i.setText(this.g.gender == 1 ? getString(R.string.male) : getString(R.string.female));
        this.k.setText(e());
        if (this.g.weight > 0.0f && this.g.height > 0) {
            this.m.setText(aA.b(this.g.weight, Keeper.readPersonInfo().miliConfig.weightUnit) + aA.a(getActivity().getApplicationContext(), Keeper.readPersonInfo().miliConfig.weightUnit));
            float a = aA.a(this.g.height, Birthday.fromStr(this.g.birthday).getAge(), this.g.weight);
            this.w.setText(aA.b(a));
            this.u.setText(aA.a(getActivity(), a, Birthday.fromStr(this.g.birthday).getAge(), this.g.gender));
        }
        this.h = Birthday.fromStr(this.g.birthday);
        if (this.h != null) {
            this.o.setText(this.h.toString());
        }
        Utils.b(this.g, this.r);
        this.s.setText(this.g.name);
        if (this.g.targetWeight > 0.0f) {
            this.y.setText(((int) aA.b(this.g.targetWeight, Keeper.readPersonInfo().miliConfig.weightUnit)) + aA.a(getActivity().getApplicationContext(), Keeper.readPersonInfo().miliConfig.weightUnit));
        } else {
            this.y.setText(getString(R.string.not_set));
        }
    }

    private String e() {
        int i = this.g.height;
        int a = Utils.a(i);
        if (Keeper.readPersonInfo().getUnit() == 0) {
            return i + getString(R.string.cm);
        }
        String quantityString = getResources().getQuantityString(R.plurals.numberFoot, a / 12, new Object[]{Integer.valueOf(a / 12)});
        return quantityString + " " + getResources().getQuantityString(R.plurals.numberInch, a % 12, new Object[]{Integer.valueOf(a % 12)});
    }

    private void f() {
        DialogFragment fqVar = new fq();
        Bundle bundle = new Bundle();
        bundle.putString(C0812l.a, getString(R.string.del_family_member));
        bundle.putString(C0812l.b, getString(R.string.del_family_member_content));
        bundle.putString(C0812l.d, getString(R.string.delete));
        bundle.putString(C0812l.c, getString(R.string.cancel));
        fqVar.setArguments(bundle);
        fqVar.setOpClickListener(new i(this));
        c.showPanel(getActivity(), fqVar);
    }

    private boolean g() {
        J.a().b(this.g);
        C0596r.e(f, "after deleteInfoMark " + this.g.toString());
        return J.a().a(getActivity().getApplicationContext());
    }

    @SuppressLint({"NewApi"})
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == b && intent != null) {
            C0596r.e(f, "receive select img fragment with uid " + this.g.uid + " uid name " + this.g.name + " in crop img");
            String stringExtra = intent.getStringExtra(CropImageActivity.a);
            Bitmap a = C0544h.a().a(Uri.fromFile(new File(stringExtra)).toString());
            if (a != null) {
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    this.g.avatarSource = byteArrayOutputStream.toByteArray();
                    this.g.avatarUrl = null;
                    C0596r.e(f, "save avatar source from select pic" + this.g.avatarSource);
                    a.recycle();
                    C0596r.e(f, "onActivityResult requst_code =" + i + " task photo post evnetbus");
                    EventBus.getDefault().post(new EventUserInfoUpdate(this.g));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            C0596r.e(f, "the crop image file path is " + stringExtra);
        } else if (i == c && intent != null && intent.getExtras() != null) {
            C0596r.e(f, "receive select img fragment with uid " + this.g.uid + " uid name " + this.g.name + " in take photo");
            this.v = (Bitmap) intent.getExtras().get(b.b);
            if (this.v != null) {
                try {
                    OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    this.v.compress(CompressFormat.PNG, 100, byteArrayOutputStream2);
                    this.g.avatarSource = byteArrayOutputStream2.toByteArray();
                    C0596r.e(f, "save avatar source from take photo" + this.g.avatarSource);
                    this.v.recycle();
                    this.v = null;
                    C0596r.e(f, "onActivityResult requst_code =" + i + " task photo post evnetbus");
                    EventBus.getDefault().post(new EventUserInfoUpdate(this.g));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else if (d != i) {
        } else {
            if (WeightGoalSetActivity.c == i2) {
                EventBus.getDefault().post(new EventUserInfoUpdate(this.g));
            } else if (WeightGoalSetActivity.d == i2) {
                float floatExtra = intent.getFloatExtra(WeightGoalSetActivity.b, 0.0f);
                this.g.targetWeight = aA.a(floatExtra, Keeper.readPersonInfo().miliConfig.weightUnit);
                EventBus.getDefault().post(new EventUserInfoUpdate(this.g));
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_gender:
                C0401a.a(getActivity(), C0401a.fu);
                c.showPanel(getActivity(), C0754dc.a(this.g.uid).getClass());
                return;
            case R.id.info_age_area:
                C0401a.a(getActivity(), C0401a.fw);
                c.showPanel(getActivity(), C0752da.a(this.g.uid).getClass());
                return;
            case R.id.info_height:
                C0401a.a(getActivity(), C0401a.fv);
                c.showPanel(getActivity(), C0755dd.a(this.g.uid).getClass());
                return;
            case R.id.info_weight:
                c.showPanel(getActivity(), C0760di.a(this.g.uid).getClass());
                return;
            case R.id.device_set_goal:
                Intent intent = new Intent(getActivity(), WeightGoalSetActivity.class);
                intent.putExtra(WeightGoalSetActivity.a, this.g.uid);
                getActivity().startActivityForResult(intent, d);
                C0401a.a(getActivity(), C0401a.fy);
                return;
            case R.id.del_member:
                C0401a.a(getActivity(), C0401a.fq);
                f();
                return;
            case R.id.member_page_icon:
                C0401a.a(getActivity(), C0401a.fx);
                C0596r.e(f, "open select img fragment with uid " + this.g.uid + " uid name " + this.g.name);
                c.showPanel(getActivity(), dC.class);
                return;
            case R.id.member_page_nickname:
            case R.id.edit_member_name:
                C0401a.a(getActivity(), C0401a.ft);
                c.showPanel(getActivity(), C0758dg.a(this.g.uid).getClass());
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = J.a().a(getArguments().getInt(e));
        C0596r.e(f, "receive userinfo =" + this.g);
        EventBus.getDefault().register(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.member_info_fragment, null);
        a(inflate);
        d();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.g != null) {
            C0596r.e(f, "onDestroyView here save info " + this.g.toString());
        }
        J.a().d(this.g);
    }

    public void onEvent(EventUserInfoUpdate eventUserInfoUpdate) {
        if (eventUserInfoUpdate != null && eventUserInfoUpdate.getInfo() != null) {
            this.g = eventUserInfoUpdate.getInfo();
            C0596r.e(f, "update ... ui " + this.g);
            J.a().d(this.g);
            d();
        }
    }

    public void onPause() {
        super.onPause();
        C0401a.a(C0401a.aW);
    }

    public void onStop() {
        super.onStop();
        C0401a.b(C0401a.aW);
    }
}
