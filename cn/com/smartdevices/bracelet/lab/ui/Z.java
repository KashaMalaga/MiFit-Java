package cn.com.smartdevices.bracelet.lab.ui;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Looper;
import cn.com.smartdevices.bracelet.C0596r;

final class Z extends Thread {
    public Y a;
    final /* synthetic */ V b;

    public Z(V v, Y y) {
        this.b = v;
        this.a = y;
    }

    public void run() {
        Looper.prepare();
        this.b.g = Looper.myLooper();
        synchronized (this) {
            try {
                if (this.b.h == null) {
                    AudioManager audioManager = (AudioManager) this.a.b.getSystemService("audio");
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioStreamType(this.a.e);
                    mediaPlayer.setDataSource(this.a.b, this.a.c);
                    mediaPlayer.setLooping(this.a.d);
                    mediaPlayer.setVolume(this.a.f, this.a.f);
                    mediaPlayer.prepare();
                    if (!(this.a.c == null || this.a.c.getEncodedPath() == null || this.a.c.getEncodedPath().length() <= 0)) {
                        if (this.a.d) {
                            audioManager.requestAudioFocus(null, this.a.e, 1);
                        } else {
                            audioManager.requestAudioFocus(null, this.a.e, 3);
                        }
                    }
                    mediaPlayer.setOnCompletionListener(this.b);
                    this.b.h = mediaPlayer;
                    this.b.n = audioManager;
                }
                this.b.h.start();
            } catch (Exception e) {
                C0596r.a(this.b.i, e.getMessage());
            }
            notify();
        }
        Looper.loop();
    }
}
