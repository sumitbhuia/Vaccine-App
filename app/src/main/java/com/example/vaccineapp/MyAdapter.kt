package com.example.vaccineapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


//CustomAdapter class (var listName : ArrayList<Template class[i.e.ModelClass] shows how data is collected>) : RecyclerView.[from]Adapter<CustomAdapter.[from]MyViewHolder Class>
class MyAdapter(val vaccineList:ArrayList<VaccineModel>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

// code for custom viewHolder , if not necessary can use ViewHolder for default use cases
    // it is a custom class but originally derived from viewHolder class which take itemView as input
   inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
       // setting variable -> fo connecting to specific views
        var vaccineImage : ImageView
        var vaccineTitle:TextView
        //as soon as class is made the variables and views are connected
        init{
            //connecting parameters to views
            vaccineImage = itemView.findViewById(R.id.imageView)
            vaccineTitle= itemView.findViewById(R.id.textView)

            // ans click listeners are also activated
            itemView.setOnClickListener{
                Toast.makeText(itemView.context,"You choose : ${vaccineList[adapterPosition]}",Toast.LENGTH_SHORT).show()
            }
        }
   }

    // implementing the necessary functions for adapter class
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // A adapter, will first create views by inflating the with data and -> late feed the to view holder to hold them -> to feed to adapter view
        // a variable for new view -> to be used in  the view holder
        // take date from parent i.e is vaccineList and feed to recycler view
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout,parent,false)
        // feed the the new view to viewHolder
        return MyViewHolder(v)
    }
    // this function take a viewHolder and position
    //matched the recycler views to the ArrayLst data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.vaccineTitle.text = vaccineList[position].name
        holder.vaccineImage.setImageResource(vaccineList[position].img)

    }
    //this keeps track of the data list in arrayList to keep position correct
    override fun getItemCount(): Int {
        return vaccineList.size
    }
}