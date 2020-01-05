package com.example.index.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.index.Models.OfferList.OfferIds;
import com.example.index.Models.Tools.Tool;
import com.example.index.R;

import java.util.List;

public class ToolsAdapter extends RecyclerView.Adapter<ToolsAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Tool> toolList;

    private ListenerTool listenerTool;


    public ToolsAdapter(Context context, List<Tool> toolList) {
        this.inflater = LayoutInflater.from(context);
        this.toolList = toolList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_tool, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tool tool = toolList.get(position);
        holder.textView_name.setText(tool.getName()+"");
        holder.textView_price.setText(tool.getPrice()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerTool.recyclerviewOnClick(toolList.get(position).getId());
            }
        });

    }

    public ListenerTool getListenerTool() {
        return listenerTool;
    }

    public void setListenerTool(ListenerTool listenerTool) {
        this.listenerTool = listenerTool;
    }

    @Override
    public int getItemCount() {
        return toolList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView textView_name;
        final TextView textView_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_name = itemView.findViewById(R.id.textView_name_tool);
            textView_price = itemView.findViewById(R.id.textView_price_tool);

        }
    }

    public void dataChanged( List<Tool> toolList){

        this.toolList = toolList;
        notifyDataSetChanged();
    }
}
