package cn.com.smartdevices.bracelet;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.view.a.C0113o;
import android.text.TextUtils;
import com.g.a.f;
import com.xiaomi.mistatistic.sdk.a;
import com.xiaomi.mistatistic.sdk.d;
import java.util.HashMap;
import java.util.Map;

public class C0401a {
    public static final String A = "PagePersonGuideGender";
    public static final String B = "PagePersonGuideAge";
    public static final String C = "PagePersonGuideHeight";
    public static final String D = "PagePersonGuideWeight";
    public static final String E = "PagePersonGuideGoal";
    public static final String F = "PagePersonGuideFinish";
    public static final String G = "PageAlarm";
    public static final String H = "PageAlarmNew";
    public static final String I = "PageAlarmNewRepeat";
    public static final String J = "PageAlarmNewRepeatCustom";
    public static final String K = "PageFeedback";
    public static final String L = "PageAbout";
    public static final String M = "PageAgreementAndPrivacy";
    public static final String N = "PageBracelet";
    public static final String O = "PageBraceletLight";
    public static final String P = "PageBraceletHand";
    public static final String Q = "PageBraceletGoal";
    public static final String R = "PageBraceletUnbind";
    public static final String S = "PageUnlockHelp";
    public static final String T = "PageUnlockInvaildHelp";
    public static final String U = "PageBindWeChat";
    public static final String V = "PageBindQQHealth";
    public static final String W = "PageShare";
    public static final String X = "PageFirmwareUpgrade";
    public static final String Y = "PageShoesFirmwareUpgrade";
    public static final String Z = "PageLabEntrance";
    public static final String a = "PageDynamic";
    public static final String aA = "PageWaterMark";
    public static final String aB = "PageWaterMarkGallery";
    public static final String aC = "PageWaterMarkShare";
    public static final String aD = "PageWeiboHealthAuth";
    public static final String aE = "CallFromWeiboHealth";
    public static final String aF = "AuthWeiboHealthSucceed";
    public static final String aG = "AuthWeiboHealthSucceedServerList";
    public static final String aH = "AuthWeiboHealthFailureSDK";
    public static final String aI = "AuthWeiboHealthFailureCancel";
    public static final String aJ = "AuthWeiboHealthFailureMiServer";
    public static final String aK = "AuthWeiboHealthFailureMiOther";
    public static final String aL = "PageWeightFamilyMember";
    public static final String aM = "PageWeightUserSetName";
    public static final String aN = "PageWeightUserSetGender";
    public static final String aO = "PageWeightUserSetBirth";
    public static final String aP = "PageWeightUserSetHeight";
    public static final String aQ = "PageWeightReport";
    public static final String aR = "PageWeightUserList";
    public static final String aS = "PageWeightTips";
    public static final String aT = "PageWeightChooseUser";
    public static final String aU = "PageWeightSelectUser";
    public static final String aV = "PageWeightGoalSet";
    public static final String aW = "PageWeightUserInfo";
    public static final String aX = "PageWeightUserSetSuc";
    public static final String aY = "Share";
    public static final String aZ = "ShareFrom";
    public static final String aa = "PageLabSportIn";
    public static final String ab = "PageLabSportResult";
    public static final String ac = "PageLabSportTimeout";
    public static final String ad = "PageLabSportVote";
    public static final String ae = "PageLabSportVoteOthers";
    public static final String af = "PageLabMarkAction";
    public static final String ag = "PageBehaviorTagGuide";
    public static final String ah = "PageBehaviorTagMenu";
    public static final String ai = "PageBehaviorTagData";
    public static final String aj = "PageBehaviorTagHistory";
    public static final String ak = "PageRunMain";
    public static final String al = "PageRunHistory";
    public static final String am = "PageRunResult";
    public static final String an = "PageRunMapResult";
    public static final String ao = "PageRunPaceResult";
    public static final String ap = "PageShoesDetail";
    public static final String aq = "PageShoesIntro";
    public static final String ar = "PageShoesCalibrate";
    public static final String as = "PageShoesPrepareCalibrate";
    public static final String at = "PageShoesUnbind";
    public static final String au = "PageShoesList";
    public static final String av = "PageShoesBind";
    public static final String aw = "PageShoesUpdateFirmware";
    public static final String ax = "PagePartnerDetail";
    public static final String ay = "PagePartnerList";
    public static final String az = "PageHealthLink";
    public static final String b = "PageDynamicDetail";
    public static final String bA = "PartnerFileChooser";
    public static final String bB = "PartnerFileChooseCancelled";
    public static final String bC = "PartenerShareClick";
    public static final String bD = "WaterMarkIn";
    public static final String bE = "WaterMarkCamera";
    public static final String bF = "WaterMarkGallery";
    public static final String bG = "WaterMarkFlash";
    public static final String bH = "WaterMarkFront";
    public static final String bI = "WaterMarkCancel";
    public static final String bJ = "WaterMarkFinish";
    public static final String bK = "WaterMarkCameraSet";
    public static final String bL = "WaterMarkGallerySet";
    public static final String bM = "RunDelTrack";
    public static final String bN = "RunDelTrackOK";
    public static final String bO = "RunDelTrackCancel";
    public static final String bP = "BehaviorClick";
    public static final String bQ = "TagGuideEnter";
    public static final String bR = "TagMenuEnter";
    public static final String bS = "TagDataEnter";
    public static final String bT = "TagHistoryEnter";
    public static final String bU = "ShoesDetailIn";
    public static final String bV = "ShoesIntroIn";
    public static final String bW = "ShoesCalibrateIn";
    public static final String bX = "ShoesPrepareCalibrateIn";
    public static final String bY = "ShoesUnbindIn";
    public static final String bZ = "ShoesListIn";
    public static final String ba = "ShareTo";
    public static final String bb = "SportVote";
    public static final String bc = "SportIn";
    public static final String bd = "WifiState";
    public static final String be = "BuyBand";
    public static final String bf = "PartnerIn";
    public static final String bg = "PartnerAuth";
    public static final String bh = "PartnerCancelAuth";
    public static final String bi = "RunSettingIn";
    public static final String bj = "RunSetPaceOK";
    public static final String bk = "RunSetPaceCancel";
    public static final String bl = "RunMainIn";
    public static final String bm = "RunStart";
    public static final String bn = "RunPause";
    public static final String bo = "UnlockAutoPaused";
    public static final String bp = "RunResume";
    public static final String bq = "RunAutoResume";
    public static final String br = "RunStop";
    public static final String bs = "RunReturn";
    public static final String bt = "RunCancel";
    public static final String bu = "RunHistoryIn";
    public static final String bv = "RunSharePace";
    public static final String bw = "RunShareTrack";
    public static final String bx = "BandDetected";
    public static final String by = "PartnerHealthIn";
    public static final String bz = "DialHealthService";
    public static final String c = "PageDynamicDetailModifySleepStart";
    public static final String cA = "ShareToWeChat";
    public static final String cB = "ShareToWeChatFriends";
    public static final String cC = "ShareToMiChat";
    public static final String cD = "ShareToWeibo";
    public static final String cE = "ShareToLine";
    public static final String cF = "ShareToFaceBook";
    public static final String cG = "ShareToTwitter";
    public static final String cH = "ViewDynamic";
    public static final String cI = "View_DynamicDetail_Step";
    public static final String cJ = "View_DynamicDetail_Sleep";
    public static final String cK = "View_DynamicDetail_SwitchTo_Step";
    public static final String cL = "View_DynamicDetail_SwitchTo_Sleep";
    public static final String cM = "View_Statistic_Step";
    public static final String cN = "View_Statistic_Sleep";
    public static final String cO = "View_Statistic_SwitchTo_Step";
    public static final String cP = "View_Statistic_SwitchTo_Sleep";
    public static final String cQ = "DynamicRealStepUpdate";
    public static final String cR = "DynamicDetailViewChartItem";
    public static final String cS = "ModeStep";
    public static final String cT = "ModeSleep";
    public static final String cU = "ModeWeight";
    public static final String cV = "FromDynamicList";
    public static final String cW = "FromDynamic";
    public static final String cX = "StatisticLevelDaily";
    public static final String cY = "StatisticLevelWeekly";
    public static final String cZ = "StatisticLevelMonthly";
    public static final String ca = "ShoesBindIn";
    public static final String cb = "ShoesUpdateFirmwareIn";
    public static final String cc = "login";
    public static final String cd = "fail";
    public static final String ce = "about";
    public static final String cf = "PhotoFromCamera";
    public static final String cg = "PhotoFromGallery";
    public static final String ch = "ShareStepGoalSuccess";
    public static final String ci = "ShareStepGoalFailed";
    public static final String cj = "ShareSleep";
    public static final String ck = "ShareWeeklySteps";
    public static final String cl = "ShareMonthlySteps";
    public static final String cm = "ShareWeeklySleep";
    public static final String cn = "ShareMonthlySleep";
    public static final String co = "ShareNewRecord";
    public static final String cp = "ShareContinueDays";
    public static final String cq = "ShareStepDynamicList";
    public static final String cr = "ShareEvent";
    public static final String cs = "ShareService";
    public static final String ct = "ShareFromDynamic";
    public static final String cu = "ShareFromDynamicDetail";
    public static final String cv = "ShareFromDynamicList";
    public static final String cw = "ShareFromStatistic";
    public static final String cx = "ShareFromLabSport";
    public static final String cy = "ShareToQQ";
    public static final String cz = "ShareToQQZone";
    public static final String d = "PageDynamicDetailModifySleepEnd";
    public static final String dA = "Successed";
    public static final String dB = "Failed";
    public static final String dC = "Confirmed";
    public static final String dD = "Canceled";
    public static final String dE = "StartUpScanBracelet";
    public static final String dF = "StartUpFoundBracelet";
    public static final String dG = "StartUpPairingBracelet";
    public static final String dH = "StartUpConnectBracelet";
    public static final String dI = "StartUpNotBindBracelet";
    public static final String dJ = "StartUpViewBraceletList";
    public static final String dK = "BraceletFind";
    public static final String dL = "BraceletGoal";
    public static final String dM = "BraceletLight";
    public static final String dN = "BraceletHand";
    public static final String dO = "BraceletCallNotify";
    public static final String dP = "BraceletCallNotifyTime";
    public static final String dQ = "BraceletUnbind";
    public static final String dR = "BraceletBindWeChat";
    public static final String dS = "BraceletUnlockSetting";
    public static final String dT = "BindWeChatQrcode";
    public static final String dU = "BindWeChatLaunch";
    public static final String dV = "UserSettingGender";
    public static final String dW = "UserSettingAge";
    public static final String dX = "UserSettingHeight";
    public static final String dY = "UserSettingWeight";
    public static final String dZ = "UserLogout";
    public static final String da = "DynamicList";
    public static final String db = "SlideUp";
    public static final String dc = "SlideDownSync";
    public static final String dd = "SlideDownConnect";
    public static final String de = "DynamicListItemClick";
    public static final String df = "ClickMainMenu";
    public static final String dg = "ClickMainMenuItem";
    public static final String dh = "MenuBracelet";
    public static final String di = "MenuAlarm";
    public static final String dj = "MenuPerson";
    public static final String dk = "MenuShare";
    public static final String dl = "MenuAbout";
    public static final String dm = "MenuSensorhub";
    public static final String dn = "MenuRunning";
    public static final String do = "MenuLab";
    public static final String dp = "MenuService";
    public static final String dq = "MenuFriend";
    public static final String dr = "MenuHeartRate";
    public static final String ds = "DynamicDetailModifySleepTime";
    public static final String dt = "SleepTimeStart";
    public static final String du = "SleepTimeEnd";
    public static final String dv = "StartUp";
    public static final String dw = "StartLogin";
    public static final String dx = "StartRegister";
    public static final String dy = "StartUpLogin";
    public static final String dz = "StartUpRegister";
    public static final String e = "PageStatistic";
    public static final String eA = "WeatherStart";
    public static final String eB = "WeatherOK";
    public static final String eC = "WeatherException";
    public static final String eD = "LocationStart";
    public static final String eE = "LocationOK";
    public static final String eF = "LocationException";
    public static final String eG = "Call_Ring";
    public static final String eH = "Call_Offhook";
    public static final String eI = "Call_Idle";
    public static final String eJ = "Call_Notify";
    public static final String eK = "User_Binded_Start";
    public static final String eL = "User_CallNotify_Start";
    public static final String eM = "User_QQ_Health_Start";
    public static final String eN = "User_App_Notifi_Start";
    public static final String eO = "User_App_Notifi_Access_Service_Start";
    public static final String eP = "Event_App_Notifi";
    public static final String eQ = "User_VibrateNotifyClosed";
    public static final String eR = "Game_ViewSignup";
    public static final String eS = "Game_Dislike";
    public static final String eT = "QQ_Login";
    public static final String eU = "QQ_Login_Cancel";
    public static final String eV = "QQ_Login_Error";
    public static final String eW = "QQ_Login_Success";
    public static final String eX = "QQ_Login_Fail";
    public static final String eY = "QQ_Logout";
    public static final String eZ = "QQ_Request_UserInfo";
    public static final String ea = "AlarmSetting";
    public static final String eb = "AboutCheckUpdate";
    public static final String ec = "AboutViewOfficialSite";
    public static final String ed = "AboutFeedback";
    public static final String ee = "AboutSendFeedback";
    public static final String ef = "AboutUserAgreement";
    public static final String eg = "FirmwareUpgrade";
    public static final String eh = "ShoesFirmwareUpgrade";
    public static final String ei = "BleConnect";
    public static final String ej = "BleDisconnect";
    public static final String ek = "BleSyncData";
    public static final String el = "BleSyncDataFirst";
    public static final String em = "ExceptRealtimeLessDetailStep";
    public static final String en = "ExceptRealtimeMoreDetailStep";
    public static final String eo = "ExceptDeviceReboot";
    public static final String ep = "ExceptSyncDataBeforeHead";
    public static final String eq = "ExceptSyncDataLengthError";
    public static final String er = "ExceptSyncDataHeadComing";
    public static final String es = "ExceptSearchBandUserInfoInvalid";
    public static final String et = "SyncDataNoConnection";
    public static final String eu = "SyncDataLessThanFiveMinutes";
    public static final String ev = "SyncDataToServerFailed";
    public static final String ew = "SyncDataToServerSuccess";
    public static final String ex = "WeatherRequestCity";
    public static final String ey = "WeatherRequestCityCode";
    public static final String ez = "WeatherRequestWeather";
    public static final String f = "PagePersonInfo";
    public static final String fA = "Weight_Report_Delete";
    public static final String fB = "Weight_Report_Show";
    public static final String fC = "Weight_Report_Show_From_Dynamic";
    public static final String fD = "Weight_Cancle_Choose_User";
    public static final String fE = "Weight_Generate_Weight_Report";
    public static final String fF = "Weight_Auto_Merge_Weight";
    public static final String fG = "ON";
    public static final String fH = "OFF";
    public static final String fI = "Weight_Click_About_Scale";
    public static final String fJ = "Binded_Device";
    public static final String fK = "Weight_Sync_History";
    public static final String fL = "Click_Sync_Weight_History_LuaItem";
    public static final String fM = "Scale_Connect_Fail";
    public static final String fN = "Bind_Scale";
    public static final String fO = "Connect_Device_Time";
    public static final String fP = "Reboot_Count";
    public static final String fQ = "Weight_Choose_User";
    public static final String fR = "Weight_Show_Statistic";
    public static final String fS = "Weight_Show_Instruction_Page";
    public static final String fT = "Weight_Click_Unbind";
    public static final String fU = "Weight_Bind_Later";
    public static final String fV = "Weight_Bind_Scale_Timeout";
    public static final String fW = "Weight_Bind_Scale_Fail";
    public static final String fX = "Weight_Bind_Scale_OK_Automatic";
    public static final String fY = "Weight_Bind_Scale_OK_Manual";
    public static final String fZ = "Weight_Bind_Scale_Fail_And_Rebind";
    public static final String fa = "QQ_Request_UserInfo_Error";
    public static final String fb = "QQ_Request_UserInfo_Success";
    public static final String fc = "QQ_Request_UserInfo_Fail";
    public static final String fd = "QQ_Health_SyncData";
    public static final String fe = "QQ_Health_SyncData_Success";
    public static final String ff = "QQ_Health_SyncData_Fail";
    public static final String fg = "confirm_manual_lazy_day";
    public static final String fh = "Pair_For_SmartLock_Start";
    public static final String fi = "Pair_For_SmartLock_Success";
    public static final String fj = "Pair_For_SmartLock_Success_NoSecuritySetting";
    public static final String fk = "Page_Help";
    public static final String fl = "Weight_Add_User";
    public static final String fm = "From_Family_User_List_Page";
    public static final String fn = "From_Weight_Choose_User_Page";
    public static final String fo = "Weight_Add_User_Succ";
    public static final String fp = "Weight_Add_User_Fail";
    public static final String fq = "Weight_Del_User";
    public static final String fr = "Weight_Del_User_Succ";
    public static final String fs = "Weight_Del_User_Fail";
    public static final String ft = "Weight_User_Change_Name";
    public static final String fu = "Weight_User_Change_Gender";
    public static final String fv = "Weight_User_Change_Height";
    public static final String fw = "Weight_User_Change_Birth";
    public static final String fx = "Weight_User_Change_Icon";
    public static final String fy = "Weight_User_Change_Weight_Goal";
    public static final String fz = "Weight_Report_Change_User";
    public static final String g = "PagePersonInfoGender";
    public static final String gA = "PageFriendMain";
    public static final String gB = "PageMessage";
    public static final String gC = "PageRemark";
    public static final String gD = "PageSearchResult";
    public static final String gE = "PageUserCard";
    public static final String gF = "PageQrScan";
    public static final String gG = "PageGalleryPicker";
    public static final String gH = "AddFriendEnter";
    public static final String gI = "RemoveFriend";
    public static final String gJ = "FriendDetailEnter";
    public static final String gK = "FriendMainEnter";
    public static final String gL = "MessageEnter";
    public static final String gM = "RemarkEnter";
    public static final String gN = "SearchResultEnter";
    public static final String gO = "UserCardEnter";
    public static final String gP = "GalleryPickerEnter";
    public static final String gQ = "QrcodeScanEnter";
    public static final String gR = "SendCareToBraceletSuccess";
    public static final String gS = "SendCareToBraceletFail";
    public static final String gT = "SendCareToFriend";
    public static final String gU = "AcceptCareInvitation";
    public static final String gV = "RefusedCareToFriend";
    public static final String gW = "HeartMeasureButton";
    public static final String gX = "HeartMeasureMention";
    public static final String gY = "HeartNoMentionButton";
    public static final String gZ = "HeartMeasureFail";
    public static final String ga = "Weight_Bind_Scale_Fail_And_Not_Bind";
    public static final String gb = "Weight_Bind_Scale_Fail_And_LookingForHelp";
    public static final String gc = "value_device_not_found";
    public static final String gd = "value_device_bind_fail";
    public static final String ge = "Click_Family_Member_Page";
    public static final String gf = "Click_Family_Member_List";
    public static final String gg = "Click_Del_User_And_OK";
    public static final String gh = "Weight_Set_Weight_Goal";
    public static final String gi = "Weight_Reset_Weight_Goal";
    public static final String gj = "Weight_Clear_Weight_Goal";
    public static final String gk = "Weight_Create_User_Weight";
    public static final String gl = "Weight_Create_User_Weight_MANUAL";
    public static final String gm = "Weight_Create_User_Weight_SCALE";
    public static final String gn = "Weight_Share_Weight_Report";
    public static final String go = "Weight_Report_BMI";
    public static final String gp = "Weight_Show_About_Scale";
    public static final String gq = "Weight_Item_Show_Set_Weight_Goal";
    public static final String gr = "Weight_Record_Manual";
    public static final String gs = "Running_Record_Manual";
    public static final String gt = "From_Main_UI";
    public static final String gu = "From_Statistic";
    public static final String gv = "Weight_Record_Time";
    public static final String gw = "Setting_Sms_Notify";
    public static final String gx = "Setting_Alarm_Notify";
    public static final String gy = "PageAddFriend";
    public static final String gz = "PageFriendDetail";
    public static final String h = "PagePersonInfoUnit";
    public static final String hA = "TYPE_3G";
    public static final String hB = "TYPE_4G";
    public static final String hC = "TYPE_WIFI";
    public static final String hD = "TYPE_NO_NETWORK";
    public static final String hE = "launch_ad";
    public static final String hF = "launch_default";
    public static final String hG = "launch_open";
    private static final String hH = "Analytics";
    private static final String hI = "2882303761517163841";
    private static final String hJ = "5171716313841";
    private static final String hK = "Normal";
    private static boolean hL = true;
    private static boolean hM = true;
    private static boolean hN = true;
    private static Context hO = null;
    public static final String ha = "HeartMeasureSuccess";
    public static final String hb = "SleepAssistOn";
    public static final String hc = "SleepAssistOff";
    public static final String hd = "Run1SMIbandSettingHeartRateOffToOn";
    public static final String he = "Run1SMIbandSettingHeartRateOnToOff";
    public static final String hf = "Run1SMIbandHeartRateOnClickStartRunning";
    public static final String hg = "RunRunningPageUnpair1SbandAlert";
    public static final String hh = "RunRunningPageUnconnect1SbandAlert";
    public static final String hi = "RunRunningPageHeartRateOffAlert";
    public static final String hj = "Run1SMIbandHeartRateOnStopRunComfirmed";
    public static final String hk = "Run1SMIbandStopRunComfirmedExistHeartRate";
    public static final String hl = "Run1SMIbandStopRunExistHeartRateDisconnect";
    public static final String hm = "Run1SMIbandStopRunExistHeartRateReconnectSuccess";
    public static final String hn = "1";
    public static final String ho = "0";
    public static final String hp = "BabyScaleNotNearby";
    public static final String hq = "BabyWeight";
    public static final String hr = "BabyAdultWeight";
    public static final String hs = "BabyWeightDataTable";
    public static final String ht = "BabyWeightDataTableHelp";
    public static final String hu = "BabyWeightGapSmall";
    public static final String hv = "BabyWeightLessThanOne";
    public static final String hw = "PageHonorMedalDetal";
    public static final String hx = "HonorMedalDetalEnter";
    public static final String hy = "AppInUse";
    public static final String hz = "TYPE_2G";
    public static final String i = "PagePersonInfoAge";
    public static final String j = "PagePersonInfoHeight";
    public static final String k = "PagePersonInfoWeight";
    public static final String l = "PagePersonInfoAvatarSelection";
    public static final String m = "PagePersonInfoAvatarCrop";
    public static final String n = "PageStartUp";
    public static final String o = "PageWebRegister";
    public static final String p = "PageWebUserAgreement";
    public static final String q = "PageSearchSingleBracelet";
    public static final String r = "PageSearchMultiBracelet";
    public static final String s = "PageBraceletNotFound";
    public static final String t = "PageWeightNotFoundHelp";
    public static final String u = "PageBraceletNotFoundHelp";
    public static final String v = "PageBraceletConnectFailed";
    public static final String w = "PageSystemLow";
    public static final String x = "PageSystemNotSupport";
    public static final String y = "PageInstruction";
    public static final String z = "PageInstructionWeight";

