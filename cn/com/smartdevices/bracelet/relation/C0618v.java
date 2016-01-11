package cn.com.smartdevices.bracelet.relation;

class C0618v implements Runnable {
    final /* synthetic */ FriendActivity a;

    C0618v(FriendActivity friendActivity) {
        this.a = friendActivity;
    }

    public void run() {
        this.a.h.notifyDataSetChanged();
        this.a.b();
    }
}
