package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

public class ProvideMultiMessageForWeiboResponse extends BaseResponse {
    public WeiboMultiMessage multiMessage;

    public ProvideMultiMessageForWeiboResponse(Bundle bundle) {
        fromBundle(bundle);
    }

    final boolean check(Context context, VersionCheckHandler versionCheckHandler) {
        return this.multiMessage == null ? false : (versionCheckHandler == null || versionCheckHandler.checkResponse(context, this.reqPackageName, this.multiMessage)) ? this.multiMessage.checkArgs() : false;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.multiMessage = new WeiboMultiMessage(bundle);
    }

    public int getType() {
        return 2;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putAll(this.multiMessage.toBundle(bundle));
    }
}
