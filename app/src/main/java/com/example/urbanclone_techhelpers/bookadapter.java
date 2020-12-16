package com.example.urbanclone_techhelpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application2.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class bookadapter extends FirebaseRecyclerAdapter<Book,bookadapter.vwholder> {
    Context context;
    String b=myadapter.getValue();
    //    SharedPreferences sharedPreferences = context.getSharedPreferences("te", MODE_PRIVATE);
//    final String value = sharedPreferences.getString("value","");
    public bookadapter(@NonNull FirebaseRecyclerOptions<Book> options, Context applicationContext) {
        super(options);
        this.context=applicationContext;
    }

    @Override
    protected void onBindViewHolder(@NonNull bookadapter.vwholder holder, int position, @NonNull Book book) {
        holder.u.setText("Service Provider: " + book.getTechemail());
        //holder.srt.setRating(feed.getRating());
        holder.dt.setText("Date: " + book.getDate());
        holder.time.setText("Time: " + book.getTime());
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
    public bookadapter.vwholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bookingcard,parent,false);
        return new bookadapter.vwholder(view);
    }

    class vwholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final TextView u,dt,time;
        //final RatingBar srt;
        public vwholder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            u=(TextView)itemView.findViewById(R.id.useremail);
            dt=(TextView)itemView.findViewById(R.id.date);
            time=(TextView)itemView.findViewById(R.id.time);
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

