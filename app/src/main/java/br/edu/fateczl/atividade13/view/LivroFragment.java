package br.edu.fateczl.atividade13.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import br.edu.fateczl.atividade13.R;
import br.edu.fateczl.atividade13.controller.LivroDao;
import br.edu.fateczl.atividade13.model.Livro;

public class LivroFragment extends Fragment {
    private LivroDao livroDao = new LivroDao();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_livro, container, false);

        EditText editCodigo = view.findViewById(R.id.editCodigo);
        EditText editPaginas = view.findViewById(R.id.editPaginas);
        EditText editISBN = view.findViewById(R.id.editISBN);
        EditText editEdicao = view.findViewById(R.id.editEdicao);
        TextView textLista = view.findViewById(R.id.textLista);
        Button btnSalvar = view.findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(v -> {
            int codigo = Integer.parseInt(editCodigo.getText().toString());
            int paginas = Integer.parseInt(editPaginas.getText().toString());
            String ISBN = editISBN.getText().toString();
            int edicao = Integer.parseInt(editEdicao.getText().toString());

            Livro livro = new Livro(codigo, paginas, ISBN, edicao);
            livroDao.insert(livro);

            textLista.setText(livroDao.findAll().toString());
        });

        return view;
    }
}
