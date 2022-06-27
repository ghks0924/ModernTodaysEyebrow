package com.todayseyebrow.moderntodayseyebrow.ui.view.activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.todayseyebrow.moderntodayseyebrow.R
import com.todayseyebrow.moderntodayseyebrow.data.db.MemoDatabase
import com.todayseyebrow.moderntodayseyebrow.data.db.MessageDatabase
import com.todayseyebrow.moderntodayseyebrow.data.repository.TotalRepositoryImpl
import com.todayseyebrow.moderntodayseyebrow.databinding.ActivityMainBinding
import com.todayseyebrow.moderntodayseyebrow.ui.viewmodel.MainViewModel
import com.todayseyebrow.moderntodayseyebrow.ui.viewmodel.MainViewModelProviderFactory
import com.todayseyebrow.moderntodayseyebrow.util.Constants.DATASTORE_NAME

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var mainViewModel: MainViewModel

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val Context.datastore by preferencesDataStore(DATASTORE_NAME)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupJetpackNavigation()

        val memoDB = MemoDatabase.getInstance(this)
        val messageDB = MessageDatabase.getInstance(this)
        val totalRepository = TotalRepositoryImpl(memoDB, messageDB, datastore)
        val factory = MainViewModelProviderFactory(totalRepository, this)
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    private fun setupJetpackNavigation() {
        val host = supportFragmentManager
            .findFragmentById(R.id.booksearch_nav_host_fragment) as NavHostFragment? ?: return
        navController = host.navController
        binding.bottomNavigationView.setupWithNavController(navController)

//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.fragment_memos,
//                R.id.fragment_messages,
//                R.id.fragment_calendar,
//                R.id.fragment_sales,
//                R.id.fragment_customers
//            ) // 모든 fragment를 home으로 해서 백버튼이 안나타남
//        )
//        setupActionBarWithNavController(navController)
    }
}