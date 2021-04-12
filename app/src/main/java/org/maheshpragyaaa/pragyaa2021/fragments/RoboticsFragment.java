package org.maheshpragyaaa.pragyaa2021.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.maheshpragyaaa.pragyaa2021.EventDetailsActivity;
import org.maheshpragyaaa.pragyaa2021.R;



public class RoboticsFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        // Set padding for Tiles
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.vsm_keyLines);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;

        public ViewHolder(final LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_event, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.tile_picture);
            name = (TextView) itemView.findViewById(R.id.tile_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
//                    Intent intent = new Intent(context, EventDetailsActivity.class);
//                    intent.putExtra("image",ContentAdapter.images[getAdapterPosition()]);
//                    intent.putExtra("event_category","robotics");
//                    intent.putExtra(EventDetailsActivity.EXTRA_POSITION, getAdapterPosition());
//                    context.startActivity(intent);

                    Intent robo =new Intent(Intent.ACTION_VIEW, Uri.parse("https://pragyaa.tech/Event/robotics.html"));
                    context.startActivity(robo);
                }
            });
        }
    }


    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Tiles in RecyclerView.
        private Context mContext;
        private ProgressDialog mProgress;

        // 4 images
        private static final String[] images = {

                "https://pragyaa.tech/Event/images/My%20Ink.png",
//                "https://www.eprlabs.com/wp-content/uploads/2017/09/Arduino-Line-Follower-Robot-Image-9-760x440.jpg",
//                "http://www.robosoftsystems.co.in/roboshop/media/catalog/product/cache/1/image/500x500/9df78eab33525d08d6e5fb8d27136e95/m/o/mobile_robotic_arm_total_assembly.jpg",
//                "http://www.sporttechie.com/wp-content/uploads/2015/08/soccer1.jpg",
                "https://pragyaa.tech/Event/images/The%20Junkyard.png",
                "https://pragyaa.tech/Event/images/The%20Soft-War.png",
//                "https://s3-eu-central-1.amazonaws.com/centaur-wp/theengineer/prod/content/uploads/2017/04/06174529/drone-racing.jpg",


        };
        private final String[] eventName;

        public ContentAdapter(Context context) {
            mContext = context;
            Resources resources = context.getResources();
            eventName = resources.getStringArray(R.array.robotics);
            mProgress = new ProgressDialog(mContext);
            mProgress.setMessage("Loading...");
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RoboticsFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            mProgress.show();
            Picasso.with(mContext).load(images[position]).into(holder.picture);
            holder.name.setText(eventName[position % eventName.length]);
            mProgress.dismiss();
        }

        @Override
        public int getItemCount() {
            return images.length;
        }
    }
}
