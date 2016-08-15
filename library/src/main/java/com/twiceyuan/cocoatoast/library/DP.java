package com.twiceyuan.cocoatoast.library;

public class DP {

    public static int dp2px(float dpValue) {
        final float scale = CocoaToast.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(float pxValue) {
        final float scale = CocoaToast.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}