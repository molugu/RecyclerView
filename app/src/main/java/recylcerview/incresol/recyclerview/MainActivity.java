package recylcerview.incresol.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<String> myDataSet =new ArrayList<String>(50);
    android.support.design.widget.FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton=(android.support.design.widget.FloatingActionButton)findViewById(R.id.floatingActionButton);
        myRecyclerView=(RecyclerView)findViewById(R.id.my_recycler_view);
        myRecyclerView.setHasFixedSize(true);
        mLayoutManager= new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter=new MyAdapter(myDataSet);
        myRecyclerView.setAdapter(mAdapter);
        floatingActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.floatingActionButton:

                LayoutInflater layoutInflater= LayoutInflater.from(this);
                View promptView=layoutInflater.inflate(R.layout.dialog_layout,null);

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setView(promptView);
                final EditText userInput = (EditText)promptView.findViewById(R.id.editTextDialogUserInput);
                alertDialogBuilder.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       String input= userInput.getText().toString();
                        if (!input.equals("")){
                            MyAdapter myAdapter1 = new MyAdapter();

                        myAdapter1.add(myAdapter1.getItemCount(), userInput.getText().toString());
                    }else{
                            alertDialogBuilder.setCancelable(true);
                        }
                    }
                }).setCancelable(true);
                alertDialogBuilder.show();
                break;

        }
    }
}
