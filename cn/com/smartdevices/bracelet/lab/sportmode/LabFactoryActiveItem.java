package cn.com.smartdevices.bracelet.lab.sportmode;

import android.content.Context;
import cn.com.smartdevices.bracelet.lua.LuaAction;
import cn.com.smartdevices.bracelet.model.ShareData;

public class LabFactoryActiveItem {
    private int mCalories = 0;
    private int mCount = 0;
    private LuaAction mLuaAction = null;
    private int mMode = 0;
    private ShareData mShareData = null;
    private int mStartTime = 0;
    private int mStopTime = 0;

    public LabFactoryActiveItem(int i) {
        this.mMode = i;
    }

    public void clear() {
        this.mStartTime = 0;
        this.mStopTime = 0;
        this.mMode = 0;
        this.mCalories = 0;
        this.mCount = 0;
        this.mShareData = null;
    }

    public int getCalories() {
        return this.mCalories;
    }

    public int getCount() {
        return this.mCount;
    }

    public int getKey() {
        return (this.mStartTime << 16) | this.mStopTime;
    }

    public LuaAction getLuaAction() {
        return this.mLuaAction;
    }

    public int getMode() {
        return this.mMode;
    }

    public ShareData getShareData() {
        return this.mShareData;
    }

    public int getStart() {
        return this.mStartTime;
    }

    public int getStop() {
        return this.mStopTime;
    }

    public void setCalories(int i) {
        this.mCalories = i;
    }

    public void setCount(int i) {
        this.mCount = i;
    }

    public void setLuaAction(Context context) {
        this.mLuaAction = LuaAction.getInstance(context);
    }

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setShareData(ShareData shareData) {
        this.mShareData = shareData;
    }

    public void setStart(int i) {
        this.mStartTime = i;
    }

    public void setStop(int i) {
        this.mStopTime = i;
    }
}
