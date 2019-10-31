package com.example.dqv_front

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.dqv.PageAdapter
import com.example.dqv.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_menu.*


class MenuActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val viewPager = findViewById<View>(R.id.viewPages) as ViewPager
        viewPager.adapter = PageAdapter(supportFragmentManager,tabLayout.tabCount)



        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })



    }


}
