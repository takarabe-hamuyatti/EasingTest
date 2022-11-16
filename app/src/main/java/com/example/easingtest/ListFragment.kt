package com.example.easingtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easingtest.databinding.FragmentListBinding


class ListFragment : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = Adapter()
        val scroller = EasingScroller(requireContext())

        FragmentListBinding.bind(view).let { binding ->
            binding.list.adapter = adapter
            adapter.showList()

            binding.fab.setOnClickListener {
                scroller.targetPosition = 0
                (binding.list.layoutManager as? LinearLayoutManager)?.startSmoothScroll(scroller)
            }
        }
    }
}