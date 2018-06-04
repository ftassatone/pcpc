package helpfire.ontheroad;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearRinforzi, linearEmergenza;
    private Button btRinforzi, btPolizia, btForestale, btCarabinieri, btAmbulanza;
    private TextView nomeSegnalatoreTxt, indirizzoEmergenzaTxt, tipoEmergenzaTxt, cognomeSegnalatoreTxt, provinciaTxt, gradoEmergenzaTxt,
            informazioniAggiuntiveTxt;
    private Emergenza em;
    private ArrayList<Emergenza> emergenze;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearRinforzi = (LinearLayout) findViewById(R.id.linearRinforzi);
        linearEmergenza = (LinearLayout) findViewById(R.id.linearEmergenza);

        btRinforzi = (Button) findViewById(R.id.btRinforzi);
        btPolizia = (Button) findViewById(R.id.btPolizia);
        btForestale = (Button) findViewById(R.id.btForestale);
        btCarabinieri = (Button) findViewById(R.id.btCarabinieri);
        btAmbulanza = (Button) findViewById(R.id.btAmbulanza);

        nomeSegnalatoreTxt = (TextView) findViewById(R.id.nomeSegnalatoreTxt);
        indirizzoEmergenzaTxt = (TextView) findViewById(R.id.indirizzoEmergenzaTxt);
        tipoEmergenzaTxt = (TextView) findViewById(R.id.tipoEmergenzaTxt);
        cognomeSegnalatoreTxt = (TextView) findViewById(R.id.cognomeSegnalatoreTxt);
        provinciaTxt = (TextView) findViewById(R.id.provinciaTxt);
        gradoEmergenzaTxt = (TextView) findViewById(R.id.gradoEmergenzaTxt);
        informazioniAggiuntiveTxt = (TextView) findViewById(R.id.informazioniAggiuntiveTxt);

        em = new Emergenza();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.compila_report, menu);
        return true;
    }


}
