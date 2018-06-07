package helpfire.ontheroad;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Report extends AppCompatActivity {

    private LinearLayout linearEmergenzaRep, linearAggiungiMedia, linearImmagini;
    private TextView nomeSegnalatoreRep, indirizzoEmergenzaRep, tipoEmergenzaRep, cognomeSegnalatoreRep, provinciaRep, gradoEmergenzaRep,
            descrizioneEmergenzaRep;
    private ImageButton btImmagini;
    private String mCurrentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;
    static final int ID_RICHIESTA_PERMISSION = 1;
    static final int REQUEST_IMAGE_CAPTURE = 1 ;

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
        btImmagini = (ImageButton) findViewById(R.id.btImmagini);


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
                                /*ContentValues values = new ContentValues();
                                values.put(MediaStore.Images.Media.TITLE, "prova");
                                Uri mImageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                                intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);*/
                                startActivityForResult(intent,REQUEST_TAKE_PHOTO);
                                break;
                            default:
                                break;
                        }
                    }
                });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == this.RESULT_CANCELED){
            return;
        }
        if(requestCode == REQUEST_IMAGE_CAPTURE){
            if(data!=null){
                Uri contentURI = data.getData();
                Log.d("MIO", "URI "+data.getData());
                try{
                    if(contentURI==null){
                        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                        String path = saveImage(bitmap);
                        Log.d("MIO", "path "+path);
                        ImageView imageView = new ImageView(getApplicationContext());
                        imageView.setImageBitmap(bitmap);
                        linearImmagini.addView(imageView);
                    }else{
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),contentURI);
                        Log.d("MIO", "bitmap "+bitmap);
                        String path = saveImage(bitmap);
                        Log.d("MIO", "path "+path);
                        ImageView imageView = new ImageView(getApplicationContext());
                        imageView.setImageBitmap(bitmap);
                        linearImmagini.addView(imageView);
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }else if(requestCode == REQUEST_TAKE_PHOTO){
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageBitmap(thumbnail);
            linearImmagini.addView(imageView);
        }
    }

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

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        //File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File root = Environment.getExternalStorageDirectory();
        File directory = new File(root.getAbsolutePath()+"/DCIM/OnTheRoad");
        directory.mkdir();
        Log.d("DANIELE","dir "+directory);
        File image = File.createTempFile(imageFileName,".jpg",directory);
        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        Log.d("DANIELE"," mCurrentPhotoPath "+ mCurrentPhotoPath);
        return image;
    }

}
