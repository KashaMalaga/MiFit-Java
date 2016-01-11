package com.xiaomi.hm.health.bt.e;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import cn.com.smartdevices.bracelet.C0596r;
import java.util.List;

class e extends ScanCallback {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public void onBatchScanResults(List<ScanResult> list) {
        super.onBatchScanResults(list);
        C0596r.e("BleScanCenter", "onBatchScanResults:" + list.size());
    }

    public void onScanFailed(int i) {
        super.onScanFailed(i);
        C0596r.e("BleScanCenter", "onScanFailed:" + i);
    }

    public void onScanResult(int i, ScanResult scanResult) {
        C0596r.e("BleScanCenter", "onScanResult callbackType:" + i + ",result:" + scanResult);
        this.a.a(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
    }
}
