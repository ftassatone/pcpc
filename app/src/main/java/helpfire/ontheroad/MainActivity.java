package helpfire.ontheroad;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearRinforzi, linearEmergenza;
    private Button btRinforzi, btPolizia, btForestale, btCarabinieri, btAmbulanza;
    private TextView nomeSegnalatoreTxt, indirizzoEmergenzaTxt, tipoEmergenzaTxt, cognomeSegnalatoreTxt, provinciaTxt, gradoEmergenzaTxt,
            informazioniAggiuntiveTxt;
    private Emergenza em;
    private ArrayList<Emergenza> emergenze;
    int n;
    String nomeSegnalatore, indirizzoEmergenza, tipoEmergenza, cognomeSegnalatore, provincia, gradoEmergenza, informazioniAggiuntive;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearRinforzi = (LinearLayout) findViewById(R.id.linearRinforzi);
        linearEmergenza = (LinearLayout) findViewById(R.id.linearEmergenza);
        linearEmergenza.setBackground(getDrawable(R.drawable.bordo));

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
        informazioniAggiuntiveTxt.setBackground(getDrawable(R.drawable.bordo));
        emergenze = new ArrayList<>();
        //n=0;
        em = new Emergenza();
        emergenze =  em.creaEmergenze();
        Log.d("LOG","emergenze "+emergenze);
        ottieniDati();
    }

    public void popolaText(){
        nomeSegnalatoreTxt.setText(nomeSegnalatore);
        indirizzoEmergenzaTxt.setText(indirizzoEmergenza);
        tipoEmergenzaTxt.setText(tipoEmergenza);
        cognomeSegnalatoreTxt.setText(cognomeSegnalatore);
        provinciaTxt.setText(provincia);
        informazioniAggiuntiveTxt.setText(informazioniAggiuntive);
        gradoEmergenzaTxt.setText(gradoEmergenza);
    }

    public void ottieniDati(){
        Random random = new Random();
        n = random.nextInt(11)+1;
        Log.d("LOG", "random "+n);
        nomeSegnalatore = emergenze.get(n).getNomeSegnalatore();
        indirizzoEmergenza = emergenze.get(n).getIndirizzoEmergenza();
        tipoEmergenza = emergenze.get(n).getTipoEmergenza();
        cognomeSegnalatore = emergenze.get(n).getCognomeSegnalatore();
        provincia = emergenze.get(n).getProvincia();
        informazioniAggiuntive = emergenze.get(n).getInformazioniAggiuntive();
        gradoEmergenza = emergenze.get(n).getGradoEmergenza();
        popolaText();
        Log.d("DATI", "dati "+nomeSegnalatore+" "+indirizzoEmergenza+" "+tipoEmergenza+" "+cognomeSegnalatore+" "+provincia+" "+informazioniAggiuntive+" "+gradoEmergenza);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.compila_report, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_compilaReport) {
            Intent vaiReport = new Intent(getApplicationContext(), Report.class);
            vaiReport.putExtra("nome", nomeSegnalatore);
            vaiReport.putExtra("indirizzo", indirizzoEmergenza);
            vaiReport.putExtra("tipo", tipoEmergenza);
            vaiReport.putExtra("cognome", cognomeSegnalatore);
            vaiReport.putExtra("informazioni", informazioniAggiuntive);
            vaiReport.putExtra("grado", gradoEmergenza);
            vaiReport.putExtra("provincia", provincia);
            startActivity(vaiReport);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
