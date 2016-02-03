package com.huami.android.zxing;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Vibrator;
import android.util.Log;
import com.huami.android.a.k;
import java.io.Closeable;

final class b implements OnCompletionListener, OnErrorListener, Closeable {
    private static final String a = b.class.getSimpleName();
    private static final float b = 0.1f;
    private static final long c = 200;
    private final Activity d;
    private MediaPlayer e;
    private boolean f;
    private boolean g = true;

    b(Activity activity) {
        this.d = activity;
        this.e = null;
        a();
    }

    private static boolean a(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getRingerMode() == 2;
    }

    private MediaPlayer b(Context context) {
        AssetFileDescriptor openRawResourceFd;
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        try {
            openRawResourceFd = context.getResources().openRawResourceFd(k.beep);
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.setVolume(b, b);
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (Throwable e) {
            Log.w(a, e);
            mediaPlayer.release();
            return null;
        } catch (Throwable th) {
            openRawResourceFd.close();
        }
    }

    synchronized void a() {
        this.f = a(this.d);
        if (this.f && this.e == null) {
            this.d.setVolumeControlStream(3);
            this.e = b(this.d);
        }
    }

    synchronized void b() {
        if (this.f && this.e != null) {
            this.e.start();
        }
        if (this.g) {
            ((Vibrator) this.d.getSystemService("vibrator")).vibrate(c);
        }
    }

    public synchronized void close() {
        if (this.e != null) {
            this.e.release();
            this.e = null;
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.seekTo(0);
    }

    public synchronized boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 100) {
            this.d.finish();
        } else {
            mediaPlayer.release();
            this.e = null;
            a();
        }
        return true;
    }
}
