package practice.design.warshipGame;


public class ShipBlock implements Block {
	/* If damageIndex = 4 means this block will get damaged completely
	 * if it get hit 4 times.
	 */
	private int damageIndex;
	private Ship associatedShip;
	private boolean shipBlockDamaged;
	
	ShipBlock(int damageIndex, Ship associatedShip) {
		this.damageIndex = damageIndex;
		this.associatedShip = associatedShip;
		this.shipBlockDamaged = false;
	}
	
	public void hitBlock(int power) {
		if (power < 0)  //-ve power means this power can blow the whole ship.
		{
			// blow the whole ship
			associatedShip.setNoOfBlocksDamaged(associatedShip.getShipLength());
			return;
		}
		
		if (damageIndex <= power) {
			damageIndex = 0;
			shipBlockDamaged = true;
			associatedShip.setNoOfBlocksDamaged(associatedShip.getNoOfBlocksDamaged() + 1);
		} else {
			damageIndex -= power;
		}
		associatedShip.setHitCount(associatedShip.getHitCount() + 1);
	}
	public boolean isShipBlockDamaged() {
		return shipBlockDamaged;
	}

	public Ship getAssociatedShip() {
		return associatedShip;
	}
	
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean isOccupied() {
		return true;
	}
}
