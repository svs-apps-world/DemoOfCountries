package com.dev.svs.demoprofileandcountrylist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.dev.svs.demoprofileandcountrylist.countries.CountryListFragment
import com.dev.svs.demoprofileandcountrylist.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(ProfileFragment.newInstance(), ProfileFragment.TAG)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when {
                (it.itemId == R.id.menu_person) -> {
                    replaceFragment(ProfileFragment.newInstance(), ProfileFragment.TAG)
                    true
                }
                (it.itemId == R.id.menu_countries) -> {
                    replaceFragment(CountryListFragment.newInstance(), CountryListFragment.TAG)
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    private fun replaceFragment(newFragment: Fragment, tag: String) {
        val fragmentManager = supportFragmentManager
        val ft = fragmentManager.beginTransaction()
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        ft.replace(R.id.mainActivityFragmentContainer, newFragment, tag)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft.addToBackStack(tag)
        ft.commit()
    }

    override fun onBackPressed() {
        finish()
    }
}
