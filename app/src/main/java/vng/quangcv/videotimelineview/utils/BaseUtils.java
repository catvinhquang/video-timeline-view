package vng.quangcv.videotimelineview.utils;

import android.content.Context;

public class BaseUtils {

    private static Context context;

    /**
     * init in Application
     *
     * @param ctx
     */
    public static void init(Context ctx) {
        BaseUtils.context = ctx;

        //something to do...


    }

    public static Context getContext() {
        return context;
    }
}
