package com.mohetabsem.databaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add.setOnClickListener {

            val title = ed_name.text.toString()

            val postHelper = PostsHelper(this)

            if(title.trim()!=""){

                val status = postHelper.addPost(PostsModel(0, title))

                val posts: List<PostsModel> = postHelper.viewPosts()

                listView.adapter = Adapter(this, posts )
                if(status > -1){
                    Toast.makeText(applicationContext,"record added", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(applicationContext,"title or description cannot be blank", Toast.LENGTH_LONG).show()
            }


        }



    }
    override fun onResume() {
        super.onResume()

        //creating the instance of PostHelper class
        val postHelper = PostsHelper(this)
        //calling the viewPosts method of PostsHelper class to read the records
        val posts: List<PostsModel> = postHelper.viewPosts()

        //creating custom ArrayAdapter
        //val postAdapter = PostAdapter(this, postArrayId, postArrayTitle, postArrayDescription)

        listView.adapter = Adapter(this, posts as ArrayList<PostsModel>)
    }

}