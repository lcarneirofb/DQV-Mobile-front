package com.example.dqv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.dqv.API.APICaller
import com.example.dqv.API.RetrofitInitializer
import com.example.dqv.beans.*
import com.example.dqv.fragments.novaConsulta
import com.example.dqv.repositories.PessoaRepository
import com.example.dqv.services.DQV
import com.example.dqv.services.ServiceBuilder
import com.example.dqv.services.models.LoginResponse
import com.example.dqv_front.MenuActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_consultas.*
import retrofit2.*
import java.sql.Time
import java.sql.Timestamp

class MainActivity : AppCompatActivity() {
    var pessoaPerm: Pessoa? = null
        get() = pessoaPerm



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_login.setOnClickListener {

            val user: String = inpt_usuario.text.toString()
            val pass: String = inpt_senha.text.toString()


            //Verificacoes dos campos de login e senha
            if(user.isNullOrEmpty()){
                Toast.makeText(this, R.string.loginWarning, Toast.LENGTH_SHORT).show()
                txt_usuario.requestFocus()
                return@setOnClickListener
            }

            if(pass.isNullOrEmpty()){
                Toast.makeText(this, R.string.senhaWarning, Toast.LENGTH_SHORT).show()
                txt_senha.requestFocus()
                return@setOnClickListener
            }


            //começo da operacao de login

            var login: Login = Login(user,pass)

            RetrofitInitializer()
            val call = RetrofitInitializer().loginService().authenticateUser(login)
            call.enqueue(object: Callback<Pessoa?> {
                override fun onResponse(call: Call<Pessoa?>, response: Response<Pessoa?>) {
                    response?.body()?.let {
                        val pessoa: Pessoa = it


                        if(pessoa.id == null || pessoa.nome == null){
                            Toast.makeText(applicationContext,R.string.userNotFound, Toast.LENGTH_SHORT).show()
                            return
                        }
                        val pessoaRepo = PessoaRepository.getInstance()
                        if(pessoaRepo.retornaPessoa()==null){
                            pessoaRepo.configPessoa(pessoa)
                        }

                        val intent = Intent(applicationContext,MenuActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<Pessoa?>, t: Throwable) {
                    Toast.makeText(applicationContext,t?.message, Toast.LENGTH_SHORT).show()
                    println(t?.message)
                    Toast.makeText(applicationContext, "Algo de errado não está certo, "+
                            "Estudantes sedentos estão trabalhando para resolver o seu problema, NTI PLS HALP", Toast.LENGTH_SHORT).show()
                }
            })

            //fim login


            //começo consultas
            //Verificar id como parâmetro
            val callAgendamento = RetrofitInitializer().agendamentoConsultaService().getAgendamentosPessoa(1)
            callAgendamento.enqueue(object: Callback<List<AgendamentoConsulta>?> {
                override fun onResponse(call: Call<List<AgendamentoConsulta>?>,
                                        response: Response<List<AgendamentoConsulta>?>) {
                    response?.body()?.let {
                        val agendamentos: List<AgendamentoConsulta> = it
//                        for(i in agendamentos) {
//                            println(i.consulta?.especialista?.nome)
//                        }
                        Toast.makeText(applicationContext,agendamentos.get(0).id.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<AgendamentoConsulta>?>,
                                       t: Throwable?) {

                    Toast.makeText(applicationContext,t?.message, Toast.LENGTH_SHORT).show()
                    println(t?.message)
                    //Toast.makeText(applicationContext, "Algo de errado não está certo, estudantes sedentos "+
                    //        "estão trabalhando para resolver o seu problema, NTI PLS HALP", Toast.LENGTH_SHORT).show()
                }
            })

            //fim consultas

            //inicio receita

            val callReceita = RetrofitInitializer().receitaService().getReceita(2)
            callReceita.enqueue(object: Callback<Receita?> {
                override fun onResponse(call: Call<Receita?>,
                                        response: Response<Receita?>) {
                    response?.body()?.let {
                        val receita: Receita = it
//                            println(receita.id)
//                            println(receita.consulta?.observacao)
//                            println(receita.dataEmissao)
//                            println(receita.validade)
//                            println(receita.posologia)
//                            println(receita.descrição)
//                            println(receita.medicamento)
//                            println(receita.principioAtivo)
//                            println("============================")
                        Toast.makeText(applicationContext,receita.medicamento, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Receita?>,
                                       t: Throwable?) {

                    Toast.makeText(applicationContext,t?.message, Toast.LENGTH_SHORT).show()
                    println(t?.message)
                    //Toast.makeText(applicationContext, "Algo de errado não está certo, estudantes sedentos "+
                    //        "estão trabalhando para resolver o seu problema, NTI PLS HALP", Toast.LENGTH_SHORT).show()
                }
            })


            //fim receita

            //inicio receitas Paciente

            val callReceitasPaciente = RetrofitInitializer().receitaService().getReceitasPaciente(1)
            callReceitasPaciente.enqueue(object: Callback<List<Receita>?> {
                override fun onResponse(call: Call<List<Receita>?>?,
                                        response: Response<List<Receita>?>?) {
                    response?.body()?.let {
                        val receitas: List<Receita> = it
                        for(i in receitas) {
//                            println(i.id)
//                            println(i.consulta?.observacao)
//                            println(i.dataEmissao)
//                            println(i.validade)
//                            println(i.posologia)
//                            println(i.descrição)
//                            println(i.medicamento)
//                            println(i.principioAtivo)
//                            println("============================")
                            //Toast.makeText(applicationContext,receita.medicamento, Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<List<Receita>?>,
                                       t: Throwable?) {

                    Toast.makeText(applicationContext,t?.message, Toast.LENGTH_SHORT).show()
                    println(t?.message)
                    //Toast.makeText(applicationContext, "Algo de errado não está certo, estudantes sedentos "+
                    //        "estão trabalhando para resolver o seu problema, NTI PLS HALP", Toast.LENGTH_SHORT).show()
                }
            })


            //fim receitas Paciente

            //inicio receitas Consulta

            val callReceitasConsulta = RetrofitInitializer().receitaService().getReceitasConsulta(2)
            callReceitasConsulta.enqueue(object: Callback<List<Receita>?> {
                override fun onResponse(call: Call<List<Receita>?>?,
                                        response: Response<List<Receita>?>?) {
                    response?.body()?.let {
                        val receitas: List<Receita> = it
                        for(i in receitas) {
                            println(i.id)
                            println(i.consulta?.observacao)
                            println(i.dataEmissao)
                            println(i.validade)
                            println(i.posologia)
                            println(i.descrição)
                            println(i.medicamento)
                            println(i.principioAtivo)
                            println("============================")
                            //Toast.makeText(applicationContext,receita.medicamento, Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<List<Receita>?>,
                                       t: Throwable?) {

                    Toast.makeText(applicationContext,t?.message, Toast.LENGTH_SHORT).show()
                    println(t?.message)
                    //Toast.makeText(applicationContext, "Algo de errado não está certo, estudantes sedentos "+
                    //        "estão trabalhando para resolver o seu problema, NTI PLS HALP", Toast.LENGTH_SHORT).show()
                }
            })


            //fim receitas Consulta

        }
    }

}
