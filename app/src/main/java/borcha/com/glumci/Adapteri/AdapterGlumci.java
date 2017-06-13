package borcha.com.glumci.Adapteri;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import borcha.com.glumci.R;
import borcha.com.glumci.db.dbmodel.Glumac;

/**
 * Created by androiddevelopment on 13.6.17..
 */

public class AdapterGlumci  extends ArrayAdapter<Glumac>{

    LayoutInflater lyInflater;
    Context cont;
    TextView txvPrezimeIme,txvGodinaRodjenja;

    public AdapterGlumci( Context context, int resource, List<Glumac> _glumci) {
        super(context, R.layout.stavka_liste_glumci,_glumci);
        cont=context;
    }


    @NonNull
    @Override
    public View getView(int position, View vi,  ViewGroup parent) {
        lyInflater=(LayoutInflater)cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vi=lyInflater.inflate(R.layout.stavka_liste_glumci,null);
        Glumac glumac=getItem(position);


        txvPrezimeIme=(TextView)vi.findViewById(R.id.txvPrezimeImeGlumca_lista);
        txvGodinaRodjenja=(TextView)vi.findViewById(R.id.txtDatumRodjenja_lista);

        txvPrezimeIme.setText(glumac.getPrezime()+ ", " + glumac.getIme());
        txvGodinaRodjenja.setText(glumac.getDatumRodjenja().toString());


        return vi;
    }
}
