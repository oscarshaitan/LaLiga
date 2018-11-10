package com.oscart.laliga;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import Retro.Team;

public class TeamCellAdapter extends RecyclerView.Adapter<TeamCellAdapter.SimpleViewHolder> {

    private Activity activity;
    private List<Team> dataSet;
    private int  height, width;
    private RecyclerItemClickListener recyclerItemClickListener;


    TeamCellAdapter (int height, int width, Activity activity,RecyclerItemClickListener recyclerItemClickListener){
        this.height = height;
        this.width = width;
        this.activity = activity;
        this.dataSet = new ArrayList<>();
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.team_cell, viewGroup, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder viewHolder, final int i) {

        viewHolder.superLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(activity, TeamDetail.class);
                intent.putExtra("TID",""+dataSet.get(i).getIdTeam());
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.goup, R.anim.godown);*/
                recyclerItemClickListener.onItemClick(dataSet.get(i));
            }
        });

        viewHolder.background.setMinimumHeight((int)(height*0.16));
        viewHolder.background.setMinimumWidth((width-20)/3);

        Picasso.get() //
                .load(dataSet.get(i).getStrTeamBadge()) //
                .placeholder(R.drawable.ic_launcher_background) //
                .resize((width-20)/3,(int)(height*0.16))
                //.tag(activity) //
                .into(viewHolder.background);
        viewHolder.team.setText(dataSet.get(i).getStrTeam());
        viewHolder.year.setText(dataSet.get(i).getIntFormedYear());
        viewHolder.stadium.setText(dataSet.get(i).getStrStadium());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public void add(List<Team> dataSet){
        this.dataSet = dataSet;
    }



    public class SimpleViewHolder extends RecyclerView.ViewHolder {
        ImageView background;
        TextView team;
        TextView year;
        TextView stadium;
        CardView superLay;
        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            background = (ImageView)itemView.findViewById(R.id.background);
            team =(TextView)itemView.findViewById(R.id.team);
            year =(TextView)itemView.findViewById(R.id.year);
            stadium =(TextView)itemView.findViewById(R.id.stadium);
            superLay = (CardView)itemView.findViewById(R.id.superLay);
        }
    }
}
