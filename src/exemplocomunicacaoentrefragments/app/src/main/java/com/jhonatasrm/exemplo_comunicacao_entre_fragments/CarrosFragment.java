package com.jhonatasrm.exemplo_comunicacao_entre_fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CarrosFragment extends ListFragment {

    private ArrayAdapter<Carros> adapter;
    private OnItemClick listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (!(context instanceof OnItemClick)) {
            throw new RuntimeException("A activity não implementa a interface CarrosFragment.OnItemClick");
        }

        listener = (OnItemClick) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);

        String[] nomes = getActivity().getResources().getStringArray(R.array.carros_nomes);
        String[] precos = getActivity().getResources().getStringArray(R.array.preco_carros);

        for (int i = 0; i < nomes.length; i++) {
            Carros carros = new Carros(nomes[i], Double.parseDouble(precos[i]));
            adapter.add(carros);
        }

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Carros carros = adapter.getItem(position);

        if (listener != null) {
            listener.onClick(carros);
        }
    }

    public interface OnItemClick {
        void onClick(Carros carros);
    }
}
