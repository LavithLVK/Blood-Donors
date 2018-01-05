package com.example.lavithedam.blooddonors.fragment

import android.app.Dialog
import android.app.DialogFragment
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import com.example.lavithedam.blooddonors.BloodCount
import com.example.lavithedam.blooddonors.R


/**
 * Created by lavith.edam on 1/4/2018.
 */
class BloodCountFragment : DialogFragment {

    var bloodCount: BloodCount = BloodCount("", 0)

    constructor() : super() {

    }

    constructor(bloodCount: BloodCount) : this() {
        this.bloodCount = bloodCount
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater?.inflate(R.layout.fragment_blood_count, container, false) as View
        var donorCountView: TextView = view!!.findViewById(R.id.fragment_donor_count)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        donorCountView.setText(bloodCount.bloodGroup + " Donor Count is : \n" + bloodCount.getDonorCount())
        return view;
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

}
