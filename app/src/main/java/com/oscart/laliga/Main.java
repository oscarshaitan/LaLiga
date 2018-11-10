package com.oscart.laliga;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Retro.Team;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import presenter.MainP;

public class Main extends AppCompatActivity implements MainP.MainPresenter {
    private DBFunctions DBFunc;
    private MainP mainP;
    private TeamCellAdapter adapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBFunc = new DBFunctions(this);
        mainP = new MainP(this);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;


        RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
            @Override
            public void onItemClick(Team team) {
                Intent intent = new Intent(Main.this, TeamDetail.class);
                intent.putExtra("TID",""+team.getIdTeam());
                startActivity(intent);
                overridePendingTransition(R.anim.goup, R.anim.godown);
            }
        };


        gridLayoutManager = new GridLayoutManager(this,3);
        onConfigurationChanged(getResources().getConfiguration());
        RecyclerView recycler = (RecyclerView)findViewById(R.id.recycler);
        recycler.setLayoutManager(gridLayoutManager);
        adapter = new TeamCellAdapter(height,width,this,recyclerItemClickListener);
        mainP.getData();

        recycler.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainP.selectLanguage();
            }
        });
    }

    @Override
    public void selectLanguage(){
        final List<String> language = new ArrayList<>();
        language.add("Español");
        language.add("English");
        MaterialDialog materialDialog = new MaterialDialog.Builder(this)
                .title("Select a language")
                .items(language)
                .positiveText("Ok")
                .choiceWidgetColor(getResources().getColorStateList(R.color.colorPrimary))
                .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = prefs.edit();
                        if(dialog.getSelectedIndex()==0){
                            editor.putString("Langague","ES");
                        }
                        else if(dialog.getSelectedIndex()==1){
                            editor.putString("Langague","EN");
                        }
                        editor.apply();
                        return false;
                    }
                })
                .show();
    }

    @Override
    public void getTeamFromDB() {
         adapter.add(DBFunc.getTeams());
         adapter.notifyDataSetChanged();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            gridLayoutManager.setSpanCount(5);
        }
        else {
            gridLayoutManager.setSpanCount(3);
        }
        /*
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;*/
    }

    @Override
    public void onBackPressed() {

    }


}
