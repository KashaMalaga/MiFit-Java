package com.xiaomi.hm.health.a;

import com.xiaomi.hm.health.g;

public final class j {
    public static final int[] CustomViewPager;
    public static final int CustomViewPager_swipeable = 0;
    public static final int[] DimPanelFragmentBottomBar = new int[]{g.left_text, g.right_text, g.left_text_color, g.right_text_color, g.show_style};
    public static final int DimPanelFragmentBottomBar_left_text = 0;
    public static final int DimPanelFragmentBottomBar_left_text_color = 2;
    public static final int DimPanelFragmentBottomBar_right_text = 1;
    public static final int DimPanelFragmentBottomBar_right_text_color = 3;
    public static final int DimPanelFragmentBottomBar_show_style = 4;

    static {
        int[] iArr = new int[DimPanelFragmentBottomBar_right_text];
        iArr[DimPanelFragmentBottomBar_left_text] = g.swipeable;
        CustomViewPager = iArr;
    }
}
