package com.example.dell.booklibrary.activity;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.os.DeadObjectException;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.booklibrary.DB.InitializeDatabase;
import com.example.dell.booklibrary.R;
import com.example.dell.booklibrary.model.Book;

public class DetailActivity extends AppCompatActivity {
    private Context mContext;
    private String passedBookName;
    private int passedBookId;
    private String passedIsRead;
    TextView tvbookName,tvAuthorName,tvPrice,tvReleaseDate,tvCategory,tvSummary;
    ImageView imvphoto;
    Button btnDelete,btnEdit;
    Book clickedBook;
    String ischecked;
    InitializeDatabase dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvbookName=(TextView)findViewById(R.id.etdtbookName);
        tvAuthorName=(TextView)findViewById(R.id.etdtauthorName);
        tvPrice=(TextView)findViewById(R.id.etdtprice);
        tvReleaseDate=(TextView)findViewById(R.id.etdtreleaseDate);
        tvCategory=(TextView)findViewById(R.id.dtcategory);
        tvSummary=(TextView)findViewById(R.id.etdtsummary);
        btnDelete=(Button)findViewById(R.id.btndtDelete);
        btnEdit=(Button)findViewById(R.id.btndtEdit);
        imvphoto=(ImageView)findViewById(R.id.dtbookimage) ;

        passedBookName= getIntent().getExtras().getString("SelectedBookName");
        passedBookId=getIntent().getExtras().getInt("SelectedBookId");

         dbHelper = InitializeDatabase.getInstance(this);

        clickedBook=dbHelper.getBookDAO().getBookById(passedBookId);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarRV);
        toolbar.setTitle(clickedBook.getBookName());

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvbookName.setText(clickedBook.getBookName());
        tvAuthorName.setText(clickedBook.getAuthorName());
        tvPrice.setText(clickedBook.getPrice());
        tvReleaseDate.setText(clickedBook.getReleaseDate());
        tvCategory.setText(clickedBook.getCategoary());
        tvSummary.setText(clickedBook.getSummary());
        imvphoto.setImageBitmap(BitmapFactory.decodeFile(clickedBook.getPhotoPath()));


        btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(DetailActivity.this,BookEditActivity.class);
                    intent.putExtra("BookName",passedBookName);
                    intent.putExtra("BookID",passedBookId);
                    startActivity(intent);
                    onPause();
                }
            });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);



                // Ask the final question
                builder.setMessage("Are you sure to Delete?");

                // Set the alert dialog yes button click listener
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when user clicked the Yes button
                        // Set the TextView visibility GONE
                      dbHelper.getBookDAO().deleteByBookId(clickedBook.getBookId());
                      finish();
                    }
                });

                // Set the alert dialog no button click listener
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when No button clicked
                        Toast.makeText(getApplicationContext(),
                                "' No' Button Clicked",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        clickedBook=dbHelper.getBookDAO().getBookById(passedBookId);
        tvbookName.setText(clickedBook.getBookName());
        tvAuthorName.setText(clickedBook.getAuthorName());
        tvPrice.setText(clickedBook.getPrice());
        tvReleaseDate.setText(clickedBook.getReleaseDate());
        tvCategory.setText(clickedBook.getCategoary());
        tvSummary.setText(clickedBook.getSummary());
        imvphoto.setImageBitmap(BitmapFactory.decodeFile(clickedBook.getPhotoPath()));
    }

    @Override
    public void onBackPressed() {
        finish();

    }
}
