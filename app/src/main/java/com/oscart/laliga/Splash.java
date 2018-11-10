package com.oscart.laliga;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import Retro.PostDataService;
import Retro.RetroTeamList;
import Retro.RetrofitClientInstance;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends AppCompatActivity {
    private PostDataService service;

    private DBFunctions DBFunc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        DBFunc = new DBFunctions(this);
        service = RetrofitClientInstance.getRetrofitInstance(getApplicationContext()).create(PostDataService.class);
        getTeams();
        animation();
    }


    public void getTeams(){
        Call<RetroTeamList> teamListCall = (Call<RetroTeamList>)service.getTeams("1","4335");
        teamListCall.enqueue(new Callback<RetroTeamList>() {
            @Override
            public void onResponse(Call<RetroTeamList> call, Response<RetroTeamList> response) {
                DBFunc.saveTeams(response.body());
                startApp();
            }

            @Override
            public void onFailure(Call<RetroTeamList> call, Throwable t) {
                Toast.makeText(Splash.this, "Someing went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startApp(){
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
        overridePendingTransition(R.anim.goup, R.anim.godown);
    }

    private void animation(){
        YoYo.with(Techniques.BounceInUp)
                .duration(1000)
                .repeat(5)
                .playOn(findViewById(R.id.soccer));
    }
}
