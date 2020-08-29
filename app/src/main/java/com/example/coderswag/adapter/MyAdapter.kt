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

class MyAdapter(private val myDataset: List<Category>, val itemClick: (Category) -> Unit) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(var categoryView: View, var context: Context, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(categoryView) {
        val categoryImage: ImageView = categoryView.findViewById(R.id.categoryimage)
        val categoryName: TextView = categoryView.findViewById(R.id.categorytext)

        fun bindCategoryImage(myCategory: Category) {
            categoryName.text =  myCategory.title // set the title
            // set the image
            val resourceId = this.context.resources.getIdentifier(myCategory.image, "drawable", this.context.packageName)
            categoryImage.setImageResource(resourceId)

            categoryView.setOnClickListener { itemClick(myCategory) }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        // create a new view
        val categoryView = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)

        return MyViewHolder(categoryView, parent.context, itemClick)
    }

    // Replace the contents of a view (invoked by the layout manager)
    // displays the content of data onto recycler view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bindCategoryImage(myDataset[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.count()
}