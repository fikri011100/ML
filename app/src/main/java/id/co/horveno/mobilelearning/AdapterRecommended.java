package id.co.horveno.mobilelearning;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by fikriimaduddin on 8/29/17.
 */

public class AdapterRecommended extends RecyclerView.Adapter<AdapterRecommended.ViewHolder> {
    Context context;
    ArrayList<HashMap<String, String>> list_data;


    public AdapterRecommended(RecommendedActivity homeActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = homeActivity;
        this.list_data = list_data;
    }



    @Override
    public AdapterRecommended.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_unrealengine, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterRecommended.ViewHolder holder, int position) {
        final HashMap<String,String>listitem = list_data.get(position);
        holder.nameTextView.setText(list_data.get(position).get("judul_video"));
        holder.duration.setText(list_data.get(position).get("duration"));
        Glide.with(context)
                .load(Helper.imgus + list_data.get(position).get("gambar")+Helper.lanjut)
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent a = new Intent(v.getContext(), PerkatActivity.class);
//                a.putExtra("id_kategori",listitem.get("id_kategori"));
//                v.getContext().startActivity(a);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView duration,nameTextView;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardMoreRecom);
            duration = (TextView)itemView.findViewById(R.id.unreal_descMoreRecom);
            nameTextView= (TextView) itemView.findViewById(R.id.unreal_titleMoreRecom);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewMoreRecom);

        }
    }

}
