package com.dev.svs.demoprofileandcountrylist.countries

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.dev.svs.demoprofileandcountrylist.Constants
import com.dev.svs.demoprofileandcountrylist.R
import com.dev.svs.demoprofileandcountrylist.models.CountryDetail
import com.dev.svs.demoprofileandcountrylist.network.GetDataService
import com.dev.svs.demoprofileandcountrylist.network.RetrofitClientInstance
import kotlinx.android.synthetic.main.activity_country_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

class CountryDetailActivity : AppCompatActivity() {

    var countryName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra(Constants.COUNTRY_NAME))
            countryName = intent.getStringExtra(Constants.COUNTRY_NAME)

        supportActionBar?.title = countryName
    }

    override fun onResume() {
        super.onResume()
        makeBackendCall()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun makeBackendCall() {
        /*Create handle for the RetrofitInstance interface*/
        val service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService::class.java)
        val call = service.countryDetail(countryName)

        call.enqueue(object : Callback<ArrayList<CountryDetail>> {
            override fun onResponse(
                call: Call<ArrayList<CountryDetail>>,
                response: Response<ArrayList<CountryDetail>>
            ) {
                if (response.body() == null || response.body()?.size == 0) {
                    makeBackendCallWithFullnameFalse()
                } else
                    loadValues(response.body())
            }

            override fun onFailure(call: Call<ArrayList<CountryDetail>>, t: Throwable) {
            }
        })
    }

    private fun makeBackendCallWithFullnameFalse() {
        /*Create handle for the RetrofitInstance interface*/
        val service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService::class.java)
        val call = service.countryDetail(countryName, false)

        call.enqueue(object : Callback<ArrayList<CountryDetail>> {
            override fun onResponse(
                call: Call<ArrayList<CountryDetail>>,
                response: Response<ArrayList<CountryDetail>>
            ) {
                loadValues(response.body())
            }

            override fun onFailure(call: Call<ArrayList<CountryDetail>>, t: Throwable) {
            }
        })
    }

    private fun loadValues(list: ArrayList<CountryDetail>?) {
        if (list != null && list.size > 0) {
            val countryDetail = list[0]
            nativeName.text = countryDetail.nativeName
            capital.text = countryDetail.capital
            population.text = countryDetail.population.roundToInt().toString()
            area.text = countryDetail.area.roundToInt().toString()
            region.text = countryDetail.region
            subRegion.text = countryDetail.subregion
            currency.text = countryDetail.currencies[0].toString()
            demonym.text = countryDetail.demonym
        }
    }
}