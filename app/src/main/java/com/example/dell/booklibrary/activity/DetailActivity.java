package com.example.dell.booklibrary.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
    private String passedIsRead;
    TextView tvbookName,tvAuthorName,tvPrice,tvReleaseDate,tvCategory,tvSummary;
    ImageView imvphoto;
    Button btnSave;
    Book clickedBook;
    String ischecked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvbookName=(TextView)findViewById(R.id.bookName);
        tvAuthorName=(TextView)findViewById(R.id.authorName);
        tvPrice=(TextView)findViewById(R.id.price);
        tvReleaseDate=(TextView)findViewById(R.id.releaseDate);
        tvCategory=(TextView)findViewById(R.id.category);
        tvSummary=(TextView)findViewById(R.id.summary);
        btnSave=(Button)findViewById(R.id.btnSave);


        passedBookName= getIntent().getExtras().getString("SelectedBookName");
        passedIsRead= getIntent().getExtras().getString("SelectedBookisRead");
        final InitializeDatabase dbHelper = InitializeDatabase.getInstance(this);
        clickedBook=dbHelper.getBookDAO().getBookByName(passedBookName);
       // ischecked=dbHelper.getBookDAO().getIsReadbyBookName(passedBookName);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarRV);
        toolbar.setTitle(clickedBook.getBookName());
        //ischecked=clickedBook.getIsRead();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Toast.makeText(this, "before ischecked condition "+ ischecked , Toast.LENGTH_SHORT).show();
        if(passedIsRead.equals("false"))
        {
            //Toast.makeText(this, "ischecked conditionfalse " , Toast.LENGTH_SHORT).show();
            btnSave.setText("Save");
        }
        else if (passedIsRead.equals("true")){
           // Toast.makeText(this, "ischecked conditiontrue " , Toast.LENGTH_SHORT).show();
            btnSave.setText("Unsave");
        }
        //Toast.makeText(this, "after ischecked condition " , Toast.LENGTH_SHORT).show();

        tvbookName.setText(clickedBook.getBookName());
        tvAuthorName.setText(clickedBook.getAuthorName());
        tvPrice.setText(clickedBook.getPrice());
        tvReleaseDate.setText(clickedBook.getReleaseDate());
        tvCategory.setText(clickedBook.getCategoary());
        tvSummary.setText(clickedBook.getSummary());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnSave.getText().toString().toLowerCase().equals("unsave")){
                    btnSave.setText("Save");
                    dbHelper.getBookDAO().updateIsRead("false",passedBookName);
                }
                else if(btnSave.getText().toString().toLowerCase().equals("save")){
                    btnSave.setText("Unsave");
                    dbHelper.getBookDAO().updateIsRead("true",passedBookName);

                }
              //  Intent i = new Intent(DetailActivity.this, DetailActivity.class);
              // finish();
                //startActivity(i);;
//                recreate();

            }
        });

    }
    @Override
    public void onBackPressed() {
        finish();

    }
}
