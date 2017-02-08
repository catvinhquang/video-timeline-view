package vng.quangcv.videotimelineview;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int VIDEO_MAX_DURATION = 15;

    VideoTrimmerView trimmerView;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        trimmerView = (VideoTrimmerView) findViewById(R.id.trimmer_view);
        trimmerView.setMaxDuration(VIDEO_MAX_DURATION);
        trimmerView.setVideoURI(Uri.parse("/storage/emulated/0/sample.mp4"));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        trimmerView.onPause();
        trimmerView.setRestoreState(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        trimmerView.destroy();
    }

}
