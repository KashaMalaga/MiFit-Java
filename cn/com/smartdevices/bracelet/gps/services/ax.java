package cn.com.smartdevices.bracelet.gps.services;

final class ax implements C0442t {
    final /* synthetic */ SubGPSSportService a;

    private ax(SubGPSSportService subGPSSportService) {
        this.a = subGPSSportService;
    }

    public void a() {
        if (this.a.h != null && !this.a.h.d) {
            this.a.c.removeMessages(1);
            this.a.c.sendEmptyMessage(1);
        }
    }
}
