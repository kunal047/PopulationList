package rusk.com.popoulationlist;

/**
 * Created by kunal on 17-06-2017.
 */

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import rusk.com.popoulationlist.model.WorldPopulation;


public class WorldPopulationAdapter extends RecyclerView.Adapter<WorldPopulationAdapter.WorldPopulationViewHolder> {

    private ArrayList<WorldPopulation> mWorldPopulationList;
    private Context mContext;

    public WorldPopulationAdapter(Context context, ArrayList<WorldPopulation> worldPopulationList) {
        mContext = context;
        mWorldPopulationList = worldPopulationList;
    }

    @Override
    public WorldPopulationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        WorldPopulationViewHolder worldPopulationViewHolder = new WorldPopulationViewHolder(view);
        return worldPopulationViewHolder;

    }

    @Override
    public void onBindViewHolder(WorldPopulationViewHolder holder, int position) {

        WorldPopulation worldPopulation = mWorldPopulationList.get(position);
        Glide.with(holder.imageViewFlag.getContext()).load(worldPopulation.getFlag()).into(holder.imageViewFlag);
        holder.textViewCountry.setText(worldPopulation.getRank() + ") " + worldPopulation.getCountry());
        holder.textViewPopulation.setText(worldPopulation.getPopulation());

    }

    @Override
    public int getItemCount() {
        return mWorldPopulationList.size();
    }

    public class WorldPopulationViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewFlag;
        TextView textViewCountry, textViewPopulation;

        public WorldPopulationViewHolder(View itemView) {
            super(itemView);
            imageViewFlag = (ImageView) itemView.findViewById(R.id.imageViewFlag);
            textViewCountry = (TextView) itemView.findViewById(R.id.textViewCountry);
            textViewPopulation = (TextView) itemView.findViewById(R.id.textViewPopulation);
            mContext = itemView.getContext();
            imageViewFlag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    WorldPopulation worldPopulation = mWorldPopulationList.get(position);
                    showImage(worldPopulation.getFlag());

//                    Intent intent = new Intent(mContext, FullImageViewActivity.class);
//                    intent.putExtra("image_url", worldPopulation.getFlag());
//                    mContext.startActivity(intent);
                }
            });

        }
    }

    public void showImage(String imageUrl) {
        Dialog builder = new Dialog(mContext, android.R.style.Theme_Light);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.BLACK));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });

        ImageView imageView = new ImageView(mContext);
        Glide.with(mContext).load(imageUrl).into(imageView);

        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();
    }

}
