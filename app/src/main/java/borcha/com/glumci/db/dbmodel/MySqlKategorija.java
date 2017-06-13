package borcha.com.glumci.db.dbmodel;

import android.content.Context;

import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import borcha.com.glumci.db.MyDbHelp;
/**
 * Created by borcha on 02.06.17..
 */

class MySqlZanr extends MyDbHelp {

    private Context cont;
    private Zanr zanr;
    private int id=0;



    /**
     * Konstruktor za unos. Nap. Ukoliko je sa Id-om ima moguce dodatne operacije kao sto su: <br> Update ili Delete.
     * @param _cont

     */
    public MySqlZanr(Context _cont){
        super(_cont);
        this.cont=_cont;

    }

    /**
     * Konstruktor sa Id-om je ukoliko saljemo u cilju update ili brisanja podatka.
     * @param _cont
     * @param _zanr
     */
    public MySqlZanr(Context _cont, Zanr _zanr) {
        super(_cont);
        this.cont = _cont;
        this.zanr=_zanr;

    }


    //*************************operaciej nad bazom *****************************************************

    /**
     * Update jela
     */
    public void prepraviKategoriju() {

       int rez= 0;

        try {
            rez = getDaoZanr().update(this.zanr);
            //PrepraviKategoriju.OnPrepraviKategoriju(rez);
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    /**
     * Brisanje jela
     */
    public void obrisiKategoriju()  {
        int rez= 0;
            try{
                rez=getDaoZanr().delete(this.zanr);
                //ObrisiKategoriju.OnObrisiKategoriju(rez);


            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    /**
     * Unos novog zanra
     * @param _zanr
     */
    public void snimiNovuKategoriju(Zanr _zanr) {

        if(!_zanr.equals(null)) {
            //TODO. Uraditi Sql upit za delete
            int rez = 0;
            try {
                rez = getDaoZanr().create(_zanr);
                //SnimiNovuKategoriju.OnSnimiNovuKategoriju(rez);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    //Vraca listu svih objekata Jelo
    public List<Zanr> getSveKategorije() {
        List<Zanr> lista=new ArrayList<>();
        try {
            lista=getDaoZanr().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    //Trazi vrednost jela po ID zapisu
    public Zanr getZanrPoId(int _id) {
        Zanr Zanr=null;
        try {
            Zanr= getDaoZanr().queryForId(_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Zanr;
    }

    /**
     *  Vraca listu jela po kategoriji
     */

    public List<Glumac> getJelaPoKategoriji(Zanr _Zanr) throws SQLException {

        QueryBuilder upit=getDaoGlumac().queryBuilder().join(getDaoGlumac().queryBuilder());
        Where<Glumac,Integer> where=upit.where().idEq(_Zanr);

        return where.query();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr Zanr) {
        this.zanr = Zanr;
    }


    public int getBrojZanr(){
        int br=0;
        try {
            br=getDaoZanr().queryForAll().size();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return br;
    }


    //***********************Intefejs -> dogadjaji **************************************
    public interface IPrepraviKategoriju{
        public void OnPrepraviKategoriju(int uspesno);
    }

    public interface IObrisiKategoriju{
        void OnObrisiKategoriju(int uspesno);
    }

    public interface ISnimiNovuKategoriju{
        void OnSnimiNovuKategoriju(int uspesno);
    }



}
