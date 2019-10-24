package com.example.dell.booklibrary.activity;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.os.DeadObjectException;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.booklibrary.DB.InitializeDatabase;
import com.example.dell.booklibrary.R;
import com.example.dell.booklibrary.model.Book;

public class DetailActivity extends AppCompatActivity {
    private Context mContext;
    private String passedBookName;
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
        //passedIsRead= getIntent().getExtras().getString("SelectedBookisRead");
         dbHelper = InitializeDatabase.getInstance(this);
        clickedBook=dbHelper.getBookDAO().getBookByName(passedBookName);
       // ischecked=dbHelper.getBookDAO().getIsReadbyBookName(passedBookName);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarRV);
        toolbar.setTitle(clickedBook.getBookName());
        //ischecked=clickedBook.getIsRead();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Toast.makeText(this, "before ischecked condition "+ ischecked , Toast.LENGTH_SHORT).show();
//        if(passedIsRead.equals("false"))
//        {
//            //Toast.makeText(this, "ischecked conditionfalse " , Toast.LENGTH_SHORT).show();
//            btnSave.setText("Save");
//        }
//        else if (passedIsRead.equals("true")){
//           // Toast.makeText(this, "ischecked conditiontrue " , Toast.LENGTH_SHORT).show();
//            btnSave.setText("Unsave");
//        }
        //Toast.makeText(this, "after ischecked condition " , Toast.LENGTH_SHORT).show();

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
                    startActivity(intent);
                    onPause();
                }
            });

//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (btnSave.getText().toString().toLowerCase().equals("unsave")){
//                    btnSave.setText("Save");
//                    dbHelper.getBookDAO().updateIsRead("false",passedBookName);
//                }
//                else if(btnSave.getText().toString().toLowerCase().equals("save")){
//                    btnSave.setText("Unsave");
//                    dbHelper.getBookDAO().updateIsRead("true",passedBookName);
//
//                }
//              //  Intent i = new Intent(DetailActivity.this, DetailActivity.class);
//              // finish();
//                //startActivity(i);;
////                recreate();
//
//            }
//        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        clickedBook=dbHelper.getBookDAO().getBookByName(passedBookName);
        tvbookName.setText(clickedBook.getBookName());
        tvAuthorName.setText(clickedBook.getAuthorName());
        tvPrice.setText(clickedBook.getPrice());
        tvReleaseDate.setText(clickedBook.getReleaseDate());
        tvCategory.setText(clickedBook.getCategoary());
        tvSummary.setText(clickedBook.getSummary());

    }

    @Override
    public void onBackPressed() {
        finish();

    }
}
