package com.ibrahimpesen.catsapp.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahimpesen.catsapp.R
import com.ibrahimpesen.catsapp.adapter.CatListRecyclerAdapter
import com.ibrahimpesen.catsapp.viewmodel.CatListViewModel
import kotlinx.android.synthetic.main.cat_recycler_row.*
import kotlinx.android.synthetic.main.fragment_cat_list.*


class CatListFragment : Fragment() {

    private lateinit var viewModel : CatListViewModel
    private val catRecyclerAdapter = CatListRecyclerAdapter(arrayListOf(), arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= ViewModelProvider(this)[CatListViewModel::class.java]
        viewModel.dataFromSql()

        catListRecycler.layoutManager= LinearLayoutManager(context)
        catListRecycler.adapter= catRecyclerAdapter

        swipeRefreshLayout.setOnRefreshListener {

            progressBar.visibility=View.VISIBLE
            errorMessage.visibility=View.GONE
            catListRecycler.visibility=View.GONE
            viewModel.refreshDataFromInternet()
            swipeRefreshLayout.isRefreshing=false
        }
        observeLiveData()

        /*btnFav.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_catListFragment_to_catFavFragment)
        }*/




    }


    fun observeLiveData(){
        viewModel.cats.observe(viewLifecycleOwner, Observer { cats->
            cats?.let{
                catListRecycler.visibility=View.VISIBLE
                catRecyclerAdapter.catListUpdate(cats)
            }


        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { error->
            error?.let {
                if (it){
                    errorMessage.visibility=View.VISIBLE
                }
                else{
                    errorMessage.visibility=View.GONE
                }

            }

        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { loading->
            loading?.let {
                if (it){
                    catListRecycler.visibility=View.GONE
                    errorMessage.visibility=View.GONE
                    progressBar.visibility=View.VISIBLE

                }else{
                    progressBar.visibility=View.GONE
                }
            }

        })
    }




}