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



public class GamingZoneFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        GamingZoneFragment.ContentAdapter adapter = new GamingZoneFragment.ContentAdapter(recyclerView.getContext());
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
//                    intent.putExtra("event_category","gaming_zone");
//                    intent.putExtra(EventDetailsActivity.EXTRA_POSITION, getAdapterPosition());
//                    context.startActivity(intent);
                    Intent gz =new Intent(Intent.ACTION_VIEW, Uri.parse("https://pragyaa.tech/Event/gaming.html"));
                    context.startActivity(gz);

                }
            });
        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Tiles in RecyclerView.
        private Context mContext;
        private ProgressDialog mProgress;

        // 4 images
        private static final String[] images = {
                "https://pragyaa.tech/Event/images/Valorant.png",
                "https://pragyaa.tech/Event/images/Call%20of%20Duty.png",
                "https://pragyaa.tech/Event/images/Free%20Fire.png",

                "https://pragyaa.tech/Event/images/Counter%20Strike-GO.png",
//                "http://s1.1zoom.net/big0/678/360478-AcerSense.jpg",
//
//                "http://www.1zoom.me/big2/57/206206-warlock2.jpg",
//
//                "https://image.redbull.com/rbcom/010/2015-03-21/1331712617330_2/0010/1/1500/1000/1/fifa-15.jpg",
                "https://pragyaa.tech/Event/images/PUBG%20PC%20Lite.png",
        };
        private final String[] eventName;
        public ContentAdapter(Context context) {
            mContext = context;
            Resources resources = context.getResources();
            eventName = resources.getStringArray(R.array.gaming);
            mProgress = new ProgressDialog(mContext);
            mProgress.setMessage("Loading...");

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new GamingZoneFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
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