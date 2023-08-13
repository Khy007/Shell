package hu.shell;

public class Animacio {
	private int szamlalo;
	
    public int getSzamlalo() {
		return szamlalo;
	}
    
	public void setSzamlalo(int szamlalo) {
		this.szamlalo = szamlalo;
	}
  
    public void proc() throws InterruptedException {
    	Animacio anim = new Animacio();
    	anim.setSzamlalo(25);
    	for (int i = 0; i <anim.getSzamlalo(); i++) {
            System.out.print('*');
				Thread.sleep(100);
        }
    }
    
}
