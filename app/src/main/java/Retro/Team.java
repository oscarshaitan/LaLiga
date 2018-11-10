package Retro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class Team {

    @SerializedName("idTeam")
    @Expose
    @Id
    private String idTeam;

    @SerializedName("strTeam")
    @Expose
    private String strTeam;
    @SerializedName("strAlternate")
    @Expose
    private String strAlternate;
    @SerializedName("intFormedYear")
    @Expose
    private String intFormedYear;

    @SerializedName("strStadium")
    @Expose
    private String strStadium;
    @SerializedName("strKeywords")
    @Expose
    private String strKeywords;

    @SerializedName("strWebsite")
    @Expose
    private String strWebsite;
    @SerializedName("strFacebook")
    @Expose
    private String strFacebook;
    @SerializedName("strTwitter")
    @Expose
    private String strTwitter;
    @SerializedName("strInstagram")
    @Expose
    private String strInstagram;
    @SerializedName("strDescriptionEN")
    @Expose
    private String strDescriptionEN;

    @SerializedName("strDescriptionES")
    @Expose
    private String strDescriptionES;

    @SerializedName("strTeamBadge")
    @Expose
    private String strTeamBadge;
    @SerializedName("strTeamJersey")
    @Expose
    private String strTeamJersey;
    @SerializedName("strTeamLogo")
    @Expose
    private String strTeamLogo;
    @SerializedName("strTeamFanart1")
    @Expose
    private String strTeamFanart1;

    @SerializedName("strTeamBanner")
    @Expose
    private String strTeamBanner;
    @SerializedName("strYoutube")
    @Expose
    private String strYoutube;
    @SerializedName("strLocked")
    @Expose
    private String strLocked;


    @Generated(hash = 9214903)
    public Team(String idTeam, String strTeam, String strAlternate,
            String intFormedYear, String strStadium, String strKeywords,
            String strWebsite, String strFacebook, String strTwitter,
            String strInstagram, String strDescriptionEN, String strDescriptionES,
            String strTeamBadge, String strTeamJersey, String strTeamLogo,
            String strTeamFanart1, String strTeamBanner, String strYoutube,
            String strLocked) {
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strAlternate = strAlternate;
        this.intFormedYear = intFormedYear;
        this.strStadium = strStadium;
        this.strKeywords = strKeywords;
        this.strWebsite = strWebsite;
        this.strFacebook = strFacebook;
        this.strTwitter = strTwitter;
        this.strInstagram = strInstagram;
        this.strDescriptionEN = strDescriptionEN;
        this.strDescriptionES = strDescriptionES;
        this.strTeamBadge = strTeamBadge;
        this.strTeamJersey = strTeamJersey;
        this.strTeamLogo = strTeamLogo;
        this.strTeamFanart1 = strTeamFanart1;
        this.strTeamBanner = strTeamBanner;
        this.strYoutube = strYoutube;
        this.strLocked = strLocked;
    }

    @Generated(hash = 882286361)
    public Team() {
    }


    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrAlternate() {
        return strAlternate;
    }

    public void setStrAlternate(String strAlternate) {
        this.strAlternate = strAlternate;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrKeywords() {
        return strKeywords;
    }

    public void setStrKeywords(String strKeywords) {
        this.strKeywords = strKeywords;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }

    public String getStrTwitter() {
        return strTwitter;
    }

    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    public String getStrInstagram() {
        return strInstagram;
    }

    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrDescriptionES() {
        return strDescriptionES;
    }

    public void setStrDescriptionES(String strDescriptionES) {
        this.strDescriptionES = strDescriptionES;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeamJersey() {
        return strTeamJersey;
    }

    public void setStrTeamJersey(String strTeamJersey) {
        this.strTeamJersey = strTeamJersey;
    }

    public String getStrTeamLogo() {
        return strTeamLogo;
    }

    public void setStrTeamLogo(String strTeamLogo) {
        this.strTeamLogo = strTeamLogo;
    }

    public String getStrTeamFanart1() {
        return strTeamFanart1;
    }

    public void setStrTeamFanart1(String strTeamFanart1) {
        this.strTeamFanart1 = strTeamFanart1;
    }

    public String getStrTeamBanner() {
        return strTeamBanner;
    }

    public void setStrTeamBanner(String strTeamBanner) {
        this.strTeamBanner = strTeamBanner;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrLocked() {
        return strLocked;
    }

    public void setStrLocked(String strLocked) {
        this.strLocked = strLocked;
    }
}