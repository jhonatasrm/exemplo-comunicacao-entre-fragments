package com.jhonatasrm.exemplo_comunicacao_entre_fragments;

import android.app.Activity;
import android.os.Bundle;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends Activity implements CarrosFragment.OnItemClick {

    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    private TextFragment textFrag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);

        textFrag = (TextFragment) getFragmentManager().findFragmentById(R.id.frag_text);
	}

    @Override
    public void onClick(Carros carros) {
        textFrag.setText(String.format("O preço do %s é %s", carros.getNome(), nf.format(carros.getPreco())));
    }
}
