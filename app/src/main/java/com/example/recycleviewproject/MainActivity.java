package com.example.recycleviewproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    /*int []image={

            R.drawable.ic_bba,R.drawable.ic_civl,R.drawable.ic_cse,
            R.drawable.ic_eee,R.drawable.ic_english,R.drawable.ic_llb
    };
*/

    String []CourseName;


    MyAdapter myAdapter;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;



    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=findViewById(R.id.RecycleViewId);
       // CourseName=getResources().getStringArray(R.array.courses);
         //myAdapter=new MyAdapter(this,image,CourseName);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("DATA");

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


      databaseReference.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              dataSnapshot.getValue(MyAdapter.class);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError) {

             // Log.w(TAG, "Failed to read value.", error.toException());


          }
      });

    }
}
