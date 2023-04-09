package com.example.miuapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.miuapp.databinding.ActivitySigninBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val obj = ArrayList<User>()
        obj.add(User("Bisrat", "Alemu", "bisratbetre5@gmail.com", "123"))
        obj.add(User("Jane", "Doe", "jane.doe@gmail.com", "123"))
        obj.add(User("Bob", "Smith", "bob.smith@gmail.com", "123"))
        obj.add(User("Alice", "Smith", "alice.smith@gmail.com", "123"))
        obj.add(User("Mark", "Johnson", "mark.johnson@gmail.com", "123"))



        val signinBtn = binding.signin
        signinBtn.setOnClickListener{
            val firstName: String?= intent.getStringExtra("fname")
            val lastName: String?= intent.getStringExtra("lname")
            val newPassword: String?= intent.getStringExtra("newPassword")
            val newEmail: String?= intent.getStringExtra("newEmail")

            if(firstName!=null && lastName!=null && newPassword!=null && newEmail!=null){
                val newUser = User(firstName,lastName,newEmail,newPassword)
                if(!obj.contains(newUser)){
                    obj?.add(newUser)
                }
            }

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            var found= false
            val intent = Intent(this, shoppingCategory::class.java)
            obj.forEach{ user -> if((email.equals(user.userName) )&& password.equals(user.password)){
                intent.putExtra("info",user.userName)
                found=true
            } }
            if (found){

                startActivity(intent)
                return@setOnClickListener
            }
            else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
        val createNewAccountBtn = binding.newAccount
        createNewAccountBtn.setOnClickListener{
            val intent = Intent(this,SignUp::class.java )
            startActivity(intent)

            return@setOnClickListener
        }
        fun isValidEmail(email: String): Boolean {
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            return email.matches(emailPattern.toRegex())
        }
      val forgotPassword = binding.forgotPassword
        forgotPassword.setOnClickListener{
            val username = binding.email.text.toString()
            var isValid= false

            obj.forEach { user -> if(user.userName.equals(username)&& isValidEmail(username)){
                isValid= true
                val intent = Intent(Intent.ACTION_SEND)
                intent.data= Uri.parse("mailto:${user.userName}")
                intent.putExtra(Intent.EXTRA_SUBJECT,"Your old password")
                intent.putExtra(Intent.EXTRA_TEXT, "your old password is ${user.password}")
                startActivity(intent)
            }}

            if(isValid){
                Toast.makeText(this, "Your old password is sent to the username you provided", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "Invalid email address or email address does not exist", Toast.LENGTH_SHORT).show()
            }


        }



    }
}