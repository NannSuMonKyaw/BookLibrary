package com.example.dell.booklibrary.adapter;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.booklibrary.DB.InitializeDatabase;

import com.example.dell.booklibrary.R;
import com.example.dell.booklibrary.activity.DetailActivity;
import com.example.dell.booklibrary.model.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private Context mContext;
    private List<Book> bookList;
    private String strbookName;
    private String imagePath;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView bookName, authorName;
        public ImageView thumbnail ;

        private Book book;
        private String isRead;
        InitializeDatabase dbHelper;

        public MyViewHolder(View view) {
            super(view);
            dbHelper = InitializeDatabase.getInstance(view.getContext());

            bookName = (TextView) view.findViewById(R.id.etcardbookName);
            authorName = (TextView) view.findViewById(R.id.etcardAuthorName);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);



            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    strbookName=book.getBookName();

                    Toast.makeText(mContext, "Click on " + strbookName, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent( v.getContext(),DetailActivity.class);
                    intent.putExtra("SelectedBookName",strbookName);
                    //intent.putExtra("SelectedBookisRead",isRead);
                    //Toast.makeText(mContext, strbookName, Toast.LENGTH_SHORT).show();
                    v.getContext().startActivity(intent);

                }
            });


        }

        public void bindData(Book book) {

            this.book = book;
            bookName.setText(book.getBookName());
            authorName.setText(book.getAuthorName());
            imagePath=dbHelper.getBookDAO().getphotoPathbyBookName(book.getBookName());
//            isRead = book.getIsRead();
////            int imageid=mContext.getResources().getIdentifier(imagePath, "id", mContext.getPackageName());
//           Log.d("Info","Image Path===="+imagePath);
//            //thumbnail.setImageResource(R.drawable.album1);
//            if (isRead.equals("false")) {
//
//                checkedImage.setImageResource(R.drawable.unchecked_16);
//            } else if (isRead.equals("true")) {
//                checkedImage.setImageResource(R.drawable.checked_16);
//            }
//            //Glide.with(mContext)
            //   .load(new File(imagePath.getPath()))
            //    .into(thumbnail);


            if(imagePath!= null) {
                // // thumbnail.setImageURI(Uri.parse(imagePath));
                thumbnail.setImageBitmap(BitmapFactory.decodeFile(imagePath));
                //thumbnail.setImageResource(mContext.getResources().getIdentifier(imagePath, "drawable", mContext.getPackageName()));
            }
            // loading album cover using Glide library
            // Glide.with(mContext).load((book.getPhotoPath())).into(thumbnail);
        }
    }
    //  public static int getResourseId(Context context, String pVariableName, String pResourcename, String pPackageName) throws RuntimeException {
    //   try {
    //      return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
    //   } catch (Exception e) {
    //        throw new RuntimeException("Error getting Resource ID.", e);
    //    }
    // }

    public BookAdapter(Context mContext, List<Book> bookList) {
        this.mContext = mContext;
        this.bookList = bookList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.bindData(book);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}

