package com.example.dqv.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.dqv.API.RetrofitInitializer
import com.example.dqv.MainActivity
import com.example.dqv.R
import com.example.dqv.beans.AgendamentoConsulta
import com.example.dqv_front.MenuActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_consultas.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ConsultasFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    //var btn: FloatingActionButton? = btn_novaConsulta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataAgendamentos()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var layout: View? = inflater.inflate(R.layout.fragment_consultas, container, false)


        getDataAgendamentos()

        return layout
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


    fun getDataAgendamentos(){
        val callAgendamento = RetrofitInitializer().agendamentoConsultaService().getAgendamentosPessoa(1)
        callAgendamento.enqueue(object: Callback<List<AgendamentoConsulta>?> {
            override fun onResponse(call: Call<List<AgendamentoConsulta>?>,
                                    response: Response<List<AgendamentoConsulta>?>) {
                response?.body()?.let {
                    val agendamentos: List<AgendamentoConsulta> = it
                            for(i in agendamentos) {
                                txt_especialidade.text = i.consulta?.especialista?.especialidade?.name
                                txt_nome_medico.text = getResources().getString(R.string.nomeMedico) + i.consulta?.especialista?.nome
                                if(i.consulta?.status == true){
                                    txt_status_consulta.text = getResources().getString(R.string.statusConsultaC)
                                }else{
                                    txt_status_consulta.text = getResources().getString(R.string.statusConsultaCan)
                                }
                                txt_data.text = i.consulta?.horario?.horaInico.toString()

                                if(txt_especialidade.text == "ASSISTENTE_SOCIAL"){
                                    img_consultTypeIcon.setImageResource(R.drawable.img_socialas)
                                }else if(txt_especialidade.text == "PSICOLOGO"){
                                    img_consultTypeIcon.setImageResource(R.drawable.img_psicologo)
                                }else if(txt_especialidade.text == "NUTRICIONISTA"){
                                    img_consultTypeIcon.setImageResource(R.drawable.img_nutricionista)
                                }else if(txt_especialidade.text == "ORTODONTISTA"){
                                    img_consultTypeIcon.setImageResource(R.drawable.img_ortodontista)
                                }else if(txt_especialidade.text == "MEDICO"){
                                    img_consultTypeIcon.setImageResource(R.drawable.img_medico)
                                }
                            }

                }
            }

            override fun onFailure(call: Call<List<AgendamentoConsulta>?>,
                                   t: Throwable?) {

                Toast.makeText(context, t?.message, Toast.LENGTH_SHORT).show()
                println(t?.message)
                //Toast.makeText(applicationContext, "Algo de errado não está certo, estudantes sedentos "+
                //        "estão trabalhando para resolver o seu problema, NTI PLS HALP", Toast.LENGTH_SHORT).show()
            }

        })

    }
}
