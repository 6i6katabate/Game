package com.elsys;

// note-a se izpolzva za razmenqne na repliki mejdi geroite
// toi e implementiram kato useable item koito geroite izpolzvat (use)
// i "kazvat" informaciqta ot note-a

public class Note extends Item implements Equipable, Usable{
    private final String info;

    public Note(String info) {
        super("Note");
        this.info = info;
    }

    @Override
    public String use (Character caster, Character target){
        return ("\n"+caster.toString() + "says to " + target.toString() + ": " + " \"" + this.info + "\"");
    }
}
