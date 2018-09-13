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
 * 提取svn更新记录对应的文件的frame
 * @author x
 *
 */
public class FrameUtil {
//	String updatedFilePathList="D:\\new.txt";<br/>
//	 *	 String srcPath="D:\\workspace2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webplus3";<br/>
//	 *   String targetPath="D:\\test";<br/> 
	static String updatedStr = "C:\\Users\\sudytech\\Desktop\\a.txt";
	static String srcStr = "D:\\workspaces\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webplus3";
	static String targetStr = "C:\\Users\\sudytech\\Desktop\\新建文件夹1";
	
	static JFrame frame = new JFrame();
	static JButton updatedFileBt = new JButton("选择更新的文件    ");
	static JTextField updatedFileName = new JTextField(updatedStr,50);
	
	static JButton srcPathBt = new JButton("选择源文件的目录");
	static JTextField srcPathName = new JTextField(srcStr,50);
	
	static JButton argetPathBt = new JButton("选择存放目录        ");
	static JTextField argetPathName = new JTextField(targetStr,50);
	JFileChooser chooser;
	String choosertitle;
	static JButton submitBt = new JButton("确定提取文件        ");
	static JButton clearBt = new JButton("重置");
	static JTextField msg = new JTextField("message",44);
	static JPanel p = new JPanel();
	static int num =1;
	static String st = "";
	String updatedFilePathList="";
	String srcPath="";
	String targetPath="";
	
	/**
	 * 显示frmae
	 */
	public void show() {
		updatedFileBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					// 解释下这里,弹出个对话框,可以选择要上传的文件,如果选择了,就把选择的文件的绝对路径打印出来,有了绝对路径,通过JTextField的settext就能设置进去了,那个我没写
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
						msg.setText("已经提取文件了。");
					}else{
						clearExtractFileSum();
						st = ef.extractSvnUpdatedFile(updatedFilePathList, srcPath, targetPath);
						msg.setText(st);
					}
				}
				if("error".endsWith(st)){
					String error="error,请在  "+targetPath+" 中查询日志。";
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
		
		String text ="说明：这是根据svn日志更新的记录提取对应的class、xml、jsp及web下其他文件。\n" +
//				"1、源文件目录就是项目已被编译的源文件的目录。\n" +
				"      1、以上输入框的文件路径为举例说明，请根据实际情况输入对应路径。\n" +
				"      2、提取出错时日志存储在D盘。\n" +
				"      3、可以将文件或文件夹路径复制在输入框中。    -- by：xyq";
		JTextArea comment = new JTextArea(text,2,63);
		comment.setEditable(false);
		msg.setEditable(false);
		p.add(comment);
		frame.add(p);
		frame.setTitle("提取svn更新文件1.2");
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