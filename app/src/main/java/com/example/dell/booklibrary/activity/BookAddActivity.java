package com.example.dell.booklibrary.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.example.dell.booklibrary.R;
import com.example.dell.booklibrary.DB.InitializeDatabase;

import com.example.dell.booklibrary.model.Book;

public class BookAddActivity extends AppCompatActivity {
private EditText etBookName,etAuthorName,etPrice,etReleaseDate,etCategory,etSummary;
private Button btnSave;ImageView bookPhoto;
private String strBookName,strAuthorName,strPrice,strReleaseDate,strCategory,strSummary;
private String picturePath;
    Book book;
    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add);
        etBookName=(EditText)findViewById(R.id.etbookName);
        etAuthorName=(EditText)findViewById(R.id.etauthorName);
        etPrice=(EditText)findViewById(R.id.etprice);
        etReleaseDate=(EditText)findViewById(R.id.etreleaseDate);
        etCategory=(EditText)findViewById(R.id.etreleaseDate);
        etSummary=(EditText)findViewById(R.id.etsummary);
        btnSave=(Button)findViewById(R.id.btnSave);
        bookPhoto=(ImageView)findViewById(R.id.imbookimage);


        bookPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });




        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strBookName=etBookName.getText().toString();
                strAuthorName=etAuthorName.getText().toString();
                strPrice=etPrice.getText().toString();
                strReleaseDate=etReleaseDate.getText().toString();
                strCategory=etCategory.getText().toString();
                strSummary=etSummary.getText().toString();
                book=new Book(strBookName,strAuthorName,strPrice,strReleaseDate,strCategory,strSummary,picturePath);
                InitializeDatabase dbHelper = InitializeDatabase.getInstance(v.getContext());
                dbHelper.getBookDAO().insert(book);

                finish();
            }
        });










    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.imbookimage);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));


        }


    }
}
