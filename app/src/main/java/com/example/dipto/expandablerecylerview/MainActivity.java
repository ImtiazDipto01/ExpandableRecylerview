package com.example.dipto.expandablerecylerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dipto.expandablerecylerview.model.InnerModel;
import com.example.dipto.expandablerecylerview.model.OuterModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int[] out_img = {R.drawable.one, R.drawable.two, R.drawable.three} ;
    String[] outter_title = {"Doctor one", "Doctor two", "Dcotor three"} ;
    String[] inner_string = {"apollo hospital", "United hospital"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.expanded_recyler);
        RecylerViewAdapter recylerViewAdapter = new RecylerViewAdapter(getApplicationContext(), getdata()) ;
        LinearLayoutManager layoutManager =  new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false) ;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recylerViewAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(recylerViewAdapter);
    }

    private List<OuterModel> getdata(){
        List<OuterModel> outterlist = new ArrayList<>() ;

        for(int i = 0 ; i < out_img.length ; i++){

            List<InnerModel> innerlist = new ArrayList<>() ;

            for(int j = 0 ; j < inner_string.length ; j++){

                InnerModel innerModel = new InnerModel(inner_string[j]) ;
                innerlist.add(innerModel) ;
            }

            OuterModel outerModel = new OuterModel(outter_title[i], innerlist, out_img[i]) ;
            outterlist.add(outerModel) ;
        }

        return outterlist ;
    }
}
