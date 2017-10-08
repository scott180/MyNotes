package com.xyq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * �����ύ��svn��¼����Ӧ��class��xml��jsp�ļ���ȡ����
 * @author x
 *
 */
public class ExtractFile {
	private static String targetPathStatic = "";
	private static String dir = "D://";//Ҫ�洢��Ŀ���ļ��г���ʱ����־�洢��D��
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
	 static int sumJava = 0;//class�ļ�����
	 static int sumJava1 = 0;//class�ļ���
	 static int sumJava2 = 0;//�ڲ���class�ļ���
	 static int sumJsp = 0;//jsp�ļ���
	 static int sumXml = 0;//xml�ļ���
	 static int sumWeb = 0;//web�������ļ�����json��jpg��css��js�ȵȣ���jsp���ƣ�
	 
	 static int sumError = 0;//�����ļ���
	 static int sumError1 = 0;//��ĿĿ¼
	 static int sumError2 = 0;//����Ŀ�ļ�����ʽ����
	 static int sumError3 = 0;//����Ŀ�ļ����Ǳ����class�ļ�
	 static int sumError4 = 0;//����Ŀ�ļ����Ǳ����xml�ļ�
	 static int sumError5 = 0;//����Ŀ�ļ����Ǳ����jsp�ļ�
	 static int sumError6 = 0;//����Ŀ�ļ����Ǳ����web���ļ�
	 static Map<Integer,String> map = new LinkedHashMap<Integer,String>();//�����µ��ļ�ÿ�м�¼����map�У�ȥ��ʱʹ��
	 static int row = 0;//�����ļ�������
	 static Map<String,Integer> replace = new LinkedHashMap<String,Integer>();//�ظ��ļ�¼
	/*	public static void main(String[] args) throws Exception {
			String updatedFilePathList = "D://new.txt";
			File updatedFile = new File(updatedFilePathList);
//			String t = "D://222//1�½��ļ���111//11";
//			File f = new File(t);
//			if(! f.exists()) f.mkdirs();
//			String path = f.getAbsolutePath()+"//"+updatedFile.getName();
//			File file = new File(path);
//			file.createNewFile();
//			copy(updatedFile,f);
			String projectName = "webplus3";
			String jas = projectName+"/src/java/";
			String webs = projectName+"/web/";
//			File[] list = updatedFile.listFiles();
//			for(File s : list){
//				System.out.println(s.getName().substring(0, (s.getName().lastIndexOf(".")+1)));
//			}
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(updatedFile)));
			String s = br.readLine();
			/*String name = s.substring(s.lastIndexOf("/")+1,s.length());
			String srcStr = "D:\\workspaces\\UCPPlus_v1_1\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webplus3";
			String path = srcStr+"\\WEB-INF\\"+name;
			File file = new File(path);
//			System.out.println(file.getAbsolutePath());
			String targetStr = "C:\\Users\\sudytech\\Desktop\\�½��ļ���1";
			String targetDir = targetStr+"\\ROOT\\WEB-INF";*/
			
			
//			System.out.println(11111);
//			System.out.println(s);
//			String cname = s.substring(s.lastIndexOf("/")+1, s.length());//����+��չ��
//			System.out.println("--  "+cname);
//			/����ʦ����ѧ��������Ժ����/trunk/02src/webplus3/webplus3/src/java/com/sudytech/webplus/jgy/action/RankListAction.java
//			String name = "webplus3";
//			s.indexOf(name+"/src/java");
//			System.out.println(s.indexOf("/src1/java"));
//			System.out.println(s.substring(s.indexOf(name+"/src/java"),s.length()));
//			System.out.println(s.substring(s.indexOf(webs), s.length()));
//			System.out.println(s.substring(s.indexOf("classes"), s.lastIndexOf("\\")));
//			s=s.substring("webplus3/src/java".length(),s.lastIndexOf("/"));//Ŀ¼
//			s=s.substring(s.lastIndexOf("/")+1, s.length()-".java".length());//����
//			System.out.println(updatedFile.getAbsolutePath());
			
