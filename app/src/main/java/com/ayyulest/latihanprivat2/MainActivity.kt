package com.ayyulest.latihanprivat2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.ayyulest.latihanprivat2.adapter.PostItemAdapter
import com.ayyulest.latihanprivat2.rest.ApiClient
import com.ayyulest.latihanprivat2.rest.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_list_post.layoutManager=LinearLayoutManager(this)
        val service:ApiService=ApiClient.client()
        service.getALLPost().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                rv_list_post.adapter=PostItemAdapter(it, this)
            }

    }
}
