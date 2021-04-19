package com.hfad.ad4assignment3.ui.third_fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hfad.ad4assignment3.databinding.ThirdFragmentBinding
import com.hfad.ad4assignment3.ui.view_model.MainViewModel

class ThirdFragment : Fragment() {
    private lateinit var ui: ThirdFragmentBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    companion object {
        fun newInstance() = ThirdFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ui = ThirdFragmentBinding.inflate(inflater, container, false)
        return ui.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.counterText.observe(viewLifecycleOwner, Observer {
            ui.textView.text = it.toString()
        })
    }
}