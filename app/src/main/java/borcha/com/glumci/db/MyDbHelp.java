package borcha.com.glumci.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import borcha.com.glumci.db.dbmodel.Glumac;
import borcha.com.glumci.db.dbmodel.Zanr;

/**
 * Created by borcha on 02.06.17..
 */

public class MyDbHelp extends OrmLiteSqliteOpenHelper {

    private static final String DBNAME="dbglumci.db";
    private static final int DB_VER=1;

    private Dao<Glumac, Integer> daoGlumac=null;
    private Dao<Zanr, Integer> daoZanr = null;

    public MyDbHelp(Context context) {
           super(context, DBNAME, null,DB_VER);
    }



    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource conn) {

        Log.i(MyDbHelp.class.getName(), "onCreate");
        try {
            TableUtils.createTable(conn, Glumac.class);
            TableUtils.createTable(conn, Zanr.class);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource conn, int oldVersion, int newVersion) {

        Log.i(MyDbHelp.class.getName(), "onUpdate");
        try {
            TableUtils.dropTable(conn,Glumac.class,true);
            TableUtils.dropTable(conn,Zanr.class,true);

            onCreate(database,conn);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public Dao<Glumac,Integer> getDaoGlumac() throws SQLException {

        if(daoGlumac==null) {
            daoGlumac = getDao(Glumac.class);
        }

        return daoGlumac;
    }


    public Dao<Zanr,Integer> getDaoZanr() throws SQLException {

        if(daoZanr==null){
            daoZanr=getDao(Zanr.class);
        }

        return daoZanr;
    }

    @Override
    public void close() {
        Log.i("baza","Zatvorena");
        daoZanr=null;
        daoGlumac=null;

        super.close();
    }


}
