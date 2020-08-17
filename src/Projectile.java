import java.awt.*;

public class Projectile extends Entity {
    Projectile(Item i, Point p, Map m){
        super("<projectile>", p, m);
        super.setPassable(true);
    }

    // TODO (R) clean up all instances of this method across project
    public boolean canOccupySpace(int x, int y) {
        if(!map.isOnMap(x,y)) return false;
        int[][] openMap = map.getOpenMap();
        return openMap[y][x] == 0 || openMap[y][x] == 2; // TODO: change access
    }
}