    public static String a(Context context) {
        String str = null;
        try {
            str = context.getPackageManager().getApplicationInfo(context.getPackageName(), C0113o.h).metaData.getString(Constant.d);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            str = hK;
        }
        C0596r.e(hH, "Current Channel : " + str);
        return str;
    }

    public static void a(Activity activity) {
        if (hL) {
            C0596r.e(hH, "Start Session : " + activity);
            if (hM) {
                f.b((Context) activity);
            }
            if (hN) {
                d.a(activity, null);
            }
        }
    }

    public static void a(Context context, Exception exception) {
        if (hL && hM) {
            f.a(context, (Throwable) exception);
        }
    }

    public static void a(Context context, String str) {
        if (hL) {
            C0596r.e(hH, "Event : " + str);
            if (hM) {
                f.b(context, str);
            }
            if (hN) {
                d.a("Event", str);
            }
        }
    }

    public static void a(Context context, String str, int i) {
        C0401a.a(context, str, null, i);
    }

    public static void a(Context context, String str, String str2) {
        if (hL) {
            C0596r.e(hH, "Event : " + str + ", Value : " + str2);
            if (hM) {
                f.b(context, str, str2);
            }
            if (hN) {
                Map hashMap = new HashMap();
                hashMap.put("Property", str2);
                d.a("Event", str, hashMap);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        C0401a.a(context, str, hashMap);
    }

    public static void a(Context context, String str, String str2, String str3, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        C0401a.a(context, str, hashMap, i);
    }

    public static void a(Context context, String str, HashMap<String, String> hashMap) {
        if (hL) {
            C0596r.e(hH, "Event : " + str + ", Properties : " + hashMap);
            if (hM) {
                f.a(context, str, (Map) hashMap);
            }
            if (hN) {
                d.a("Event", str, (Map) hashMap);
            }
        }
    }

    public static void a(Context context, String str, HashMap<String, String> hashMap, int i) {
        if (hL) {
            C0596r.e(hH, "Event : " + str + ", Properties : " + hashMap + ", Duration : " + i);
            if (hM) {
                f.a(context, str, (Map) hashMap, i);
            }
        }
    }

    public static void a(String str) {
        if (hL) {
            C0596r.e(hH, "Start Page : " + str);
            if (hM) {
                f.a(str);
            }
        }
    }

    public static void a(String str, String str2) {
        if (hN) {
            d.a("Event", str, str2);
        }
    }

    public static void a(boolean z, boolean z2, boolean z3, Context context) {
        C0596r.e(hH, "config Umeng to " + z);
        hL = z;
        hO = context;
        if (hL) {
            if (hM) {
                f.e(z2);
                f.d(z3);
            }
            if (hN) {
                d.a(context, hI, hJ, C0401a.a(context), false);
                a.d();
                if (z2) {
                    d.a();
                }
                d.a(false);
            }
        }
    }

    public static boolean a() {
        return hL;
    }

    public static String b(Context context) {
        return d.a(context);
    }

    public static void b(Activity activity) {
        if (hL) {
            C0596r.e(hH, "End Session : " + activity);
            if (hM) {
                f.a((Context) activity);
            }
            if (hN) {
                d.b();
            }
        }
    }

    public static void b(Context context, String str) {
        if (hL && hM) {
            f.a(context, str);
        }
    }

    @Deprecated
    public static void b(Context context, String str, String str2) {
        if (hL) {
            C0596r.e(hH, "Start Event : " + str + ", Value : " + str2);
            if (!hM) {
                return;
            }
            if (str2 == null) {
                f.c(context, str);
            } else {
                f.c(context, str, str2);
            }
        }
    }

    public static void b(String str) {
        if (hL) {
            C0596r.e(hH, "End Page : " + str);
            if (hM) {
                f.b(str);
            }
        }
    }

    @Deprecated
    public static void c(Context context, String str) {
        C0401a.b(context, str, null);
    }

    @Deprecated
    public static void c(Context context, String str, String str2) {
        if (hL) {
            C0596r.e(hH, "End Event : " + str + ", Value : " + str2);
            if (!hM) {
                return;
            }
            if (str2 == null) {
                f.d(context, str);
            } else {
                f.d(context, str, str2);
            }
        }
    }

    public static void c(String str) {
        C0401a.a(hO, str);
    }

    @Deprecated
    public static void d(Context context, String str) {
        C0401a.c(context, str, null);
    }
}
