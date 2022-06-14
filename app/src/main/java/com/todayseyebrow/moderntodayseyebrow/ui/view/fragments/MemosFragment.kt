package com.todayseyebrow.moderntodayseyebrow.ui.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.todayseyebrow.moderntodayseyebrow.R
import com.todayseyebrow.moderntodayseyebrow.data.model.Memo
import com.todayseyebrow.moderntodayseyebrow.databinding.FragmentMemosBinding
import com.todayseyebrow.moderntodayseyebrow.ui.adapter.MemoAdapter
import com.todayseyebrow.moderntodayseyebrow.ui.view.activities.MainActivity
import com.todayseyebrow.moderntodayseyebrow.ui.viewmodel.MainViewModel
import com.todayseyebrow.moderntodayseyebrow.util.collectLatestStateFlow
import java.util.*

class MemosFragment : Fragment() {

    private var _binding: FragmentMemosBinding? = null
    private val binding get() = _binding!!

    private lateinit var mainViewModel: MainViewModel
    private lateinit var memoAdapter: MemoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMemosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = (activity as MainActivity).mainViewModel

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {
                    val action = MemosFragmentDirections.actionFragmentMemosToSearchFragment()
                    findNavController().navigate(action)
                    true
                }

                R.id.more -> {
                    Log.d("test111", "!11")
                    true
                }

                else -> false
            }
        }

        setupRecyclerView()
        setupTouchHelper(view)

        collectLatestStateFlow(mainViewModel.memos) {
            memoAdapter.submitList(it)
            Log.d("test111", it.size.toString())
        }

        binding.addFab.setOnClickListener {
            val memo =
                Memo("12121212", "가나다라마바사", "아자차카타파하", UUID.randomUUID().toString(), false, false)
            mainViewModel.saveMemo(memo)
            Snackbar.make(view, "Memo has saved", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {
        memoAdapter = MemoAdapter()
        binding.rvMemos.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = memoAdapter
        }

        memoAdapter.setOnItemClickListener {
            Snackbar.make(binding.root, "Memo has been clicked", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupTouchHelper(view: View) {
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.bindingAdapterPosition
                val memo = memoAdapter.currentList[position]
                mainViewModel.deleteMemo(memo)
                Snackbar.make(view, "Book has deleted", Snackbar.LENGTH_SHORT).apply {
                    setAction("Undo") {
                        mainViewModel.saveMemo(memo)
                    }
                }.show()
            }
        }
        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.rvMemos)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}