package com.handmark.pulltorefresh.library.extras;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnPullEventListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;
import java.util.HashMap;

public class SoundPullEventListener<V extends View> implements OnPullEventListener<V> {
    private final Context mContext;
    private MediaPlayer mCurrentMediaPlayer;
    private final HashMap<State, Integer> mSoundMap = new HashMap();

    public SoundPullEventListener(Context context) {
        this.mContext = context;
    }

    private void playSound(int i) {
        if (this.mCurrentMediaPlayer != null) {
            this.mCurrentMediaPlayer.stop();
            this.mCurrentMediaPlayer.release();
        }
        this.mCurrentMediaPlayer = MediaPlayer.create(this.mContext, i);
        if (this.mCurrentMediaPlayer != null) {
            this.mCurrentMediaPlayer.start();
        }
    }

    public void addSoundEvent(State state, int i) {
        this.mSoundMap.put(state, Integer.valueOf(i));
    }

    public void clearSounds() {
        this.mSoundMap.clear();
    }

    public MediaPlayer getCurrentMediaPlayer() {
        return this.mCurrentMediaPlayer;
    }

    public final void onPullEvent(PullToRefreshBase<V> pullToRefreshBase, State state, Mode mode) {
        Integer num = (Integer) this.mSoundMap.get(state);
        if (num != null) {
            playSound(num.intValue());
        }
    }
}
