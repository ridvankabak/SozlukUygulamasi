package com.example.sozlukuygulamasi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KelimeAdapter extends RecyclerView.Adapter<KelimeAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Kelimeler> kelimelerList;

    public KelimeAdapter(Context mContext, List<Kelimeler> kelimelerList) {
        this.mContext = mContext;
        this.kelimelerList = kelimelerList;
    }


    public class  CardTasarimTutucu extends RecyclerView.ViewHolder{
        private TextView textViewIngilizce,textViewTurkce;
        private CardView kelime_card;


        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            kelime_card = itemView.findViewById(R.id.kelime_card);
            textViewTurkce = itemView.findViewById(R.id.textViewTurkce);
            textViewIngilizce = itemView.findViewById(R.id.textViewIngilizce);


        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_sozluk,parent,false);

        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardTasarimTutucu holder, int position) {
        final Kelimeler kelime = kelimelerList.get(position);
        holder.textViewIngilizce.setText(kelime.getIngilizce());
        holder.textViewTurkce.setText(kelime.getTurkce());

        holder.kelime_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext,DetayActivity.class);
                i.putExtra("nesne",kelime);
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kelimelerList.size();
    }
}
