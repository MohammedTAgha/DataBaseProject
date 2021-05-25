package com.mohetabsem.databaseproject


import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.list_item.view.*


class Adapter(context: Context,
                    private val posts: List<PostsModel>) :
    ArrayAdapter<PostsModel>(context, R.layout.list_item, posts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val l:LayoutInflater = LayoutInflater.from(context)
        val View = l.inflate(R.layout.list_item, parent, false)
        View.Title.text = posts[position].Title

        return View
    }
}