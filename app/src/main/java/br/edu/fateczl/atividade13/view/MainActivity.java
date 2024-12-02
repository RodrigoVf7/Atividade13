package br.edu.fateczl.atividade13.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import br.edu.fateczl.atividade13.R;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/


public class MainActivity extends AppCompatActivity {

    private Button btnLivro, btnRevista, btnAluguel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLivro = findViewById(R.id.btnLivro);
        btnRevista = findViewById(R.id.btnRevista);
        btnAluguel = findViewById(R.id.btnAluguel);

        btnLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Substitui o fragment para LivroFragment
                replaceFragment(new LivroFragment());
            }
        });

        btnRevista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Substitui o fragment para RevistaFragment
                replaceFragment(new RevistaFragment());
            }
        });

        btnAluguel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AluguelFragment());
            }
        });

        if (savedInstanceState == null) {
            replaceFragment(new LivroFragment());
        }
    }

    // Método para substituir o fragment atual
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment); // 'fragment_container' é o ID do seu contêiner de fragmentos
        transaction.addToBackStack(null); // Adiciona o fragment à pilha de navegação
        transaction.commit();
    }
}

