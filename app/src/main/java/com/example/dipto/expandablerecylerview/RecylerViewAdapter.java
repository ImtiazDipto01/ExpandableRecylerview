package com.example.dipto.expandablerecylerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dipto.expandablerecylerview.model.InnerModel;
import com.example.dipto.expandablerecylerview.model.OuterModel;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

/**
 * Created by Dipto on 8/3/2017.
 */

public class RecylerViewAdapter extends ExpandableRecyclerViewAdapter<RecylerViewAdapter.OutterViewHolder, RecylerViewAdapter.InnerViewHolder> {

    private Context context ;
    public RecylerViewAdapter(Context context, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.context = context ;
    }

    @Override
    public OutterViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_outter, parent,false) ;
        return new OutterViewHolder(view);
    }

    @Override
    public InnerViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_inner, parent,false) ;
        return new InnerViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(InnerViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final InnerModel innerModel = ((OuterModel) group).getItems().get(childIndex);
        holder.setSubTitletName(innerModel.getName());
    }

    @Override
    public void onBindGroupViewHolder(OutterViewHolder holder, int flatPosition, ExpandableGroup group) {

        holder.setGenreTitle(context, group); ;
    }

    public class OutterViewHolder extends GroupViewHolder{

        private TextView titleName;
        private ImageView arrow;
        private ImageView icon;

        public OutterViewHolder(View itemView) {
            super(itemView);

            titleName = (TextView) itemView.findViewById(R.id.list_item_genre_name);
            arrow = (ImageView) itemView.findViewById(R.id.list_item_genre_arrow);
            icon = (ImageView) itemView.findViewById(R.id.list_item_genre_icon);
        }

        public void setGenreTitle(Context context, ExpandableGroup title) {
            if (title instanceof OuterModel) {
                titleName.setText(title.getTitle());
                icon.setImageResource(((OuterModel) title).getImg());
            }
        }
    }

    public class InnerViewHolder extends ChildViewHolder{

        private TextView subTitleTextView;

        public InnerViewHolder(View itemView) {
            super(itemView);

            subTitleTextView = (TextView) itemView.findViewById(R.id.subtitle);

        }

        public void setSubTitletName(String name) {
            subTitleTextView.setText(name);
        }
    }

}


