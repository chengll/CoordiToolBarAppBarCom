package test.dmdfchina.com.glesdemo.mytest;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import test.dmdfchina.com.glesdemo.R;

/**
 * Created by mkt on 2018/1/24.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context mContext;
    public MyAdapter(Context mContext){
        this.mContext=mContext;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(mContext).inflate(R.layout.layout_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.card_text.setText(position+"");
    }


    @Override
    public int getItemCount() {
        return 40;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        CardView myCardView;
        TextView card_text;

        public MyViewHolder(View itemView) {
            super(itemView);
            myCardView=itemView.findViewById(R.id.myCardView);
            card_text=itemView.findViewById(R.id.card_text);
        }
    }
}
