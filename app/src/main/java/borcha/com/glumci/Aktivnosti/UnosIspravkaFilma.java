package borcha.com.glumci.Aktivnosti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by androiddevelopment on 13.6.17..
 */

public class UnosIspravkaFilma extends AppCompatActivity {

    public static final int TIPOPERACIJE_NOVO=0;//Ukoliko dolazimo sa novim ulazom
    public static final int TIPOPERACIJE_ISPRAVI=1;//Ukoliko dolazimo da ispravimo podatak

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
