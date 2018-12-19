package com.dev.svs.demoprofileandcountrylist.countries

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.dev.svs.demoprofileandcountrylist.R

class CountryListAdapter(var countryList: ArrayList<String>, var mListener: CountryListInterface) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return CountryListItemVH(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.list_item_country,
                viewGroup,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CountryListItemVH) {
            holder.countryNameTextView.text = countryList[position]
            holder.parentLayout.setOnClickListener {
                mListener.onCountrySelected(countryList[position])
            }
        }
    }

    class CountryListItemVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryNameTextView: TextView = itemView.findViewById(R.id.listItemCountryName)
        val parentLayout: RelativeLayout = itemView.findViewById(R.id.listItemCountryParent)
    }
}