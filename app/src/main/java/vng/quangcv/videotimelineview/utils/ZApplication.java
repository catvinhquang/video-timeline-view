package vng.quangcv.videotimelineview.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by Quang Cat on 2/8/2017.
 */

public class ZApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BaseUtils.init(this);
    }

}