package com.example.datarecoveryapp.ui.imagesdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datarecoveryapp.R
import com.example.datarecoveryapp.databinding.FragmentHomeBinding
import com.example.datarecoveryapp.databinding.FragmentImagesBinding
import com.example.datarecoveryapp.ui.home.interfaces.OnItemClickListener
import com.example.datarecoveryapp.ui.home.model.CardModel
import com.example.datarecoveryapp.ui.home.viewmodel.HomeViewModel
import com.example.datarecoveryapp.ui.imagesdetails.adapter.ImagesAdapter
import com.example.datarecoveryapp.ui.imagesdetails.interfaces.OnItemClick
import com.example.datarecoveryapp.ui.imagesdetails.model.ImageFile
import com.google.android.material.animation.ImageMatrixProperty
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ImagesFragment : Fragment(),OnItemClick {
    private lateinit var binding:FragmentImagesBinding
    private val imagesAdapter by lazy { ImagesAdapter(this) }
    private val viewModel:HomeViewModel by activityViewModels()
    private val selectedList= mutableListOf<ImageFile>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val images= mutableListOf<ImageFile>()

        viewModel.imagesList.observe(viewLifecycleOwner, Observer {files->
            files.forEach {
                images.add(ImageFile(it,false))
            }
            imagesAdapter.submitList(images)
        })

        binding.imagesRecyclerView.apply {
            adapter=imagesAdapter
            layoutManager=GridLayoutManager(requireContext(),3)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_images, container, false)
        with(binding)
        {
            lifecycleOwner = this@ImagesFragment
            //viewmodel = this@HomeFragment.viewModel
        }
        return binding.root
    }

    override fun onClick(imageFile: ImageFile) {
        if(selectedList.contains(imageFile)){
            selectedList.remove(imageFile)
        }
        else{
            selectedList.add(imageFile)
        }
        if(selectedList.isEmpty()){
            binding.btnRecover.visibility=View.GONE
            binding.totalSelectedText.visibility=View.GONE
            binding.bottomView.visibility=View.GONE
        }
        else{
            binding.btnRecover.visibility=View.VISIBLE
            binding.totalSelectedText.visibility=View.VISIBLE
            binding.bottomView.visibility=View.VISIBLE
            binding.totalSelectedText.text="${selectedList.size} files selected"
        }
    }



}