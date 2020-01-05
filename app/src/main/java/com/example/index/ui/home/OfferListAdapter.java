package com.example.index.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.index.Models.OfferList.OfferIds;
import com.example.index.R;

import java.util.List;

public class OfferListAdapter extends RecyclerView.Adapter<OfferListAdapter.ViewHolder> {

    private static final String TAG = "OfferListAdapter";

    private LayoutInflater inflater;
    private List<OfferIds> offerIdsList;
    private int color_tableDarkOfferlist, color_tableLightOfferlist;

    public OfferListAdapter(Context context, List<OfferIds> offerIdsList) {
        this.inflater = LayoutInflater.from(context);
        this.offerIdsList = offerIdsList;
        color_tableDarkOfferlist = context.getResources().getColor(R.color.tableDarkOfferlist);
        color_tableLightOfferlist = context.getResources().getColor(R.color.tableLightOfferlist);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_offerlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OfferIds offerIds = offerIdsList.get(position);
        holder.textView_note.setText(offerIds.getNotes()+"");
        holder.textView_price.setText(offerIds.getPrice()+"");



        if (position%2==0){
            holder.cardView.setBackgroundColor(color_tableDarkOfferlist);

        }else{
            holder.cardView.setBackgroundColor(color_tableLightOfferlist);

        }

    }

    @Override
    public int getItemCount() {

        return offerIdsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final CardView cardView;
        final TextView textView_note;
        final TextView textView_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_note = itemView.findViewById(R.id.textView_note);
            textView_price = itemView.findViewById(R.id.textView_price);
            cardView = itemView.findViewById(R.id.cardView_offer);
        }
    }

    public void dataChanged( List<OfferIds> offerIdsList){

        this.offerIdsList = offerIdsList;
        notifyDataSetChanged();
    }
}
