package randomnumber.su.ac.th.bodymassindex;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import randomnumber.su.ac.th.bodymassindex.EntityClass.UserModel;

public class UserAdapter extends RecyclerView.Adapter <UserAdapter.viewHolder>{

    Context context;
    List<UserModel> list;

    public UserAdapter(Context context, List<UserModel> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
        public viewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}
