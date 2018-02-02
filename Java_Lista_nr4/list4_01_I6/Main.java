/* O6. Zdefiniowa� klas� Hotel. 
 * Ka�dy hotel ma okre�lon� liczb� numerowanych pokoi rozmieszczonych  na poszczeg�lnych pi�trach.
 * Liczba pi�ter i liczba pokoi na ka�dym pi�trze jest ustawiana w momencie tworzenia obiektu. 
 * Pok�j jest identyfikowany przez obiekt klasy NumerPokoju (o polach: pietro i pokoj). 
 * Okre�lony pok�j jest wyj�ty je�li jest z nim powi�zany obiekt klasy Osoba 
 * (zaproponowa� definicj� stosownej klasy). Jedna osoba mo�e wynajmowa� wiele pokoi.  
 * Zdefiniowa� metody: 
 * - czy jest jaki� wolny pok�j, 
 * - ile jest wolnych pokoi, 
 * - wynajmij dowolny z wolnych pokoi podanej (jako parametr) osobie (obiekt typu Osoba); 
 *  wynikiem powinien by� numer przydzielonego pokoju, 
 *  
 *  - czy mo�na wynaj�� k s�siednich pokoi 
 *  (wynikiem powinien by� numer pierwszego pokoju lub null je�li to niemo�liwe), 
 *  - czy osoba o podanym nazwisku wynajmuje jaki� pok�j, 
 *  - kt�re pokoje wynajmuje osoba o podanym nazwisku 
 *  (wynikiem powinna by� tablica numer�w pokoi lub null), 
 *  - zwolnij wszystkie pokoje wynajmowane przez osob� o podanym nazwisku. 
 *  Zaproponuj ewentualne inne metody klasy Hotel
 */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel grand = new Hotel(2,3); // liczba pieter, liczba pokoi
		Osoba osoba1 = new Osoba("Jan", "Abcd"); // imie, nazwisko
		Osoba osoba2 = new Osoba("Mariusz", "Abcd"); // imie, nazwisko
		grand.wynajmijPokoj(1, osoba1);
		
		grand.informacjePokoj(1);
		grand.informacjePokoj(2);
		grand.informacjePokoj(3);
		
		System.out.println("\nWolne pokoje: ");
		grand.wolnePokoje();
	}

}
