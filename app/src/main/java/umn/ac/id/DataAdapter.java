package umn.ac.id;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private final ArrayList<Data> data;

    public DataAdapter(ArrayList<Data> data){
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String users = "User: " + data.get(position).getUser();
        String ids = "id: " + data.get(position).getId();

        holder.user.setText(users);
        holder.id.setText(ids);
        holder.title.setText(data.get(position).getTitle());
        holder.body.setText(data.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView user, id, title, body;

        public ViewHolder(View view) {
            super(view);
            user = view.findViewById(R.id.user);
            id = view.findViewById(R.id.id);
            title = view.findViewById(R.id.title);
            body = view.findViewById(R.id.body);
        }
    }
}