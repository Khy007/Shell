package hu.shell;

import java.io.*;
import java.util.*;

public class Feltolt {
	private int ertek;
	private PrintWriter pw;
	private String fileName;
	Boolean sikeresIras=false;
	
	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getErtek() {
		return ertek;
	}

	public void setErtek(int ertek) {
		this.ertek = ertek;
	}
	public Feltolt() {
		
	}
	
	public Feltolt(String fileName) {
        this.fileName = fileName;
        try {
            pw = new PrintWriter(new FileWriter(fileName));
            sikeresIras=true; 
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nem lehetett a "+ fileName +" nevű filet létrehozni!");
        }
    }
	
	public void proc() throws InterruptedException {
		System.out.println("Adatok generálása folyamatban a "+fileName+ " nevű fileba: ");
		//animáció lejátszása
		Animacio animacio = new Animacio();
		animacio.proc();
		//random számok feltöltése a file-ba
		Random random = new Random();
		for (int i = 0; i < ertek; i++) {
			int randSzam = random.nextInt(1001);
				if (i< ertek-1) {
					pw.print(randSzam + ", ");
				}
				else {
					pw.print(randSzam);
				}
		}
		if (sikeresIras) {
			System.out.println();
			System.out.println("File létrehozása sikeres!");
		}
		else {
			System.out.println();
			System.out.println("HIBA! File létrehozása sikertelen!");
		}
		pw.close();
	}
	
}
