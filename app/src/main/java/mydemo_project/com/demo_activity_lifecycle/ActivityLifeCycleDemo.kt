package mydemo_project.com.demo_activity_lifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity__life__cycle.*
import android.view.ViewTreeObserver
import android.R.attr.start
import android.animation.ObjectAnimator
import android.content.Intent
import android.support.v4.content.ContextCompat


class ActivityLifeCycleDemo : AppCompatActivity() {

    private var expandable: Boolean = true
    private var expand: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__life__cycle)
        Log.i("TAG ==>", "In onCreate")

        Log.i("TAG ==>", "Number of lines ==>" + descriptionText.lineCount)
        descriptionText.text = "J-1 Jhalawar, LBS Rd, Nityanand Nagar, Ghatkopar West, Mumbai, Maharashtra 400086, India"


        descriptionText.viewTreeObserver.addOnGlobalLayoutListener {
            if (expandable) {
                expandable = false
                if (descriptionText.lineCount > 1) {
                    showMore.visibility = View.VISIBLE
                    val animation = ObjectAnimator.ofInt(descriptionText, "maxLines", 1)
                    animation.setDuration(0).start()
                }
            }
        }

        showMore.setOnClickListener {
            if (!expand) {
                expand = true
                val animation = ObjectAnimator.ofInt(descriptionText, "maxLines", 10)
                animation.setDuration(100).start()
            } else {
                expand = false
                val animation = ObjectAnimator.ofInt(descriptionText, "maxLines", 1)
                animation.setDuration(100).start()
            }
        }

        openWebView.setOnClickListener {
            val intent = Intent(this, HRMSLeave::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("TAG ==>", "In onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("TAG ==>", "In onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("TAG ==>", "In onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("TAG ==>", "In onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("TAG ==>", "In onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TAG ==>", "In onDestroy")
    }
}
