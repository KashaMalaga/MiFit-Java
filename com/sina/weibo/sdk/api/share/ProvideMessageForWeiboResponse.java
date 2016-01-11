package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMessage;

public class ProvideMessageForWeiboResponse extends BaseResponse {
    public WeiboMessage message;

    public ProvideMessageForWeiboResponse(Bundle bundle) {
        fromBundle(bundle);
    }

    final boolean check(Context context, VersionCheckHandler versionCheckHandler) {
        return this.message == null ? false : (versionCheckHandler == null || versionCheckHandler.checkResponse(context, this.reqPackageName, this.message)) ? this.message.checkArgs() : false;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.message = new WeiboMessage(bundle);
    }

    public int getType() {
        return 2;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putAll(this.message.toBundle(bundle));
    }
}
