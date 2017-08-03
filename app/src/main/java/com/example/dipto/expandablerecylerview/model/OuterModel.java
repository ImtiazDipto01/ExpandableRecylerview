package com.example.dipto.expandablerecylerview.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Dipto on 8/2/2017.
 */

public class OuterModel extends ExpandableGroup<InnerModel> {

    private int img ;
    public OuterModel(String outertitle, List<InnerModel> items, int img){

        super(outertitle, items);
        this.img = img ;
    }

    public int getImg() {
        return img;
    }
}
