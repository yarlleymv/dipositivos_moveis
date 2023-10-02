package com.example.teladelogin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Cadastrodedados : AppCompatActivity(), View.OnClickListener {
    private lateinit var editTextIDusuario: EditText
    private lateinit var editTextNome: EditText
    private lateinit var editTextDatadenascimento: EditText
    private lateinit var editTexttelefone: EditText
    private lateinit var cadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrodedados)

        editTextIDusuario = findViewById<EditText>(R.id.editTextText)
        editTextNome = findViewById<EditText>(R.id.editTextText2)
        editTextDatadenascimento = findViewById<EditText>(R.id.textView5)
        editTexttelefone = findViewById<EditText>(R.id.editTextPhone2)
        cadastrar = findViewById<Button>(R.id.button4)


        val arquivo = getSharedPreferences( "Niver", Context.MODE_PRIVATE)

        cadastrar.setOnClickListener(this)
        editTextIDusuario.setText(arquivo.getString("ID", ""))
        editTextNome.setText(arquivo.getString("Nome", ""))
        editTextDatadenascimento.setText(arquivo.getString("Data de Nascimento", ""))
        editTexttelefone.setText(arquivo.getString("Telefone", ""))
    }

    override fun onClick(view: View?) {
        var arquivo = getSharedPreferences( "Niver", MODE_PRIVATE)

        var ID = arquivo.getString("ID", "")
        var Nome = arquivo.getString("Nome", "")
        var Data_nascimento = arquivo.getString("Data", "")
        var Telefone = arquivo.getString("Telefone", "")

        if (editTextIDusuario.text. toString().equals("")
            or editTextNome.text. toString().equals("")
            or editTextDatadenascimento. toString().equals("")
            or editTexttelefone. toString().equals("")
            ){
            Toast.makeText(
            this,
            "Preencha todos os campos",
            Toast.LENGTH_LONG
            ).show()
        }

        else if (ID == "" && Nome == "" && Data_nascimento == "" && Telefone == ""){

            var editor = arquivo.edit()
            editor.putString("ID", editTextIDusuario.text. toString())
            editor.putString("Nome", editTextNome.text. toString())
            editor.putString("Data", editTextDatadenascimento. toString())
            editor.putString("Telefone",editTexttelefone. toString())

            editor.commit()
            Toast.makeText(
                this,
                "Dados Salvos com sucesso",
                Toast.LENGTH_LONG
            ).show()
        }
        else if (editTextIDusuario.text. toString().equals(ID)
            and editTextNome.text. toString().equals(Nome)
            and editTextDatadenascimento. toString().equals(Data_nascimento)
            and editTexttelefone. toString().equals(Telefone)
            ){
            Toast.makeText(
                this,
                "Dados já cadastrados \n" +
                "ID: ${editTextIDusuario.text} \n" +
                "Nome: ${editTextNome.text} \n" +
                "Data: ${editTextDatadenascimento.text} \n" +
                "Telefone: ${editTexttelefone.text} \n",
                Toast.LENGTH_LONG
            ).show()
        }

        else{
            var editor = arquivo.edit()
            editor.putString("ID", editTextIDusuario.text. toString())
            editor.putString("Nome", editTextNome.text. toString())
            editor.putString("Data", editTextDatadenascimento. toString())
            editor.putString("Telefone",editTexttelefone. toString())

            editor.commit()

            Toast.makeText(
                this,
                "Dados salvos",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    }


