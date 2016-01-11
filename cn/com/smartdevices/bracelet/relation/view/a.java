package cn.com.smartdevices.bracelet.relation.view;

class a implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ CareButton b;

    a(CareButton careButton, int i) {
        this.b = careButton;
        this.a = i;
    }

    public void run() {
        this.b.a(this.a - 1);
    }
}
