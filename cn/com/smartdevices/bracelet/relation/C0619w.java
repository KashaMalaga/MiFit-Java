package cn.com.smartdevices.bracelet.relation;

class C0619w implements Runnable {
    final /* synthetic */ FriendActivity a;

    C0619w(FriendActivity friendActivity) {
        this.a = friendActivity;
    }

    public void run() {
        this.a.h.notifyDataSetChanged();
    }
}
