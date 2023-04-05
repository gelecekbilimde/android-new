package org.gelecekbilimde.ui.activitys

import android.os.Bundle
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint
import org.gelecekbilimde.R
import org.gelecekbilimde.databinding.ActivityMainBinding
import org.gelecekbilimde.util.GeneralUtil

/**
 *
 * @author ferhatozcelik
 * @since 2023-03-29
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        if (GeneralUtil().isGooglePlayServicesAvailable(this)){
            FirebaseApp.initializeApp(applicationContext)
        }
        navController = findNavController(R.id.navHostFragment)
        setupSmoothBottomMenu()
    }

    private fun setupSmoothBottomMenu() {
        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.bottom_navigation_menu)
        val menu = popupMenu.menu
        activityMainBinding.bottomNavigationView.setupWithNavController(menu, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
