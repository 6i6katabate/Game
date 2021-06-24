package com.elsys;

public class Scroll extends Item implements Equipable, Usable {
    private final int dmg;
    private final int mana;

    public Scroll(int dmg, int mana){
        super("Scroll");
        this.dmg = dmg;
        this.mana = mana;
    }

    @Override
    public String use(Character caster, Character target) {
        String output = "";
    	if (caster instanceof Mage) {

            // scroll-a za mage e ekvivalenta na bow-a  za archera
            // suotvetno tuk ima sushtata sushtite proverki i sushtata sistema za izchislqvane na realnata shteta
            // samo che se gleda razlikata v intelekta

            // tuk obache ima i proverka dali mage-a ima dostatuchno mana da izpolzva svoq scroll

            if (((Mage) caster).getCurrentMana() < this.mana){
               return ("You don't have enought mana to use this scroll!\nMAGE NEEDS A POTION!");
             
            }
            int newMana = ((Mage) caster).getCurrentMana() - this.mana;
            ((Mage) caster).setCurrentMana(newMana);
//            int intellectDiff = caster.getIntellect() - target.getIntellect();
              int realDMG = this.dmg;
//
//            if (intellectDiff < 0) {
//                for (int i = 0; i > intellectDiff; i--) {
//                    realDMG -= (this.dmg / 10);
//                }
//            } else {
//                for (int i = 0; i < intellectDiff; i++) {
//                    realDMG += (this.dmg / 10);
//                }
//            }
            
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
