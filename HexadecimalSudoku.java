import java.util.ArrayList;

public class HexadecimalSudoku {

	public static void main(String[] args) {
		char[][] boardArr = {{'1','2','3','4','5','6','7','8','9','0','A','B','E','F','C','D'},
							{'2','6','7','8','5','6','7','1','A','B','C','D','E','F','C','D'},
							{'3','0','A','B','5','6','7','2','A','B','C','D','E','F','C','D'},
							{'4','D','E','F','5','6','7','3','A','B','C','D','E','F','C','D'},
							{'5','2','3','4','5','7','7','4','A','B','C','D','E','F','C','D'},
							{'6','2','3','4','5','6','7','5','A','B','C','D','E','F','C','D'},
							{'7','2','3','4','5','6','7','6','A','B','C','D','E','F','0','9'},
							{'8','2','3','4','5','6','7','7','A','B','C','D','E','F','0','9'},
							{'9','2','3','4','5','6','7','8','A','B','C','D','E','F','C','D'},
							{'0','2','3','4','5','6','7','9','A','B','C','D','E','F','C','D'},
							{'A','2','3','4','5','6','7','A','A','B','C','D','E','F','C','D'},
							{'B','2','3','4','5','6','7','B','A','B','C','D','E','F','C','D'},
							{'C','2','3','4','5','6','7','C','A','B','C','D','0','1','2','3'},
							{'D','2','3','4','5','6','7','D','A','B','C','D','4','5','6','7'},
							{'E','2','3','4','5','6','7','E','A','B','C','D','8','9','A','B'},
							{'F','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F'}};
		
		
		// method 2 System.out.println(BoardValidation(boardArr));
		// System.out.println(SubGridValidation(7,7,boardArr));
		// method 4 
		System.out.println(ValidRowColumn(16,boardArr));
		// method 1 System.out.println(CharacterValidation('A'));

		
		
	}
	
	public static boolean CharacterValidation(char charInp) {
		
		if (charInp == 0) { // 
			return false;
		}
		ArrayList<Character> ValidInps = new ArrayList<Character>();
		ValidInps.add('0');
		ValidInps.add('1');
		ValidInps.add('2');
		ValidInps.add('3');
		ValidInps.add('4');
		ValidInps.add('5');
		ValidInps.add('6');
		ValidInps.add('7');
		ValidInps.add('8');
		ValidInps.add('9');
		ValidInps.add('A');
		ValidInps.add('B');
		ValidInps.add('C');
		ValidInps.add('D');
		ValidInps.add('E');
		ValidInps.add('F');
		
		if (ValidInps.contains(charInp) == true) {
			return true;
		}
		else {
			return false;
		}

	}
	
	public static boolean BoardValidation(char[][] boardInp) {
		
		if (boardInp == null) {
			return false;
		}
		
		int rowc = boardInp.length;
		int colc = boardInp[0].length;
		int valid = 0;
		
		for (int i=0; i < boardInp.length; i++) {
			for (int j=0; j < boardInp[i].length; j++) {
				if(CharacterValidation(boardInp[i][j]) == true) {
					valid++;
				}
			}	
		}
		if((rowc == 16) && (colc == 16) && (valid == 256)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int SubGridValidation(int row, int col, char[][] boardInp) {
		
		if ((BoardValidation(boardInp)) == true){ // checks if the board is valid
			;
		}
		else {
			return(-1000);
		}
		
		ArrayList<Character> SubGridNums = new ArrayList<Character>();
		
		if(((row < 1 || row > 16)) && ((col < 1 || col > 16))) {
			return(0);
		}
		else if (row < 1 || row > 16) {
			return(1);
		}
		else if (col < 1 || col > 16) {
			return (2);
		}
		else {
			int rowBound = (row - (row % 4));
			int colBound = (col - (col % 4));
			int uniqueSub = 0;
			
			for (int i = rowBound; i < rowBound+4; i++) {
				for(int j = colBound; j < colBound+4; j++) {
					if (SubGridNums.contains(boardInp[i][j]) == false) {
						SubGridNums.add(boardInp[i][j]);
						uniqueSub++;
						if(uniqueSub == 16) {
							System.out.println(SubGridNums);
							return(3);
							}						
					}
				}
			}
			
		}
		System.out.println(SubGridNums);
		return (-999);
	
	}
	
	public static int ValidRowColumn(int inp, char[][] boardInp) {
		
		ArrayList<Character> RowChars = new ArrayList<Character>();
		ArrayList<Character> ColChars = new ArrayList<Character>();
		int uniqueRow = 0;
		int uniqueCol = 0;
		
		if((inp <= -1) && (inp >= -16)) {
			int row = (-inp)-1;
			for (int i=row;;) {
				for (int j=0; j < boardInp[i].length; j++) {
					if(RowChars.contains(boardInp[i][j]) == false){
						RowChars.add(boardInp[i][j]);
						uniqueRow++;
						if(uniqueRow == 16) {
							System.out.println(RowChars);
							return(3);
						}
					}
					
				}	
			}
		}
		else if(inp == 0) {
			return 0;
		}
		else if(inp < -16) {
			return(1);
		}
		else if ((inp >= 1) && (inp <= 16)) {
			int col = inp-1;
			for (int j=col;;) {
				for (int i=0; i < boardInp.length; i++) {
					if(ColChars.contains(boardInp[i][j]) == false){
						ColChars.add(boardInp[i][j]);
						uniqueCol++;
						if(uniqueCol == 16) {
							System.out.println(ColChars);
							return(4);
						}
					}
					
				}	
			}
		}
		else if(inp > 16) {
			return(2);
		}
		return(-3000);
		
		
	}
		
}

			


