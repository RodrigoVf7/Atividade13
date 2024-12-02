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
import br.edu.fateczl.atividade13.controller.AlunoController;
import br.edu.fateczl.atividade13.model.Aluno;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class AlunoFragment extends Fragment {
    private AlunoController alunoController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aluno, container, false);

        EditText editCodigo = view.findViewById(R.id.editCodigo);
        EditText editNome = view.findViewById(R.id.editNome);
        EditText editCpf = view.findViewById(R.id.editCpf);
        EditText editEmail = view.findViewById(R.id.editEmail);
        TextView textLista = view.findViewById(R.id.textLista);
        Button btnSalvar = view.findViewById(R.id.btnSalvar);

        alunoController = new AlunoController(getActivity());


        btnSalvar.setOnClickListener(v -> {

            int codigo = Integer.parseInt(editCodigo.getText().toString());
            String nome = editNome.getText().toString();
            String cpf = editCpf.getText().toString();
            String email = editEmail.getText().toString();

            Aluno aluno = new Aluno(codigo, nome,email);

            alunoController.insertAluno(aluno);

            textLista.setText(alunoController.getAllAlunos().toString());
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        alunoController = null;
    }
}