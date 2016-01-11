package cn.com.smartdevices.bracelet.model.game;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import java.util.Calendar;

public class GameBriefInfo {
    private static final int DEFAULT_GOAL = 10000;
    private static final String TAG = "GameBriefInfo";
    private int bonus;
    private int bonusOpenTime;
    private GameStage bonusStage;
    private String defaultUrl;
    private int goal;
    private int id;
    private int like;
    private String name;
    private GameStage playingStage;
    private GameStage registerStage;
    private boolean registered;
    private int serverTime;
    private int startTime;
    private int stopTime;

    public int getBonus() {
        return this.bonus;
    }

    public int getBonusOpenTime() {
        return this.bonusOpenTime;
    }

    public GameStage getBonusStage() {
        return this.bonusStage;
    }

    public String getBonusUrl(Context context) {
        return this.bonusStage.getUrl(context);
    }

    public String getDefaultUrl(Context context) {
        return this.defaultUrl + Utils.i(context);
    }

    public String getGamePlayingUrl(Context context) {
        return this.playingStage.getUrl(context);
    }

    public int getGoal() {
        return this.goal;
    }

    public int getId() {
        return this.id;
    }

    public int getLike() {
        return this.like;
    }

    public GameStage getPlayingStage() {
        return this.playingStage;
    }

    public long getRegisterEndTimeStamp() {
        return this.registerStage.getStopTime();
    }

    public String getRegisterUrl(Context context) {
        C0596r.e(TAG, "getRegisterUrl = " + this.registerStage.getUrl(context));
        return this.registerStage.getUrl(context);
    }

    public long getServerTime() {
        if (this.serverTime <= 0) {
            this.serverTime = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
        }
        return (long) this.serverTime;
    }

    public boolean isGameStart() {
        return this.serverTime >= this.startTime && this.serverTime <= this.stopTime;
    }

    public boolean isInBonusStage() {
        return this.bonusStage != null ? this.bonusStage.isActive(this.serverTime) : false;
    }

    public boolean isInGamingStage() {
        return this.playingStage != null ? this.playingStage.isActive(this.serverTime) : false;
    }

    public boolean isInRegisterStage() {
        return this.registerStage != null ? this.registerStage.isActive(this.serverTime) : false;
    }

    public boolean isRegistered() {
        return this.registered;
    }

    public void setBonus(int i) {
        this.bonus = i;
    }

    public void setBonusOpenTime(int i) {
        this.bonusOpenTime = i;
    }

    public void setBonusStage(GameStage gameStage) {
        this.bonusStage = gameStage;
    }

    public void setDefaultUrl(String str) {
        this.defaultUrl = str;
    }

    public void setGoal(int i) {
        if (i >= 0) {
            this.goal = i;
        } else {
            this.goal = DEFAULT_GOAL;
        }
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLike(int i) {
        this.like = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPlayingStage(GameStage gameStage) {
        this.playingStage = gameStage;
    }

    public void setRegisterStage(GameStage gameStage) {
        this.registerStage = gameStage;
    }

    public void setRegistered(boolean z) {
        C0596r.e(TAG, "Registered = " + z);
        this.registered = z;
    }

    public void setServerTime(int i) {
        this.serverTime = i;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

    public void setStopTime(int i) {
        this.stopTime = i;
    }

    public String toString() {
        return "\n\nname = " + this.name + ", id = " + this.id + ", startTime =" + GameStage.toDate((long) this.startTime) + "\n Register stage " + this.registerStage + "\n Playing stage  " + this.playingStage + "\n Bonus Stage " + this.bonusStage + "\n goal = " + this.goal + "\n bonus = " + this.bonus + "\n bonusOpenTime = " + GameStage.toDate((long) this.bonusOpenTime) + "\n serverTime =" + GameStage.toDate((long) this.serverTime);
    }
}
