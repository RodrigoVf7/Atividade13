package br.edu.fateczl.atividade13.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.fateczl.atividade13.R;
import br.edu.fateczl.atividade13.controller.RevistaController;
import br.edu.fateczl.atividade13.model.Revista;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/


public class RevistaFragment extends Fragment {
    private RevistaController revistaController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_revista, container, false);

        // Inicializando as views
        EditText editCodigo = view.findViewById(R.id.editCodigo);
        EditText editNome = view.findViewById(R.id.editNome);
        EditText editQtdPaginas = view.findViewById(R.id.editQtdPaginas);
        EditText editIsbn = view.findViewById(R.id.editIsbn);
        EditText editEdicao = view.findViewById(R.id.editEdicao);
        TextView textLista = view.findViewById(R.id.textLista);
        Button btnSalvar = view.findViewById(R.id.btnSalvar);

        revistaController = new RevistaController(getActivity());


        btnSalvar.setOnClickListener(v -> {
            int codigo = Integer.parseInt(editCodigo.getText().toString());
            String nome = editNome.getText().toString();
            int qtdPaginas = Integer.parseInt(editQtdPaginas.getText().toString());
            String isbn = editIsbn.getText().toString();
            int edicao = Integer.parseInt(editEdicao.getText().toString());

            Revista revista = new Revista(codigo, nome, qtdPaginas, isbn, edicao);

            revistaController.insertRevista(revista);

            textLista.setText(revistaController.getAllRevistas().toString());
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        revistaController = null;
    }
}
