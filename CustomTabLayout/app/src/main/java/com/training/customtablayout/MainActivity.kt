package com.training.customtablayout

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tab)
        viewPager = findViewById(R.id.view_pager)
        adapter = MainAdapter(supportFragmentManager)
        val oneFragment = OneFragment()
        val twoFragment = TwoFragment()
        val spannableStringBuilder: SpannableStringBuilder = SpannableStringBuilder()
        val s1 = SpannableString("bold\n")
        val s2 = SpannableString("italic\n")
        spannableStringBuilder.append(s1)
        spannableStringBuilder.append(s2)
        s2.setSpan(ForegroundColorSpan(Color.BLUE), 0, s2.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        adapter.addFragment(oneFragment, "34\nItems")
        adapter.addFragment(twoFragment, "21\nFollowers")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    private class MainAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager) {

        private val fragments: ArrayList<Fragment> = arrayListOf()
        private val strings: ArrayList<String> = arrayListOf()

        public fun addFragment(fragment: Fragment, name: String) {
            fragments.add(fragment)
            strings.add(name)
        }

        override fun getCount(): Int = fragments.size

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getPageTitle(position: Int): CharSequence? = strings[position]
    }
}