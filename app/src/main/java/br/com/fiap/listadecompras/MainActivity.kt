package br.com.fiap.listadecompras


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
     /**
      *  Utilizamos o SupressLint para que a função faça com que o compilador não crie avisos
      *  no caso de uma view for criada sem um ID inserido
      */
    @SuppressLint("MissingInflatedId")
    /**
     *  onCreate é utilizado para criar uma activity
     * Utilizamos o savedInstanceState para recuperar o estado de uma instance anterior quando der.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * O método onCreate é referenciado para fazer as incializações da activity de forma correta
         * Em setContentView definimos o layout da activity baseado no nosso arquivo XML que foi criado,
         * assim teremos um "modelo" de como será o visual da tela do app
         */
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * na variável recyclerView capturamos a RecyclerView do layout procurando por seu ID
         * na variável itemsAdapter criamos o adaptor dos itens
         * em recyclerView.adapter definimos o adaptador da RecyclerView
         * na variável button capturamos o botão do layout procurando por seu ID
         * na variável editText capturamos o EditText do layout procurando por seu ID
         */
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        /**
        *  Aqui criamos um listener para o botão realizar uma função quando for clicado
        */
        button.setOnClickListener {
            /**
             * Criamos um novo itemModel com o nome inserido no editText, depois adicionamos o item ao adapter
             */
            val item = ItemModel(
                name = editText.text.toString()
            )
            itemsAdapter.addItem(item)
        }
    }
 }
