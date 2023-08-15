package hu.shell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Rendez {
	private BufferedReader br;
    private static int[] tomb;
    private String rendezMod;

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public static int[] getTomb() {
        return tomb;
    }
 
    public static void setTomb(int[] tomb) {
        Rendez.tomb = tomb;
    }
    
    public String getRendezMod() {
		return rendezMod;
	}

	public void setRendezMod(String rendezMod) {
		this.rendezMod = rendezMod;
	}
	public Rendez(){	
	}

	public Rendez(String fileName) {
		ArrayList<Integer> szamok = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(fileName));
            String sor;
            // Egy ciklus, amely addig fut, amíg van sor a fájlban
            while ((sor = br.readLine()) != null) {
                // Az aktuális sort elválasztjuk a vesszők mentén és egy tömböt kapunk
                String[] reszek = sor.split(", ");
                // Végigmegyünk a tömbön és minden elemet átalakítunk egész számmá és hozzáadjuk az ArrayList-hez
                for (String resz : reszek) {
                    int number = Integer.parseInt(resz);
                    szamok.add(number);
                }
            }
            br.close();
            tomb = new int[szamok.size()];
            for (int i = 0; i < szamok.size(); i++) {
                tomb[i] = szamok.get(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void proc() {
		if(rendezMod.equals("shell")) {
			int[] gaps = {1, 4, 13}; // A Knuth-féle távolságok
			for (int s = gaps.length - 1; s >= 0; s--) // Végigmegyünk a távolságokon fordított sorrendben
			{
			    int gap = gaps[s]; // Az aktuális távolság
			    for (int i = gap; i < tomb.length; i++) // Végigmegyünk a tömbön a távolság mértékével
			    {
			        int x = tomb[i]; // Az aktuális elem
			        int j = i - gap; // Az aktuális elemmel összehasonlítandó index
			        while (j >= 0 && tomb[j] > x) // Amíg nem találunk kisebb vagy egyenlő elemet
			        {
			            tomb[j + gap] = tomb[j]; // Eltoljuk az elemeket a távolság mértékével
			            j = j - gap; // Csökkentjük az indexet
			        }
			        tomb[j + gap] = x; // Beszúrjuk az aktuális elemet a megfelelő helyre
			    }
			}
				System.out.println("Rendezés kész a módszer: " + rendezMod);
		}
		else {
			System.out.println("Nem ismerem fel a rendezési módot!");
		}
	}
}

