package presenter;



public class MainP {

    private MainP.MainPresenter presenter;

    public MainP(MainP.MainPresenter presenter){
        this.presenter = presenter;
    }
    public void getData(){
        presenter.getTeamFromDB();
    }

    public void selectLanguage(){
        presenter.selectLanguage();
    }

    public interface MainPresenter{
        void getTeamFromDB();
        void selectLanguage();
    }
}
