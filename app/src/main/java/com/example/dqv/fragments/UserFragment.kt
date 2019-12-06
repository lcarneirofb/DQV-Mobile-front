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
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.dqv.API.RetrofitInitializer
import com.example.dqv.MainActivity
import com.example.dqv.PageAdapter
import com.example.dqv.R
import com.example.dqv.beans.Pessoa
import com.example.dqv.repositories.PessoaRepository
import com.example.dqv_front.MenuActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.fragment_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response







// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = R.layout.fragment_user
private const val ARG_PARAM2 = R.layout.fragment_troca_senha

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [UserFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [UserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        getDataUser()


    }

    fun sendMessage(view: View) {

        // Do something in response to button
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var layout: View? = inflater.inflate(ARG_PARAM1, container, false)
        var button : Button? = layout?.findViewById(R.id.btn_confTrocaSenha)
        button?.setOnClickListener{
            val repo : PessoaRepository = PessoaRepository.getInstance()
            val pessoa = repo.retornaPessoa()

            if(inpt_senhaAtual_troca.text.toString()!!.equals(pessoa.pass) ){
                if(inpt_senhaNova_troca.text.isNullOrEmpty() || inpt_senhaNovaConf_troca.text.isNullOrEmpty()
                ){
                    Toast.makeText(context, "Digite as senhas, por favor",Toast.LENGTH_SHORT)
                    return@setOnClickListener
                }
                if(inpt_senhaNova_troca.text.toString()!!.equals(inpt_senhaNovaConf_troca.text.toString())){
                    pessoa.pass = inpt_senhaNova_troca.text.toString()
                    repo.configPessoa(pessoa)
                }
                else{
                    Toast.makeText(context, "As senhas estão diferentes, por favor, digite corretamente",Toast.LENGTH_SHORT)
                    return@setOnClickListener
                }
            }else{
                Toast.makeText(context, "A senha atual está errada, digite corretamente por favor",Toast.LENGTH_SHORT)
                return@setOnClickListener
            }


            val call = RetrofitInitializer().pessoaService().updatePessoa(pessoa)
            call.enqueue(object: retrofit2.Callback<Pessoa?>{
                override fun onResponse(call: Call<Pessoa?>,response: Response<Pessoa?>){
                    response.body()?.let{
                        val pessoaResponse = it
                        println("trocou")
                        Toast.makeText(context, "Troca efetuada com sucesso",Toast.LENGTH_SHORT)
                    }
                }
                override fun onFailure(call: Call<Pessoa?>, t:Throwable){
                    println("nàotrocou")
                    Toast.makeText(context, "Não foi possível completar essa troca, tente mais tarde!",Toast.LENGTH_SHORT)
                }
            })

        }
        getDataUser()
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
         * @return A new instance of fragment UserFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            UserFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
    fun getDataUser(){
        val pessoaRepo = PessoaRepository.getInstance()
        var pessoa = pessoaRepo.retornaPessoa()


        RetrofitInitializer()
        val call = RetrofitInitializer().pessoaService().getPessoa(pessoa.id!!.toInt())
        call.enqueue(object: Callback<Pessoa?> {
            override fun onResponse(call: Call<Pessoa?>, response: Response<Pessoa?>) {
                response?.body()?.let {
                    val pessoa: Pessoa = it

                    txt_nome_user.text = pessoa?.nome
                    txt_cpf_user.text = pessoa?.cpf
                    txt_telefone_user.text = pessoa?.telefone
                    txt_datansc_user.text = pessoa?.dataNascimento.toString()
                    txt_rg_user.text = pessoa?.rg
                    txt_estcivil_user.text = pessoa?.estadoCivil.toString()
                    txt_sexo_user.text = pessoa?.sexo.toString()
                    txt_email_user.text = pessoa?.email
                    txt_logradouro_user.text = pessoa?.endereco?.logradouro
                    txt_cidade_user.text = pessoa?.endereco?.cidade
                    txt_cep_user.text = pessoa?.endereco?.cep
                    txt_numeroend_user.text = pessoa?.endereco?.numero.toString()
                    txt_uf_user.text = pessoa?.endereco?.uf
                }
            }

            override fun onFailure(call: Call<Pessoa?>, t: Throwable) {
                Toast.makeText(context,t?.message, Toast.LENGTH_SHORT).show()
                println(t?.message)
                Toast.makeText(context, "Algo de errado não está certo, "+
                        "Estudantes sedentos estão trabalhando para resolver o seu problema, NTI PLS HALP", Toast.LENGTH_SHORT).show()
            }
        })

    }


}
