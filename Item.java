package com.elsys;

public abstract class Item {
    private final String type;
    private boolean ifPicked; // promenliva koqto pokazva dali predmetut e veche vzet

    Item(String type){
        this.type = type;
        this.ifPicked = false; // by default itema ne e vzet ot nikogo
    }

    public String getType(){
        return type;
    }

    public void setIfPicked(boolean ifPicked){
        this.ifPicked = ifPicked;
    }

    public boolean getIfPicked(){
        return this.ifPicked;
    }

}
