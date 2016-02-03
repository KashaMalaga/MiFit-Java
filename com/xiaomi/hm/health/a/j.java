package com.xiaomi.hm.health.a;

import com.xiaomi.hm.health.R;

public final class j {
    public static final int[] CustomViewPager;
    public static final int CustomViewPager_swipeable = 0;
    public static final int[] DimPanelFragmentBottomBar = new int[]{R.attr.left_text, R.attr.right_text, R.attr.left_text_color, R.attr.right_text_color, R.attr.show_style};
    public static final int DimPanelFragmentBottomBar_left_text = 0;
    public static final int DimPanelFragmentBottomBar_left_text_color = 2;
    public static final int DimPanelFragmentBottomBar_right_text = 1;
    public static final int DimPanelFragmentBottomBar_right_text_color = 3;
    public static final int DimPanelFragmentBottomBar_show_style = 4;

    static {
        int[] iArr = new int[DimPanelFragmentBottomBar_right_text];
        iArr[DimPanelFragmentBottomBar_left_text] = R.attr.swipeable;
        CustomViewPager = iArr;
    }
}
