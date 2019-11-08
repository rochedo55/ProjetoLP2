package br.ufrn.imd.modelo;

public class Tupla<Id, Dist , Rot> {


	private Id x;
	private Dist y;
	private Rot z;
	
	public Tupla(Id x, Dist y, Rot z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Id getX() {
		return x;
	}
	public void setX(Id x) {
		this.x = x;
	}
	public Dist getY() {
		return y;
	}
	public void setY(Dist y) {
		this.y = y;
	}
	public Rot getZ() {
		return z;
	}
	public void setZ(Rot z) {
		this.z = z;
	}

}
