package cn.com.smartdevices.bracelet.model;

public class StartingUpResInfo {
    private String bg_img_url;
    private long expire_time;
    private int id;
    private String jump_url;
    private long start_time;
    private String title;

    public boolean equals(Object obj) {
        if (!(obj instanceof StartingUpResInfo)) {
            return super.equals(obj);
        }
        StartingUpResInfo startingUpResInfo = (StartingUpResInfo) obj;
        return this.bg_img_url.equals(startingUpResInfo.bg_img_url) && this.start_time == startingUpResInfo.start_time && this.expire_time == startingUpResInfo.expire_time && this.title.equals(startingUpResInfo.title) && this.jump_url.equals(startingUpResInfo.jump_url);
    }

    public String getBg_img_url() {
        return this.bg_img_url;
    }

    public long getExpire_time() {
        return this.expire_time;
    }

    public int getId() {
        return this.id;
    }

    public String getJump_url() {
        return this.jump_url;
    }

    public long getStart_time() {
        return this.start_time;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBg_img_url(String str) {
        this.bg_img_url = str;
    }

    public void setExpire_time(long j) {
        this.expire_time = j;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setJump_url(String str) {
        this.jump_url = str;
    }

    public void setStart_time(long j) {
        this.start_time = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
