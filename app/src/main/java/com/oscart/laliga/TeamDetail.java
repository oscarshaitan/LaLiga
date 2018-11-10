package com.oscart.laliga;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import Retro.PostDataService;
import Retro.RetroTeamEventList;
import Retro.RetrofitClientInstance;
import Retro.Team;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import presenter.DetailP;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDetail extends AppCompatActivity implements DetailP.DetailPresenter {
    private DetailP detailP;
    private String TID;
    private Toolbar toolbar;
    private ImageView banner;
    private TextView stadium;
    private TextView year;
    private ImageView jersey;
    private ImageView badge;
    private ImageView web;
    private ImageView fb;
    private ImageView twtr;
    private ImageView inst;
    private ImageView ytb;
    private TextView descrip;
    private int height;
    private int width;
    private MatchCellAdapter adapter;
    private GridLayoutManager gridLayoutManager;
    private DBFunctions DBFunc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);
        Bundle bundle = getIntent().getExtras();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        assert bundle != null;
        TID = bundle.getString("TID");
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        banner = (ImageView)findViewById(R.id.banner);
        stadium = (TextView)findViewById(R.id.stadium);
        year = (TextView)findViewById(R.id.year);
        jersey = (ImageView)findViewById(R.id.jersey);
        badge = (ImageView)findViewById(R.id.badge);
        descrip = (TextView)findViewById(R.id.description);

        web = (ImageView)findViewById(R.id.web);
        fb = (ImageView)findViewById(R.id.fb);
        twtr = (ImageView)findViewById(R.id.twtr);
        inst = (ImageView)findViewById(R.id.inst);
        ytb = (ImageView)findViewById(R.id.ytb);




        DBFunc = new DBFunctions(this);
        detailP = new DetailP(this);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        detailP.setLanguageToFill(prefs.getString("Langague","EN"));
        gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        onConfigurationChanged(getResources().getConfiguration());
        RecyclerView recycler = (RecyclerView)findViewById(R.id.recycler);
        recycler.setLayoutManager(gridLayoutManager);
        adapter = new MatchCellAdapter(this,height,width);
        recycler.setAdapter(adapter);
        detailP.getMatchs();
    }

    @Override
    public void fillGeneral() {
        DBFunctions DBFunc = new DBFunctions(this);
        final Team team = DBFunc.getTeam(TID);
        toolbar.setTitle(team.getStrTeam());
        stadium.setText(team.getStrStadium());
        year.setText(team.getIntFormedYear());


        Picasso.get()
                .load(team.getStrTeamBanner()+"/preview")
                .placeholder(R.color.colorPrimary)
                .tag(getApplicationContext())
                .into(banner);

        Picasso.get()
                .load(team.getStrTeamJersey())
                .placeholder(R.drawable.ic_launcher_background)
                .resize(width/2,width/2)
                .tag(getApplicationContext())
                .into(jersey);

        Picasso.get()
                .load(team.getStrTeamBadge())
                .placeholder(R.drawable.ic_launcher_background)
                .resize(width/2,width/2)
                .tag(getApplicationContext())
                .into(badge);

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!team.getStrWebsite().isEmpty()){
                    String url = (team.getStrWebsite().contains("https://"))? team.getStrWebsite():"https://"+team.getStrWebsite();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    overridePendingTransition(R.anim.goup, R.anim.godown);
                }
                else Toast.makeText(TeamDetail.this, "No Website Available", Toast.LENGTH_SHORT).show();
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!team.getStrFacebook().isEmpty()){
                    String url = (team.getStrFacebook().contains("https://"))? team.getStrFacebook():"https://"+team.getStrFacebook();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    overridePendingTransition(R.anim.goup, R.anim.godown);
                }
                else Toast.makeText(TeamDetail.this, "No Facebook Available", Toast.LENGTH_SHORT).show();
            }
        });

        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!team.getStrInstagram().isEmpty()){
                    String url = (team.getStrInstagram().contains("https://"))? team.getStrInstagram():"https://"+team.getStrInstagram();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    overridePendingTransition(R.anim.goup, R.anim.godown);
                }
                else Toast.makeText(TeamDetail.this, "No Instagram Available", Toast.LENGTH_SHORT).show();
            }
        });

        twtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!team.getStrTwitter().isEmpty()){
                    String url = (team.getStrTwitter().contains("https://"))? team.getStrTwitter():"https://"+team.getStrTwitter();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    overridePendingTransition(R.anim.goup, R.anim.godown);
                }
                else Toast.makeText(TeamDetail.this, "No Twitter Available", Toast.LENGTH_SHORT).show();
            }
        });

        ytb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!team.getStrYoutube().isEmpty()){
                    String url = (team.getStrYoutube().contains("https://"))? team.getStrYoutube():"https://"+team.getStrYoutube();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    overridePendingTransition(R.anim.goup, R.anim.godown);
                }
                else Toast.makeText(TeamDetail.this, "No Youtube Available", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void fillMatchs() {
        final PostDataService service = RetrofitClientInstance.getRetrofitInstance(getApplicationContext()).create(PostDataService.class);

        Call<RetroTeamEventList> eventListCall = service.getTeamEvents("1",TID);
        eventListCall.enqueue(new Callback<RetroTeamEventList>() {
            @Override
            public void onResponse(Call<RetroTeamEventList> call, final Response<RetroTeamEventList> response) {
                assert response.body() != null;
                adapter.add(response.body().getEvents());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<RetroTeamEventList> call, Throwable t) {

            }
        });

    }

    @Override
    public void fillSpanish() {
        DBFunctions DBFunc = new DBFunctions(this);
        final Team team = DBFunc.getTeam(TID);
        descrip.setText(team.getStrDescriptionES());
    }

    @Override
    public void fillEnglish() {
        DBFunctions DBFunc = new DBFunctions(this);
        final Team team = DBFunc.getTeam(TID);
        descrip.setText(team.getStrDescriptionEN());
    }

    @Override
    public Team getTeam(String TID) {
        return DBFunc.getTeam(TID);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            gridLayoutManager.setSpanCount(3);
        }
        else {
            gridLayoutManager.setSpanCount(2);
        }
        /*
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;*/
    }


}
