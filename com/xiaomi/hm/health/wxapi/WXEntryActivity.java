package com.xiaomi.hm.health.wxapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ui.BaseActivity;
import com.huami.android.view.b;
import com.huami.android.widget.share.m;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WXEntryActivity extends BaseActivity implements IWXAPIEventHandler {
    private IWXAPI a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = WXAPIFactory.createWXAPI(this, m.j, false);
        this.a.handleIntent(getIntent(), this);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.a.handleIntent(intent, this);
    }

    public void onReq(BaseReq baseReq) {
        switch (baseReq.getType()) {
        }
    }

    public void onResp(BaseResp baseResp) {
        if (!(baseResp.errCode == 0 || baseResp.errCode == -2)) {
            b.a((Context) this, baseResp.errStr + "|" + baseResp.errCode, 1);
            C0596r.b("WXEntry", baseResp.errStr + "|" + baseResp.errCode);
        }
        finish();
    }
}
