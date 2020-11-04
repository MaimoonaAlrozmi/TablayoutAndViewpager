package TabWithIcon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.maimoona.tablayout.R

lateinit var tabLayout: TabLayout
lateinit var viewPager: ViewPager2

class TabsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        tabLayout = findViewById(R.id.tab)
        viewPager = findViewById(R.id.view_pager)

        viewPager.adapter = object : FragmentStateAdapter(this) {

            override fun getItemCount(): Int {
                return 3
            }

            override fun createFragment(position: Int): Fragment {

                return when (position) {
                    0 -> Chats.newInstance("", "")
                    1 -> Status.newInstance("", "")
                    2 -> Calls.newInstance("", "")
                    else -> {
                        Calls.newInstance("", "")
                    }
                }
            }
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, postion ->
            tab.text = when (postion) {
                0 -> "CHATS"
                1 -> "STATUS"
                2 -> "CALLS"
                else -> null
            }
        }.attach()
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_chat_24)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_chat_24)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_chat_24)

    }
}