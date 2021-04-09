package data.locdvd;

public class Serie {
    private String strCat = "";
    private String strTitre = "";
    private String strRealisateur = "";
    private int iImg = 0;

    //Constructeur par défaut
    public Serie(){}

    //Mutateurs
    public void setCat(String cat) {this.strCat = cat;}
    public void setTitre(String titre) {this.strTitre = titre;}
    public void setRealisateur(String realisateur) {this.strRealisateur = realisateur;}
    public void setImg(int img) {this.iImg = img;}

    //Accesseurs
    public String getCat(){return this.strCat;}
    public String getTitre(){return this.strTitre;}
    public String getRealisateur(){return this.strRealisateur;}
    public int getImg(){return this.iImg;}

}
