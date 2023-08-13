package hu.shell;

public class Kiir {
	private int[][] matrix;
	private int meret;
	
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public int getMeret() {
		return meret;
	}

	public void setMeret(int meret) {
		this.meret = meret;
	}

	public void proc() {
		matrix = new int[meret][meret];
		int[] tomb = Rendez.getTomb();
		int index = 0;
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        // az eredeti tömb aktuális elemének átmásolása
		        matrix[i][j] = tomb[index];
		        // az index növelése
		        index++;
		        // a 2D tömb elemének kiíratása
		        System.out.print(matrix[i][j] + "\t");
		    }
		    // új sor a konzolon
		    System.out.println();
		}
	}
}

