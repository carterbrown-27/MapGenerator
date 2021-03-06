

public final class Weapon extends Item implements Equippable {
	private boolean equipped = false;
	private double damage;
	private double accuracy;
	private double weight;
	
	Weapon(String id){
		super(id);
		super.setAmount(1);
		
		// TODO (A) introduce logic to see if it is weilded/not.
		super.addPrompt('u', "(u)nequip");
		super.addPrompt('w', "(w)ield");
		// TODO: weapon init here:
		damage = super.getItemData().getDouble("damage");
		accuracy = super.getItemData().getDouble("accuracy");
		weight = super.getItemData().getDouble("weight");
	}
	
	// TODO (+) add a dmg calculation here (maybe)
	public double getDamage() {
		return damage;
	}
	
	public double getAccuracy() {
		return accuracy;
	}
	
	public double getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return super.toString() + (isEquipped() ? " (wielded)" : "");
	}
	
	@Override
	public void equip(Creature c) {
		// TODO (A) Implement
		Weapon prev = c.weapon;
		if(prev != null) prev.unequip(c);
		c.weapon = this;
		equipped = true;
	}

	@Override
	public void unequip(Creature c) {
		// TODO (A) Implement
		c.weapon = null;
		equipped = false;
	}
	
	@Override
	public void drop(Creature from) {
		unequip(from);
		super.drop(from);
	}
	
	@Override
	public boolean isEquipped() {
		return this.equipped;
	}
}
