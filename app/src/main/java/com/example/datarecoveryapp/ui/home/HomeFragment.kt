package com.example.datarecoveryapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datarecoveryapp.R
import com.example.datarecoveryapp.databinding.FragmentHomeBinding
import com.example.datarecoveryapp.ui.home.adapter.CardsAdapter
import com.example.datarecoveryapp.ui.home.interfaces.OnItemClickListener
import com.example.datarecoveryapp.ui.home.model.CardModel
import com.example.datarecoveryapp.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(),OnItemClickListener {
    private lateinit var binding:FragmentHomeBinding
    private val cardsAdapter by lazy { CardsAdapter(this) }
    private val viewModel:HomeViewModel by activityViewModels()
    private val TAGIMAGES="imagesTag"
    private val TAGAUDIOS="audiosTag"
    private val TAGVIDEOS="videosTag"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cards= mutableListOf<CardModel>()
        /*cards.add(CardModel(R.drawable.ic_icon_gallery,"Images","0 Items",R.color.greenCardColor))
        cards.add(CardModel(R.drawable.ic_icon_video,"Videos","6 Items",R.color.redCardColor))
        cards.add(CardModel(R.drawable.ic_icon_audio,"Audios","0 Items",R.color.yellowCardColor))*/
//        cardsAdapter.submitList(cards)
       val job= CoroutineScope(Dispatchers.Main).launch {
            launch {
                viewModel.getAllImages()
            }
            launch {
                viewModel.getAllAudios()

            }
            launch {
                viewModel.getAllVideos()

            }
        }
        CoroutineScope(Dispatchers.Default).launch {
        job.join()
        }

        viewModel.imagesList.observe(viewLifecycleOwner, Observer {files->
            if(files!=null){
                cards.add(CardModel(R.drawable.ic_icon_gallery,"Images","${files.size} items",R.color.greenCardColor))
                cardsAdapter.submitList(cards)
            }
        })
        viewModel.audiosList.observe(viewLifecycleOwner, Observer {files->
            if(files!=null){
                cards.add(CardModel(R.drawable.ic_icon_audio,"Audios","${files.size} items",R.color.yellowCardColor))
                cardsAdapter.submitList(cards)
            }
        })
        viewModel.videosList.observe(viewLifecycleOwner, Observer {files->
            if(files!=null){
                cards.add(CardModel(R.drawable.ic_icon_video,"Videos","${files.size} items",R.color.redCardColor))
                cardsAdapter.submitList(cards)
            }

        })


        binding.cardRecyclerView.apply {
            adapter=cardsAdapter
            layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        with(binding)
        {
            lifecycleOwner = this@HomeFragment
            //viewmodel = this@HomeFragment.viewModel
        }
        return binding.root
    }

    override fun onClick(cardModel: CardModel) {
        if(cardModel.title=="Images"){
            val action=HomeFragmentDirections.actionHomeFragmentToImagesFragment()
            findNavController().navigate(action)
        }
    }


}