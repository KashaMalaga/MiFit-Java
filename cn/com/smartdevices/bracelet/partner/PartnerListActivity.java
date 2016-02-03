package cn.com.smartdevices.bracelet.partner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventServiceListLoad;
import cn.com.smartdevices.bracelet.eventbus.EventServiceStateChanged;
import cn.com.smartdevices.bracelet.ui.BindGoogleFitActivity;
import cn.com.smartdevices.bracelet.ui.BindQQHealthActivity;
import cn.com.smartdevices.bracelet.ui.BindWeixinActivity;
import cn.com.smartdevices.bracelet.ui.BindWeixinActivityNew;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.weibo.BindHealthActivity;
import com.huami.android.widget.share.m;
import com.xiaomi.hm.health.R;
import de.greenrobot.event.EventBus;

public class PartnerListActivity extends SystemBarTintActivity implements OnChildClickListener, OnGroupClickListener {
    private PartnerListAdapter mListAdapter = null;
    private PartnerDataManager mServiceManager;
    ExpandableListView mServiceView;

    private void setTitleBack() {
        TextView textView = (TextView) findViewById(R.id.home_back);
        textView.setText(getString(R.string.action_pop_service));
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PartnerListActivity.this.finish();
            }
        });
    }

    public void expandAllGroup() {
        int groupCount = this.mListAdapter.getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            this.mServiceView.expandGroup(i);
        }
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        int intValue = this.mListAdapter.getGroup(i).intValue();
        Partner child = this.mListAdapter.getChild(i, i2);
        if (child == null) {
            return false;
        }
        Intent intent = null;
        if (!TextUtils.isEmpty(child.id)) {
            C0401a.a(getApplicationContext(), C0409b.bG + child.id);
        }
        if (2 == intValue) {
            intent = WebActivity.buildIntent(this, child);
        } else if (m.c.equals(child.id)) {
            intent = new Intent(this, BindQQHealthActivity.class);
        } else if (m.a.equals(child.id)) {
            intent = Utils.p(this) ? new Intent(this, BindWeixinActivityNew.class) : new Intent(this, BindWeixinActivity.class);
        } else if (Partner.HEALTH_LINK_ID.equals(child.id)) {
            intent = new Intent(this, HealthLinkActivity.class);
        } else if (Partner.WEIBO_HEALTH_ID.equals(child.id)) {
            BindHealthActivity.a((Context) this, 3);
            return true;
        } else if (Partner.GOOGLE_FIT_ID.equals(child.id)) {
            intent = new Intent(this, BindGoogleFitActivity.class);
        }
        if (intent != null) {
            startActivity(intent);
        }
        return intent != null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_service_list);
        ((TextView) findViewById(R.id.home_back)).setText(R.string.action_pop_service);
        setTitleBack();
        this.mServiceManager = new PartnerDataManager(this);
        this.mListAdapter = new PartnerListAdapter(this, this.mServiceManager.getLocalServiceList());
        this.mServiceView = (ExpandableListView) findViewById(R.id.service_list);
        this.mServiceView.setAdapter(this.mListAdapter);
        this.mServiceView.setOnChildClickListener(this);
        this.mServiceView.setOnGroupClickListener(this);
        expandAllGroup();
        EventBus.getDefault().register(this);
        this.mServiceManager.loadAvailableServiceList(false);
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(EventServiceListLoad eventServiceListLoad) {
        if (eventServiceListLoad != null && eventServiceListLoad.success) {
            this.mListAdapter.addPartners(2, eventServiceListLoad.partners);
            this.mListAdapter.notifyDataSetChanged();
            expandAllGroup();
        }
    }

    public void onEvent(EventServiceStateChanged eventServiceStateChanged) {
        if (eventServiceStateChanged.success) {
            int i = 0;
            if (eventServiceStateChanged.action == 0) {
                i = 1;
            }
            this.mListAdapter.updatePartnerItem(2, eventServiceStateChanged.thirdAppId, i, eventServiceStateChanged.url);
            this.mListAdapter.notifyDataSetChanged();
        }
    }

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return true;
    }

    public void onPause() {
        super.onResume();
        C0401a.b(C0401a.ay);
        C0401a.b((Activity) this);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.ay);
        C0401a.a((Activity) this);
    }
}
