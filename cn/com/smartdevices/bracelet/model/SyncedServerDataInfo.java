package cn.com.smartdevices.bracelet.model;

import android.content.SharedPreferences.Editor;
import cn.com.smartdevices.bracelet.Keeper;
import kankan.wheel.widget.a;

public class SyncedServerDataInfo {
    public static final int DATA_HAVE = 2;
    public static final int DATA_NONE = 1;
    public static final int DATA_SAVED_TO_DB = 3;
    public static final int DATA_UNKNOW = 0;
    public static final String TYPE_BRACELET_START_DATE = "net_start_day";
    public static final String TYPE_BRACELET_STATE = "net_data_state";
    public static final String TYPE_BRACELET_STOP_DATE = "net_stop_day";
    public static final String TYPE_ROPESKIPPING_START_DATE = "syncRopeStartDate";
    public static final String TYPE_ROPESKIPPING_STATE = "syncRopeState";
    public static final String TYPE_ROPESKIPPING_STOP_DATE = "syncRopeStopDate";
    public static final String TYPE_RUNNING_STATE = "syncRunningState";
    public static final String TYPE_SITUPS_START_DATE = "syncSitupsStartDate";
    public static final String TYPE_SITUPS_STATE = "syncSitupsState";
    public static final String TYPE_SITUPS_STOP_DATE = "syncSitupsStopDate";
    private int mDataState = DATA_UNKNOW;
    private String mStartDate = null;
    private String mStopDate = null;
    private int mType = DATA_UNKNOW;

    public SyncedServerDataInfo(int i) {
        this.mType = i;
    }

    public static SyncedServerDataInfo readInfoFromPref(int i) {
        SyncedServerDataInfo syncedServerDataInfo = new SyncedServerDataInfo(i);
        switch (i) {
            case DATA_UNKNOW /*0*/:
                syncedServerDataInfo.mDataState = Keeper.getSharedPref().getInt(TYPE_BRACELET_STATE, DATA_UNKNOW);
                syncedServerDataInfo.mStartDate = Keeper.getSharedPref().getString(TYPE_BRACELET_START_DATE, null);
                syncedServerDataInfo.mStopDate = Keeper.getSharedPref().getString(TYPE_BRACELET_STOP_DATE, null);
                break;
            case DATA_NONE /*1*/:
                syncedServerDataInfo.mDataState = Keeper.getSharedPref().getInt(TYPE_ROPESKIPPING_STATE, DATA_UNKNOW);
                syncedServerDataInfo.mStartDate = Keeper.getSharedPref().getString(TYPE_ROPESKIPPING_START_DATE, null);
                syncedServerDataInfo.mStopDate = Keeper.getSharedPref().getString(TYPE_ROPESKIPPING_STOP_DATE, null);
                break;
            case DATA_HAVE /*2*/:
                syncedServerDataInfo.mDataState = Keeper.getSharedPref().getInt(TYPE_SITUPS_STATE, DATA_UNKNOW);
                syncedServerDataInfo.mStartDate = Keeper.getSharedPref().getString(TYPE_SITUPS_START_DATE, null);
                syncedServerDataInfo.mStopDate = Keeper.getSharedPref().getString(TYPE_SITUPS_STOP_DATE, null);
                break;
            case a.aQ /*4*/:
                syncedServerDataInfo.mDataState = Keeper.getSharedPref().getInt(TYPE_RUNNING_STATE, DATA_UNKNOW);
                break;
        }
        return syncedServerDataInfo;
    }

    public String getStartDate() {
        return this.mStartDate;
    }

    public int getState() {
        return this.mDataState;
    }

    public String getStopDate() {
        return this.mStopDate;
    }

    public boolean isSucceededToSaved() {
        return this.mDataState == DATA_SAVED_TO_DB;
    }

    public boolean isSynced() {
        return this.mDataState != 0;
    }

    public boolean isSyncedData() {
        return this.mDataState == DATA_HAVE;
    }

    public void restState() {
        this.mDataState = DATA_UNKNOW;
    }

    public void saveInfo() {
        Editor edit = Keeper.getSharedPref().edit();
        switch (this.mType) {
            case DATA_UNKNOW /*0*/:
                edit.putInt(TYPE_BRACELET_STATE, this.mDataState);
                edit.putString(TYPE_BRACELET_START_DATE, this.mStartDate);
                edit.putString(TYPE_BRACELET_STOP_DATE, this.mStopDate);
                break;
            case DATA_NONE /*1*/:
                edit.putInt(TYPE_ROPESKIPPING_STATE, this.mDataState);
                edit.putString(TYPE_ROPESKIPPING_START_DATE, this.mStartDate);
                edit.putString(TYPE_ROPESKIPPING_STOP_DATE, this.mStopDate);
                break;
            case DATA_HAVE /*2*/:
                edit.putInt(TYPE_SITUPS_STATE, this.mDataState);
                edit.putString(TYPE_SITUPS_START_DATE, this.mStartDate);
                edit.putString(TYPE_SITUPS_STOP_DATE, this.mStopDate);
                break;
            case a.aQ /*4*/:
                edit.putInt(TYPE_RUNNING_STATE, this.mDataState);
                break;
        }
        edit.commit();
    }

    public void setStartDate(String str) {
        this.mStartDate = str;
    }

    public void setState(int i) {
        this.mDataState = i;
    }

    public void setStopDate(String str) {
        this.mStopDate = str;
    }
}
