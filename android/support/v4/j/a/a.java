package android.support.v4.j.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;

class a {
    private static final String a = "android.support.v4.speech.tts";

    a() {
    }

    static TextToSpeech a(Context context, OnInitListener onInitListener, String str) {
        if (VERSION.SDK_INT >= 14) {
            return new TextToSpeech(context, onInitListener, str);
        }
        if (str == null) {
            return new TextToSpeech(context, onInitListener);
        }
        Log.w(a, "Can't specify tts engine on this device");
        return new TextToSpeech(context, onInitListener);
    }
}
