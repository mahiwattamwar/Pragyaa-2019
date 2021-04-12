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


public class Textplorer extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        Textplorer.ContentAdapter adapter = new Textplorer.ContentAdapter(recyclerView.getContext());
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
//                    intent.putExtra("event_category", "textplorer");
//                    intent.putExtra(EventDetailsActivity.EXTRA_POSITION, getAdapterPosition());
//                    context.startActivity(intent);
                    Intent textpl =new Intent(Intent.ACTION_VIEW, Uri.parse("https://pragyaa.tech/Event/texplorer.html"));
                    context.startActivity(textpl);
                }
            });
        }
    }


    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Tiles in RecyclerView.
        private Context mContext;
        private ProgressDialog mProgress;

        // 7 images
        private static final String[] images = {
                "https://pragyaa.tech/Event/images/Styling%20Trends.png",
//                "https://pragyaa.tech/Event/images/Draw%20Your%20Design.png",
                "https://content.instructables.com/ORIG/F65/4FWR/JXOYEPJW/F654FWRJXOYEPJW.jpg?auto=webp&frame=1&width=320&md=90a461c6303d3480ee5c0bb36da64887",
                "https://media.istockphoto.com/vectors/present-your-best-ideas-to-people-and-company-vector-id1070278900?k=6&m=1070278900&s=170667a&w=0&h=EaBnbRzMg3iTOIl5k_Qz5ZujdR3071SbMoSGmIeGUQw=",
//                "https://pragyaa.tech/Event/images/Present%20Your%20Idea.png",
                "https://pragyaa.tech/Event/images/TexQuiz.png",
                "https://pragyaa.tech/Event/images/Style%20your%20Mannequin.png",


        };
        private final String[] eventName;

        public ContentAdapter(Context context) {
            mContext = context;
            Resources resources = context.getResources();
            eventName = resources.getStringArray(R.array.textplorer);
            mProgress = new ProgressDialog(mContext);
            mProgress.setMessage("Loading...");
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Textplorer.ViewHolder(LayoutInflater.from(parent.getContext()), parent);

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
