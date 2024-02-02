package com.example.vaccineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1 - Adapter view = Recycler view


        //connect recycler view
        val recyclerView :RecyclerView = findViewById(R.id.recyclerView)
        // set layout of recycler view
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        //2 - Data sources

       // make a empty array list
        var vaccineList:ArrayList<VaccineModel> = ArrayList()

        // make the the array list following the model class and assign data
        val v1=VaccineModel("Covid-19",R.drawable.vaccine1)
        val v2=VaccineModel("Bhuter virus",R.drawable.vaccine4)
        val v3=VaccineModel("Muter muter",R.drawable.vaccine5)
        val v4=VaccineModel("Chickenpox",R.drawable.vaccine6)
        val v5=VaccineModel("Madness",R.drawable.vaccine7)
        val v6=VaccineModel("Cricket",R.drawable.vaccine8)
        val v7=VaccineModel("Bitch",R.drawable.vaccine9)

        // add the data to the empty array list
        vaccineList.add(v1)
        vaccineList.add(v2)
        vaccineList.add(v3)
        vaccineList.add(v4)
        vaccineList.add(v5)
        vaccineList.add(v6)
        vaccineList.add(v7)


        //3- Adapter

        // set adapter and give it data arraylist
        val adapter = MyAdapter(vaccineList)

        //tell recycler view who is the adapter
        recyclerView.adapter=adapter




    }
}