package helpfire.ontheroad;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class Report extends AppCompatActivity{

    private LinearLayout linearEmergenzaRep, linearAggiungiMedia, linearImmagini;
    private TextView nomeSegnalatoreRep, indirizzoEmergenzaRep, tipoEmergenzaRep, cognomeSegnalatoreRep, provinciaRep, gradoEmergenzaRep,
            descrizioneEmergenzaRep, orarioPoliziaTxt, orarioForestaleTxt,orarioCarabinieriTxt, orarioAmbulanzaTxt;
    private ImageButton btImmagini;
    private CheckBox checkPrimaPartenza, checkSecondaPartena, checkSupporto, checkRincalzo, checkPolizia, checkForestale,
            checkCarabinieri, checkAmbulanza,check;
    private static final int REQUEST_TAKE_PHOTO = 1;
    private static final int ID_RICHIESTA_PERMISSION = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 1 ;
    private String ora;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

        int statoPermissionWrite = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int statoPermissionCamera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int statoPermissionRead = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (statoPermissionWrite == PackageManager.PERMISSION_DENIED || statoPermissionCamera == PackageManager.PERMISSION_DENIED
                || statoPermissionRead == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, ID_RICHIESTA_PERMISSION);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, ID_RICHIESTA_PERMISSION);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, ID_RICHIESTA_PERMISSION);
        }

        linearEmergenzaRep = (LinearLayout) findViewById(R.id.linearEmergenzaRep);
        linearAggiungiMedia = (LinearLayout) findViewById(R.id.linearAggiungiMedia);
        linearImmagini = (LinearLayout) findViewById(R.id.linearImmagini);

        linearAggiungiMedia.setBackground(getDrawable(R.drawable.bordo));
        linearEmergenzaRep.setBackground(getDrawable(R.drawable.bordo));

        nomeSegnalatoreRep = (TextView) findViewById(R.id.nomeSegnalatoreRep);
        indirizzoEmergenzaRep = (TextView) findViewById(R.id.indirizzoEmergenzaRep);
        tipoEmergenzaRep = (TextView) findViewById(R.id.tipoEmergenzaRep);
        cognomeSegnalatoreRep = (TextView) findViewById(R.id.cognomeSegnalatoreRep);
        provinciaRep = (TextView) findViewById(R.id.provinciaRep);
        gradoEmergenzaRep = (TextView) findViewById(R.id.gradoEmergenzaRep);
        descrizioneEmergenzaRep = (TextView) findViewById(R.id.descrizioneEmergenzaRep);
        orarioPoliziaTxt = (TextView) findViewById(R.id.orarioPoliziaTxt);
        orarioForestaleTxt = (TextView) findViewById(R.id.orarioForestaleTxt);
        orarioCarabinieriTxt = (TextView) findViewById(R.id.orarioCarabinieriTxt);
        orarioAmbulanzaTxt = (TextView) findViewById(R.id.orarioAmbulanzaTxt);
        btImmagini = (ImageButton) findViewById(R.id.btImmagini);

        checkPrimaPartenza = (CheckBox) findViewById(R.id.checkPrimaPartenza);
        checkSecondaPartena = (CheckBox) findViewById(R.id.checkSecondaPartenza);
        checkSupporto = (CheckBox) findViewById(R.id.checkSupporto);
        checkRincalzo = (CheckBox) findViewById(R.id.checkRincalzo);
        checkPolizia = (CheckBox) findViewById(R.id.checkPolizia);
        checkPolizia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkPolizia.isChecked()){
                    inserisciOrario(view);
                }else
                    orarioPoliziaTxt.setText("");
            }
        });
        checkForestale = (CheckBox) findViewById(R.id.checkForestale);
        checkForestale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkForestale.isChecked()){
                    inserisciOrario(view);
                }else
                    orarioForestaleTxt.setText("");

            }
        });
        checkCarabinieri = (CheckBox) findViewById(R.id.checkCarabinieri);
        checkCarabinieri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkCarabinieri.isChecked()){
                    inserisciOrario(view);
                }else
                    orarioCarabinieriTxt.setText("");

            }
        });
        checkAmbulanza = (CheckBox) findViewById(R.id.checkAmbulanza);
        checkAmbulanza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAmbulanza.isChecked()){
                    inserisciOrario(view);
                }else
                    orarioAmbulanzaTxt.setText("");
            }
        });

        btImmagini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creaBuilder();
            }
        });
        popolaText();
    }


    public void popolaText(){
        Intent prendiDati = getIntent();
        nomeSegnalatoreRep.setText(prendiDati.getExtras().getString("nome"));
        indirizzoEmergenzaRep.setText(prendiDati.getExtras().getString("indirizzo"));
        tipoEmergenzaRep.setText(prendiDati.getExtras().getString("tipo"));
        cognomeSegnalatoreRep.setText(prendiDati.getExtras().getString("cognome"));
        provinciaRep.setText(prendiDati.getExtras().getString("provincia"));
        gradoEmergenzaRep.setText(prendiDati.getExtras().getString("grado"));
        descrizioneEmergenzaRep.setText(prendiDati.getExtras().getString("informazioni"));
    }

    //creazione del dialog per la scelta tra galleria e fotocamera
    public void creaBuilder(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Report.this);
        builder.setTitle("Choose Image Source");
        builder.setItems(new CharSequence[] {"Gallery", "Camera"},
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                startActivityForResult(galleryIntent, REQUEST_IMAGE_CAPTURE);
                                break;
                            case 1:
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(intent,REQUEST_TAKE_PHOTO);
                                break;
                            default:
                                break;
                        }
                    }
                });
        builder.show();
    }

    //apertura della fotocamera,successivamente mostra la foto nell'activity nella sezione delle anteprime.
    //selezione dell'immagine dalla galleria e anteprima nell'activity.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == this.RESULT_CANCELED){
            return;
        }
        if(requestCode == REQUEST_IMAGE_CAPTURE){
            if(data!=null){
                Uri contentURI = data.getData();
                try{
                    if(contentURI==null){
                        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                        String path = saveImage(bitmap);
                        ImageView imageView = new ImageView(getApplicationContext());
                        imageView.setImageBitmap(bitmap);
                        FrameLayout frameLayout = new FrameLayout(getApplicationContext());
                        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(30, 30);
                        frameLayout.setLayoutParams(layoutParams1);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
                        imageView.setLayoutParams(layoutParams);
                        linearImmagini.addView(imageView);
                        linearImmagini.addView(frameLayout);
                    }else{
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),contentURI);
                        String path = saveImage(bitmap);
                        ImageView imageView = new ImageView(getApplicationContext());
                        imageView.setImageBitmap(bitmap);
                        FrameLayout frameLayout = new FrameLayout(getApplicationContext());
                        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(30, 30);
                        frameLayout.setLayoutParams(layoutParams1);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
                        imageView.setLayoutParams(layoutParams);
                        linearImmagini.addView(imageView);
                        linearImmagini.addView(frameLayout);
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }else if(requestCode == REQUEST_TAKE_PHOTO){
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageBitmap(thumbnail);
            FrameLayout frameLayout = new FrameLayout(getApplicationContext());
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(30, 30);
            frameLayout.setLayoutParams(layoutParams1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
            imageView.setLayoutParams(layoutParams);
            linearImmagini.addView(imageView);
            linearImmagini.addView(frameLayout);
        }
    }

    //salvataggio della foto scattata nella directory
    public String saveImage(Bitmap myBitmap){
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG,90, bytes);
        File wallpaperDirectory = new File(Environment.getExternalStorageDirectory()+"/DCIM/OnTheRoad");
        if(!wallpaperDirectory.exists()){
            wallpaperDirectory.mkdirs();
        }
        try{
            File f = new File(wallpaperDirectory, Calendar.getInstance().getTimeInMillis()+".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this, new String[]{f.getPath()}, new String[]{"image/jpg"},null);
            fo.close();
            return f.getAbsolutePath();
        }catch (IOException e1){
            e1.printStackTrace();
        }
        return "";
    }

    //metodo per inserire l'orario utilizzando il TimePickerDialog
    public void inserisciOrario (View view){
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        check = (CheckBox)view;
        TimePickerDialog dialog = new TimePickerDialog(Report.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                ora = hourOfDay + ":" + minute;
                switch (check.getText().toString()){
                    case "Polizia": orarioPoliziaTxt.setText("Arrivo - "+ora);
                        break;
                    case "Forestale": orarioForestaleTxt.setText("Arrivo - "+ora);
                        break;
                    case "Carabinieri": orarioCarabinieriTxt.setText("Arrivo - "+ora);
                        break;
                    case "Ambulanza": orarioAmbulanzaTxt.setText("Arrivo - "+ora);
                        break;
                }
            }
        },hour, minute, DateFormat.is24HourFormat(getApplicationContext()));
        dialog.show();
    }

    //creazione del dialog per l'inserimento dell'orario per le partenze e gli arrivi dei vvf

}
