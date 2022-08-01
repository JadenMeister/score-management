import javax.swing.*;
import java.awt.event.*;
import javax.swing.JTable;
import java.awt.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class Layout extends JFrame implements ActionListener
{
    private JLabel IdL, MajorL, sub1L, sub2L, sub3L, sub4L, sub5L, sub6L, sub7L, sub8L;
    private JLabel [] allLabel;
    private JButton bt1, bt2, bt3, bt4, bt5, bt6;
    private JButton [] allBtn;
    private JTextField MajorT,IdT,sub1T,sub2T,sub3T,sub4T,sub5T,sub6T,sub7T,sub8T;
    private JTextField [] allText;
    private DefaultTableModel model;
    private Vector <String> head;
    private JTable table;
    private ScoreFunction sf;


    public Layout(){
        sf = new ScoreFunction(this);
        //하단버튼
        JPanel bottom = new JPanel(new GridLayout(1,5,0,0));
        bt1=new JButton("입력");
        bt2=new JButton("출력");
        bt3=new JButton("학번검색");
        bt4=new JButton("순위");
        bt5=new JButton("삭제");
        bt6=new JButton("파일저장");
        allBtn = new JButton[] {bt1,bt2,bt3,bt4,bt5,bt6};
        for(int i=0;i<allBtn.length;i++) {
            bottom.add(allBtn[i]);
        }
        add("South",bottom);


            head = new Vector<String>();
            head.add("학번");
            head.add("이름");
            head.add("과목1");
            head.add("과목2");
            head.add("과목3");
            head.add("과목4");
            head.add("과목5");
            head.add("과목6");
            head.add("과목7");
            head.add("과목8");
            head.add("총점");
            head.add("평균");
            model = new DefaultTableModel(head, 0);
            table = new JTable(model);
            JScrollPane scroll = new JScrollPane(table);

            JPanel center = new JPanel(new GridLayout(1,2,0,0));
            JPanel center1= new JPanel(new GridLayout(10,1,0,0));

            JPanel []leftP= new JPanel[10];
            for(int i=0;i<leftP.length;i++) {
                leftP[i] = new JPanel();
            }

            MajorL=new JLabel("학번");
            IdL=new JLabel("이름");
            sub1L=new JLabel("과목1");
            sub2L=new JLabel("과목2");
            sub3L=new JLabel("과목3");
            sub4L=new JLabel("과목4");
            sub5L=new JLabel("과목5");
            sub6L=new JLabel("과목6");
            sub7L=new JLabel("과목7");
            sub8L=new JLabel("과목8");

            allLabel= new JLabel[]{ MajorL, IdL, sub1L, sub2L, sub3L, sub4L, sub5L, sub6L,sub7L, sub8L };


            //텍스트 필드 설정
            MajorT= new JTextField("",20);
            IdT= new JTextField("",20);
            sub1T= new JTextField("",20);
            sub2T= new JTextField("",20);
            sub3T= new JTextField("",20);
            sub4T= new JTextField("",20);
            sub5T= new JTextField("",20);
            sub6T= new JTextField("",20);
            sub7T= new JTextField("",20);
            sub8T= new JTextField("",20);
            allText = new JTextField[]{ MajorT, IdT, sub1T, sub2T, sub3T, sub4T, sub5T, sub6T, sub7T, sub8T };

                 for(int i=0;i<leftP.length;i++) {
                     leftP[i].add("West", allLabel[i]);
                     leftP[i].add("Center", allText[i]);
                 }

                for(int i=0;i<10;i++){
                    center1.add(leftP[i]);
                }
                center.add(center1); center.add(scroll);
                add(center);

            //윈도우
            setBounds(300,500,600,300);
            setVisible(true);

            for(int i=0;i<allBtn.length;i++){
                allBtn[i].addActionListener(this);
            }

            //이벤트
            this.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){ System.exit(0); }
            });
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {  //입력
            JOptionPane.showConfirmDialog(Layout.this, "정보 입력", "정보",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            sf.insert();
            for (int i = 0; i < allText.length; i++) {
                allText[i].setText("");
            }
        } else if (e.getSource() == bt2) { //출력
            model = sf.outputModel(model);
        } else if (e.getSource() == bt3) {
            String answer = JOptionPane.showInputDialog(this, "학번 입력");
            if (answer != null) {
                model = sf.search(answer, model);
            }
        } else if (e.getSource() == bt4) {  //검색
            model = sf.to_desc(model);
        } else if (e.getSource() == bt5) {  //삭제
            String answer = JOptionPane.showInputDialog(this, "삭제할 학번 입력");
            if (answer != null) model = sf.delete(answer, model);
        } else if (e.getSource() == bt6) {  //파일저장
            sf.save();
        }
    }
        public String getMajor(){return MajorT.getText();}
        public String getId() {return IdT.getText();}
        public int getSub1() {return Integer.parseInt(sub1T.getText());}
        public int getSub2() {return Integer.parseInt(sub2T.getText());}
        public int getSub3() {return Integer.parseInt(sub3T.getText());}
        public int getSub4() {return Integer.parseInt(sub4T.getText());}
        public int getSub5() {return Integer.parseInt(sub5T.getText());}
        public int getSub6() {return Integer.parseInt(sub6T.getText());}
        public int getSub7() {return Integer.parseInt(sub7T.getText());}
        public int getSub8() {return Integer.parseInt(sub8T.getText());}

}









