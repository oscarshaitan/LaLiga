package presenter;

import java.io.IOException;

import Retro.Team;

public class DetailP {

    private DetailP.DetailPresenter detailPresenter;

    public DetailP(DetailP.DetailPresenter detailPresenter){
        this.detailPresenter = detailPresenter;
    }

    public  void getMatchs(){
        detailPresenter.fillMatchs();
    }
    public void setLanguageToFill(String languague){
        detailPresenter.fillGeneral();
        switch (languague){
            case "EN":
                detailPresenter.fillEnglish();
                break;
            case "ES":
                detailPresenter.fillSpanish();
                break;
            default:
                detailPresenter.fillEnglish();
        }

    }

    public interface DetailPresenter{
        void fillGeneral();
        void fillMatchs();
        void fillSpanish();
        void fillEnglish();
        Team getTeam(String TID);
        Team getMissingTeam(String TID) throws IOException;
        String getThisTID();
    }
}
