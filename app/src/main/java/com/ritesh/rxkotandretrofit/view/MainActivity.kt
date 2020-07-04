package com.ritesh.rxkotandretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ritesh.rxkotandretrofit.R
import com.ritesh.rxkotandretrofit.modals.Time
import com.ritesh.rxkotandretrofit.network.Client.time


import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prglay.visibility = View.VISIBLE


        time.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .repeatWhen { complete->complete.delay(2,TimeUnit.SECONDS) }
            .subscribe(object: Observer<Time>{
                override fun onComplete() {
                    Log.e("MainActivity","Completed")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.e("MainActivity","Subscribed")

                }

                override fun onNext(t: Time) {

                  prglay.visibility= View.INVISIBLE
                    txtv.text = t.unixtime

                }

                override fun onError(e: Throwable) {

                }
            })





    }
}
