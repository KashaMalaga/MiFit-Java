package cn.com.smartdevices.bracelet.model.game;

import android.content.Context;
import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventGameUpdate;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.push.i;
import com.d.a.a.h;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.hm.health.dataprocess.DaySportData.Summary;
import com.xiaomi.hm.health.dataprocess.SportDay;
import de.greenrobot.event.EventBus;
import java.util.Calendar;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class GameManager {
    public static final String GAME_MARK = "GAME_";
    public static final String NEW_GAME = "NewGame";
    public static final int STATUS_ACTIVE = 1;
    private static final String STR_GAME_BONUS = "game_bonus";
    public static final String STR_GAME_CLEAR_BANNER = "game_clear_banner";
    private static final String STR_GAME_DEFAULT = "game_default";
    private static final String STR_GAME_NOT_REGISTER = "game_not_registered";
    private static final String STR_GAME_PLAYING = "game_playing";
    private static final String STR_GAME_PLAYING_FAIL = "game_playing_fail";
    private static final String STR_GAME_PLAYING_FAILED = "game_playing_failed";
    private static final String STR_GAME_REGISTER = "game_registered";
    private static final String TAG = "GameManager";
    boolean TEST = false;
    private GameBriefInfo mGameBriefInfo = new GameBriefInfo();
    private int mTotalSteps;

    class GameTask extends AsyncTask<String, String, String> {
        private Context mContext = null;

        public GameTask(Context context) {
            this.mContext = context;
        }

        protected String doInBackground(String... strArr) {
            GameBriefInfo access$000 = GameManager.this.getGameBriefInfo(this.mContext);
            EventGameUpdate eventGameUpdate = new EventGameUpdate();
            eventGameUpdate.getConfigInfo().setType(GameManager.GAME_MARK + access$000.getId());
            eventGameUpdate.getConfigInfo().setRight("onTop");
            C0596r.e(GameManager.TAG, "mark = " + strArr[0]);
            if (access$000.getLike() == 0 || strArr[0].equals(GameManager.STR_GAME_CLEAR_BANNER)) {
                GameManager.this.clearGameUI(this.mContext, eventGameUpdate);
            } else if (access$000.isGameStart()) {
                GameManager.this.getRegisterInfo(this.mContext);
                if (access$000.isInRegisterStage()) {
                    if (GameManager.this.mGameBriefInfo.isRegistered()) {
                        eventGameUpdate.getConfigInfo().setTitle(GameManager.STR_GAME_REGISTER);
                        eventGameUpdate.getConfigInfo().setUrl(GameManager.this.mGameBriefInfo.getRegisterUrl(this.mContext));
                        eventGameUpdate.getConfigInfo().setTimeStamp(GameManager.this.mGameBriefInfo.getRegisterEndTimeStamp());
                        EventBus.getDefault().post(eventGameUpdate);
                    } else {
                        eventGameUpdate.getConfigInfo().setTitle(GameManager.STR_GAME_NOT_REGISTER);
                        eventGameUpdate.getConfigInfo().setUrl(GameManager.this.mGameBriefInfo.getRegisterUrl(this.mContext));
                        EventBus.getDefault().post(eventGameUpdate);
                    }
                } else if (access$000.isInGamingStage()) {
                    if (GameManager.this.mGameBriefInfo.isRegistered()) {
                        GameManager.this.showGameRecord(this.mContext, eventGameUpdate);
                    } else {
                        GameManager.this.clearGameUI(this.mContext, eventGameUpdate);
                    }
                } else if (!access$000.isInBonusStage()) {
                    eventGameUpdate.getConfigInfo().setTitle(GameManager.STR_GAME_DEFAULT);
                    eventGameUpdate.getConfigInfo().setUrl(GameManager.this.mGameBriefInfo.getDefaultUrl(this.mContext));
                    EventBus.getDefault().post(eventGameUpdate);
                } else if (GameManager.this.mGameBriefInfo.isRegistered()) {
                    GameManager.this.showBonusBanner(this.mContext, eventGameUpdate);
                } else {
                    GameManager.this.clearGameUI(this.mContext, eventGameUpdate);
                }
            } else {
                GameManager.this.clearGameUI(this.mContext, eventGameUpdate);
            }
            return null;
        }
    }

    private int checkContinusReachGoal(SportDay sportDay, SportDay sportDay2) {
        int offsetDay = sportDay2.offsetDay(sportDay) + STATUS_ACTIVE;
        C0596r.e(TAG, "Check continus reach goal,  startDay = " + sportDay + ", stopDay = " + sportDay2 + ", goal=" + this.mGameBriefInfo.getGoal() + "curGameDurationDay = " + offsetDay);
        if (offsetDay < 0) {
            C0596r.d(TAG, "Game start/stop time illegal : start = " + sportDay + ", stopday = " + sportDay2);
            return -1;
        }
        this.mTotalSteps = 0;
        for (int i = 0; i < offsetDay; i += STATUS_ACTIVE) {
            SportDay addDay = sportDay.addDay(i);
            int steps = C0591m.a().b(addDay).getSteps();
            this.mTotalSteps += steps;
            C0596r.e(TAG, "sumary step = " + steps);
            if (this.mGameBriefInfo.getGoal() > steps) {
                int timeInMillis = (int) (addDay.calendar.getTimeInMillis() / 1000);
                C0596r.e(TAG, "First failed at " + addDay);
                return timeInMillis;
            }
        }
        return 0;
    }

    private void clearGameUI(Context context, EventGameUpdate eventGameUpdate) {
        eventGameUpdate.getConfigInfo().setTitle(STR_GAME_CLEAR_BANNER);
        EventBus.getDefault().post(eventGameUpdate);
    }

    private GameBriefInfo getGameBriefInfo(Context context) {
        C0596r.e(TAG, "start get game briefInfo ");
        l.a(context, new h() {
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                C0596r.d(GameManager.TAG, "Get game info failed , statusCode = " + i);
            }

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                C0596r.e(GameManager.TAG, "get responseBody=" + new String(bArr));
                if (bArr != null && bArr.length > 0) {
                    GameManager.this.parseGameBriefInfo(GameManager.this.mGameBriefInfo, bArr);
                }
            }
        });
        C0596r.e(TAG, "get game briefInfo = " + this.mGameBriefInfo);
        return this.mGameBriefInfo;
    }

    private void getRegisterInfo(Context context) {
        l.b(context, new h() {
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                C0596r.d(GameManager.TAG, "Get game register info failed , statusCode = " + i);
            }

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                C0596r.e(GameManager.TAG, "get register responseBody=" + new String(bArr));
                try {
                    GameManager.this.mGameBriefInfo.setRegistered(new JSONObject(new String(bArr)).optInt(b.a) > 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void parseGameBriefInfo(GameBriefInfo gameBriefInfo, byte[] bArr) {
        String str = new String("{\"code\":1,\"message\":\"config info\",\"data\":{\"like\":1,\"name\":\"\\u56fd\\u5e86\\u4e03\\u5929\\u4e50\",\"actno\":\"20141001\",\"config\":\"{\\\"global\\\":{\\\"no\\\":20141001,\\\"stime\\\":1411401600,\\\"etime\\\":1411646400},\\\"bm\\\":{\\\"stime\\\":1411439400,\\\"etime\\\":1411444800,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/hd.ahhuami.com\\\\\\/\\\"},\\\"act\\\":{\\\"stime\\\":1411444801,\\\"etime\\\":1411624800,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/hd.ahhuami.com\\\\\\/act.php\\\"},\\\"award\\\":{\\\"stime\\\":1411624801,\\\"etime\\\":1411646400,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/hd.ahhuami.com\\\\\\/award.php\\\"}}\",\"server_time\":1411539767,\"goal\":\"2000\",\"bonus\":0,\"bonus_opentime\":1411632000}}");
        if (!this.TEST) {
            str = new String(bArr);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(b.a);
            if (optInt != STATUS_ACTIVE) {
                C0596r.e(TAG, "parseGameBriefInfo error code =" + optInt);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(b.b);
            if (optJSONObject == null) {
                C0596r.d(TAG, "dataObj is null");
                return;
            }
            if (gameBriefInfo == null) {
                gameBriefInfo = new GameBriefInfo();
            }
            C0596r.e(TAG, "dataObj = " + optJSONObject.toString());
            gameBriefInfo.setName(optJSONObject.optString("name"));
            gameBriefInfo.setId(optJSONObject.optInt("actno"));
            gameBriefInfo.setDefaultUrl(optJSONObject.optString("defaultUrl"));
            gameBriefInfo.setGoal(optJSONObject.optInt(d.c));
            gameBriefInfo.setBonus(optJSONObject.optInt("bonus"));
            gameBriefInfo.setBonusOpenTime(optJSONObject.optInt("bonus_opentime"));
            gameBriefInfo.setServerTime(optJSONObject.optInt("server_time"));
            gameBriefInfo.setLike(optJSONObject.optInt("like", STATUS_ACTIVE));
            jSONObject = new JSONObject(optJSONObject.optString(i.e));
            if (jSONObject == null) {
                C0596r.d(TAG, "configObj is null");
                return;
            }
            optJSONObject = jSONObject.optJSONObject("global");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("bm");
            JSONObject optJSONObject3 = jSONObject.optJSONObject(SocialConstants.PARAM_ACT);
            jSONObject = jSONObject.optJSONObject("award");
            if (optJSONObject != null) {
                gameBriefInfo.setId(optJSONObject.optInt("no"));
                gameBriefInfo.setStartTime(optJSONObject.optInt("stime"));
                gameBriefInfo.setStopTime(optJSONObject.optInt("etime"));
            }
            if (optJSONObject2 != null) {
                gameBriefInfo.setRegisterStage(GameStage.fromJson(optJSONObject2));
            }
            if (optJSONObject3 != null) {
                gameBriefInfo.setPlayingStage(GameStage.fromJson(optJSONObject3));
            }
            if (jSONObject != null) {
                gameBriefInfo.setBonusStage(GameStage.fromJson(jSONObject));
            }
            if (!this.TEST) {
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void showBonusBanner(Context context, EventGameUpdate eventGameUpdate) {
        GameStage playingStage = this.mGameBriefInfo.getPlayingStage();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(playingStage.getStartTime() * 1000);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(playingStage.getStopTime() * 1000);
        int checkContinusReachGoal = checkContinusReachGoal(new SportDay(instance), new SportDay(instance2));
        if (checkContinusReachGoal == -1) {
            C0596r.d(TAG, "showBonusBanner, illegal playing stage time: " + playingStage.getStartTime() + ", " + playingStage.getStopTime());
            return;
        }
        boolean z = checkContinusReachGoal <= 0;
        C0596r.e(TAG, "showBonusBanner continueRecord = " + z);
        eventGameUpdate.getConfigInfo().setTitle(STR_GAME_BONUS);
        eventGameUpdate.getConfigInfo().setUrl(this.mGameBriefInfo.getBonusUrl(context));
        eventGameUpdate.getConfigInfo().setTimeStamp((long) this.mGameBriefInfo.getBonusOpenTime());
        eventGameUpdate.getConfigInfo().setServerTimeStamp(this.mGameBriefInfo.getServerTime());
        eventGameUpdate.getConfigInfo().setBonus(this.mGameBriefInfo.getBonus());
        eventGameUpdate.getConfigInfo().setIsBind(z);
        eventGameUpdate.getConfigInfo().setRecordStep(this.mTotalSteps);
        EventBus.getDefault().post(eventGameUpdate);
    }

    private void showGameRecord(Context context, EventGameUpdate eventGameUpdate) {
        GameStage playingStage = this.mGameBriefInfo.getPlayingStage();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(playingStage.getStartTime() * 1000);
        Calendar.getInstance().setTimeInMillis(playingStage.getStopTime() * 1000);
        int checkContinusReachGoal = checkContinusReachGoal(new SportDay(instance), new SportDay().addDay(-1));
        if (checkContinusReachGoal != -1) {
            if (checkContinusReachGoal <= 0) {
                Summary b = C0591m.a().b(new SportDay());
                eventGameUpdate.getConfigInfo().setGoal(this.mGameBriefInfo.getGoal());
                C0596r.e(TAG, "playing start time =" + playingStage.getStartTime());
                eventGameUpdate.getConfigInfo().setTimeStamp(playingStage.getStartTime());
                eventGameUpdate.getConfigInfo().setTimeStamp1(playingStage.getStopTime());
                eventGameUpdate.getConfigInfo().setTimeStamp2((long) this.mGameBriefInfo.getBonusOpenTime());
                eventGameUpdate.getConfigInfo().setTitle(STR_GAME_PLAYING);
                eventGameUpdate.getConfigInfo().setUrl(this.mGameBriefInfo.getGamePlayingUrl(context));
                C0596r.e(TAG, "steps = " + b.getSteps());
                eventGameUpdate.getConfigInfo().setRecordStep(b.getSteps());
            } else {
                if (Keeper.readGameFailed()) {
                    eventGameUpdate.getConfigInfo().setTitle(STR_GAME_PLAYING_FAILED);
                } else {
                    Keeper.keepGameFailed(true);
                    eventGameUpdate.getConfigInfo().setTitle(STR_GAME_PLAYING_FAIL);
                }
                eventGameUpdate.getConfigInfo().setUrl(this.mGameBriefInfo.getGamePlayingUrl(context));
                eventGameUpdate.getConfigInfo().setTimeStamp((long) checkContinusReachGoal);
            }
            EventBus.getDefault().post(eventGameUpdate);
        }
    }

    public void processGameEvent(Context context, String str) {
        new GameTask(context.getApplicationContext()).execute(new String[]{str, null, null});
    }
}
