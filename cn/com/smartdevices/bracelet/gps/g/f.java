package cn.com.smartdevices.bracelet.gps.g;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.h.e;

final class f implements OnCompletionListener, OnErrorListener {
    final /* synthetic */ e a;

    public f(e eVar) {
        this.a = eVar;
    }

    private void a() {
        Message obtainMessage = this.a.g.obtainMessage();
        obtainMessage.what = 1;
        this.a.g.sendMessage(obtainMessage);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.a.j = false;
        a();
        e.a("RunPlayer", "PlayListener onCompletion");
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.a.j = false;
        a();
        C0596r.d("RunPlayer", "PlayListener onError what: " + i + ",extra: " + i2);
        return false;
    }
}
