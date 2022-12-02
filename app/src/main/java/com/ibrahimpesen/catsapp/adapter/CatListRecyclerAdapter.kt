package com.ibrahimpesen.catsapp.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.CheckBox
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimpesen.catsapp.R
import com.ibrahimpesen.catsapp.model.CatsItem
import com.ibrahimpesen.catsapp.util.imageDownload
import com.ibrahimpesen.catsapp.util.placeholderCreate

import com.ibrahimpesen.catsapp.view.CatListFragmentDirections

import kotlinx.android.synthetic.main.cat_recycler_row.view.cbHeart
import kotlinx.android.synthetic.main.cat_recycler_row.view.ivCat
import kotlinx.android.synthetic.main.cat_recycler_row.view.tvCatName
import kotlinx.android.synthetic.main.fragment_cat_list.view.*


class CatListRecyclerAdapter(val catList: ArrayList<CatsItem>, val favCatList: ArrayList<CatsItem>) :
    RecyclerView.Adapter<CatListRecyclerAdapter.CatViewHolder>() {

    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*init {
            itemView.cbHeart.setOnClickListener { v->
                val isCheched = (v as CheckBox).isChecked
                List[adapterPosition].
            }

        }*/

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cat_recycler_row, parent, false)
        return CatViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.itemView.tvCatName.text = catList.get(position).name
        //görsel kısmı eklenecek


        holder.itemView.setOnClickListener {
            val action = CatListFragmentDirections.actionCatListFragmentToCatDetailFragment()
            var bundle = Bundle()
            bundle.putString("name",catList.get(position).name)
            bundle.putString("image", catList.get(position).image?.url)
            bundle.putString("description", catList.get(position).description)
            bundle.putString("origin", catList.get(position).origin)
            bundle.putString("wikipedia_url", catList.get(position).wikipediaUrl)
            bundle.putString("life_span", catList.get(position).lifeSpan)
            bundle.putString("dog_friendly", catList.get(position).dogFriendly.toString())
            Navigation.findNavController(it)
                .navigate(R.id.action_catListFragment_to_catDetailFragment, bundle)
        }
        println("test -> ${catList.get(position).image?.url}")
        holder.itemView.ivCat.imageDownload(
            catList.get(position).image?.url,
            placeholderCreate(holder.itemView.context)
        )



        /*holder.itemView.cbHeart.text = favCatList.get(position).isSelected.toString()

        val currentCat =favCatList.get(position)

        if (holder.itemView.cbHeart.isChecked){
            currentCat.isSelected=true
            favCatList.add(currentCat)

        }else if(!holder.itemView.cbHeart.isChecked) {
            currentCat.isSelected=false
            favCatList.remove(currentCat)
        }*/


        //holder.itemView.cbHeart.text = catList.get(position).isSelected.toString()

        /*holder.itemView.cbHeart.setOnClickListener {

        var bundle = Bundle()
            bundle.putString("ivCat", catList.get(position).image?.url)
            bundle.putString("tvCatName",catList.get(position).name)
            Navigation.findNavController(it)
                .navigate(R.id.action_catListFragment_to_catFavFragment,bundle)

        }*/





    }

    override fun getItemCount(): Int {
        return catList.size
    }

    fun catListUpdate(newCatList: List<CatsItem>) {

        catList.clear()
        catList.addAll(newCatList)
        notifyDataSetChanged()

    }
}