			/*String updatedFilePathList = "F://�½��ļ���//new  0.txt";
//			String  srcPath = "D://workspace2//.metadata//.plugins//org.eclipse.wst.server.core//tmp0/wtpwebapps//webplus3";
			String  srcPath = "F://�½��ļ���//webplus3//webplus3";
			String targetPath = "F://�½��ļ���";
			extractSvnUpdatedFile(updatedFilePathList,srcPath,targetPath);
			String projectName= "webplus3";
			String tt = s.substring(s.lastIndexOf(projectName)+projectName.length()+1, s.lastIndexOf("\\"));
			System.out.println(tt);
		};*/
		
		
		/**
		 * ���ݸ��µ�java��xml��jsp�ļ��б�Դ�ļ����Ƶ�Ŀ���ļ���
		 * @param updatedFilePathList  ���µ��б��ļ�
		 * @param srcPath  Դ�ļ��ļ���
		 * @param targetPath  Ŀ���ļ���
		 * @comment
		 *  1��Դ�ļ��ļ��е����ƾ�����Ŀ��������һ������Դ�ļ�����ʽ���£�<br/>
		 * 	 String updatedFilePathList="D:\\new.txt";<br/>
		 *	 String srcPath="D:\\workspace2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webplus3";<br/>
		 *   String targetPath="D:\\test";<br/> 
		 *  2�����µ��б��ļ���svn��־��¼�и��ƺ�Ҫ��������ʽ���£�<br/>
		 *  webplus3/src/java/com/sudytech/webplus/jgy/schedule/action/ScheduleMgrAction.java<br/>
		 *	webplus3/src/java/config/applicationContext-activity.xml<br/>
		 *	webplus3/web/_web/jgy/manage/updateCardPadge.jsp<br/>
		 *	3�����������ļ����ļ��в�����ʱ��־�ļ��洢��D�̡�
		 */
		public String extractSvnUpdatedFile(String updatedFilePathList,String srcPath,String targetPath){
			initLog(targetPath);
			log("***************************************************************************begin***************************************************************************");
			String remind ="success";
			try {
				File updatedFile = new File(updatedFilePathList);
				File srcFile = new File(srcPath);
				File targetFile = new File(targetPath);
				if(!updatedFile.exists() || !updatedFile.isFile()){
					remind = " ���µ��ļ��б��ļ������ڣ�"+"  "+updatedFilePathList;
				} else if(!srcFile.exists() || !srcFile.isDirectory()){
					remind =" Դ�ļ�Ŀ¼������(��Ŀ�����·������ȷ)��"+"  "+srcPath;
				} else if(!targetFile.exists() || !targetFile.isDirectory()){
					remind = " Ҫ��ŵ�Ŀ���ļ��в����ڣ�"+"  "+targetPath;
				}else{
					String root = targetPath+"//ROOT";
					File rootDir = new File(root);
					rootDir.mkdir();
					targetFile = new File(root);
					extract(updatedFile,srcFile,targetFile);
				}
				if(sumJava==0 && sumXml==0 && sumJsp==0 && "success".endsWith(remind)){
					remind = "error";
				}
				System.out.println(remind);
				if(!"success".equals(remind)){
					  log(getCurrentTime()+remind);
				}else{
				log("\n\r");
				log("*********************************************************************************************************************************************************");
				int sum = sumJava+sumJsp+sumXml+sumWeb;
				log("--��ȡ�ɹ��ļ�ͳ�ƣ�������"+sum+"�������� class�ļ�������"+sumJava+"�� (class:"+sumJava1+"��,�ڲ���class��"+sumJava2+"��)"+",jsp�ļ�����"+sumJsp+"��,xml�ļ�����"+sumXml+"��,web���ļ�����"+sumWeb+"��--");
				log("--��ȡʧ���ļ�ͳ�ƣ�������"+sumError+"�������� ��ĿĿ¼:"+sumError1+"��������Ŀ�ļ�:"+sumError2+"����"+
				   "�Ǳ���class�ļ���"+sumError3+"�����Ǳ���xml�ļ���"+sumError4+"�����Ǳ���jsp�ļ���"+sumError5+"�����Ǳ���web���ļ���"+sumError6+"��--");
				log("--����"+map.size()+"��,��Ч·��"+(sum-sumJava2)+"��,��Ч·��"+sumError+"��--");
				logReplaceFile();
				//��Ŀ�ļ����Ǳ����class�ļ�
				}
				log("**************************************************************************end****************************************************************************");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return remind;
		}
		
		/**
		 * ����ظ���¼����־
		 */
		private void logReplaceFile() {
			// TODO Auto-generated method stub
//			int sum = map.size();
//			List<String> list = new ArrayList<String>();
			/*Map<String,Integer> replace = new LinkedHashMap<String,Integer>();
			for(int i=0;i<row;i++){
				String value = map.get(i);
				for(int j=i+1;j<row;j++){
					String value2 = map.get(j); 
					if(value.equals(value2)){
//						list.add(value);break;
						int num = count.get(value)==null ? 1 : count.get(value);
						num++;
						if(j>)
						count.put(value, num);
					}
				}
			}*/
			
			if(replace.size()>0){
				int c = 0;
				for(String st : replace.keySet()){
					int num = replace.get(st);
					c+=num;
				}
				log("--�ظ�·����"+c+"�У��������£�");
				for(String st : replace.keySet()){
					int num = replace.get(st);
					log("   "+st+" :"+num+"��");
				}
			}
		}

		/** 
		 * ���ݸ����ļ��б�Դ�ļ����Ƶ�Ŀ���ļ���
		 * @param updatedFile
		 * @param srcFile
		 * @param targetFile
		 */
		private void extract(File updatedFile, File srcFile,File targetFile) {
			// TODO Auto-generated method stub
			try {
				String projectName = srcFile.getName();
				String absName = srcFile.getAbsolutePath();
//				InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");  
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(updatedFile),"UTF-8"));
				String st = null;
				while((st=br.readLine())!=null){
					if("".equals(st.trim()) || checkReplace(st))continue;
					if(!st.contains(".")){
						log("record dir: "+st);
						sumError1++;
						sumError++;
						log("��ĿĿ¼:  "+st);
					}else{
						st = handlePrefix(st,projectName);
						if(projectName.equals(st.substring(0, projectName.length()))){//��Ŀ����ͬ
							if(st.contains("/web/WEB-INF/")){
								String recordName = st.endsWith("xml") ? "xml" : "web";
								log("record "+recordName+":"+st);
								String name = st.substring(st.lastIndexOf("/")+1,st.length());
								//String srcStr = "D:\\workspaces\\UCPPlus_v1_1\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webplus3";
								String path = absName+"\\WEB-INF\\"+name;
								File src = new File(path);
//								System.out.println(file.getAbsolutePath());
								//String targetStr = "C:\\Users\\sudytech\\Desktop\\�½��ļ���1";
								String targetDir = targetFile.getAbsolutePath()+"\\WEB-INF";
								File target = new File(targetDir);
								handleWebInfFiles(src,target,st);
								
							}else if(st.endsWith("java")){
								log("record class: "+st);
								//webplus3/src/java/com/sudytech/webplus/jgy/collect/IcollectStandrd.java
								String tdir = st.substring((projectName+"/src/java").length(),st.lastIndexOf("/"));//Ŀ¼
								String cname = st.substring(st.lastIndexOf("/")+1, st.length()-".java".length());//����
								String dir = absName+"\\WEB-INF\\classes"+tdir;
								File classDir = new File(dir);
								//F:\�½��ļ���\webplus3\webplus3\WEB-INF\classes
								//F:\�½��ļ���\webplus3\webplus3\com\sudytech\webplus\jgy\card
								handleClassFile(classDir,targetFile,cname);
							}else if(st.endsWith("jsp")){
								log("record jsp: "+st);
								//webplus3/web/_web/activity/manage/activityLabel.jsp
								String tdir = st.substring((projectName+"/web").length(),st.lastIndexOf("/"));//Ŀ¼
								String cname = st.substring(st.lastIndexOf("/")+1, st.length()-".jsp".length());//����
								String dir = absName+tdir;
								File jspDir = new File(dir);
								handleJspFile(jspDir,targetFile,cname,projectName);
							}else if(st.endsWith("xml")){
								log("record xml: "+st);
								String tdir = st.substring((projectName+"/src/java").length(),st.lastIndexOf("/"));//Ŀ¼
								String cname = st.substring(st.lastIndexOf("/")+1, st.length()-".xml".length());//����
								String dir = absName+"\\WEB-INF\\classes"+tdir;
								File classDir = new File(dir);
								handleXmlFile(classDir,targetFile,cname);
							}else if(st.contains(".")){
								log("record web: "+st);
								String tdir = st.substring((projectName+"/web").length(),st.lastIndexOf("/"));//Ŀ¼
								String cname = st.substring(st.lastIndexOf("/")+1, st.length());//����+��չ��
								String dir = absName+tdir;
								File jspDir = new File(dir);
								handleWebFile(jspDir,targetFile,cname,projectName);
							}
						/*	else{
								log("record dir: "+st);
//								sumError1++;
								sumError++;
								log("����:  "+st);
							}*/
						
						}else{
							log("record format error: "+st);
							sumError2++;
							sumError++;
							log("����Ŀ�ļ�:  "+st);
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("extract: "+e.getMessage());
//				e.printStackTrace();
			}
		}
		
		/**
		 * ȥ��
		 * @param st
		 * @return
		 */
		private boolean checkReplace(String st) {
			// TODO Auto-generated method stub
			boolean flag = false;
			for(String record : map.values()){
				if(record.equals(st)){
					int num = replace.get(st) == null ? 0 : replace.get(st);
					num++;
					replace.put(st, num);
					log("�ظ�:  "+st);
					flag = true;break;
				}
			}
			map.put(row, st); 
			row++;
			return flag;
		}

		/**
		 * ����ǰ׺
		 * �� �� /����ʦ����ѧ��������Ժ����/trunk/02src/webplus3/webplus3/src/java/com/sudytech/webplus/jgy/action/RankListAction.java
		 * ����Ϊ webplus3/src/java/com/sudytech/webplus/jgy/action/RankListAction.java
		 * @param st
		 * @param projectName
		 * @return
		 */
		private String handlePrefix(String st, String projectName) {
			// TODO Auto-generated method stub
//			System.out.println(s.substring(s.indexOf(name+"/src/java"),s.length()));
//			System.out.println(s.substring(s.indexOf(name+"/web")+name.length()+1, s.length()));
//			webplus3/web/_web/jgy/manage/cardPadgeManage.jsp
//			/����ʦ����ѧ��������Ժ����/trunk/02src/webplus3/webplus3/src/java/com/sudytech/webplus/jgy/action/RankListAction.java
			String ha = "";
			String jas = projectName+"/src/java/";
			String webs = projectName+"/web/";
			try{
				if(st.startsWith(projectName)){
					return st;
				}else if(st.indexOf(jas)==-1 && st.indexOf(webs)==-1){
					return st;
				}else{
					if(!st.contains(".")){
						return st;
					}else if(st.endsWith("java") || st.endsWith("xml")){
						if(st.contains("/web/WEB-INF/")){
							ha = st.substring(st.indexOf(projectName+"/web/WEB-INF/"),st.length());
						}else{
							ha = st.substring(st.indexOf(jas),st.length());
						}
					}else{
						ha = st.substring(st.indexOf(webs), st.length());
					}
				}
			}catch (Exception e){
				System.out.println("handlePrefix: "+st+e.getMessage());
			}
			return ha;
		}
		
		/**
		 * ����WEBINF���ļ�
		 * @param srcFile
		 * @param targetDir
		 * @param record
		 */
		private void handleWebInfFiles(File srcFile,File targetDir,String record){
			if(srcFile.exists()){
				if(!targetDir.exists()) targetDir.mkdirs();
				if(srcFile.getName().endsWith("xml")){
					sumXml++;
				}else{
					sumWeb++;
				}
				log("   src: "+srcFile.getAbsolutePath());
				copy(srcFile,targetDir);
			}else{
				sumError6++;
				sumError++;
				log("����Ŀ�ļ����Ǳ����web���ļ�:  "+record);
			}
			
		}
		/**
		 * ����web�������ļ� ��json��jpg��css��js�ȵ�
		 * @param webDir
		 * @param targetFile
		 * @param cname
		 * @param projectName
		 */
		private  void handleWebFile(File webDir, File targetFile,
				String cname,String projectName) {
			// TODO Auto-generated method stub
			if(webDir.exists() && webDir.isDirectory()){
				int n1=0;
				File[] files  = webDir.listFiles();
				for(int i=0 ;i<files.length; i++){
					String name = files[i].getName();
					if((cname).equals(name)){
						n1++;
						String path = webDir.getAbsolutePath()+"\\"+name;
						log("   src: "+path);
						copyJspFile(path,targetFile,projectName);
					}
				}
				sumWeb+=n1;
			}else{
				sumError6++;
				sumError++;
				log("����Ŀ�ļ����Ǳ����web���ļ�:  "+cname);
			}
		}
		/**
		 * ����jsp�ļ�
		 * @param jspDir
		 * @param targetFile
		 * @param cname
		 * @param projectName
		 */
		private  void handleJspFile(File jspDir, File targetFile,
				String cname,String projectName) {
			// TODO Auto-generated method stub
			if(jspDir.exists() && jspDir.isDirectory()){
				int n1=0;
				File[] files  = jspDir.listFiles();
				for(int i=0 ;i<files.length; i++){
					String name = files[i].getName();
					if((cname+".jsp").equals(name)){
						n1++;
						String jspPath = jspDir.getAbsolutePath()+"\\"+name;
						log("   src: "+jspPath);
						copyJspFile(jspPath,targetFile,projectName);
					}
				}
				sumJsp+=n1;
			}else{
				sumError5++;
				sumError++;
				log("����Ŀ�ļ����Ǳ����jsp�ļ�:  "+cname);
			}
		}

		/**
		 * ����class�ļ�
		 * @param classDir �ļ�Ŀ¼
		 * @param targetFile  ��Ҫ��ŵ�Ŀ¼
		 * @param cname  �ļ���
		 */
		private  void handleClassFile(File classDir, File targetFile,String cname) {
			// TODO Auto-generated method stub
			if(classDir.exists() && classDir.isDirectory()){
				int n1=0;
				int n2=0;
				File[] files  = classDir.listFiles();
				for(int i=0 ;i<files.length; i++){
					String name = files[i].getName();
					if((cname+".class").equals(name)){
						n1++;
						String classPath = classDir.getAbsolutePath()+"\\"+name;
						log("   src: "+classPath);
						copyClassFile(classPath,targetFile);
					}else if(name.startsWith(cname+"$") && name.endsWith(".class")){
						n2++;
						String classPath = classDir.getAbsolutePath()+"\\"+name;
						log("   src: "+classPath);
						copyClassFile(classPath,targetFile);
						
					}
				}
				sumJava1+=n1;
				sumJava2+=n2;
				sumJava+=(n1+n2);
				log(cname+" class�ļ���"+n1+"�����ڲ���class�ļ���"+n2+"��");
			}else{
				sumError3++;
				sumError++;
				log("����Ŀ�ļ����Ǳ����class�ļ�:  "+cname);
			}
		}
		
		/**
		 * ����xml�ļ�
		 * @param classDir �ļ�Ŀ¼
		 * @param targetFile  ��Ҫ��ŵ�Ŀ¼
		 * @param cname  �ļ���
		 */
		private  void handleXmlFile(File classDir, File targetFile,String cname) {
			// TODO Auto-generated method stub
			if(classDir.exists() && classDir.isDirectory()){
				int n1=0;
				File[] files  = classDir.listFiles();
				for(int i=0 ;i<files.length; i++){
					String name = files[i].getName();
					if((cname+".xml").equals(name)){
						n1++;
						String classPath = classDir.getAbsolutePath()+"\\"+name;
						log("   src: "+classPath);
						copyClassFile(classPath,targetFile);
					}
				}
				sumXml+=n1;
			}else{
				sumError4++;
				sumError++;
				log("����Ŀ�ļ����Ǳ����xml�ļ�:  "+cname);
			}
		}

		/**
		 * ����class��xml�ļ�Ŀ��·��
		 */
		private  void copyClassFile(String classPath, File targetRoot) {
			// TODO Auto-generated method stub
//			F:\�½��ļ���\webplus3\webplus3\WEB-INF\classes\com\sudytech\webplus\jgy\follow\IfollowStandrd.class
//			s.substring(s.indexOf("classes"), s.lastIndexOf("\\")
			try{
				File classFile = new File(classPath);
				if(!classFile.exists()){
					log("copyFile�쳣��"+classPath);
					return;
				}
				String t = classPath.substring(classPath.indexOf("classes"), classPath.lastIndexOf("\\"));
				String targetPath = targetRoot.getAbsolutePath()+"\\WEB-INF\\"+t;
				File targetDir = new File(targetPath);
				if(!targetDir.exists()) targetDir.mkdirs();
				copy(classFile,targetDir);
			}catch(Exception e){
				log("copyFile Exception:"+e.getMessage());
			}
		}
		
		/**
		 * ����jsp��web�ļ�Ŀ��·��
		 */
		private  void copyJspFile(String jspPath, File targetRoot,String projectName) {
			// TODO Auto-generated method stub
//			record: webplus3/web/_web/jgy/manage/jgyQueryStudent.jsp
//			src: F:\�½��ļ���\webplus3\webplus3\_web\jgy\manage\jgyQueryStudent.jsp
//			target: F:\�½��ļ���\ROOT\_web\jgy\manage\jgyQueryStudent.jsp
			try{
				File jspFile = new File(jspPath);
				if(!jspFile.exists()){
					log("copyJspWebFile�쳣��"+jspPath);
					return;
				}
				int begin = jspPath.lastIndexOf(projectName)+projectName.length()+1;
				int end = jspPath.lastIndexOf("\\");
				String t = "";
				if(end>begin){
					t = jspPath.substring(begin,end);
				}
				String targetPath = targetRoot.getAbsolutePath()+"\\"+t;
				File targetDir = new File(targetPath);
				if(!targetDir.exists()) targetDir.mkdirs();
				copy(jspFile,targetDir);
			}catch(Exception e){
				log("copyJspWebFile Exception:"+e.getMessage());
			}
		}
		/**
		 * �����ļ�
		 * @param srcFile
		 * @param targetDir
		 */
		private  void copy(File srcFile, File targetDir) {
			// TODO Auto-generated method stub
			try {
				if(!srcFile.exists()){
					log("ϵͳ�Ҳ���ָ�����ļ�:"+srcFile.getAbsolutePath());
					return;
				}else if(!targetDir.exists()){
					log("ϵͳ�Ҳ���ָ�����ļ�:"+targetDir.getAbsolutePath());
					return;
				}
				String path = targetDir.getAbsolutePath()+"\\"+srcFile.getName();
				File file = new File(path);
				file.createNewFile();
				FileInputStream in = new FileInputStream(srcFile);
				FileOutputStream out = new FileOutputStream(file);
				byte[] b = new byte[1024];
				int c=0;
				while( (c=in.read(b))!=-1){
					out.write(b, 0, c);
					out.flush();
				}
				in.close();
				out.close();
				log("   target: "+path);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		/**
		 * ��ʼ����־
		 * @param targetPath
		 */
		private  void initLog(String targetPath) {
			// TODO Auto-generated method stub
			try {
				targetPathStatic = targetPath;
				File dir = new File(targetPathStatic);
				if(dir.exists() && dir.isDirectory()){
					File log = new File(targetPathStatic+"//log."+getCurrentDate()+".txt");
					if(!log.exists()) log.createNewFile();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/**
		 * �����־�ļ�
		 * @param remind
		 */
		private  void log(String remind) {
			// TODO Auto-generated method stub
//			String currentTime = getCurrentTime(); 
			File log = new File(targetPathStatic+"//log."+getCurrentDate()+".txt");
//			FileWriter fw = null;
			OutputStreamWriter fw = null;
			try {
				if(!log.exists()){
					log = new File(dir+"//log."+getCurrentDate()+".txt");
				}
				fw = new OutputStreamWriter(new FileOutputStream(log,true),"UTF-8");
//	            fw = new FileWriter(log,true);
				if(remind.startsWith("record") || remind.startsWith("�ظ�")){
				   fw.write("\n\r");
				   fw.write(getCurrentTime());
				   fw.write("\r");
				}/*else if(remind.startsWith("�ظ�")){
					fw.write("\n\r");
					fw.write(getCurrentTime());
					fw.write("\r");
				}*/
				String s = remind;
				fw.write(s);
				fw.write("\r");
				fw.flush();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		/**
		 * ��ȡ��ǰʱ��ĸ�ʽ���ַ���
		 * @return
		 */
		private  String getCurrentTime() {
			// TODO Auto-generated method stub
//			sdf.format(new Date(System.currentTimeMillis()));
			return sdf.format(new Date(System.currentTimeMillis()));
		}
		
		/**
		 * ��ȡ��ǰ���ڵĸ�ʽ���ַ���
		 * @return
		 */
		private  String getCurrentDate() {
			// TODO Auto-generated method stub
	//		sdf1.format(new Date(System.currentTimeMillis()));
			return sdf1.format(new Date(System.currentTimeMillis()));
		}
		
}
