import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
  
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
  
import com.mysql.jdbc.PreparedStatement;
  
public class PreviewButton
{
    public JButton Preview = new JButton("Preview"); //Creates new  JButton that can be accessed by other classes
    public JButton SaveButton = new JButton("Save");
    public JTable table = new JTable();
    DefaultTableModel tableModel = new DefaultTableModel(); //Creates new default table so tableModel resets on opening a new table.
    public DefaultTableModel changedTableModel = new DefaultTableModel();
    public PreviewButton(MainFrame mainFrame)
    {
        Preview.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                JFrame previewframe = new JFrame("Preview Window");
                previewframe.setVisible(true);
                previewframe.setSize(500, 500);
                try (Connection PreviewCon = DriverManager.getConnection("jdbc:mysql://somewhere:port/schema","user","pass");
                Statement stmt = PreviewCon.createStatement(); //creates statement "stmt" which holds connection from above and allows me to write sql statement
                ResultSet rstables = stmt.executeQuery("SELECT * FROM " + mainFrame.SelectedTable))
                //create result set that selects all the data from the table name held in SelectedTable
                {
                    ResultSetMetaData metaData = rstables.getMetaData(); //Gets meta data from result set of SelectedTable
                    int columnCount = metaData.getColumnCount(); //Get number of columns from meta data
                    for (int columnIndex = 1; columnIndex <= columnCount;columnIndex++) //Get all columns names from meta data
                    {
                        tableModel.addColumn(metaData.getColumnLabel(columnIndex)); //Adds column names to table model
                    }
                    Object [] row = new Object[columnCount]; //Creates an array with the size of the column count
                    while (rstables.next())
                    {
                        for (int i = 0; i < columnCount; i++)
                        {
                                row[i] = rstables.getObject(i+1); //Gets object from the column with the index of the result set 
                        }
                        tableModel.addRow(row); // Adds the row to the table model 
                    }
                    table.setModel(tableModel); // Adds the table model to the JTable
                    previewframe.add(table);
                    previewframe.add(SaveButton, BorderLayout.SOUTH);
                }   
                catch (SQLException p) 
                {
                    System.out.println("somthing went wrong");
                }
  
            }
  
        });
    }
    public void TableChange(MainFrame mainFrame)
    {
        table.getModel().addTableModelListener(new TableModelListener() //adds tablemodellistener to the tablemodel from above
        {
            public void tableChanged(TableModelEvent t)//checks if the tablemodel has been changed
            {
                Vector<Vector<String>> data = new Vector<Vector<String>>(); //creates new vector that holds a string called data
                for (int column = 0; column < table.getModel().getColumnCount(); column++) //loops through the columns of tableModel starting with column 0
                {
                    for (int row = 0; row<table.getModel().getRowCount(); row++) //loops through the rows of tableModel starting with 0
                    {
                        data.add((Vector<String>) table.getModel().getValueAt(row, column)); //adds the value of tableModel at 0,0 to data
                        changedTableModel.addRow(data); // adds the row of data from the data vector to another tableModel
                    }
                }
            }
        });
    }
    public void SaveButton(MainFrame mainFrame)
    {
        SaveButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent s)
            {
                Statement TruncateTable = null; //instantiates the statement "TruncateTalbe" with value null
                try (Connection SaveCon = DriverManager.getConnection("jdbc:mysql://somewhere:port/schema","user","pass");
                        Statement stmt = SaveCon.createStatement(); //creates statement "stmt" which holds connection from above and allows me to write sql statement
                        ResultSet rstables = stmt.executeQuery("SELECT * FROM " + mainFrame.SelectedTable)) //get result set from all data from selectedtable
                {
                    TruncateTable = SaveCon.createStatement();
                    TruncateTable.executeUpdate("TRUNCATE TABLE" + mainFrame.SelectedTable); //executes a truncate on selectedtable
                    java.sql.PreparedStatement InsertTable = SaveCon.prepareStatement("INSERT INTO" +mainFrame.SelectedTable+"VALUES(?,?,?)"); //prepare statement for inserting values into the now empty selected table
                    for (int column = 0; column < changedTableModel.getColumnCount(); column++) //loops through changedTableModel columns start 0
                    {
                        for (int row = 0; row<changedTableModel.getRowCount(); row++) //loops through changedTableModel rows start with 0
                        {
                            Object o = changedTableModel.getValueAt(row, column); //create new object "o" that holds the value of changedTableModel at 0,0
                            InsertTable.setString(column+1, (String)o); 
                        }
                        InsertTable.executeUpdate(); //execute InsertTable statement
                        InsertTable.clearParameters();
                    }
                } 
                catch (SQLException e) 
                {
                    e.printStackTrace();
                }
            }
        });
    }
  
  
}