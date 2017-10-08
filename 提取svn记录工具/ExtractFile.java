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
 * 根据提交的svn记录将对应的class、xml、jsp文件提取出来
 * @author x
 *
 */
public class ExtractFile {
	private static String targetPathStatic = "";
	private static String dir = "D://";//要存储的目标文件夹出错时，日志存储在D盘
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
	 static int sumJava = 0;//class文件总数
	 static int sumJava1 = 0;//class文件数
	 static int sumJava2 = 0;//内部类class文件数
	 static int sumJsp = 0;//jsp文件数
	 static int sumXml = 0;//xml文件数
	 static int sumWeb = 0;//web下其他文件，如json，jpg，css，js等等（与jsp类似）
	 
	 static int sumError = 0;//错误文件数
	 static int sumError1 = 0;//项目目录
	 static int sumError2 = 0;//非项目文件，格式错误
	 static int sumError3 = 0;//非项目文件，非编译的class文件
	 static int sumError4 = 0;//非项目文件，非编译的xml文件
	 static int sumError5 = 0;//非项目文件，非编译的jsp文件
	 static int sumError6 = 0;//非项目文件，非编译的web下文件
	 static Map<Integer,String> map = new LinkedHashMap<Integer,String>();//将更新的文件每行记录放在map中，去重时使用
	 static int row = 0;//更新文件的行数
	 static Map<String,Integer> replace = new LinkedHashMap<String,Integer>();//重复的记录
	/*	public static void main(String[] args) throws Exception {
			String updatedFilePathList = "D://new.txt";
			File updatedFile = new File(updatedFilePathList);
//			String t = "D://222//1新建文件夹111//11";
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
			String targetStr = "C:\\Users\\sudytech\\Desktop\\新建文件夹1";
			String targetDir = targetStr+"\\ROOT\\WEB-INF";*/
			
			
//			System.out.println(11111);
//			System.out.println(s);
//			String cname = s.substring(s.lastIndexOf("/")+1, s.length());//名称+扩展名
//			System.out.println("--  "+cname);
//			/华东师范大学经管云书院二期/trunk/02src/webplus3/webplus3/src/java/com/sudytech/webplus/jgy/action/RankListAction.java
//			String name = "webplus3";
//			s.indexOf(name+"/src/java");
//			System.out.println(s.indexOf("/src1/java"));
//			System.out.println(s.substring(s.indexOf(name+"/src/java"),s.length()));
//			System.out.println(s.substring(s.indexOf(webs), s.length()));
//			System.out.println(s.substring(s.indexOf("classes"), s.lastIndexOf("\\")));
//			s=s.substring("webplus3/src/java".length(),s.lastIndexOf("/"));//目录
//			s=s.substring(s.lastIndexOf("/")+1, s.length()-".java".length());//名称
//			System.out.println(updatedFile.getAbsolutePath());
			
