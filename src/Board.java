import java.util.Vector;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

interface  Board //인터페이스
{

    public void insert();  //입력 메소드
    public DefaultTableModel to_desc(DefaultTableModel model);
    public DefaultTableModel delete(String Id, DefaultTableModel model);
    public DefaultTableModel outputModel(DefaultTableModel model);
    public DefaultTableModel search(String Id, DefaultTableModel searchModel);
    public void save();
    public DefaultTableModel load(DefaultTableModel model);
}
