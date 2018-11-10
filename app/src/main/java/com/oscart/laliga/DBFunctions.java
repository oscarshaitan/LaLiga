package com.oscart.laliga;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

import java.util.List;

import Retro.DaoMaster;
import Retro.DaoSession;
import Retro.EventDao;
import Retro.RetroTeamList;
import Retro.Team;
import Retro.TeamDao;

public class DBFunctions {

    private TeamDao teamDao;
    private EventDao eventDao;


    private Context context;
    public DBFunctions(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "LaLiga-db");

        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        teamDao = daoSession.getTeamDao();
        eventDao = daoSession.getEventDao();
        this.context = context;
    }


    public void saveTeams(RetroTeamList list){
        for (Team team : list.getTeams()) {
            teamDao.insertOrReplace(team);
        }
    }
    public void saveTeam(Team team){
        teamDao.insertOrReplace(team);
    }

    public List<Team> getTeams(){
        return teamDao.loadAll();
    }

    public Team getTeam(String TID){
        return teamDao.load(TID);
    }


}
