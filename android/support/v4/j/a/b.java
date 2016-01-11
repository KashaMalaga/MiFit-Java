package android.support.v4.j.a;

import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;
import java.util.Locale;
import java.util.Set;

class b {
    public static final String a = "embeddedTts";
    public static final String b = "networkTts";

    b() {
    }

    static Set<String> a(TextToSpeech textToSpeech, Locale locale) {
        return VERSION.SDK_INT >= 15 ? textToSpeech.getFeatures(locale) : null;
    }

    static void a(TextToSpeech textToSpeech, e eVar) {
        if (VERSION.SDK_INT >= 15) {
            textToSpeech.setOnUtteranceProgressListener(new c(eVar));
        } else {
            textToSpeech.setOnUtteranceCompletedListener(new d(eVar));
        }
    }
}
