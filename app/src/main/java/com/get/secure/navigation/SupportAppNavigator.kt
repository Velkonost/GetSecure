package com.get.secure.navigation

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen

class SupportAppNavigator(activity: AppCompatActivity, @IdRes containerId: Int) :
    AppNavigator(activity, containerId) {

    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
//        if (
//            currentFragment is PaywallFragment
//            || nextFragment is PaywallFragment
//        ) {
//            fragmentTransaction.setCustomAnimations(
//                R.anim.enter_from_right,
//                R.anim.exit_to_left,
//                R.anim.enter_from_left,
//                R.anim.exit_to_right
//            )
//        }

        super.setupFragmentTransaction(screen, fragmentTransaction, currentFragment, nextFragment)
    }

    override fun back() {
        super.back()
    }

}