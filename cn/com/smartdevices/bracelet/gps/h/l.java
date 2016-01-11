package cn.com.smartdevices.bracelet.gps.h;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;

public class l {
    private l() {
    }

    public static void a(Context context, long j) {
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(j);
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return false;
        }
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamVolume == 0) {
            return true;
        }
        if (audioManager.isWiredHeadsetOn() || audioManager.isBluetoothA2dpOn()) {
            return false;
        }
        return streamVolume < audioManager.getStreamMaxVolume(3) / 2;
    }

    public static void b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(600);
        }
    }
}
