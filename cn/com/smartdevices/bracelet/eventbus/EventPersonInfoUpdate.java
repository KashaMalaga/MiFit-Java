package cn.com.smartdevices.bracelet.eventbus;

public class EventPersonInfoUpdate {
    public static final String UPDATE_AVATAR = "update_avatar";
    public String type;

    public EventPersonInfoUpdate(String str) {
        this.type = str;
    }
}
