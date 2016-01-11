package cn.com.smartdevices.bracelet.gps.g;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class e {
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 2;
    final /* synthetic */ a a;
    private Context e = null;
    private volatile Looper f;
    private volatile g g;
    private MediaPlayer h = null;
    private ConcurrentHashMap<String, d> i = null;
    private volatile boolean j = false;
    private AudioManager k = null;
    private String l = null;

    public e(a aVar, Context context) {
        this.a = aVar;
        this.e = context;
        this.i = new ConcurrentHashMap();
        HandlerThread handlerThread = new HandlerThread("PlayTask");
        handlerThread.start();
        this.f = handlerThread.getLooper();
        this.g = new g(this, this.f);
    }

    private MediaPlayer a(c cVar, String str) {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(cVar.d);
            mediaPlayer.setDataSource(cVar.a, cVar.b);
            mediaPlayer.setLooping(cVar.c);
            mediaPlayer.setVolume(cVar.e, cVar.e);
            mediaPlayer.prepare();
            AudioManager audioManager = (AudioManager) cVar.a.getSystemService("audio");
            if (!(cVar.b == null || cVar.b.getEncodedPath() == null || cVar.b.getEncodedPath().length() <= 0)) {
                if (cVar.c) {
                    audioManager.requestAudioFocus(null, cVar.d, c);
                } else {
                    audioManager.requestAudioFocus(null, cVar.d, 3);
                }
            }
            this.k = audioManager;
            this.l = str;
            Object fVar = new f(this);
            mediaPlayer.setOnCompletionListener(fVar);
            mediaPlayer.setOnErrorListener(fVar);
            mediaPlayer.start();
            this.j = true;
            return mediaPlayer;
        } catch (Exception e) {
            C0596r.d("RunPlayer", e.getMessage());
            return null;
        }
    }

    private void a(Message message) {
        switch (message.what) {
            case b /*0*/:
                if (message.obj instanceof d) {
                    d dVar = (d) message.obj;
                    if (!a(this.e, dVar.b, dVar.a)) {
                        this.i.remove(dVar.a);
                        return;
                    }
                    return;
                }
                return;
            case c /*1*/:
                d();
                return;
            case d /*2*/:
                if (this.j) {
                    this.j = false;
                    this.h.stop();
                    this.h.release();
                    this.h = null;
                    this.k.abandonAudioFocus(null);
                    this.k = null;
                }
                if (this.i.size() > 0) {
                    this.i.clear();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private boolean a(Context context, List<String> list, String str) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        File a = this.a.a.a(context, list);
        if (a == null) {
            C0596r.d("RunPlayer", "playSound failed to create file cmdId: " + str);
            return false;
        }
        String absolutePath = a.getAbsolutePath();
        c cVar = new c();
        cVar.a = context;
        cVar.b = Uri.parse(absolutePath);
        cVar.c = false;
        cVar.d = 3;
        cVar.e = 1.0f;
        MediaPlayer a2 = a(cVar, str);
        this.h = a2;
        if (a2 == null) {
            C0596r.d("RunPlayer", "playSound failed to create player cmdId: " + str + ",srcFilePath: " + absolutePath);
        }
        return a2 != null;
    }

    private void c() {
        if (this.g != null && this.i.size() > 0) {
            Iterator it = this.i.values().iterator();
            if (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar != null) {
                    Message obtainMessage = this.g.obtainMessage();
                    obtainMessage.what = b;
                    obtainMessage.obj = dVar;
                    this.g.sendMessage(obtainMessage);
                    return;
                }
                return;
            }
            cn.com.smartdevices.bracelet.gps.h.e.a("RunPlayer", "Delayed cachedMsgMap !hasNext");
        }
    }

    private void d() {
        if (this.l != null) {
            this.i.remove(this.l);
        }
        if (this.k != null) {
            this.k.abandonAudioFocus(null);
            this.k = null;
        }
        if (this.h != null) {
            this.h.stop();
            this.h.release();
            this.h = null;
        }
        c();
    }

    public void a() {
        if (this.i != null) {
            this.i.clear();
        }
        if (this.h != null) {
            try {
                if (this.h.isPlaying()) {
                    this.h.stop();
                }
                this.h.release();
            } catch (Exception e) {
                C0596r.a("Run", e.getMessage());
            }
            this.h = null;
        }
        if (this.g != null) {
            this.g.removeMessages(d);
            this.g.removeMessages(3);
            this.g.removeMessages(c);
            this.g.removeMessages(4);
        }
        if (this.f != null) {
            this.f.quit();
        }
    }

    public void a(d dVar) {
        Message obtainMessage = this.g.obtainMessage();
        obtainMessage.what = b;
        obtainMessage.obj = dVar;
        this.i.put(dVar.a, dVar);
        if (this.i.size() == c) {
            this.g.sendMessage(obtainMessage);
        } else {
            C0596r.d("RunPlayer", "Execute delayed to play type = " + dVar.c + ",cachedSize = " + this.i.size());
        }
    }

    public void b() {
        Message obtainMessage = this.g.obtainMessage();
        obtainMessage.what = d;
        this.g.sendMessage(obtainMessage);
    }
}
