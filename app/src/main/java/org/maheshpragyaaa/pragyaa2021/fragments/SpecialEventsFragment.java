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



public class SpecialEventsFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        SpecialEventsFragment.ContentAdapter adapter = new SpecialEventsFragment.ContentAdapter(recyclerView.getContext());
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
//                    intent.putExtra("event_category", "special_events");
//                    intent.putExtra(EventDetailsActivity.EXTRA_POSITION, getAdapterPosition());
//                    context.startActivity(intent);
                    Intent onl =new Intent(Intent.ACTION_VIEW, Uri.parse("https://pragyaa.tech/Event/creative-events.html"));
                    context.startActivity(onl);
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

        // 7 images
        private static final String[] images = {
//                "https://i.ytimg.com/vi/HT9aa2vqS1w/maxresdefault.jpg",
//                "https://firebasestorage.googleapis.com/v0/b/pragyaa2017-d7e2d.appspot.com/o/Junkyard-Wars.jpg?alt=media&token=d912bec6-eb43-4610-a93e-e8fc538415be",
//                "https://firebasestorage.googleapis.com/v0/b/pragyaa2017-d7e2d.appspot.com/o/Junkyard-Wars.jpg?alt=media&token=d912bec6-eb43-4610-a93e-e8fc538415be",
//                "https://firebasestorage.googleapis.com/v0/b/pragyaa2017-d7e2d.appspot.com/o/Junkyard-Wars.jpg?alt=media&token=d912bec6-eb43-4610-a93e-e8fc538415be",
//
//                "https://p.globalsources.com/IMAGES/PDT/BIG/876/B0858358876.jpg",
//                "http://www.afnews.info/public/moise/AstroQuizG-450.jpg",
//                "https://3.bp.blogspot.com/-bFnPLqnavc4/T-2ABL0WeMI/AAAAAAAAAsE/SHlhLSZshJI/s1600/scan0019.jpg",
//                "http://mcoet.mauligroup.org/ignite18/images/mock-placement.jpg",
//                "http://www.dream-wallpaper.com/free-wallpaper/cartoon-wallpaper/vector-technology-1-wallpaper/1600x1200/free-wallpaper-8.jpg",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
                "https://pragyaa.tech/Event/images/mockplacement.png",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
//                "data:image/jpeg;base64,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",
//               "https://pragyaa.tech/Event/images/knowledgehunt.png",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
                "https://pragyaa.tech/Event/images/knowledgehunt.png",
                "https://pragyaa.tech/Event/images/hunkybrains.png",
                "https://pragyaa.tech/Event/images/BMLA.png",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",
//                "https://www.scientificamerican.com/sciam/cache/file/8BB1A7D9-275E-4336-984D329C1A25C8FF.jpg?w=590&h=393&A47683A1-0624-4756-8DD1F186514539D2",

"https://pragyaa.tech/Event/images/readathon.png",
"https://pragyaa.tech/Event/images/spacebuzz.png",
                "https://pragyaa.tech/Event/images/juniorscientist.png",
                "https://pragyaa.tech/Event/images/talkingpen.png",
                "https://pragyaa.tech/Event/images/clearyourlense.png",
                "https://pragyaa.tech/Event/images/animationexpress.png",
                "https://pragyaa.tech/Event/images/beanentrepreneur.png",
                "https://pragyaa.tech/Event/images/facethenantion.png",
//                "https://cdn.makeuseof.com/wp-content/uploads/2013/01/camera-lens-670x335.jpg",
//                "https://www.tonetag.com/resources/wp-content/uploads/2016/01/StartUp-01-1.jpg",
        };
        private final String[] eventName;

        public ContentAdapter(Context context) {
            mContext = context;
            Resources resources = context.getResources();
            eventName = resources.getStringArray(R.array.specialevents);
            mProgress = new ProgressDialog(mContext);
            mProgress.setMessage("Loading...");
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SpecialEventsFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
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
