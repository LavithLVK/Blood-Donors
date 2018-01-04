package com.example.lavithedam.blooddonors.fragment

import android.app.Dialog
import android.app.DialogFragment
import android.app.Fragment
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import com.example.lavithedam.blooddonors.R
import android.view.Window.FEATURE_NO_TITLE


/**
 * Created by lavith.edam on 1/4/2018.
 */
class BloodCountFragment : DialogFragment {

    var donorCount: Long = 0

    constructor() : super() {

    }

    constructor(donorCount: Long) : this() {
        this.donorCount = donorCount
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater?.inflate(R.layout.fragment_blood_count, container, false) as View
        donorCount = arguments.get("donor_count") as Long
        var donorCountView: TextView = view!!.findViewById(R.id.fragment_donor_count)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        donorCountView.setText(donorCount.toString())
        return view;
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // The only reason you might override this method when using onCreateView() is
        // to modify any dialog characteristics. For example, the dialog includes a
        // title by default, but your custom layout might not need it. So here you can
        // remove the dialog title, but you must call the superclass to get the Dialog.
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

}
