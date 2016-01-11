package cn.com.smartdevices.bracelet.shoes.ui;

class C0666w implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ ShoesBindTestActivity b;

    C0666w(ShoesBindTestActivity shoesBindTestActivity, int i) {
        this.b = shoesBindTestActivity;
        this.a = i;
    }

    public void run() {
        if (this.b.w != null) {
            this.b.w.setMessage("\u5347\u7ea7\u8fdb\u5ea6\uff1a" + this.a + "/" + this.b.x);
        }
    }
}
