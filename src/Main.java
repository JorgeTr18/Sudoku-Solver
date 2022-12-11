
public class Main {

	public static int dimensionTablero = 9;

	public static void main(String[] args) {

		int tablero[][] = { 
				{ 0, 0, 0, 0, 3, 0, 5, 0, 6 }, 
				{ 0, 3, 0, 0, 0, 7, 0, 0, 0 }, 
				{ 0, 0, 7, 2, 0, 6, 0, 0, 1 },
				{ 0, 0, 1, 0, 0, 0, 2, 3, 5 }, 
				{ 4, 0, 0, 0, 1, 0, 0, 0, 9 }, 
				{ 0, 8, 5, 0, 0, 0, 4, 0, 0 },
				{ 5, 0, 0, 1, 0, 3, 9, 0, 0 }, 
				{ 0, 0, 0, 4, 0, 0, 0, 5, 0 }, 
				{ 9, 0, 3, 0, 2, 0, 0, 0, 0 } };
		
		

	}

	public static boolean numEnFila(int[][] tablero, int fila, int num) {

		for (int i = 0; i < dimensionTablero; i++) {
			if (tablero[fila][i] == num) {
				return true;
			}
		}
		return false;
	};

	public static boolean numEnColumna(int[][] tablero, int columna, int num) {

		for (int i = 0; i < dimensionTablero; i++) {
			if (tablero[i][columna] == num) {
				return true;
			}
		}
		return false;
	};

	public static boolean numEnCuadrado(int[][] tablero, int fila, int columna, int num) {

		int posicionFila = fila - fila % 3;
		int posicionColumna = columna - columna % 3;

		for (int i = posicionFila; i < posicionFila + 3; i++) {
			for (int j = posicionColumna; j < posicionColumna + 3; j++) {
				if (tablero[i][j] == num) {
					return true;
				}

			}
		}
		return false;
	}
	
	public static boolean posicionValida(int[][] tablero, int fila, int columna, int num) {
		return (!numEnFila(tablero, fila, num) && !numEnColumna(tablero, columna, num)
				&& !numEnCuadrado(tablero, fila, columna, num));
	};

	public static boolean validarTablero(int[][] tablero) {
		for (int fila = 0; fila < dimensionTablero; fila++) {
			for (int columna = 0; columna < dimensionTablero; columna++) {

				if (tablero[fila][columna] == 0) {

					for (int num = 1; num <= dimensionTablero; num++) {
						if (posicionValida(tablero, fila, columna, num)) {
							tablero[fila][columna] = num;
							if (validarTablero(tablero)) {
								return true;
							} else {
								tablero[fila][columna] = 0;
							}
						}

					}
					return false;
				}
			}
		}

		return true;
	};

};

	