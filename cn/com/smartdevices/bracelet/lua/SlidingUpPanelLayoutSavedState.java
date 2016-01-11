package cn.com.smartdevices.bracelet.lua;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class SlidingUpPanelLayoutSavedState extends BaseSavedState {
    public static final Creator<SlidingUpPanelLayoutSavedState> CREATOR = new n();
    SlideState mSlideState;

    public enum SlideState {
        EXPANDED,
        COLLAPSED,
        ANCHORED
    }

    private SlidingUpPanelLayoutSavedState(Parcel parcel) {
        super(parcel);
        try {
            this.mSlideState = (SlideState) Enum.valueOf(SlideState.class, parcel.readString());
        } catch (IllegalArgumentException e) {
            this.mSlideState = SlideState.COLLAPSED;
        }
    }

    SlidingUpPanelLayoutSavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mSlideState.toString());
    }
}
