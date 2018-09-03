package com.xyq;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * ��ȡsvn���¼�¼��Ӧ���ļ���frame
 * @author x
 *
 */
public class FrameUtil {
//	String updatedFilePathList="D:\\new.txt";<br/>
//	 *	 String srcPath="D:\\workspace2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webplus3";<br/>
//	 *   String targetPath="D:\\test";<br/> 
	static String updatedStr = "C:\\Users\\sudytech\\Desktop\\a.txt";
	static String srcStr = "D:\\workspaces\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webplus3";
	static String targetStr = "C:\\Users\\sudytech\\Desktop\\�½��ļ���1";
	
	static JFrame frame = new JFrame();
	static JButton updatedFileBt = new JButton("ѡ����µ��ļ�    ");
	static JTextField updatedFileName = new JTextField(updatedStr,50);
	
	static JButton srcPathBt = new JButton("ѡ��Դ�ļ���Ŀ¼");
	static JTextField srcPathName = new JTextField(srcStr,50);
	
	static JButton argetPathBt = new JButton("ѡ����Ŀ¼        ");
	static JTextField argetPathName = new JTextField(targetStr,50);
	JFileChooser chooser;
	String choosertitle;
	static JButton submitBt = new JButton("ȷ����ȡ�ļ�        ");
	static JButton clearBt = new JButton("����");
	static JTextField msg = new JTextField("message",44);
	static JPanel p = new JPanel();
	static int num =1;
	static String st = "";
	String updatedFilePathList="";
	String srcPath="";
	String targetPath="";
	
	/**
	 * ��ʾfrmae
	 */
	public void show() {
		updatedFileBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					// ����������,�������Ի���,����ѡ��Ҫ�ϴ����ļ�,���ѡ����,�Ͱ�ѡ����ļ��ľ���·����ӡ����,���˾���·��,ͨ��JTextField��settext�������ý�ȥ��,�Ǹ���ûд
					System.out.println("updatedFileName:    "+jfc.getSelectedFile().getAbsolutePath());
					updatedFileName.setText(jfc.getSelectedFile().getAbsolutePath());
					num=1;
				}
			}
		});
		
		srcPathBt.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			    chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle(choosertitle);
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);
			    if (chooser.showOpenDialog(p) == JFileChooser.APPROVE_OPTION) {
			    	String s = chooser.getCurrentDirectory()+"\\"+chooser.getSelectedFile().getName();
			        System.out.println("srcPathName:    "+s);
			        srcPathName.setText(s);
			        num=1;
			    }
			   }
		});
		
		argetPathBt.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			    chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle(choosertitle);
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);
			    if (chooser.showOpenDialog(p) == JFileChooser.APPROVE_OPTION) {
			    	String s = chooser.getCurrentDirectory()+"\\"+chooser.getSelectedFile().getName();
			        System.out.println("argetPathName:    "+s);
			        argetPathName.setText(s);
			        num=1;
			    } 
			   }
		});
		
		submitBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExtractFile ef = new ExtractFile();
				if(!updatedFilePathList.endsWith(updatedFileName.getText()) || !srcPath.equals(srcPathName.getText()) || 
					!targetPath.equals(argetPathName.getText())){
					num=1;
				}
//				 updatedFilePathList=updatedFileName.getText();
//				 srcPath=srcPathName.getText();
//				 targetPath=argetPathName.getText();
				if(num==1){
					clearExtractFileSum();
					 updatedFilePathList=updatedFileName.getText();
					 srcPath=srcPathName.getText();
					 targetPath=argetPathName.getText();
					st = ef.extractSvnUpdatedFile(updatedFilePathList, srcPath, targetPath);
					msg.setText(st);
				}else{
					if("success".equals(st)){
						msg.setText("�Ѿ���ȡ�ļ��ˡ�");
					}else{
						clearExtractFileSum();
						st = ef.extractSvnUpdatedFile(updatedFilePathList, srcPath, targetPath);
						msg.setText(st);
					}
				}
				if("error".endsWith(st)){
					String error="error,����  "+targetPath+" �в�ѯ��־��";
					msg.setText(error);
				}
				num++;
			}
		});
		clearBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatedFileName.setText(updatedStr);
				srcPathName.setText(srcStr);
				argetPathName.setText(targetStr);
				msg.setText("message");
				num=1;
			}
		});
		
		frame.setLayout(new BorderLayout(5,5)); 
		Panel p = new Panel();
//		GridLayout layout = new GridLayout(4,2,10,10);
//		p.setLayout(layout);
		p.add(updatedFileBt);
		p.add(updatedFileName);	
		p.add(srcPathBt);
		p.add(srcPathName);
		p.add(argetPathBt);
		p.add(argetPathName);
		p.add(submitBt);
		p.add(msg);
		p.add(clearBt);
		
		String text ="˵�������Ǹ���svn��־���µļ�¼��ȡ��Ӧ��class��xml��jsp��web�������ļ���\n" +
//				"1��Դ�ļ�Ŀ¼������Ŀ�ѱ������Դ�ļ���Ŀ¼��\n" +
				"      1�������������ļ�·��Ϊ����˵���������ʵ����������Ӧ·����\n" +
				"      2����ȡ����ʱ��־�洢��D�̡�\n" +
				"      3�����Խ��ļ����ļ���·��������������С�    -- by��xyq";
		JTextArea comment = new JTextArea(text,2,63);
		comment.setEditable(false);
		msg.setEditable(false);
		p.add(comment);
		frame.add(p);
		frame.setTitle("��ȡsvn�����ļ�1.2");
		frame.setLocation(300, 200);
		frame.setSize(780, 245);
		// f.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//		frame.pack();
	}

	protected void clearExtractFileSum() {
		// TODO Auto-generated method stub
		ExtractFile.sumError=0;
		ExtractFile.sumError1=0;
		ExtractFile.sumError2=0;
		ExtractFile.sumError3=0;
		ExtractFile.sumError4=0;
		ExtractFile.sumError5=0;
		ExtractFile.sumError6=0;
		ExtractFile.sumJava=0;
		ExtractFile.sumJava1=0;
		ExtractFile.sumJava2=0;
		ExtractFile.sumJsp=0;
		ExtractFile.sumXml=0;
		ExtractFile.sumWeb=0;
		ExtractFile.row=0;
		ExtractFile.map.clear();
		ExtractFile.replace.clear();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrameUtil().show();
		
	}

}