			/*String updatedFilePathList = "F://新建文件夹//new  0.txt";
//			String  srcPath = "D://workspace2//.metadata//.plugins//org.eclipse.wst.server.core//tmp0/wtpwebapps//webplus3";
			String  srcPath = "F://新建文件夹//webplus3//webplus3";
			String targetPath = "F://新建文件夹";
			extractSvnUpdatedFile(updatedFilePathList,srcPath,targetPath);
			String projectName= "webplus3";
			String tt = s.substring(s.lastIndexOf(projectName)+projectName.length()+1, s.lastIndexOf("\\"));
			System.out.println(tt);
		};*/
		
		
		/**
		 * 根据更新的java、xml、jsp文件列表将源文件复制到目标文件夹
		 * @param updatedFilePathList  更新的列表文件
		 * @param srcPath  源文件文件夹
		 * @param targetPath  目标文件夹
		 * @comment
		 *  1、源文件文件夹的名称就是项目名且其下一级就是源文件，格式如下：<br/>
		 * 	 String updatedFilePathList="D:\\new.txt";<br/>
		 *	 String srcPath="D:\\workspace2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webplus3";<br/>
		 *   String targetPath="D:\\test";<br/> 
		 *  2、更新的列表文件从svn日志记录中复制后要做处理，格式如下：<br/>
		 *  webplus3/src/java/com/sudytech/webplus/jgy/schedule/action/ScheduleMgrAction.java<br/>
		 *	webplus3/src/java/config/applicationContext-activity.xml<br/>
		 *	webplus3/web/_web/jgy/manage/updateCardPadge.jsp<br/>
		 *	3、当参数中文件或文件夹不存在时日志文件存储在D盘。
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
					remind = " 更新的文件列表文件不存在！"+"  "+updatedFilePathList;
				} else if(!srcFile.exists() || !srcFile.isDirectory()){
					remind =" 源文件目录不存在(项目编译的路径不正确)！"+"  "+srcPath;
				} else if(!targetFile.exists() || !targetFile.isDirectory()){
					remind = " 要存放的目标文件夹不存在！"+"  "+targetPath;
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
				log("--提取成功文件统计：总数："+sum+"个，其中 class文件总数："+sumJava+"个 (class:"+sumJava1+"个,内部类class："+sumJava2+"个)"+",jsp文件数："+sumJsp+"个,xml文件数："+sumXml+"个,web下文件数："+sumWeb+"个--");
				log("--提取失败文件统计：总数："+sumError+"个，其中 项目目录:"+sumError1+"个；非项目文件:"+sumError2+"个；"+
				   "非编译class文件："+sumError3+"个；非编译xml文件："+sumError4+"个；非编译jsp文件："+sumError5+"个；非编译web下文件："+sumError6+"个--");
				log("--共有"+map.size()+"行,有效路径"+(sum-sumJava2)+"行,无效路径"+sumError+"行--");
				logReplaceFile();
				//项目文件，非编译的class文件
				}
				log("**************************************************************************end****************************************************************************");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return remind;
		}
		
		/**
		 * 输出重复记录的日志
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
				log("--重复路径共"+c+"行，详情如下：");
				for(String st : replace.keySet()){
					int num = replace.get(st);
					log("   "+st+" :"+num+"行");
				}
			}
		}

		/** 
		 * 根据更新文件列表将源文件复制到目标文件夹
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
						log("项目目录:  "+st);
					}else{
						st = handlePrefix(st,projectName);
						if(projectName.equals(st.substring(0, projectName.length()))){//项目名相同
							if(st.contains("/web/WEB-INF/")){
								String recordName = st.endsWith("xml") ? "xml" : "web";
								log("record "+recordName+":"+st);
								String name = st.substring(st.lastIndexOf("/")+1,st.length());
								//String srcStr = "D:\\workspaces\\UCPPlus_v1_1\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webplus3";
								String path = absName+"\\WEB-INF\\"+name;
								File src = new File(path);
//								System.out.println(file.getAbsolutePath());
								//String targetStr = "C:\\Users\\sudytech\\Desktop\\新建文件夹1";
								String targetDir = targetFile.getAbsolutePath()+"\\WEB-INF";
								File target = new File(targetDir);
								handleWebInfFiles(src,target,st);
								
							}else if(st.endsWith("java")){
								log("record class: "+st);
								//webplus3/src/java/com/sudytech/webplus/jgy/collect/IcollectStandrd.java
								String tdir = st.substring((projectName+"/src/java").length(),st.lastIndexOf("/"));//目录
								String cname = st.substring(st.lastIndexOf("/")+1, st.length()-".java".length());//名称
								String dir = absName+"\\WEB-INF\\classes"+tdir;
								File classDir = new File(dir);
								//F:\新建文件夹\webplus3\webplus3\WEB-INF\classes
								//F:\新建文件夹\webplus3\webplus3\com\sudytech\webplus\jgy\card
								handleClassFile(classDir,targetFile,cname);
							}else if(st.endsWith("jsp")){
								log("record jsp: "+st);
								//webplus3/web/_web/activity/manage/activityLabel.jsp
								String tdir = st.substring((projectName+"/web").length(),st.lastIndexOf("/"));//目录
								String cname = st.substring(st.lastIndexOf("/")+1, st.length()-".jsp".length());//名称
								String dir = absName+tdir;
								File jspDir = new File(dir);
								handleJspFile(jspDir,targetFile,cname,projectName);
							}else if(st.endsWith("xml")){
								log("record xml: "+st);
								String tdir = st.substring((projectName+"/src/java").length(),st.lastIndexOf("/"));//目录
								String cname = st.substring(st.lastIndexOf("/")+1, st.length()-".xml".length());//名称
								String dir = absName+"\\WEB-INF\\classes"+tdir;
								File classDir = new File(dir);
								handleXmlFile(classDir,targetFile,cname);
							}else if(st.contains(".")){
								log("record web: "+st);
								String tdir = st.substring((projectName+"/web").length(),st.lastIndexOf("/"));//目录
								String cname = st.substring(st.lastIndexOf("/")+1, st.length());//名称+扩展名
								String dir = absName+tdir;
								File jspDir = new File(dir);
								handleWebFile(jspDir,targetFile,cname,projectName);
							}
						/*	else{
								log("record dir: "+st);
//								sumError1++;
								sumError++;
								log("其他:  "+st);
							}*/
						
						}else{
							log("record format error: "+st);
							sumError2++;
							sumError++;
							log("非项目文件:  "+st);
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
		 * 去重
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
					log("重复:  "+st);
					flag = true;break;
				}
			}
			map.put(row, st); 
			row++;
			return flag;
		}

		/**
		 * 处理前缀
		 * 如 ： /华东师范大学经管云书院二期/trunk/02src/webplus3/webplus3/src/java/com/sudytech/webplus/jgy/action/RankListAction.java
		 * 处理为 webplus3/src/java/com/sudytech/webplus/jgy/action/RankListAction.java
		 * @param st
		 * @param projectName
		 * @return
		 */
		private String handlePrefix(String st, String projectName) {
			// TODO Auto-generated method stub
//			System.out.println(s.substring(s.indexOf(name+"/src/java"),s.length()));
//			System.out.println(s.substring(s.indexOf(name+"/web")+name.length()+1, s.length()));
//			webplus3/web/_web/jgy/manage/cardPadgeManage.jsp
//			/华东师范大学经管云书院二期/trunk/02src/webplus3/webplus3/src/java/com/sudytech/webplus/jgy/action/RankListAction.java
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
		 * 处理WEBINF下文件
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
				log("非项目文件，非编译的web下文件:  "+record);
			}
			
		}
		/**
		 * 处理web下其他文件 如json，jpg，css，js等等
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
				log("非项目文件，非编译的web下文件:  "+cname);
			}
		}
		/**
		 * 处理jsp文件
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
				log("非项目文件，非编译的jsp文件:  "+cname);
			}
		}

		/**
		 * 处理class文件
		 * @param classDir 文件目录
		 * @param targetFile  将要存放的目录
		 * @param cname  文件名
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
				log(cname+" class文件："+n1+"个，内部类class文件："+n2+"个");
			}else{
				sumError3++;
				sumError++;
				log("非项目文件，非编译的class文件:  "+cname);
			}
		}
		
		/**
		 * 处理xml文件
		 * @param classDir 文件目录
		 * @param targetFile  将要存放的目录
		 * @param cname  文件名
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
				log("非项目文件，非编译的xml文件:  "+cname);
			}
		}

		/**
		 * 处理class、xml文件目标路径
		 */
		private  void copyClassFile(String classPath, File targetRoot) {
			// TODO Auto-generated method stub
//			F:\新建文件夹\webplus3\webplus3\WEB-INF\classes\com\sudytech\webplus\jgy\follow\IfollowStandrd.class
//			s.substring(s.indexOf("classes"), s.lastIndexOf("\\")
			try{
				File classFile = new File(classPath);
				if(!classFile.exists()){
					log("copyFile异常："+classPath);
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
		 * 处理jsp及web文件目标路径
		 */
		private  void copyJspFile(String jspPath, File targetRoot,String projectName) {
			// TODO Auto-generated method stub
//			record: webplus3/web/_web/jgy/manage/jgyQueryStudent.jsp
//			src: F:\新建文件夹\webplus3\webplus3\_web\jgy\manage\jgyQueryStudent.jsp
//			target: F:\新建文件夹\ROOT\_web\jgy\manage\jgyQueryStudent.jsp
			try{
				File jspFile = new File(jspPath);
				if(!jspFile.exists()){
					log("copyJspWebFile异常："+jspPath);
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
		 * 复制文件
		 * @param srcFile
		 * @param targetDir
		 */
		private  void copy(File srcFile, File targetDir) {
			// TODO Auto-generated method stub
			try {
				if(!srcFile.exists()){
					log("系统找不到指定的文件:"+srcFile.getAbsolutePath());
					return;
				}else if(!targetDir.exists()){
					log("系统找不到指定的文件:"+targetDir.getAbsolutePath());
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
		 * 初始化日志
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
		 * 输出日志文件
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
				if(remind.startsWith("record") || remind.startsWith("重复")){
				   fw.write("\n\r");
				   fw.write(getCurrentTime());
				   fw.write("\r");
				}/*else if(remind.startsWith("重复")){
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
		 * 获取当前时间的格式化字符串
		 * @return
		 */
		private  String getCurrentTime() {
			// TODO Auto-generated method stub
//			sdf.format(new Date(System.currentTimeMillis()));
			return sdf.format(new Date(System.currentTimeMillis()));
		}
		
		/**
		 * 获取当前日期的格式化字符串
		 * @return
		 */
		private  String getCurrentDate() {
			// TODO Auto-generated method stub
	//		sdf1.format(new Date(System.currentTimeMillis()));
			return sdf1.format(new Date(System.currentTimeMillis()));
		}
		
}
