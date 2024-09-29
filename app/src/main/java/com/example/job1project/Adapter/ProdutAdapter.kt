package com.example.job1project.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.job1project.Product
import com.example.job1project.R
import com.example.job1project.ViewModel.ProductViewModel

class ProdutAdapter(private val products:List<Product>):RecyclerView.Adapter<ProdutAdapter.ProductViewHolder>() {
   inner class ProductViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

       val productImg = itemView.findViewById<ImageView>(R.id.productImage)
       val productName = itemView.findViewById<TextView>(R.id.nameTxt)
       val productPrice =  itemView.findViewById<TextView>(R.id.productPriceTxt)
       val productDescription = itemView.findViewById<TextView>(R.id.productDescriptionTxt)

       fun bind(product: Product){
           productName.text = product.title
           productPrice.text = "$${product.price}"
           productDescription.text = product.description
           Glide.with(itemView).load(product.images[0])
               .into(productImg)

       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent,false)

        return ProductViewHolder(view)

    }


    override fun getItemCount(): Int {
        return products.size
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
         val product = products[position]
        holder.bind(product)
    }

}