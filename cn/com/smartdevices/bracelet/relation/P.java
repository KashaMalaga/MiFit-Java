package cn.com.smartdevices.bracelet.relation;

class P implements Runnable {
    final /* synthetic */ MessageActivity a;

    P(MessageActivity messageActivity) {
        this.a = messageActivity;
    }

    public void run() {
        this.a.a(false);
        this.a.f.notifyDataSetChanged();
    }
}
