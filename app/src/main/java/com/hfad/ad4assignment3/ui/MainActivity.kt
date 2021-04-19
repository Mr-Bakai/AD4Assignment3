package com.hfad.ad4assignment3.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.hfad.ad4assignment3.R
import com.hfad.ad4assignment3.databinding.ActivityMainBinding
import com.hfad.ad4assignment3.ui.adapter.PagerAdapter
import com.hfad.ad4assignment3.ui.first_fragment.FirstFragment
import com.hfad.ad4assignment3.ui.second_fragment.SecondFragment
import com.hfad.ad4assignment3.ui.third_fragment.ThirdFragment

class MainActivity : AppCompatActivity() {
    private lateinit var ui: ActivityMainBinding
    private lateinit var previewMenuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        val adapter = PagerAdapter(initFragments(), this)
        ui.viewPager.adapter = adapter

        ui.bottomNavigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.ic_first -> ui.viewPager.currentItem = 0
                R.id.ic_second -> ui.viewPager.currentItem = 1
                R.id.ic_third -> ui.viewPager.currentItem = 2
            }
            true
        }

        ui.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                onPageSelectedF(position)
            }
        })
    }

    private fun initFragments(): ArrayList<Fragment> {
        return arrayListOf(
            FirstFragment.newInstance(),
            SecondFragment.newInstance(),
            ThirdFragment.newInstance()
        )
    }

    private fun onPageSelectedF(position: Int) {

        if (::previewMenuItem.isInitialized) {
            previewMenuItem.isChecked = true
        } else {
            ui.bottomNavigation.menu.getItem(position).isChecked = true
        }

        ui.bottomNavigation.menu.getItem(position).isChecked = true
        previewMenuItem = ui.bottomNavigation.menu.getItem(position)
    }
}