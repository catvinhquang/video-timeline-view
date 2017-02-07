//package vng.quangcv.videotimelineview;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TimelineAdapter extends RecyclerView.Adapter {
//
//    private Context context;
//    private List<Bitmap> imageList;
//
//    public TimelineAdapter(Context context) {
//        this.context = context;
//
//        imageList = new ArrayList<>();
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(context);
//        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
//        return new ItemHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        ImageView imageView = ((ItemHolder) holder).imageView;
//        imageView.setImageBitmap(imageList.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return imageList.size();
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return position;
//    }
//
//    public class ItemHolder extends RecyclerView.ViewHolder {
//        public ImageView imageView;
//
//        public ItemHolder(View itemView) {
//            super(itemView);
//            imageView = (ImageView) itemView.findViewById(R.id.image_view);
//        }
//    }
//
//}
