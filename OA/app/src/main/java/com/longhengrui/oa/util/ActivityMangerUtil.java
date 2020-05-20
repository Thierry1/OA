package com.longhengrui.oa.util;

import android.app.Activity;
import android.content.Intent;

public class ActivityMangerUtil {
    public static <T> void startActivity(Activity context, Class<T> clazz, boolean isfinish) {
        context.startActivity(new Intent(context, clazz));
        if (isfinish) {
            context.finish();
        }
    }

}
