package vng.quangcv.videotimelineview;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Quang Cat on 2/7/2017.
 */

public class VideoTimelineView extends RecyclerView {

    private MediaMetadataRetriever mmr;
    private ArrayList<Bitmap> imageList;

    private int itemWidth = 200;
    private int width;
    private int height;

    public VideoTimelineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // Lấy thông số thiết lập trong file xml
        int[] attrsArray = new int[]{
                android.R.attr.layout_width,
                android.R.attr.layout_height
        };
        TypedArray ta = context.obtainStyledAttributes(attrs, attrsArray);
        width = ta.getLayoutDimension(0, ViewGroup.LayoutParams.MATCH_PARENT);
        height = ta.getLayoutDimension(1, ViewGroup.LayoutParams.MATCH_PARENT);
        ta.recycle();


        mmr = new MediaMetadataRetriever();
        imageList = new ArrayList<>();

        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        setLayoutManager(llm);
        setAdapter(new TimelineAdapter());
    }

    public void setVideoPath(String path) {
        if (path.equals("")) {
            try {
                AssetFileDescriptor afd = getContext().getAssets().openFd("sample.mp4");
                mmr.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            mmr.setDataSource(path);
        }
        renewImageList();
    }

    private void renewImageList() {
        imageList.clear();

        long microSecond = 0;
        Bitmap frame = mmr.getFrameAtTime(microSecond);
        while (frame != null) {
            float r = (float) height / frame.getHeight();
            Bitmap scaledFrame = Bitmap.createScaledBitmap(frame,
                    Math.round(frame.getWidth() * r), Math.round(frame.getHeight() * r), false);
            imageList.add(scaledFrame);
            frame.recycle();

            microSecond += 2 * 1000 * 1000;
            frame = mmr.getFrameAtTime(microSecond);
        }
    }

    public class TimelineAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new LayoutParams(itemWidth,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return new ItemHolder(imageView);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ImageView imageView = (ImageView) ((ItemHolder) holder).itemView;
            imageView.setImageBitmap(imageList.get(position));
        }

        @Override
        public int getItemCount() {
            return imageList.size();
        }

        public class ItemHolder extends RecyclerView.ViewHolder {
            public ItemHolder(View itemView) {
                super(itemView);
            }
        }

    }

}
