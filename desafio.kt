enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class UsuarioJaCadastradoException(mensagem: String) : Exception(mensagem)

data class Usuario(var name: String, var email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, var nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {

        inscritos.apply{
            if(none{it.email==usuario.email}){
                add(usuario)
                println("Usuario cadastrado com sucesso")
            }else if(equals(usuario)){
                println("Usuario ja inscrito")
            }else{
                throw UsuarioJaCadastradoException("Email ja Cadastrado");
            }
        }
    }
}


fun main() {

    val teste1=Formacao("Teste1",mutableListOf(ConteudoEducacional("ce1")),Nivel.BASICO)
    val teste2=Formacao("Teste2",mutableListOf(ConteudoEducacional("ce2")),Nivel.BASICO)
    val teste3=Formacao("Teste3",mutableListOf(ConteudoEducacional("ce3")),Nivel.BASICO)
    val teste4=Formacao("Teste4",mutableListOf(ConteudoEducacional("ce4")),Nivel.BASICO)
    teste1.matricular(Usuario("nome1","nome1@gmail.com"))
    try{
        teste1.matricular(Usuario("nome2","nome1@gmail.com"))
    } catch( e: UsuarioJaCadastradoException){
        println("Exceção capturada: ${e.message}")
    }

    teste1.matricular(Usuario("nome1","nome2@gmail.com"))

    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}