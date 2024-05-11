package br.com.fiap.listadecompras

/**
 *  imports das classes do framework android
 */
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *  Criando classe que define o adapter para o RecyclerView, será responsável por vincular os dados da lista de itens ao RecyclerView
 */
class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    /**
     * Criando uma variável que será uma lista de itens
     */
    private val items = mutableListOf<ItemModel>()

    /**
     * Serve para adicionar um novo item na lista criada, chamando a RecyclerView com o notifyDataSetChanged(),
     * que serve para informar ao RecyclerView que as Views foram alteradas e precisam ser atualizadas
     */
    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()

    }

    /**
     * Antes de explicarmos vale entender o conceito do ViewHolder, que possuí os elementos visuais de um item no RecyclerView
     * Esse código serve para criar um novo ViewHolder que exibirá um item da lista.
     * Isso faz com que seja possível reutilizar os visuais dos itens e atualiza-los.
     *
     * Dentro dele o código serve para em tempo de execução inserir o conteúdo do layout XML que criamos para a view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)

    }

    /**
     * Servirá para contar o número de items na lista
     */
    override fun getItemCount(): Int = items.size

    /**
     * O método onBindViewHolder serve para atualizar a ViewHolder já existente com dados do item da lista na posição que for fornecida.
     * Como parâmetro recebe o ViewHolder que será atualizado e a posição do item da lista.
     * Dentro do método é recuperado o objeto item dentro da lista na posição que for fornecida e o método bind vincula os dados do item na View
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    /**
     * Essa ViewHolder apresenta a visão de cada item da RecyclerView
     */
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)

        /**
         * Atualiza a ViewHolder com os dados do item específico da posição correspondente
         */
        fun bind(item: ItemModel) {
            textView.text = item.name
        }
    }
}
