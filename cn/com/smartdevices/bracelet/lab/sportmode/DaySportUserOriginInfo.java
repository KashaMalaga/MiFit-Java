package cn.com.smartdevices.bracelet.lab.sportmode;

import java.util.ArrayList;
import java.util.List;

public class DaySportUserOriginInfo extends DaySportOriginInfo {
    private List<LabFactoryActiveItem> mActiveItemList;

    public DaySportUserOriginInfo(int i) {
        super(i);
        this.mActiveItemList = null;
        this.mActiveItemList = new ArrayList();
    }

    public void addActiveItem(LabFactoryActiveItem labFactoryActiveItem) {
        this.mActiveItemList.add(labFactoryActiveItem);
    }

    public List<LabFactoryActiveItem> getActiveItemList() {
        return this.mActiveItemList;
    }

    public void release() {
        if (this.mActiveItemList != null) {
            this.mActiveItemList.clear();
        }
    }

    public void removeActiveItem(LabFactoryActiveItem labFactoryActiveItem) {
        this.mActiveItemList.remove(labFactoryActiveItem);
    }
}
