package lab4;

public class Pencil extends StationeryItem {

	public Pencil() {
		super("Pencil", 1);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pencil clone()
	{
		Pencil p = (Pencil) super.clone();
		return p;
	}
}
