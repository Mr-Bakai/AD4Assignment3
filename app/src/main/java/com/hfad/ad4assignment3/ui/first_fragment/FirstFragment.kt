package com.hfad.ad4assignment3.ui.first_fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hfad.ad4assignment3.databinding.FirstFragmentBinding
import com.hfad.ad4assignment3.ui.view_model.MainViewModel

class FirstFragment : Fragment() {
    private lateinit var ui: FirstFragmentBinding

    companion object {
        fun newInstance() = FirstFragment()
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ui = FirstFragmentBinding.inflate(inflater, container, false)
        return ui.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ui.btnInc.setOnClickListener {
            viewModel.onIncrementClick()
        }

        ui.btnSub.setOnClickListener {
            viewModel.onSubtractClick()
        }
    }
}