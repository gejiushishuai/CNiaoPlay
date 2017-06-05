package com.chhd.per_library.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DensityUtil {

    public static int dip2px(float dpValue) {
        float scale = UiUtils.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int dip2sp(float dpValue) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue,
                UiUtils.getResources().getDisplayMetrics()));
    }

    public static int px2dip(float pxValue) {
        float scale = UiUtils.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static int px2sp(float pxValue) {
        float fontScale = UiUtils.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }


    public static int sp2px(float spValue) {
        float fontScale = UiUtils.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int sp2dip(float spValue) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue,
                UiUtils.getResources().getDisplayMetrics()));
    }

    public static int getScreenW() {
        return UiUtils.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenH() {
        return UiUtils.getResources().getDisplayMetrics().heightPixels;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static int getScreenRealH() {
        int h;
        WindowManager winMgr = (WindowManager) UiUtils.getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = winMgr.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealMetrics(dm);
            h = dm.heightPixels;
        } else {
            try {
                Method method = Class.forName("android.view.Display")
                        .getMethod("getRealMetrics", DisplayMetrics.class);
                method.invoke(display, dm);
                h = dm.heightPixels;
            } catch (Exception e) {
                display.getMetrics(dm);
                h = dm.heightPixels;
            }
        }
        return h;
    }

    public static int getStatusBarH() {
        Class<?> c;
        Object obj;
        Field field;
        int statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = UiUtils.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    public static int getNavigationBarrH() {
        Resources resources = UiUtils.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return resources.getDimensionPixelOffset(identifier);
    }
}
