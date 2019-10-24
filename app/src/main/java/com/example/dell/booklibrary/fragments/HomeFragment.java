package com.example.dell.booklibrary.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.booklibrary.DB.InitializeDatabase;
import com.example.dell.booklibrary.activity.BookAddActivity;
import com.example.dell.booklibrary.adapter.BookAdapter;
import com.example.dell.booklibrary.model.Book;
import com.example.dell.booklibrary.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private List<Book> bookList,bookArray;
    FloatingActionButton fab;
    int userId;
    String bookName,authorName,price,releaseDate,category,summary,photoPath;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        fab=(FloatingActionButton)view.findViewById(R.id.fab);
        bookList = new ArrayList<Book>();
        SharedPreferences sp=getActivity().getSharedPreferences("login",MODE_PRIVATE);
        userId=sp.getInt("userId",1);
       // prepareBooks();
        adapter = new BookAdapter(getContext(), bookList);
        RecyclerView.LayoutManager mLayoutManager =new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareBooks();

    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           Intent intent=new Intent(v.getContext(),BookAddActivity.class);
            startActivity(intent);
        }
    });

        return view;
    }
    private void prepareBooks() {



        InitializeDatabase dbHelper = InitializeDatabase.getInstance(getContext());

        bookArray=(ArrayList<Book>)dbHelper.getBookDAO().getAllBookbyUserId(userId);


        for(int i=0;i<bookArray.size();i++) {
            bookName=bookArray.get(i).getBookName();

            authorName=bookArray.get(i).getAuthorName();
            photoPath=bookArray.get(i).getPhotoPath();



            Book a = new Book(bookName, authorName,userId,price,releaseDate,category,summary,photoPath);
            bookList.add(a);


        }





       adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        //prepareBooks();
        InitializeDatabase dbHelper = InitializeDatabase.getInstance(getContext());

        bookArray=(ArrayList<Book>)dbHelper.getBookDAO().getAllBookbyUserId(userId);
        adapter = new BookAdapter(getContext(), bookArray);
        recyclerView.setAdapter(adapter);
    }
}
