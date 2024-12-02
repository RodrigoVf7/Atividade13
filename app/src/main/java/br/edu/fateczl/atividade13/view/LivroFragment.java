package br.edu.fateczl.atividade13.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import br.edu.fateczl.atividade13.R;
import br.edu.fateczl.atividade13.Persistence.LivroDao;
import br.edu.fateczl.atividade13.model.Livro;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class LivroFragment extends Fragment {
    private LivroDao livroDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_livro, container, false);

        // Inicializando as views
        EditText editCodigo = view.findViewById(R.id.editCodigo);
        EditText editPaginas = view.findViewById(R.id.editPaginas);
        EditText editISBN = view.findViewById(R.id.editISBN);
        EditText editEdicao = view.findViewById(R.id.editEdicao);
        EditText editNome = view.findViewById(R.id.editNome);
        TextView textLista = view.findViewById(R.id.textLista);
        Button btnSalvar = view.findViewById(R.id.btnSalvar);

        livroDao = new LivroDao(getActivity());

        btnSalvar.setOnClickListener(v -> {
            try {
                // Coletando os dados dos campos com validação
                String codigoStr = editCodigo.getText().toString();
                String paginasStr = editPaginas.getText().toString();
                String ISBN = editISBN.getText().toString();
                String edicaoStr = editEdicao.getText().toString();
                String nome = editNome.getText().toString(); // Pegar o nome do livro

                // Validação de entrada
                if (codigoStr.isEmpty() || paginasStr.isEmpty() || ISBN.isEmpty() || edicaoStr.isEmpty() || nome.isEmpty()) {
                    Toast.makeText(getContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int codigo = Integer.parseInt(codigoStr);
                int paginas = Integer.parseInt(paginasStr);
                int edicao = Integer.parseInt(edicaoStr);

                Livro livro = new Livro(codigo, nome, paginas, ISBN, edicao);  // Agora passa o nome

                livroDao.insert(livro);

                textLista.setText(livroDao.findAll().toString());

            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Erro ao inserir dados. Verifique os valores numéricos.", Toast.LENGTH_SHORT).show();
            }
        });

        // Retornando a view do fragment
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (livroDao != null) {
            livroDao.close();
        }
    }
}


