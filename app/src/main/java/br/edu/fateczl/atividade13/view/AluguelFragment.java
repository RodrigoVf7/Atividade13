package br.edu.fateczl.atividade13.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.fateczl.atividade13.Persistence.AluguelDao;
import br.edu.fateczl.atividade13.R;
import br.edu.fateczl.atividade13.controller.AluguelController;
import br.edu.fateczl.atividade13.model.Aluguel;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class AluguelFragment extends Fragment {
    private AluguelDao aluguelDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aluguel, container, false);

        EditText editCodigo = view.findViewById(R.id.editCodigo);  // exemplarCodigo
        EditText editRA = view.findViewById(R.id.editRA);          // alunoRA
        EditText editDataRetirada = view.findViewById(R.id.editDataRetirada); // dataRetirada
        EditText editDataDevolucao = view.findViewById(R.id.editDataDevolucao); // dataDevolucao
        Button btnSalvar = view.findViewById(R.id.btnSalvar);
        TextView textLista = view.findViewById(R.id.textLista);
        //os comentarios desse fragment serve para os outros tbm;
        // Inicializando o AluguelDao
        aluguelDao = new AluguelDao(getActivity());

        btnSalvar.setOnClickListener(v -> {
            // Coletando os dados dos campos
            int exemplarCodigo = Integer.parseInt(editCodigo.getText().toString());
            int alunoRA = Integer.parseInt(editRA.getText().toString());
            String dataRetirada = editDataRetirada.getText().toString();
            String dataDevolucao = editDataDevolucao.getText().toString();

            // Criando o objeto Aluguel com os dados coletados
            Aluguel aluguel = new Aluguel(exemplarCodigo, alunoRA, dataRetirada, dataDevolucao);

            // Inserindo o aluguel no banco de dados
            aluguelDao.insert(aluguel);

            // Exibindo a lista de alugueis
            textLista.setText(aluguelDao.findAll().toString());
        });

        return view;
    }
}

