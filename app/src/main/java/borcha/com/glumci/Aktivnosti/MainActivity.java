package borcha.com.glumci.Aktivnosti;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.Date;

import borcha.com.glumci.R;
import borcha.com.glumci.db.MySqLGlumci.MySqlGlumac;
import borcha.com.glumci.db.dbmodel.Film;
import borcha.com.glumci.db.dbmodel.Glumac;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inicirajPocetneVrednosti();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inNoviGlumac=new Intent(getBaseContext(),UnosIspravkaFilma.class);
                inNoviGlumac.putExtra("operacija",UnosIspravkaFilma.TIPOPERACIJE_NOVO);
                startActivity(inNoviGlumac);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Napraviti bazu i pocetne vrednosti
    private void inicirajPocetneVrednosti() {

        Glumac startGlumac=new Glumac();
        startGlumac.setPrezime("Damon");
        startGlumac.setIme("Matt");
        startGlumac.setDatumRodjenja(new Date());
        startGlumac.setBiografija("Metju Pejdž Dejmon (engl. Matthew Paige Damon) američki je glumac i scenarista, rođen 8. oktobra 1970. godine u Kembridžu (Masačusets).");

       /* Film film1=new Film();
        film1.setNaziv("Film 1");
        film1.setZanr("Akcioni");//iz arrays

        Film film2=new Film();
        film1.setNaziv("Film 2");
        film1.setZanr("Horor");//iz arrays

        startGlumac.addFilm(film1);
        startGlumac.addFilm(film2);*/

        MySqlGlumac dbglumac=new MySqlGlumac(this);
        dbglumac.setGlumac(startGlumac);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
