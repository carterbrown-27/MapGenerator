public class AI {
	private Creature c;
	private ActionLibrary lib;
	private static Player player;

	AI(Creature _c){
		// ("configuring AI...");
		this.c = _c;
		this.lib = new ActionLibrary(this.c);
		// TODO (A) Replace this with "influence map" from Map
		player = Main.player;
		// ("done.");
	}

	public boolean takeTurn(){
		
		c.upkeep();
		// TODO (+) add AI
		boolean waiting = basic();
		c.endStep();
		
		return waiting;
	}

	// what one turn of the given creature looks like

	// 0 is wait
	// 1 is success
	// 2 is fail
	public boolean basic(){
		if(c.isAdjacentTo(player.getPos())){
			if(lib.melee(player,1)){
				Main.view.appendText("The "+c.getName()+" hits you!");
			}else{
				Main.view.appendText("The "+c.getName()+" misses you.");				
			}
			return true;
		}else{
			return lib.move(false);
		}
	}
}
