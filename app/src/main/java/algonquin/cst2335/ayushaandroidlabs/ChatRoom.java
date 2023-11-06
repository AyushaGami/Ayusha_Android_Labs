package algonquin.cst2335.ayushaandroidlabs;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import algonquin.cst2335.ayushaandroidlabs.databinding.ActivityChatRoomBinding;
import algonquin.cst2335.ayushaandroidlabs.databinding.SentMessageBinding;

public class ChatRoom extends AppCompatActivity {

    ActivityChatRoomBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChatRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recycleView.setAdapter(new RecyclerView.Adapter<RowHolder>(){
            @NonNull
            @Override
            public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
                SentMessageBinding rowBinding = SentMessageBinding.inflate(getLayoutInflater(), parent, false);

                return new RowHolder(rowBinding.getRoot());

            }
            @Override
            public void onBindViewHolder(@NonNull RowHolder holder, int position) {
            }
            @Override
            public int getItemCount() {
                return 0;
            }});
    }
    class RowHolder extends RecyclerView.ViewHolder {

        TextView message;
        TextView time;

        public RowHolder(@NonNull View itemView){
            super(itemView);
            message = itemView.findViewById(R.id.message);
            time = itemView.findViewById(R.id.time);
        }
    }
}