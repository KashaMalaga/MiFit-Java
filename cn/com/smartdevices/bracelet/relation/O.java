package cn.com.smartdevices.bracelet.relation;

class O implements Runnable {
    final /* synthetic */ MessageActivity a;

    O(MessageActivity messageActivity) {
        this.a = messageActivity;
    }

    public void run() {
        this.a.a(false);
        this.a.f.notifyDataSetChanged();
    }
}
