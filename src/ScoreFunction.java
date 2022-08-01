import java.util.Vector;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.io.*;

public class ScoreFunction implements Score {
    private SCP scp;
    private Layout layout;
    private ArrayList<SCP> li;
    private ArrayList<SCP> allList;

    public ScoreFunction(Layout layout) {
        this.layout = layout;
        li = new ArrayList<SCP>();
        allList = new ArrayList<SCP>();
    }

    @Override
    public void insert() {
        scp = new SCP(layout.getMajor(), layout.getId(), layout.getSub1(), layout.getSub2(), layout.getSub3()
                , layout.getSub4(), layout.getSub5(), layout.getSub6(), layout.getSub7(), layout.getSub8());
        li.add(scp);
        allList.add(scp);
    }

    @Override
    public DefaultTableModel outputModel(DefaultTableModel model) {
        if (li.size() != 0) {
            for (SCP data : li) {
                Vector<Object> v = new Vector<Object>();
                v.add(data.getMajor());
                v.add(data.getId());
                v.add(data.getSub1());
                v.add(data.getSub2());
                v.add(data.getSub3());
                v.add(data.getSub4());
                v.add(data.getSub5());
                v.add(data.getSub6());
                v.add(data.getSub7());
                v.add(data.getSub8());
                v.add(data.getTotal());
                v.add(data.getAvg());
                model.addRow(v);
            }
        } else {
            while (model.getRowCount() != 0) {
                model.removeRow(0);
            }
            for (SCP data : allList) {
                Vector<Object> v = new Vector<Object>();
                v.add(data.getMajor());
                v.add(data.getId());
                v.add(data.getSub1());
                v.add(data.getSub2());
                v.add(data.getSub3());
                v.add(data.getSub4());
                v.add(data.getSub5());
                v.add(data.getSub6());
                v.add(data.getSub7());
                v.add(data.getSub8());
                v.add(data.getTotal());
                v.add(data.getAvg());
                model.addRow(v);
            }
        }
        while (li.size() != 0) {
            li.remove(0);
        }

        return model;
    }

    @Override
    public DefaultTableModel search(String Major, DefaultTableModel searchModel) {
        for (int i = 0; i < searchModel.getRowCount(); i++) {
            if (!Major.equals(searchModel.getValueAt(i, 0))) {  //만약 학번과 같은 값을 찾는다면

                searchModel.removeRow(i);
                i = -1;
            }
        }
        return searchModel;
    }

    @Override
    public DefaultTableModel to_desc(DefaultTableModel model) {
        Collections.sort(allList);
        if (li.size() != 0) {
            for (SCP data : li) {
                Vector<Object> v = new Vector<Object>();
                v.add(data.getMajor());
                v.add(data.getId());
                v.add(data.getSub1());
                v.add(data.getSub2());
                v.add(data.getSub3());
                v.add(data.getSub4());
                v.add(data.getSub5());
                v.add(data.getSub6());
                v.add(data.getSub7());
                v.add(data.getSub8());
                v.add(data.getTotal());
                v.add(data.getAvg());
                model.addRow(v);

            }
        } else {

        }
            while (model.getRowCount() != 0) {model.removeRow(0);}
            System.out.println(model.getRowCount());
            System.out.println(String.format("%.2f", scp.getAvg()));

            for (SCP data : allList) {
                Vector<Object> v = new Vector<Object>();
                v.add(data.getMajor());
                v.add(data.getId());
                v.add(data.getSub1());
                v.add(data.getSub2());
                v.add(data.getSub3());
                v.add(data.getSub4());
                v.add(data.getSub5());
                v.add(data.getSub6());
                v.add(data.getSub7());
                v.add(data.getSub8());
                v.add(data.getTotal());
                v.add(data.getAvg());
                model.addRow(v);
            }
            while (li.size() != 0) {
                li.remove(0);
            }
            return model;
        }
    @Override
    public DefaultTableModel delete(String Major, DefaultTableModel model){
        for(int i=0;i<allList.size();i++){
            if(Major.equals(allList.get(i).getMajor())){
                allList.remove(i);
                break;
            }
        }
        model=outputModel(model);
        return model;
        }
    @Override
    public void save(){
        Object o =allList;
        File file = null;
        JFileChooser chooser = new JFileChooser();
        int result= chooser.showSaveDialog(layout);
        if(result==JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
        }
        if(file!=null){
            try{
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(o);
                oos.close();
                fos.close();
            } catch(IOException e){}
        }

    }
    @Override
    public DefaultTableModel load(DefaultTableModel model){
        try{
            File file = null;
            JFileChooser c= new JFileChooser();
            int result = c.showOpenDialog(layout);
            if(result==JFileChooser.APPROVE_OPTION){
                file = c.getSelectedFile();
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object o = ois.readObject();
                allList=(ArrayList<SCP>) o;
                fis.close();
                ois.close();
            }
        } catch(IOException | ClassNotFoundException e){ e.printStackTrace(); }
        model=outputModel(model);
        return model;
    }
}









