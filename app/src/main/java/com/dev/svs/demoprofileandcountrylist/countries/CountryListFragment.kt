package com.dev.svs.demoprofileandcountrylist.countries

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.svs.demoprofileandcountrylist.Constants
import com.dev.svs.demoprofileandcountrylist.MainActivity
import com.dev.svs.demoprofileandcountrylist.R
import kotlinx.android.synthetic.main.fragment_country_list.*

class CountryListFragment : Fragment(), CountryListInterface {


    companion object {
        const val TAG: String = "CountryListFragment"
        fun newInstance(): CountryListFragment {
            return CountryListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryListRecyclerView.layoutManager = GridLayoutManager(context, 2)
        countryListRecyclerView.adapter =
                CountryListAdapter(resources.getStringArray(R.array.countries_array).toList() as ArrayList<String>, this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity)?.supportActionBar?.title = "Countries"
    }
    override fun onCountrySelected(countryName: String) {
        val intent  = Intent(context, CountryDetailActivity::class.java)
        intent.putExtra(Constants.COUNTRY_NAME, countryName)
        startActivity(intent)
    }
}