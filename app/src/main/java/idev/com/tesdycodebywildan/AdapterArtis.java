package idev.com.tesdycodebywildan;


import android.content.Context;

import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdapterArtis extends RecyclerView.Adapter<AdapterArtis.ArtisViewHolder> {
    private Context context;
    private ArrayList<ModelArtis> dataArtis = new ArrayList<>();

    public AdapterArtis(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ArtisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_artist, parent, false);
        return new ArtisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtisViewHolder holder, int position) {
        final ModelArtis modelArtis = dataArtis.get(position);
        Picasso.with(context).load(modelArtis.getImage()).fit().into(holder.image);
        holder.namaArtis.setText(modelArtis.getName());
        holder.tglLahir.setText("Date Of Birth : " + Utils.dateFormatter(modelArtis.getDob()));

        //click
        holder.itemClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("data", modelArtis);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataArtis.size();
    }

    public void addDataArtis(ModelArtis modelArtis) {
        dataArtis.add(modelArtis);
        notifyDataSetChanged();
    }

    public ArrayList<ModelArtis> getDataArtis() {
        return dataArtis;
    }

    class ArtisViewHolder extends RecyclerView.ViewHolder {
        public TextView namaArtis, tglLahir;
        public ImageView image;
        public View itemClick;

        public ArtisViewHolder(View itemView) {
            super(itemView);

            namaArtis = itemView.findViewById(R.id.txtNamaArtis);
            tglLahir = itemView.findViewById(R.id.txtTanggalLahir);
            image = itemView.findViewById(R.id.gambarArtis);
            itemClick = itemView.findViewById(R.id.layoutClick);
        }

    }

}
