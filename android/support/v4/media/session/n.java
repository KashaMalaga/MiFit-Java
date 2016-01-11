package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.session.MediaController.PlaybackInfo;
import com.xiaomi.hm.health.t;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class n {
    private static final int a = 4;
    private static final int b = 6;
    private static final int c = 7;

    private static int a(AudioAttributes audioAttributes) {
        if ((audioAttributes.getFlags() & 1) == 1) {
            return c;
        }
        if ((audioAttributes.getFlags() & a) == a) {
            return b;
        }
        switch (audioAttributes.getUsage()) {
            case l.a /*1*/:
            case a.aW /*11*/:
            case a.be /*12*/:
            case t.WeightView_wv_tips /*14*/:
                return 3;
            case a.k /*2*/:
                return 0;
            case a.l /*3*/:
                return 8;
            case a /*4*/:
                return a;
            case a.X /*5*/:
            case c /*7*/:
            case a.ba /*8*/:
            case a.bo /*9*/:
            case a.bd /*10*/:
                return 5;
            case b /*6*/:
                return 2;
            case t.WeightView_wv_bmi_size /*13*/:
                return 1;
            default:
                return 3;
        }
    }

    public static int a(Object obj) {
        return ((PlaybackInfo) obj).getPlaybackType();
    }

    public static AudioAttributes b(Object obj) {
        return ((PlaybackInfo) obj).getAudioAttributes();
    }

    public static int c(Object obj) {
        return a(b(obj));
    }

    public static int d(Object obj) {
        return ((PlaybackInfo) obj).getVolumeControl();
    }

    public static int e(Object obj) {
        return ((PlaybackInfo) obj).getMaxVolume();
    }

    public static int f(Object obj) {
        return ((PlaybackInfo) obj).getCurrentVolume();
    }
}
