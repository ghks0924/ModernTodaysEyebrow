package com.todayseyebrow.moderntodayseyebrow.ui.view.dialogs

import android.graphics.Point
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment

class SimpleOkDialog : DialogFragment() {

    //viewBinding
//    private lateinit var binding:

    interface ClickListener {
        fun onClick(str: String)
    }

    private lateinit var clickListener: ClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = DialogHowToPayBinding.inflate(inflater, container, false)
//        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
//
//        return binding.root
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 클릭 리스너 달고
//        binding.cashCardview.setOnClickListener {
//            clickListener.onClick("현금")
//            dismiss()
//        }

    }

    override fun onResume() {
        super.onResume()
        val outMetrics = DisplayMetrics()
        val size = Point()

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            val display = requireActivity().display!!
            display.getRealMetrics(outMetrics)
            display.getRealSize(size)
        } else {
            @Suppress("DEPRECATION")
            val display = requireActivity().windowManager.defaultDisplay
            @Suppress("DEPRECATION")
            display.getMetrics(outMetrics)
            display.getRealSize(size)
        }

        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        val deviceWidth = size.x
        params?.width = (deviceWidth * 0.6).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams
        //==end of 창 크기 조절
    }

    fun setOnClickListener(listener: (String) -> Unit) {
        this.clickListener = object : ClickListener {
            override fun onClick(str: String) {
                listener(str)
            }
        }
    }
}