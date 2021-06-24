package com.elsys;

public class Bow extends Item implements Equipable, Usable {
    private final int dmg; // kolko e silata na luka

    public Bow(int dmg){
        super("Bow");
        this.dmg = dmg;
    }

    @Override
    public String use(Character caster, Character target){
    	
    	String output = "";
        if (caster instanceof Archer){
//            int dexterityDiff = caster.getDextetiry() - target.getDextetiry();
            int realDMG = this.dmg; // promenliva v koqto shte suhranqvame kolko shte e realnata shteta koqto shte nanese luka na oponenta si pri udar

//            if (dexterityDiff < 0) {
//                for (int i = 0; i > dexterityDiff; i--) {
//                    realDMG -= (this.dmg / 10);
//                }
//            } else {
//                for (int i = 0; i < dexterityDiff; i++) {
//                    realDMG += (this.dmg / 10);
//                }
//            }

            // za vseki 10 razlika v dexterity-to na dvata geroq
            // silata ot udara suotvetno e po golqma/malka s 10%

            output+=("\n"+caster.toString() + "dealt " + realDMG + " demage to " + target.toString());
            target.setCurrentHP(target.getCurrentHP() - realDMG);
            if (target.getCurrentHP() > 0) {
                output+=("\n"+target.toString());
            } else {
                target.setCurrentHP(0);
                output+=("\n"+target.toString() + "has died!");
            }
        }
        return output;
        
    }
}
