/*
 * T4. Dla danego zbioru P zawieraj�cego n punkt�w na p�aszczy�nie, w uk�adzie wsp�rz�dnych XOY,  wyznacz: 
 * - punkt najbardziej odleg�y od pocz�tku uk�adu wsp�rz�dnych, 
 * - wsp�rz�dne wierzcho�k�w prostok�ta o najmniejszym z mo�liwych polu powierzchni i bokach r�wnoleg�ych do osi, w kt�rego polu znajd� si� wszystkie punkty zbioru P, 
 * - tabel� odleg�o�ci pomi�dzy wszystkimi mo�liwymi parami punkt�w, 
 * - par� punkt�w najbardziej odleg�ych od siebie, 
 * - tr�jk� punkt�w tworz�cych tr�jk�t o najwi�kszym polu powierzchni. Ponadto: 
 * - uporz�dkuj zbi�r punkt�w w kolejno�ci rosn�cych odleg�o�ci tych punkt�w od pocz�tku uk�adu wsp�rz�dnych, 
 * - uporz�dkuj pary punkt�w w kolejno�ci rosn�cych odleg�o�ci pomi�dzy nimi.
 *   
 * @author: Marcel Sawicki
 * @version 1.00 2014/01/05
 */
import java.util.Scanner;

public class ZadanieT4 {

	public static double odleglosc(double xa, double xb, double ya, double yb){
		double dx=xa-xb;
		double dy=ya-yb;
		return Math.sqrt(dx*dx+dy*dy);
	} // odleglosc miedzy punktami
	
