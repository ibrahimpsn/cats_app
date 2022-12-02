package com.ibrahimpesen.catsapp.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahimpesen.catsapp.R
import com.ibrahimpesen.catsapp.adapter.FavCatListRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_cat_fav.*


class CatFavFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat_fav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivBack.setOnClickListener {
            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
        }



    }




}