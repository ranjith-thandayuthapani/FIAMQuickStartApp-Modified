package com.google.firebase.fiamquickstart

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.firebase.example.internal.BaseEntryChoiceActivity
import com.firebase.example.internal.Choice
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.fiamquickstart.java.MainActivity
import com.google.firebase.fiamquickstart.kotlin.KotlinMainActivity
import com.google.firebase.inappmessaging.FirebaseInAppMessaging
import com.google.firebase.inappmessaging.inAppMessaging
import com.google.firebase.installations.installations
import com.google.firebase.fiamquickstart.R

class EntryChoiceActivity : BaseEntryChoiceActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var firebaseIam: FirebaseInAppMessaging

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAnalytics = Firebase.analytics
        firebaseIam = Firebase.inAppMessaging

        firebaseIam.isAutomaticDataCollectionEnabled = true
        firebaseIam.setMessagesSuppressed(false)


        findViewById<Button>(com.google.firebase.inappmessaging.display.R.id.button).setOnClickListener {
            firebaseAnalytics.logEvent("engagement_party_two", Bundle())
        }

    }

    override fun getChoices(): List<Choice> {
        return listOf(
            Choice(
                "Java",
                "Run the Firebase In App Messaging quickstart written in Java.",
                Intent(this, MainActivity::class.java),
            ),
            Choice(
                "Kotlin",
                "Run the Firebase In App Messaging quickstart written in Kotlin.",
                Intent(this, KotlinMainActivity::class.java),
            ),
        )
    }
}
