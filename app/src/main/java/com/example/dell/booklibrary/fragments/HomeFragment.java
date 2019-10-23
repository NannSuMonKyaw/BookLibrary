package com.example.dell.booklibrary.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.booklibrary.DB.InitializeDatabase;
import com.example.dell.booklibrary.adapter.BookAdapter;
import com.example.dell.booklibrary.model.Book;
import com.example.dell.booklibrary.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private List<Book> bookList,bookArray;

    String bookName,authorName,price,releaseDate,category,summary,photoPath,isRead;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        bookList = new ArrayList<>();

        adapter = new BookAdapter(getContext(), bookList);
        RecyclerView.LayoutManager mLayoutManager =new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        return view;
    }
    private void prepareAlbums() {



        InitializeDatabase dbHelper = InitializeDatabase.getInstance(getContext());

        bookArray=(ArrayList<Book>)dbHelper.getBookDAO().getAllBook();

        for(int i=0;i<bookArray.size();i++) {
            bookName=bookArray.get(i).getBookName();

            authorName=bookArray.get(i).getAuthorName();
            photoPath=bookArray.get(i).getPhotoPath();
            isRead=bookArray.get(i).getIsRead();

            Book a = new Book(bookName, authorName,price,releaseDate,category,summary,photoPath,isRead);
            bookList.add(a);

        }





       adapter.notifyDataSetChanged();
    }
}
