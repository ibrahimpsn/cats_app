package com.ibrahimpesen.catsapp.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions
import com.ibrahimpesen.catsapp.R
import com.ibrahimpesen.catsapp.util.imageDownload
import com.ibrahimpesen.catsapp.util.placeholderCreate
import com.ibrahimpesen.catsapp.viewmodel.CatDetailViewModel
import kotlinx.android.synthetic.main.fragment_cat_detail.*


class CatDetailFragment : Fragment() {
    private lateinit var viewModel : CatDetailViewModel
    private var catId = 0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_cat_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            ivCat.imageDownload(it.getString("image"), placeholderCreate(requireContext()))
            tvCatName.text=it.getString("name")
            tvDescription.text=it.getString("description")
            tvOrigin.text=it.getString("origin")
            tvWikipedia.text=it.getString("wikipedia_url")
            tvLifeSpan.text=it.getString("life_span")
            tvDogFriendly.text=it.getString("dog_friendly")
        }

        viewModel= ViewModelProvider(this)[CatDetailViewModel::class.java]
        viewModel.dataFromRoom(catId)



        observeLiveData()
        toCatListFragment()

    }

    fun observeLiveData(){

        viewModel.catLiveData.observe(viewLifecycleOwner, Observer { cat->

            cat?.let {

                /*ivCat.imageDownload(it.image.toString(), placeholderCreate(requireContext()))
                tvCatName.text=it.name
                tvDescription.text=it.description
                tvOrigin.text=it.origin
                tvWikipedia.text=it.wikipediaUrl
                tvLifeSpan.text=it.lifeSpan
                tvDogFriendly.text=it.dogFriendly.toString()*/

            }

        })

    }

    fun toCatListFragment(){

            ivBack.setOnClickListener {
                val intent = Intent(context,MainActivity::class.java)
                startActivity(intent)
            }

    }







}