package com.example.teladelogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var editTextUsuario: EditText
    private lateinit var editTextTextadmin123: EditText
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arquivo = getSharedPreferences("login_senha", Context.MODE_PRIVATE)
        button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener(this)

        editTextUsuario = findViewById(R.id.editTextUsuario)
        editTextTextadmin123 = findViewById(R.id.editTextTextadmin123)

        editTextUsuario.setText(arquivo.getString("login", ""))
        editTextTextadmin123.setText(arquivo.getString("senha", ""))

    }


    override fun onClick(view: View?) {
            val arquivo = getSharedPreferences("login_senha", Context.MODE_PRIVATE)

            var login = arquivo.getString("login", "")
            var senha = arquivo.getString("senha", "")

            if (login == "" && senha == ""){

            val editor = arquivo.edit()
            editor.putString("login", editTextUsuario.text.toString())
            editor.putString("senha", editTextTextadmin123.text.toString())
            editor.commit()

            Toast.makeText(
                this,
                "Seja bem vindo", //
                Toast.LENGTH_LONG
            ).show()
        }

        else if (editTextUsuario.text.toString().equals(login)
            and editTextTextadmin123.text.toString().equals(senha)){

            val intent = Intent (this, Cadastrodedados::class.java)
                startActivity(intent)

                Toast.makeText(
                    this,
                    "login e senha corretos!",
                    Toast.LENGTH_LONG
                ).show()
        }

        else {
                Toast.makeText(
                    this,
                    "Usuário e/ou senha inválidos!", //
                    Toast.LENGTH_LONG
                ).show()

            }
    }

}



   /* private fun formulário() : Boolean{

        var error = false

        if (editTextUsuario.text.isEmpty()){

            editTextUsuario.error = "Digite seu usuário"
            error = true
        }

        if (editTextTextadmin123.text.isEmpty()){

            editTextTextadmin123.error = "Digite sua senha"
            error = true
        }

        return error
    }
*/
