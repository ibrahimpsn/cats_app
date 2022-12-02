package com.ibrahimpesen.catsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimpesen.catsapp.R
import com.ibrahimpesen.catsapp.model.CatsItem
import com.ibrahimpesen.catsapp.util.imageDownload
import com.ibrahimpesen.catsapp.util.placeholderCreate
import kotlinx.android.synthetic.main.cat_fav_recycler_row.view.*
import kotlinx.android.synthetic.main.cat_recycler_row.view.*
import kotlinx.android.synthetic.main.cat_recycler_row.view.ivCat
import kotlinx.android.synthetic.main.cat_recycler_row.view.tvCatName
import kotlinx.android.synthetic.main.fragment_cat_fav.view.*

class FavCatListRecyclerAdapter(val favCatList: ArrayList<CatsItem>):
    RecyclerView.Adapter<FavCatListRecyclerAdapter.FavViewHolder>() {
    class FavViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cat_recycler_row, parent, false)
        return FavViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        holder.itemView.tvCatName.text = favCatList.get(position).name
        holder.itemView.ivCat.imageDownload(
            favCatList.get(position).image?.url,
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

    }

    override fun getItemCount(): Int {
        return favCatList.size
    }
    fun catListUpdate(newCatList: List<CatsItem>) {

        /*favCatList.clear()
        favCatList.addAll(newCatList)
        notifyDataSetChanged()*/

    }


}
