package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("work","working");
        setContentView(R.layout.activity_main);


        RecyclerView myRecyclerView = findViewById(R.id.myrecyclerview);
        List<String> myList = new ArrayList<>();



        MyAdapter myAdapter = new MyAdapter(myList);



        myRecyclerView.setAdapter(myAdapter);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL,false);
        myRecyclerView.setLayoutManager(layoutManager);



        EditText itemEditText = findViewById(R.id.addItemEditText);



        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemEditText.getText().toString();




                myList.add(item);

                myAdapter.notifyItemInserted(myList.size()-1);

            }
        });
        ItemTouchHelper touchHelper = new ItemTouchHelper(

                new ItemTouchHelper.SimpleCallback( 0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT ) {

                    @Override



                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition(); /* <-- deprecated method */

                        myList.remove(position); // delete item from adapter's ArrayList
                        myAdapter.notifyItemRemoved(position);
                    }
                }
        );


        touchHelper.attachToRecyclerView(myRecyclerView);
    }
    public boolean onCreateOptionsMenu(Menu menu) {





        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {




        if(item.getItemId() == R.id.vertical)
        {
            RecyclerView recyclerView = findViewById(R.id.myrecyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,
                    RecyclerView.VERTICAL,false));
        }




        else if(item.getItemId() == R.id.horiontal)
        {
            RecyclerView recyclerView = findViewById(R.id.myrecyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,
                    RecyclerView.HORIZONTAL,false));
        }





        return super.onOptionsItemSelected(item);
    }

    }
