package com.brunoeleodoro.org.firstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.brunoeleodoro.org.firstkotlinapp.adapters.ShowsAdapter
import com.brunoeleodoro.org.firstkotlinapp.domain.Show
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        series()
    }
    fun series()
    {
        val request = StringRequest(Request.Method.GET,"http://api.tvmaze.com/shows?language=english",
                Response.Listener { response ->
                    val array = JSONArray(response)
                    var i = 0
                    val shows = ArrayList<Show>()
                    while(i < array.length())
                    {
                        val item = array.getJSONObject(i)
                        val show = Show(   item.getString("name"),
                                item.getString("language"),
                                item.getJSONObject("image").getString("medium")
                            )
                        shows.add(show)
                        Log.i("script","name="+item.getString("name"))
                        i++
                    }
                    recyclerView.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
                    //recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                    recyclerView.adapter = ShowsAdapter(this,shows)

                },
                Response.ErrorListener { error: VolleyError? -> Log.i("script","erro="+error) })

        Volley.newRequestQueue(this).add(request)
    }
}