	public static double[] posortuj(double[] tab) {
		double temp;
		int zmiana = 1;
		System.out.println("Posortowane: ");
		while(zmiana > 0){
			zmiana = 0;
			for(int i=0; i<tab.length-1; i++){
				if(tab[i]>tab[i+1]){
					temp = tab[i+1];
					tab[i+1] = tab[i];
					tab[i] = temp;
					zmiana++;
				}
			}
		}
		for(int rj=0;rj<tab.length; rj++) {
			System.out.print(tab[rj]+", ");
		}
		System.out.println();
		return tab;
	}
	public static void main(String[] args) {
		// tworze tablice dwuwymiarowa
		
		System.out.println("Ile punktow bedzie zawieral zbior P?");
		System.out.print("n=");
    	Scanner nk = new Scanner(System.in);
    	int n = nk.nextInt();
		double[][] macierz= new double[n][2];
		
		double maxOdl=0;
		int ktoryPkt=0;
    	Scanner xk = new Scanner(System.in);
    	Scanner yk = new Scanner(System.in);
		for(int h=0;h<n;h++){
			System.out.println("Punkt nr "+h);
			System.out.print("x=");

	    	macierz[h][0] = xk.nextInt();
	    	System.out.print("y=");

	    	macierz[h][1]=yk.nextInt();
		}

// - punkt najbardziej odleg�y od pocz�tku uk�adu wsp�rz�dnych
		System.out.println("Szukam punktu najbardziej odleglego od poczatku ukladu wspolrzednych XOY.");
		int j=0;
		for(int k=0;k<n;k++){
			if(maxOdl<odleglosc(macierz[k][j],0,macierz[k][j+1],0))
			{
				maxOdl=odleglosc(macierz[k][j],0,macierz[k][j+1],0); ktoryPkt=k;
			};
			//}
		}//for
		System.out.println("Najbardziej odlegly punkt znajduje sie w odleglosci od poczatku ukladu wspolrzednych: ");
		System.out.println(String.format( "%.4f", maxOdl)); // wyswietlam cztery miejsca po przecinku
		System.out.println("\nJest to punkt nr "+ktoryPkt);
// - wsp�rz�dne wierzcho�k�w prostok�ta o najmniejszym z mo�liwych polu powierzchni i bokach 
// r�wnoleg�ych do osi, w kt�rego polu znajd� si� wszystkie punkty zbioru P, 

// - tabel� odleg�o�ci pomi�dzy wszystkimi mo�liwymi parami punkt�w,
	System.out.println("Tabela odleglosci pomiedzy wszystkimi mozliwymi parami punktow.");
	System.out.println("+------------------------------------------+");
	System.out.println(" Punkt A | Punkt B | Odleglosc miedzy nimi ");
	System.out.println("+------------------------------------------+");
		for(int d=0;d<n;d++){
					for(int z=0; z<n; z++ ) { 
						System.out.print(d+" 	 | ");
						System.out.print(z+" 	   | ");
						double policzonaOdleglosc = odleglosc(macierz[d][0],macierz[z][0],macierz[d][1],macierz[z][1]); 
						System.out.println(String.format( "%.4f", policzonaOdleglosc));
					}	
		}
// - par� punkt�w najbardziej odleg�ych od siebie,
		double maxymalnaOdleglosc =0;
		int punktA = 0;
		int punktB = 0;
		
		for(int d=0;d<n;d++){
			for(int z=0; z<n; z++ ) {
				double policzonaOdleglosc = odleglosc(macierz[d][0],macierz[z][0],macierz[d][1],macierz[z][1]);
				if(maxymalnaOdleglosc<policzonaOdleglosc) {
					maxymalnaOdleglosc=policzonaOdleglosc;
					punktA = d;
					punktB = z;
				}
			}	
		}
		System.out.println("Znalazlem pare punktow najbardziej odleg�ych od siebie.");
		System.out.println("Punkt A = " + punktA);
		System.out.println("Punkt B = " + punktB);
		System.out.println("Odleglosc miedzy nimi = " + maxymalnaOdleglosc);
		
// - tr�jk� punkt�w tworz�cych tr�jk�t o najwi�kszym polu powierzchni.
		
// Ponadto:
// - uporz�dkuj zbi�r punkt�w w kolejno�ci rosn�cych odleg�o�ci tych punkt�w 
// od pocz�tku uk�adu wsp�rz�dnych, 
		double[][] tablicaOdleglosciOdX0Y = new double[n][2];
		double[][] uporzadkowanaTablicaOdleglosciOdX0Y = new double[n][2];
	System.out.println("Porzadkuje zbior punktow w kolejno�ci rosn�cych odleg�o�ci tych punktow");
	System.out.println("od poczatku ukladu wspolrzadnych.");
	System.out.println("+--------------------------------------------------+");
	System.out.println(" Punkt | Odleglosc od poczatku ukladu wspolrzednych ");
	System.out.println("+--------------------------------------------------+");
		for(int v=0;v<n;v++){
						double policzonaOdlegloscX0Y = odleglosc(macierz[v][0],0,macierz[v][1],0);
						tablicaOdleglosciOdX0Y[v][0]= v;
						tablicaOdleglosciOdX0Y[v][1]= policzonaOdlegloscX0Y;
							System.out.print(tablicaOdleglosciOdX0Y[v][0]+" # ");
							System.out.print(tablicaOdleglosciOdX0Y[v][1]+"\n");	
		}
		
		// bubble sort
		double[] tab = new double[n];
		for(int r=0;r<n;r++) {
			tab[r]=tablicaOdleglosciOdX0Y[r][1];
		}
		posortuj(tab);
// - uporz�dkuj pary punkt�w w kolejno�ci rosn�cych odleg�o�ci pomi�dzy nimi.
		double[][] tablicaOdleglosciMiedzyPunktami = new double[n*n][3];
		double[][] uporzadkowanaTablicaOdleglosciMiedzyPunktami = new double[n*n][3];
	System.out.println("Porzadkuje pary punktow w kolejno�ci rosn�cych odleglosci pomi�dzy nimi.");
	System.out.println("+------------------------------------------+");
	System.out.println(" Punkt A | Punkt B | Odleglosc miedzy nimi ");
	System.out.println("+------------------------------------------+");
	int licznik =0;
		for(int g=0;g<n;g++){
					for(int o=0; o<n; o++ ) { 
						double policzonaOdleglosc = odleglosc(macierz[g][0],macierz[o][0],macierz[g][1],macierz[o][1]);
						tablicaOdleglosciMiedzyPunktami[licznik][0]= g;
						tablicaOdleglosciMiedzyPunktami[licznik][1]= o;
						tablicaOdleglosciMiedzyPunktami[licznik][2]= policzonaOdleglosc;
						if(licznik<n*n) {
							System.out.print(tablicaOdleglosciMiedzyPunktami[licznik][0]+" # ");
							System.out.print(tablicaOdleglosciMiedzyPunktami[licznik][1]+" # ");
							System.out.print(tablicaOdleglosciMiedzyPunktami[licznik][2]+"\n");
							licznik++;
						}
					}	
		}
		// bubble sort
		double[] tabOdleglosci = new double[n*n];
		for(int rt=0;rt<n*n;rt++) {
			tabOdleglosci[rt]=tablicaOdleglosciMiedzyPunktami[rt][2];
		}
		posortuj(tabOdleglosci);
		
		nk.close();
		xk.close();
		yk.close();
		
	}//main
}// class List3T4