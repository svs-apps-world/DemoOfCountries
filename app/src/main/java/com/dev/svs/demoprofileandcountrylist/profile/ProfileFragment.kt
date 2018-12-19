package com.dev.svs.demoprofileandcountrylist.profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.svs.demoprofileandcountrylist.MainActivity
import com.dev.svs.demoprofileandcountrylist.R

class ProfileFragment : Fragment() {
    companion object {
        val TAG: String = "ProfileFragment"
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile_tab, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).supportActionBar?.title = "Profile"
    }
}