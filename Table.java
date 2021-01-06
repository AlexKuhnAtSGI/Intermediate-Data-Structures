package comp2402a2;

import java.util.ArrayList;

/**
 */
public class Table<T> implements AbstractTable<T> {
  /**
   * You decide on the instance variables you need.
   */
  
  protected int numRows;
  protected int numCols;
  protected ArrayList<ArrayList<T>> matrix;
  
  public Table(Class<T> t) {
    numRows = 0;
    numCols = 0;
    matrix = new ArrayList<ArrayList<T>>();
  }
  
  public int rows() {
    return numRows;
  }
  
  public int cols() {
    return numCols;
  }
  
  public T get(int i, int j) {
    if (i < 0 || i > rows() - 1 || j < 0 || j > cols()-1)
      throw new IndexOutOfBoundsException();
    return matrix.get(i).get(j);
  }
  
  public T set(int i, int j, T x) {
    if (i < 0 || i > rows() - 1 || j < 0 || j > cols()-1)
      throw new IndexOutOfBoundsException();
    return matrix.get(i).set(j, x);
  }
  
  public void addRow(int i) {
    if (i < 0 || i > rows()) throw new IndexOutOfBoundsException();
    numRows += 1;
    ArrayList<T> addedRow = new ArrayList<T>(cols());
    for (int x = 0; x < cols(); x += 1)
    {
      addedRow.add(null);
    }
    matrix.add(i,addedRow);
  }
  
  public void removeRow(int i) {
    if (i < 0 || i > rows() - 1) throw new IndexOutOfBoundsException();
    numRows -= 1;
    matrix.remove(i);
  }
  
  public void addCol(int j) {
    if (j < 0 || j > cols()) throw new IndexOutOfBoundsException();
    numCols += 1;
    for (int i = 0; i < rows(); i += 1)
    {
      ArrayList<T> addedCol = matrix.get(i);
      addedCol.add(j, null);
    }
  }
  
  public void removeCol(int j) {
    if (j < 0 || j > cols() - 1) throw new IndexOutOfBoundsException();
    numCols -= 1;
    for (int i = 0; i < rows(); i += 1) {
      matrix.get(i).remove(j);
    }
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rows(); i++) {
      for (int j = 0; j < cols(); j++) {
        sb.append(String.valueOf(get(i, j)));
        sb.append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
  
  /* Here is the expected output from this main function:
   1111 null null null null null 
   null 2222 null null null null
   null null 3333 null null null
   null null null 4444 null null
   null null null null 5555 null
   null null null null null 6666
   7777 null null null null null
   null 8888 null null null null
   null null 9999 null null null
   
   1111 null null null null null null
   null 2222 null null null null null
   null null null 3333 null null null
   null null null null null null null
   null null null null 4444 null null
   null null null null null 5555 null
   null null null null null null 6666
   7777 null null null null null null
   null 8888 null null null null null
   null null null 9999 null null null
   */
  public static void main(String[] args) {
    int nrows = 9, ncols = 6;
    Table<Integer> t = new Table<Integer>(Integer.class);
    for (int i = 0; i < ncols; i++) {
      t.addCol(t.cols());
    }
    for (int i = 0; i < nrows; i++) {
      t.addRow(t.rows());
    }
    for (int i = 1; i <= nrows; i++) {
      t.set(i-1, (i-1)%t.cols(), 1111*i);
    }
    System.out.println(t.toString());
    t.addCol(2);
    t.addRow(3);
    System.out.println(t.toString());
    t.removeCol(2);
    t.removeRow(3);
    System.out.println(t.toString());
    t.get(0, 0);
    t.set(0, 0, 1);
  }
}
