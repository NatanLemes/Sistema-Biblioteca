import view.EmprestimoView;
import view.LivroView;
import view.UsuarioView;

public class App {
    public static void main(String[] args) throws Exception {

        UsuarioView usuarioView = new UsuarioView();
        LivroView   livroView = new LivroView();
        EmprestimoView emprestimoView = new EmprestimoView();
        // usuarioView.insert();
        // usuarioView.buscarUsuarios();
        // usuarioView.buscarUsuarioPorCpf();
        usuarioView.LogarSistema();
        // livroView.insert();
        // livroView.buscaLivros();
        // livroView.buscaLivroPorNome();
        // emprestimoView.GerarEmprestimo();
        // emprestimoView.GerarDevolucao();


    }
}
