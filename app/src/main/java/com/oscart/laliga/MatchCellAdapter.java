package com.oscart.laliga;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Retro.Event;
import Retro.Team;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MatchCellAdapter extends RecyclerView.Adapter<MatchCellAdapter.SimpleViewHolder>  {
    private Activity activity;
    private List<Event> dataSet;
    private int  height, width;

    public MatchCellAdapter(Activity activity, int height, int width) {
        this.activity = activity;
        this.dataSet = new ArrayList<>();
        this.height = height;
        this.width = width;
    }

    @NonNull
    @Override
    public MatchCellAdapter.SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_cell, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchCellAdapter.SimpleViewHolder viewHolder, int i) {


        //Log.d("TD",dataSet.get(i).getIdAwayTeam()+ " VS "+dataSet.get(i).getIdHomeTeam());

        Team away = ((TeamDetail)activity).getTeam(dataSet.get(i).getIdAwayTeam());


        Team home = ((TeamDetail)activity).getTeam(dataSet.get(i).getIdHomeTeam());



        viewHolder.away.setMinimumHeight((int)(width*0.15));
        viewHolder.away.setMinimumWidth((int)(width*0.15));
        viewHolder.home.setMinimumHeight((int)(width*0.15));
        viewHolder.home.setMinimumWidth((int)(width*0.15));
        int newH = (int)(width*0.20);

        if(away!=null){
            Picasso.get() //
                    .load(away.getStrTeamBadge()) //
                    .placeholder(R.drawable.ic_launcher_background) //
                    .resize(newH,newH)
                    .error(R.drawable.soccer)
                    .tag(activity) //
                    .into(viewHolder.away);
        }

        if(home!=null){
            Picasso.get() //
                    .load(home.getStrTeamBadge()) //
                    .placeholder(R.drawable.ic_launcher_background) //
                    .resize(newH,newH)
                    .error(R.drawable.soccer)
                    .tag(activity) //
                    .into(viewHolder.home);
        }
        Toast.makeText(activity, "Some team are not on La Liga list team", Toast.LENGTH_SHORT).show();
        if(home==null){
            Picasso.get() //
                    .load(R.drawable.soccer) //
                    .placeholder(R.drawable.ic_launcher_background) //
                    .resize(newH,newH)
                    .error(R.drawable.soccer)
                    .tag(activity) //
                    .into(viewHolder.home);
        }
        if(away==null){
            Picasso.get() //
                    .load(R.drawable.soccer) //
                    .placeholder(R.drawable.ic_launcher_background) //
                    .resize(newH,newH)
                    .error(R.drawable.soccer)
                    .tag(activity) //
                    .into(viewHolder.away);
        }

        //hay partidos donde uno de lso equips ono pertenece a la liga y adicional tienen la fecha en null



        viewHolder.teamAway.setText(dataSet.get(i).getStrAwayTeam());
        viewHolder.teamHome.setText(dataSet.get(i).getStrHomeTeam());
        viewHolder.date.setText(dataSet.get(i).getStrDate());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {
        ImageView away, home;
        TextView teamAway,teamHome,date;
        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            away = (ImageView)itemView.findViewById(R.id.away);
            home = (ImageView)itemView.findViewById(R.id.home);
            teamAway = (TextView)itemView.findViewById(R.id.teamAway);
            teamHome = (TextView)itemView.findViewById(R.id.teamHome);
            date = (TextView)itemView.findViewById(R.id.date);
        }
    }

    public void add(List<Event> dataSet){
        this.dataSet = dataSet;
    }
}
