package android.support.v4.media;

import android.media.AudioManager.OnAudioFocusChangeListener;

class p implements OnAudioFocusChangeListener {
    final /* synthetic */ l a;

    p(l lVar) {
        this.a = lVar;
    }

    public void onAudioFocusChange(int i) {
        this.a.d.a(i);
    }
}
