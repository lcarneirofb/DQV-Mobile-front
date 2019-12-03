package com.example.dqv.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dqv.API.RetrofitInitializer
import com.example.dqv.R
import com.example.dqv.beans.Receita
import kotlinx.android.synthetic.main.fragment_consultas.*
import kotlinx.android.synthetic.main.fragment_receitas.*
import kotlinx.android.synthetic.main.fragment_receitas.txt_especialidade
import kotlinx.android.synthetic.main.fragment_receitas.txt_nome_medico
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.Timestamp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ReceitasFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ReceitasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReceitasFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        getDataReceitas()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout: View? =  inflater.inflate(R.layout.fragment_receitas, container, false)

        getDataReceitas()

        return layout
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReceitasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReceitasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun getDataReceitas(){
        val callReceitasPaciente = RetrofitInitializer().receitaService().getReceitasPaciente(1)
        callReceitasPaciente.enqueue(object: Callback<List<Receita>?> {
            override fun onResponse(call: Call<List<Receita>?>?,
                                    response: Response<List<Receita>?>?) {
                response?.body()?.let {
                    val receitas: List<Receita> = it
                    //val dataformato: LocalDate
                    for(i in receitas) {
                            txt_especialidade.text = i.consulta?.especialista?.especialidade?.name
                            txt_nome_medico.text = getResources().getString(R.string.nomeMedico) + i.consulta?.especialista?.nome
                            txt_data_emissao.text = getResources().getString(R.string.dtEmissao) + i.dataEmissao
                            txt_validade.text = getResources().getString(R.string.dtValidade) + i.validade?.capitalize()
                            txt_posologia.text = getResources().getString(R.string.posologiaRec) + i.posologia
                            txt_descricao.text = getResources().getString(R.string.descricaoRec) + i.descrição
                            txt_medicamento.text = getResources().getString(R.string.nomeMedicamento) + i.medicamento
                            txt_prin_ativo.text = getResources().getString(R.string.prinAtivoRec) + i.principioAtivo
                            if(txt_especialidade.text == "ASSISTENTE_SOCIAL"){
                                img_recipeTypeIcon.setImageResource(R.drawable.img_socialas)
                            }else if(txt_especialidade.text == "PSICOLOGO"){
                                img_recipeTypeIcon.setImageResource(R.drawable.img_psicologo)
                            }else if(txt_especialidade.text == "NUTRICIONISTA"){
                                img_recipeTypeIcon.setImageResource(R.drawable.img_nutricionista)
                            }else if(txt_especialidade.text == "ORTODONTISTA"){
                                img_recipeTypeIcon.setImageResource(R.drawable.img_ortodontista)
                            }else if(txt_especialidade.text == "MEDICO"){
                                img_recipeTypeIcon.setImageResource(R.drawable.img_medico)
                            }
                    }

                }
            }

            override fun onFailure(call: Call<List<Receita>?>,
                                   t: Throwable?) {

                Toast.makeText(context,t?.message, Toast.LENGTH_SHORT).show()
                println(t?.message)
                //Toast.makeText(applicationContext, "Algo de errado não está certo, estudantes sedentos "+
                //        "estão trabalhando para resolver o seu problema, NTI PLS HALP", Toast.LENGTH_SHORT).show()
            }
        })

    }
}
