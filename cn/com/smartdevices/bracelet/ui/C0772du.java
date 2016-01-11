package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.D;
import cn.com.smartdevices.bracelet.Keeper;

class C0772du implements Runnable {
    final /* synthetic */ SearchSingleBraceletActivity a;

    C0772du(SearchSingleBraceletActivity searchSingleBraceletActivity) {
        this.a = searchSingleBraceletActivity;
    }

    public void run() {
        D.a(Keeper.readBraceletBtInfo().b);
        this.a.setResult(-1);
        this.a.finish();
    }
}
