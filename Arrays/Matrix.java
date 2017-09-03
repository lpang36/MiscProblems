import java.util.Arrays;

public class Matrix {
	private int[][] m;
	int rows;
	int cols;
	public Matrix (int[][] mat) {
		m = mat;
		rows = m.length;
		cols = m[0].length;
	}
	//cci 1.1.6
	public void rotate() {
		int n;
		if (cols%2==0) 
			n = cols/2;
		else
			n = cols/2+1;
		for (int i = 0; i<n; i++) {
			for (int j = i; j<rows-i-1; j++) {
				int temp = m[i][j];
				m[i][j] = m[j][rows-i-1];
				m[j][rows-i-1] = m[rows-i-1][cols-j-1];
				m[rows-i-1][cols-j-1] = m[cols-j-1][i];
				m[cols-j-1][i] = temp;
			}
		}
	}
	public void reduceRow (int n, boolean[][] ind, int origin) {
		for (int i = 0; i<cols; i++) {
			m[n][i] = 0;
			if (i!=origin)
				ind[n][i] = true;
		}
	}
	public void reduceCol (int n, boolean[][] ind, int origin) {
		for (int i = 0; i<rows; i++) {
			m[i][n] = 0;
			if (i!=origin)
				ind[i][n] = true;
		}
	}
	//cci 1.1.7
	//if you really wanted to optimize this you should have a binary search tree structure of
	//rows and columns so those indices are skipped over if they've already been set to 0
	//also keep a count of the number of elements in this tree
	//or maybe there's a next lvl vectorized implementation of this
	public void reduceRowsCols() {
		boolean[][] ind = new boolean[rows][cols];
		for (int i = 0; i<rows; i++) {
			for (int j = 0; j<cols; j++) {
				if (m[i][j]==0&&!ind[i][j]) {
					reduceRow(i,ind,j);
					reduceCol(j,ind,i);
				}
			}
		}
	}
	public String toString() {
		String s = "";
		for (int i = 0; i<rows; i++) {
			for (int j = 0; j<cols; j++) {
				s+=m[i][j]+" ";
			}
			s+="\n";
		}
		return s;
	}
	public static void main(String[] args) {
		int[][] m = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		Matrix obj = new Matrix(m);
		System.out.println(obj);
		obj.rotate();
		System.out.println(obj);
		int[][] m1 = new int[][] {{1,0,1},{1,1,1},{1,0,1},{1,1,1}};
		Matrix obj1 = new Matrix(m1);
		obj1.reduceRowsCols();
		System.out.println(obj1);
	}
}