package borcha.com.glumci.Db.dbmodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import com.j256.ormlite.*;

import static android.R.attr.data;


/**
 * Created by borcha on 20.05.17..
 */

public class Glumac {

    private static final String dTABLE_GLUMAC="tGlumci",





    private int id;
    private String ime;
    private String prezime;
    private String biografija;
    private Date datumRodjenja;
    private Date datumSmrti;
    private float rejting;
    private String slika;



    public Glumac() { }

    public Glumac(int _id, String _ime, String _prezime, Date _datumRodjenja, Date _datumSmrti, float _rejting, String _slika) {
        this.id = _id;
        this.ime = _ime;
        this.prezime = _prezime;
        this.datumRodjenja = _datumRodjenja;
        this.datumSmrti = _datumSmrti;
        this.rejting=_rejting;
        this.slika = _slika;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Date getDatumSmrti() {
        return datumSmrti;
    }

    public void setDatumSmrti(Date datumSmrti) {
        this.datumSmrti = datumSmrti;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public float getRejting() {
        return rejting;
    }

    public void setRejting(float rejting) {
        this.rejting = rejting;
    }

    public String toString() {
        return "Glumac>> " + id + " - " + ime + " " + prezime + " " + datumRodjenja + " / " + datumSmrti;
    }

}
