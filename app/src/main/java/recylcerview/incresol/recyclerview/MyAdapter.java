package recylcerview.incresol.recyclerview;

import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Incresol-078 on 16-09-2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private static ArrayList<String> mDataset;

public MyAdapter(){
    super();
}

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_description;
        public RelativeLayout rowlayout_main;

        public ViewHolder(View itemView) {
            super(itemView);
            textView_description=(TextView)itemView.findViewById(R.id.textView_description);
            rowlayout_main=(RelativeLayout)itemView.findViewById(R.id.rowlayout_main);
        }

    }

    public void add(int position, String item){
        mDataset.add(position,item);
        notifyItemInserted(position);
    }

    public void remove(String item){
        int position=mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }


    public MyAdapter(ArrayList<String> myDataSet){
        mDataset=myDataSet;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String name=mDataset.get(position);
        holder.textView_description.setText(mDataset.get(position));
        holder.rowlayout_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
