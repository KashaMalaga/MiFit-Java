package cn.com.smartdevices.bracelet.lab.sportmode;

public class DynamicGroupItemInfo extends GroupItemBaseInfo {
    private boolean mIsOnRoundFinished = false;
    private int mNewRoundCountOfPBState = 0;
    private int mSaveRoundCountOfPB = 0;

    public DynamicGroupItemInfo(int i, int i2) {
        super(i);
        this.mSaveRoundCountOfPB = i2;
    }

    public boolean isMarkedInGroup() {
        return this.mIsOnRoundFinished;
    }

    public boolean isNewPBPoint() {
        return this.mNewRoundCountOfPBState % 2 > 0;
    }

    public void setCount(int i) {
        super.setCount(i);
        setEndTime(System.currentTimeMillis());
        if (this.mSaveRoundCountOfPB > 0 && this.mNewRoundCountOfPBState < 2 && this.mSaveRoundCountOfPB < i) {
            this.mNewRoundCountOfPBState++;
        }
    }

    public void setMarkedOneRoundFinished() {
        this.mIsOnRoundFinished = true;
    }
}
