package com.example.urbanclone_techhelpers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.application2.Details;
import com.example.application2.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Context.MODE_PRIVATE;

public class myadapter extends FirebaseRecyclerAdapter<Model,myadapter.myviewholder>
{
    static String ab;
    Context context;
    public myadapter(@NonNull FirebaseRecyclerOptions<Model> options, Context applicationContext) {
        super(options);
        this.context=applicationContext;
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, int position, @NonNull final Model model) {
        final int p=holder.getAdapterPosition();
        holder.n.setText("Name: "+model.getName());
        holder.e.setText("Email: "+model.getEmail());
        holder.a.setText("Address: "+model.getAddress());
        holder.rb.setRating(model.getAvgrating());
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ab=holder.e.getText().toString();
                Intent intent=new Intent((context), Details.class);
                intent.putExtra("position",String.valueOf(p+1));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final CircleImageView iv;
        final TextView n,e,a;
        final RatingBar rb;
        public myviewholder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            iv=(CircleImageView)itemView.findViewById(R.id.ivm);
            n=(TextView)itemView.findViewById(R.id.tmname);
            e=(TextView)itemView.findViewById(R.id.tmaddr);
            a=(TextView)itemView.findViewById(R.id.tmemail);
            rb=(RatingBar)itemView.findViewById(R.id.rb);
            iv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //int p=this.getAdapterPosition();
            //Log.d("p",String.valueOf(p));
        }
    }

    public static String getValue(){
        return ab;
    }
}
