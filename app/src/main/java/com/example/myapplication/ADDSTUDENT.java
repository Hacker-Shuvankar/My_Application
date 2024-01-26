package com.example.myapplication;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.delaroystudios.studentmgt.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ADDSTUDENT extends AppCompatActivity {
    EditText nameET,phoneET,deptET,rollET,RegistrationET,noET,yearET,AdmissionET,emailET;
    RadioGroup genderRG;
    String gender;
    ImageView img;
    Button browse,upload, submit ;
    private DatabaseReference reference;

    Uri filepath;
    Bitmap bitmap ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference("Students");
        nameET=findViewById(R.id.nameET);
        phoneET=findViewById(R.id.phoneET);
        deptET=findViewById(R.id.deptET);
        rollET=findViewById(R.id.rollET);
        noET=findViewById(R.id.noET);
        RegistrationET=findViewById(R.id.RegistrationET);
        yearET=findViewById(R.id.yearET);
        AdmissionET=findViewById(R.id.AdmissionET);
        emailET=findViewById(R.id.emailET);
        genderRG=findViewById(R.id.genderRG);

        genderRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton genderRB = findViewById((checkedId));
                gender = genderRB.getText().toString();
            }
        });

        img=(ImageView) findViewById(R.id.imageView);
        upload=(Button) findViewById(R.id.upload);
        browse=(Button) findViewById(R.id.browse);

        submit=(Button)findViewById(R.id.submit);
                browse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Dexter.withContext(ADDSTUDENT.this)
                                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                                .withListener(new PermissionListener() {
                                    @Override
                                    public void onPermissionGranted(PermissionGrantedResponse response) {
                                        Intent intent = new Intent(Intent.ACTION_PICK);
                                        intent.setType("image/*");
                                        startActivityForResult(Intent.createChooser(intent,"Please select Image"), 1);
                                    }

                                    @Override
                                    public void onPermissionDenied(PermissionDeniedResponse response) {

                                    }

                                    @Override
                                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                        token.continuePermissionRequest();
                                    }
                                }).check();
                    }
                });

                upload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        uploadtofirebase();
                    }
                });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Map<String,String> details= new HashMap<>();
                details.put("name",nameET.getText().toString().trim());
                details.put("phone",phoneET.getText().toString().trim());
                details.put("dept",deptET.getText().toString().trim());
                details.put("roll",rollET.getText().toString().trim());
                details.put("no",noET.getText().toString().trim());
                details.put("registration",RegistrationET.getText().toString().trim());
                details.put("year",yearET.getText().toString().trim());
                details.put("addmission",AdmissionET.getText().toString().trim());
                details.put("email",emailET.getText().toString().trim());
                details.put("gender", Objects.requireNonNull(genderRG.getAutofillValue()).toString().trim());
                reference.setValue(details);

            }
        });


    }



    private void uploadtofirebase() {
        ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle("File Uploader");
        dialog.show();
        FirebaseStorage storage =FirebaseStorage.getInstance();
        StorageReference uploader =storage.getReference().child("image1");
        uploader.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Upload Successful",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress( UploadTask.TaskSnapshot taskSnapshot) {
                        float percent = (float) (100 * taskSnapshot.getBytesTransferred()) /taskSnapshot.getTotalByteCount();
                        dialog.setMessage("Upload :"+(int)percent+"%");
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,   Intent data) {
        if(requestCode==1 && resultCode==RESULT_OK){
            filepath=data.getData();
            try {
                InputStream inputStream=getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);

            }catch(Exception ignored){

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void  image(View view ){
        Toast.makeText(this,"Upload image", Toast.LENGTH_SHORT).show();
    }





}