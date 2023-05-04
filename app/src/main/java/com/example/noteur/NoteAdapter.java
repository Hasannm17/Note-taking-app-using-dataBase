package com.example.noteur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes=new ArrayList<>();

    private  onItemClickListner listener;


    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);


        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
Note currentNote=notes.get(position);
holder.txtTitle.setText(currentNote.getTitle());
holder.txtDescription.setText(currentNote.getDescription());



    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
public void setNotes(List<Note> notes){
        this.notes=notes;
        notifyDataSetChanged();
}


public Note getNotes(int posotion){
        return notes.get(posotion);

}
    class NoteHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        TextView txtDescription;


        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle=itemView.findViewById(R.id.textviewtitle);
            txtDescription =itemView.findViewById(R.id.textViewDescription);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 int position =getAdapterPosition();
                 if (listener !=null && position!=RecyclerView.NO_POSITION){
                     listener.onItemClick(notes.get(position));
                 }
                }
            });

        }
    }
public  interface  onItemClickListner{


        void onItemClick(Note note);


}

public  void setOnItemCluckListener(onItemClickListner listener){


this.listener=listener;


}


}
