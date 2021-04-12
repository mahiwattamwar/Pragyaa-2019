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


public class Coding extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        Coding.ContentAdapter adapter = new Coding.ContentAdapter(recyclerView.getContext());
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

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_event, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.tile_picture);
            name = (TextView) itemView.findViewById(R.id.tile_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
//                    Intent intent = new Intent(context, EventDetailsActivity.class);
//                    intent.putExtra("image", ContentAdapter.images[getAdapterPosition()]);
//                    intent.putExtra("event_category", "coding");
//                    intent.putExtra(EventDetailsActivity.EXTRA_POSITION, getAdapterPosition());
//                    context.startActivity(intent);
                    Intent cd =new Intent(Intent.ACTION_VIEW, Uri.parse("https://pragyaa.tech/Event/codester.html"));
                    context.startActivity(cd);
                }
            });
        }
    }


    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Tiles in RecyclerView.
        private Context mContext;
        private ProgressDialog mProgress;

        // 3 images
        private static final String[] images = {
//                "https://cdn.makeuseof.com/wp-content/uploads/2017/09/c-programming-example-code.jpg",
//                "http:/microcon.jpg",
//                "http://www3.imperial.ac.uk/newseventsimages?p_image_type=mainnews2012&p_image_id=25253",
//                "https://cdn.makeuseof.com/wp-content/uploads/2017/09/c-programming-example-code.jpg",
                "https://pragyaa.tech/Event/images/reversecode.png",
                "https://pragyaa.tech/Event/images/encryption.png",

                "https://pragyaa.tech/Event/images/pacethecode.png",

                "https://pragyaa.tech/Event/images/runtimeerror.png",

                "https://pragyaa.tech/Event/images/codetalk.png",

        };
        private final String[] eventName;

        public ContentAdapter(Context context) {
            mContext = context;
            Resources resources = context.getResources();
            eventName = resources.getStringArray(R.array.coding);
            mProgress = new ProgressDialog(mContext);
            mProgress.setMessage("Loading...");
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Coding.ViewHolder(LayoutInflater.from(parent.getContext()), parent);

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
