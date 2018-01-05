package com.example.lavithedam.blooddonors.adapter

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.lavithedam.blooddonors.BloodCount
import com.example.lavithedam.blooddonors.R
import com.example.lavithedam.blooddonors.activity.activity.getCurrentActivity
import com.example.lavithedam.blooddonors.fragment.BloodCountFragment
import java.util.*

/**
 * Created by lavith.edam on 12/15/2017.
 */
class HomeGridAdapter : ArrayAdapter<BloodCount> {

    private var bloodGroupCountsList = arrayListOf<BloodCount>()
    private var mContext: Context?
    internal var fragmentManager: FragmentManager? = null
    internal var fragmentTransaction: FragmentTransaction? = null

    constructor(context: Context, resourceId: Int, stringsList: ArrayList<BloodCount>) : super(context, resourceId, stringsList) {
        this.mContext = context
        this.bloodGroupCountsList = stringsList
    }

    class ViewHolder(var bloodGroup: TextView?, var donorCount: TextView?) {

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var viewHolder: ViewHolder = ViewHolder(null, null)
        var tempView: View
        if (convertView == null) {
            tempView = View.inflate(mContext, R.layout.grid_item_view, null)

            viewHolder.bloodGroup = tempView.findViewById(R.id.grid_item_blood_group)
            tempView.setTag(viewHolder)
        } else {
            tempView = convertView
            viewHolder = tempView.getTag() as ViewHolder
        }
        viewHolder.bloodGroup?.setText(bloodGroupCountsList.get(position).bloodGroup)
        viewHolder.bloodGroup?.setOnClickListener(View.OnClickListener {
            openBloodCount(bloodGroupCountsList.get(position))
        })
        return tempView
    }

    fun openBloodCount(bloodCount: BloodCount) {
        fragmentManager = getCurrentActivity()?.fragmentManager
        fragmentTransaction = fragmentManager?.beginTransaction()
        var fragment: BloodCountFragment = BloodCountFragment(bloodCount)
        fragment.show(fragmentManager,"My fragment")
    }

}