package com.example.coderswag.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.model.Category

class MyAdapter(private val myDataset: List<Category>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(var categoryView: View, var context: Context) : RecyclerView.ViewHolder(categoryView)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        // create a new view
        val categoryView = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false) as View

        return MyViewHolder(categoryView, parent.context)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val categoryImage: ImageView = holder.categoryView.findViewById(R.id.categoryimage)
        val categoryName: TextView = holder.categoryView.findViewById(R.id.categorytext)
        println("======================================================")

        val imgresid = holder.context.resources.getIdentifier(myDataset[position].image, "drawable", holder.context.packageName)
        categoryImage.setImageResource(imgresid)

        categoryName.text = myDataset[position].title
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}