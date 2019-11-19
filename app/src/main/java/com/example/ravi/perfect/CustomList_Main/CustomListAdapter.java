package com.example.ravi.perfect.CustomList_Main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ravi.perfect.R;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<CustomListMetaData> {
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    private static class ViewHolder{
        TextView number;
        TextView reason;
        TextView date;
    }

    public CustomListAdapter(Context context, int resource, ArrayList<CustomListMetaData> objects){
        super(context,resource,objects);
        mContext=context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String number=getItem(position).getNumbr();
        String reason=getItem(position).getResn();
        String date=getItem(position).getDte();

        CustomListMetaData data=new CustomListMetaData(number,reason,date);
        final View result;
        ViewHolder holder;

        if (convertView==null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.number = (TextView) convertView.findViewById(R.id.textviewnumber);
            holder.reason = (TextView) convertView.findViewById(R.id.textviewreason);
            holder.date = (TextView) convertView.findViewById(R.id.textviewdatetime);

            result = convertView;

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.number.setText(data.getNumbr());
        holder.reason.setText(data.getResn());
        holder.date.setText(data.getDte());

        return convertView;
    }

}
