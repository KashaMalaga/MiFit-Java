package cn.com.smartdevices.bracelet.eventbus;

public interface EventWeibo {

    public class BindWeiboHealthState {
        public static final int BIND_ERROR = 2;
        public static final int BIND_OK = 1;
        public static final int UNBIND_ERROR = 4;
        public static final int UNBIND_OK = 3;
        public int state;
    }
}
