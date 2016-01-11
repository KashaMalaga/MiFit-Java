package cn.com.smartdevices.bracelet.eventbus;

import cn.com.smartdevices.bracelet.weight.UserInfo;

public class EventUserInfoUpdate {
    public UserInfo info;

    public EventUserInfoUpdate(UserInfo userInfo) {
        this.info = userInfo;
    }

    public UserInfo getInfo() {
        return this.info;
    }
}
