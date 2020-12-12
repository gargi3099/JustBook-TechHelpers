package com.example.urbanclone_techhelpers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application2.Details;
import com.example.application2.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import static android.content.Context.MODE_PRIVATE;


public class myfeedadapter extends FirebaseRecyclerAdapter<Feed,myfeedadapter.vwholder> {
    Context context;
    String b=myadapter.getValue();
//    SharedPreferences sharedPreferences = context.getSharedPreferences("te", MODE_PRIVATE);
//    final String value = sharedPreferences.getString("value","");
    public myfeedadapter(@NonNull FirebaseRecyclerOptions<Feed> options, Context applicationContext) {
        super(options);
        this.context=applicationContext;
    }

    @Override
    protected void onBindViewHolder(@NonNull vwholder holder, int position, @NonNull Feed feed) {
        // Boolean t= value.equals(feed.getTechemail());
        //Toast.makeText(context, "value" + b + " " + "email" + feed.getTechemail(), Toast.LENGTH_LONG).show();
        holder.u.setText("User: " + feed.getEmail());
            //holder.srt.setRating(feed.getRating());
            holder.rt.setText("Rating: " + feed.getRating());
            holder.ct.setText("Comment: " + feed.getComment());
        }


//        holder.u.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent((context), Details.class);
//                intent.putExtra("position",String.valueOf(p+1));
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//
//            }
//        });




    @NonNull
    @Override
    public vwholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlecard,parent,false);
        return new vwholder(view);
    }

    class vwholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final TextView u,rt,ct;
        //final RatingBar srt;
        public vwholder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            u=(TextView)itemView.findViewById(R.id.useremail);
            rt=(TextView)itemView.findViewById(R.id.rate);
            ct=(TextView)itemView.findViewById(R.id.review);
            //srt=(RatingBar)itemView.findViewById(R.id.rbf);
            u.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //int p=this.getAdapterPosition();
            //Log.d("p",String.valueOf(p));
        }
    }
}
