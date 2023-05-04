package com.example.mymusic.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

class DeepLinkNavigator(private val context: Context) : Navigator<DeepLinkDestination>() {

    @SuppressLint("WrongConstant")
    override fun navigate(
        destination: DeepLinkDestination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ): NavDestination? {
        // Handle the deep link navigation based on the destination URI
        val uri = Uri.parse(destination.uri)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        val activityInfo = intent.resolveActivityInfo(context.packageManager, intent.flags)
        val activityClass = Class.forName(activityInfo.name)
        val intentForActivity = Intent(context, activityClass)
        intentForActivity.data = uri
        context.startActivity(intentForActivity)
        return destination
    }

    override fun createDestination(): DeepLinkDestination {
        return DeepLinkDestination(this)
    }

    override fun popBackStack(): Boolean {
        // Not implemented for deep link navigation
        return false
    }
}

class DeepLinkDestination(navigator: Navigator<out NavDestination>) :
    NavDestination(navigator) {
    var uri: String? = null
}