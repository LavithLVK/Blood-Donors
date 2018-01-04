package com.example.lavithedam.blooddonors

/**
 * Created by lavith.edam on 1/4/2018.
 */
class BloodCount(var bloodGroup: String, private var donorCount: Long) {
//    }

    public fun getDonorCount(): Long {
        return donorCount
    }

    public fun setDonorCount(donorCount: Long) {
        this.donorCount = donorCount
    }


}