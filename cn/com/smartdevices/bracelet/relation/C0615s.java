package cn.com.smartdevices.bracelet.relation;

class C0615s implements Runnable {
    final /* synthetic */ FriendActivity a;

    C0615s(FriendActivity friendActivity) {
        this.a = friendActivity;
    }

    public void run() {
        this.a.i.setVisibility(8);
        this.a.g.setVisibility(0);
        this.a.h.notifyDataSetChanged();
        this.a.b();
    }
}
