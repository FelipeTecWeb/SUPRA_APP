package br.com.supra.gestaoescolar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by felip on 16/05/2018.
 */

class TurmasAdapter extends BaseAdapter {

    private final Context context;
    private final List<Turma> listaTurmas;

    public TurmasAdapter(Context context, List<Turma> listaTurmas) {
        this.context = context;
        this.listaTurmas = listaTurmas;
    }

    @Override
    public int getCount() {
        return listaTurmas != null? listaTurmas.size():0;
    }

    @Override
    public Object getItem(int posicao) {
        return listaTurmas.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        // Infla a View
        View viewText = LayoutInflater.from(context).inflate(R.layout.activity_boletim, viewGroup, false);
        // Procura elementos de tela para atualizar
        TextView t = (TextView)viewText.findViewById(R.id.textItemList);

        Turma turma = listaTurmas.get(posicao);

        return viewText;
    }

    public List<Turma> getList(){
        return listaTurmas;
    }

}
