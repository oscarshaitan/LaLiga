package Retro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PostDataService {

    @GET("{api_key}/lookup_all_teams.php")
    Call<RetroTeamList> getTeams(@Path("api_key") String api_key, @Query("id") String liga_id);

    @GET("{api_key}/lookupteam.php")
    Call<Team> getTeamDetail(@Path("api_key") String api_key, @Query("id") String liga_id);

    @GET("{api_key}/eventsnext.php")
    Call<RetroTeamEventList> getTeamEvents(@Path("api_key") String api_key, @Query("id") String liga_id);

}
