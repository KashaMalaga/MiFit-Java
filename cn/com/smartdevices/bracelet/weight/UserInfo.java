package cn.com.smartdevices.bracelet.weight;

import cn.com.smartdevices.bracelet.C0596r;
import com.activeandroid.a.a;
import com.activeandroid.a.d;
import com.activeandroid.g;
import org.json.JSONObject;

@d(a = "UserInfos")
public class UserInfo extends g {
    public static final String TAG = UserInfo.class.getSimpleName();
    public static final String USERINFO_KEY = "USERINFO_KEY";
    public static final String USERINFO_KEY_AVATAR_SOURCE = "USERINFO_KEY_TARGET_AVATAR_SOURCE";
    public static final String USERINFO_KEY_AVATAR_URL = "USERINFO_KEY_TARGET_AVATAR_URL";
    public static final String USERINFO_KEY_BIRTH = "USERINFO_KEY_BIRTH";
    public static final String USERINFO_KEY_GENDER = "USERINFO_KEY_GENDER";
    public static final String USERINFO_KEY_HEIGHT = "USERINFO_KEY_HEIGHT";
    public static final String USERINFO_KEY_NAME = "USERINFO_KEY_NAME";
    public static final String USERINFO_KEY_TARGET_WEIGHT = "USERINFO_KEY_TARGET_WEIGHT";
    public static final String USERINFO_KEY_UID = "USERINFO_KEY_UID";
    public static final String USERINFO_KEY_WEIGHT = "USERINFO_KEY_WEIGHT";
    public static final int USER_GENDER_FEMALE = 0;
    public static final int USER_GENDER_MALE = 1;
    public static final int USER_ID_SELF = -1;
    public static final int USER_ID_UNKNOWN = 0;
    @a(a = "AvatarSource")
    public byte[] avatarSource;
    @a(a = "AvatarUrl")
    public String avatarUrl;
    @a(a = "Birthday")
    public String birthday;
    @a(a = "Gender")
    public int gender;
    @a(a = "Height")
    public int height;
    @a(a = "Name")
    public String name;
    @a(a = "Synced")
    public int synced;
    @a(a = "TargetWeight")
    public float targetWeight;
    @a(a = "UserId")
    public int uid;
    @a(a = "Weight")
    public float weight;

    public static UserInfo fromJsonString(String str) {
        UserInfo userInfo = new UserInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            userInfo.uid = jSONObject.optInt(USERINFO_KEY_UID);
            userInfo.name = jSONObject.optString(USERINFO_KEY_NAME);
            userInfo.gender = jSONObject.optInt(USERINFO_KEY_GENDER);
            userInfo.birthday = jSONObject.optString(USERINFO_KEY_BIRTH);
            userInfo.height = jSONObject.optInt(USERINFO_KEY_HEIGHT);
            userInfo.weight = (float) jSONObject.optDouble(USERINFO_KEY_WEIGHT);
            userInfo.targetWeight = (float) jSONObject.optDouble(USERINFO_KEY_TARGET_WEIGHT);
            userInfo.avatarUrl = jSONObject.optString(USERINFO_KEY_AVATAR_URL);
            userInfo.avatarSource = jSONObject.optString(USERINFO_KEY_AVATAR_SOURCE).getBytes();
            return userInfo;
        } catch (Exception e) {
            return null;
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(USERINFO_KEY_UID, this.uid);
            jSONObject.put(USERINFO_KEY_NAME, this.name);
            jSONObject.put(USERINFO_KEY_GENDER, this.gender);
            jSONObject.put(USERINFO_KEY_BIRTH, this.birthday);
            jSONObject.put(USERINFO_KEY_HEIGHT, this.height);
            jSONObject.put(USERINFO_KEY_WEIGHT, (double) this.weight);
            jSONObject.put(USERINFO_KEY_TARGET_WEIGHT, (double) this.targetWeight);
            jSONObject.put(USERINFO_KEY_AVATAR_URL, this.avatarUrl);
            jSONObject.put(USERINFO_KEY_AVATAR_SOURCE, this.avatarSource.toString());
        } catch (Exception e) {
        }
        C0596r.e(TAG, "UserInfo toString " + jSONObject.toString());
        return jSONObject.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(" : <").append("Name : ").append(this.name);
        stringBuilder.append(", ").append("Gender : ").append(this.gender);
        stringBuilder.append(", ").append("Birthday : ").append(this.birthday);
        stringBuilder.append(", ").append("Height : ").append(this.height);
        stringBuilder.append(", ").append("Weight : ").append(this.weight);
        stringBuilder.append(", ").append("TargetWeight : ").append(this.targetWeight);
        stringBuilder.append(", ").append("UserId : ").append(this.uid);
        stringBuilder.append(", ").append("AvatarUrl : ").append(this.avatarUrl);
        stringBuilder.append(", ").append("AvatarSource is Null : ").append(this.avatarSource == null);
        stringBuilder.append(", ").append("Synced : ").append(this.synced);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
