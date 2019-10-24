package com.example.dell.booklibrary.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.booklibrary.DB.InitializeDatabase;
import com.example.dell.booklibrary.R;
import com.example.dell.booklibrary.model.Book;


public class BookEditActivity extends AppCompatActivity {
private EditText etAuthorName,etPrice,etReleaseDate,etCategory,etSummary;
TextView etBookName;
Button btnSave;ImageView bookPhoto;String passedBookName;Book clickedBook;
Book book;private static int RESULT_LOAD_IMAGE = 1;  String picturePath="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_edit);
        etBookName=(TextView) findViewById(R.id.etedbookName);
        etAuthorName=(EditText)findViewById(R.id.etedauthorName);
        etPrice=(EditText)findViewById(R.id.etedprice);
        etReleaseDate=(EditText)findViewById(R.id.etedreleaseDate);
        etCategory=(EditText)findViewById(R.id.edcategory);
        etSummary=(EditText)findViewById(R.id.etedsummary);
        btnSave=(Button)findViewById(R.id.btnedSave);
        bookPhoto=(ImageView)findViewById(R.id.edimbookimage);

        passedBookName= getIntent().getExtras().getString("BookName");
        //passedIsRead= getIntent().getExtras().getString("SelectedBookisRead");
        final InitializeDatabase dbHelper = InitializeDatabase.getInstance(this);
        clickedBook=dbHelper.getBookDAO().getBookByName(passedBookName);

        etBookName.setText(clickedBook.getBookName());
        etAuthorName.setText(clickedBook.getAuthorName());
        etPrice.setText(clickedBook.getPrice());
        etReleaseDate.setText(clickedBook.getReleaseDate());
        etCategory.setText(clickedBook.getCategoary());
        etSummary.setText(clickedBook.getSummary());
        picturePath=dbHelper.getBookDAO().getphotoPathbyBookName(passedBookName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getBookDAO().updateBookByName(etBookName.getText().toString(),etAuthorName.getText().toString(),etPrice.getText().toString(),etReleaseDate.getText().toString(),etCategory.getText().toString(),etSummary.getText().toString(),picturePath);

                finish();
            }
        });

        bookPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
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

            bookPhoto.setImageBitmap(BitmapFactory.decodeFile(picturePath));


        }

    }}
