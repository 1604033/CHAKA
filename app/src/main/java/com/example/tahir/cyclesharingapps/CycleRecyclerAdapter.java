package com.example.sibbir.cyclesharingapps;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CycleRecyclerAdapter extends RecyclerView.Adapter<CycleRecyclerAdapter.ViewHolder>{
    public ArrayList<CycleItem>arrayList;
    public Context context;

    public CycleRecyclerAdapter(ArrayList<CycleItem> arrayList,Context context) {
        this.arrayList = arrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Vl=LayoutInflater.from(parent.getContext()).inflate(R.layout.cycle_xml,parent,false);

        return new ViewHolder(Vl);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CycleItem bloodItem=arrayList.get(position);
        holder.id.setText(bloodItem.getId());
        holder.location.setText(bloodItem.getLocation());
        holder.phone.setText(bloodItem.getPhoneNumber());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView phone;
        public TextView id;
        public TextView location;
        public ViewHolder(View itemView) {
            super(itemView);
            phone=itemView.findViewById(R.id.phoneId);
            id=itemView.findViewById(R.id.id_id);
            location=itemView.findViewById(R.id.locationId);

        }
    }
}
